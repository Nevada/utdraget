package com.nevada.utdraget.gwt.scaffold;

import com.google.gwt.app.place.Activity;
import com.google.gwt.app.place.ActivityMapper;
import com.google.gwt.app.place.PlaceController;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.utdraget.gwt.request.ApplicationRequestFactory;
import com.nevada.utdraget.gwt.scaffold.place.BasePlaceFilter;
import com.nevada.utdraget.gwt.ui.RegularUserActivitiesMapper;
import com.nevada.utdraget.gwt.scaffold.place.RegularUserScaffoldPlace;

/**
 * Finds the activity to run for a particular {@link ScaffoldPlace} in the bottom
 * half of the {@link ScaffoldShell}.
 */
public final class ScaffoldDetailsActivities implements
    ActivityMapper<ApplicationPlace> {

  private final ActivityMapper<RegularUserScaffoldPlace> regularUserActivities;
  public ScaffoldDetailsActivities(ApplicationRequestFactory requestFactory,
      PlaceController<ApplicationPlace> placeController) {
    this.regularUserActivities = new RegularUserActivitiesMapper(
        requestFactory, placeController); 
  }

  public Activity getActivity(ApplicationPlace place) {
    return place.acceptFilter(new BasePlaceFilter<Activity>(null) {
      public Activity filter(RegularUserScaffoldPlace place) {
        return regularUserActivities.getActivity(place);
      }
    });
  }
}
