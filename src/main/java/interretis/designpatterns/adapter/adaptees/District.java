package interretis.designpatterns.adapter.adaptees;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

import com.google.common.collect.Lists;

@ToString(of = "name")
public class District {

    @Getter
    String name;
    @Getter
    Province province;
    @Getter
    List<Commune> communes;

    public District(String name, Province province)
    {
	this.name = name;

	this.province = province;
	this.province.districts.add(this);

	this.communes = Lists.newArrayList();
    }
}
