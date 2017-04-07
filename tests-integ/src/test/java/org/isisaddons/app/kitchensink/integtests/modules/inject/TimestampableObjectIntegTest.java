/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.isisaddons.app.kitchensink.integtests.modules.inject;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import org.apache.isis.applib.fixturescripts.FixtureScripts;

import org.isisaddons.app.kitchensink.dom.inject.InjectObject;
import org.isisaddons.app.kitchensink.dom.inject.InjectObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.inject.InjectObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;

import static org.assertj.core.api.Assertions.assertThat;

public class TimestampableObjectIntegTest extends KitchensinkAppIntegTest {


    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    InjectObjects injectObjects;

    InjectObject injectObject;

    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
        fixtureScripts.runFixtureScript(new InjectObjectsFixture(), null);
        nextSession();

        // given
        injectObject = injectObjects.firstInjectObject();
        nextSession();
    }

    @Test
    public void all_services_injected_into_list() throws Exception {

        // when
        final int numberOfServices = injectObject.getNumberOfServices();

        // then
        assertThat(numberOfServices).isEqualTo(2);
    }

    @Test
    public void no_services_then_empty_list() throws Exception {

        // when
        final int numberOfServices = injectObject.getNumberOfOtherServices();

        // then
        assertThat(numberOfServices).isNotNull();
        assertThat(numberOfServices).isEqualTo(0);
    }


}