package interretis.designpatterns.adapter;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import interretis.designpatterns.adapter.adaptees.Commune;
import interretis.designpatterns.adapter.adaptees.Country;
import interretis.designpatterns.adapter.adaptees.District;
import interretis.designpatterns.adapter.adaptees.Province;
import interretis.designpatterns.adapter.adapters.CountryAdapter;
import interretis.designpatterns.adapter.adapters.ObjectAdapter;
import interretis.designpatterns.adapter.api.Part;

import org.junit.Before;
import org.junit.Test;

public class AdapterTest {

    Country country;
    Province province;
    District district;
    Commune commune;

    @Before
    public void setup()
    {
	// given
	country = new Country("Poland");
	province = new Province("dolnośląskie", country);
	district = new District("bolesławiecki", province);
	commune = new Commune("Bolesławiec", district);
    }

    @Test
    public void class_adapter()
    {
	// when
	final Part countryAdapter = new CountryAdapter(country);

	// then
	final Part provinceAdapter = countryAdapter.getChildren().iterator().next();
	assertThat(provinceAdapter.getParent(), is(countryAdapter));

	final Part districtAdapter = provinceAdapter.getChildren().iterator().next();
	assertThat(districtAdapter.getParent(), is(provinceAdapter));

	final Part communeAdapter = districtAdapter.getChildren().iterator().next();
	assertThat(communeAdapter.getParent(), is(districtAdapter));

	assertThat(communeAdapter.getChildren(), empty());
    }

    @Test
    public void object_adapter()
    {
	// when
	final Part countryAdapter = new ObjectAdapter(country);

	// then
	final Part provinceAdapter = countryAdapter.getChildren().iterator().next();
	assertThat(provinceAdapter.getParent(), is(countryAdapter));

	final Part districtAdapter = provinceAdapter.getChildren().iterator().next();
	assertThat(districtAdapter.getParent(), is(provinceAdapter));

	final Part communeAdapter = districtAdapter.getChildren().iterator().next();
	assertThat(communeAdapter.getParent(), is(districtAdapter));

	assertThat(communeAdapter.getChildren(), empty());
    }
}
