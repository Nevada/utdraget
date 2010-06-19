package com.nevada.utdraget;

import java.lang.String;

privileged aspect RegularUser_Roo_ToString {
    
    public String RegularUser.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Password: ").append(getPassword()).append(", ");
        sb.append("Email: ").append(getEmail());
        return sb.toString();
    }
    
}
