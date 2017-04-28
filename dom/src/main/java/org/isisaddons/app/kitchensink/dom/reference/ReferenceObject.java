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
package org.isisaddons.app.kitchensink.dom.reference;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Nullable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.MinLength;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.other.AutoObject;
import org.isisaddons.app.kitchensink.dom.other.AutoObjects;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObject;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObjects;
import org.isisaddons.app.kitchensink.dom.other.OtherObject;
import org.isisaddons.app.kitchensink.dom.other.OtherObjects;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "REFERENCE"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
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


    //region > someAutoObjectMandatory (property)
    private AutoObject someAutoObjectMandatory;

    @Column(allowsNull = "false")
    public AutoObject getSomeAutoObjectMandatory() {
        return someAutoObjectMandatory;
    }

    public void setSomeAutoObjectMandatory(final AutoObject someAutoObjectMandatory) {
        this.someAutoObjectMandatory = someAutoObjectMandatory;
    }
//    public Collection<AutoObject> choicesSomeAutoObjectMandatory() {
//        return autoObjects.listAll();
//    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject updateSomeAutoObjectMandatory(final AutoObject i) {
        setSomeAutoObjectMandatory(i);
        return this;
    }
    public AutoObject default0UpdateSomeAutoObjectMandatory() {
        return getSomeAutoObjectMandatory();
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  OtherObject i) {
        setSomeOtherObjectOptionalWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectOptionalWithChoices() {
        return getSomeOtherObjectOptionalWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectOptionalWithChoices() {
        return otherObjects.listAll();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectOptionalWithChoices() {
        setSomeOtherObjectOptionalWithChoices(null);
        return this;
    }
    //endregion

    //region > someOtherObjectActionOnlyWithChoices (property)
    private OtherObject someOtherObjectActionOnlyWithChoices;

    @Property(editing = Editing.DISABLED)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectActionOnlyWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  OtherObject i) {
        setSomeOtherObjectActionOnlyWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectActionOnlyWithChoices() {
        return getSomeOtherObjectActionOnlyWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectActionOnlyWithChoices() {
        return otherObjects.listAll();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectActionOnlyWithChoices() {
        setSomeOtherObjectActionOnlyWithChoices(null);
        return this;
    }
    //endregion



    //region > someOtherObjectOptionalWithoutChoices (property)
    private OtherObject someOtherObjectOptionalWithoutChoices;

    @Column(allowsNull = "true")
    public OtherObject getSomeOtherObjectOptionalWithoutChoices() {
        return someOtherObjectOptionalWithoutChoices;
    }

    public void setSomeOtherObjectOptionalWithoutChoices(final OtherObject someOtherObjectOptionalWithoutChoices) {
        this.someOtherObjectOptionalWithoutChoices = someOtherObjectOptionalWithoutChoices;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectOptionalWithoutChoices(@Parameter(optionality=Optionality.OPTIONAL) final  OtherObject i) {
        setSomeOtherObjectOptionalWithoutChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectOptionalWithoutChoices() {
        return getSomeOtherObjectOptionalWithoutChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectOptionalWithoutChoices() {
        return otherObjects.listAll();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectOptionalWithoutChoices() {
        setSomeOtherObjectOptionalWithoutChoices(null);
        return this;
    }
    //endregion

    //region > someOtherObjectActionOnlyWithoutChoices (property)
    private OtherObject someOtherObjectActionOnlyWithoutChoices;

    @Property(editing = Editing.DISABLED)
    @Column(allowsNull = "true")
    public OtherObject getSomeOtherObjectActionOnlyWithoutChoices() {
        return someOtherObjectActionOnlyWithoutChoices;
    }

    public void setSomeOtherObjectActionOnlyWithoutChoices(final OtherObject someOtherObjectActionOnlyWithoutChoices) {
        this.someOtherObjectActionOnlyWithoutChoices = someOtherObjectActionOnlyWithoutChoices;
    }


    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectActionOnlyWithoutChoices(@Parameter(optionality=Optionality.OPTIONAL) final  OtherObject i) {
        setSomeOtherObjectActionOnlyWithoutChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectActionOnlyWithoutChoices() {
        return getSomeOtherObjectActionOnlyWithoutChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectActionOnlyWithoutChoices() {
        return otherObjects.listAll();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectActionOnlyWithoutChoices() {
        setSomeOtherObjectActionOnlyWithoutChoices(null);
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public ReferenceObject updateSomeOtherBoundedObjectOptional(@Parameter(optionality=Optionality.OPTIONAL) final  OtherBoundedObject i) {
        setSomeOtherBoundedObjectOptional(i);
        return this;
    }
    public OtherBoundedObject default0UpdateSomeOtherBoundedObjectOptional() {
        return getSomeOtherBoundedObjectOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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


    //region > someOtherObjectUsingName (property)
    private OtherObject someOtherObjectUsingName;

    @Property(hidden = Where.EVERYWHERE)
    @Column(allowsNull = "true")
    public OtherObject getSomeOtherObjectUsingName() {
        return someOtherObjectUsingName;
    }

    public void setSomeOtherObjectUsingName(final OtherObject someOtherObjectUsingName) {
        this.someOtherObjectUsingName = someOtherObjectUsingName;
    }

    @NotPersistent
    public String getSomeOtherObjectUsingNameName() {
        return getSomeOtherObjectUsingName() != null? getSomeOtherObjectUsingName().getName() : null;
    }

    public void setSomeOtherObjectUsingNameName(final String name) {
        OtherObject otherObject = name != null
                ? container.firstMatch(OtherObject.class, withName(name))
                : null;
        setSomeOtherObjectUsingName(otherObject);
    }

    public List<String> choicesSomeOtherObjectUsingNameName() {
        List<OtherObject> otherObjects = container.allInstances(OtherObject.class);
        return Lists.newArrayList(
                Iterables.transform(otherObjects, nameOf())
        );
    }

    private static Function<OtherObject, String> nameOf() {
        return new Function<OtherObject, String>() {
            @Nullable @Override public String apply(final OtherObject input) {
                return input.getName();
            }
        };
    }

    private static Predicate<OtherObject> withName(final String name) {
        return new Predicate<OtherObject>() {
    @Override public boolean apply(final OtherObject input) {
        return Objects.equal(input.getName(), name);
    }
};
    }

    //endregion


    //region > children (collection)
    @Persistent(mappedBy = "parent", dependentElement = "false")
    private SortedSet<ReferenceChildObject> children = new TreeSet<ReferenceChildObject>();

    @MemberOrder(sequence = "1")
    public SortedSet<ReferenceChildObject> getChildren() {
        return children;
    }

    public void setChildren(final SortedSet<ReferenceChildObject> children) {
        this.children = children;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @MemberOrder(name = "children", sequence = "1")
    public ReferenceObject addChild(final String name) {
        referenceChildObjects.create(name, this);
        return this;
    }

    public String validate0AddChild(final String name) {
        final Optional<ReferenceChildObject> childNamed = getChildren().stream().filter(x -> name.equals(x.getName())).findAny();
        return childNamed.isPresent() ? String.format("There is already a child named %s", name) : null;
    }
    //endregion


    //region > moveChildren (action)

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @MemberOrder(name = "children", sequence = "1")
    public ReferenceObject moveChildren(
            //@Nullable
            @ParameterLayout(named = "Select some child(ren)")
            final List<ReferenceChildObject> childObjects) {
        for (ReferenceChildObject childObject : childObjects) {
            childObject.setParent(this);
        }
        return this;
    }

    public List<ReferenceChildObject> choices0MoveChildren() {
        return otherChildren();
    }

    public List<ReferenceChildObject> default0MoveChildren() {
        final List<ReferenceChildObject> defaults = Lists.newArrayList();
        final List<ReferenceChildObject> choices = choices0MoveChildren();

        if(choices.size() > 2) {
            defaults.add(choices.get(0));
            defaults.add(choices.get(2));
        } else if(choices.size() > 1) {
            defaults.add(choices.get(0));
        }
        return defaults;
    }

    private List<ReferenceChildObject> otherChildren() {
        final List<ReferenceChildObject> referenceChildObjects = this.referenceChildObjects.listAll();
        referenceChildObjects.removeAll(getChildren());
        return referenceChildObjects;
    }

    //endregion


    //region > moveChildren2 (action)

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @MemberOrder(name = "children", sequence = "1")
    public ReferenceObject moveChildren2(
            @Nullable
            final List<ReferenceChildObject> childObjects) {
        for (ReferenceChildObject childObject : childObjects) {
            childObject.setParent(this);
        }
        return this;
    }

    public List<ReferenceChildObject> autoComplete0MoveChildren2(@MinLength(1) String search) {
        final List<ReferenceChildObject> referenceChildObjects = this.referenceChildObjects.findNamed(search);
        referenceChildObjects.removeAll(getChildren());
        return referenceChildObjects;
    }

    //endregion


    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @javax.inject.Inject
    private AutoObjects autoObjects;

    @javax.inject.Inject
    private OtherObjects otherObjects;

    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

    @javax.inject.Inject
    private ReferenceChildObjects referenceChildObjects;


    //endregion

}
