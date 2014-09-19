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
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObject;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObjects;
import org.isisaddons.app.kitchensink.dom.other.OtherObject;
import org.isisaddons.app.kitchensink.dom.other.OtherObjects;
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
@ObjectType("CHOICE")
@Bookmarkable
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectOptionalWithChoices(final @Optional OtherObject i) {
        setSomeOtherObjectOptionalWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectOptionalWithChoices() {
        return getSomeOtherObjectOptionalWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectOptionalWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectOptionalWithChoices() {
        setSomeOtherObjectOptionalWithChoices(null);
        return this;
    }
    //endregion

    //region > someOtherObjectActionOnlyWithChoices (property)
    private OtherObject someOtherObjectActionOnlyWithChoices;

    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherObjectActionOnlyWithChoices(final @Optional OtherObject i) {
        setSomeOtherObjectActionOnlyWithChoices(i);
        return this;
    }
    public OtherObject default0UpdateSomeOtherObjectActionOnlyWithChoices() {
        return getSomeOtherObjectActionOnlyWithChoices();
    }
    public List<OtherObject> choices0UpdateSomeOtherObjectActionOnlyWithChoices() {
        return otherObjects.listAll();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject resetSomeOtherObjectActionOnlyWithChoices() {
        setSomeOtherObjectActionOnlyWithChoices(null);
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public ReferenceObject updateSomeOtherBoundedObjectOptional(final @Optional OtherBoundedObject i) {
        setSomeOtherBoundedObjectOptional(i);
        return this;
    }
    public OtherBoundedObject default0UpdateSomeOtherBoundedObjectOptional() {
        return getSomeOtherBoundedObjectOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @javax.inject.Inject
    private OtherObjects otherObjects;

    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

    //endregion

}
