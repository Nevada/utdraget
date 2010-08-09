package com.nevada.utdraget.gwt.request;

import com.google.gwt.valuestore.shared.RecordChangedEvent;
import com.nevada.utdraget.gwt.request.RegularUserRecord;
import com.nevada.utdraget.gwt.request.RegularUserChangedHandler;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.valuestore.shared.WriteOperation;

@RooGwtMirroredFrom(RegularUser.class)
public class RegularUserRecordChanged extends RecordChangedEvent<RegularUserRecord, RegularUserChangedHandler> {

    public static final Type<com.nevada.utdraget.gwt.request.RegularUserChangedHandler> TYPE = new com.google.gwt.event.shared.GwtEvent.Type<com.nevada.utdraget.gwt.request.RegularUserChangedHandler>();

    public RegularUserRecordChanged(RegularUserRecord record, WriteOperation writeOperation) {
        super(record, writeOperation);
    }

    public Type<com.nevada.utdraget.gwt.request.RegularUserChangedHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(RegularUserChangedHandler handler) {
        handler.onRegularUserChanged(this);
    }
}
