package interretis.designpatterns.adapter.adaptees;

import lombok.Getter;
import lombok.ToString;

@ToString(of = "name")
public class Commune {

    @Getter
    String name;
    @Getter
    District district;

    public Commune(String name, District district)
    {
	this.name = name;
	this.district = district;
	this.district.communes.add(this);
    }
}
