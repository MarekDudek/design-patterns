package interretis.designpatterns.builder.impl.poland;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

import com.google.common.collect.Lists;

@ToString(of = { "name", "children" })
public class Portion {

    private String name;
    private Portion parent;
    @Getter
    private List<Portion> children;

    public Portion(String name)
    {
	this(name, null);
    }

    public Portion(String name, Portion parent)
    {
	this.name = name;

	this.parent = parent;

	if (this.parent != null)
	{
	    assertChildrenInitialized();
	    this.parent.children.add(this);
	}
    }

    private void assertChildrenInitialized()
    {
	if (parent.children == null)
	{
	    parent.children = Lists.newLinkedList();
	}
    }
}
