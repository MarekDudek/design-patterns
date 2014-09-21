package interretis.designpatterns.prototype;

import static interretis.designpatterns.prototype.impl.AdministrativeUnitType.COUNTRY;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import interretis.designpatterns.prototype.api.Prototype;
import interretis.designpatterns.prototype.api.PrototypeRegistry;
import interretis.designpatterns.prototype.impl.AdministrativeUnit;
import interretis.designpatterns.prototype.impl.AdministrativeUnitRegistry;
import interretis.designpatterns.prototype.impl.AdministrativeUnitType;

import org.junit.Before;
import org.junit.Test;

public class PrototypeTest {

    private PrototypeRegistry registry;

    @Before
    public void setup()
    {
	registry = new AdministrativeUnitRegistry();
    }

    @Test
    public void instance_is_different_every_time()
    {
	// when
	final AdministrativeUnit country = (AdministrativeUnit) registry.getPrototype(COUNTRY);

	// then
	assertThat(country, notNullValue());

	// when
	final AdministrativeUnit second = (AdministrativeUnit) registry.getPrototype(COUNTRY);

	// then
	assertThat(country, not(sameInstance(second)));
    }

    @Test
    public void all_types_can_be_created()
    {
	// when
	final Prototype country = registry.getPrototype(AdministrativeUnitType.COUNTRY);
	final Prototype province = registry.getPrototype(AdministrativeUnitType.PROVINCE);
	final Prototype district = registry.getPrototype(AdministrativeUnitType.DISTRICT);
	final Prototype commune = registry.getPrototype(AdministrativeUnitType.COMMUNE);
	
	// then
	
	assertThat(country, notNullValue());
	assertThat(province, notNullValue());
	assertThat(district, notNullValue());
	assertThat(commune, notNullValue());
    }
}
