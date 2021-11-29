/* *********************************************************************** *
 * project: org.matsim.*												   *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2008 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.matsim.project;

import com.google.inject.*;
import com.google.inject.Module;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.api.core.v01.events.Event;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.NetworkFactory;
import org.matsim.api.core.v01.network.Node;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.controler.AbstractModule;
import org.matsim.core.controler.Controler;
import org.matsim.core.controler.ControlerUtils;
import org.matsim.core.controler.OutputDirectoryHierarchy;
import org.matsim.core.events.handler.BasicEventHandler;
import org.matsim.core.network.NetworkUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.utils.objectattributes.attributable.Attributes;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @author nagel
 *
 */
public class MyMatsimRunRunner {

	private static final Logger log = Logger.getLogger("MyMATSimRunner") ;
	private static final String SELECTOR_NAME = "selectorName";


	public static void main(String[] args) {
		Config config = ConfigUtils.loadConfig("scenarios/equil/config.xml");
		Scenario scenario = ScenarioUtils.loadScenario(config);

//		Injector injector = ControlerUtils.createAdhocInjector(config, scenario);

		Controler controler = new Controler(config);

		controler.addOverridingModule((new AbstractModule() {
			@Override
			public void install() {
				if (getConfig().strategy().getPlanSelectorForRemoval().equals(SELECTOR_NAME)) {
					// bindPlanSelectorForRemoval().toProvider(MyExpBetaPlanChangerForRemovalProvider.class);
				}
		}}));
	}

}
