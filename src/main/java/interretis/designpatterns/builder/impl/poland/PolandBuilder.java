package interretis.designpatterns.builder.impl.poland;

import static com.google.common.base.Preconditions.checkState;
import interretis.designpatterns.builder.api.Builder;

public class PolandBuilder implements Builder {

    private Portion country;
    private Portion currentProvince;
    private Portion currentDistrict;

    @Override
    public void levelOne(String name)
    {
	checkState(country == null);

	country = new Portion("Polska");
    }

    @Override
    public void levelTwo(String name)
    {
	checkState(country != null);

	currentProvince = new Portion(name, country);

	currentDistrict = null;
    }

    @Override
    public void levelThree(String name)
    {
	checkState(currentProvince != null);

	currentDistrict = new Portion(name, currentProvince);
    }

    @Override
    public void levelFour(String name)
    {
	checkState(currentDistrict != null);

	new Portion(name, currentDistrict);
    }

    public Portion getResult()
    {
	return country;
    }
}
