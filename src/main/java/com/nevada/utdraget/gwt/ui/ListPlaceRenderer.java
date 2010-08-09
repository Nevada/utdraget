package com.nevada.utdraget.gwt.ui;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.valuestore.shared.Record;
import com.nevada.utdraget.gwt.scaffold.place.ApplicationListPlace;
public class ListPlaceRenderer extends AbstractRenderer<ApplicationListPlace> {
    public String render(ApplicationListPlace object) {
        Class<? extends Record> type = object.getType();
        if (type.equals(com.nevada.utdraget.gwt.request.RegularUserRecord.class)) {
            return "RegularUsers";
        }
        throw new IllegalArgumentException("Cannot render unknown type " + object);
    }
}
