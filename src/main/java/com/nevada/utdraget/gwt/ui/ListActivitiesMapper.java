package com.nevada.utdraget.gwt.ui;

import com.google.gwt.app.place.AbstractRecordListActivity;
import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.google.gwt.event.shared.HandlerManager;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.utdraget.gwt.request.ApplicationRequestFactory;
import com.nevada.utdraget.gwt.ui.RegularUserListActivity;
import com.nevada.utdraget.gwt.request.RegularUserRecord;

/**
 * The class that knows what {@link com.google.gwt.app.place.Activity} to run
 * when the user goes to a particular {@link ListScaffoldPlace}.
 */
public class ListActivitiesMapper implements ActivityMapper<ApplicationListPlace> {
	private final ApplicationRequestFactory requests;
	private final PlaceController<ApplicationPlace> placeController;
	private HandlerManager eventBus;

	public ListActivitiesMapper(HandlerManager eventBus, ApplicationRequestFactory requests, PlaceController<ApplicationPlace> placeController) {
		this.eventBus = eventBus;
		this.requests = requests;
		this.placeController = placeController;
	}

	public AbstractRecordListActivity<?> getActivity(ApplicationListPlace place) {
		if (place.getType().equals(RegularUserRecord.class)) {
			return new RegularUserListActivity(eventBus, requests, placeController);
		}
		throw new RuntimeException("Unable to locate a activity for " + place);
	}
}
