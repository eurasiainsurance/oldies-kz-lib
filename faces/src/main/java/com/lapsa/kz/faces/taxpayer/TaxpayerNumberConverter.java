package com.lapsa.kz.faces.taxpayer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

@FacesConverter(forClass = TaxpayerNumber.class)
public class TaxpayerNumberConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
	return MyOptionals.of(value) //
		.map(TaxpayerNumber::assertValid) //
		.orElse(null);
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
	return MyOptionals.of(value) //
		.map(MyObjects.cast(TaxpayerNumber.class)) //
		.map(TaxpayerNumber::getNumber) //
		.orElse("");
    }
}
