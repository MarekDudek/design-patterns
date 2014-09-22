package interretis.designpatterns.adapter;

import static org.junit.Assert.*;
import interretis.designpatterns.adapter.adaptees.Commune;
import interretis.designpatterns.adapter.adaptees.Country;
import interretis.designpatterns.adapter.adaptees.District;
import interretis.designpatterns.adapter.adaptees.Province;
import interretis.designpatterns.adapter.adapters.CountryAdapter;
import interretis.designpatterns.adapter.api.Part;

import org.junit.Test;

public class AdapterTest {

    @Test
    public void test()
    {
	// given
	final Country country = new Country("Poland");
	final Province province = new Province("dolnośląskie", country);
	final District district = new District("bolesławiecki", province);
	new Commune("Bolesławiec", district);

	// when
	final Part countryAdapter = new CountryAdapter(country);

	// then
	final Part provinceAdapter = countryAdapter.getChildren().iterator().next();
	assertEquals(provinceAdapter.getParent(), countryAdapter);

	final Part districtAdapter = provinceAdapter.getChildren().iterator().next();
	assertEquals(districtAdapter.getParent(), provinceAdapter);

	final Part communeAdapter = districtAdapter.getChildren().iterator().next();
	assertEquals(communeAdapter.getParent(), districtAdapter);
    }
}
