package interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.State;

public class StateOrCommonwelth extends AbstractAdministrativeUnit implements State {

    public StateOrCommonwelth(String name, Country country)
    {
	super(name, (AbstractAdministrativeUnit) country);
    }
}
