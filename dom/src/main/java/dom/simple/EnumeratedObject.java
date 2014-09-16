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
@ObjectType("ENUMERATED")
@Bookmarkable
public class EnumeratedObject implements Comparable<EnumeratedObject> {

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

    //region > someBoolean (property)
    private boolean someBoolean;

    public boolean getSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(final boolean aBoolean) {
        this.someBoolean = aBoolean;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeBoolean(final boolean b) {
        setSomeBoolean(b);
        return this;
    }
    public boolean default0UpdateSomeBoolean() {
        return getSomeBoolean();
    }
    //endregion

    //region > someBooleanWrapperMandatory (property)
    private Boolean someBooleanWrapperMandatory;

    @Column(allowsNull = "false")
    public Boolean getSomeBooleanWrapperMandatory() {
        return someBooleanWrapperMandatory;
    }

    public void setSomeBooleanWrapperMandatory(final Boolean someBooleanWrapperMandatory) {
        this.someBooleanWrapperMandatory = someBooleanWrapperMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeBooleanWrapperMandatory(final Boolean i) {
        setSomeBooleanWrapperMandatory(i);
        return this;
    }
    public Boolean default0UpdateSomeBooleanWrapperMandatory() {
        return getSomeBooleanWrapperMandatory();
    }
    //endregion

    //region > someBooleanWrapperOptional (property)
    private Boolean someBooleanWrapperOptional;

    @Column(allowsNull = "true")
    public Boolean getSomeBooleanWrapperOptional() {
        return someBooleanWrapperOptional;
    }

    public void setSomeBooleanWrapperOptional(final Boolean someBooleanWrapperOptional) {
        this.someBooleanWrapperOptional = someBooleanWrapperOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeBooleanWrapperOptional(final @Optional Boolean i) {
        setSomeBooleanWrapperOptional(i);
        return this;
    }
    public Boolean default0UpdateSomeBooleanWrapperOptional() {
        return getSomeBooleanWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject resetSomeBooleanWrapperOptional() {
        setSomeBooleanWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someEnumOf3Mandatory (property)
    private EnumOf3 someEnumOf3Mandatory;

    @Column(allowsNull = "false")
    public EnumOf3 getSomeEnumOf3Mandatory() {
        return someEnumOf3Mandatory;
    }

    public void setSomeEnumOf3Mandatory(final EnumOf3 someEnumOf3Mandatory) {
        this.someEnumOf3Mandatory = someEnumOf3Mandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3Mandatory(final EnumOf3 i) {
        setSomeEnumOf3Mandatory(i);
        return this;
    }
    public EnumOf3 default0UpdateSomeEnumOf3Mandatory() {
        return getSomeEnumOf3Mandatory();
    }
    //endregion

    //region > someEnumOf3Optional (property)
    private EnumOf3 someEnumOf3Optional;

    @Column(allowsNull = "true")
    public EnumOf3 getSomeEnumOf3Optional() {
        return someEnumOf3Optional;
    }

    public void setSomeEnumOf3Optional(final EnumOf3 someEnumOf3Optional) {
        this.someEnumOf3Optional = someEnumOf3Optional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3Optional(final @Optional EnumOf3 i) {
        setSomeEnumOf3Optional(i);
        return this;
    }
    public EnumOf3 default0UpdateSomeEnumOf3Optional() {
        return getSomeEnumOf3Optional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject resetSomeEnumOf3Optional() {
        setSomeEnumOf3Optional(null);
        return this;
    }
    //endregion

    //region > someEnumOf4Mandatory (property)
    private EnumOf4 someEnumOf4Mandatory;

    @Column(allowsNull = "false")
    public EnumOf4 getSomeEnumOf4Mandatory() {
        return someEnumOf4Mandatory;
    }

    public void setSomeEnumOf4Mandatory(final EnumOf4 someEnumOf4Mandatory) {
        this.someEnumOf4Mandatory = someEnumOf4Mandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf4Mandatory(final EnumOf4 i) {
        setSomeEnumOf4Mandatory(i);
        return this;
    }
    public EnumOf4 default0UpdateSomeEnumOf4Mandatory() {
        return getSomeEnumOf4Mandatory();
    }
    //endregion

    //region > someEnumOf4Optional (property)
    private EnumOf4 someEnumOf4Optional;

    @Column(allowsNull = "true")
    public EnumOf4 getSomeEnumOf4Optional() {
        return someEnumOf4Optional;
    }

    public void setSomeEnumOf4Optional(final EnumOf4 someEnumOf4Optional) {
        this.someEnumOf4Optional = someEnumOf4Optional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf4Optional(final @Optional EnumOf4 i) {
        setSomeEnumOf4Optional(i);
        return this;
    }
    public EnumOf4 default0UpdateSomeEnumOf4Optional() {
        return getSomeEnumOf4Optional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject resetSomeEnumOf4Optional() {
        setSomeEnumOf4Optional(null);
        return this;
    }
//endregion

    //region > someEnumOf8Mandatory (property)
    private EnumOf8 someEnumOf8Mandatory;

    @Column(allowsNull = "false")
    public EnumOf8 getSomeEnumOf8Mandatory() {
        return someEnumOf8Mandatory;
    }

    public void setSomeEnumOf8Mandatory(final EnumOf8 someEnumOf8Mandatory) {
        this.someEnumOf8Mandatory = someEnumOf8Mandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf8Mandatory(final EnumOf8 i) {
        setSomeEnumOf8Mandatory(i);
        return this;
    }
    public EnumOf8 default0UpdateSomeEnumOf8Mandatory() {
        return getSomeEnumOf8Mandatory();
    }
    //endregion

    //region > someEnumOf8Optional (property)
    private EnumOf8 someEnumOf8Optional;

    @Column(allowsNull = "true")
    public EnumOf8 getSomeEnumOf8Optional() {
        return someEnumOf8Optional;
    }

    public void setSomeEnumOf8Optional(final EnumOf8 someEnumOf8Optional) {
        this.someEnumOf8Optional = someEnumOf8Optional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf8Optional(final @Optional EnumOf8 i) {
        setSomeEnumOf8Optional(i);
        return this;
    }
    public EnumOf8 default0UpdateSomeEnumOf8Optional() {
        return getSomeEnumOf8Optional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public EnumeratedObject resetSomeEnumOf8Optional() {
        setSomeEnumOf8Optional(null);
        return this;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(EnumeratedObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
