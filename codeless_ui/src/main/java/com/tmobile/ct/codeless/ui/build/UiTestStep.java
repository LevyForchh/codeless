/*******************************************************************************
 * * Copyright 2018 T Mobile, Inc. or its affiliates. All Rights Reserved.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  * use this file except in compliance with the License.  You may obtain a copy
 *  * of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 *  * License for the specific language governing permissions and limitations under
 *  * the License.
 ******************************************************************************/
package com.tmobile.ct.codeless.ui.build;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ExcelUiTestRow.
 *
 * @author Rob Graff
 */
public class UiTestStep {

	/** The Step. */
	private String Step;
	
	/** The Action. */
	private String Action;
	
	/** The Target. */
	private String Target;
	
	/** The Input. */
	private String Input;
	
	/** The Wait time override. */
	private String WaitTime_Override;
	
	/** The Wait type. */
	private String WaitType;
	
	/** The Action override. */
	private String Action_Override;

	private String description;
	
	/** The test data. */
	private List<String> testData = new ArrayList<>();


	/**
	 * Gets the test data.
	 *
	 * @return the test data
	 */
	public List<String> getTestData() {
		return testData;
	}
	
	/**
	 * Sets the test data.
	 *
	 * @param testData the new test data
	 */
	public void setTestData(List<String> testData) {
		this.testData = testData;
	}
	
	/**
	 * Gets the step.
	 *
	 * @return the step
	 */
	public String getStep() {
		return Step;
	}
	
	/**
	 * Sets the step.
	 *
	 * @param step the new step
	 */
	public void setStep(String step) {
		Step = step;
	}
	
	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return Action;
	}
	
	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(String action) {
		Action = action;
	}
	
	/**
	 * Gets the target.
	 *
	 * @return the target
	 */
	public String getTarget() {
		return Target;
	}
	
	/**
	 * Sets the target.
	 *
	 * @param target the new target
	 */
	public void setTarget(String target) {
		Target = target;
	}
	
	/**
	 * Gets the input.
	 *
	 * @return the input
	 */
	public String getInput() {
		return Input;
	}
	
	/**
	 * Sets the input.
	 *
	 * @param input the new input
	 */
	public void setInput(String input) {
		Input = input;
	}
	
	/**
	 * Gets the wait time override.
	 *
	 * @return the wait time override
	 */
	public String getWaitTime_Override() {
		return WaitTime_Override;
	}
	
	/**
	 * Sets the wait time override.
	 *
	 * @param waitTime_Override the new wait time override
	 */
	public void setWaitTime_Override(String waitTime_Override) {
		WaitTime_Override = waitTime_Override;
	}

	/**
	 * Gets the wait type.
	 *
	 * @return the wait type
	 */
	public String getWaitType() {
		return WaitType;
	}
	
	/**
	 * Sets the wait type.
	 *
	 * @param waitType the new wait type
	 */
	public void setWaitType(String waitType) {
		WaitType = waitType;
	}
	
	/**
	 * Gets the action override.
	 *
	 * @return the action override
	 */
	public String getAction_Override() {
		return Action_Override;
	}
	
	/**
	 * Sets the action override.
	 *
	 * @param action_Override the new action override
	 */
	public void setAction_Override(String action_Override) {
		Action_Override = action_Override;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}



