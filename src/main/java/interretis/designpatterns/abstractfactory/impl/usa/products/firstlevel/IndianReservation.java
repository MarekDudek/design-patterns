package interretis.designpatterns.abstractfactory.impl.usa.products.firstlevel;

import interretis.designpatterns.abstractfactory.abstractimpl.AbstractAdministrativeUnit;
import interretis.designpatterns.abstractfactory.api.products.Country;
import interretis.designpatterns.abstractfactory.api.products.firstlevel.Reservation;

public class IndianReservation extends AbstractAdministrativeUnit implements Reservation {

    public IndianReservation(Country country) 
    {
	super((AbstractAdministrativeUnit) country);
    }
}
