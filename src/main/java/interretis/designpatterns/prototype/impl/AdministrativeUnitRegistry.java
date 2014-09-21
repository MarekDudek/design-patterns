package interretis.designpatterns.prototype.impl;

import static interretis.designpatterns.prototype.impl.AdministrativeUnitType.COMMUNE;
import static interretis.designpatterns.prototype.impl.AdministrativeUnitType.COUNTRY;
import static interretis.designpatterns.prototype.impl.AdministrativeUnitType.DISTRICT;
import static interretis.designpatterns.prototype.impl.AdministrativeUnitType.PROVINCE;
import interretis.designpatterns.prototype.api.PrototypeRegistry;
import interretis.designpatterns.prototype.api.PrototypeType;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class AdministrativeUnitRegistry implements PrototypeRegistry {

    private final Map<AdministrativeUnitType, AdministrativeUnit> prototypes =

	    ImmutableMap.<AdministrativeUnitType, AdministrativeUnit> builder().
		    put(COUNTRY,
			    new AdministrativeUnit(COUNTRY)
		    ).
		    put(PROVINCE,
			    new AdministrativeUnit(PROVINCE)
		    ).
		    put(DISTRICT,
			    new AdministrativeUnit(DISTRICT)
		    ).
		    put(COMMUNE,
			    new AdministrativeUnit(COMMUNE)
		    ).
		    build();

    @Override
    public AdministrativeUnit getPrototype(final PrototypeType type)
    {
	final AdministrativeUnit prototype = prototypes.get(type);
	return prototype.clone();
    }
}
