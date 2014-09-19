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

import com.google.common.io.Files;

public class BuilderTest {

    @Test
    public void country_should_be_properly_build() throws Exception
    {
	// given
	final String path = getClass().getResource("poland.txt").getFile();
	final File file = new File(path);
	final List<String> lines = Files.readLines(file, Charset.forName("UTF-8"));

	// when
	final PolandBuilder builder = new PolandBuilder();
	final Director director = new HierarchicTextDataDirector(builder);
	director.construct(lines);

	// then
	final Portion country = (Portion) builder.getResult();

	assertThat(country, notNullValue());

	final List<Portion> provinces = country.getChildren();
	assertThat(provinces, hasSize(4));
    }
}
