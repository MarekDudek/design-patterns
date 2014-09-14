package interretis.designpatterns.abstractfactory;

import interretis.designpatterns.abstractfactory.api.TerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;
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
	final Country poland = polishFactory.createCountry();

	final Province mazowieckie = polishFactory.createProvince(poland);
	final County ostroleka = polishFactory.createCounty(mazowieckie);
	final Commune goworowo = polishFactory.createCommune(ostroleka);

	final Province dolnoslaskie = polishFactory.createProvince(poland);
	final County boleslawiecki = polishFactory.createCounty(dolnoslaskie);
	final Commune osiecznica = polishFactory.createCommune(boleslawiecki);

	final Province lubuskie = polishFactory.createProvince(poland);
	final County nowosolski = polishFactory.createCounty(lubuskie);
	final Commune kolsko = polishFactory.createCommune(nowosolski);
    }

    @Test
    public void build_america()
    {
	final Country america = americanFactory.createCountry();

	final FederalDistrict districtOfColumbia = americanFactory.createFederalDistrict(america);

	final State arizona = americanFactory.createState(america);
	final County santaCruzCounty = americanFactory.createCounty(arizona);

	final State california = americanFactory.createState(america);
	final County orangeCounty = americanFactory.createCounty(california);

	final State florida = americanFactory.createState(america);
	final County palmBeachCounty = americanFactory.createCounty(florida);

	final DependentTerritory virginIslands = americanFactory.createDependentTerritory(america);
	final DependentTerritory samoa = americanFactory.createDependentTerritory(america);

	final Reservation navahoNation = americanFactory.createReservation(america);
	final Reservation pineRidgeReservation = americanFactory.createReservation(america);
    }
}
