package interretis.designpatterns.abstractfactory.abstractimpl;

import interretis.designpatterns.abstractfactory.api.TerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.District;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Town;

public abstract class AbstractTerritorialDivisionsFactory implements TerritorialDivisionsFactory {

    @Override
    public State createState(String name, Country country)
    {
	throw new IllegalStateException("This country does not have states");
    }

    @Override
    public Province createProvince(String name, Country country)
    {
	throw new IllegalStateException("This country does not have provinces");
    }

    @Override
    public FederalDistrict createFederalDistrict(String name, Country country)
    {
	throw new IllegalStateException("This country does not have federal districts");
    }

    @Override
    public DependentTerritory createDependentTerritory(String name, Country country)
    {
	throw new IllegalStateException("This country does not have dependent territories");
    }

    @Override
    public Reservation createReservation(String name, Country country)
    {
	throw new IllegalStateException("This country does not have reservations");
    }

    @Override
    public Commune createCommune(String name, AdministrativeUnit division) 
    {
	throw new IllegalStateException("This country does not have communes");
    }

    @Override
    public Town createTown(String name, AdministrativeUnit parent) 
    {
	throw new IllegalStateException("This country does not have towns");
    }

    @Override
    public District createDistrict(String name, AdministrativeUnit parent) 
    {
	throw new IllegalStateException("This country does not have districts");

    }
}
