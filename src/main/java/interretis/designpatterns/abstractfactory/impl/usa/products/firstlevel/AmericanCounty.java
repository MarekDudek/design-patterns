package interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;

public class AmericanCounty extends AbstractAdministrativeUnit implements County {

    public AmericanCounty(AdministrativeUnit parent)
    {
	super((AbstractAdministrativeUnit) parent);
    }
}
