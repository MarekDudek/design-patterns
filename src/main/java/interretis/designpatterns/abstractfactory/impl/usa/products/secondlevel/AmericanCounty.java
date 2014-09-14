package interretis.designpatterns.abstractfactory.impl.usa.products.secondlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;

public class AmericanCounty extends AbstractAdministrativeUnit implements County {

    public AmericanCounty(String name, AdministrativeUnit parent)
    {
	super(name, (AbstractAdministrativeUnit) parent);
    }
}
