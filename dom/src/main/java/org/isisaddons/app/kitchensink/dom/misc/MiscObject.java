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
package org.isisaddons.app.kitchensink.dom.misc;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.Entity;
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
@ObjectType("MISC")
@Bookmarkable
public class MiscObject implements Entity<MiscObject> {


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


    //region > someUrlMandatory (property)
    private java.net.URL someUrlMandatory;

    @Column(allowsNull = "false")
    public java.net.URL getSomeUrlMandatory() {
        return someUrlMandatory;
    }

    public void setSomeUrlMandatory(final java.net.URL someUrlMandatory) {
        this.someUrlMandatory = someUrlMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUrlMandatory(final java.net.URL i) {
        setSomeUrlMandatory(i);
        return this;
    }
    public java.net.URL default0UpdateSomeUrlMandatory() {
        return getSomeUrlMandatory();
    }
    //endregion

    //region > someUrlOptional (property)
    private java.net.URL someUrlOptional;

    @Column(allowsNull = "true")
    public java.net.URL getSomeUrlOptional() {
        return someUrlOptional;
    }

    public void setSomeUrlOptional(final java.net.URL someUrlOptional) {
        this.someUrlOptional = someUrlOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUrlOptional(final @Optional java.net.URL i) {
        setSomeUrlOptional(i);
        return this;
    }
    public java.net.URL default0UpdateSomeUrlOptional() {
        return getSomeUrlOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject resetSomeUrlOptional() {
        setSomeUrlOptional(null);
        return this;
    }
    //endregion

    //region > someUrlHidden (property)
    private java.net.URL someUrlHidden;

    @Column(allowsNull = "false")
    @Hidden
    public java.net.URL getSomeUrlHidden() {
        return someUrlHidden;
    }

    public void setSomeUrlHidden(final java.net.URL someUrlHidden) {
        this.someUrlHidden = someUrlHidden;
    }

    //endregion

    //region > someUrlDisabled (property)
    private java.net.URL someUrlDisabled;

    @Column(allowsNull = "false")
    @Disabled
    public java.net.URL getSomeUrlDisabled() {
        return someUrlDisabled;
    }

    public void setSomeUrlDisabled(final java.net.URL someUrlDisabled) {
        this.someUrlDisabled = someUrlDisabled;
    }

    //endregion

    //region > someUrlWithValidation (property)
    private java.net.URL someUrlWithValidation;

    @Column(allowsNull = "false")
    public java.net.URL getSomeUrlWithValidation() {
        return someUrlWithValidation;
    }

    public void setSomeUrlWithValidation(final java.net.URL someUrlWithValidation) {
        this.someUrlWithValidation = someUrlWithValidation;
    }

    public String validateSomeUrlWithValidation(final java.net.URL i) {
        return !i.toString().contains("://") ? "Does not contain '://'": null;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUrlWithValidation(final java.net.URL i) {
        setSomeUrlWithValidation(i);
        return this;
    }

    public String validateUpdateSomeUrlWithValidation(final java.net.URL i) {
        return validateSomeUrlWithValidation(i);
    }
    public java.net.URL default0UpdateSomeUrlWithValidation() {
        return getSomeUrlWithValidation();
    }

    //endregion

    //region > someUrlMandatoryWithChoices (property)
    private java.net.URL someUrlMandatoryWithChoices;

    @Column(allowsNull = "false")
    public java.net.URL getSomeUrlMandatoryWithChoices() {
        return someUrlMandatoryWithChoices;
    }

    public void setSomeUrlMandatoryWithChoices(final java.net.URL someUrlMandatoryWithChoices) {
        this.someUrlMandatoryWithChoices = someUrlMandatoryWithChoices;
    }
    public Collection<java.net.URL> choicesSomeUrlMandatoryWithChoices() throws MalformedURLException {
        return Lists.newArrayList(
                new java.net.URL("http://isis.apache.org"),
                new java.net.URL("http://www.isisaddons.org"),
                new java.net.URL("http://www.apache.org"),
                new java.net.URL("http://issues.apache.org"),
                new java.net.URL("https://cwiki.apache.org/confluence/display/ISIS/Index")
                );
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUrlMandatoryWithChoices(final java.net.URL i) {
        setSomeUrlMandatoryWithChoices(i);
        return this;
    }
    public java.net.URL default0UpdateSomeUrlMandatoryWithChoices() {
        return getSomeUrlMandatoryWithChoices();
    }
    public List<java.net.URL> choices0UpdateSomeUrlMandatoryWithChoices() throws MalformedURLException {
        return Lists.newArrayList(
                new java.net.URL("http://isis.apache.org"),
                new java.net.URL("http://www.isisaddons.org"),
                new java.net.URL("http://www.apache.org"),
                new java.net.URL("http://issues.apache.org"),
                new java.net.URL("https://cwiki.apache.org/confluence/display/ISIS/Index")
        );
    }
    //endregion

    //region > someUrlOptionalWithChoices (property)
    private java.net.URL someUrlOptionalWithChoices;

    @Column(allowsNull = "true")
    public java.net.URL getSomeUrlOptionalWithChoices() {
        return someUrlOptionalWithChoices;
    }

    public void setSomeUrlOptionalWithChoices(final java.net.URL someUrlOptionalWithChoices) {
        this.someUrlOptionalWithChoices = someUrlOptionalWithChoices;
    }
    public Collection<java.net.URL> choicesSomeUrlOptionalWithChoices() throws MalformedURLException {
        return Lists.newArrayList(
                new java.net.URL("http://isis.apache.org"),
                new java.net.URL("http://www.isisaddons.org"),
                new java.net.URL("http://www.apache.org"),
                new java.net.URL("http://issues.apache.org"),
                new java.net.URL("https://cwiki.apache.org/confluence/display/ISIS/Index")
        );
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUrlOptionalWithChoices(final @Optional java.net.URL i) {
        setSomeUrlOptionalWithChoices(i);
        return this;
    }
    public java.net.URL default0UpdateSomeUrlOptionalWithChoices() {
        return getSomeUrlOptionalWithChoices();
    }
    public List<java.net.URL> choices0UpdateSomeUrlOptionalWithChoices() throws MalformedURLException {
        return Lists.newArrayList(
                new java.net.URL("http://isis.apache.org"),
                new java.net.URL("http://www.isisaddons.org"),
                new java.net.URL("http://www.apache.org"),
                new java.net.URL("http://issues.apache.org"),
                new java.net.URL("https://cwiki.apache.org/confluence/display/ISIS/Index")
        );
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject resetSomeUrlOptionalWithChoices() {
        setSomeUrlOptionalWithChoices(null);
        return this;
    }
    //endregion



    //region > someUuidMandatory (property)
    private java.util.UUID someUuidMandatory;

    @Column(allowsNull = "false")
    public java.util.UUID getSomeUuidMandatory() {
        return someUuidMandatory;
    }

    public void setSomeUuidMandatory(final java.util.UUID someUuidMandatory) {
        this.someUuidMandatory = someUuidMandatory;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUuidMandatory(final java.util.UUID i) {
        setSomeUuidMandatory(i);
        return this;
    }
    public java.util.UUID default0UpdateSomeUuidMandatory() {
        return getSomeUuidMandatory();
    }
    //endregion

    //region > someUuidOptional (property)
    private java.util.UUID someUuidOptional;

    @Column(allowsNull = "true")
    public java.util.UUID getSomeUuidOptional() {
        return someUuidOptional;
    }

    public void setSomeUuidOptional(final java.util.UUID someUuidOptional) {
        this.someUuidOptional = someUuidOptional;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUuidOptional(final @Optional java.util.UUID i) {
        setSomeUuidOptional(i);
        return this;
    }
    public java.util.UUID default0UpdateSomeUuidOptional() {
        return getSomeUuidOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject resetSomeUuidOptional() {
        setSomeUuidOptional(null);
        return this;
    }
    //endregion

    //region > someUuidHidden (property)
    private java.util.UUID someUuidHidden;

    @Column(allowsNull = "false")
    @Hidden
    public java.util.UUID getSomeUuidHidden() {
        return someUuidHidden;
    }

    public void setSomeUuidHidden(final java.util.UUID someUuidHidden) {
        this.someUuidHidden = someUuidHidden;
    }

    //endregion

    //region > someUuidDisabled (property)
    private java.util.UUID someUuidDisabled;

    @Column(allowsNull = "false")
    @Disabled
    public java.util.UUID getSomeUuidDisabled() {
        return someUuidDisabled;
    }

    public void setSomeUuidDisabled(final java.util.UUID someUuidDisabled) {
        this.someUuidDisabled = someUuidDisabled;
    }

    //endregion

    //region > someUuidWithValidation (property)
    private java.util.UUID someUuidWithValidation;

    @Column(allowsNull = "false")
    public java.util.UUID getSomeUuidWithValidation() {
        return someUuidWithValidation;
    }

    public void setSomeUuidWithValidation(final java.util.UUID someUuidWithValidation) {
        this.someUuidWithValidation = someUuidWithValidation;
    }

    public String validateSomeUuidWithValidation(final java.util.UUID i) {
        return !i.toString().contains("-")? "Must contain '-' character(s)": null;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUuidWithValidation(final java.util.UUID i) {
        setSomeUuidWithValidation(i);
        return this;
    }

    public String validateUpdateSomeUuidWithValidation(final java.util.UUID i) {
        return validateSomeUuidWithValidation(i);
    }
    public java.util.UUID default0UpdateSomeUuidWithValidation() {
        return getSomeUuidWithValidation();
    }

    //endregion

    //region > someUuidMandatoryWithChoices (property)
    private java.util.UUID someUuidMandatoryWithChoices;

    @Column(allowsNull = "false")
    public java.util.UUID getSomeUuidMandatoryWithChoices() {
        return someUuidMandatoryWithChoices;
    }

    public void setSomeUuidMandatoryWithChoices(final java.util.UUID someUuidMandatoryWithChoices) {
        this.someUuidMandatoryWithChoices = someUuidMandatoryWithChoices;
    }
    public Collection<java.util.UUID> choicesSomeUuidMandatoryWithChoices() {
        return Lists.newArrayList(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID());
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUuidMandatoryWithChoices(final java.util.UUID i) {
        setSomeUuidMandatoryWithChoices(i);
        return this;
    }
    public java.util.UUID default0UpdateSomeUuidMandatoryWithChoices() {
        return getSomeUuidMandatoryWithChoices();
    }
    public List<java.util.UUID> choices0UpdateSomeUuidMandatoryWithChoices() {
        return Lists.newArrayList(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID());
    }
    //endregion

    //region > someUuidOptionalWithChoices (property)
    private java.util.UUID someUuidOptionalWithChoices;

    @Column(allowsNull = "true")
    public java.util.UUID getSomeUuidOptionalWithChoices() {
        return someUuidOptionalWithChoices;
    }

    public void setSomeUuidOptionalWithChoices(final java.util.UUID someUuidOptionalWithChoices) {
        this.someUuidOptionalWithChoices = someUuidOptionalWithChoices;
    }
    public Collection<java.util.UUID> choicesSomeUuidOptionalWithChoices() {
        return Lists.newArrayList(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID());
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject updateSomeUuidOptionalWithChoices(final @Optional java.util.UUID i) {
        setSomeUuidOptionalWithChoices(i);
        return this;
    }
    public java.util.UUID default0UpdateSomeUuidOptionalWithChoices() {
        return getSomeUuidOptionalWithChoices();
    }
    public List<java.util.UUID> choices0UpdateSomeUuidOptionalWithChoices() {
        return Lists.newArrayList(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID());
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public MiscObject resetSomeUuidOptionalWithChoices() {
        setSomeUuidOptionalWithChoices(null);
        return this;
    }
    //endregion




    //region > compareTo

    @Override
    public int compareTo(MiscObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
