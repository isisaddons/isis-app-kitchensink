/*
 *  Copyright 2014 Dan Haywood
 *
 *  Licensed under the Apache License, Version 2.0 (the
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
package org.isisaddons.app.kitchensink.fixture.date;

import java.util.List;
import javax.inject.Inject;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.date.DateObject;
import org.isisaddons.app.kitchensink.dom.date.DateObjects;
import org.isisaddons.module.fakedata.dom.FakeDataService;
import org.joda.time.DateTime;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.services.clock.ClockService;

public class DateObjectsFixture extends FixtureScript {

    //region > numberToCreate
    private Integer numberToCreate;

    /**
     * Defaults to 3
     */
    public Integer getNumberToCreate() {
        return numberToCreate;
    }

    public void setNumberToCreate(final Integer numberToCreate) {
        this.numberToCreate = numberToCreate;
    }
    //endregion


    //region > name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    //endregion


    //region > dateTime (input property)
    private DateTime dateTime;
    public DateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(final DateTime dateTime) {
        this.dateTime = dateTime;
    }
    //endregion


    //region > objects (output)
    private final List<DateObject> objects = Lists.newArrayList();

    public List<DateObject> getObjects() {
        return objects;
    }
    //endregion


    @Override
    protected void execute(final ExecutionContext ec) {

        defaultParam("numberToCreate", ec, 3);

        defaultParam("name", ec, fake.lorem().words(1));
        defaultParam("dateTime", ec, clockService.nowAsDateTime().withHourOfDay(10).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0));

        // create
        final DateTime dt2 = getDateTime().plusDays(1).plusHours(1).plusMinutes(5);
        final DateTime dt3 = dt2.plusDays(1).plusHours(1).plusMinutes(5);

        DateTime dt = getDateTime();
        for (int k = 0; k < getNumberToCreate(); k++) {
            final String str = getName() + " #" + k;

            create(str, dt, ec);

            dt = dt.plusDays(1).plusHours(1).plusMinutes(5).plusSeconds(15);
        }
    }

    private DateObject create(final String name, final DateTime dt, final ExecutionContext ec) {
        final DateObject dateObject =
                dateObjects.createDateObject(name, dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), dt.getMinuteOfHour());

        objects.add(dateObject);

        return ec.addResult(this, dateObject);
    }

    @javax.inject.Inject
    private DateObjects dateObjects;

    @javax.inject.Inject
    private ClockService clockService;

    @Inject
    FakeDataService fake;

}
