package com.lapsa.kz.country;

import java.util.function.Predicate;
import java.util.stream.Stream;

import tech.lapsa.java.commons.localization.LocalizedElement;

public enum KZTypeOfSettlement implements LocalizedElement {
    CITY, // город
    VILLAGE, // село
    AUL, // аул
    OTHER, // другое
    UNDEFINED(false), // не определено
    ;

    //

    private final boolean selectable;

    //

    private KZTypeOfSettlement() {
	selectable = true;
    }

    private KZTypeOfSettlement(final boolean selectable) {
	this.selectable = selectable;
    }

    //

    public static final Stream<KZTypeOfSettlement> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<KZTypeOfSettlement> SELECTABLE_FILTER = KZTypeOfSettlement::isSelectable;

    public static final KZTypeOfSettlement[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(KZTypeOfSettlement[]::new);
    }

    //

    private static final Predicate<KZTypeOfSettlement> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final KZTypeOfSettlement[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(KZTypeOfSettlement[]::new);
    }

    // GENERATED

    public boolean isSelectable() {
	return selectable;
    }

    public boolean in(KZTypeOfSettlement ... typesOfSettlement) {
	for (KZTypeOfSettlement a : typesOfSettlement)
	    if (a.equals(this))
		return true;
	return false;
    }
}
