package com.nevada.utdraget;

import com.nevada.utdraget.RegularUser;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RegularUserDataOnDemand_Roo_DataOnDemand {
    
    declare @type: RegularUserDataOnDemand: @Component;
    
    private Random RegularUserDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<RegularUser> RegularUserDataOnDemand.data;
    
    public RegularUser RegularUserDataOnDemand.getNewTransientRegularUser(int index) {
        com.nevada.utdraget.RegularUser obj = new com.nevada.utdraget.RegularUser();
        obj.setEmail("email_" + index);
        obj.setName("name_" + index);
        obj.setPassword("password_" + index);
        return obj;
    }
    
    public RegularUser RegularUserDataOnDemand.getSpecificRegularUser(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size()-1)) index = data.size() - 1;
        RegularUser obj = data.get(index);
        return RegularUser.findRegularUser(obj.getId());
    }
    
    public RegularUser RegularUserDataOnDemand.getRandomRegularUser() {
        init();
        RegularUser obj = data.get(rnd.nextInt(data.size()));
        return RegularUser.findRegularUser(obj.getId());
    }
    
    public boolean RegularUserDataOnDemand.modifyRegularUser(RegularUser obj) {
        return false;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void RegularUserDataOnDemand.init() {
        if (data != null) {
            return;
        }
        
        data = com.nevada.utdraget.RegularUser.findRegularUserEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'RegularUser' illegally returned null");
        if (data.size() > 0) {
            return;
        }
        
        data = new java.util.ArrayList<com.nevada.utdraget.RegularUser>();
        for (int i = 0; i < 10; i++) {
            com.nevada.utdraget.RegularUser obj = getNewTransientRegularUser(i);
            obj.persist();
            data.add(obj);
        }
    }
    
}
