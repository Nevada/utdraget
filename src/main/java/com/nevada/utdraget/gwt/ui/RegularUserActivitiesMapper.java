package com.nevada.utdraget.gwt.ui;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.utdraget.gwt.request.RegularUserRecord;
import com.nevada.utdraget.gwt.scaffold.place.RegularUserScaffoldPlace;
import com.nevada.utdraget.gwt.ui.RegularUserDetailsActivity;
import com.nevada.utdraget.gwt.ui.RegularUserEditActivity;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdraget.gwt.request.ApplicationRequestFactory;

/**
 * Maps {@link ${entity.detailsPlace}} instances to the {@link Activity} to run.
 */
public class RegularUserActivitiesMapper implements ActivityMapper<RegularUserScaffoldPlace> {
	private final ApplicationRequestFactory requests;
	private final PlaceController<ApplicationPlace> placeController;

	public RegularUserActivitiesMapper(ApplicationRequestFactory requests, PlaceController<ApplicationPlace> placeController) {
		this.requests = requests;
		this.placeController = placeController;
	}

	public Activity getActivity(RegularUserScaffoldPlace place) {
		switch (place.getOperation()) {
		case DETAILS:
			return new RegularUserDetailsActivity(place.getId(), requests, placeController);
		case EDIT:
			return new RegularUserEditActivity(place.getId(), requests, placeController);
		}

		throw new IllegalArgumentException("Unknown operation " + place.getOperation());
	}
}
