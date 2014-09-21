package interretis.designpatterns.factorymethod;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import interretis.designpatterns.factorymethod.api.Part;
import interretis.designpatterns.factorymethod.api.PartFactory;
import interretis.designpatterns.factorymethod.impl.poland.PolandFactory;
import interretis.designpatterns.factorymethod.impl.usa.AmericaFactory;

import org.junit.Before;
import org.junit.Test;

public class FactoryMethodTest {

    private PartFactory polandFactory;
    private PartFactory americaFactory;

    @Before
    public void setup()
    {
	polandFactory = new PolandFactory();
	americaFactory = new AmericaFactory();
    }

    @Test
    public void manufacture_america()
    {
	final Part america = americaFactory.makeTopLevelPart();
	final Part california = americaFactory.makePart(america);
	final Part orangeCounty = americaFactory.makePart(california);
	final Part santaAna = americaFactory.makeBottomLevelPart(orangeCounty);
	
	assertThat(santaAna.getParent(), is(orangeCounty));
	assertThat(orangeCounty.getParent(), is(california));
	assertThat(california.getParent(), is(america));
    }

    @Test
    public void manufacture_poland()
    {
	final Part poland = polandFactory.makeTopLevelPart();
	final Part dolnoslaskieProvince = polandFactory.makePart(poland);
	final Part boleslawieckiDistrict = polandFactory.makePart(dolnoslaskieProvince);
	final Part boleslawiecCommune = polandFactory.makeBottomLevelPart(boleslawieckiDistrict);

	assertThat(boleslawiecCommune.getParent(), is(boleslawieckiDistrict));
	assertThat(boleslawieckiDistrict.getParent(), is(dolnoslaskieProvince));
	assertThat(dolnoslaskieProvince.getParent(), is(poland));
    }
}
