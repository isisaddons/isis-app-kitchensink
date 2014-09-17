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
package com.danhaywood.isis.kitchensink.dom.date;

import java.sql.Timestamp;
import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

@Named("Date")
@DomainService(menuOrder = "10", repositoryFor = DateObject.class)
public class DateObjects {

    //region > identification in the UI

    public String getId() {
        return "date";
    }

    public String iconName() {
        return "DateObject";
    }

    //endregion

    //region > listAll (action)

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<DateObject> listAll() {
        return container.allInstances(DateObject.class);
    }

    //endregion

    //region > create (action)

    @MemberOrder(sequence = "2")
    public DateObject create(
            final @Named("Name") String name,
            final @Named("Year") int year,
            final @Named("Month") int month,
            final @Named("Day") int day,
            final @Named("Hour") int hour,
            final @Named("Minutes") int minutes) {
        final DateObject obj = container.newTransientInstance(DateObject.class);
        obj.setName(name);

        final org.joda.time.DateTime dt = new org.joda.time.DateTime(year, month, day, hour, minutes);
        final org.joda.time.LocalDateTime ldt = new org.joda.time.LocalDateTime(year, month, day, hour, minutes);
        final org.joda.time.LocalDate ld = new org.joda.time.LocalDate(year, month, day);

        obj.setSomeJavaUtilDateMandatory(dt.toDate());
        obj.setSomeJavaSqlDateMandatory(new java.sql.Date(dt.toDate().getTime()));
        obj.setSomeJavaSqlTimestampMandatory(new Timestamp(dt.toDate().getTime()));

        obj.setSomeJodaDateTimeMandatory(dt);
        obj.setSomeJodaLocalDateTimeMandatory(ldt);
        obj.setSomeJodaLocalDateMandatory(ld);

//        obj.setSomeApplibDateMandatory(new Date(ld.toDate()));
//        obj.setSomeApplibDateTimeMandatory(new DateTime(ldt.toDateTime()));

        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
