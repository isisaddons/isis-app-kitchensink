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
package org.isisaddons.app.kitchensink.integtests.modules.primitive;

import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.primitive.PrimitiveObject;
import org.isisaddons.app.kitchensink.dom.primitive.PrimitiveObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.primitive.PrimitiveObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import static org.assertj.core.api.Assertions.assertThat;

public class PrimitiveObjectIntegTest extends KitchensinkAppIntegTest {

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
    public void persist_then_update() throws Exception {

        // given, when
        fixtureScripts.runFixtureScript(new PrimitiveObjectsFixture() {{
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
        PrimitiveObject primitiveObject = primitiveObjects.first();

        assertThat(primitiveObject.getName()).isEqualTo("Foo #0");
        assertThat(primitiveObject.getSomeByte()).isEqualTo((byte)123);
        assertThat(primitiveObject.getSomeShort()).isEqualTo((short)456);
        assertThat(primitiveObject.getSomeInt()).isEqualTo(789);
        assertThat(primitiveObject.getSomeLong()).isEqualTo(1234567890L);
        assertThat(primitiveObject.getSomeFloat()).isEqualTo(123.5F);
        assertThat(primitiveObject.getSomeDouble()).isEqualTo(456.5);

        // when
        primitiveObject.updateSomeByte((byte) 99);
        primitiveObject.updateSomeShort((short) 654);
        primitiveObject.updateSomeInt(987);
        primitiveObject.updateSomeLong(9876543210L);
        primitiveObject.updateSomeFloat(321.5F);
        primitiveObject.updateSomeDouble(654.5);

        nextSession();

        // then
        primitiveObject = primitiveObjects.first();

        assertThat(primitiveObject.getName()).isEqualTo("Foo #0");
        assertThat(primitiveObject.getSomeByte()).isEqualTo((byte)99);
        assertThat(primitiveObject.getSomeShort()).isEqualTo((short)654);
        assertThat(primitiveObject.getSomeInt()).isEqualTo(987);
        assertThat(primitiveObject.getSomeLong()).isEqualTo(9876543210L);
        assertThat(primitiveObject.getSomeFloat()).isEqualTo(321.5F);
        assertThat(primitiveObject.getSomeDouble()).isEqualTo(654.5);

    }

}