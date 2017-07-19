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
package org.isisaddons.app.kitchensink.integtests.modules.viewmodels;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.registry.ServiceRegistry2;

import org.isisaddons.app.kitchensink.dom.primitive.PrimitiveObjects;
import org.isisaddons.app.kitchensink.dom.viewmodels.ViewModels;
import org.isisaddons.app.kitchensink.dom.viewmodels.SomeViewModel;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;

public class ViewmodelIntegTest extends KitchensinkAppIntegTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    PrimitiveObjects primitiveObjects;


    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
    }

    @Test
    public void create() throws Exception {

        // given
        ViewModels viewModels = new ViewModels();
        serviceRegistry2.injectServicesInto(viewModels);

        // when
        SomeViewModel viewModel = viewModels.createViewModel(1, "test", new LocalDate(2016,1,1));
        SomeViewModel viewModelThroughWrapper = wrap(viewModels).createViewModel(2, "test", new LocalDate(2016,1,1));

        // then
        Assertions.assertThat(viewModel.getDate()).isEqualTo(new LocalDate(2016,1,1));
        Assertions.assertThat(viewModelThroughWrapper.getDate()).isEqualTo(new LocalDate(2016,1,1));

    }

    @Inject
    ServiceRegistry2 serviceRegistry2;

}