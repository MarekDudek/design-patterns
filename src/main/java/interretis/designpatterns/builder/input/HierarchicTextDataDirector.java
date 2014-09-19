package interretis.designpatterns.builder.input;

import interretis.designpatterns.builder.api.Builder;
import interretis.designpatterns.builder.api.Director;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HierarchicTextDataDirector implements Director {

    private Builder builder;

    @Override
    public void construct(final List<String> lines)
    {
	for (final String line : lines)
	{
	    final String trimmed = line.trim();

	    final Level level = Level.forLine(line);
	    switch (level)
	    {
	    case FIRST:
		builder.levelOne(trimmed);
		break;

	    case SECOND:
		builder.levelTwo(trimmed);
		break;

	    case THIRD:
		builder.levelThree(trimmed);
		break;

	    case FOURTH:
		builder.levelFour(trimmed);
		break;
	    }
	}
    }

    enum Level {

	FIRST, SECOND, THIRD, FOURTH;

	public static Level forLine(final String line)
	{
	    final int tabsCount = tabsCount(line);
	    return Level.values()[tabsCount];
	}

	private static final Pattern LEADING_TABS = Pattern.compile("^(\t*).*");

	private static int tabsCount(final String line)
	{
	    final Matcher matcher = LEADING_TABS.matcher(line);
	    if (matcher.find())
	    {
		final String tabs = matcher.group(1);
		return tabs.length();
	    }
	    else
	    {
		return 0;
	    }
	}
    }
}
