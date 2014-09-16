package interretis.designpatterns.builder.impl;

import interretis.designpatterns.builder.api.Builder;

public class PolandBuilder implements Builder {

    private final Portion country = new Portion("Polska");

    private Portion currentProvince;
    private Portion currentDistrict;

    @Override
    public void levelOne(String name)
    {
	currentProvince = new Portion(name, country);
    }

    @Override
    public void levelTwo(String name)
    {
	currentDistrict = new Portion(name, currentProvince);
    }

    @Override
    public void levelThree(String name)
    {
	new Portion(name, currentDistrict);
    }

    public Object getResult() {
	return country;
    }
}
