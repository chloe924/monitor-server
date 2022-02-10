package com.chloe.monitor.client.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SocketMonitorClient Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 7, 2019</pre> 
* @version 1.0 
*/ 
public class SocketMonitorClientTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: isAlive() 
* 
*/ 
@Test
public void testIsAlive() throws Exception {
    SocketMonitorClient sc = new SocketMonitorClient(
            "216.58.217.36:80",null,null);
    Assert.assertTrue(sc.isAlive());

    sc = new SocketMonitorClient(
            "216.58.217.36:8888",null,null);
    Assert.assertFalse(sc.isAlive());
} 


} 
