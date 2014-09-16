package interretis.designpatterns.abstractfactory.impl.poland.products;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.County;

public class Powiat extends AbstractAdministrativeUnit implements County {

    public Powiat(String name, AdministrativeUnit parent) 
    {
	super(name, (AbstractAdministrativeUnit) parent);
    }
}
