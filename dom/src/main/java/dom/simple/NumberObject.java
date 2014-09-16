package dom.simple;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import javax.validation.constraints.Digits;
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
@ObjectType("NUMBER")
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
    public NumberObject updateSomeShort(final short s) {
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
    public NumberObject updateSomeInt(final int i) {
        setSomeInt(i);
        return this;
    }
    public int default0UpdateSomeInt() {
        return getSomeInt();
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
    public NumberObject updateSomeFloat(final float f) {
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
    public NumberObject updateSomeDouble(final double d) {
        setSomeDouble(d);
        return this;
    }
    public double default0UpdateSomeDouble() {
        return getSomeDouble();
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
    public Byte default0UpdateSomeByteWrapperMandatory() {
        return getSomeByteWrapperMandatory();
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
    public Short default0UpdateSomeShortWrapperMandatory() {
        return getSomeShortWrapperMandatory();
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
    public Integer default0UpdateSomeIntegerWrapperMandatory() {
        return getSomeIntegerWrapperMandatory();
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
    public Long default0UpdateSomeLongWrapperMandatory() {
        return getSomeLongWrapperMandatory();
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
    public Float default0UpdateSomeFloatWrapperMandatory() {
        return getSomeFloatWrapperMandatory();
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
    public Double default0UpdateSomeDoubleWrapperMandatory() {
        return getSomeDoubleWrapperMandatory();
    }
    //endregion

    //region > someBigIntegerMandatory (property)
    private BigInteger someBigIntegerMandatory;

    @Column(allowsNull = "false")
    public BigInteger getSomeBigIntegerMandatory() {
        return someBigIntegerMandatory;
    }

    public void setSomeBigIntegerMandatory(final BigInteger someBigIntegerMandatory) {
        this.someBigIntegerMandatory = someBigIntegerMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeBigIntegerMandatory(final BigInteger d) {
        setSomeBigIntegerMandatory(d);
        return this;
    }
    public BigInteger default0UpdateSomeBigIntegerMandatory() {
        return getSomeBigIntegerMandatory();
    }
    //endregion

    //region > someBigDecimalMandatory (property)
    private BigDecimal someBigDecimalMandatory;

    @Column(allowsNull = "false")
    public BigDecimal getSomeBigDecimalMandatory() {
        return someBigDecimalMandatory;
    }

    public void setSomeBigDecimalMandatory(final BigDecimal someBigDecimalMandatory) {
        this.someBigDecimalMandatory = someBigDecimalMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeBigDecimalMandatory(final BigDecimal d) {
        setSomeBigDecimalMandatory(d);
        return this;
    }
    public BigDecimal default0UpdateSomeBigDecimalMandatory() {
        return getSomeBigDecimalMandatory();
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

    public Byte default0UpdateSomeByteWrapperOptional() {
        return getSomeByteWrapperOptional();
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
    public Short default0UpdateSomeShortWrapperOptional() {
        return getSomeShortWrapperOptional();
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
    public Integer default0UpdateSomeIntegerWrapperOptional() {
        return getSomeIntegerWrapperOptional();
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
    public Float default0UpdateSomeFloatWrapperOptional() {
        return getSomeFloatWrapperOptional();
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
    public Double default0UpdateSomeDoubleWrapperOptional() {
        return getSomeDoubleWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeDoubleWrapperOptional() {
        setSomeDoubleWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someBigIntegerOptional (property)
    private BigInteger someBigIntegerOptional;

    @Column(allowsNull = "true")
    public BigInteger getSomeBigIntegerOptional() {
        return someBigIntegerOptional;
    }

    public void setSomeBigIntegerOptional(final BigInteger someBigIntegerOptional) {
        this.someBigIntegerOptional = someBigIntegerOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeBigIntegerOptional(final @Optional BigInteger d) {
        setSomeBigIntegerOptional(d);
        return this;
    }
    public BigInteger default0UpdateSomeBigIntegerOptional() {
        return getSomeBigIntegerOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeBigIntegerOptional() {
        setSomeBigIntegerOptional(null);
        return this;
    }
    //endregion

    //region > someBigDecimalOptional (property)
    private BigDecimal someBigDecimalOptional;

    @Column(allowsNull = "true")
    public BigDecimal getSomeBigDecimalOptional() {
        return someBigDecimalOptional;
    }

    public void setSomeBigDecimalOptional(final BigDecimal someBigDecimalOptional) {
        this.someBigDecimalOptional = someBigDecimalOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeBigDecimalOptional(final @Optional BigDecimal d) {
        setSomeBigDecimalOptional(d);
        return this;
    }
    public BigDecimal default0UpdateSomeBigDecimalOptional() {
        return getSomeBigDecimalOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeBigDecimalOptional() {
        setSomeBigDecimalOptional(null);
        return this;
    }
    //endregion

    //region > someBigDecimal92 (property)
    private BigDecimal someBigDecimal92;

    @Digits(integer = 9, fraction = 2)
    @Column(allowsNull = "true")
    public BigDecimal getSomeBigDecimal92() {
        return someBigDecimal92;
    }

    public void setSomeBigDecimal92(final BigDecimal someBigDecimal92) {
        this.someBigDecimal92 = someBigDecimal92;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeBigDecimal92(final @Optional @Digits(integer = 9, fraction = 2) BigDecimal d) {
        setSomeBigDecimal92(d);
        return this;
    }

    public BigDecimal default0UpdateSomeBigDecimal92() {
        return getSomeBigDecimal92();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeBigDecimal92() {
        setSomeBigDecimal92(null);
        return this;
    }
    //endregion

    //region > someBigDecimal124 (property)
    private BigDecimal someBigDecimal124;

    @Digits(integer = 12, fraction = 4)
    @Column(allowsNull = "true")
    public BigDecimal getSomeBigDecimal124() {
        return someBigDecimal124;
    }

    public void setSomeBigDecimal124(final BigDecimal someBigDecimal124) {
        this.someBigDecimal124 = someBigDecimal124;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject updateSomeBigDecimal124(final @Optional @Digits(integer = 12, fraction = 4) BigDecimal d) {
        setSomeBigDecimal124(d);
        return this;
    }

    public BigDecimal default0UpdateSomeBigDecimal124() {
        return getSomeBigDecimal124();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public NumberObject resetSomeBigDecimal124() {
        setSomeBigDecimal124(null);
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
