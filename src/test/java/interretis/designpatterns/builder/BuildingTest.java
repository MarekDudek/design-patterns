package interretis.designpatterns.builder;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import interretis.designpatterns.builder.api.Director;
import interretis.designpatterns.builder.impl.PolandBuilder;
import interretis.designpatterns.builder.impl.Portion;
import interretis.designpatterns.builder.input.HierarchicTextDataDirector;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Test;

public class BuildingTest {

    @Test
    public void country_should_be_properly_build() throws Exception
    {
	// given
	final String path = getClass().getResource("poland.txt").getFile();
	final File file = new File(path);

	// when
	final PolandBuilder builder = new PolandBuilder();

	final Director director = new HierarchicTextDataDirector(file, builder, Charset.forName("UTF-8"));
	director.construct();

	final Portion country = (Portion) builder.getResult();

	// then
	assertThat(country, notNullValue());

	final List<Portion> provinces = country.getChildren();
	assertThat(provinces, hasSize(4));
    }
}
