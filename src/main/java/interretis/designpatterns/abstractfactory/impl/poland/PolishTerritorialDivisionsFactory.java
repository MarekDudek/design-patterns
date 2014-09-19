package interretis.designpatterns.abstractfactory.impl.poland;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractTerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.FirstLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;
import interretis.designpatterns.abstractfactory.impl.poland.products.Gmina;
import interretis.designpatterns.abstractfactory.impl.poland.products.Poland;
import interretis.designpatterns.abstractfactory.impl.poland.products.Powiat;
import interretis.designpatterns.abstractfactory.impl.poland.products.Wojewodztwo;

public class PolishTerritorialDivisionsFactory extends AbstractTerritorialDivisionsFactory {

    @Override
    public Country createCountry(String name)
    {
	return new Poland(name);
    }

    @Override
    public Province createProvince(String name, Country country)
    {
	return new Wojewodztwo(name, country);
    }

    @Override
    public County createCounty(String name, FirstLevelDivision division)
    {
	return new Powiat(name, division);
    }

    @Override
    public Commune createCommune(String name, AdministrativeUnit division)
    {
	return new Gmina(name, division);
    }
}
