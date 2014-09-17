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

package com.danhaywood.isis.kitchensink.fixture.date;

import com.danhaywood.isis.kitchensink.dom.date.DateObject;
import com.danhaywood.isis.kitchensink.dom.date.DateObjects;
import org.joda.time.DateTime;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.clock.ClockService;

public class DateObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        final DateTime dt = clockService.nowAsDateTime().withHourOfDay(10).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0);
        final DateTime dt2 = dt.plusDays(1).plusHours(1).plusMinutes(5);
        final DateTime dt3 = dt2.plusDays(1).plusHours(1).plusMinutes(5);
        create("Foo", executionContext, dt);
        create("Bar", executionContext, dt2);
        create("Baz", executionContext, dt3);
    }

    private DateObject create(final String name, ExecutionContext executionContext, DateTime dt) {
        return executionContext.add(this, dateObjects.create(name, dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), dt.getMinuteOfHour()));
    }

    @javax.inject.Inject
    private DateObjects dateObjects;

    @javax.inject.Inject
    private ClockService clockService;

}
