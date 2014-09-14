package interretis.designpatterns.abstractfactory.impl.usa;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractTerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.FirstLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.District;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Town;
import interretis.designpatterns.abstractfactory.impl.usa.products.America;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.AmericanFederalDistrict;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.IndianReservation;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.InsularArea;
import interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel.StateOrCommonwelth;
import interretis.designpatterns.abstractfactory.impl.usa.products.secondlevel.AmericanCounty;
import interretis.designpatterns.abstractfactory.impl.usa.products.secondlevel.InsularTerritoryDistrict;
import interretis.designpatterns.abstractfactory.impl.usa.products.thirdlevel.AmericanCity;

public class AmericanTerritorialDivisionsFactory extends AbstractTerritorialDivisionsFactory {

    @Override
    public Country createCountry(String name)
    {
	return new America(name);
    }

    @Override
    public State createState(String name, Country country)
    {
	return new StateOrCommonwelth(name, country);
    }

    @Override
    public FederalDistrict createFederalDistrict(String name, Country country)
    {
	return new AmericanFederalDistrict(name, country);
    }

    @Override
    public DependentTerritory createDependentTerritory(String name, Country country)
    {
	return new InsularArea(name, country);
    }

    @Override
    public Reservation createReservation(String name, Country country)
    {
	return new IndianReservation(name, country);
    }

    @Override
    public County createCounty(String name, FirstLevelDivision division)
    {
	return new AmericanCounty(name, division);
    }

    @Override
    public Town createTown(String name, AdministrativeUnit parent) 
    {
	return new AmericanCity(name, parent);
    }

    @Override
    public District createDistrict(String name, AdministrativeUnit parent) 
    {
	return new InsularTerritoryDistrict(name, parent);
    }
}
