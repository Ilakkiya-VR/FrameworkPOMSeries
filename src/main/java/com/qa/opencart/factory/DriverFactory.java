package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.FrameworkException;

public class DriverFactory {

	public static String highlightEle;
	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	public OptionsManager optionManager;

	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
		// System.out.println("Browser Name:: " + browserName);
		log.info("Browser Name:: " + browserName);
		highlightEle = prop.getProperty("highlight");
		optionManager = new OptionsManager(prop);

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			// driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionManager.getChromeOptions()));
			break;
		case "firefox":
			// driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionManager.getFirefoxOptions()));
			break;
		case "edge":
			// driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver(optionManager.getEdgeOptions()));
			break;
		default:
			// System.out.println(AppError.INVALID_BROWSER_MSG + browserName);
			log.info("Browser used::" + browserName);
			log.error(AppError.INVALID_BROWSER_MSG);
			throw new FrameworkException("=======INVALID BROWSER========");

		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	// this is used to get the local copy of the driver anytime
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

//this is used to initialise the prop with properties file
//mvn clean install -Denv="qa"
	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		log.info("Environment Name::::::::::" + envName);
		try {
			if (envName == null) {
				log.warn("Environment is not provided.Hence QA env is consideres as default env to run the test+");
				ip = new FileInputStream("./src/test/resources/config/config.qa.properties");

			} else {
				switch (envName.trim().toLowerCase()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/config.qa.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/config.dev.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/config.stage.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/config.uat.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/config.properties");
					break;
				default:
					log.error("Invalid Environment. Please pass the valid env");
					throw new FrameworkException("===========Invalid Environment==================");
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * takescreenshot
	 */

	public static File getScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		return srcFile;
	}

	public static byte[] getScreenshotByte() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);// temp dir

	}

	public static String getScreenshotBase64() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);// temp dir

	}

}
