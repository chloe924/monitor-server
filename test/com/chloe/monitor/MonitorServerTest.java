package com.chloe.monitor; 

import com.chloe.monitor.caller.Caller;
import com.chloe.monitor.client.MonitorClient;
import com.chloe.monitor.dao.MonitoredServices;
import com.chloe.monitor.dao.RegistedCallers;
import com.chloe.monitor.dao.impl.MonitoredServicesMemory;
import com.chloe.monitor.dao.impl.RegistedCallersMemory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/** 
* MonitorServer Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 7, 2019</pre> 
* @version 1.0 
*/ 
public class MonitorServerTest {
    MonitorServer ms1;
    MonitorServer ms2;
    MonitoredServices ms = new MonitoredServicesMemory();
    RegistedCallers rcs = new RegistedCallersMemory();

    @Before
public void before() throws Exception {
     ms1 = MonitorServer.getInstance(1,1, ms,rcs);
     ms2 = MonitorServer.getInstance(2,1, ms,rcs);

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getInstance(int monitorClientThreadPoolSize, int monitorNoticeThreadPoolSize, MonitoredServices monitoredServices, RegistedCallers registedCallers) 
* 
*/ 
@Test
public void testGetInstance() throws Exception {
    Assert.assertEquals(ms1,ms2);

}

/** 
* 
* Method: run() 
* 
*/ 
@Test
public void testRun() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: callerRegister(String serviceUrl, Caller caller) 
* 
*/ 
@Test
public void testCallerRegister() throws Exception { 


} 


} 
