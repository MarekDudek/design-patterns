package interretis.designpatterns.adapter.adapters;

import interretis.designpatterns.adapter.adaptees.Country;
import interretis.designpatterns.adapter.adaptees.Province;
import interretis.designpatterns.adapter.api.Part;
import interretis.designpatterns.util.ConversionUtils;

import java.util.List;

import lombok.EqualsAndHashCode;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.FluentIterable;

@EqualsAndHashCode(of = "country")
public class CountryAdapter implements Part {

    Country country;

    public CountryAdapter(Country country)
    {
	this.country = country;
    }

    @Override
    public String toString()
    {
	return MoreObjects.toStringHelper(this).
		add("name", country.getName()).
		add("provinces", getChildren()).
		toString();
    }

    @Override
    public Part getParent()
    {
	return null;
    }

    @Override
    public List<Part> getChildren()
    {
	final List<Province> provinces = country.getProvinces();
	final Function<Province, ProvinceAdapter> function = new ProvinceAdapter.ProvinceTransformer();
	final List<ProvinceAdapter> adapters = FluentIterable.from(provinces).transform(function).toList();
	return ConversionUtils.genericise(adapters);
    }
}
