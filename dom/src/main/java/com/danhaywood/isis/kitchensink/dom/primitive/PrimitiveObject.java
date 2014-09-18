package com.danhaywood.isis.kitchensink.dom.primitive;

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.danhaywood.isis.kitchensink.dom.Entity;
import com.google.common.collect.Lists;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("PRIMITIVE")
@Bookmarkable
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public PrimitiveObject updateSomeByte(final byte b) {
        setSomeByte(b);
        return this;
    }
    public byte default0UpdateSomeByte() {
        return getSomeByte();
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
    public PrimitiveObject updateSomeShort(final short s) {
        setSomeShort(s);
        return this;
    }
    public short default0UpdateSomeShort() {
        return getSomeShort();
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
    public PrimitiveObject updateSomeInt(final int i) {
        setSomeInt(i);
        return this;
    }
    public int default0UpdateSomeInt() {
        return getSomeInt();
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
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public PrimitiveObject updateSomeLong(final long l) {
        setSomeLong(l);
        return this;
    }
    public long default0UpdateSomeLong() {
        return getSomeLong();
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
    public PrimitiveObject updateSomeFloat(final float f) {
        setSomeFloat(f);
        return this;
    }
    public float default0UpdateSomeFloat() {
        return getSomeFloat();
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
    public PrimitiveObject updateSomeDouble(final double d) {
        setSomeDouble(d);
        return this;
    }
    public double default0UpdateSomeDouble() {
        return getSomeDouble();
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
