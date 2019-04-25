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

import javax.annotation.Nullable;
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

import lombok.Getter;
import lombok.Setter;

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

    @Column(allowsNull="false")
    @Title(sequence="1")
    @Getter @Setter
    private String name;



    //region > someBoolean (property)

    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private boolean someBoolean;

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeBoolean(final boolean b) {
        setSomeBoolean(b);
        return this;
    }
    public boolean default0UpdateSomeBoolean() {
        return isSomeBoolean();
    }
    //endregion


    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private boolean someBooleanHidden;


    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private boolean someBooleanDisabled;


    //region > someBooleanWithValidation (property)
    @Getter @Setter
    private boolean someBooleanWithValidation;

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
        return isSomeBooleanWithValidation();
    }

    //endregion



    //region > someBooleanWrapperMandatory (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private Boolean someBooleanWrapperMandatory;

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
    @Getter @Setter
    @Column(allowsNull = "true")
    private Boolean someBooleanWrapperOptional;

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


    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private java.lang.Boolean someBooleanWrapperHidden;


    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private java.lang.Boolean someBooleanWrapperDisabled;


    //region > someBooleanWrapperWithValidation (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private java.lang.Boolean someBooleanWrapperWithValidation;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private EnumOf3 someEnumOf3Mandatory;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private EnumOf3 someEnumOf3Optional;

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

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private EnumOf3 someEnumOf3Hidden;


    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private EnumOf3 someEnumOf3Disabled;


    //region > someEnumOf3WithValidation (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private EnumOf3 someEnumOf3WithValidation;

    public String validateSomeEnumOf3WithValidation(final EnumOf3 i) {
        return i == EnumOf3.AMEX ? "Can't enter AMEX": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3WithValidation(final EnumOf3 i, @Nullable String unused) {
        setSomeEnumOf3WithValidation(i);
        return this;
    }

    public String validateUpdateSomeEnumOf3WithValidation(final EnumOf3 i, String unused) {
        return validateSomeEnumOf3WithValidation(i);
    }
    public EnumOf3 default0UpdateSomeEnumOf3WithValidation() {
        return getSomeEnumOf3WithValidation();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public EnumeratedObject updateSomeEnumOf3WithPerArgValidation(
            final EnumOf3 i,
            @Nullable String unused) {
        setSomeEnumOf3WithValidation(i);
        return this;
    }

    // validate 0th arg
    public String validate0UpdateSomeEnumOf3WithPerArgValidation(final EnumOf3 i) {
        return validateSomeEnumOf3WithValidation(i);
    }
    // validate 0th arg
    public String validate1UpdateSomeEnumOf3WithPerArgValidation(final String dummy) {
        return dummy == null || dummy.startsWith("a") ? "dummy must be some string not starting with 'a'" : null;
    }
//    public EnumOf3 default0UpdateSomeEnumOf3WithPerArgValidation() {
//        return getSomeEnumOf3WithValidation();
//    }

    //endregion



    //region > someEnumOf4Mandatory (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private EnumOf4 someEnumOf4Mandatory;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private EnumOf4 someEnumOf4Optional;

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

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private EnumOf4 someEnumOf4Hidden;


    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private EnumOf4 someEnumOf4Disabled;


    //region > someEnumOf4WithValidation (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private EnumOf4 someEnumOf4WithValidation;

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
    @Column(allowsNull = "false")
    @Getter @Setter
    private EnumOf8 someEnumOf8Mandatory;

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
    @Column(allowsNull = "true")
    @Getter @Setter
    private EnumOf8 someEnumOf8Optional;


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

    @Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    @Getter @Setter
    private EnumOf8 someEnumOf8Hidden;


    @Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private EnumOf8 someEnumOf8Disabled;


    //region > someEnumOf8WithValidation (property)
    @Column(allowsNull = "false")
    @Getter @Setter
    private EnumOf8 someEnumOf8WithValidation;

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


    @Override
    public int compareTo(EnumeratedObject other) {
        return ObjectContracts.compare(this, other, "name");
    }


    @javax.inject.Inject
    DomainObjectContainer container;

}
