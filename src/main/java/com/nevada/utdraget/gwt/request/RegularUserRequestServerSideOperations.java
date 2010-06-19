package com.nevada.utdraget.gwt.request;

import com.google.gwt.requestfactory.shared.RequestFactory.RequestDefinition;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;
import com.nevada.utdraget.RegularUser;
import com.google.gwt.requestfactory.shared.ServerType;

@RooGwtMirroredFrom(RegularUser.class)
@ServerType(type = RegularUser.class)
public enum RegularUserRequestServerSideOperations implements RequestDefinition {

    FIND_ALL_REGULAR_USERS, FIND_REGULAR_USER, COUNT_REGULAR_USERS, FIND_REGULAR_USER_ENTRIES;

    public String getDomainClassName() {
        return "com.nevada.utdraget.RegularUser";
    }

    public String getDomainMethodName() {
        switch(this) {
            case FIND_ALL_REGULAR_USERS:
                return "findAllRegularUsers";
            case FIND_REGULAR_USER:
                return "findRegularUser";
            case COUNT_REGULAR_USERS:
                return "countRegularUsers";
            case FIND_REGULAR_USER_ENTRIES:
                return "findRegularUserEntries";
            default:
                throw new IllegalStateException();
        }
    }

    public boolean isReturnTypeList() {
        switch(this) {
            case FIND_ALL_REGULAR_USERS:
                return true;
            case FIND_REGULAR_USER:
                return false;
            case COUNT_REGULAR_USERS:
                return false;
            case FIND_REGULAR_USER_ENTRIES:
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?> getReturnType() {
        switch(this) {
            case FIND_ALL_REGULAR_USERS:
                return com.nevada.utdraget.gwt.request.RegularUserRecord.class;
            case FIND_REGULAR_USER:
                return com.nevada.utdraget.gwt.request.RegularUserRecord.class;
            case COUNT_REGULAR_USERS:
                return java.lang.Long.class;
            case FIND_REGULAR_USER_ENTRIES:
                return com.nevada.utdraget.gwt.request.RegularUserRecord.class;
            default:
                throw new IllegalStateException();
        }
    }

    public Class<?>[] getParameterTypes() {
        switch(this) {
            case FIND_ALL_REGULAR_USERS:
                return null;
            case FIND_REGULAR_USER:
                return new Class[] { java.lang.Long.class };
            case COUNT_REGULAR_USERS:
                return null;
            case FIND_REGULAR_USER_ENTRIES:
                return new Class[] { int.class, int.class };
            default:
                throw new IllegalStateException();
        }
    }
}
