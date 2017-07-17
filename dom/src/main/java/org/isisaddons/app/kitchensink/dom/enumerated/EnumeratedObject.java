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
package org.isisaddons.app.kitchensink.dom.enumerated;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.annotation.Where;
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
        objectType = "ENUMERATED"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class EnumeratedObject implements Entity<EnumeratedObject> {

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

    
    //region > someBoolean (property)
    private boolean someBoolean;

    @Property(editing = Editing.DISABLED)
    public boolean getSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(final boolean aBoolean) {
        this.someBoolean = aBoolean;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeBoolean(final boolean b) {
        setSomeBoolean(b);
        return this;
    }
    public boolean default0UpdateSomeBoolean() {
        return getSomeBoolean();
    }
    //endregion

    //region > someBooleanHidden (property)
    private boolean someBooleanHidden;

    @Property(hidden = Where.EVERYWHERE)
    public boolean getSomeBooleanHidden() {
        return someBooleanHidden;
    }

    public void setSomeBooleanHidden(final boolean someBooleanHidden) {
        this.someBooleanHidden = someBooleanHidden;
    }

    //endregion

    //region > someBooleanDisabled (property)
    private boolean someBooleanDisabled;

    @Property(editing = Editing.DISABLED)
    public boolean getSomeBooleanDisabled() {
        return someBooleanDisabled;
    }

    public void setSomeBooleanDisabled(final boolean someBooleanDisabled) {
        this.someBooleanDisabled = someBooleanDisabled;
    }

    //endregion

    //region > someBooleanWithValidation (property)
    private boolean someBooleanWithValidation;

    public boolean getSomeBooleanWithValidation() {
        return someBooleanWithValidation;
    }

    public void setSomeBooleanWithValidation(final boolean someBooleanWithValidation) {
        this.someBooleanWithValidation = someBooleanWithValidation;
    }

    public String validateSomeBooleanWithValidation(final boolean i) {
        // this validation is broken, somehow...
        return null;//i == getSomeBooleanWithValidation() ? "Can only enter opposite of current": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeBooleanWithValidation(final boolean i) {
        setSomeBooleanWithValidation(i);
        return this;
    }

    public String validateUpdateSomeBooleanWithValidation(final boolean i) {
        return validateSomeBooleanWithValidation(i);
    }
    public boolean default0UpdateSomeBooleanWithValidation() {
        return getSomeBooleanWithValidation();
    }

    //endregion



    //region > someBooleanWrapperMandatory (property)
    private Boolean someBooleanWrapperMandatory;

    @Column(allowsNull = "false")
    public Boolean getSomeBooleanWrapperMandatory() {
        return someBooleanWrapperMandatory;
    }

    public void setSomeBooleanWrapperMandatory(final Boolean someBooleanWrapperMandatory) {
        this.someBooleanWrapperMandatory = someBooleanWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeBooleanWrapperMandatory(final Boolean i) {
        setSomeBooleanWrapperMandatory(i);
        return this;
    }
    public Boolean default0UpdateSomeBooleanWrapperMandatory() {
        return getSomeBooleanWrapperMandatory();
    }


    @Action(semantics=SemanticsOf.NON_IDEMPOTENT)
    public EnumeratedObject toggleSomeBooleanWrapperMandatory() {
        setSomeBooleanWrapperMandatory(! getSomeBooleanWrapperMandatory());
        return this;
    }

    @Action(semantics=SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE)
    public EnumeratedObject toggleSomeBooleanWrapperMandatoryAreYouSure() {
        setSomeBooleanWrapperMandatory(! getSomeBooleanWrapperMandatory());
        return this;
    }

    //endregion

    //region > someBooleanWrapperOptional (property)
    private Boolean someBooleanWrapperOptional;

    @Column(allowsNull = "true")
    public Boolean getSomeBooleanWrapperOptional() {
        return someBooleanWrapperOptional;
    }

    public void setSomeBooleanWrapperOptional(final Boolean someBooleanWrapperOptional) {
        this.someBooleanWrapperOptional = someBooleanWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeBooleanWrapperOptional(
            @Parameter(optionality=Optionality.OPTIONAL)
            final  Boolean i) {
        setSomeBooleanWrapperOptional(i);
        return this;
    }
    public Boolean default0UpdateSomeBooleanWrapperOptional() {
        return getSomeBooleanWrapperOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject resetSomeBooleanWrapperOptional() {
        setSomeBooleanWrapperOptional(null);
        return this;
    }
    //endregion
    
    //region > someBooleanWrapperHidden (property)
    private java.lang.Boolean someBooleanWrapperHidden;

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Boolean getSomeBooleanWrapperHidden() {
    return someBooleanWrapperHidden;
    }
    
    public void setSomeBooleanWrapperHidden(final java.lang.Boolean someBooleanWrapperHidden) {
    this.someBooleanWrapperHidden = someBooleanWrapperHidden;
    }
    
    //endregion
    
    //region > someBooleanWrapperDisabled (property)
    private java.lang.Boolean someBooleanWrapperDisabled;

    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Boolean getSomeBooleanWrapperDisabled() {
    return someBooleanWrapperDisabled;
    }
    
    public void setSomeBooleanWrapperDisabled(final java.lang.Boolean someBooleanWrapperDisabled) {
    this.someBooleanWrapperDisabled = someBooleanWrapperDisabled;
    }
    
    //endregion
    
    //region > someBooleanWrapperWithValidation (property)
    private java.lang.Boolean someBooleanWrapperWithValidation;

    @Column(allowsNull = "false")
    public java.lang.Boolean getSomeBooleanWrapperWithValidation() {
        return someBooleanWrapperWithValidation;
    }
    
    public void setSomeBooleanWrapperWithValidation(final java.lang.Boolean someBooleanWrapperWithValidation) {
    this.someBooleanWrapperWithValidation = someBooleanWrapperWithValidation;
    }
    
    public String validateSomeBooleanWrapperWithValidation(final java.lang.Boolean i) {
        // this validation is broken, somehow...
        return null; // i == getSomeBooleanWrapperWithValidation() ? "Can only enter opposite of current": null;
    }
    
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeBooleanWrapperWithValidation(final java.lang.Boolean i) {
    setSomeBooleanWrapperWithValidation(i);
    return this;
    }
    
    public String validateUpdateSomeBooleanWrapperWithValidation(final java.lang.Boolean i) {
    return validateSomeBooleanWrapperWithValidation(i);
    }
    public java.lang.Boolean default0UpdateSomeBooleanWrapperWithValidation() {
    return getSomeBooleanWrapperWithValidation();
    }
    
    //endregion
    
    
    
    //region > someEnumOf3Mandatory (property)
    private EnumOf3 someEnumOf3Mandatory;

    @Column(allowsNull = "false")
    public EnumOf3 getSomeEnumOf3Mandatory() {
        return someEnumOf3Mandatory;
    }

    public void setSomeEnumOf3Mandatory(final EnumOf3 someEnumOf3Mandatory) {
        this.someEnumOf3Mandatory = someEnumOf3Mandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3Mandatory(final EnumOf3 i) {
        setSomeEnumOf3Mandatory(i);
        return this;
    }
    public EnumOf3 default0UpdateSomeEnumOf3Mandatory() {
        return getSomeEnumOf3Mandatory();
    }
    //endregion

    //region > someEnumOf3Optional (property)
    private EnumOf3 someEnumOf3Optional;

    @Column(allowsNull = "true")
    public EnumOf3 getSomeEnumOf3Optional() {
        return someEnumOf3Optional;
    }

    public void setSomeEnumOf3Optional(final EnumOf3 someEnumOf3Optional) {
        this.someEnumOf3Optional = someEnumOf3Optional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3Optional(@Parameter(optionality=Optionality.OPTIONAL) final  EnumOf3 i) {
        setSomeEnumOf3Optional(i);
        return this;
    }
    public EnumOf3 default0UpdateSomeEnumOf3Optional() {
        return getSomeEnumOf3Optional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject resetSomeEnumOf3Optional() {
        setSomeEnumOf3Optional(null);
        return this;
    }
    //endregion

    //region > someEnumOf3Hidden (property)
    private EnumOf3 someEnumOf3Hidden;

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public EnumOf3 getSomeEnumOf3Hidden() {
        return someEnumOf3Hidden;
    }

    public void setSomeEnumOf3Hidden(final EnumOf3 someEnumOf3Hidden) {
        this.someEnumOf3Hidden = someEnumOf3Hidden;
    }

    //endregion

    //region > someEnumOf3Disabled (property)
    private EnumOf3 someEnumOf3Disabled;

    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public EnumOf3 getSomeEnumOf3Disabled() {
        return someEnumOf3Disabled;
    }

    public void setSomeEnumOf3Disabled(final EnumOf3 someEnumOf3Disabled) {
        this.someEnumOf3Disabled = someEnumOf3Disabled;
    }

    //endregion

    //region > someEnumOf3WithValidation (property)
    private EnumOf3 someEnumOf3WithValidation;

    @Column(allowsNull = "false")
    public EnumOf3 getSomeEnumOf3WithValidation() {
        return someEnumOf3WithValidation;
    }

    public void setSomeEnumOf3WithValidation(final EnumOf3 someEnumOf3WithValidation) {
        this.someEnumOf3WithValidation = someEnumOf3WithValidation;
    }

    public String validateSomeEnumOf3WithValidation(final EnumOf3 i) {
        return i == EnumOf3.AMEX ? "Can't enter AMEX": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3WithValidation(final EnumOf3 i) {
        setSomeEnumOf3WithValidation(i);
        return this;
    }

    public String validateUpdateSomeEnumOf3WithValidation(final EnumOf3 i) {
        return validateSomeEnumOf3WithValidation(i);
    }
    public EnumOf3 default0UpdateSomeEnumOf3WithValidation() {
        return getSomeEnumOf3WithValidation();
    }

    //endregion



    //region > someEnumOf4Mandatory (property)
    private EnumOf4 someEnumOf4Mandatory;

    @Column(allowsNull = "false")
    public EnumOf4 getSomeEnumOf4Mandatory() {
        return someEnumOf4Mandatory;
    }

    public void setSomeEnumOf4Mandatory(final EnumOf4 someEnumOf4Mandatory) {
        this.someEnumOf4Mandatory = someEnumOf4Mandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf4Mandatory(final EnumOf4 i) {
        setSomeEnumOf4Mandatory(i);
        return this;
    }
    public EnumOf4 default0UpdateSomeEnumOf4Mandatory() {
        return getSomeEnumOf4Mandatory();
    }
    //endregion

    //region > someEnumOf4Optional (property)
    private EnumOf4 someEnumOf4Optional;

    @Column(allowsNull = "true")
    public EnumOf4 getSomeEnumOf4Optional() {
        return someEnumOf4Optional;
    }

    public void setSomeEnumOf4Optional(final EnumOf4 someEnumOf4Optional) {
        this.someEnumOf4Optional = someEnumOf4Optional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf4Optional(@Parameter(optionality=Optionality.OPTIONAL) final  EnumOf4 i) {
        setSomeEnumOf4Optional(i);
        return this;
    }
    public EnumOf4 default0UpdateSomeEnumOf4Optional() {
        return getSomeEnumOf4Optional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject resetSomeEnumOf4Optional() {
        setSomeEnumOf4Optional(null);
        return this;
    }
//endregion

    //region > someEnumOf4Hidden (property)
    private EnumOf4 someEnumOf4Hidden;

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public EnumOf4 getSomeEnumOf4Hidden() {
        return someEnumOf4Hidden;
    }

    public void setSomeEnumOf4Hidden(final EnumOf4 someEnumOf4Hidden) {
        this.someEnumOf4Hidden = someEnumOf4Hidden;
    }

    //endregion

    //region > someEnumOf4Disabled (property)
    private EnumOf4 someEnumOf4Disabled;

    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public EnumOf4 getSomeEnumOf4Disabled() {
        return someEnumOf4Disabled;
    }

    public void setSomeEnumOf4Disabled(final EnumOf4 someEnumOf4Disabled) {
        this.someEnumOf4Disabled = someEnumOf4Disabled;
    }

    //endregion

    //region > someEnumOf4WithValidation (property)
    private EnumOf4 someEnumOf4WithValidation;

    @Column(allowsNull = "false")
    public EnumOf4 getSomeEnumOf4WithValidation() {
        return someEnumOf4WithValidation;
    }

    public void setSomeEnumOf4WithValidation(final EnumOf4 someEnumOf4WithValidation) {
        this.someEnumOf4WithValidation = someEnumOf4WithValidation;
    }

    public String validateSomeEnumOf4WithValidation(final EnumOf4 i) {
        return i == EnumOf4.SPRING ? "Can't enter SPRING": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf4WithValidation(final EnumOf4 i) {
        setSomeEnumOf4WithValidation(i);
        return this;
    }

    public String validateUpdateSomeEnumOf4WithValidation(final EnumOf4 i) {
        return validateSomeEnumOf4WithValidation(i);
    }
    public EnumOf4 default0UpdateSomeEnumOf4WithValidation() {
        return getSomeEnumOf4WithValidation();
    }

    //endregion
    
    
    //region > someEnumOf8Mandatory (property)
    private EnumOf8 someEnumOf8Mandatory;

    @Column(allowsNull = "false")
    public EnumOf8 getSomeEnumOf8Mandatory() {
        return someEnumOf8Mandatory;
    }

    public void setSomeEnumOf8Mandatory(final EnumOf8 someEnumOf8Mandatory) {
        this.someEnumOf8Mandatory = someEnumOf8Mandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf8Mandatory(final EnumOf8 i) {
        setSomeEnumOf8Mandatory(i);
        return this;
    }
    public EnumOf8 default0UpdateSomeEnumOf8Mandatory() {
        return getSomeEnumOf8Mandatory();
    }
    //endregion

    //region > someEnumOf8Optional (property)
    private EnumOf8 someEnumOf8Optional;

    @Column(allowsNull = "true")
    public EnumOf8 getSomeEnumOf8Optional() {
        return someEnumOf8Optional;
    }

    public void setSomeEnumOf8Optional(final EnumOf8 someEnumOf8Optional) {
        this.someEnumOf8Optional = someEnumOf8Optional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf8Optional(@Parameter(optionality=Optionality.OPTIONAL) final  EnumOf8 i) {
        setSomeEnumOf8Optional(i);
        return this;
    }
    public EnumOf8 default0UpdateSomeEnumOf8Optional() {
        return getSomeEnumOf8Optional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject resetSomeEnumOf8Optional() {
        setSomeEnumOf8Optional(null);
        return this;
    }
    //endregion

    //region > someEnumOf8Hidden (property)
    private EnumOf8 someEnumOf8Hidden;

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public EnumOf8 getSomeEnumOf8Hidden() {
        return someEnumOf8Hidden;
    }

    public void setSomeEnumOf8Hidden(final EnumOf8 someEnumOf8Hidden) {
        this.someEnumOf8Hidden = someEnumOf8Hidden;
    }

    //endregion

    //region > someEnumOf8Disabled (property)
    private EnumOf8 someEnumOf8Disabled;

    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public EnumOf8 getSomeEnumOf8Disabled() {
        return someEnumOf8Disabled;
    }

    public void setSomeEnumOf8Disabled(final EnumOf8 someEnumOf8Disabled) {
        this.someEnumOf8Disabled = someEnumOf8Disabled;
    }

    //endregion

    //region > someEnumOf8WithValidation (property)
    private EnumOf8 someEnumOf8WithValidation;

    @Column(allowsNull = "false")
    public EnumOf8 getSomeEnumOf8WithValidation() {
        return someEnumOf8WithValidation;
    }

    public void setSomeEnumOf8WithValidation(final EnumOf8 someEnumOf8WithValidation) {
        this.someEnumOf8WithValidation = someEnumOf8WithValidation;
    }

    public String validateSomeEnumOf8WithValidation(final EnumOf8 i) {
        return i == EnumOf8.ABBEY_ROAD ? "Can't enter ABBEY_ROAD": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf8WithValidation(final EnumOf8 i) {
        setSomeEnumOf8WithValidation(i);
        return this;
    }

    public String validateUpdateSomeEnumOf8WithValidation(final EnumOf8 i) {
        return validateSomeEnumOf8WithValidation(i);
    }
    public EnumOf8 default0UpdateSomeEnumOf8WithValidation() {
        return getSomeEnumOf8WithValidation();
    }

    //endregion

    
    //region > compareTo

    @Override
    public int compareTo(EnumeratedObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
