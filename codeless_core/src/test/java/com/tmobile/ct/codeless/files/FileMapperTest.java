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
package com.tmobile.ct.codeless.files;

import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class FileMapperTest {
	
	@Test
	public void itShouldMapNestedFolders() {
		String path = ClassPathUtil.getAbsolutePath("/components");
		
		FileMapper mapper = new FileMapper(Paths.get(path), "component");
		
		ConcurrentHashMap<String, FileDotIdentifier> files = mapper.map();
		
		assertThat(files.size()).isEqualTo(4);
	}

}
