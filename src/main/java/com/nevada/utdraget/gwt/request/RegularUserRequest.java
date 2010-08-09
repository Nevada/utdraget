package com.nevada.utdraget.gwt.request;

import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.requestfactory.shared.Service;
import com.google.gwt.requestfactory.shared.RecordListRequest;
import com.google.gwt.requestfactory.shared.RecordRequest;
import com.google.gwt.valuestore.shared.PropertyReference;
import com.google.gwt.requestfactory.shared.RequestFactory.RequestObject;

@RooGwtMirroredFrom(RegularUser.class)
@Service(RegularUser.class)
public interface RegularUserRequest {

    abstract RecordListRequest<com.nevada.utdraget.gwt.request.RegularUserRecord> findAllRegularUsers();

    abstract RecordRequest<com.nevada.utdraget.gwt.request.RegularUserRecord> findRegularUser(PropertyReference<String> id);

    abstract RequestObject<java.lang.Long> countRegularUsers();

    abstract RecordListRequest<com.nevada.utdraget.gwt.request.RegularUserRecord> findRegularUserEntries(int firstResult, int maxResults);
}
