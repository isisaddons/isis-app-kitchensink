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
