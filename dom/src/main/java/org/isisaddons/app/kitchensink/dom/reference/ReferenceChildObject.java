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

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObjects;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "REFERENCE_CHILD"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_CHILD
)
public class ReferenceChildObject implements Entity<ReferenceChildObject> {

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
    private ReferenceObject parent;

    @Property(editing = Editing.DISABLED)
    @MemberOrder(sequence = "1")
    @Column(allowsNull = "false")
    public ReferenceObject getParent() {
        return parent;
    }

    public void setParent(final ReferenceObject parent) {
        this.parent = parent;
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(final ReferenceChildObject other) {
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
