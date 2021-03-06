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
package org.isisaddons.app.kitchensink.dom.inject;

import java.util.List;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.wrapper.WrapperFactory;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "INJECT"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class InjectObject implements Entity<InjectObject> {

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

    //region > updateName (action)
    @MemberOrder(sequence = "1")
    public InjectObject updateName(
            @ParameterLayout(
                    named = "New description"
            )
            final String newName) {
        setName(newName);
        return this;
    }
    //endregion

    //region > numberOfServices (derived property)
    @NotPersistent
    public int getNumberOfServices() {
        return someServices.size();
    }
    //endregion

    //region > numberOfOtherServices (derived property)
    @NotPersistent
    public int getNumberOfOtherServices() {
        return someOtherServices.size();
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(final InjectObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @Inject
    InjectObjects injectObjects;

    @Inject
    WrapperFactory wrapperFactory;

    @NotPersistent
    @javax.inject.Inject
    List<SomeSuperType> someServices;

    @NotPersistent
    @javax.inject.Inject
    List<SomeOtherSuperType> someOtherServices;

    //endregion

}
