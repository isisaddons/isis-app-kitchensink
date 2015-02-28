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
package org.isisaddons.app.kitchensink.dom.wrapper;

import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.Entity;
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

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "WRAPPER"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class WrapperObject implements Entity<WrapperObject> {

    //region > name (property)

    private String name;

    @javax.jdo.annotations.Column(allowsNull="false")
    @Title(sequence="1")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //endregion


    //region > someByteWrapperMandatory (property)
    private Byte someByteWrapperMandatory;

    @Column(allowsNull = "false")
    public Byte getSomeByteWrapperMandatory() {
        return someByteWrapperMandatory;
    }

    public void setSomeByteWrapperMandatory(final Byte someByteWrapperMandatory) {
        this.someByteWrapperMandatory = someByteWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperMandatory(final Byte b) {
        setSomeByteWrapperMandatory(b);
        return this;
    }
    public Byte default0UpdateSomeByteWrapperMandatory() {
        return getSomeByteWrapperMandatory();
    }
    //endregion

    //region > someByteWrapperOptional (property)
    private Byte someByteWrapperOptional;

    @Column(allowsNull = "true")
    public Byte getSomeByteWrapperOptional() {
        return someByteWrapperOptional;
    }

    public void setSomeByteWrapperOptional(final Byte someByteWrapperOptional) {
        this.someByteWrapperOptional = someByteWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Byte b) {
        setSomeByteWrapperOptional(b);
        return this;
    }

    public Byte default0UpdateSomeByteWrapperOptional() {
        return getSomeByteWrapperOptional();
    }
    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeByteWrapperOptional() {
        setSomeByteWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someByteWrapperHidden (property)
    private java.lang.Byte someByteWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Byte getSomeByteWrapperHidden() {
        return someByteWrapperHidden;
    }

    public void setSomeByteWrapperHidden(final java.lang.Byte someByteWrapperHidden) {
        this.someByteWrapperHidden = someByteWrapperHidden;
    }

    //endregion

    //region > someByteWrapperDisabled (property)
    private java.lang.Byte someByteWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Byte getSomeByteWrapperDisabled() {
        return someByteWrapperDisabled;
    }

    public void setSomeByteWrapperDisabled(final java.lang.Byte someByteWrapperDisabled) {
        this.someByteWrapperDisabled = someByteWrapperDisabled;
    }

    //endregion

    //region > someByteWrapperWithValidation (property)
    private java.lang.Byte someByteWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Byte getSomeByteWrapperWithValidation() {
        return someByteWrapperWithValidation;
    }

    public void setSomeByteWrapperWithValidation(final java.lang.Byte someByteWrapperWithValidation) {
        this.someByteWrapperWithValidation = someByteWrapperWithValidation;
    }

    public String validateSomeByteWrapperWithValidation(final java.lang.Byte i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperWithValidation(final java.lang.Byte i) {
        setSomeByteWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeByteWrapperWithValidation(final java.lang.Byte i) {
        return validateSomeByteWrapperWithValidation(i);
    }
    public java.lang.Byte default0UpdateSomeByteWrapperWithValidation() {
        return getSomeByteWrapperWithValidation();
    }

    //endregion

    //region > someByteWrapperMandatoryWithChoices (property)
    private Byte someByteWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Byte getSomeByteWrapperMandatoryWithChoices() {
        return someByteWrapperMandatoryWithChoices;
    }

    public void setSomeByteWrapperMandatoryWithChoices(final Byte someByteWrapperMandatoryWithChoices) {
        this.someByteWrapperMandatoryWithChoices = someByteWrapperMandatoryWithChoices;
    }
    public Collection<Byte> choicesSomeByteWrapperMandatoryWithChoices() {
        return Lists.newArrayList((byte)1, (byte)2, (byte)3, (byte)4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperMandatoryWithChoices(final Byte i) {
        setSomeByteWrapperMandatoryWithChoices(i);
        return this;
    }
    public Byte default0UpdateSomeByteWrapperMandatoryWithChoices() {
        return getSomeByteWrapperMandatoryWithChoices();
    }
    public List<Byte> choices0UpdateSomeByteWrapperMandatoryWithChoices() {
        return Lists.newArrayList((byte)1, (byte)2, (byte)3, (byte)4);
    }
    //endregion

    //region > someByteWrapperOptionalWithChoices (property)
    private Byte someByteWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Byte getSomeByteWrapperOptionalWithChoices() {
        return someByteWrapperOptionalWithChoices;
    }

    public void setSomeByteWrapperOptionalWithChoices(final Byte someByteWrapperOptionalWithChoices) {
        this.someByteWrapperOptionalWithChoices = someByteWrapperOptionalWithChoices;
    }
    public Collection<Byte> choicesSomeByteWrapperOptionalWithChoices() {
        return Lists.newArrayList((byte)1, (byte)2, (byte)3, (byte)4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Byte i) {
        setSomeByteWrapperOptionalWithChoices(i);
        return this;
    }
    public Byte default0UpdateSomeByteWrapperOptionalWithChoices() {
        return getSomeByteWrapperOptionalWithChoices();
    }
    public List<Byte> choices0UpdateSomeByteWrapperOptionalWithChoices() {
        return Lists.newArrayList((byte)1, (byte)2, (byte)3, (byte)4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeByteWrapperOptionalWithChoices() {
        setSomeByteWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion



    //region > someShortWrapperMandatory (property)
    private Short someShortWrapperMandatory;

    @Column(allowsNull = "false")
    public Short getSomeShortWrapperMandatory() {
        return someShortWrapperMandatory;
    }

    public void setSomeShortWrapperMandatory(final Short someShortWrapperMandatory) {
        this.someShortWrapperMandatory = someShortWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperMandatory(final Short s) {
        setSomeShortWrapperMandatory(s);
        return this;
    }
    public Short default0UpdateSomeShortWrapperMandatory() {
        return getSomeShortWrapperMandatory();
    }
    //endregion

    //region > someShortWrapperOptional (property)
    private Short someShortWrapperOptional;

    @Column(allowsNull = "true")
    public Short getSomeShortWrapperOptional() {
        return someShortWrapperOptional;
    }

    public void setSomeShortWrapperOptional(final Short someShortWrapperOptional) {
        this.someShortWrapperOptional = someShortWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Short s) {
        setSomeShortWrapperOptional(s);
        return this;
    }
    public Short default0UpdateSomeShortWrapperOptional() {
        return getSomeShortWrapperOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeShortWrapperOptional() {
        setSomeShortWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someShortWrapperHidden (property)
    private java.lang.Short someShortWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Short getSomeShortWrapperHidden() {
        return someShortWrapperHidden;
    }

    public void setSomeShortWrapperHidden(final java.lang.Short someShortWrapperHidden) {
        this.someShortWrapperHidden = someShortWrapperHidden;
    }

    //endregion

    //region > someShortWrapperDisabled (property)
    private java.lang.Short someShortWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Short getSomeShortWrapperDisabled() {
        return someShortWrapperDisabled;
    }

    public void setSomeShortWrapperDisabled(final java.lang.Short someShortWrapperDisabled) {
        this.someShortWrapperDisabled = someShortWrapperDisabled;
    }

    //endregion

    //region > someShortWrapperWithValidation (property)
    private java.lang.Short someShortWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Short getSomeShortWrapperWithValidation() {
        return someShortWrapperWithValidation;
    }

    public void setSomeShortWrapperWithValidation(final java.lang.Short someShortWrapperWithValidation) {
        this.someShortWrapperWithValidation = someShortWrapperWithValidation;
    }

    public String validateSomeShortWrapperWithValidation(final java.lang.Short i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperWithValidation(final java.lang.Short i) {
        setSomeShortWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeShortWrapperWithValidation(final java.lang.Short i) {
        return validateSomeShortWrapperWithValidation(i);
    }
    public java.lang.Short default0UpdateSomeShortWrapperWithValidation() {
        return getSomeShortWrapperWithValidation();
    }

    //endregion

    //region > someShortWrapperMandatoryWithChoices (property)
    private Short someShortWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Short getSomeShortWrapperMandatoryWithChoices() {
        return someShortWrapperMandatoryWithChoices;
    }

    public void setSomeShortWrapperMandatoryWithChoices(final Short someShortWrapperMandatoryWithChoices) {
        this.someShortWrapperMandatoryWithChoices = someShortWrapperMandatoryWithChoices;
    }
    public Collection<Short> choicesSomeShortWrapperMandatoryWithChoices() {
        return Lists.newArrayList((short)1, (short)2, (short)3, (short)4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperMandatoryWithChoices(final Short i) {
        setSomeShortWrapperMandatoryWithChoices(i);
        return this;
    }
    public Short default0UpdateSomeShortWrapperMandatoryWithChoices() {
        return getSomeShortWrapperMandatoryWithChoices();
    }
    public List<Short> choices0UpdateSomeShortWrapperMandatoryWithChoices() {
        return Lists.newArrayList((short)1, (short)2, (short)3, (short)4);
    }
    //endregion

    //region > someShortWrapperOptionalWithChoices (property)
    private Short someShortWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Short getSomeShortWrapperOptionalWithChoices() {
        return someShortWrapperOptionalWithChoices;
    }

    public void setSomeShortWrapperOptionalWithChoices(final Short someShortWrapperOptionalWithChoices) {
        this.someShortWrapperOptionalWithChoices = someShortWrapperOptionalWithChoices;
    }
    public Collection<Short> choicesSomeShortWrapperOptionalWithChoices() {
        return Lists.newArrayList((short)1, (short)2, (short)3, (short)4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Short i) {
        setSomeShortWrapperOptionalWithChoices(i);
        return this;
    }
    public Short default0UpdateSomeShortWrapperOptionalWithChoices() {
        return getSomeShortWrapperOptionalWithChoices();
    }
    public List<Short> choices0UpdateSomeShortWrapperOptionalWithChoices() {
        return Lists.newArrayList((short)1, (short)2, (short)3, (short)4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeShortWrapperOptionalWithChoices() {
        setSomeShortWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someIntegerWrapperMandatory (property)
    private Integer someIntegerWrapperMandatory;

    @Column(allowsNull = "false")
    public Integer getSomeIntegerWrapperMandatory() {
        return someIntegerWrapperMandatory;
    }

    public void setSomeIntegerWrapperMandatory(final Integer someIntegerWrapperMandatory) {
        this.someIntegerWrapperMandatory = someIntegerWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperMandatory(final Integer i) {
        setSomeIntegerWrapperMandatory(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperMandatory() {
        return getSomeIntegerWrapperMandatory();
    }
    //endregion

    //region > someIntegerWrapperOptional (property)
    private Integer someIntegerWrapperOptional;

    @Column(allowsNull = "true")
    public Integer getSomeIntegerWrapperOptional() {
        return someIntegerWrapperOptional;
    }

    public void setSomeIntegerWrapperOptional(final Integer someIntegerWrapperOptional) {
        this.someIntegerWrapperOptional = someIntegerWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Integer i) {
        setSomeIntegerWrapperOptional(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperOptional() {
        return getSomeIntegerWrapperOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeIntegerWrapperOptional() {
        setSomeIntegerWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someIntegerWrapperHidden (property)
    private java.lang.Integer someIntegerWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Integer getSomeIntegerWrapperHidden() {
        return someIntegerWrapperHidden;
    }

    public void setSomeIntegerWrapperHidden(final java.lang.Integer someIntegerWrapperHidden) {
        this.someIntegerWrapperHidden = someIntegerWrapperHidden;
    }

    //endregion

    //region > someIntegerWrapperDisabled (property)
    private java.lang.Integer someIntegerWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Integer getSomeIntegerWrapperDisabled() {
        return someIntegerWrapperDisabled;
    }

    public void setSomeIntegerWrapperDisabled(final java.lang.Integer someIntegerWrapperDisabled) {
        this.someIntegerWrapperDisabled = someIntegerWrapperDisabled;
    }

    //endregion

    //region > someIntegerWrapperWithValidation (property)
    private java.lang.Integer someIntegerWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Integer getSomeIntegerWrapperWithValidation() {
        return someIntegerWrapperWithValidation;
    }

    public void setSomeIntegerWrapperWithValidation(final java.lang.Integer someIntegerWrapperWithValidation) {
        this.someIntegerWrapperWithValidation = someIntegerWrapperWithValidation;
    }

    public String validateSomeIntegerWrapperWithValidation(final java.lang.Integer i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperWithValidation(final java.lang.Integer i) {
        setSomeIntegerWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeIntegerWrapperWithValidation(final java.lang.Integer i) {
        return validateSomeIntegerWrapperWithValidation(i);
    }
    public java.lang.Integer default0UpdateSomeIntegerWrapperWithValidation() {
        return getSomeIntegerWrapperWithValidation();
    }

    //endregion

    //region > someIntegerWrapperMandatoryWithChoices (property)
    private Integer someIntegerWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Integer getSomeIntegerWrapperMandatoryWithChoices() {
        return someIntegerWrapperMandatoryWithChoices;
    }

    public void setSomeIntegerWrapperMandatoryWithChoices(final Integer someIntegerWrapperMandatoryWithChoices) {
        this.someIntegerWrapperMandatoryWithChoices = someIntegerWrapperMandatoryWithChoices;
    }
    public Collection<Integer> choicesSomeIntegerWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperMandatoryWithChoices(final Integer i) {
        setSomeIntegerWrapperMandatoryWithChoices(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperMandatoryWithChoices() {
        return getSomeIntegerWrapperMandatoryWithChoices();
    }
    public List<Integer> choices0UpdateSomeIntegerWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1, 2, 3, 4);
    }
    //endregion

    //region > someIntegerWrapperOptionalWithChoices (property)
    private Integer someIntegerWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Integer getSomeIntegerWrapperOptionalWithChoices() {
        return someIntegerWrapperOptionalWithChoices;
    }

    public void setSomeIntegerWrapperOptionalWithChoices(final Integer someIntegerWrapperOptionalWithChoices) {
        this.someIntegerWrapperOptionalWithChoices = someIntegerWrapperOptionalWithChoices;
    }
    public Collection<Integer> choicesSomeIntegerWrapperOptionalWithChoices() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Integer i) {
        setSomeIntegerWrapperOptionalWithChoices(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperOptionalWithChoices() {
        return getSomeIntegerWrapperOptionalWithChoices();
    }
    public List<Integer> choices0UpdateSomeIntegerWrapperOptionalWithChoices() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeIntegerWrapperOptionalWithChoices() {
        setSomeIntegerWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someLongWrapperMandatory (property)
    private Long someLongWrapperMandatory;

    @Column(allowsNull = "false")
    public Long getSomeLongWrapperMandatory() {
        return someLongWrapperMandatory;
    }

    public void setSomeLongWrapperMandatory(final Long someLongWrapperMandatory) {
        this.someLongWrapperMandatory = someLongWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperMandatory(final Long l) {
        setSomeLongWrapperMandatory(l);
        return this;
    }
    public Long default0UpdateSomeLongWrapperMandatory() {
        return getSomeLongWrapperMandatory();
    }
    //endregion

    //region > someLongWrapperOptional (property)
    private Long someLongWrapperOptional;

    @Column(allowsNull = "true")
    public Long getSomeLongWrapperOptional() {
        return someLongWrapperOptional;
    }

    public void setSomeLongWrapperOptional(final Long someLongWrapperOptional) {
        this.someLongWrapperOptional = someLongWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Long l) {
        setSomeLongWrapperOptional(l);
        return this;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeLongWrapperOptional() {
        setSomeLongWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someLongWrapperHidden (property)
    private java.lang.Long someLongWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Long getSomeLongWrapperHidden() {
        return someLongWrapperHidden;
    }

    public void setSomeLongWrapperHidden(final java.lang.Long someLongWrapperHidden) {
        this.someLongWrapperHidden = someLongWrapperHidden;
    }

    //endregion

    //region > someLongWrapperDisabled (property)
    private java.lang.Long someLongWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Long getSomeLongWrapperDisabled() {
        return someLongWrapperDisabled;
    }

    public void setSomeLongWrapperDisabled(final java.lang.Long someLongWrapperDisabled) {
        this.someLongWrapperDisabled = someLongWrapperDisabled;
    }

    //endregion

    //region > someLongWrapperWithValidation (property)
    private java.lang.Long someLongWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Long getSomeLongWrapperWithValidation() {
        return someLongWrapperWithValidation;
    }

    public void setSomeLongWrapperWithValidation(final java.lang.Long someLongWrapperWithValidation) {
        this.someLongWrapperWithValidation = someLongWrapperWithValidation;
    }

    public String validateSomeLongWrapperWithValidation(final java.lang.Long i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperWithValidation(final java.lang.Long i) {
        setSomeLongWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeLongWrapperWithValidation(final java.lang.Long i) {
        return validateSomeLongWrapperWithValidation(i);
    }
    public java.lang.Long default0UpdateSomeLongWrapperWithValidation() {
        return getSomeLongWrapperWithValidation();
    }

    //endregion

    //region > someLongWrapperMandatoryWithChoices (property)
    private Long someLongWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Long getSomeLongWrapperMandatoryWithChoices() {
        return someLongWrapperMandatoryWithChoices;
    }

    public void setSomeLongWrapperMandatoryWithChoices(final Long someLongWrapperMandatoryWithChoices) {
        this.someLongWrapperMandatoryWithChoices = someLongWrapperMandatoryWithChoices;
    }
    public Collection<Long> choicesSomeLongWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1L, 2L, 3L, 4L);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperMandatoryWithChoices(final Long i) {
        setSomeLongWrapperMandatoryWithChoices(i);
        return this;
    }
    public Long default0UpdateSomeLongWrapperMandatoryWithChoices() {
        return getSomeLongWrapperMandatoryWithChoices();
    }
    public List<Long> choices0UpdateSomeLongWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1L, 2L, 3L, 4L);
    }
    //endregion

    //region > someLongWrapperOptionalWithChoices (property)
    private Long someLongWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Long getSomeLongWrapperOptionalWithChoices() {
        return someLongWrapperOptionalWithChoices;
    }

    public void setSomeLongWrapperOptionalWithChoices(final Long someLongWrapperOptionalWithChoices) {
        this.someLongWrapperOptionalWithChoices = someLongWrapperOptionalWithChoices;
    }
    public Collection<Long> choicesSomeLongWrapperOptionalWithChoices() {
        return Lists.newArrayList(1L, 2L, 3L, 4L);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Long i) {
        setSomeLongWrapperOptionalWithChoices(i);
        return this;
    }
    public Long default0UpdateSomeLongWrapperOptionalWithChoices() {
        return getSomeLongWrapperOptionalWithChoices();
    }
    public List<Long> choices0UpdateSomeLongWrapperOptionalWithChoices() {
        return Lists.newArrayList(1L, 2L, 3L, 4L);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeLongWrapperOptionalWithChoices() {
        setSomeLongWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someFloatWrapperMandatory (property)
    private Float someFloatWrapperMandatory;

    @Column(allowsNull = "false")
    public Float getSomeFloatWrapperMandatory() {
        return someFloatWrapperMandatory;
    }

    public void setSomeFloatWrapperMandatory(final Float someFloatWrapperMandatory) {
        this.someFloatWrapperMandatory = someFloatWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperMandatory(final Float f) {
        setSomeFloatWrapperMandatory(f);
        return this;
    }
    public Float default0UpdateSomeFloatWrapperMandatory() {
        return getSomeFloatWrapperMandatory();
    }
    //endregion

    //region > someFloatWrapperOptional (property)
    private Float someFloatWrapperOptional;

    @Column(allowsNull = "true")
    public Float getSomeFloatWrapperOptional() {
        return someFloatWrapperOptional;
    }

    public void setSomeFloatWrapperOptional(final Float someFloatWrapperOptional) {
        this.someFloatWrapperOptional = someFloatWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Float f) {
        setSomeFloatWrapperOptional(f);
        return this;
    }
    public Float default0UpdateSomeFloatWrapperOptional() {
        return getSomeFloatWrapperOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeFloatWrapperOptional() {
        setSomeFloatWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someFloatWrapperHidden (property)
    private java.lang.Float someFloatWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Float getSomeFloatWrapperHidden() {
        return someFloatWrapperHidden;
    }

    public void setSomeFloatWrapperHidden(final java.lang.Float someFloatWrapperHidden) {
        this.someFloatWrapperHidden = someFloatWrapperHidden;
    }

    //endregion

    //region > someFloatWrapperDisabled (property)
    private java.lang.Float someFloatWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Float getSomeFloatWrapperDisabled() {
        return someFloatWrapperDisabled;
    }

    public void setSomeFloatWrapperDisabled(final java.lang.Float someFloatWrapperDisabled) {
        this.someFloatWrapperDisabled = someFloatWrapperDisabled;
    }

    //endregion

    //region > someFloatWrapperWithValidation (property)
    private java.lang.Float someFloatWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Float getSomeFloatWrapperWithValidation() {
        return someFloatWrapperWithValidation;
    }

    public void setSomeFloatWrapperWithValidation(final java.lang.Float someFloatWrapperWithValidation) {
        this.someFloatWrapperWithValidation = someFloatWrapperWithValidation;
    }

    public String validateSomeFloatWrapperWithValidation(final java.lang.Float i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperWithValidation(final java.lang.Float i) {
        setSomeFloatWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeFloatWrapperWithValidation(final java.lang.Float i) {
        return validateSomeFloatWrapperWithValidation(i);
    }
    public java.lang.Float default0UpdateSomeFloatWrapperWithValidation() {
        return getSomeFloatWrapperWithValidation();
    }

    //endregion

    //region > someFloatWrapperMandatoryWithChoices (property)
    private Float someFloatWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Float getSomeFloatWrapperMandatoryWithChoices() {
        return someFloatWrapperMandatoryWithChoices;
    }

    public void setSomeFloatWrapperMandatoryWithChoices(final Float someFloatWrapperMandatoryWithChoices) {
        this.someFloatWrapperMandatoryWithChoices = someFloatWrapperMandatoryWithChoices;
    }
    public Collection<Float> choicesSomeFloatWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperMandatoryWithChoices(final Float i) {
        setSomeFloatWrapperMandatoryWithChoices(i);
        return this;
    }
    public Float default0UpdateSomeFloatWrapperMandatoryWithChoices() {
        return getSomeFloatWrapperMandatoryWithChoices();
    }
    public List<Float> choices0UpdateSomeFloatWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
    }
    //endregion

    //region > someFloatWrapperOptionalWithChoices (property)
    private Float someFloatWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Float getSomeFloatWrapperOptionalWithChoices() {
        return someFloatWrapperOptionalWithChoices;
    }

    public void setSomeFloatWrapperOptionalWithChoices(final Float someFloatWrapperOptionalWithChoices) {
        this.someFloatWrapperOptionalWithChoices = someFloatWrapperOptionalWithChoices;
    }
    public Collection<Float> choicesSomeFloatWrapperOptionalWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Float i) {
        setSomeFloatWrapperOptionalWithChoices(i);
        return this;
    }
    public Float default0UpdateSomeFloatWrapperOptionalWithChoices() {
        return getSomeFloatWrapperOptionalWithChoices();
    }
    public List<Float> choices0UpdateSomeFloatWrapperOptionalWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeFloatWrapperOptionalWithChoices() {
        setSomeFloatWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > someDoubleWrapperMandatory (property)
    private Double someDoubleWrapperMandatory;

    @Column(allowsNull = "false")
    public Double getSomeDoubleWrapperMandatory() {
        return someDoubleWrapperMandatory;
    }

    public void setSomeDoubleWrapperMandatory(final Double someDoubleWrapperMandatory) {
        this.someDoubleWrapperMandatory = someDoubleWrapperMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperMandatory(final Double d) {
        setSomeDoubleWrapperMandatory(d);
        return this;
    }
    public Double default0UpdateSomeDoubleWrapperMandatory() {
        return getSomeDoubleWrapperMandatory();
    }
    //endregion

    //region > someDoubleWrapperOptional (property)
    private Double someDoubleWrapperOptional;

    @Column(allowsNull = "true")
    public Double getSomeDoubleWrapperOptional() {
        return someDoubleWrapperOptional;
    }

    public void setSomeDoubleWrapperOptional(final Double someDoubleWrapperOptional) {
        this.someDoubleWrapperOptional = someDoubleWrapperOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperOptional(@Parameter(optionality=Optionality.OPTIONAL) final  Double d) {
        setSomeDoubleWrapperOptional(d);
        return this;
    }
    public Double default0UpdateSomeDoubleWrapperOptional() {
        return getSomeDoubleWrapperOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeDoubleWrapperOptional() {
        setSomeDoubleWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someDoubleWrapperHidden (property)
    private java.lang.Double someDoubleWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.lang.Double getSomeDoubleWrapperHidden() {
        return someDoubleWrapperHidden;
    }

    public void setSomeDoubleWrapperHidden(final java.lang.Double someDoubleWrapperHidden) {
        this.someDoubleWrapperHidden = someDoubleWrapperHidden;
    }

    //endregion

    //region > someDoubleWrapperDisabled (property)
    private java.lang.Double someDoubleWrapperDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.lang.Double getSomeDoubleWrapperDisabled() {
        return someDoubleWrapperDisabled;
    }

    public void setSomeDoubleWrapperDisabled(final java.lang.Double someDoubleWrapperDisabled) {
        this.someDoubleWrapperDisabled = someDoubleWrapperDisabled;
    }

    //endregion

    //region > someDoubleWrapperWithValidation (property)
    private java.lang.Double someDoubleWrapperWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.lang.Double getSomeDoubleWrapperWithValidation() {
        return someDoubleWrapperWithValidation;
    }

    public void setSomeDoubleWrapperWithValidation(final java.lang.Double someDoubleWrapperWithValidation) {
        this.someDoubleWrapperWithValidation = someDoubleWrapperWithValidation;
    }

    public String validateSomeDoubleWrapperWithValidation(final java.lang.Double i) {
        return i % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperWithValidation(final java.lang.Double i) {
        setSomeDoubleWrapperWithValidation(i);
        return this;
    }

    public String validateUpdateSomeDoubleWrapperWithValidation(final java.lang.Double i) {
        return validateSomeDoubleWrapperWithValidation(i);
    }
    public java.lang.Double default0UpdateSomeDoubleWrapperWithValidation() {
        return getSomeDoubleWrapperWithValidation();
    }

    //endregion

    //region > someDoubleWrapperMandatoryWithChoices (property)
    private Double someDoubleWrapperMandatoryWithChoices;

    @Column(allowsNull = "false")
    public Double getSomeDoubleWrapperMandatoryWithChoices() {
        return someDoubleWrapperMandatoryWithChoices;
    }

    public void setSomeDoubleWrapperMandatoryWithChoices(final Double someDoubleWrapperMandatoryWithChoices) {
        this.someDoubleWrapperMandatoryWithChoices = someDoubleWrapperMandatoryWithChoices;
    }
    public Collection<Double> choicesSomeDoubleWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperMandatoryWithChoices(final Double i) {
        setSomeDoubleWrapperMandatoryWithChoices(i);
        return this;
    }
    public Double default0UpdateSomeDoubleWrapperMandatoryWithChoices() {
        return getSomeDoubleWrapperMandatoryWithChoices();
    }
    public List<Double> choices0UpdateSomeDoubleWrapperMandatoryWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }
    //endregion

    //region > someDoubleWrapperOptionalWithChoices (property)
    private Double someDoubleWrapperOptionalWithChoices;

    @Column(allowsNull = "true")
    public Double getSomeDoubleWrapperOptionalWithChoices() {
        return someDoubleWrapperOptionalWithChoices;
    }

    public void setSomeDoubleWrapperOptionalWithChoices(final Double someDoubleWrapperOptionalWithChoices) {
        this.someDoubleWrapperOptionalWithChoices = someDoubleWrapperOptionalWithChoices;
    }
    public Collection<Double> choicesSomeDoubleWrapperOptionalWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  Double i) {
        setSomeDoubleWrapperOptionalWithChoices(i);
        return this;
    }
    public Double default0UpdateSomeDoubleWrapperOptionalWithChoices() {
        return getSomeDoubleWrapperOptionalWithChoices();
    }
    public List<Double> choices0UpdateSomeDoubleWrapperOptionalWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public WrapperObject resetSomeDoubleWrapperOptionalWithChoices() {
        setSomeDoubleWrapperOptionalWithChoices(null);
        return this;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(WrapperObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
