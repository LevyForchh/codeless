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
package com.tmobile.ct.codeless.service.accessor.request;

import com.tmobile.ct.codeless.core.Test;
import com.tmobile.ct.codeless.core.TestDataSource;
import com.tmobile.ct.codeless.service.HttpRequest;
import com.tmobile.ct.codeless.service.httpclient.Endpoint;
import com.tmobile.ct.codeless.testdata.RequestModifier;

/**
 * The Class EndpointModifier.
 *
 * @author Rob Graff
 */
public class EndpointModifier implements RequestModifier<Endpoint, HttpRequest>{


	/** The dataSource to override. */
	private TestDataSource dataSource;

	/**
	 * Instantiates a new endpoint modifier.
	 *
	 * @param responseAccessor the response accessor
	 */
	public EndpointModifier(TestDataSource dataSource){

		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see com.tmobile.ct.codeless.service.accessor.request.RequestModifier#modify(com.tmobile.ct.codeless.service.HttpRequest)
	 */
	@Override
	public void modify(HttpRequest request,Test test) {
		request.setEndpoint(new Endpoint((String)dataSource.fullfill()));

	}
}
