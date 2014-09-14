package interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.DependentTerritory;

public class InsularArea extends AbstractAdministrativeUnit implements  DependentTerritory{

    public InsularArea(String name, Country country) 
    {
	super(name, (AbstractAdministrativeUnit)country);
    }
}
