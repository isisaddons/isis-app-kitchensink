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
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@ObjectType("WRAPPER")
@Bookmarkable
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperOptional(final @Optional Byte b) {
        setSomeByteWrapperOptional(b);
        return this;
    }

    public Byte default0UpdateSomeByteWrapperOptional() {
        return getSomeByteWrapperOptional();
    }
    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject resetSomeByteWrapperOptional() {
        setSomeByteWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someByteWrapperHidden (property)
    private java.lang.Byte someByteWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
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
    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeByteWrapperOptionalWithChoices(final @Optional Byte i) {
        setSomeByteWrapperOptionalWithChoices(i);
        return this;
    }
    public Byte default0UpdateSomeByteWrapperOptionalWithChoices() {
        return getSomeByteWrapperOptionalWithChoices();
    }
    public List<Byte> choices0UpdateSomeByteWrapperOptionalWithChoices() {
        return Lists.newArrayList((byte)1, (byte)2, (byte)3, (byte)4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperOptional(final @Optional Short s) {
        setSomeShortWrapperOptional(s);
        return this;
    }
    public Short default0UpdateSomeShortWrapperOptional() {
        return getSomeShortWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject resetSomeShortWrapperOptional() {
        setSomeShortWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someShortWrapperHidden (property)
    private java.lang.Short someShortWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
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
    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeShortWrapperOptionalWithChoices(final @Optional Short i) {
        setSomeShortWrapperOptionalWithChoices(i);
        return this;
    }
    public Short default0UpdateSomeShortWrapperOptionalWithChoices() {
        return getSomeShortWrapperOptionalWithChoices();
    }
    public List<Short> choices0UpdateSomeShortWrapperOptionalWithChoices() {
        return Lists.newArrayList((short)1, (short)2, (short)3, (short)4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperOptional(final @Optional Integer i) {
        setSomeIntegerWrapperOptional(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperOptional() {
        return getSomeIntegerWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject resetSomeIntegerWrapperOptional() {
        setSomeIntegerWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someIntegerWrapperHidden (property)
    private java.lang.Integer someIntegerWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
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
    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeIntegerWrapperOptionalWithChoices(final @Optional Integer i) {
        setSomeIntegerWrapperOptionalWithChoices(i);
        return this;
    }
    public Integer default0UpdateSomeIntegerWrapperOptionalWithChoices() {
        return getSomeIntegerWrapperOptionalWithChoices();
    }
    public List<Integer> choices0UpdateSomeIntegerWrapperOptionalWithChoices() {
        return Lists.newArrayList(1, 2, 3, 4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperOptional(final @Optional Long l) {
        setSomeLongWrapperOptional(l);
        return this;
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject resetSomeLongWrapperOptional() {
        setSomeLongWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someLongWrapperHidden (property)
    private java.lang.Long someLongWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
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
    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeLongWrapperOptionalWithChoices(final @Optional Long i) {
        setSomeLongWrapperOptionalWithChoices(i);
        return this;
    }
    public Long default0UpdateSomeLongWrapperOptionalWithChoices() {
        return getSomeLongWrapperOptionalWithChoices();
    }
    public List<Long> choices0UpdateSomeLongWrapperOptionalWithChoices() {
        return Lists.newArrayList(1L, 2L, 3L, 4L);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperOptional(final @Optional Float f) {
        setSomeFloatWrapperOptional(f);
        return this;
    }
    public Float default0UpdateSomeFloatWrapperOptional() {
        return getSomeFloatWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject resetSomeFloatWrapperOptional() {
        setSomeFloatWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someFloatWrapperHidden (property)
    private java.lang.Float someFloatWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
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
    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeFloatWrapperOptionalWithChoices(final @Optional Float i) {
        setSomeFloatWrapperOptionalWithChoices(i);
        return this;
    }
    public Float default0UpdateSomeFloatWrapperOptionalWithChoices() {
        return getSomeFloatWrapperOptionalWithChoices();
    }
    public List<Float> choices0UpdateSomeFloatWrapperOptionalWithChoices() {
        return Lists.newArrayList(1.1f, 2.2f, 3.3f, 4.4f);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperOptional(final @Optional Double d) {
        setSomeDoubleWrapperOptional(d);
        return this;
    }
    public Double default0UpdateSomeDoubleWrapperOptional() {
        return getSomeDoubleWrapperOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject resetSomeDoubleWrapperOptional() {
        setSomeDoubleWrapperOptional(null);
        return this;
    }
    //endregion

    //region > someDoubleWrapperHidden (property)
    private java.lang.Double someDoubleWrapperHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Hidden
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
    @Disabled
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public WrapperObject updateSomeDoubleWrapperOptionalWithChoices(final @Optional Double i) {
        setSomeDoubleWrapperOptionalWithChoices(i);
        return this;
    }
    public Double default0UpdateSomeDoubleWrapperOptionalWithChoices() {
        return getSomeDoubleWrapperOptionalWithChoices();
    }
    public List<Double> choices0UpdateSomeDoubleWrapperOptionalWithChoices() {
        return Lists.newArrayList(1.1, 2.2, 3.3, 4.4);
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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
