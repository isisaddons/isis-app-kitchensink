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
package org.isisaddons.app.kitchensink.integtests.modules.semantics;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import org.apache.isis.applib.fixturescripts.FixtureScripts;

import org.isisaddons.app.kitchensink.dom.semantics.SemanticsObject;
import org.isisaddons.app.kitchensink.dom.semantics.SemanticsObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.semantics.SemanticsObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SemanticsObjectIntegTest extends KitchensinkAppIntegTest {


    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    SemanticsObjects semanticsObjects;


    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
    }

    @Test
    public void invokeSafeSemantics() throws Exception {

        // given
        fixtureScripts.runFixtureScript(new SemanticsObjectsFixture(), null);
        nextSession();
        SemanticsObject semanticsObject = semanticsObjects.firstSemanticsObject();
        nextSession();

        assertThat(semanticsObject.getCounter()).isEqualTo(0);

        // when
        semanticsObject.invoke(5, SemanticsObject.Which.SAFE);

        // then
        assertThat(semanticsObject.getCounter()).isEqualTo(5);
    }

    @Test
    public void invokeSafeAndCacheableSemantics() throws Exception {

        // given
        fixtureScripts.runFixtureScript(new SemanticsObjectsFixture(), null);
        nextSession();
        SemanticsObject semanticsObject = semanticsObjects.firstSemanticsObject();
        nextSession();

        assertThat(semanticsObject.getCounter()).isEqualTo(0);

        // when
        semanticsObject.invoke(5, SemanticsObject.Which.SAFE_AND_REQUEST_CACHEABLE);

        // then
        assertThat(semanticsObject.getCounter()).isEqualTo(1);
    }

}