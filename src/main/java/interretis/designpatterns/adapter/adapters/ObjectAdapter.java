package interretis.designpatterns.adapter.adapters;

import interretis.designpatterns.adapter.adaptees.Commune;
import interretis.designpatterns.adapter.adaptees.Country;
import interretis.designpatterns.adapter.adaptees.District;
import interretis.designpatterns.adapter.adaptees.Province;
import interretis.designpatterns.adapter.api.Part;
import interretis.designpatterns.util.ConversionUtils;

import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

@EqualsAndHashCode(of = "adaptee")
public class ObjectAdapter implements Part {

    private Object adaptee;

    public ObjectAdapter(Object adaptee) {
	this.adaptee = adaptee;
    }

    @Override
    public Part getParent() {

	final Class<?> klass = adaptee.getClass();

	if (klass == Country.class)
	{
	    return null;
	}
	if (klass == Province.class)
	{
	    final Province province = (Province) adaptee;
	    final Country country = province.getCountry();
	    return new ObjectAdapter(country);
	}
	if (klass == District.class)
	{
	    final District district = (District) adaptee;
	    final Province province = district.getProvince();
	    return new ObjectAdapter(province);
	}
	if (klass == Commune.class)
	{
	    final Commune commune = (Commune) adaptee;
	    final District district = commune.getDistrict();
	    return new ObjectAdapter(district);
	}

	throw new IllegalStateException(adaptee.getClass().getCanonicalName());
    }

    @Override
    public List<Part> getChildren()
    {
	final Class<?> klass = adaptee.getClass();

	if (klass == Country.class)
	{
	    final Country country = (Country) adaptee;
	    final List<Province> provinces = country.getProvinces();
	    final ImmutableList<Part> adapters = FluentIterable.from(provinces).transform(OBJECT_TO_ADAPTER).toList();
	    return ConversionUtils.genericise(adapters);
	}
	if (klass == Province.class)
	{
	    final Province province = (Province) adaptee;
	    final List<District> districts = province.getDistricts();
	    final ImmutableList<Part> adapters = FluentIterable.from(districts).transform(OBJECT_TO_ADAPTER).toList();
	    return ConversionUtils.genericise(adapters);
	}
	if (klass == District.class)
	{
	    final District district = (District) adaptee;
	    final List<Commune> communes = district.getCommunes();
	    final ImmutableList<Part> adapters = FluentIterable.from(communes).transform(OBJECT_TO_ADAPTER).toList();
	    return ConversionUtils.genericise(adapters);
	}
	if (klass == Commune.class)
	{
	    return Collections.emptyList();
	}

	throw new IllegalStateException(adaptee.getClass().getCanonicalName());
    }

    private static final ObjectToAdapter OBJECT_TO_ADAPTER = new ObjectToAdapter();

    private static class ObjectToAdapter implements Function<Object, Part> {

	@Override
	public ObjectAdapter apply(final Object object)
	{
	    return new ObjectAdapter(object);
	}

    }
}
