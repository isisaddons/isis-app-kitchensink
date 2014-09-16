package dom.simple;

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
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

    //endregion

}
