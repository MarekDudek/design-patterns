package interretis.designpatterns.abstractfactory.impl.usa.products.thirdlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Town;

public class AmericanCity extends AbstractAdministrativeUnit implements Town {

    public AmericanCity(String name, AdministrativeUnit parent)
    {
	super(name, (AbstractAdministrativeUnit) parent);
    }
}
