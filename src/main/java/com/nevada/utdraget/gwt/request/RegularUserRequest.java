package com.nevada.utdraget.gwt.request;

import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.requestfactory.shared.ServerType;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.requestfactory.shared.ServerOperation;
import com.google.gwt.requestfactory.shared.RecordRequest;
import com.google.gwt.valuestore.shared.PropertyReference;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestObject;

@RooGwtMirroredFrom(RegularUser.class)
@ServerType(type = RegularUser.class)
public interface RegularUserRequest {

    @ServerOperation("FIND_ALL_REGULAR_USERS")
    abstract RecordListRequest<com.nevada.utdraget.gwt.request.RegularUserRecord> findAllRegularUsers();

    @ServerOperation("FIND_REGULAR_USER")
    abstract RecordRequest<com.nevada.utdraget.gwt.request.RegularUserRecord> findRegularUser(PropertyReference<String> id);

    @ServerOperation("COUNT_REGULAR_USERS")
    abstract RequestObject<java.lang.Long> countRegularUsers();

    @ServerOperation("FIND_REGULAR_USER_ENTRIES")
    abstract RecordListRequest<com.nevada.utdraget.gwt.request.RegularUserRecord> findRegularUserEntries(int firstResult, int maxResults);
}
