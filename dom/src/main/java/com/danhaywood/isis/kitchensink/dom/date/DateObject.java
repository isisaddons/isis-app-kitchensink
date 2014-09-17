package com.danhaywood.isis.kitchensink.dom.date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
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
public class DateObject implements Comparable<DateObject> {

    //region > nameInCollection (property)

    public String getNameInCollection() {
        return getName();
    }

    //endregion

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

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
