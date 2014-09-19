package interretis.designpatterns.builder.impl.america;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interretis.designpatterns.builder.api.Builder;

public class AmericaBuilder implements Builder {

    public static final Pattern STATE_PATTERN = Pattern.compile("^(.*)\t([A-Z]{2})\t\\((state|commonwelth)\\)$");
    public static final Pattern DISTRICT_PATTERN = Pattern.compile("^(.*)\t\\((federal district)\\)$");
    public static final Pattern TERRITORY_PATTERN = Pattern.compile("^(.*)\t\\((territory)\\)$");

    private America america;

    @Override
    public void levelOne(String name)
    {
	america = new America();
    }

    @Override
    public void levelTwo(String line)
    {
	final Matcher stateMatcher = STATE_PATTERN.matcher(line);

	if (stateMatcher.find())
	{
	    final String name = stateMatcher.group(1);
	    final String acronym = stateMatcher.group(2);
	    final String type = stateMatcher.group(3);

	    final State state = new State(name, acronym, type);
	    america.addState(state);

	    return;
	}

	final Matcher districtMatcher = DISTRICT_PATTERN.matcher(line);

	if (districtMatcher.find())
	{
	    final String name = districtMatcher.group(1);

	    final FederalDistrict district = new FederalDistrict(name);
	    america.addDistrict(district);

	    return;
	}

	final Matcher territoryMatcher = TERRITORY_PATTERN.matcher(line);

	if (territoryMatcher.find())
	{
	    final String name = territoryMatcher.group(1);

	    final Territory territory = new Territory(name);
	    america.addTerritory(territory);

	    return;
	}
    }

    @Override
    public void levelThree(String name)
    {
    }

    @Override
    public void levelFour(String name)
    {
    }

    public America getResult()
    {
	return america;
    }
}
