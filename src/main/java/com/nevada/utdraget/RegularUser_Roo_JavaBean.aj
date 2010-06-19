package com.nevada.utdraget;

import java.lang.String;

privileged aspect RegularUser_Roo_JavaBean {
    
    public String RegularUser.getName() {
        return this.name;
    }
    
    public void RegularUser.setName(String name) {
        this.name = name;
    }
    
    public String RegularUser.getPassword() {
        return this.password;
    }
    
    public void RegularUser.setPassword(String password) {
        this.password = password;
    }
    
    public String RegularUser.getEmail() {
        return this.email;
    }
    
    public void RegularUser.setEmail(String email) {
        this.email = email;
    }
    
}
