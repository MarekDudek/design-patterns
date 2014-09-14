package interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.FederalDistrict;

public class AmericanFederalDistrict extends AbstractAdministrativeUnit implements FederalDistrict {

    public AmericanFederalDistrict(String name, Country country) 
    {
	super(name, (AbstractAdministrativeUnit) country);
    }
}
