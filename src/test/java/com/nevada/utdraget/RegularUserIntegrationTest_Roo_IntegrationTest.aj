package com.nevada.utdraget;

import com.nevada.utdraget.RegularUserDataOnDemand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RegularUserIntegrationTest_Roo_IntegrationTest {
    
    declare @type: RegularUserIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: RegularUserIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml");
    
    @Autowired
    private RegularUserDataOnDemand RegularUserIntegrationTest.dod;
    
    @Test
    public void RegularUserIntegrationTest.testCountRegularUsers() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        long count = com.nevada.utdraget.RegularUser.countRegularUsers();
        org.junit.Assert.assertTrue("Counter for 'RegularUser' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void RegularUserIntegrationTest.testFindRegularUser() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        java.lang.Long id = dod.getRandomRegularUser().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to provide an identifier", id);
        com.nevada.utdraget.RegularUser obj = com.nevada.utdraget.RegularUser.findRegularUser(id);
        org.junit.Assert.assertNotNull("Find method for 'RegularUser' illegally returned null for id '" + id + "'", obj);
        org.junit.Assert.assertEquals("Find method for 'RegularUser' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void RegularUserIntegrationTest.testFindAllRegularUsers() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        long count = com.nevada.utdraget.RegularUser.countRegularUsers();
        org.junit.Assert.assertTrue("Too expensive to perform a find all test for 'RegularUser', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        java.util.List<com.nevada.utdraget.RegularUser> result = com.nevada.utdraget.RegularUser.findAllRegularUsers();
        org.junit.Assert.assertNotNull("Find all method for 'RegularUser' illegally returned null", result);
        org.junit.Assert.assertTrue("Find all method for 'RegularUser' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void RegularUserIntegrationTest.testFindRegularUserEntries() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        long count = com.nevada.utdraget.RegularUser.countRegularUsers();
        if (count > 20) count = 20;
        java.util.List<com.nevada.utdraget.RegularUser> result = com.nevada.utdraget.RegularUser.findRegularUserEntries(0, (int)count);
        org.junit.Assert.assertNotNull("Find entries method for 'RegularUser' illegally returned null", result);
        org.junit.Assert.assertEquals("Find entries method for 'RegularUser' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    @Transactional
    public void RegularUserIntegrationTest.testFlush() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        java.lang.Long id = dod.getRandomRegularUser().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to provide an identifier", id);
        com.nevada.utdraget.RegularUser obj = com.nevada.utdraget.RegularUser.findRegularUser(id);
        org.junit.Assert.assertNotNull("Find method for 'RegularUser' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyRegularUser(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'RegularUser' failed to increment on flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void RegularUserIntegrationTest.testMerge() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        java.lang.Long id = dod.getRandomRegularUser().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to provide an identifier", id);
        com.nevada.utdraget.RegularUser obj = com.nevada.utdraget.RegularUser.findRegularUser(id);
        org.junit.Assert.assertNotNull("Find method for 'RegularUser' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyRegularUser(obj);
        java.lang.Integer currentVersion = obj.getVersion();
        obj.merge();
        obj.flush();
        org.junit.Assert.assertTrue("Version for 'RegularUser' failed to increment on merge and flush directive", obj.getVersion() > currentVersion || !modified);
    }
    
    @Test
    @Transactional
    public void RegularUserIntegrationTest.testPersist() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        com.nevada.utdraget.RegularUser obj = dod.getNewTransientRegularUser(Integer.MAX_VALUE);
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to provide a new transient entity", obj);
        org.junit.Assert.assertNull("Expected 'RegularUser' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        org.junit.Assert.assertNotNull("Expected 'RegularUser' identifier to no longer be null", obj.getId());
    }
    
    @Test
    @Transactional
    public void RegularUserIntegrationTest.testRemove() {
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to initialize correctly", dod.getRandomRegularUser());
        java.lang.Long id = dod.getRandomRegularUser().getId();
        org.junit.Assert.assertNotNull("Data on demand for 'RegularUser' failed to provide an identifier", id);
        com.nevada.utdraget.RegularUser obj = com.nevada.utdraget.RegularUser.findRegularUser(id);
        org.junit.Assert.assertNotNull("Find method for 'RegularUser' illegally returned null for id '" + id + "'", obj);
        obj.remove();
        obj.flush();
        org.junit.Assert.assertNull("Failed to remove 'RegularUser' with identifier '" + id + "'", com.nevada.utdraget.RegularUser.findRegularUser(id));
    }
    
}
