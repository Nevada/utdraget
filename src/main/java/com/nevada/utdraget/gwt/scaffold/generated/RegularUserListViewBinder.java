package com.nevada.utdraget.gwt.scaffold.generated;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.nevada.utdraget.gwt.scaffold.generated.RegularUserListView;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(RegularUser.class)
@ServerType(type = RegularUser.class)
public interface RegularUserListViewBinder extends UiBinder<HTMLPanel, RegularUserListView> {
}
