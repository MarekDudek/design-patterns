package interretis.designpatterns.adapter.adapters;

import java.util.List;

import lombok.EqualsAndHashCode;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

import interretis.designpatterns.adapter.adaptees.District;
import interretis.designpatterns.adapter.adaptees.Province;
import interretis.designpatterns.adapter.api.Part;
import interretis.designpatterns.util.ConversionUtils;

@EqualsAndHashCode(of = "province")
public class ProvinceAdapter implements Part {

    Province province;

    public ProvinceAdapter(Province province)
    {
	this.province = province;
    }

    @Override
    public String toString()
    {
	return MoreObjects.toStringHelper(this).
		add("name", province.getName()).
		add("districts", getChildren()).
		toString();
    }

    @Override
    public Part getParent()
    {
	return new CountryAdapter(province.getCountry());
    }

    @Override
    public List<Part> getChildren()
    {
	final List<District> districts = province.getDistricts();
	final Function<District, DistrictAdaptor> transformer = new DistrictAdaptor.DistrictTransformer();
	final ImmutableList<DistrictAdaptor> adapters = FluentIterable.from(districts).transform(transformer).toList();
	return ConversionUtils.genericise(adapters);
    }

    static class ProvinceTransformer implements Function<Province, ProvinceAdapter> {

	@Override
	public ProvinceAdapter apply(final Province province)
	{
	    return new ProvinceAdapter(province);
	}
    }
}
