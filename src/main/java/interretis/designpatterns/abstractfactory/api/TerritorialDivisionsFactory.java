package interretis.designpatterns.abstractfactory.api;

import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.metamodel.FirstLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.metamodel.SecondLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;

public interface TerritorialDivisionsFactory {

    Country createCountry();

    State createState(Country country);

    Province createProvince(Country country);
    
    FederalDistrict createFederalDistrict(Country country);
    
    DependentTerritory createDependentTerritory(Country country);
    
    Reservation createReservation(Country country);
    
    County createCounty(FirstLevelDivision division);
    
    Commune createCommune(SecondLevelDivision division);
}
