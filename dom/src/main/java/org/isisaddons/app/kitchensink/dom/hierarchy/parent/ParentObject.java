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
package org.isisaddons.app.kitchensink.dom.hierarchy.parent;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Queries;
import javax.jdo.annotations.Query;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObjects;

import static com.google.common.base.Predicates.not;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import static org.isisaddons.app.kitchensink.dom.hierarchy.child.PredicateUtil.containedIn;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@Queries({
        @Query(
                name = "findWithNoChildren",
                value = "SELECT "
                        + "FROM org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject "
                        + "WHERE !(SELECT parent "
                        + "          FROM org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject).contains(this) "),
        @Query(
                name = "findUnique",
                value = "SELECT "
                        + "FROM org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject "
                        + "WHERE name == :name ")
})
@DomainObject(
        objectType = "PARENT"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
@Getter @Setter
@RequiredArgsConstructor(staticName = "create")
public class ParentObject implements Entity<ParentObject> {


    @Column(allowsNull="false")
    @Title(sequence="1")
    @lombok.NonNull
    private String name;

    @Persistent(mappedBy = "parent", dependentElement = "false")
    @MemberOrder(sequence = "1")
    private SortedSet<ChildObject> children = new TreeSet<ChildObject>();



    @MemberOrder(sequence = "1")
    public ParentObject addChild(final ChildObject childObject) {
        childObject.setParent(this);
        return this;
    }

    public List<ChildObject> choices0AddChild() {
        return Lists.newArrayList(Iterables.filter(childObjects.listAll(), not(containedIn(getChildren())))
        );
    }


    @MemberOrder(sequence = "1")
    public ParentObject moveChild(final ChildObject childObject, final ParentObject other) {
        childObject.setParent(other);
        return this;
    }

    public java.util.Collection<ChildObject> choices0MoveChild() {
        return getChildren();
    }
    public java.util.Collection<ParentObject> choices1MoveChild() {
        return Lists.newArrayList(
                Iterables.filter(parentObjects.listAll(), not(containedIn(Collections.singleton(this)))
        ));
    }

    public String disableMoveChild(final ChildObject childObject, final ParentObject other) {
        return choices0MoveChild().isEmpty()? "No children to move": null;
    }



    @Override
    public int compareTo(ParentObject other) {
        return Ordering.natural().onResultOf(ParentObject::getName).compare(this, other);
    }




    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE)
    @javax.inject.Inject
    private ChildObjects childObjects;

    @Getter(AccessLevel.PRIVATE) @Setter(AccessLevel.PRIVATE)
    @javax.inject.Inject
    ParentObjects parentObjects;

}
