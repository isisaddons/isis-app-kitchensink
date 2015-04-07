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
package org.isisaddons.app.kitchensink.integtests.modules.wrapper;

import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.wrapper.WrapperObject;
import org.isisaddons.app.kitchensink.dom.wrapper.WrapperObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.wrapper.WrapperObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import static org.assertj.core.api.Assertions.assertThat;

public class WrapperObjectIntegTest extends KitchensinkAppIntegTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    WrapperObjects wrapperObjects;


    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
    }

    @Test
    public void persist_then_update() throws Exception {

        // given, when
        fixtureScripts.runFixtureScript(new WrapperObjectsFixture() {{
            setNumberToCreate(1);
            setName("Foo");
            setByte((byte) 123);
            setShort((short) 456);
            setInteger(789);
            setLong(1234567890L);
            setFloat(123.5F);
            setDouble(456.5);
        }}, null);

        nextSession();

        // then
        WrapperObject wrapperObject = wrapperObjects.first();

        assertThat(wrapperObject.getName()).isEqualTo("Foo #0");
        assertThat(wrapperObject.getSomeByteWrapperMandatory()).isEqualTo((byte)123);
        assertThat(wrapperObject.getSomeShortWrapperMandatory()).isEqualTo((short)456);
        assertThat(wrapperObject.getSomeIntegerWrapperMandatory()).isEqualTo(789);
        assertThat(wrapperObject.getSomeLongWrapperMandatory()).isEqualTo(1234567890L);
        assertThat(wrapperObject.getSomeFloatWrapperMandatory()).isEqualTo(123.5F);
        assertThat(wrapperObject.getSomeDoubleWrapperMandatory()).isEqualTo(456.5);

        // when
        wrapperObject.updateSomeByteWrapperMandatory((byte) 99);
        wrapperObject.updateSomeShortWrapperMandatory((short) 654);
        wrapperObject.updateSomeIntegerWrapperMandatory(987);
        wrapperObject.updateSomeLongWrapperMandatory(9876543210L);
        wrapperObject.updateSomeFloatWrapperMandatory(321.5F);
        wrapperObject.updateSomeDoubleWrapperMandatory(654.5);

        wrapperObject.updateSomeByteWrapperOptional(null);
        wrapperObject.updateSomeShortWrapperOptional(null);
        wrapperObject.updateSomeIntegerWrapperOptional(null);
        wrapperObject.updateSomeLongWrapperOptional(null);
        wrapperObject.updateSomeFloatWrapperOptional(null);
        wrapperObject.updateSomeDoubleWrapperOptional(null);

        nextSession();

        // then
        wrapperObject = wrapperObjects.first();

        assertThat(wrapperObject.getName()).isEqualTo("Foo #0");
        assertThat(wrapperObject.getSomeByteWrapperMandatory()).isEqualTo((byte) 99);
        assertThat(wrapperObject.getSomeShortWrapperMandatory()).isEqualTo((short) 654);
        assertThat(wrapperObject.getSomeIntegerWrapperMandatory()).isEqualTo(987);
        assertThat(wrapperObject.getSomeLongWrapperMandatory()).isEqualTo(9876543210L);
        assertThat(wrapperObject.getSomeFloatWrapperMandatory()).isEqualTo(321.5F);
        assertThat(wrapperObject.getSomeDoubleWrapperMandatory()).isEqualTo(654.5);

        assertThat(wrapperObject.getSomeByteWrapperOptional()).isNull();
        assertThat(wrapperObject.getSomeShortWrapperOptional()).isNull();
        assertThat(wrapperObject.getSomeIntegerWrapperOptional()).isNull();
        assertThat(wrapperObject.getSomeLongWrapperOptional()).isNull();
        assertThat(wrapperObject.getSomeFloatWrapperOptional()).isNull();
        assertThat(wrapperObject.getSomeDoubleWrapperOptional()).isNull();

    }

}