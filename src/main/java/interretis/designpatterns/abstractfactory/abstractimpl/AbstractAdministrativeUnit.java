package interretis.designpatterns.abstractfactory.abstractimpl;

import interretis.designpatterns.abstractfactory.api.products.metamodel.AdministrativeUnit;

import java.util.List;

import lombok.Getter;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public abstract class AbstractAdministrativeUnit implements AdministrativeUnit {

    @Getter
    private final String name;
    private final AbstractAdministrativeUnit parent;
    private final List<AdministrativeUnit> children;

    public AbstractAdministrativeUnit(final String name, final AbstractAdministrativeUnit parent)
    {
	this.name = Preconditions.checkNotNull(name);
	this.parent = parent;
	if (this.parent != null) {
	    this.parent.children.add(this);
	}
	this.children = Lists.newLinkedList();
    }
}
