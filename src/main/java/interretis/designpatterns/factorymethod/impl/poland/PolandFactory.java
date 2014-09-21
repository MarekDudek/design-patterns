package interretis.designpatterns.factorymethod.impl.poland;

import interretis.designpatterns.factorymethod.api.Part;
import interretis.designpatterns.factorymethod.api.PartFactory;
import interretis.designpatterns.factorymethod.impl.poland.parts.Commune;
import interretis.designpatterns.factorymethod.impl.poland.parts.District;
import interretis.designpatterns.factorymethod.impl.poland.parts.Poland;
import interretis.designpatterns.factorymethod.impl.poland.parts.Province;

public class PolandFactory implements PartFactory {

    @Override
    public Part makeTopLevelPart()
    {
	return new Poland();
    }

    @Override
    public Part makePart(final Part parent)
    {
	if (parent instanceof Poland)
	{
	    return new Province((Poland) parent);
	}
	else if (parent instanceof Province)
	{
	    return new District((Province) parent);
	}
	
	throw new IllegalArgumentException();
    }

    @Override
    public Part makeBottomLevelPart(Part parent)
    {
	if (parent instanceof District)
	{
	    return new Commune((District) parent);
	}
	
	throw new IllegalArgumentException();
    }
}
