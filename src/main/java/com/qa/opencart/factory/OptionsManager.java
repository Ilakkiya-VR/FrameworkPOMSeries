package com.qa.opencart.factory;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	private static final Logger log = LogManager.getLogger(OptionsManager.class);
	
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			log.info("Running Headless Mode");
			co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			log.info("Running Incognito Mode");
			co.addArguments("--incognito");
		}
		return co;
	}
	public FirefoxOptions getFirefoxOptions() {
		fo=new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			log.info("Running Headless Mode");
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			log.info("Running Incognito Mode");
			fo.addArguments("--incognito");
		}
		return fo;
	}
	public EdgeOptions getEdgeOptions() {
		eo=new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			log.info("Running Headless Mode");
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))){
			log.info("Running Incognito Mode");
			eo.addArguments("--inPrivate");
		}
		return eo;
	}

}
