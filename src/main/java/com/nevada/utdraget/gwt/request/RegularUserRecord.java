package com.nevada.utdraget.gwt.request;

import com.google.gwt.valuestore.shared.Record;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.valuestore.shared.Property;

@RooGwtMirroredFrom(RegularUser.class)
@ServerType(type = RegularUser.class)
public interface RegularUserRecord extends Record {

    public String TOKEN = "RegularUserRecord";

    Property<java.lang.String> email = new com.google.gwt.valuestore.shared.Property<java.lang.String>("email", "Email", java.lang.String.class);

    Property<java.lang.String> name = new com.google.gwt.valuestore.shared.Property<java.lang.String>("name", "Name", java.lang.String.class);

    Property<java.lang.String> pw = new com.google.gwt.valuestore.shared.Property<java.lang.String>("pw", "Pw", java.lang.String.class);

    abstract String getEmail();

    abstract String getName();

    abstract String getPw();
}
