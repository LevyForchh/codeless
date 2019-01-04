package com.tmobile.ct.codeless.core;

import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * The Interface Test.
 *
 * @author Rob Graff
 */
public interface Test extends Trackable{

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name);
	
	/**
	 * Sets the steps.
	 *
	 * @param steps the new steps
	 */
	void setSteps(List<Step> steps);
	
	/**
	 * Sets the test data.
	 *
	 * @param data the new test data
	 */
	void setTestData(TestData data);
	
	/**
	 * Adds the step.
	 *
	 * @param step the step
	 */
	void addStep(Step step);
	
	/**
	 * Sets the config.
	 *
	 * @param config the new config
	 */
	void setConfig(Config config);
	
	/**
	 * Sets the web driver.
	 *
	 * @param driver the new web driver
	 */
	void setWebDriver(WebDriver driver);
	
	/**
	 * Sets the log proxies.
	 *
	 * @param logProxies the new log proxies
	 */
	void setLogProxies(List<LogProxy> logProxies);
	
	/**
	 * Adds the log proxy.
	 *
	 * @param logProxy the log proxy
	 */
	void addLogProxy(LogProxy logProxy);
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	String getName();
	
	/**
	 * Gets the steps.
	 *
	 * @return the steps
	 */
	List<Step> getSteps();
	
	/**
	 * Gets the test data.
	 *
	 * @return the test data
	 */
	TestData getTestData();
	
	/**
	 * Gets the config.
	 *
	 * @return the config
	 */
	Config getConfig();
	
	/**
	 * Gets the step by name.
	 *
	 * @param name the name
	 * @return the step by name
	 */
	Step getStepByName(String name);
	
	/**
	 * Sets the suite.
	 *
	 * @param suite the new suite
	 */
	void setSuite(Suite suite);
	
	/**
	 * Gets the suite.
	 *
	 * @return the suite
	 */
	Suite getSuite();
	
	/**
	 * Gets the web driver.
	 *
	 * @return the web driver
	 */
	WebDriver getWebDriver();
	
	/**
	 * Gets the log proxies.
	 *
	 * @return the log proxies
	 */
	List<LogProxy> getLogProxies();


	
}