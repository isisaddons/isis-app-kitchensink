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
package org.isisaddons.app.kitchensink.dom.primitive;

import java.util.Collection;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Lists;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "PRIMITIVE"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class PrimitiveObject implements Entity<PrimitiveObject> {

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


    //region > someByte (property)
    private byte someByte;

    public byte getSomeByte() {
        return someByte;
    }

    public void setSomeByte(final byte aByte) {
        this.someByte = aByte;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeByte(final byte b) {
        setSomeByte(b);
        return this;
    }
    public byte default0UpdateSomeByte() {
        return getSomeByte();
    }
    //endregion

    //region > someByteHidden (property)
    private byte someByteHidden;

    @Property(hidden = Where.EVERYWHERE)
    public byte getSomeByteHidden() {
        return someByteHidden;
    }

    public void setSomeByteHidden(final byte someByteHidden) {
        this.someByteHidden = someByteHidden;
    }

    //endregion

    //region > someByteDisabled (property)
    private byte someByteDisabled;

    @Property(editing = Editing.DISABLED)
    public byte getSomeByteDisabled() {
        return someByteDisabled;
    }

    public void setSomeByteDisabled(final byte someByteDisabled) {
        this.someByteDisabled = someByteDisabled;
    }

    //endregion

    //region > someByteWithValidation (property)
    private byte someByteWithValidation;

    public byte getSomeByteWithValidation() {
        return someByteWithValidation;
    }

    public void setSomeByteWithValidation(final byte someByteWithValidation) {
        this.someByteWithValidation = someByteWithValidation;
    }

    public String validateSomeByteWithValidation(final byte i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeByteWithValidation(final byte i) {
        setSomeByteWithValidation(i);
        return this;
    }

    public String validateUpdateSomeByteWithValidation(final byte i) {
        return validateSomeByteWithValidation(i);
    }
    public byte default0UpdateSomeByteWithValidation() {
        return getSomeByteWithValidation();
    }

    //endregion

    //region > someByteWithChoices (property)
    private byte someByteWithChoices;

    public byte getSomeByteWithChoices() {
        return someByteWithChoices;
    }

    public void setSomeByteWithChoices(final byte someByteWithChoices) {
        this.someByteWithChoices = someByteWithChoices;
    }

    public Collection<Byte> choicesSomeByteWithChoices() {
        return Lists.newArrayList((byte)1, (byte)2, (byte)3, (byte)4);
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeByteWithChoices(final byte i) {
        setSomeByteWithChoices(i);
        return this;
    }

    public byte default0UpdateSomeByteWithChoices() {
        return getSomeByteWithChoices();
    }

    public List<Byte> choices0UpdateSomeByteWithChoices() {
        return Lists.newArrayList((byte)1,(byte)2,(byte)3,(byte)4);
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeShort(final short s) {
        setSomeShort(s);
        return this;
    }
    public short default0UpdateSomeShort() {
        return getSomeShort();
    }
    //endregion

    //region > someShortHidden (property)
    private short someShortHidden;

    @Property(hidden = Where.EVERYWHERE)
    public short getSomeShortHidden() {
        return someShortHidden;
    }

    public void setSomeShortHidden(final short someShortHidden) {
        this.someShortHidden = someShortHidden;
    }

    //endregion

    //region > someShortDisabled (property)
    private short someShortDisabled;

    @Property(editing = Editing.DISABLED)
    public short getSomeShortDisabled() {
        return someShortDisabled;
    }

    public void setSomeShortDisabled(final short someShortDisabled) {
        this.someShortDisabled = someShortDisabled;
    }

    //endregion

    //region > someShortWithValidation (property)
    private short someShortWithValidation;

    public short getSomeShortWithValidation() {
        return someShortWithValidation;
    }

    public void setSomeShortWithValidation(final short someShortWithValidation) {
        this.someShortWithValidation = someShortWithValidation;
    }

    public String validateSomeShortWithValidation(final short i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeShortWithValidation(final short i) {
        setSomeShortWithValidation(i);
        return this;
    }

    public String validateUpdateSomeShortWithValidation(final short i) {
        return validateSomeShortWithValidation(i);
    }
    public short default0UpdateSomeShortWithValidation() {
        return getSomeShortWithValidation();
    }

    //endregion

    //region > someShortWithChoices (property)
    private short someShortWithChoices;

    public short getSomeShortWithChoices() {
        return someShortWithChoices;
    }

    public void setSomeShortWithChoices(final short someShortWithChoices) {
        this.someShortWithChoices = someShortWithChoices;
    }

    public Collection<Short> choicesSomeShortWithChoices() {
        return Lists.newArrayList((short)1, (short)2, (short)3, (short)4);
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeShortWithChoices(final short i) {
        setSomeShortWithChoices(i);
        return this;
    }

    public short default0UpdateSomeShortWithChoices() {
        return getSomeShortWithChoices();
    }

    public List<Short> choices0UpdateSomeShortWithChoices() {
        return Lists.newArrayList((short)1,(short)2,(short)3,(short)4);
    }
    //endregion



    //region > someInt (property)
    private int someInt;

    @PropertyLayout(describedAs = "description of some int")
    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(final int someInt) {
        this.someInt = someInt;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeInt(final int i) {
        setSomeInt(i);
        return this;
    }
    public int default0UpdateSomeInt() {
        return getSomeInt();
    }
    //endregion

    //region > someIntHidden (property)
    private int someIntHidden;

    @Property(hidden = Where.EVERYWHERE)
    public int getSomeIntHidden() {
        return someIntHidden;
    }

    public void setSomeIntHidden(final int someIntHidden) {
        this.someIntHidden = someIntHidden;
    }

    //endregion

    //region > someIntDisabled (property)
    private int someIntDisabled;

    @Property(editing = Editing.DISABLED)
    public int getSomeIntDisabled() {
        return someIntDisabled;
    }

    public void setSomeIntDisabled(final int someIntDisabled) {
        this.someIntDisabled = someIntDisabled;
    }

    //endregion

    //region > someIntWithValidation (property)
    private int someIntWithValidation;

    public int getSomeIntWithValidation() {
        return someIntWithValidation;
    }

    public void setSomeIntWithValidation(final int someIntWithValidation) {
        this.someIntWithValidation = someIntWithValidation;
    }

    public String validateSomeIntWithValidation(final int i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeIntWithValidation(final int i) {
        setSomeIntWithValidation(i);
        return this;
    }

    public String validateUpdateSomeIntWithValidation(final int i) {
        return validateSomeIntWithValidation(i);
    }
    public int default0UpdateSomeIntWithValidation() {
        return getSomeIntWithValidation();
    }

    //endregion

    //region > someIntWithChoices (property)
    private int someIntWithChoices;

    public int getSomeIntWithChoices() {
        return someIntWithChoices;
    }

    public void setSomeIntWithChoices(final int someIntWithChoices) {
        this.someIntWithChoices = someIntWithChoices;
    }

    public Collection<Integer> choicesSomeIntWithChoices() {
        return Lists.newArrayList(1, 2, 3, 4);
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeIntWithChoices(final int i) {
        setSomeIntWithChoices(i);
        return this;
    }

    public int default0UpdateSomeIntWithChoices() {
        return getSomeIntWithChoices();
    }

    public List<Integer> choices0UpdateSomeIntWithChoices() {
        return Lists.newArrayList(1,2,3,4);
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeLong(final long l) {
        setSomeLong(l);
        return this;
    }
    public long default0UpdateSomeLong() {
        return getSomeLong();
    }
    //endregion

    //region > someLongHidden (property)
    private long someLongHidden;

    @Property(hidden = Where.EVERYWHERE)
    public long getSomeLongHidden() {
        return someLongHidden;
    }

    public void setSomeLongHidden(final long someLongHidden) {
        this.someLongHidden = someLongHidden;
    }

    //endregion

    //region > someLongDisabled (property)
    private long someLongDisabled;

    @Property(editing = Editing.DISABLED)
    public long getSomeLongDisabled() {
        return someLongDisabled;
    }

    public void setSomeLongDisabled(final long someLongDisabled) {
        this.someLongDisabled = someLongDisabled;
    }

    //endregion

    //region > someLongWithValidation (property)
    private long someLongWithValidation;

    public long getSomeLongWithValidation() {
        return someLongWithValidation;
    }

    public void setSomeLongWithValidation(final long someLongWithValidation) {
        this.someLongWithValidation = someLongWithValidation;
    }

    public String validateSomeLongWithValidation(final long i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeLongWithValidation(final long i) {
        setSomeLongWithValidation(i);
        return this;
    }

    public String validateUpdateSomeLongWithValidation(final long i) {
        return validateSomeLongWithValidation(i);
    }
    public long default0UpdateSomeLongWithValidation() {
        return getSomeLongWithValidation();
    }

    //endregion

    //region > someLongWithChoices (property)
    private long someLongWithChoices;

    public long getSomeLongWithChoices() {
        return someLongWithChoices;
    }

    public void setSomeLongWithChoices(final long someLongWithChoices) {
        this.someLongWithChoices = someLongWithChoices;
    }

    public Collection<Long> choicesSomeLongWithChoices() {
        return Lists.newArrayList((long)1, (long)2, (long)3, (long)4);
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeLongWithChoices(final long i) {
        setSomeLongWithChoices(i);
        return this;
    }

    public long default0UpdateSomeLongWithChoices() {
        return getSomeLongWithChoices();
    }

    public List<Long> choices0UpdateSomeLongWithChoices() {
        return Lists.newArrayList((long)1, (long)2, (long)3, (long)4);
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeFloat(final float f) {
        setSomeFloat(f);
        return this;
    }
    public float default0UpdateSomeFloat() {
        return getSomeFloat();
    }
    //endregion

    //region > someFloatHidden (property)
    private float someFloatHidden;

    @Property(hidden = Where.EVERYWHERE)
    public float getSomeFloatHidden() {
        return someFloatHidden;
    }

    public void setSomeFloatHidden(final float someFloatHidden) {
        this.someFloatHidden = someFloatHidden;
    }

    //endregion

    //region > someFloatDisabled (property)
    private float someFloatDisabled;

    @Property(editing = Editing.DISABLED)
    public float getSomeFloatDisabled() {
        return someFloatDisabled;
    }

    public void setSomeFloatDisabled(final float someFloatDisabled) {
        this.someFloatDisabled = someFloatDisabled;
    }

    //endregion

    //region > someFloatWithValidation (property)
    private float someFloatWithValidation;

    public float getSomeFloatWithValidation() {
        return someFloatWithValidation;
    }

    public void setSomeFloatWithValidation(final float someFloatWithValidation) {
        this.someFloatWithValidation = someFloatWithValidation;
    }

    public String validateSomeFloatWithValidation(final float i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeFloatWithValidation(final float i) {
        setSomeFloatWithValidation(i);
        return this;
    }

    public String validateUpdateSomeFloatWithValidation(final float i) {
        return validateSomeFloatWithValidation(i);
    }
    public float default0UpdateSomeFloatWithValidation() {
        return getSomeFloatWithValidation();
    }

    //endregion

    //region > someFloatWithChoices (property)
    private float someFloatWithChoices;

    public float getSomeFloatWithChoices() {
        return someFloatWithChoices;
    }

    public void setSomeFloatWithChoices(final float someFloatWithChoices) {
        this.someFloatWithChoices = someFloatWithChoices;
    }

    public Collection<Float> choicesSomeFloatWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeFloatWithChoices(final float i) {
        setSomeFloatWithChoices(i);
        return this;
    }

    public float default0UpdateSomeFloatWithChoices() {
        return getSomeFloatWithChoices();
    }

    public List<Float> choices0UpdateSomeFloatWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeDouble(final double d) {
        setSomeDouble(d);
        return this;
    }
    public double default0UpdateSomeDouble() {
        return getSomeDouble();
    }
    //endregion

    //region > someDoubleHidden (property)
    private double someDoubleHidden;

    @Property(hidden = Where.EVERYWHERE)
    public double getSomeDoubleHidden() {
        return someDoubleHidden;
    }

    public void setSomeDoubleHidden(final double someDoubleHidden) {
        this.someDoubleHidden = someDoubleHidden;
    }

    //endregion

    //region > someDoubleDisabled (property)
    private double someDoubleDisabled;

    @Property(editing = Editing.DISABLED)
    public double getSomeDoubleDisabled() {
        return someDoubleDisabled;
    }

    public void setSomeDoubleDisabled(final double someDoubleDisabled) {
        this.someDoubleDisabled = someDoubleDisabled;
    }

    //endregion

    //region > someDoubleWithValidation (property)
    private double someDoubleWithValidation;

    public double getSomeDoubleWithValidation() {
        return someDoubleWithValidation;
    }

    public void setSomeDoubleWithValidation(final double someDoubleWithValidation) {
        this.someDoubleWithValidation = someDoubleWithValidation;
    }

    public String validateSomeDoubleWithValidation(final double i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeDoubleWithValidation(final double i) {
        setSomeDoubleWithValidation(i);
        return this;
    }

    public String validateUpdateSomeDoubleWithValidation(final double i) {
        return validateSomeDoubleWithValidation(i);
    }
    public double default0UpdateSomeDoubleWithValidation() {
        return getSomeDoubleWithValidation();
    }

    //endregion

    //region > someDoubleWithChoices (property)
    private double someDoubleWithChoices;

    public double getSomeDoubleWithChoices() {
        return someDoubleWithChoices;
    }

    public void setSomeDoubleWithChoices(final double someDoubleWithChoices) {
        this.someDoubleWithChoices = someDoubleWithChoices;
    }

    public Collection<Double> choicesSomeDoubleWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public PrimitiveObject updateSomeDoubleWithChoices(final double i) {
        setSomeDoubleWithChoices(i);
        return this;
    }

    public double default0UpdateSomeDoubleWithChoices() {
        return getSomeDoubleWithChoices();
    }

    public List<Double> choices0UpdateSomeDoubleWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(PrimitiveObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
