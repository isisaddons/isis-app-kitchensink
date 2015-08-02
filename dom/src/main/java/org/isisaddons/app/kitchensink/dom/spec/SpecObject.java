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
package org.isisaddons.app.kitchensink.dom.spec;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Property;
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
        objectType = "SPEC"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class SpecObject implements Entity<SpecObject> {

    //region > name (property)

    private String name;

    @Property(
            mustSatisfy = CannotContainSpaces.class
    )
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
    public SpecObject updateName(
            @Parameter(
                    mustSatisfy = CannotContainSpaces.class
            )
            @ParameterLayout(
                    named = "New description"
            )
            final String newName) {
        setName(newName);
        return this;
    }
    //endregion
    //region > description (property)

    private String description;

    @Property(
            mustSatisfy = CannotContainSpacesTr.class
    )
    @Column(allowsNull="true")
    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
    //endregion

    //region > updateDescription (action)
    @MemberOrder(sequence = "1")
    public SpecObject updateDescription(
            @Parameter(
                    mustSatisfy = CannotContainSpacesTr.class,
                    optionality = Optionality.OPTIONAL
            )
            @ParameterLayout(
                    named = "New description"
            )
            final String newDescription) {
        setDescription(newDescription);
        return this;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(final SpecObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @Inject
    SpecObjects specObjects;

    @Inject
    WrapperFactory wrapperFactory;
    //endregion

}
