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
package com.tmobile.ct.codeless.test.plugin;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ClassUtils;
import com.tmobile.ct.codeless.core.plugin.ConfigPluginParser;
import com.tmobile.ct.codeless.core.plugin.Plugin;

public class PluginBuilder implements ConfigPluginParser{

	private static final String PLUGINS_KEY = "codeless.plugins";

	@Override
	public List<Plugin> getPlugins(Map<String, String> config) {
		if (config.get(PLUGINS_KEY) == null) {
			return null;
		}

		List<String> pluginClassList = parsePluginString(config.get(PLUGINS_KEY));
		List<Plugin> plugins = new ArrayList<>();
		for (String entry : pluginClassList) {
			try {
				Class<?> obj = Class.forName(entry);
				if (ClassUtils.isAssignable(obj, Plugin.class)) {
					plugins.add((Plugin) obj.newInstance());
				}
			} catch (Exception ex) {
				// skip
			}
		}

		return plugins;
	}

	public List<String> parsePluginString(String plugins){
		String[] classes = plugins.split(",");
		return Arrays.asList(classes).stream()
				.map(String::trim)
				.collect(Collectors.toList());
	}
}
