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
import javax.jdo.annotations.VersionStrategy;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObjects;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ObjectType;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import static com.google.common.base.Predicates.not;
import static org.isisaddons.app.kitchensink.dom.hierarchy.child.PredicateUtil.containedIn;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("PARENT")
@Bookmarkable(BookmarkPolicy.AS_ROOT)
public class ParentObject implements Entity<ParentObject> {


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


    //region > children (collection)
    @Persistent(mappedBy = "parent", dependentElement = "false")
    private SortedSet<ChildObject> children = new TreeSet<ChildObject>();

    @MemberOrder(sequence = "1")
    public SortedSet<ChildObject> getChildren() {
        return children;
    }

    public void setChildren(final SortedSet<ChildObject> children) {
        this.children = children;
    }
    //endregion

    //region > addChild (action)
    @MemberOrder(sequence = "1")
    public ParentObject addChild(final ChildObject childObject) {
        childObject.setParent(this);
        return this;
    }

    public List<ChildObject> choices0AddChild() {
        return Lists.newArrayList(Iterables.filter(childObjects.listAll(), not(containedIn(children)))
        );
    }

    //endregion

    //region > removeChild (action)
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
    //endregion

    //region > compareTo

    @Override
    public int compareTo(ParentObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    private DomainObjectContainer container;

    @javax.inject.Inject
    private ChildObjects childObjects;

    @javax.inject.Inject
    private ParentObjects parentObjects;


    //endregion

}
