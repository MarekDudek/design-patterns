package interretis.designpatterns.abstractfactory.api;

import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.FirstLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.District;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Town;

public interface TerritorialDivisionsFactory {

    Country createCountry(String name);

    State createState(String name, Country country);

    Province createProvince(String name, Country country);
    
    FederalDistrict createFederalDistrict(String name, Country country);
    
    DependentTerritory createDependentTerritory(String name, Country country);
    
    Reservation createReservation(String name, Country country);
    
    County createCounty(String name, FirstLevelDivision parent);
   
    District createDistrict(String name, AdministrativeUnit parent);
    
    Commune createCommune(String name, AdministrativeUnit parent);
    
    Town createTown(String name, AdministrativeUnit parent);
}
