package interretis.designpatterns.adapter.adapters;

import java.util.List;

import lombok.EqualsAndHashCode;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

import interretis.designpatterns.adapter.adaptees.Commune;
import interretis.designpatterns.adapter.adaptees.District;
import interretis.designpatterns.adapter.api.Part;
import interretis.designpatterns.util.ConversionUtils;

@EqualsAndHashCode(of = "district")
public class DistrictAdaptor implements Part {

    District district;

    public DistrictAdaptor(District district)
    {
	this.district = district;
    }

    @Override
    public String toString() {
	return MoreObjects.toStringHelper(this).
		add("name", district.getName()).
		add("communes", getChildren()).
		toString();
    }

    @Override
    public Part getParent()
    {
	return new ProvinceAdapter(district.getProvince());
    }

    @Override
    public List<Part> getChildren()
    {
	final List<Commune> communes = district.getCommunes();
	final Function<Commune, CommuneAdapter> transformer = new CommuneAdapter.CommuneTransformer();
	final ImmutableList<CommuneAdapter> adapters = FluentIterable.from(communes).transform(transformer).toList();
	return ConversionUtils.genericise(adapters);
    }

    static class DistrictTransformer implements Function<District, DistrictAdaptor> {

	@Override
	public DistrictAdaptor apply(final District district)
	{
	    return new DistrictAdaptor(district);
	}
    }
}
