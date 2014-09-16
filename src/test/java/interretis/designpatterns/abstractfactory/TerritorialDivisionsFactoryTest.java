package interretis.designpatterns.abstractfactory;

import interretis.designpatterns.abstractfactory.api.TerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.impl.poland.PolishTerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.impl.usa.AmericanTerritorialDivisionsFactory;

import org.junit.Before;
import org.junit.Test;

public class TerritorialDivisionsFactoryTest {

    private TerritorialDivisionsFactory polishFactory;
    private TerritorialDivisionsFactory americanFactory;

    @Before
    public void setup()
    {
	polishFactory = new PolishTerritorialDivisionsFactory();
	americanFactory = new AmericanTerritorialDivisionsFactory();
    }

    @Test
    public void build_poland()
    {
	final Country poland = polishFactory.createCountry("Polska");

	final Province mazowieckie = polishFactory.createProvince("mazowieckie", poland);
	final County ostroleka = polishFactory.createCounty("Ostrołęka", mazowieckie);
	polishFactory.createCommune("Goworowo", ostroleka);

	final Province dolnoslaskie = polishFactory.createProvince("dolnośląskie", poland);
	final County boleslawiecki = polishFactory.createCounty("bolesławiecki", dolnoslaskie);
	polishFactory.createCommune("Osiecznica", boleslawiecki);

	final Province lubuskie = polishFactory.createProvince("lubuskie", poland);
	final County nowosolski = polishFactory.createCounty("nowosolski", lubuskie);
	polishFactory.createCommune("Kolsko", nowosolski);
    }

    @Test
    public void build_america()
    {
	final Country america = americanFactory.createCountry("United States of America");

	final FederalDistrict federalDistrict = americanFactory.createFederalDistrict("District of Columbia", america);
	americanFactory.createTown("Washington", federalDistrict);

	final State arizona = americanFactory.createState("Arizona", america);
	final County santaCruzCounty = americanFactory.createCounty("Santa Cruz", arizona);
	americanFactory.createTown("Santa Cruz", santaCruzCounty);

	final State california = americanFactory.createState("California", america);
	final County orangeCounty = americanFactory.createCounty("Orange County", california);
	americanFactory.createTown("San Francisco", orangeCounty);

	final State florida = americanFactory.createState("Florida", america);
	final County palmBeachCounty = americanFactory.createCounty("Palm Beach", florida);
	americanFactory.createTown("Miami", palmBeachCounty);

	final DependentTerritory virginIslands = americanFactory.createDependentTerritory("Virgin Islands", america);
	americanFactory.createDistrict("St. Thomas", virginIslands);
	americanFactory.createDistrict("St. John", virginIslands);
	americanFactory.createDistrict("St. Croix", virginIslands);

	final DependentTerritory samoa = americanFactory.createDependentTerritory("Samoa", america);
	americanFactory.createDistrict("Western District", samoa);
	americanFactory.createDistrict("Eastern District", samoa);
	americanFactory.createDistrict("Manu'a District", samoa);

	americanFactory.createReservation("Navaho Nation", america);
	americanFactory.createReservation("Pine Ridge Reservation", america);
    }
}
