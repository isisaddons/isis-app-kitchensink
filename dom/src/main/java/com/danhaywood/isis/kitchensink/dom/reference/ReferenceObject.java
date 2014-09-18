package com.danhaywood.isis.kitchensink.dom.reference;

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.danhaywood.isis.kitchensink.dom.Entity;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObjects;
import com.danhaywood.isis.kitchensink.dom.other.OtherObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherObjects;
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
@ObjectType("CHOICE")
@Bookmarkable
public class ReferenceObject implements Entity<ReferenceObject> {


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

    //region > someOtherObjectMandatoryWithChoices (property)
    private OtherObject someOtherObjectMandatoryWithChoices;

    @Column(allowsNull = "false")
    public OtherObject getSomeOtherObjectMandatoryWithChoices() {
        return someOtherObjectMandatoryWithChoices;
    }

    public void setSomeOtherObjectMandatoryWithChoices(final OtherObject someOtherObjectMandatoryWithChoices) {
        this.someOtherObjectMandatoryWithChoices = someOtherObjectMandatoryWithChoices;
    }
    public Collection<OtherObject> choicesSomeOtherObjectMandatoryWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectMandatoryWithChoices(final OtherObject i) {
        setSomeOtherObjectMandatoryWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectMandatoryWithChoices() {
        return getSomeOtherObjectMandatoryWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectMandatoryWithChoices() {
        return otherObjects.listAll();
    }
    //endregion

    //region > someOtherObjectOptionalWithChoices (property)
    private OtherObject someOtherObjectOptionalWithChoices;

    @Column(allowsNull = "true")
    public OtherObject getSomeOtherObjectOptionalWithChoices() {
        return someOtherObjectOptionalWithChoices;
    }

    public void setSomeOtherObjectOptionalWithChoices(final OtherObject someOtherObjectOptionalWithChoices) {
        this.someOtherObjectOptionalWithChoices = someOtherObjectOptionalWithChoices;
    }
    public Collection<OtherObject> choicesSomeOtherObjectOptionalWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectOptionalWithChoices(final @Optional OtherObject i) {
        setSomeOtherObjectOptionalWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectOptionalWithChoices() {
        return getSomeOtherObjectOptionalWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectOptionalWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectOptionalWithChoices() {
        setSomeOtherObjectOptionalWithChoices(null);
        return this;
    }
    //endregion

    //region > someOtherObjectActionOnlyWithChoices (property)
    private OtherObject someOtherObjectActionOnlyWithChoices;

    @Disabled
    @Column(allowsNull = "true")
    public OtherObject getSomeOtherObjectActionOnlyWithChoices() {
        return someOtherObjectActionOnlyWithChoices;
    }

    public void setSomeOtherObjectActionOnlyWithChoices(final OtherObject someOtherObjectActionOnlyWithChoices) {
        this.someOtherObjectActionOnlyWithChoices = someOtherObjectActionOnlyWithChoices;
    }
    public Collection<OtherObject> choicesSomeOtherObjectActionOnlyWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectActionOnlyWithChoices(final @Optional OtherObject i) {
        setSomeOtherObjectActionOnlyWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectActionOnlyWithChoices() {
        return getSomeOtherObjectActionOnlyWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectActionOnlyWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectActionOnlyWithChoices() {
        setSomeOtherObjectActionOnlyWithChoices(null);
        return this;
    }
    //endregion

    //region > someOtherBoundedObjectMandatory (property)
    private OtherBoundedObject someOtherBoundedObjectMandatory;

    @Column(allowsNull = "false")
    public OtherBoundedObject getSomeOtherBoundedObjectMandatory() {
        return someOtherBoundedObjectMandatory;
    }

    public void setSomeOtherBoundedObjectMandatory(final OtherBoundedObject someOtherBoundedObjectMandatory) {
        this.someOtherBoundedObjectMandatory = someOtherBoundedObjectMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherBoundedObjectMandatory(final OtherBoundedObject i) {
        setSomeOtherBoundedObjectMandatory(i);
        return this;
    }
    public OtherBoundedObject default0UpdateSomeOtherBoundedObjectMandatory() {
        return getSomeOtherBoundedObjectMandatory();
    }
    //endregion

    //region > someOtherBoundedObjectOptional (property)
    private OtherBoundedObject someOtherBoundedObjectOptional;

    @Column(allowsNull = "true")
    public OtherBoundedObject getSomeOtherBoundedObjectOptional() {
        return someOtherBoundedObjectOptional;
    }

    public void setSomeOtherBoundedObjectOptional(final OtherBoundedObject someOtherBoundedObjectOptional) {
        this.someOtherBoundedObjectOptional = someOtherBoundedObjectOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherBoundedObjectOptional(final @Optional OtherBoundedObject i) {
        setSomeOtherBoundedObjectOptional(i);
        return this;
    }
    public OtherBoundedObject default0UpdateSomeOtherBoundedObjectOptional() {
        return getSomeOtherBoundedObjectOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject resetSomeOtherBoundedObjectOptional() {
        setSomeOtherBoundedObjectOptional(null);
        return this;
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(ReferenceObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @javax.inject.Inject
    private OtherObjects otherObjects;

    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

    //endregion

}
