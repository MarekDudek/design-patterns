package interretis.designpatterns.adapter.adaptees;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

import com.google.common.collect.Lists;

@ToString(of = "name")
public class Country {

    @Getter
    String name;
    @Getter
    List<Province> provinces;

    public Country(String name)
    {
	this.name = name;
	this.provinces = Lists.newArrayList();
    }
}
