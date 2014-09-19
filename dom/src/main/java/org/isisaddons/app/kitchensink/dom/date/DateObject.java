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

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("DATE")
@Bookmarkable
public class DateObject implements Entity<DateObject> {

    //region > name (property)

    private String name;

    @Column(allowsNull="false")
    @Title(sequence="1")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //endregion

    //region > someJavaUtilDateMandatory (property)
    private java.util.Date someJavaUtilDateMandatory;

    @Column(allowsNull = "false")
    public java.util.Date getSomeJavaUtilDateMandatory() {
        return someJavaUtilDateMandatory;
    }

    public void setSomeJavaUtilDateMandatory(final java.util.Date someJavaUtilDateMandatory) {
        this.someJavaUtilDateMandatory = someJavaUtilDateMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateMandatory(final java.util.Date i) {
        setSomeJavaUtilDateMandatory(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateMandatory() {
        return getSomeJavaUtilDateMandatory();
    }
    //endregion

    //region > someJavaUtilDateOptional (property)
    private java.util.Date someJavaUtilDateOptional;

    @Column(allowsNull = "true")
    public java.util.Date getSomeJavaUtilDateOptional() {
        return someJavaUtilDateOptional;
    }

    public void setSomeJavaUtilDateOptional(final java.util.Date someJavaUtilDateOptional) {
        this.someJavaUtilDateOptional = someJavaUtilDateOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateOptional(final @Optional java.util.Date i) {
        setSomeJavaUtilDateOptional(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateOptional() {
        return getSomeJavaUtilDateOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJavaUtilDateOptional() {
        setSomeJavaUtilDateOptional(null);
        return this;
    }
    //endregion

    //region > someJavaUtilDateWithChoices (property)
    private java.util.Date someJavaUtilDateWithChoices;

    @Column(allowsNull = "true")
    public java.util.Date getSomeJavaUtilDateWithChoices() {
        return someJavaUtilDateWithChoices;
    }

    public void setSomeJavaUtilDateWithChoices(final java.util.Date someJavaUtilDateWithChoices) {
        this.someJavaUtilDateWithChoices = someJavaUtilDateWithChoices;
    }

    public Collection<java.util.Date> choicesSomeJavaUtilDateWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVAUTILDATE);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateWithChoices(final @Optional java.util.Date i) {
        setSomeJavaUtilDateWithChoices(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateWithChoices() {
        return getSomeJavaUtilDateWithChoices();
    }

    public List<java.util.Date> choices0UpdateSomeJavaUtilDateWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVAUTILDATE);
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJavaUtilDateWithChoices() {
        setSomeJavaUtilDateWithChoices(null);
        return this;
    }
    //endregion


    //region > someJavaSqlDateMandatory (property)
    private java.sql.Date someJavaSqlDateMandatory;

    @Column(allowsNull = "false")
    public java.sql.Date getSomeJavaSqlDateMandatory() {
        return someJavaSqlDateMandatory;
    }

    public void setSomeJavaSqlDateMandatory(final java.sql.Date someJavaSqlDateMandatory) {
        this.someJavaSqlDateMandatory = someJavaSqlDateMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateMandatory(final java.sql.Date i) {
        setSomeJavaSqlDateMandatory(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateMandatory() {
        return getSomeJavaSqlDateMandatory();
    }
    //endregion

    //region > someJavaSqlDateOptional (property)
    private java.sql.Date someJavaSqlDateOptional;

    @Column(allowsNull = "true")
    public java.sql.Date getSomeJavaSqlDateOptional() {
        return someJavaSqlDateOptional;
    }

    public void setSomeJavaSqlDateOptional(final java.sql.Date someJavaSqlDateOptional) {
        this.someJavaSqlDateOptional = someJavaSqlDateOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateOptional(final @Optional java.sql.Date i) {
        setSomeJavaSqlDateOptional(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateOptional() {
        return getSomeJavaSqlDateOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJavaSqlDateOptional() {
        setSomeJavaSqlDateOptional(null);
        return this;
    }
    //endregion

    //region > someJavaSqlDateWithChoices (property)
    private java.sql.Date someJavaSqlDateWithChoices;

    @Column(allowsNull = "true")
    public java.sql.Date getSomeJavaSqlDateWithChoices() {
        return someJavaSqlDateWithChoices;
    }

    public void setSomeJavaSqlDateWithChoices(final java.sql.Date someJavaSqlDateWithChoices) {
        this.someJavaSqlDateWithChoices = someJavaSqlDateWithChoices;
    }

    public Collection<java.sql.Date> choicesSomeJavaSqlDateWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLDATE);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateWithChoices(final @Optional java.sql.Date i) {
        setSomeJavaSqlDateWithChoices(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateWithChoices() {
        return getSomeJavaSqlDateWithChoices();
    }

    public List<java.sql.Date> choices0UpdateSomeJavaSqlDateWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLDATE);
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJavaSqlDateWithChoices() {
        setSomeJavaSqlDateWithChoices(null);
        return this;
    }
    //endregion


    //region > someJavaSqlTimestampMandatory (property)
    private java.sql.Timestamp someJavaSqlTimestampMandatory;

    @Column(allowsNull = "false")
    public java.sql.Timestamp getSomeJavaSqlTimestampMandatory() {
        return someJavaSqlTimestampMandatory;
    }

    public void setSomeJavaSqlTimestampMandatory(final java.sql.Timestamp someJavaSqlTimestampMandatory) {
        this.someJavaSqlTimestampMandatory = someJavaSqlTimestampMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampMandatory(final java.sql.Timestamp i) {
        setSomeJavaSqlTimestampMandatory(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampMandatory() {
        return getSomeJavaSqlTimestampMandatory();
    }
    //endregion

    //region > someJavaSqlTimestampOptional (property)
    private java.sql.Timestamp someJavaSqlTimestampOptional;

    @Column(allowsNull = "true")
    public java.sql.Timestamp getSomeJavaSqlTimestampOptional() {
        return someJavaSqlTimestampOptional;
    }

    public void setSomeJavaSqlTimestampOptional(final java.sql.Timestamp someJavaSqlTimestampOptional) {
        this.someJavaSqlTimestampOptional = someJavaSqlTimestampOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampOptional(final @Optional java.sql.Timestamp i) {
        setSomeJavaSqlTimestampOptional(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampOptional() {
        return getSomeJavaSqlTimestampOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJavaSqlTimestampOptional() {
        setSomeJavaSqlTimestampOptional(null);
        return this;
    }
    //endregion

    //region > someJavaSqlTimestampWithChoices (property)
    private java.sql.Timestamp someJavaSqlTimestampWithChoices;

    @Column(allowsNull = "true")
    public java.sql.Timestamp getSomeJavaSqlTimestampWithChoices() {
        return someJavaSqlTimestampWithChoices;
    }

    public void setSomeJavaSqlTimestampWithChoices(final java.sql.Timestamp someJavaSqlTimestampWithChoices) {
        this.someJavaSqlTimestampWithChoices = someJavaSqlTimestampWithChoices;
    }

    public Collection<java.sql.Timestamp> choicesSomeJavaSqlTimestampWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLTIMESTAMP);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampWithChoices(final @Optional java.sql.Timestamp i) {
        setSomeJavaSqlTimestampWithChoices(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampWithChoices() {
        return getSomeJavaSqlTimestampWithChoices();
    }

    public List<java.sql.Timestamp> choices0UpdateSomeJavaSqlTimestampWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLTIMESTAMP);
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJavaSqlTimestampWithChoices() {
        setSomeJavaSqlTimestampWithChoices(null);
        return this;
    }
    //endregion


    //region > someJodaDateTimeMandatory (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    private org.joda.time.DateTime someJodaDateTimeMandatory;

    @Column(allowsNull = "false")
    public org.joda.time.DateTime getSomeJodaDateTimeMandatory() {
        return someJodaDateTimeMandatory;
    }

    public void setSomeJodaDateTimeMandatory(final org.joda.time.DateTime someJodaDateTimeMandatory) {
        this.someJodaDateTimeMandatory = someJodaDateTimeMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeMandatory(final org.joda.time.DateTime i) {
        setSomeJodaDateTimeMandatory(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeMandatory() {
        return getSomeJodaDateTimeMandatory();
    }
    //endregion

    //region > someJodaDateTimeOptional (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    private org.joda.time.DateTime someJodaDateTimeOptional;

    @Column(allowsNull = "true")
    public org.joda.time.DateTime getSomeJodaDateTimeOptional() {
        return someJodaDateTimeOptional;
    }

    public void setSomeJodaDateTimeOptional(final org.joda.time.DateTime someJodaDateTimeOptional) {
        this.someJodaDateTimeOptional = someJodaDateTimeOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeOptional(final @Optional org.joda.time.DateTime i) {
        setSomeJodaDateTimeOptional(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeOptional() {
        return getSomeJodaDateTimeOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJodaDateTimeOptional() {
        setSomeJodaDateTimeOptional(null);
        return this;
    }
    //endregion

    //region > someJodaDateTimeWithChoices (property)
    private org.joda.time.DateTime someJodaDateTimeWithChoices;

    @Column(allowsNull = "true")
    public org.joda.time.DateTime getSomeJodaDateTimeWithChoices() {
        return someJodaDateTimeWithChoices;
    }

    public void setSomeJodaDateTimeWithChoices(final org.joda.time.DateTime someJodaDateTimeWithChoices) {
        this.someJodaDateTimeWithChoices = someJodaDateTimeWithChoices;
    }

    public Collection<org.joda.time.DateTime> choicesSomeJodaDateTimeWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_DATETIME);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeWithChoices(final @Optional org.joda.time.DateTime i) {
        setSomeJodaDateTimeWithChoices(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeWithChoices() {
        return getSomeJodaDateTimeWithChoices();
    }

    public List<org.joda.time.DateTime> choices0UpdateSomeJodaDateTimeWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_DATETIME);
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJodaDateTimeWithChoices() {
        setSomeJodaDateTimeWithChoices(null);
        return this;
    }
    //endregion


    //region > someJodaLocalDateMandatory (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    private org.joda.time.LocalDate someJodaLocalDateMandatory;

    @Column(allowsNull = "false")
    public org.joda.time.LocalDate getSomeJodaLocalDateMandatory() {
        return someJodaLocalDateMandatory;
    }

    public void setSomeJodaLocalDateMandatory(final org.joda.time.LocalDate someJodaLocalDateMandatory) {
        this.someJodaLocalDateMandatory = someJodaLocalDateMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateMandatory(final org.joda.time.LocalDate i) {
        setSomeJodaLocalDateMandatory(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateMandatory() {
        return getSomeJodaLocalDateMandatory();
    }
    //endregion

    //region > someJodaLocalDateOptional (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    private org.joda.time.LocalDate someJodaLocalDateOptional;

    @Column(allowsNull = "true")
    public org.joda.time.LocalDate getSomeJodaLocalDateOptional() {
        return someJodaLocalDateOptional;
    }

    public void setSomeJodaLocalDateOptional(final org.joda.time.LocalDate someJodaLocalDateOptional) {
        this.someJodaLocalDateOptional = someJodaLocalDateOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateOptional(final @Optional org.joda.time.LocalDate i) {
        setSomeJodaLocalDateOptional(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateOptional() {
        return getSomeJodaLocalDateOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateOptional() {
        setSomeJodaLocalDateOptional(null);
        return this;
    }
    //endregion

    //region > someJodaLocalDateWithChoices (property)
    private org.joda.time.LocalDate someJodaLocalDateWithChoices;

    @Column(allowsNull = "true")
    public org.joda.time.LocalDate getSomeJodaLocalDateWithChoices() {
        return someJodaLocalDateWithChoices;
    }

    public void setSomeJodaLocalDateWithChoices(final org.joda.time.LocalDate someJodaLocalDateWithChoices) {
        this.someJodaLocalDateWithChoices = someJodaLocalDateWithChoices;
    }

    public Collection<org.joda.time.LocalDate> choicesSomeJodaLocalDateWithChoices() {
        return nextFewDays(4, Functions.<LocalDate>identity());
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateWithChoices(final @Optional org.joda.time.LocalDate i) {
        setSomeJodaLocalDateWithChoices(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateWithChoices() {
        return getSomeJodaLocalDateWithChoices();
    }

    public List<org.joda.time.LocalDate> choices0UpdateSomeJodaLocalDateWithChoices() {
        return nextFewDays(4, Functions.<LocalDate>identity());
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateWithChoices() {
        setSomeJodaLocalDateWithChoices(null);
        return this;
    }
    //endregion



    //region > someJodaLocalDateTimeMandatory (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    private org.joda.time.LocalDateTime someJodaLocalDateTimeMandatory;

    @Column(allowsNull = "false")
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeMandatory() {
        return someJodaLocalDateTimeMandatory;
    }

    public void setSomeJodaLocalDateTimeMandatory(final org.joda.time.LocalDateTime someJodaLocalDateTimeMandatory) {
        this.someJodaLocalDateTimeMandatory = someJodaLocalDateTimeMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateTimeMandatory(final org.joda.time.LocalDateTime i) {
        setSomeJodaLocalDateTimeMandatory(i);
        return this;
    }
    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeMandatory() {
        return getSomeJodaLocalDateTimeMandatory();
    }
    //endregion

    //region > someJodaLocalDateTimeOptional (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    private org.joda.time.LocalDateTime someJodaLocalDateTimeOptional;

    @Column(allowsNull = "true")
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeOptional() {
        return someJodaLocalDateTimeOptional;
    }

    public void setSomeJodaLocalDateTimeOptional(final org.joda.time.LocalDateTime someJodaLocalDateTimeOptional) {
        this.someJodaLocalDateTimeOptional = someJodaLocalDateTimeOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateTimeOptional(final @Optional org.joda.time.LocalDateTime i) {
        setSomeJodaLocalDateTimeOptional(i);
        return this;
    }
    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeOptional() {
        return getSomeJodaLocalDateTimeOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateTimeOptional() {
        setSomeJodaLocalDateTimeOptional(null);
        return this;
    }
    //endregion


    //
    // throwing an exception... looks like issue in Isis core.
    //

//    //region > someJodaLocalDateTimeWithChoices (property)
//    private org.joda.time.LocalDateTime someJodaLocalDateTimeWithChoices;
//
//    @Column(allowsNull = "true")
//    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeWithChoices() {
//        return someJodaLocalDateTimeWithChoices;
//    }
//
//    public void setSomeJodaLocalDateTimeWithChoices(final org.joda.time.LocalDateTime someJodaLocalDateTimeWithChoices) {
//        this.someJodaLocalDateTimeWithChoices = someJodaLocalDateTimeWithChoices;
//    }
//
//    public Collection<org.joda.time.LocalDateTime> choicesSomeJodaLocalDateTimeWithChoices() {
//        return nextFewDays(4, localDateWithTime(new LocalTime()));
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject updateSomeJodaLocalDateTimeWithChoices(final @Optional org.joda.time.LocalDateTime i) {
//        setSomeJodaLocalDateTimeWithChoices(i);
//        return this;
//    }
//    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeWithChoices() {
//        return getSomeJodaLocalDateTimeWithChoices();
//    }
//
//    public List<org.joda.time.LocalDateTime> choices0UpdateSomeJodaLocalDateTimeWithChoices() {
//        return nextFewDays(4, localDateWithTime(new LocalTime()));
//    }
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject resetSomeJodaLocalDateTimeWithChoices() {
//        setSomeJodaLocalDateTimeWithChoices(null);
//        return this;
//    }
//    //endregion


    //
    // the applib datetime/date classes are commented out because they haven't been mapped to the DataNucleus objectstore,
    // and will almost certainly remove in Isis 2.0
    //


//    //region > someApplibDateTimeMandatory (property)
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    private org.apache.isis.applib.value.DateTime someApplibDateTimeMandatory;
//
//    @Column(allowsNull = "false")
//    public org.apache.isis.applib.value.DateTime getSomeApplibDateTimeMandatory() {
//        return someApplibDateTimeMandatory;
//    }
//
//    public void setSomeApplibDateTimeMandatory(final org.apache.isis.applib.value.DateTime someApplibDateTimeMandatory) {
//        this.someApplibDateTimeMandatory = someApplibDateTimeMandatory;
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject updateSomeApplibDateTimeMandatory(final org.apache.isis.applib.value.DateTime i) {
//        setSomeApplibDateTimeMandatory(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.DateTime default0UpdateSomeApplibDateTimeMandatory() {
//        return getSomeApplibDateTimeMandatory();
//    }
//    //endregion
//
//    //region > someApplibDateTimeOptional (property)
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    private org.apache.isis.applib.value.DateTime someApplibDateTimeOptional;
//
//    @Column(allowsNull = "true")
//    public org.apache.isis.applib.value.DateTime getSomeApplibDateTimeOptional() {
//        return someApplibDateTimeOptional;
//    }
//
//    public void setSomeApplibDateTimeOptional(final org.apache.isis.applib.value.DateTime someApplibDateTimeOptional) {
//        this.someApplibDateTimeOptional = someApplibDateTimeOptional;
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject updateSomeApplibDateTimeOptional(final @Optional org.apache.isis.applib.value.DateTime i) {
//        setSomeApplibDateTimeOptional(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.DateTime default0UpdateSomeApplibDateTimeOptional() {
//        return getSomeApplibDateTimeOptional();
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject resetSomeApplibDateTimeOptional() {
//        setSomeApplibDateTimeOptional(null);
//        return this;
//    }
//    //endregion
//
//    //region > someApplibDateMandatory (property)
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    private org.apache.isis.applib.value.Date someApplibDateMandatory;
//
//    @Column(allowsNull = "false")
//    public org.apache.isis.applib.value.Date getSomeApplibDateMandatory() {
//        return someApplibDateMandatory;
//    }
//
//    public void setSomeApplibDateMandatory(final org.apache.isis.applib.value.Date someApplibDateMandatory) {
//        this.someApplibDateMandatory = someApplibDateMandatory;
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject updateSomeApplibDateMandatory(final org.apache.isis.applib.value.Date i) {
//        setSomeApplibDateMandatory(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.Date default0UpdateSomeApplibDateMandatory() {
//        return getSomeApplibDateMandatory();
//    }
//    //endregion
//
//    //region > someApplibDateOptional (property)
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    private org.apache.isis.applib.value.Date someApplibDateOptional;
//
//    @Column(allowsNull = "true")
//    public org.apache.isis.applib.value.Date getSomeApplibDateOptional() {
//        return someApplibDateOptional;
//    }
//
//    public void setSomeApplibDateOptional(final org.apache.isis.applib.value.Date someApplibDateOptional) {
//        this.someApplibDateOptional = someApplibDateOptional;
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject updateSomeApplibDateOptional(final @Optional org.apache.isis.applib.value.Date i) {
//        setSomeApplibDateOptional(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.Date default0UpdateSomeApplibDateOptional() {
//        return getSomeApplibDateOptional();
//    }
//
//    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
//    public DateObject resetSomeApplibDateOptional() {
//        setSomeApplibDateOptional(null);
//        return this;
//    }
//    //endregion


    //region > compareTo

    @Override
    public int compareTo(DateObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion


    //region > helpers

    private static final Function<LocalDate, org.joda.time.LocalDateTime> localDateWithTime(final LocalTime localTime) {
        return new Function<LocalDate, org.joda.time.LocalDateTime>() {
            @Override
            public org.joda.time.LocalDateTime apply(LocalDate input) {
                return input.toLocalDateTime(localTime);
            }
        };
    };

    private static final Function<LocalDate, org.joda.time.DateTime> LOCALDATE_AS_DATETIME = new Function<LocalDate, org.joda.time.DateTime>() {
        @Override
        public org.joda.time.DateTime apply(LocalDate input) {
            return input.toDateTimeAtStartOfDay();
        }
    };

    private static final Function<org.joda.time.DateTime, java.util.Date> DATETIME_AS_JAVAUTILDATE = new Function<org.joda.time.DateTime, java.util.Date>() {
        @Override
        public java.util.Date apply(org.joda.time.DateTime input) {
            return input.toDate();
        }
    };

    private static final Function<LocalDate, java.util.Date> LOCALDATE_AS_JAVAUTILDATE =
            Functions.compose(DATETIME_AS_JAVAUTILDATE, LOCALDATE_AS_DATETIME);

    private static final Function<java.util.Date, java.sql.Date> JAVAUTILDATE_AS_JAVASQLDATE = new Function<java.util.Date, java.sql.Date>() {
        @Override
        public java.sql.Date apply(java.util.Date input) {
            return new java.sql.Date(input.getTime());
        }
    };

    private static final Function<java.util.Date, java.sql.Timestamp> JAVAUTILDATE_AS_JAVASQTIMESTAMP = new Function<java.util.Date, java.sql.Timestamp>() {
        @Override
        public java.sql.Timestamp apply(java.util.Date input) {
            return new java.sql.Timestamp(input.getTime());
        }
    };

    private static final Function<LocalDate, java.sql.Date> LOCALDATE_AS_JAVASQLDATE = Functions.compose(JAVAUTILDATE_AS_JAVASQLDATE, LOCALDATE_AS_JAVAUTILDATE);
    private static final Function<LocalDate, java.sql.Timestamp> LOCALDATE_AS_JAVASQLTIMESTAMP = Functions.compose(JAVAUTILDATE_AS_JAVASQTIMESTAMP, LOCALDATE_AS_JAVAUTILDATE);

    private <T> List<T> nextFewDays(int numDays, Function<LocalDate, T> function) {
        return Lists.newArrayList(
                Iterables.transform(
                        nextFewDays(numDays),
                        function));
    }

    private List<LocalDate> nextFewDays(int numDays) {
        return daysFrom(clockService.now(), numDays);
    }

    private static List<LocalDate> daysFrom(LocalDate localDate, int numDays) {
        List<LocalDate> dates = Lists.newArrayList();
        for (int i = 0; i < numDays; i++) {
            dates.add(localDate.plusDays(i+1));
        }
        return dates;
    }

    //endregion


    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;
    @javax.inject.Inject
    @SuppressWarnings("unused")
    private ClockService clockService;

    //endregion

}
