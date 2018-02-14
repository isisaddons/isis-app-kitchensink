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

import com.google.common.collect.Ordering;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Parent;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;

import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "CHILD"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_CHILD
)
@Getter @Setter
@RequiredArgsConstructor(staticName = "create")
public class ChildObject implements Entity<ChildObject> {


    @Column(allowsNull="false")
    @Title(sequence="1")
    @lombok.NonNull
    private String name;

    @Property(editing = Editing.ENABLED, hidden = Where.PARENTED_TABLES)
    @Column(allowsNull = "false")
    @MemberOrder(sequence = "1")
    @lombok.NonNull
    @Parent()
    private ParentObject parent;

    public Collection<ParentObject> choicesParent() {
        return getParent().choices1MoveChild();
    }


    @Persistent(mappedBy = "child", dependentElement = "false")
    private SortedSet<GrandchildObject> grandchildren = new TreeSet<GrandchildObject>();


    @MemberOrder(sequence = "1")
    public ChildObject changeParent(final ParentObject newParent) {
        setParent(newParent);
        return this;
    }

    public Collection<ParentObject> choices0ChangeParent() {
        return getParent().choices1MoveChild();
    }



    @Override
    public int compareTo(final ChildObject other) {
        return Ordering.natural().onResultOf(ChildObject::getName).compare(this, other);
    }


}
