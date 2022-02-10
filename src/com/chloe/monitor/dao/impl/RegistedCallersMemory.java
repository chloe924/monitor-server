package com.chloe.monitor.dao.impl;

import com.chloe.monitor.caller.Caller;
import com.chloe.monitor.dao.RegistedCallers;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Chloe on 2019-02-06
 */
public class RegistedCallersMemory implements RegistedCallers {
    private static final Map<String, Set<Caller>> callers = new ConcurrentHashMap<>();
    @Override
    public boolean addCaller(String serviceUrl,Caller caller) {
        Set<Caller> callerSet =  callers.get(serviceUrl);
        if (callerSet == null) {
            callerSet = new CopyOnWriteArraySet<>();
            callerSet.add(caller);
        }
        callers.put(serviceUrl,callerSet);

        return true;
    }

    @Override
    public Set<Caller> getRegistedCallers(String serviceUrl) {
        return callers.get(serviceUrl);
    }

}
