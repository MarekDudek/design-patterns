package interretis.designpatterns.builder;

import static java.util.regex.Pattern.matches;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import interretis.designpatterns.builder.api.Director;
import interretis.designpatterns.builder.impl.america.America;
import interretis.designpatterns.builder.impl.america.AmericaBuilder;
import interretis.designpatterns.builder.impl.poland.PolandBuilder;
import interretis.designpatterns.builder.impl.poland.Portion;
import interretis.designpatterns.builder.input.HierarchicTextDataDirector;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;

import org.junit.Test;

import com.google.common.io.Files;

public class BuilderTest {

    @Test
    public void poland_should_be_properly_build() throws Exception
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
	final Portion country = builder.getResult();

	assertThat(country, notNullValue());

	final List<Portion> provinces = country.getChildren();
	assertThat(provinces, hasSize(4));
    }

    @Test
    public void america_should_be_properly_built() throws IOException
    {
	// given
	final String path = getClass().getResource("usa.txt").getFile();
	final File file = new File(path);
	final List<String> lines = Files.readLines(file, Charset.forName("UTF-8"));

	// when
	final AmericaBuilder builder = new AmericaBuilder();
	final Director director = new HierarchicTextDataDirector(builder);
	director.construct(lines);

	// then
	final America america = builder.getResult();

	assertThat(america.getStates(), hasSize(5));
	assertThat(america.getDistricts(), hasSize(1));
	assertThat(america.getTerritories(), hasSize(3));
    }

    @Test
    public void parsing_state_works()
    {
	final String statePattern = "^(.*)\t([A-Z]{2})\t\\((.*)\\)$";

	assertThat(matches(statePattern, "Florida	FL	(state)"), is(true));

	final Matcher matcher = AmericaBuilder.STATE_PATTERN.matcher("Florida	FL	(state)");
	assertThat(matcher.find(), is(true));

	final String name = matcher.group(1);
	final String acronym = matcher.group(2);
	final String type = matcher.group(3);

	assertThat(name, notNullValue());
	assertThat(acronym, notNullValue());
	assertThat(type, notNullValue());
    }
}
