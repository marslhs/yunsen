package com.mars.common.control.global;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mars.common.control.WexinControl;
import com.mars.common.control.utils.TimerUtil;

public class InitConfigListener implements ServletContextListener {
    public static final Logger logger = LoggerFactory.getLogger(WexinControl.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	    TimerUtil.startRefreshTimer();
	    logger.info("start all jobs Ooooooooooooooooooook.");
	}

}
