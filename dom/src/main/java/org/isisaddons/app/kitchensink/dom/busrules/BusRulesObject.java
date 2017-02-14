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
package org.isisaddons.app.kitchensink.dom.busrules;

import java.util.List;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Lists;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Title;
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
        objectType = "busrules.BusRulesObject"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class BusRulesObject implements Entity<BusRulesObject> {

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


    //region > actionAssociatedWithProperty

    public BusRulesObject actionAssociatedWithProperty() {
        return this;
    }

    public String disableActionAssociatedWithProperty() {
        return "Always disabled";
    }


    //endregion

    //region > action2AssociatedWithProperty

    public BusRulesObject action2AssociatedWithProperty() {
        return this;
    }


    //endregion


    //region > other (derived collection)

    @Collection(
            notPersisted = true
    )
    public List<BusRulesObject> getOther() {
        final List<BusRulesObject> other = Lists.newArrayList();
        other.addAll(busRulesObjectMenu.listAllBusRulesObject());
        other.remove(this);
        return other;
    }

    //endregion

    //region > actionAssociatedWithCollection

    public BusRulesObject actionAssociatedWithCollection() {
        return this;
    }

    public String disableActionAssociatedWithCollection() {
        return "Always disabled";
    }

    //endregion

    //region > action2AssociatedWithCollection

    public BusRulesObject action2AssociatedWithCollection() {
        return this;
    }
    //endregion


    //region > topLevelAction (action)
    public BusRulesObject topLevelAction() {
        return this;
    }
    public String disableTopLevelAction() {
        return "Always disabled";
    }
    //endregion

    //region > topLevelAction2 (action)
    public BusRulesObject topLevelAction2() {
        return this;
    }
    //endregion



    //region > compareTo

    @Override
    public int compareTo(final BusRulesObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @Inject
    BusRulesObjectMenu busRulesObjectMenu;
    //endregion

}
