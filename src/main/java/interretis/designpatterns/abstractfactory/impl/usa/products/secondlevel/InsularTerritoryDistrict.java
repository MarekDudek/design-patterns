package interretis.designpatterns.abstractfactory.impl.usa.products.secondlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.secondlevel.District;

public class InsularTerritoryDistrict extends AbstractAdministrativeUnit implements District {

    public InsularTerritoryDistrict(String name, AdministrativeUnit parent)
    {
	super(name, (AbstractAdministrativeUnit) parent);
    }
}
