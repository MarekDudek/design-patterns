package interretis.designpatterns.abstractfactory.impl.usa.products;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.Country;

public class America extends AbstractAdministrativeUnit implements Country {

    public America() 
    {
	super(null);
    }
}
