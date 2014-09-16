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
package dom.simple;

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
@ObjectType("SIMPLE")
@Bookmarkable
public class NumberObject implements Comparable<NumberObject> {

    //region > nameInCollection (property)

    public String getNameInCollection() {
        return getName();
    }

    //endregion

    //region > name (property)

    private String name;

    @javax.jdo.annotations.Column(allowsNull="false")
    @Title(sequence="1")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //endregion

    //region > someByte (property)
    private byte someByte;

    public byte getSomeByte() {
        return someByte;
    }

    public void setSomeByte(final byte aByte) {
        this.someByte = aByte;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeByte(final byte b) {
        setSomeByte(b);
        return this;
    }
    //endregion

    //region > someShort (property)
    private short someShort;

    public short getSomeShort() {
        return someShort;
    }

    public void setSomeShort(final short someShort) {
        this.someShort = someShort;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeShort(final short s) {
        setSomeShort(s);
        return this;
    }
    //endregion

    //region > someInt (property)
    private int someInt;

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(final int someInt) {
        this.someInt = someInt;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeInt(final int i) {
        setSomeInt(i);
        return this;
    }
    //endregion

    //region > someLong (property)
    private long someLong;

    public long getSomeLong() {
        return someLong;
    }

    public void setSomeLong(final long someLong) {
        this.someLong = someLong;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeLong(final long l) {
        setSomeLong(l);
        return this;
    }
    //endregion

    //region > someFloat (property)
    private float someFloat;

    public float getSomeFloat() {
        return someFloat;
    }

    public void setSomeFloat(final float someFloat) {
        this.someFloat = someFloat;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeFloat(final float f) {
        setSomeFloat(f);
        return this;
    }
    //endregion

    //region > someDouble (property)
    private double someDouble;

    public double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(final double someDouble) {
        this.someDouble = someDouble;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeDouble(final double d) {
        setSomeDouble(d);
        return this;
    }
    //endregion

    //region > someByteWrapperMandatory (property)
    private Byte someByteWrapperMandatory;

    @Column(allowsNull = "false")
    public Byte getSomeByteWrapperMandatory() {
        return someByteWrapperMandatory;
    }

    public void setSomeByteWrapperMandatory(final Byte someByteWrapperMandatory) {
        this.someByteWrapperMandatory = someByteWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeByteWrapperMandatory(final Byte b) {
        setSomeByteWrapperMandatory(b);
        return this;
    }
    //endregion

    //region > someShortWrapperMandatory (property)
    private Short someShortWrapperMandatory;

    @Column(allowsNull = "false")
    public Short getSomeShortWrapperMandatory() {
        return someShortWrapperMandatory;
    }

    public void setSomeShortWrapperMandatory(final Short someShortWrapperMandatory) {
        this.someShortWrapperMandatory = someShortWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeShortWrapperMandatory(final Short s) {
        setSomeShortWrapperMandatory(s);
        return this;
    }
    //endregion

    //region > someIntegerWrapperMandatory (property)
    private Integer someIntegerWrapperMandatory;

    @Column(allowsNull = "false")
    public Integer getSomeIntegerWrapperMandatory() {
        return someIntegerWrapperMandatory;
    }

    public void setSomeIntegerWrapperMandatory(final Integer someIntegerWrapperMandatory) {
        this.someIntegerWrapperMandatory = someIntegerWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeIntegerWrapperMandatory(final Integer i) {
        setSomeIntegerWrapperMandatory(i);
        return this;
    }
    //endregion

    //region > someLongWrapperMandatory (property)
    private Long someLongWrapperMandatory;

    @Column(allowsNull = "false")
    public Long getSomeLongWrapperMandatory() {
        return someLongWrapperMandatory;
    }

    public void setSomeLongWrapperMandatory(final Long someLongWrapperMandatory) {
        this.someLongWrapperMandatory = someLongWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeLongWrapperMandatory(final Long l) {
        setSomeLongWrapperMandatory(l);
        return this;
    }
    //endregion

    //region > someFloatWrapperMandatory (property)
    private Float someFloatWrapperMandatory;

    @Column(allowsNull = "false")
    public Float getSomeFloatWrapperMandatory() {
        return someFloatWrapperMandatory;
    }

    public void setSomeFloatWrapperMandatory(final Float someFloatWrapperMandatory) {
        this.someFloatWrapperMandatory = someFloatWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeFloatWrapperMandatory(final Float f) {
        setSomeFloatWrapperMandatory(f);
        return this;
    }
    //endregion

    //region > someDoubleWrapperMandatory (property)
    private Double someDoubleWrapperMandatory;

    @Column(allowsNull = "false")
    public Double getSomeDoubleWrapperMandatory() {
        return someDoubleWrapperMandatory;
    }

    public void setSomeDoubleWrapperMandatory(final Double someDoubleWrapperMandatory) {
        this.someDoubleWrapperMandatory = someDoubleWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeDoubleWrapperMandatory(final Double d) {
        setSomeDoubleWrapperMandatory(d);
        return this;
    }
    //endregion

    //region > someByteWrapperOptional (property)
    private Byte someByteWrapperOptional;

    @Column(allowsNull = "true")
    public Byte getSomeByteWrapperOptional() {
        return someByteWrapperOptional;
    }

    public void setSomeByteWrapperOptional(final Byte someByteWrapperOptional) {
        this.someByteWrapperOptional = someByteWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeByteWrapperOptional(final @Optional Byte b) {
        setSomeByteWrapperOptional(b);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeByteWrapperOptional() {
        setSomeByteWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someShortWrapperOptional (property)
    private Short someShortWrapperOptional;

    @Column(allowsNull = "true")
    public Short getSomeShortWrapperOptional() {
        return someShortWrapperOptional;
    }

    public void setSomeShortWrapperOptional(final Short someShortWrapperOptional) {
        this.someShortWrapperOptional = someShortWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeShortWrapperOptional(final @Optional Short s) {
        setSomeShortWrapperOptional(s);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeShortWrapperOptional() {
        setSomeShortWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someIntegerWrapperOptional (property)
    private Integer someIntegerWrapperOptional;

    @Column(allowsNull = "true")
    public Integer getSomeIntegerWrapperOptional() {
        return someIntegerWrapperOptional;
    }

    public void setSomeIntegerWrapperOptional(final Integer someIntegerWrapperOptional) {
        this.someIntegerWrapperOptional = someIntegerWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeIntegerWrapperOptional(final @Optional Integer i) {
        setSomeIntegerWrapperOptional(i);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeIntegerWrapperOptional() {
        setSomeIntegerWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someLongWrapperOptional (property)
    private Long someLongWrapperOptional;

    @Column(allowsNull = "true")
    public Long getSomeLongWrapperOptional() {
        return someLongWrapperOptional;
    }

    public void setSomeLongWrapperOptional(final Long someLongWrapperOptional) {
        this.someLongWrapperOptional = someLongWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeLongWrapperOptional(final @Optional Long l) {
        setSomeLongWrapperOptional(l);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeLongWrapperOptional() {
        setSomeLongWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someFloatWrapperOptional (property)
    private Float someFloatWrapperOptional;

    @Column(allowsNull = "true")
    public Float getSomeFloatWrapperOptional() {
        return someFloatWrapperOptional;
    }

    public void setSomeFloatWrapperOptional(final Float someFloatWrapperOptional) {
        this.someFloatWrapperOptional = someFloatWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeFloatWrapperOptional(final @Optional Float f) {
        setSomeFloatWrapperOptional(f);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeFloatWrapperOptional() {
        setSomeFloatWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someDoubleWrapperOptional (property)
    private Double someDoubleWrapperOptional;

    @Column(allowsNull = "true")
    public Double getSomeDoubleWrapperOptional() {
        return someDoubleWrapperOptional;
    }

    public void setSomeDoubleWrapperOptional(final Double someDoubleWrapperOptional) {
        this.someDoubleWrapperOptional = someDoubleWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeDoubleWrapperOptional(final @Optional Double d) {
        setSomeDoubleWrapperOptional(d);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeDoubleWrapperOptional() {
        setSomeDoubleWrapperOptional(null);
        return this;
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(NumberObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
