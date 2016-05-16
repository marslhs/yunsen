package com.mars.common.control.utils;

import java.util.Timer;
import java.util.TimerTask;

import com.mars.common.control.global.impl.GlobalConfig;


public class TimerUtil {
    //提早60s促发token刷新。 
    public static void startRefreshTimer(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            
            @Override
            public void run() {
                GlobalConfig.refreshToken();
                GlobalConfig.refreshJsTicket();
                System.out.println(GlobalConfig.getToken());
                System.out.println(GlobalConfig.getJsTicket());
            }
        }, 0, GlobalConfig.tokenExpiredIn - 60000);
       
    }
    
    public static void main(String[] args) {
        startRefreshTimer();
    }
}
