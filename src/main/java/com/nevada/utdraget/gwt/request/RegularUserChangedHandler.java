package com.nevada.utdraget.gwt.request;

import com.google.gwt.event.shared.EventHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.requestfactory.shared.ServerType;
import com.nevada.utdraget.gwt.request.RegularUserRecordChanged;

@RooGwtMirroredFrom(RegularUser.class)
@ServerType(type = RegularUser.class)
public interface RegularUserChangedHandler extends EventHandler {

    abstract void onRegularUserChanged(RegularUserRecordChanged event);
}
