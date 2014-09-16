package interretis.designpatterns.abstractfactory.impl.poland.products;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.Country;

public class Poland extends AbstractAdministrativeUnit implements Country {

    public Poland(String name) 
    {
	super(name, null);
    }
}
