package interretis.designpatterns.factorymethod.impl.usa;

import interretis.designpatterns.factorymethod.api.Part;
import interretis.designpatterns.factorymethod.api.PartFactory;
import interretis.designpatterns.factorymethod.impl.usa.parts.America;
import interretis.designpatterns.factorymethod.impl.usa.parts.County;
import interretis.designpatterns.factorymethod.impl.usa.parts.State;
import interretis.designpatterns.factorymethod.impl.usa.parts.Town;

public class AmericaFactory implements PartFactory {

    @Override
    public Part makeTopLevelPart()
    {
	return new America();
    }

    @Override
    public Part makePart(Part parent)
    {
	if (parent instanceof America)
	{
	    return new State((America) parent);
	}
	else if (parent instanceof State)
	{
	    return new County((State) parent);
	}

	throw new IllegalArgumentException();
    }

    @Override
    public Part makeBottomLevelPart(Part parent)
    {
	if (parent instanceof County)
	{
	    return new Town((County) parent);
	}

	throw new IllegalArgumentException();
    }
}
