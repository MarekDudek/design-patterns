package interretis.designpatterns.prototype.impl;

import lombok.AllArgsConstructor;
import interretis.designpatterns.prototype.api.Prototype;

@AllArgsConstructor
public class AdministrativeUnit implements Prototype {

    AdministrativeUnitType type;

    @Override
    public AdministrativeUnit clone()
    {
	try
	{
	    final Object clone = super.clone();
	    return (AdministrativeUnit) clone;
	}
	catch (final CloneNotSupportedException exc)
	{
	    throw new UnsupportedOperationException(exc);
	}
    }
}
