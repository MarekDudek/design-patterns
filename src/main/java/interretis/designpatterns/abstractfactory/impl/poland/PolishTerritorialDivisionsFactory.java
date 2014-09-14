package interretis.designpatterns.abstractfactory.impl.poland;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractTerritorialDivisionsFactory;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.metamodel.FirstLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.metamodel.SecondLevelDivision;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;
import interretis.designpatterns.abstractfactory.impl.poland.products.Gmina;
import interretis.designpatterns.abstractfactory.impl.poland.products.Poland;
import interretis.designpatterns.abstractfactory.impl.poland.products.Powiat;
import interretis.designpatterns.abstractfactory.impl.poland.products.Wojewodztwo;

public class PolishTerritorialDivisionsFactory extends AbstractTerritorialDivisionsFactory {

    @Override
    public Country createCountry()
    {
	return new Poland();
    }

    @Override
    public Province createProvince(Country country)
    {
	return new Wojewodztwo(country);
    }

    @Override
    public County createCounty(FirstLevelDivision division)
    {
	return new Powiat(division);
    }

    @Override
    public Commune createCommune(SecondLevelDivision division) 
    {
	return new Gmina(division);
    }
}
