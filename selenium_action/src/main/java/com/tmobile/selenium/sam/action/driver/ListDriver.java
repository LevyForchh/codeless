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
package com.tmobile.selenium.sam.action.driver;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tmobile.selenium.sam.action.actions.Action;
import com.tmobile.selenium.sam.action.actions.GoToStep;
import com.tmobile.selenium.sam.action.report.ActionTestResult;
import com.tmobile.selenium.sam.action.report.StepResult;
import com.tmobile.selenium.sam.action.types.ActionType;
import com.tmobile.selenium.sam.action.types.TestStatus;



/**
 * The Class ListDriver.
 *
 * @author Rob Graff (RGraff1)
 */
public class ListDriver {


	/** The actions. */
	private List<Action> actions;
	
	/** The log. */
	private static Logger log = LoggerFactory.getLogger(ListDriver.class);

	/**
	 * Instantiates a new list driver.
	 *
	 * @param actions the actions
	 */
	public ListDriver(List<Action> actions) {

		this.actions = actions;
	}

	/**
	 * Run.
	 */
	public void run() {
		ActionTestResult testResult = new ActionTestResult();

		TestStatus status = TestStatus.inProgress;
		testResult.setStatus(status);
		testResult.start();
		for(int i = 0; i<actions.size(); i++){
			Action action = actions.get(i);
			
			action.execute();
			StepResult result = action.getStepResult();
			log.info("action[" + action.type() + "] status[" + result.getStepStatus().name() + "] time["
					+ result.getTime() + "] " + action.toString() + " screenshot[" + result.getScreenshotLocation()
					+ "]");
			if (!result.getStepBool()) {
				log.info(result.getExceptionString());
				result.getException().printStackTrace();
				status = TestStatus.fail;
				break;
			}
			if(action.type().equals(ActionType.GoToStep)){
				i = ((GoToStep) action).getGoToStep() - 1;
			}
		}

		if (status != TestStatus.fail) {
			status = TestStatus.pass;
		}
		testResult.end(status);
		log.info("==Test End ["+testResult.getStatus().name()+"] start["+testResult.getStartTime()+"] end["+testResult.getEndTime()+"] time[" + testResult.getRunTime() + "] timeString[" + testResult.getRunTimeString()
				+ "]==");

	}

}
