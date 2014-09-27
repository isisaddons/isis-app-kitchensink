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
package org.isisaddons.app.kitchensink.dom.hierarchy.child;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObjects;
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
@ObjectType("CHILD")
@Bookmarkable(BookmarkPolicy.AS_CHILD)
public class ChildObject implements Entity<ChildObject> {


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


    //region > parent (property)
    private ParentObject parent;

    @Disabled
    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public ParentObject getParent() {
        return parent;
    }

    public void setParent(final ParentObject parent) {
        this.parent = parent;
    }
    //endregion

    //region > changeParent (action)
    @MemberOrder(sequence = "1")
    public ChildObject changeParent(final ParentObject newParent) {
        setParent(newParent);
        return this;
    }

    public Collection<ParentObject> choices0ChangeParent() {
        return getParent().choices1MoveChild();
    }
    //endregion
    
    
    //region > grandchildren (collection)
    @Persistent(mappedBy = "child", dependentElement = "false")
    private SortedSet<GrandchildObject> grandchildren = new TreeSet<GrandchildObject>();

    @MemberOrder(sequence = "1")
    public SortedSet<GrandchildObject> getGrandchildren() {
        return grandchildren;
    }

    public void setGrandchildren(final SortedSet<GrandchildObject> grandchildren) {
        this.grandchildren = grandchildren;
    }
    //endregion
    
    
    //region > compareTo

    @Override
    public int compareTo(ChildObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion


    //region > injected services

    @javax.inject.Inject
    private DomainObjectContainer container;

    @javax.inject.Inject
    private ParentObjects parentObjects;
    //endregion

}
