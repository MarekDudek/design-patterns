package interretis.designpatterns.builder.impl.america;

import java.util.List;

import lombok.Getter;

import com.google.common.collect.Lists;

public class America {

    @Getter
    List<State> states = Lists.newArrayList();
    @Getter
    List<FederalDistrict> districts = Lists.newArrayList();
    @Getter
    List<Territory> territories = Lists.newArrayList();

    public void addState(State state)
    {
	states.add(state);
    }

    public void addDistrict(FederalDistrict district)
    {
	districts.add(district);
    }

    public void addTerritory(Territory territory)
    {
	territories.add(territory);
    }
}
