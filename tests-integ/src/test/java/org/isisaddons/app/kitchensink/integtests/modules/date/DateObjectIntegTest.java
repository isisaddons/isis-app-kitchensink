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
package org.isisaddons.app.kitchensink.integtests.modules.date;

import java.sql.Date;
import java.sql.Timestamp;
import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.date.DateObject;
import org.isisaddons.app.kitchensink.dom.date.DateObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.date.DateObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import static org.assertj.core.api.Assertions.assertThat;

public class DateObjectIntegTest extends KitchensinkAppIntegTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    DateObjects dateObjects;


    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
    }

    @Test
    public void persist_then_update() throws Exception {

        // the kitchensink DateObjects service only persists to nearest minute
        DateTime dateTime = new DateTime(2014, 1,1,10,45,0,0, DateTimeZone.getDefault());

        final DateTime dt = dateTime;

        // given, when
        fixtureScripts.runFixtureScript(new DateObjectsFixture() {{
            setNumberToCreate(1);
            setName("Foo");
            setDateTime(dt);
        }}, null);

        nextSession();

        // then
        DateObject dateObject = dateObjects.first();

        assertThat(dateObject.getName()).isEqualTo("Foo #0");
        assertThat(dateObject.getSomeJavaSqlDateMandatory()).isEqualTo(asJavaSqlDate(dateTime));
        assertThat(dateObject.getSomeJavaUtilDateMandatory()).isEqualTo(asJavaUtilDate(dateTime));
        assertThat(dateObject.getSomeJodaDateTimeMandatory()).isEqualTo(dateTime);
        assertThat(dateObject.getSomeJodaLocalDateMandatory()).isEqualTo(asJodaLocalDate(dateTime));
        assertThat(dateObject.getSomeJavaSqlTimestampMandatory()).isEqualTo(asJavaSqlTimestamp(dateTime));
        //assertThat(dateObject.getSomeJodaLocalDateTimeMandatory()).isEqualTo(dateTime.toLocalDateTime());

        // when
        dateTime = dateTime.plusDays(1).plusHours(1).plusMinutes(5);

        dateObject.updateSomeJavaSqlDateMandatory(asJavaSqlDate(dateTime));
        dateObject.updateSomeJavaUtilDateMandatory(asJavaUtilDate(dateTime));
        dateObject.updateSomeJodaDateTimeMandatory(dateTime);
        dateObject.updateSomeJodaLocalDateMandatory(asJodaLocalDate(dateTime));
        dateObject.updateSomeJavaSqlTimestampMandatory(asJavaSqlTimestamp(dateTime));
//        dateObject.updateSomeJodaLocalDateTimeMandatory(dateTime.toLocalDateTime());

        dateObject.updateSomeJavaSqlDateOptional(null);
        dateObject.updateSomeJavaUtilDateOptional(null);
        dateObject.updateSomeJodaDateTimeOptional(null);
        dateObject.updateSomeJodaLocalDateOptional(null);
        dateObject.updateSomeJavaSqlTimestampOptional(null);
//        dateObject.updateSomeJodaLocalDateTimeOptional(null);

        nextSession();

        // then
        dateObject = dateObjects.first();

        assertThat(dateObject.getSomeJavaSqlDateMandatory()).isEqualTo(asJavaSqlDate(dateTime));
        assertThat(dateObject.getSomeJavaUtilDateMandatory()).isEqualTo(asJavaUtilDate(dateTime));
        assertThat(dateObject.getSomeJodaDateTimeMandatory()).isEqualTo(dateTime);
        assertThat(dateObject.getSomeJodaLocalDateMandatory()).isEqualTo(asJodaLocalDate(dateTime));
        assertThat(dateObject.getSomeJavaSqlTimestampMandatory()).isEqualTo(asJavaSqlTimestamp(dateTime));
        //assertThat(dateObject.getSomeJodaLocalDateTimeMandatory()).isEqualTo(dateTime.toLocalDateTime());

        assertThat(dateObject.getSomeJavaSqlDateOptional()).isNull();
        assertThat(dateObject.getSomeJavaUtilDateOptional()).isNull();
        assertThat(dateObject.getSomeJodaDateTimeOptional()).isNull();
        assertThat(dateObject.getSomeJodaLocalDateOptional()).isNull();
        assertThat(dateObject.getSomeJavaSqlTimestampOptional()).isNull();
        //assertThat(dateObject.getSomeJodaLocalDateTimeOptional()).isNull();

    }

    private static LocalDate asJodaLocalDate(final DateTime dateTime) {
        return dateTime.toLocalDate();
    }

    private static java.util.Date asJavaUtilDate(final DateTime dateTime) {
        return dateTime.toDate();
    }

    private static Timestamp asJavaSqlTimestamp(final DateTime dateTime) {
        return new Timestamp(dateTime.toDate().getTime());
    }

    private static Date asJavaSqlDate(final DateTime dateTime) {
        return new Date(dateTime.withTimeAtStartOfDay().toDate().getTime());
    }

}