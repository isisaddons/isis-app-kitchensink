package com.danhaywood.isis.kitchensink.dom.other;

import com.danhaywood.isis.kitchensink.dom.SomeCategory;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

/**
 * Intended to be referenced from other classes...
 */
@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("OTHER")
@Bookmarkable(BookmarkPolicy.AS_CHILD)
public class OtherObject implements Comparable<OtherObject> {

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

    //region > description (property)

    private String description;

    @Column(allowsNull="true")
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    //endregion

    //region > someCategory (property)

    private SomeCategory someCategory;

    @Column(allowsNull="true")
    public SomeCategory getSomeCategory() {
        return someCategory;
    }

    public void setSomeCategory(final SomeCategory someCategory) {
        this.someCategory = someCategory;
    }

    //endregion


    //region > compareTo

    @Override
    public int compareTo(OtherObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
