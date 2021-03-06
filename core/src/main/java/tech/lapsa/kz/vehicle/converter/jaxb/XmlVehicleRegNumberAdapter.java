package tech.lapsa.kz.vehicle.converter.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class XmlVehicleRegNumberAdapter extends XmlAdapter<String, VehicleRegNumber> {

    @Override
    public VehicleRegNumber unmarshal(final String v) throws Exception {
	return MyStrings.empty(v) //
		? null //
		: VehicleRegNumber.assertValid(VehicleRegNumber.normalizeNumber(v));
    }

    @Override
    public String marshal(final VehicleRegNumber v) throws Exception {
	return MyObjects.isNull(v) //
		? null //
		: v.getNumber();
    }

}
