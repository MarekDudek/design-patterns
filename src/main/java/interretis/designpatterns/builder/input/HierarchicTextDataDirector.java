package interretis.designpatterns.builder.input;

import interretis.designpatterns.builder.api.Builder;
import interretis.designpatterns.builder.api.Director;

import java.util.List;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HierarchicTextDataDirector implements Director {

    private Builder builder;

    enum Level {

	FIRST, SECOND, THIRD, FOURTH;

	public static Level forLine(final String line)
	{
	    int occurences = StringUtils.countOccurrencesOf(line, "\t");
	    return Level.values()[occurences];
	}
    }

    @Override
    public void construct(final List<String> lines)
    {
	for (final String line : lines)
	{
	    final Level level = Level.forLine(line);

	    final String trimmed = line.trim();

	    switch (level) {
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
}
