package interretis.designpatterns.abstractfactory.abstractimpl;

import interretis.designpatterns.abstractfactory.api.TerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.metamodel.SecondLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;

public abstract class AbstractTerritorialDivisionsFactory implements TerritorialDivisionsFactory {

    @Override
    public State createState(Country country)
    {
	throw new IllegalStateException("This country does not have states");
    }

    @Override
    public Province createProvince(Country country)
    {
	throw new IllegalStateException("This country does not have provinces");
    }

    @Override
    public FederalDistrict createFederalDistrict(Country country)
    {
	throw new IllegalStateException("This country does not have federal districts");
    }

    @Override
    public DependentTerritory createDependentTerritory(Country country)
    {
	throw new IllegalStateException("This country does not have dependent territories");
    }

    @Override
    public Reservation createReservation(Country country)
    {
	throw new IllegalStateException("This country does not have reservations");
    }

    @Override
    public Commune createCommune(SecondLevelDivision division) 
    {
	throw new IllegalStateException("This country does not have communes");
    }
}
