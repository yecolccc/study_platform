package com.yecol.study.course.web.listner;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

@WebListener
public class LoadConfigListner implements ServletContextListener {

    public LoadConfigListner() {
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         //取得log4j的配置信息
    	URL url = LoadConfigListner.class.getClassLoader().getResource("log4j.properties");
    	//加载配置文件
    	PropertyConfigurator.configure(url);
    }
	
}
