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
package org.isisaddons.app.kitchensink.integtests.modules.spec;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.services.wrapper.InvalidException;

import org.isisaddons.app.kitchensink.dom.spec.SpecObject;
import org.isisaddons.app.kitchensink.dom.spec.SpecObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.spec.SpecObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;
import org.isisaddons.module.fakedata.dom.FakeDataService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SpecObjectIntegTest extends KitchensinkAppIntegTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    FakeDataService fake;
    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    SpecObjects specObjects;

    SpecObject specObject;

    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
        fixtureScripts.runFixtureScript(new SpecObjectsFixture(), null);
        nextSession();

        // given
        specObject = specObjects.firstSpecObject();
        nextSession();
    }

    public static class ForParameterTest extends SpecObjectIntegTest {

        public static class SpecificationTest extends ForParameterTest {

            @Test
            public void satisfies_specification() throws Exception {

                // when
                final String newName = fake.name().firstName();
                wrap(specObject).updateName(newName);

                // then
                assertThat(specObject.getName()).isEqualTo(newName);
            }

            @Test
            public void violates_specification() throws Exception {

                final String arg = "with space";

                // expect
                expectedException.expect(InvalidException.class);
                expectedException.expectMessage(containsString("Cannot contain spaces!"));

                // when
                wrap(specObject).updateName(arg);
                assertThat(specObject.getName()).isEqualTo(arg);
            }
        }

        public static class Specification2Test extends ForParameterTest {

            @Test
            public void satisfies_specification() throws Exception {

                // when
                final String newDescription = fake.name().firstName();
                wrap(specObject).updateDescription(newDescription);

                // then
                assertThat(specObject.getDescription()).isEqualTo(newDescription);
            }

            @Test
            public void violates_specification() throws Exception {

                final String arg = "with space";

                // expect
                expectedException.expect(InvalidException.class);
                expectedException.expectMessage(containsString("Proposed value 'with space' cannot contain spaces!"));

                // when
                wrap(specObject).updateDescription(arg);
                assertThat(specObject.getDescription()).isEqualTo(arg);
            }
        }

    }
    public static class ForPropertyTest extends SpecObjectIntegTest {

        public static class SpecificationTest extends ForPropertyTest {

            @Test
            public void satisfies_specification() throws Exception {

                // when
                final String newName = fake.name().firstName();
                wrap(specObject).setName(newName);

                // then
                assertThat(specObject.getName()).isEqualTo(newName);
            }

            @Test
            public void violates_specification() throws Exception {

                final String arg = "with space";

                // expect
                expectedException.expect(InvalidException.class);
                expectedException.expectMessage(containsString("Cannot contain spaces!"));

                // when
                wrap(specObject).setName(arg);
                assertThat(specObject.getName()).isEqualTo(arg);
            }
        }

        public static class Specification2Test extends ForPropertyTest {

            @Test
            public void satisfies_specification() throws Exception {

                // when
                final String newDescription = fake.name().firstName();
                wrap(specObject).setDescription(newDescription);

                // then
                assertThat(specObject.getDescription()).isEqualTo(newDescription);
            }

            @Test
            public void violates_specification() throws Exception {

                final String arg = "with space";

                // expect
                expectedException.expect(InvalidException.class);
                expectedException.expectMessage(containsString("Proposed value 'with space' cannot contain spaces!"));

                // when
                wrap(specObject).setDescription(arg);
                assertThat(specObject.getDescription()).isEqualTo(arg);
            }
        }

    }

}