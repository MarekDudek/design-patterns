package interretis.designpatterns.adapter.adapters;

import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import interretis.designpatterns.adapter.adaptees.Commune;
import interretis.designpatterns.adapter.api.Part;

@EqualsAndHashCode(of = "commune")
public class CommuneAdapter implements Part {

    Commune commune;

    public CommuneAdapter(Commune commune)
    {
	this.commune = commune;
    }

    @Override
    public String toString()
    {
	return MoreObjects.toStringHelper(this).
		add("name", commune.getName()).
		toString();
    }

    @Override
    public Part getParent()
    {
	return new DistrictAdaptor(commune.getDistrict());
    }

    @Override
    public List<Part> getChildren()
    {
	return Collections.emptyList();
    }

    static class CommuneTransformer implements Function<Commune, CommuneAdapter> {
	@Override
	public CommuneAdapter apply(final Commune commune)
	{
	    return new CommuneAdapter(commune);
	}
    }
}
