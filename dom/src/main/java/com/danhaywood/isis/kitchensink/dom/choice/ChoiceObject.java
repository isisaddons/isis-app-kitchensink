package com.danhaywood.isis.kitchensink.dom.choice;

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObjects;
import com.danhaywood.isis.kitchensink.dom.other.OtherObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherObjects;
import com.google.common.collect.Lists;
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
public class ChoiceObject implements Comparable<ChoiceObject> {

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

    //region > someInt (property)
    private int someInt;

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(final int someInt) {
        this.someInt = someInt;
    }

    public Collection<Integer> choicesSomeInt() {
        return Lists.newArrayList(1, 2, 3, 4);
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeInt(final int i) {
        setSomeInt(i);
        return this;
    }
    
    public int default0UpdateSomeInt() {
        return getSomeInt();
    }

    public List<Integer> choices0UpdateSomeInt() {
        return Lists.newArrayList(1,2,3,4);
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
    public Collection<Integer> choicesSomeIntegerWrapperMandatory() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeIntegerWrapperMandatory(final Integer i) {
        setSomeIntegerWrapperMandatory(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperMandatory() {
        return getSomeIntegerWrapperMandatory();
    }
    public List<Integer> choices0UpdateSomeIntegerWrapperMandatory() {
        return Lists.newArrayList(1, 2, 3, 4);
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
    public Collection<Integer> choicesSomeIntegerWrapperOptional() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeIntegerWrapperOptional(final @Optional Integer i) {
        setSomeIntegerWrapperOptional(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperOptional() {
        return getSomeIntegerWrapperOptional();
    }
    public List<Integer> choices0UpdateSomeIntegerWrapperOptional() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject resetSomeIntegerWrapperOptional() {
        setSomeIntegerWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someStringMandatory (property)
    private String someStringMandatory;

    @Column(allowsNull = "false")
    public String getSomeStringMandatory() {
        return someStringMandatory;
    }

    public void setSomeStringMandatory(final String someStringMandatory) {
        this.someStringMandatory = someStringMandatory;
    }
    public Collection<String> choicesSomeStringMandatory() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeStringMandatory(final String i) {
        setSomeStringMandatory(i);
        return this;
    }
    public String default0UpdateSomeStringMandatory() {
        return getSomeStringMandatory();
    }
    public List<String> choices0UpdateSomeStringMandatory() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }
    //endregion

    //region > someStringOptional (property)
    private String someStringOptional;

    @Column(allowsNull = "true")
    public String getSomeStringOptional() {
        return someStringOptional;
    }

    public void setSomeStringOptional(final String someStringOptional) {
        this.someStringOptional = someStringOptional;
    }
    public Collection<String> choicesSomeStringOptional() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeStringOptional(final @Optional String i) {
        setSomeStringOptional(i);
        return this;
    }
    public String default0UpdateSomeStringOptional() {
        return getSomeStringOptional();
    }
    public List<String> choices0UpdateSomeStringOptional() {
        return Lists.newArrayList("a", "ab", "abcd", "abcdefgh", "abcdefghijklmnop", "abcdefghijklmnopqrstuvwxyz");
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject resetSomeStringOptional() {
        setSomeStringOptional(null);
        return this;
    }
    //endregion

    //region > someChoiceOfOtherObjectMandatory (property)
    private OtherObject someChoiceOfOtherObjectMandatory;

    @Column(allowsNull = "false")
    public OtherObject getSomeChoiceOfOtherObjectMandatory() {
        return someChoiceOfOtherObjectMandatory;
    }

    public void setSomeChoiceOfOtherObjectMandatory(final OtherObject someChoiceOfOtherObjectMandatory) {
        this.someChoiceOfOtherObjectMandatory = someChoiceOfOtherObjectMandatory;
    }
    public Collection<OtherObject> choicesSomeChoiceOfOtherObjectMandatory() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeChoiceOfOtherObjectMandatory(final OtherObject i) {
        setSomeChoiceOfOtherObjectMandatory(i);
        return this;
    }
    public OtherObject default0UpdateSomeChoiceOfOtherObjectMandatory() {
        return getSomeChoiceOfOtherObjectMandatory();
    }
    public List<OtherObject> choices0UpdateSomeChoiceOfOtherObjectMandatory() {
        return otherObjects.listAll();
    }
    //endregion

    //region > someChoiceOfOtherObjectOptional (property)
    private OtherObject someChoiceOfOtherObjectOptional;

    @Column(allowsNull = "true")
    public OtherObject getSomeChoiceOfOtherObjectOptional() {
        return someChoiceOfOtherObjectOptional;
    }

    public void setSomeChoiceOfOtherObjectOptional(final OtherObject someChoiceOfOtherObjectOptional) {
        this.someChoiceOfOtherObjectOptional = someChoiceOfOtherObjectOptional;
    }
    public Collection<OtherObject> choicesSomeChoiceOfOtherObjectOptional() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeChoiceOfOtherObjectOptional(final @Optional OtherObject i) {
        setSomeChoiceOfOtherObjectOptional(i);
        return this;
    }
    public OtherObject default0UpdateSomeChoiceOfOtherObjectOptional() {
        return getSomeChoiceOfOtherObjectOptional();
    }
    public List<OtherObject> choices0UpdateSomeChoiceOfOtherObjectOptional() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject resetSomeChoiceOfOtherObjectOptional() {
        setSomeChoiceOfOtherObjectOptional(null);
        return this;
    }
    //endregion

    //region > someChoiceOfOtherObjectActionOnly (property)
    private OtherObject someChoiceOfOtherObjectActionOnly;

    @Disabled
    @Column(allowsNull = "true")
    public OtherObject getSomeChoiceOfOtherObjectActionOnly() {
        return someChoiceOfOtherObjectActionOnly;
    }

    public void setSomeChoiceOfOtherObjectActionOnly(final OtherObject someChoiceOfOtherObjectActionOnly) {
        this.someChoiceOfOtherObjectActionOnly = someChoiceOfOtherObjectActionOnly;
    }
    public Collection<OtherObject> choicesSomeChoiceOfOtherObjectActionOnly() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeChoiceOfOtherObjectActionOnly(final @Optional OtherObject i) {
        setSomeChoiceOfOtherObjectActionOnly(i);
        return this;
    }
    public OtherObject default0UpdateSomeChoiceOfOtherObjectActionOnly() {
        return getSomeChoiceOfOtherObjectActionOnly();
    }
    public List<OtherObject> choices0UpdateSomeChoiceOfOtherObjectActionOnly() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject resetSomeChoiceOfOtherObjectActionOnly() {
        setSomeChoiceOfOtherObjectActionOnly(null);
        return this;
    }
    //endregion

    //region > someChoiceOfOtherBoundedObjectMandatory (property)
    private OtherBoundedObject someChoiceOfOtherBoundedObjectMandatory;

    @Column(allowsNull = "false")
    public OtherBoundedObject getSomeChoiceOfOtherBoundedObjectMandatory() {
        return someChoiceOfOtherBoundedObjectMandatory;
    }

    public void setSomeChoiceOfOtherBoundedObjectMandatory(final OtherBoundedObject someChoiceOfOtherBoundedObjectMandatory) {
        this.someChoiceOfOtherBoundedObjectMandatory = someChoiceOfOtherBoundedObjectMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeChoiceOfOtherBoundedObjectMandatory(final OtherBoundedObject i) {
        setSomeChoiceOfOtherBoundedObjectMandatory(i);
        return this;
    }
    public OtherBoundedObject default0UpdateSomeChoiceOfOtherBoundedObjectMandatory() {
        return getSomeChoiceOfOtherBoundedObjectMandatory();
    }
    //endregion

    //region > someChoiceOfOtherBoundedObjectOptional (property)
    private OtherBoundedObject someChoiceOfOtherBoundedObjectOptional;

    @Column(allowsNull = "true")
    public OtherBoundedObject getSomeChoiceOfOtherBoundedObjectOptional() {
        return someChoiceOfOtherBoundedObjectOptional;
    }

    public void setSomeChoiceOfOtherBoundedObjectOptional(final OtherBoundedObject someChoiceOfOtherBoundedObjectOptional) {
        this.someChoiceOfOtherBoundedObjectOptional = someChoiceOfOtherBoundedObjectOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject updateSomeChoiceOfOtherBoundedObjectOptional(final @Optional OtherBoundedObject i) {
        setSomeChoiceOfOtherBoundedObjectOptional(i);
        return this;
    }
    public OtherBoundedObject default0UpdateSomeChoiceOfOtherBoundedObjectOptional() {
        return getSomeChoiceOfOtherBoundedObjectOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ChoiceObject resetSomeChoiceOfOtherBoundedObjectOptional() {
        setSomeChoiceOfOtherBoundedObjectOptional(null);
        return this;
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(ChoiceObject other) {
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
