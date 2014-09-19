package interretis.designpatterns.abstractfactory.impl.poland.products;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.thirdlevel.Commune;

public class Gmina extends AbstractAdministrativeUnit implements Commune {

    public Gmina(String name, AdministrativeUnit division)
    {
	super(name, (AbstractAdministrativeUnit) division);
    }
}
