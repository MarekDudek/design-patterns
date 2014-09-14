package interretis.designpatterns.abstractfactory.impl.poland.products;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Province;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;

public class Wojewodztwo extends AbstractAdministrativeUnit implements Province {

    public Wojewodztwo(String name, AdministrativeUnit parent)
    {
	super(name, (AbstractAdministrativeUnit) parent);
    }
}
