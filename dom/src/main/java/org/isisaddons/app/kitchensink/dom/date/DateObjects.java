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
package org.isisaddons.app.kitchensink.dom.date;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;

@DomainService(menuOrder = "10.5", repositoryFor = DateObject.class)
@DomainServiceLayout(named="Data Types")
public class DateObjects extends RepositoryAbstract<DateObject> {

    public DateObjects() {
        super(DateObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public DateObject createDateObject(
            final @ParameterLayout(named="Name") String name,
            final @ParameterLayout(named="Year") int year,
            final @ParameterLayout(named="Month") int month,
            final @ParameterLayout(named="Day") int day,
            final @ParameterLayout(named="Hour") int hour,
            final @ParameterLayout(named="Minutes") int minutes) {
        final DateObject obj = container.newTransientInstance(DateObject.class);
        obj.setName(name);

        final org.joda.time.DateTime dt = new org.joda.time.DateTime(year, month, day, hour, minutes);
        final org.joda.time.LocalDateTime ldt = new org.joda.time.LocalDateTime(year, month, day, hour, minutes);
        final org.joda.time.LocalDate ld = new org.joda.time.LocalDate(year, month, day);
        final java.util.Date jud = dt.toDate();
        final Date sqldt = new Date(jud.getTime());
        final Timestamp ts = new Timestamp(jud.getTime());

        obj.setSomeJavaUtilDateMandatory(jud);
        obj.setSomeJavaUtilDateOptional(jud);
        obj.setSomeJavaUtilDateHidden(jud);
        obj.setSomeJavaUtilDateDisabled(jud);
        obj.setSomeJavaUtilDateWithValidation(jud);
        obj.setSomeJavaUtilDateMandatoryWithChoices(jud);
        obj.setSomeJavaUtilDateOptionalWithChoices(jud);

        obj.setSomeJavaSqlDateMandatory(sqldt);
        obj.setSomeJavaSqlDateOptional(sqldt);
        obj.setSomeJavaSqlDateHidden(sqldt);
        obj.setSomeJavaSqlDateDisabled(sqldt);
        obj.setSomeJavaSqlDateWithValidation(sqldt);
        obj.setSomeJavaSqlDateMandatoryWithChoices(sqldt);
        obj.setSomeJavaSqlDateOptionalWithChoices(sqldt);

        obj.setSomeJavaSqlTimestampMandatory(ts);
        obj.setSomeJavaSqlTimestampOptional(ts);
        obj.setSomeJavaSqlTimestampHidden(ts);
        obj.setSomeJavaSqlTimestampDisabled(ts);
        obj.setSomeJavaSqlTimestampWithValidation(ts);
        obj.setSomeJavaSqlTimestampMandatoryWithChoices(ts);
        obj.setSomeJavaSqlTimestampOptionalWithChoices(ts);

        obj.setSomeJodaDateTimeMandatory(dt);
        obj.setSomeJodaDateTimeOptional(dt);
        obj.setSomeJodaDateTimeHidden(dt);
        obj.setSomeJodaDateTimeDisabled(dt);
        obj.setSomeJodaDateTimeWithValidation(dt);
        obj.setSomeJodaDateTimeMandatoryWithChoices(dt);
        obj.setSomeJodaDateTimeOptionalWithChoices(dt);

//        obj.setSomeJodaLocalDateTimeMandatory(ldt);
//        obj.setSomeJodaLocalDateTimeOptional(ldt);
//        obj.setSomeJodaLocalDateTimeHidden(ldt);
//        obj.setSomeJodaLocalDateTimeDisabled(ldt);
//        obj.setSomeJodaLocalDateTimeWithValidation(ldt);
//        obj.setSomeJodaLocalDateTimeMandatoryWithChoices(ldt);
//        obj.setSomeJodaLocalDateTimeOptionalWithChoices(ldt);

        obj.setSomeJodaLocalDateMandatory(ld);
        obj.setSomeJodaLocalDateOptional(ld);
        obj.setSomeJodaLocalDateHidden(ld);
        obj.setSomeJodaLocalDateDisabled(ld);
        obj.setSomeJodaLocalDateWithValidation(ld);
        obj.setSomeJodaLocalDateMandatoryWithChoices(ld);
        obj.setSomeJodaLocalDateOptionalWithChoices(ld);

//        obj.setSomeApplibDateMandatory(new Date(ld.toDate()));
//        obj.setSomeApplibDateTimeMandatory(new DateTime(ldt.toDateTime()));

        container.persistIfNotAlready(obj);
        return obj;
    }

    @ActionLayout(named="First DateObject")
    @Override
    public DateObject first() {
        return super.first();
    }

    @ActionLayout(named="List All DateObjects")
    @Override
    public List<DateObject> listAll() {
        return super.listAll();
    }

}
