package interretis.designpatterns.abstractfactory.impl.usa;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractTerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.metamodel.FirstLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.impl.usa.products.America;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.AmericanCounty;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.AmericanFederalDistrict;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.IndianReservation;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.InsularArea;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.StateOrCommonwelth;

public class AmericanTerritorialDivisionsFactory extends AbstractTerritorialDivisionsFactory {

    @Override
    public Country createCountry()
    {
	return new America();
    }

    @Override
    public State createState(Country country)
    {
	return new StateOrCommonwelth(country);
    }

    @Override
    public FederalDistrict createFederalDistrict(Country country)
    {
	return new AmericanFederalDistrict(country);
    }

    @Override
    public DependentTerritory createDependentTerritory(Country country)
    {
	return new InsularArea(country);
    }

    @Override
    public Reservation createReservation(Country country)
    {
	return new IndianReservation(country);
    }

    @Override
    public County createCounty(FirstLevelDivision division)
    {
	return new AmericanCounty(division);
    }
}
