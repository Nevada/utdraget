package com.nevada.utdraget.gwt.ui;

import com.google.gwt.app.place.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.valuestore.shared.Value;
import com.google.gwt.valuestore.ui.AbstractRecordEditActivity;
import com.google.gwt.valuestore.ui.RecordEditView;
import com.nevada.utdraget.gwt.request.RegularUserRecord;
import com.nevada.utdraget.gwt.request.ApplicationRequestFactory;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationPlace;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationListPlace;
import com.nevada.utdraget.gwt.scaffold.place.RegularUserScaffoldPlace;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationRecordPlace;
import com.nevada.utdraget.gwt.scaffold.generated.RegularUserEditView;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationRecordPlace.Operation;


/**
 * An activity that requests all info on an RegularUser, allows the user to edit
 * it, and persists the results.
 */
public class RegularUserEditActivity extends
    AbstractRecordEditActivity<RegularUserRecord> {
  private static RecordEditView<RegularUserRecord> defaultView;

  private static RecordEditView<RegularUserRecord> getDefaultView() {
    if (defaultView == null) {
      defaultView = new RegularUserEditView();
    }
    return defaultView;
  }

  private final ApplicationRequestFactory requests;
  private final PlaceController<ApplicationPlace> placeController;

  /**
   * Creates an activity that uses the default singleton view instance.
   */
  public RegularUserEditActivity(String id, ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    this(id, getDefaultView(), requests, placeController);
  }

  /**
   * Creates an activity that uses its own view instance.
   */
  public RegularUserEditActivity(String id, RecordEditView<RegularUserRecord> view,
      ApplicationRequestFactory requests,
      PlaceController<ApplicationPlace> placeController) {
    super(view, id, requests);
    this.requests = requests;
    this.placeController = placeController;
  }


  protected void exit() {
    placeController.goTo(new RegularUserScaffoldPlace(getId(), Operation.DETAILS));
  }

  protected void fireFindRequest(Value<String> id,
      Receiver<RegularUserRecord> callback) {
    requests.regularUserRequest().findRegularUser(id).to(callback).fire();
  }

  protected String getRecordToken() {
    return RegularUserRecord.TOKEN;
  }
}
