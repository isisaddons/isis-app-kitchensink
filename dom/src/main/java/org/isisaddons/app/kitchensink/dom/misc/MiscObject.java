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
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Lists;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;
import org.apache.isis.applib.value.Money;

import org.isisaddons.app.kitchensink.dom.Entity;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "MISC"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeUrlMandatory(final java.net.URL i) {
        setSomeUrlMandatory(i);
        return this;
    }
    public java.net.URL default0UpdateSomeUrlMandatory() {
        return getSomeUrlMandatory();
    }

    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(name = "someUrlMandatory", sequence = "1")
    public URL openSomeUrlMandatory() throws MalformedURLException {
        return getSomeUrlMandatory();
    }
    public String disableSomeUrlMandatory() {
        return getSomeUrlMandatory() == null ? "No URL to open" : null;
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

    @Action(semantics= SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeUrlOptional(@Parameter(optionality=Optionality.OPTIONAL) final  java.net.URL i) {
        setSomeUrlOptional(i);
        return this;
    }
    public java.net.URL default0UpdateSomeUrlOptional() {
        return getSomeUrlOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject resetSomeUrlOptional() {
        setSomeUrlOptional(null);
        return this;
    }
    //endregion

    //region > someUrlHidden (property)
    private java.net.URL someUrlHidden;

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
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
    @Property(editing = Editing.DISABLED)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeUrlOptionalWithChoices(@Parameter(optionality= Optionality.OPTIONAL) final  java.net.URL i) {
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeUuidOptional(@Parameter(optionality=Optionality.OPTIONAL) final  java.util.UUID i) {
        setSomeUuidOptional(i);
        return this;
    }
    public java.util.UUID default0UpdateSomeUuidOptional() {
        return getSomeUuidOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject resetSomeUuidOptional() {
        setSomeUuidOptional(null);
        return this;
    }
    //endregion

    //region > someUuidHidden (property)
    private java.util.UUID someUuidHidden;

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
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
    @Property(editing = Editing.DISABLED)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
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

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeUuidOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.util.UUID i) {
        setSomeUuidOptionalWithChoices(i);
        return this;
    }
    public java.util.UUID default0UpdateSomeUuidOptionalWithChoices() {
        return getSomeUuidOptionalWithChoices();
    }
    public List<java.util.UUID> choices0UpdateSomeUuidOptionalWithChoices() {
        return Lists.newArrayList(UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID(),UUID.randomUUID());
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject resetSomeUuidOptionalWithChoices() {
        setSomeUuidOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someMoneyMandatory (property)
    private Money someMoneyMandatory;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyMandatory_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyMandatory_currency")
    })
    @Column(allowsNull = "false")
    public Money getSomeMoneyMandatory() {
        return someMoneyMandatory;
    }

    public void setSomeMoneyMandatory(final Money someMoneyMandatory) {
        this.someMoneyMandatory = someMoneyMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeMoneyMandatory(final Money i) {
        setSomeMoneyMandatory(i);
        return this;
    }
    public Money default0UpdateSomeMoneyMandatory() {
        return getSomeMoneyMandatory();
    }
    //endregion

    //region > someMoneyOptional (property)
    private Money someMoneyOptional;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyOptional_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyOptional_currency")
    })
    @Column(allowsNull = "true")
    public Money getSomeMoneyOptional() {
        return someMoneyOptional;
    }

    public void setSomeMoneyOptional(final Money someMoneyOptional) {
        this.someMoneyOptional = someMoneyOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeMoneyOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Money i) {
        setSomeMoneyOptional(i);
        return this;
    }
    public Money default0UpdateSomeMoneyOptional() {
        return getSomeMoneyOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject resetSomeMoneyOptional() {
        setSomeMoneyOptional(null);
        return this;
    }
    //endregion

    //region > someMoneyHidden (property)
    private Money someMoneyHidden;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyHidden_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyHidden_currency")
    })
    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public Money getSomeMoneyHidden() {
        return someMoneyHidden;
    }

    public void setSomeMoneyHidden(final Money someMoneyHidden) {
        this.someMoneyHidden = someMoneyHidden;
    }

    //endregion

    //region > someMoneyDisabled (property)
    private Money someMoneyDisabled;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyDisabled_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyDisabled_currency")
    })
    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public Money getSomeMoneyDisabled() {
        return someMoneyDisabled;
    }

    public void setSomeMoneyDisabled(final Money someMoneyDisabled) {
        this.someMoneyDisabled = someMoneyDisabled;
    }

    //endregion

    //region > someMoneyWithValidation (property)
    private Money someMoneyWithValidation;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyWithValidation_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyWithValidation_currency")
    })
    @Column(allowsNull = "false")
    public Money getSomeMoneyWithValidation() {
        return someMoneyWithValidation;
    }

    public void setSomeMoneyWithValidation(final Money someMoneyWithValidation) {
        this.someMoneyWithValidation = someMoneyWithValidation;
    }

    public String validateSomeMoneyWithValidation(final Money i) {
        return i != null && !"GBP".equals(i.getCurrency())? "Must be in GBP": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeMoneyWithValidation(final Money i) {
        setSomeMoneyWithValidation(i);
        return this;
    }

    public String validateUpdateSomeMoneyWithValidation(final Money i) {
        return validateSomeMoneyWithValidation(i);
    }
    public Money default0UpdateSomeMoneyWithValidation() {
        return getSomeMoneyWithValidation();
    }

    //endregion

    //region > someMoneyMandatoryWithChoices (property)
    private Money someMoneyMandatoryWithChoices;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyWithMandatoryWithChoices_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyWithMandatoryWithChoices_currency")
    })
    @Column(allowsNull = "false")
    public Money getSomeMoneyMandatoryWithChoices() {
        return someMoneyMandatoryWithChoices;
    }

    public void setSomeMoneyMandatoryWithChoices(final Money someMoneyMandatoryWithChoices) {
        this.someMoneyMandatoryWithChoices = someMoneyMandatoryWithChoices;
    }
    public Collection<Money> choicesSomeMoneyMandatoryWithChoices() {
        return Lists.newArrayList(new Money(1000, "GBP"),new Money(10.00, "GBP"),new Money(1000, "EUR"),new Money(10.00, "EUR"), new Money(1000, "USD"), new Money(10.00, "USD"));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeMoneyMandatoryWithChoices(final Money i) {
        setSomeMoneyMandatoryWithChoices(i);
        return this;
    }
    public Money default0UpdateSomeMoneyMandatoryWithChoices() {
        return getSomeMoneyMandatoryWithChoices();
    }
    public List<Money> choices0UpdateSomeMoneyMandatoryWithChoices() {
        return Lists.newArrayList(new Money(1000, "GBP"),new Money(10.00, "GBP"),new Money(1000, "EUR"),new Money(10.00, "EUR"), new Money(1000, "USD"), new Money(10.00, "USD"));
    }
    //endregion

    //region > someMoneyOptionalWithChoices (property)
    private Money someMoneyOptionalWithChoices;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="true", columns = {
            @javax.jdo.annotations.Column(name = "someMoneyWithOptionalWithChoices_amount"),
            @javax.jdo.annotations.Column(name = "someMoneyWithOptionalWithChoices_currency")
    })
    @Column(allowsNull = "true")
    public Money getSomeMoneyOptionalWithChoices() {
        return someMoneyOptionalWithChoices;
    }

    public void setSomeMoneyOptionalWithChoices(final Money someMoneyOptionalWithChoices) {
        this.someMoneyOptionalWithChoices = someMoneyOptionalWithChoices;
    }
    public Collection<Money> choicesSomeMoneyOptionalWithChoices() {
        return Lists.newArrayList(new Money(1000, "GBP"),new Money(10.00, "GBP"),new Money(1000, "EUR"),new Money(10.00, "EUR"), new Money(1000, "USD"), new Money(10.00, "USD"));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject updateSomeMoneyOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Money i) {
        setSomeMoneyOptionalWithChoices(i);
        return this;
    }
    public Money default0UpdateSomeMoneyOptionalWithChoices() {
        return getSomeMoneyOptionalWithChoices();
    }
    public List<Money> choices0UpdateSomeMoneyOptionalWithChoices() {
        return Lists.newArrayList(new Money(1000, "GBP"),new Money(10.00, "GBP"),new Money(1000, "EUR"),new Money(10.00, "EUR"), new Money(1000, "USD"), new Money(10.00, "USD"));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public MiscObject resetSomeMoneyOptionalWithChoices() {
        setSomeMoneyOptionalWithChoices(null);
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
