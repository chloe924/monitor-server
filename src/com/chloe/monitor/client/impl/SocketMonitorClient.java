package com.chloe.monitor.client.impl;

import com.chloe.monitor.dao.RegistedCallers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created by Chloe on 2019-02-06
 */
public class SocketMonitorClient extends AbstractMonitorClient {
    InetSocketAddress address;

    public SocketMonitorClient(String serviceUrl,ExecutorService monitorNoticeExecutePool, RegistedCallers registedCallers) {
        super(serviceUrl,monitorNoticeExecutePool,registedCallers);
        String[] serverinfo = serviceUrl.split(":");
        this.address = new InetSocketAddress(serverinfo[0], Integer.parseInt(serverinfo[1]));
    }

    @Override
    public boolean isAlive() {
        try (Socket s = new Socket()) {

            s.connect(address,1000);
            return s.isConnected();

        } catch (IOException e) {
            return  false ;
        }
    }

    public String toString() {
        return "SocketMonitorClient : connected to " + address.getHostName() + ":" + address.getPort();
    }

}
