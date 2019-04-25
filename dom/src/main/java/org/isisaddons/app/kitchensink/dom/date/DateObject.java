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
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.base.AbstractInstant;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.services.clock.ClockService;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;

import lombok.Getter;
import lombok.Setter;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "DATE"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class DateObject implements Entity<DateObject> {


    @Column(allowsNull="false")
    @Title(sequence="1")
    @Getter @Setter
    private String name;


    @Column(allowsNull = "false")
    @Getter @Setter
    private java.util.Date someJavaUtilDateMandatory;


    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateMandatory(final java.util.Date i) {
        setSomeJavaUtilDateMandatory(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateMandatory() {
        return getSomeJavaUtilDateMandatory();
    }
    //endregion

    @Column(allowsNull = "true")
    @Getter @Setter
    private java.util.Date someJavaUtilDateOptional;


    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateOptional(@Parameter(optionality=Optionality.OPTIONAL) final  java.util.Date i) {
        setSomeJavaUtilDateOptional(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateOptional() {
        return getSomeJavaUtilDateOptional();
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaUtilDateOptional() {
        setSomeJavaUtilDateOptional(null);
        return this;
    }
    //endregion

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private java.util.Date someJavaUtilDateHidden;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private java.util.Date someJavaUtilDateDisabled;


    //region > someJavaUtilDateWithValidation (property)
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private java.util.Date someJavaUtilDateWithValidation;


    public String validateSomeJavaUtilDateWithValidation(final java.util.Date i) {
        return i.getDay() == 1? "Can't enter Monday (don't like Mondays)": null;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateWithValidation(final Date i) {
        setSomeJavaUtilDateWithValidation(i);
        return this;
    }

    public String validateUpdateSomeJavaUtilDateWithValidation(final java.util.Date i) {
        return validateSomeJavaUtilDateWithValidation(i);
    }
    public java.util.Date default0UpdateSomeJavaUtilDateWithValidation() {
        return getSomeJavaUtilDateWithValidation();
    }

    //endregion


    //region > someJavaUtilDateMandatoryWithChoices (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private java.util.Date someJavaUtilDateMandatoryWithChoices;

    public Collection<java.util.Date> choicesSomeJavaUtilDateMandatoryWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVAUTILDATE);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateMandatoryWithChoices(final java.util.Date i) {
        setSomeJavaUtilDateMandatoryWithChoices(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateMandatoryWithChoices() {
        return getSomeJavaUtilDateMandatoryWithChoices();
    }

    public List<java.util.Date> choices0UpdateSomeJavaUtilDateMandatoryWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVAUTILDATE);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaUtilDateMandatoryWithChoices() {
        setSomeJavaUtilDateMandatoryWithChoices(null);
        return this;
    }
    //endregion

    //region > someJavaUtilDateOptionalWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.util.Date someJavaUtilDateOptionalWithChoices;

    public Collection<java.util.Date> choicesSomeJavaUtilDateOptionalWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVAUTILDATE);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaUtilDateOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.util.Date i) {
        setSomeJavaUtilDateOptionalWithChoices(i);
        return this;
    }
    public java.util.Date default0UpdateSomeJavaUtilDateOptionalWithChoices() {
        return getSomeJavaUtilDateOptionalWithChoices();
    }

    public List<java.util.Date> choices0UpdateSomeJavaUtilDateOptionalWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVAUTILDATE);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaUtilDateOptionalWithChoices() {
        setSomeJavaUtilDateOptionalWithChoices(null);
        return this;
    }
    //endregion



    //region > someJavaSqlDateMandatory (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private java.sql.Date someJavaSqlDateMandatory;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateMandatory(final java.sql.Date i) {
        setSomeJavaSqlDateMandatory(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateMandatory() {
        return getSomeJavaSqlDateMandatory();
    }
    //endregion

    //region > someJavaSqlDateOptional (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.sql.Date someJavaSqlDateOptional;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateOptional(@Parameter(optionality=Optionality.OPTIONAL) final  java.sql.Date i) {
        setSomeJavaSqlDateOptional(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateOptional() {
        return getSomeJavaSqlDateOptional();
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaSqlDateOptional() {
        setSomeJavaSqlDateOptional(null);
        return this;
    }
    //endregion

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private java.sql.Date someJavaSqlDateHidden;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private java.sql.Date someJavaSqlDateDisabled;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private java.sql.Date someJavaSqlDateWithValidation;

    public String validateSomeJavaSqlDateWithValidation(final java.sql.Date i) {
        return i.getDay() == 1? "Can't enter Monday (don't like Mondays)": null;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateWithValidation(final java.sql.Date i) {
        setSomeJavaSqlDateWithValidation(i);
        return this;
    }

    public String validateUpdateSomeJavaSqlDateWithValidation(final java.sql.Date i) {
        return validateSomeJavaSqlDateWithValidation(i);
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateWithValidation() {
        return getSomeJavaSqlDateWithValidation();
    }

    //endregion


    //region > someJavaSqlDateMandatoryWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.sql.Date someJavaSqlDateMandatoryWithChoices;

    public Collection<java.sql.Date> choicesSomeJavaSqlDateMandatoryWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLDATE);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateMandatoryWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.sql.Date i) {
        setSomeJavaSqlDateMandatoryWithChoices(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateMandatoryWithChoices() {
        return getSomeJavaSqlDateMandatoryWithChoices();
    }

    public List<java.sql.Date> choices0UpdateSomeJavaSqlDateMandatoryWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLDATE);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaSqlDateMandatoryWithChoices() {
        setSomeJavaSqlDateMandatoryWithChoices(null);
        return this;
    }
    //endregion

    //region > someJavaSqlDateOptionalWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.sql.Date someJavaSqlDateOptionalWithChoices;

    public Collection<java.sql.Date> choicesSomeJavaSqlDateOptionalWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLDATE);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlDateOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.sql.Date i) {
        setSomeJavaSqlDateOptionalWithChoices(i);
        return this;
    }
    public java.sql.Date default0UpdateSomeJavaSqlDateOptionalWithChoices() {
        return getSomeJavaSqlDateOptionalWithChoices();
    }

    public List<java.sql.Date> choices0UpdateSomeJavaSqlDateOptionalWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLDATE);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaSqlDateOptionalWithChoices() {
        setSomeJavaSqlDateOptionalWithChoices(null);
        return this;
    }
    //endregion



    //region > someJodaLocalDateMandatory (property)

    @Column(allowsNull = "false")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateMandatory;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateMandatory(final org.joda.time.LocalDate i) {
        setSomeJodaLocalDateMandatory(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateMandatory() {
        return getSomeJodaLocalDateMandatory();
    }
    //endregion


    //region > someJodaLocalDateOptional (property)
    @Column(allowsNull = "true")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateOptional;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateOptional(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.LocalDate i) {
        setSomeJodaLocalDateOptional(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateOptional() {
        return getSomeJodaLocalDateOptional();
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateOptional() {
        setSomeJodaLocalDateOptional(null);
        return this;
    }
    //endregion

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateHidden;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateDisabled;


    //region > someJodaLocalDateWithValidation (property)
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateWithValidation;

    public String validateSomeJodaLocalDateWithValidation(final org.joda.time.LocalDate i) {
        return i.getDayOfWeek() == DateTimeConstants.MONDAY? "Can't enter Monday (don't like Mondays)": null;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateWithValidation(final org.joda.time.LocalDate i) {
        setSomeJodaLocalDateWithValidation(i);
        return this;
    }

    public String validateUpdateSomeJodaLocalDateWithValidation(final org.joda.time.LocalDate i) {
        return validateSomeJodaLocalDateWithValidation(i);
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateWithValidation() {
        return getSomeJodaLocalDateWithValidation();
    }

    //endregion

    //region > someJodaLocalDateMandatoryWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateMandatoryWithChoices;

    public Collection<org.joda.time.LocalDate> choicesSomeJodaLocalDateMandatoryWithChoices() {
        return nextFewDays(4, Functions.<LocalDate>identity());
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateMandatoryWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.LocalDate i) {
        setSomeJodaLocalDateMandatoryWithChoices(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateMandatoryWithChoices() {
        return getSomeJodaLocalDateMandatoryWithChoices();
    }

    public List<org.joda.time.LocalDate> choices0UpdateSomeJodaLocalDateMandatoryWithChoices() {
        return nextFewDays(4, Functions.<LocalDate>identity());
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateMandatoryWithChoices() {
        setSomeJodaLocalDateMandatoryWithChoices(null);
        return this;
    }
    //endregion

    //region > someJodaLocalDateOptionalWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private org.joda.time.LocalDate someJodaLocalDateOptionalWithChoices;

    public Collection<org.joda.time.LocalDate> choicesSomeJodaLocalDateOptionalWithChoices() {
        return nextFewDays(4, Functions.<LocalDate>identity());
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.LocalDate i) {
        setSomeJodaLocalDateOptionalWithChoices(i);
        return this;
    }
    public org.joda.time.LocalDate default0UpdateSomeJodaLocalDateOptionalWithChoices() {
        return getSomeJodaLocalDateOptionalWithChoices();
    }

    public List<org.joda.time.LocalDate> choices0UpdateSomeJodaLocalDateOptionalWithChoices() {
        return nextFewDays(4, Functions.<LocalDate>identity());
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateOptionalWithChoices() {
        setSomeJodaLocalDateOptionalWithChoices(null);
        return this;
    }
    //endregion

    //region > JodaLocalTime (commented out)
/*
    //region > someJodaLocalDateTimeMandatory (property)
    private org.joda.time.LocalDateTime someJodaLocalDateTimeMandatory;

    @Column(allowsNull = "false")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeMandatory() {
        return someJodaLocalDateTimeMandatory;
    }

    public void setSomeJodaLocalDateTimeMandatory(final org.joda.time.LocalDateTime someJodaLocalDateTimeMandatory) {
        this.someJodaLocalDateTimeMandatory = someJodaLocalDateTimeMandatory;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateTimeMandatory(final org.joda.time.LocalDateTime i) {
        setSomeJodaLocalDateTimeMandatory(i);
        return this;
    }
    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeMandatory() {
        return getSomeJodaLocalDateTimeMandatory();
    }
    //endregion

    //region > someJodaLocalDateTimeOptional (property)
    private org.joda.time.LocalDateTime someJodaLocalDateTimeOptional;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    @Column(allowsNull = "true")
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeOptional() {
        return someJodaLocalDateTimeOptional;
    }

    public void setSomeJodaLocalDateTimeOptional(final org.joda.time.LocalDateTime someJodaLocalDateTimeOptional) {
        this.someJodaLocalDateTimeOptional = someJodaLocalDateTimeOptional;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateTimeOptional(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.LocalDateTime i) {
        setSomeJodaLocalDateTimeOptional(i);
        return this;
    }
    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeOptional() {
        return getSomeJodaLocalDateTimeOptional();
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateTimeOptional() {
        setSomeJodaLocalDateTimeOptional(null);
        return this;
    }
    //endregion

    //region > someJodaLocalDateTimeHidden (property)
    private org.joda.time.LocalDateTime someJodaLocalDateTimeHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeHidden() {
        return someJodaLocalDateTimeHidden;
    }

    public void setSomeJodaLocalDateTimeHidden(final org.joda.time.LocalDateTime someJodaLocalDateTimeHidden) {
        this.someJodaLocalDateTimeHidden = someJodaLocalDateTimeHidden;
    }

    //endregion

    //region > someJodaLocalDateTimeDisabled (property)
    private org.joda.time.LocalDateTime someJodaLocalDateTimeDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeDisabled() {
        return someJodaLocalDateTimeDisabled;
    }

    public void setSomeJodaLocalDateTimeDisabled(final org.joda.time.LocalDateTime someJodaLocalDateTimeDisabled) {
        this.someJodaLocalDateTimeDisabled = someJodaLocalDateTimeDisabled;
    }

    //endregion

    //region > someJodaLocalDateTimeWithValidation (property)
    private org.joda.time.LocalDateTime someJodaLocalDateTimeWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeWithValidation() {
        return someJodaLocalDateTimeWithValidation;
    }

    public void setSomeJodaLocalDateTimeWithValidation(final org.joda.time.LocalDateTime someJodaLocalDateTimeWithValidation) {
        this.someJodaLocalDateTimeWithValidation = someJodaLocalDateTimeWithValidation;
    }

    public String validateSomeJodaLocalDateTimeWithValidation(final org.joda.time.LocalDateTime i) {
        return i.getDayOfWeek() == DateTimeConstants.MONDAY? "Can't enter Monday (don't like Mondays)": null;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateTimeWithValidation(final org.joda.time.LocalDateTime i) {
        setSomeJodaLocalDateTimeWithValidation(i);
        return this;
    }

    public String validateUpdateSomeJodaLocalDateTimeWithValidation(final org.joda.time.LocalDateTime i) {
        return validateSomeJodaLocalDateTimeWithValidation(i);
    }
    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeWithValidation() {
        return getSomeJodaLocalDateTimeWithValidation();
    }

    //endregion

    //
    // throwing an exception... looks like issue in Isis core.
    //
    //region > someJodaLocalDateTimeMandatoryWithChoices (property)
    private org.joda.time.LocalDateTime someJodaLocalDateTimeMandatoryWithChoices;

    @Column(allowsNull = "true")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeMandatoryWithChoices() {
        return someJodaLocalDateTimeMandatoryWithChoices;
    }

    public void setSomeJodaLocalDateTimeMandatoryWithChoices(final org.joda.time.LocalDateTime someJodaLocalDateTimeMandatoryWithChoices) {
        this.someJodaLocalDateTimeMandatoryWithChoices = someJodaLocalDateTimeMandatoryWithChoices;
    }

    public Collection<org.joda.time.LocalDateTime> choicesSomeJodaLocalDateTimeMandatoryWithChoices() {
        return nextFewDays(4, localDateWithTime(new LocalTime()));
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaLocalDateTimeMandatoryWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.LocalDateTime i) {
        setSomeJodaLocalDateTimeMandatoryWithChoices(i);
        return this;
    }
    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeMandatoryWithChoices() {
        return getSomeJodaLocalDateTimeMandatoryWithChoices();
    }

    public List<org.joda.time.LocalDateTime> choices0UpdateSomeJodaLocalDateTimeMandatoryWithChoices() {
        return nextFewDays(4, localDateWithTime(new LocalTime()));
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaLocalDateTimeMandatoryWithChoices() {
        setSomeJodaLocalDateTimeMandatoryWithChoices(null);
        return this;
    }
    //endregion

    //
    // throwing an exception... looks like issue in Isis core.
    //
//    //region > someJodaLocalDateTimeOptionalWithChoices (property)
//    private org.joda.time.LocalDateTime someJodaLocalDateTimeOptionalWithChoices;
//
//    @Column(allowsNull = "true")
//    public org.joda.time.LocalDateTime getSomeJodaLocalDateTimeOptionalWithChoices() {
//        return someJodaLocalDateTimeOptionalWithChoices;
//    }
//
//    public void setSomeJodaLocalDateTimeOptionalWithChoices(final org.joda.time.LocalDateTime someJodaLocalDateTimeOptionalWithChoices) {
//        this.someJodaLocalDateTimeOptionalWithChoices = someJodaLocalDateTimeOptionalWithChoices;
//    }
//
//    public Collection<org.joda.time.LocalDateTime> choicesSomeJodaLocalDateTimeOptionalWithChoices() {
//        return nextFewDays(4, localDateWithTime(new LocalTime()));
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject updateSomeJodaLocalDateTimeOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.LocalDateTime i) {
//        setSomeJodaLocalDateTimeOptionalWithChoices(i);
//        return this;
//    }
//    public org.joda.time.LocalDateTime default0UpdateSomeJodaLocalDateTimeOptionalWithChoices() {
//        return getSomeJodaLocalDateTimeOptionalWithChoices();
//    }
//
//    public List<org.joda.time.LocalDateTime> choices0UpdateSomeJodaLocalDateTimeOptionalWithChoices() {
//        return nextFewDays(4, localDateWithTime(new LocalTime()));
//    }
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject resetSomeJodaLocalDateTimeOptionalWithChoices() {
//        setSomeJodaLocalDateTimeOptionalWithChoices(null);
//        return this;
//    }
//    //endregion

*/
    //endregion

    //
    // the applib datetime/date classes are commented out because they haven't been mapped to the DataNucleus objectstore,
    // and will almost certainly remove in Isis 2.0
    //


    //region > ApplibDateTime (commented out)

//    //region > someApplibDateTimeMandatory (property)
//    private org.apache.isis.applib.value.DateTime someApplibDateTimeMandatory;
//
//    @Column(allowsNull = "false")
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    public org.apache.isis.applib.value.DateTime getSomeApplibDateTimeMandatory() {
//        return someApplibDateTimeMandatory;
//    }
//
//    public void setSomeApplibDateTimeMandatory(final org.apache.isis.applib.value.DateTime someApplibDateTimeMandatory) {
//        this.someApplibDateTimeMandatory = someApplibDateTimeMandatory;
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject updateSomeApplibDateTimeMandatory(final org.apache.isis.applib.value.DateTime i) {
//        setSomeApplibDateTimeMandatory(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.DateTime default0UpdateSomeApplibDateTimeMandatory() {
//        return getSomeApplibDateTimeMandatory();
//    }
//    // end region
//
//    //region > someApplibDateTimeOptional (property)
//    private org.apache.isis.applib.value.DateTime someApplibDateTimeOptional;
//
//    @Column(allowsNull = "true")
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    public org.apache.isis.applib.value.DateTime getSomeApplibDateTimeOptional() {
//        return someApplibDateTimeOptional;
//    }
//
//    public void setSomeApplibDateTimeOptional(final org.apache.isis.applib.value.DateTime someApplibDateTimeOptional) {
//        this.someApplibDateTimeOptional = someApplibDateTimeOptional;
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject updateSomeApplibDateTimeOptional(@Parameter(optionality=Optionality.OPTIONAL) final  org.apache.isis.applib.value.DateTime i) {
//        setSomeApplibDateTimeOptional(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.DateTime default0UpdateSomeApplibDateTimeOptional() {
//        return getSomeApplibDateTimeOptional();
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject resetSomeApplibDateTimeOptional() {
//        setSomeApplibDateTimeOptional(null);
//        return this;
//    }
//    //end region
//
//    //region > someApplibDateMandatory (property)
//    private org.apache.isis.applib.value.Date someApplibDateMandatory;
//
//    @Column(allowsNull = "false")
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    public org.apache.isis.applib.value.Date getSomeApplibDateMandatory() {
//        return someApplibDateMandatory;
//    }
//
//    public void setSomeApplibDateMandatory(final org.apache.isis.applib.value.Date someApplibDateMandatory) {
//        this.someApplibDateMandatory = someApplibDateMandatory;
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject updateSomeApplibDateMandatory(final org.apache.isis.applib.value.Date i) {
//        setSomeApplibDateMandatory(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.Date default0UpdateSomeApplibDateMandatory() {
//        return getSomeApplibDateMandatory();
//    }
//    // xnd region
//
//    //region > someApplibDateOptional (property)
//    private org.apache.isis.applib.value.Date someApplibDateOptional;
//
//    @Column(allowsNull = "true")
//    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
//    public org.apache.isis.applib.value.Date getSomeApplibDateOptional() {
//        return someApplibDateOptional;
//    }
//
//    public void setSomeApplibDateOptional(final org.apache.isis.applib.value.Date someApplibDateOptional) {
//        this.someApplibDateOptional = someApplibDateOptional;
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject updateSomeApplibDateOptional(@Parameter(optionality=Optionality.OPTIONAL) final  org.apache.isis.applib.value.Date i) {
//        setSomeApplibDateOptional(i);
//        return this;
//    }
//    public org.apache.isis.applib.value.Date default0UpdateSomeApplibDateOptional() {
//        return getSomeApplibDateOptional();
//    }
//
//    @Action(semantics = SemanticsOf.IDEMPOTENT)
//    public DateObject resetSomeApplibDateOptional() {
//        setSomeApplibDateOptional(null);
//        return this;
//    }
//    //end region

    //endregion


    //region > someJodaDateTimeMandatory (property)
    @Column(allowsNull = "false")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeMandatory;


    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeMandatory(final org.joda.time.DateTime i) {
        setSomeJodaDateTimeMandatory(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeMandatory() {
        return getSomeJodaDateTimeMandatory();
    }
    //endregion

    //region > someJodaDateTimeOptional (property)
    @Column(allowsNull = "true")
    @javax.jdo.annotations.Persistent(defaultFetchGroup="true")
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeOptional;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeOptional(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.DateTime i) {
        setSomeJodaDateTimeOptional(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeOptional() {
        return getSomeJodaDateTimeOptional();
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaDateTimeOptional() {
        setSomeJodaDateTimeOptional(null);
        return this;
    }
    //endregion

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeHidden;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeDisabled;


    //region > someJodaDateTimeWithValidation (property)
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeWithValidation;

    public String validateSomeJodaDateTimeWithValidation(final org.joda.time.DateTime i) {
        return i.getDayOfWeek() == DateTimeConstants.MONDAY? "Can't enter Monday (don't like Mondays)": null;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeWithValidation(final org.joda.time.DateTime i) {
        setSomeJodaDateTimeWithValidation(i);
        return this;
    }

    public String validateUpdateSomeJodaDateTimeWithValidation(final org.joda.time.DateTime i) {
        return validateSomeJodaDateTimeWithValidation(i);
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeWithValidation() {
        return getSomeJodaDateTimeWithValidation();
    }

    //endregion

    //region > someJodaDateTimeMandatoryWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeMandatoryWithChoices;


    public Collection<org.joda.time.DateTime> choicesSomeJodaDateTimeMandatoryWithChoices() {
        return nextFewDays(4, LocalDate::toDateTimeAtStartOfDay);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeMandatoryWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.DateTime i) {
        setSomeJodaDateTimeMandatoryWithChoices(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeMandatoryWithChoices() {
        return getSomeJodaDateTimeMandatoryWithChoices();
    }

    public List<org.joda.time.DateTime> choices0UpdateSomeJodaDateTimeMandatoryWithChoices() {
        return nextFewDays(4, LocalDate::toDateTimeAtStartOfDay);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaDateTimeMandatoryWithChoices() {
        setSomeJodaDateTimeMandatoryWithChoices(null);
        return this;
    }
    //endregion

    //region > someJodaDateTimeOptionalWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private org.joda.time.DateTime someJodaDateTimeOptionalWithChoices;

    public Collection<org.joda.time.DateTime> choicesSomeJodaDateTimeOptionalWithChoices() {
        return nextFewDays(4, LocalDate::toDateTimeAtStartOfDay);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJodaDateTimeOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  org.joda.time.DateTime i) {
        setSomeJodaDateTimeOptionalWithChoices(i);
        return this;
    }
    public org.joda.time.DateTime default0UpdateSomeJodaDateTimeOptionalWithChoices() {
        return getSomeJodaDateTimeOptionalWithChoices();
    }

    public List<org.joda.time.DateTime> choices0UpdateSomeJodaDateTimeOptionalWithChoices() {
        return nextFewDays(4, LocalDate::toDateTimeAtStartOfDay);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJodaDateTimeOptionalWithChoices() {
        setSomeJodaDateTimeOptionalWithChoices(null);
        return this;
    }
    //endregion



    //region > someJavaSqlTimestampMandatory (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampMandatory;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampMandatory(final java.sql.Timestamp i) {
        setSomeJavaSqlTimestampMandatory(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampMandatory() {
        return getSomeJavaSqlTimestampMandatory();
    }
    //endregion

    //region > someJavaSqlTimestampOptional (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampOptional;

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampOptional(@Parameter(optionality=Optionality.OPTIONAL) final  java.sql.Timestamp i) {
        setSomeJavaSqlTimestampOptional(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampOptional() {
        return getSomeJavaSqlTimestampOptional();
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaSqlTimestampOptional() {
        setSomeJavaSqlTimestampOptional(null);
        return this;
    }
    //endregion

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampHidden;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampDisabled;

    //endregion

    //region > someJavaSqlTimestampWithValidation (property)
    @javax.jdo.annotations.Column(allowsNull = "false")
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampWithValidation;

    public String validateSomeJavaSqlTimestampWithValidation(final java.sql.Timestamp i) {
        return i.getDay() == 1? "Can't enter Monday (don't like Mondays)": null;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampWithValidation(final java.sql.Timestamp i) {
        setSomeJavaSqlTimestampWithValidation(i);
        return this;
    }

    public String validateUpdateSomeJavaSqlTimestampWithValidation(final java.sql.Timestamp i) {
        return validateSomeJavaSqlTimestampWithValidation(i);
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampWithValidation() {
        return getSomeJavaSqlTimestampWithValidation();
    }

    //endregion

    //region > someJavaSqlTimestampMandatoryWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampMandatoryWithChoices;

    public Collection<java.sql.Timestamp> choicesSomeJavaSqlTimestampMandatoryWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLTIMESTAMP);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampMandatoryWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.sql.Timestamp i) {
        setSomeJavaSqlTimestampMandatoryWithChoices(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampMandatoryWithChoices() {
        return getSomeJavaSqlTimestampMandatoryWithChoices();
    }

    public List<java.sql.Timestamp> choices0UpdateSomeJavaSqlTimestampMandatoryWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLTIMESTAMP);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaSqlTimestampMandatoryWithChoices() {
        setSomeJavaSqlTimestampMandatoryWithChoices(null);
        return this;
    }
    //endregion

    //region > someJavaSqlTimestampOptionalWithChoices (property)
    @Column(allowsNull = "true")
    @Getter @Setter
    private java.sql.Timestamp someJavaSqlTimestampOptionalWithChoices;

    public Collection<java.sql.Timestamp> choicesSomeJavaSqlTimestampOptionalWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLTIMESTAMP);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject updateSomeJavaSqlTimestampOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.sql.Timestamp i) {
        setSomeJavaSqlTimestampOptionalWithChoices(i);
        return this;
    }
    public java.sql.Timestamp default0UpdateSomeJavaSqlTimestampOptionalWithChoices() {
        return getSomeJavaSqlTimestampOptionalWithChoices();
    }

    public List<java.sql.Timestamp> choices0UpdateSomeJavaSqlTimestampOptionalWithChoices() {
        return nextFewDays(4, LOCALDATE_AS_JAVASQLTIMESTAMP);
    }
    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public DateObject resetSomeJavaSqlTimestampOptionalWithChoices() {
        setSomeJavaSqlTimestampOptionalWithChoices(null);
        return this;
    }
    //endregion


    @Override
    public int compareTo(DateObject other) {
        return ObjectContracts.compare(this, other, "name");
    }


    //region > helpers

    private static final Function<LocalDate, java.util.Date> LOCALDATE_AS_JAVAUTILDATE =
            Functions.compose(AbstractInstant::toDate, LocalDate::toDateTimeAtStartOfDay);

    private static final Function<java.util.Date, java.sql.Date> JAVAUTILDATE_AS_JAVASQLDATE = input -> new java.sql.Date(input.getTime());

    private static final Function<java.util.Date, java.sql.Timestamp> JAVAUTILDATE_AS_JAVASQTIMESTAMP = input -> new java.sql.Timestamp(input.getTime());

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


    @javax.inject.Inject
    DomainObjectContainer container;
    @javax.inject.Inject
    ClockService clockService;

}
