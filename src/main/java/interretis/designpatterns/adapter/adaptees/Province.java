package interretis.designpatterns.adapter.adaptees;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.ToString;

@ToString(of = "name")
public class Province {

    @Getter
    String name;
    @Getter
    Country country;
    @Getter
    List<District> districts;

    public Province(String name, Country country)
    {
	this.name = name;

	this.country = country;
	this.country.provinces.add(this);

	this.districts = Lists.newArrayList();
    }
}
