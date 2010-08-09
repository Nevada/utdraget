package com.nevada.utdraget.gwt.scaffold.place;

import com.google.gwt.valuestore.shared.Record;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationPlaceFilter;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.utdraget.gwt.scaffold.place.RegularUserScaffoldPlace;
import com.nevada.utdraget.gwt.request.RegularUserRecord;

/**
 * Filters an {@link ApplicationPlace} to the corresponding record type.
 */
public final class ApplicationPlaceToRecordType implements ApplicationPlaceFilter<Class<? extends Record>> {

	public Class<? extends Record> filter(RegularUserScaffoldPlace place) {
		return RegularUserRecord.class;
	}

	public Class<? extends Record> filter(ApplicationListPlace place) {
		return place.getType();
	}
}