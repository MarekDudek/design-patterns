package interretis.designpatterns.abstractfactory.abstractimpl;

import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;

import java.util.List;

import com.google.common.collect.Lists;

public abstract class AbstractAdministrativeUnit implements AdministrativeUnit {

    private final AbstractAdministrativeUnit parent;
    private final List<AdministrativeUnit> children;

    public AbstractAdministrativeUnit(final AbstractAdministrativeUnit parent)
    {
	this.parent = parent;
	if (this.parent != null) {
	    this.parent.children.add(this);
	}
	this.children = Lists.newLinkedList();
    }
}
