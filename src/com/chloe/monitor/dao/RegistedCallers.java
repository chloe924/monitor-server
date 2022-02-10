package com.chloe.monitor.dao;

import com.chloe.monitor.caller.Caller;

import java.util.Set;

/**
 * Created by Chloe on 2019-02-06
 */
public interface RegistedCallers  {

    boolean addCaller(String serviceUrl,Caller caller);

    Set<Caller> getRegistedCallers(String serviceUrl);
}

