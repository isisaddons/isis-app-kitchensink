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
package org.isisaddons.app.kitchensink.dom.javamath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import javax.validation.constraints.Digits;
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
        objectType = "NUMBER"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class JavaMathObject implements Entity<JavaMathObject> {

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


    //region > someBigIntegerMandatory (property)
    private BigInteger someBigIntegerMandatory;

    @Column(allowsNull = "false")
    public BigInteger getSomeBigIntegerMandatory() {
        return someBigIntegerMandatory;
    }

    public void setSomeBigIntegerMandatory(final BigInteger someBigIntegerMandatory) {
        this.someBigIntegerMandatory = someBigIntegerMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigIntegerMandatory(final BigInteger d) {
        setSomeBigIntegerMandatory(d);
        return this;
    }
    public BigInteger default0UpdateSomeBigIntegerMandatory() {
        return getSomeBigIntegerMandatory();
    }
    //endregion

    //region > someBigIntegerOptional (property)
    private BigInteger someBigIntegerOptional;

    @Column(allowsNull = "true")
    public BigInteger getSomeBigIntegerOptional() {
        return someBigIntegerOptional;
    }

    public void setSomeBigIntegerOptional(final BigInteger someBigIntegerOptional) {
        this.someBigIntegerOptional = someBigIntegerOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigIntegerOptional(
            @Parameter(optionality=Optionality.OPTIONAL)
            final  BigInteger d) {
        setSomeBigIntegerOptional(d);
        return this;
    }
    public BigInteger default0UpdateSomeBigIntegerOptional() {
        return getSomeBigIntegerOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject resetSomeBigIntegerOptional() {
        setSomeBigIntegerOptional(null);
        return this;
    }
    //endregion

    //region > someBigIntegerHidden (property)
    private java.math.BigInteger someBigIntegerHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.math.BigInteger getSomeBigIntegerHidden() {
        return someBigIntegerHidden;
    }

    public void setSomeBigIntegerHidden(final java.math.BigInteger someBigIntegerHidden) {
        this.someBigIntegerHidden = someBigIntegerHidden;
    }

    //endregion

    //region > someBigIntegerDisabled (property)
    private java.math.BigInteger someBigIntegerDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.math.BigInteger getSomeBigIntegerDisabled() {
        return someBigIntegerDisabled;
    }

    public void setSomeBigIntegerDisabled(final java.math.BigInteger someBigIntegerDisabled) {
        this.someBigIntegerDisabled = someBigIntegerDisabled;
    }

    //endregion

    //region > someBigIntegerWithValidation (property)
    private java.math.BigInteger someBigIntegerWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.math.BigInteger getSomeBigIntegerWithValidation() {
        return someBigIntegerWithValidation;
    }

    public void setSomeBigIntegerWithValidation(final java.math.BigInteger someBigIntegerWithValidation) {
        this.someBigIntegerWithValidation = someBigIntegerWithValidation;
    }

    public String validateSomeBigIntegerWithValidation(final java.math.BigInteger i) {
        return i.intValue() % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigIntegerWithValidation(final BigInteger i) {
        setSomeBigIntegerWithValidation(i);
        return this;
    }

    public String validateUpdateSomeBigIntegerWithValidation(final java.math.BigInteger i) {
        return validateSomeBigIntegerWithValidation(i);
    }
    public java.math.BigInteger default0UpdateSomeBigIntegerWithValidation() {
        return getSomeBigIntegerWithValidation();
    }

    //endregion

    //region > someBigIntegerMandatoryWithChoices (property)
    private java.math.BigInteger someBigIntegerMandatoryWithChoices;

    @Column(allowsNull = "false")
    public java.math.BigInteger getSomeBigIntegerMandatoryWithChoices() {
        return someBigIntegerMandatoryWithChoices;
    }

    public void setSomeBigIntegerMandatoryWithChoices(final java.math.BigInteger someBigIntegerMandatoryWithChoices) {
        this.someBigIntegerMandatoryWithChoices = someBigIntegerMandatoryWithChoices;
    }
    public Collection<java.math.BigInteger> choicesSomeBigIntegerMandatoryWithChoices() {
        return Lists.newArrayList(BigInteger.valueOf(1L), BigInteger.valueOf(2L), BigInteger.valueOf(3L), BigInteger.valueOf(4L));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigIntegerMandatoryWithChoices(final java.math.BigInteger i) {
        setSomeBigIntegerMandatoryWithChoices(i);
        return this;
    }
    public java.math.BigInteger default0UpdateSomeBigIntegerMandatoryWithChoices() {
        return getSomeBigIntegerMandatoryWithChoices();
    }
    public List<java.math.BigInteger> choices0UpdateSomeBigIntegerMandatoryWithChoices() {
        return Lists.newArrayList(BigInteger.valueOf(1L), BigInteger.valueOf(2L), BigInteger.valueOf(3L), BigInteger.valueOf(4L));
    }
    //endregion

    //region > someBigIntegerOptionalWithChoices (property)
    private java.math.BigInteger someBigIntegerOptionalWithChoices;

    @Column(allowsNull = "true")
    public java.math.BigInteger getSomeBigIntegerOptionalWithChoices() {
        return someBigIntegerOptionalWithChoices;
    }

    public void setSomeBigIntegerOptionalWithChoices(final java.math.BigInteger someBigIntegerOptionalWithChoices) {
        this.someBigIntegerOptionalWithChoices = someBigIntegerOptionalWithChoices;
    }
    public Collection<java.math.BigInteger> choicesSomeBigIntegerOptionalWithChoices() {
        return Lists.newArrayList(BigInteger.valueOf(1L), BigInteger.valueOf(2L), BigInteger.valueOf(3L), BigInteger.valueOf(4L));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigIntegerOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.math.BigInteger i) {
        setSomeBigIntegerOptionalWithChoices(i);
        return this;
    }
    public java.math.BigInteger default0UpdateSomeBigIntegerOptionalWithChoices() {
        return getSomeBigIntegerOptionalWithChoices();
    }
    public List<java.math.BigInteger> choices0UpdateSomeBigIntegerOptionalWithChoices() {
        return Lists.newArrayList(BigInteger.valueOf(1L), BigInteger.valueOf(2L), BigInteger.valueOf(3L), BigInteger.valueOf(4L));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject resetSomeBigIntegerOptionalWithChoices() {
        setSomeBigIntegerOptionalWithChoices(null);
        return this;
    }
    //endregion




    //region > someBigDecimalMandatory (property)
    private BigDecimal someBigDecimalMandatory;

    @Column(allowsNull = "false")
    public BigDecimal getSomeBigDecimalMandatory() {
        return someBigDecimalMandatory;
    }

    public void setSomeBigDecimalMandatory(final BigDecimal someBigDecimalMandatory) {
        this.someBigDecimalMandatory = someBigDecimalMandatory;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimalMandatory(final BigDecimal d) {
        setSomeBigDecimalMandatory(d);
        return this;
    }
    public BigDecimal default0UpdateSomeBigDecimalMandatory() {
        return getSomeBigDecimalMandatory();
    }
    //endregion

    //region > someBigDecimalOptional (property)
    private BigDecimal someBigDecimalOptional;

    @Column(allowsNull = "true")
    public BigDecimal getSomeBigDecimalOptional() {
        return someBigDecimalOptional;
    }

    public void setSomeBigDecimalOptional(final BigDecimal someBigDecimalOptional) {
        this.someBigDecimalOptional = someBigDecimalOptional;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimalOptional(@Parameter(optionality=Optionality.OPTIONAL) final  BigDecimal d) {
        setSomeBigDecimalOptional(d);
        return this;
    }
    public BigDecimal default0UpdateSomeBigDecimalOptional() {
        return getSomeBigDecimalOptional();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject resetSomeBigDecimalOptional() {
        setSomeBigDecimalOptional(null);
        return this;
    }
    //endregion

    //region > someBigDecimalHidden (property)
    private java.math.BigDecimal someBigDecimalHidden;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(hidden = Where.EVERYWHERE)
    public java.math.BigDecimal getSomeBigDecimalHidden() {
        return someBigDecimalHidden;
    }

    public void setSomeBigDecimalHidden(final java.math.BigDecimal someBigDecimalHidden) {
        this.someBigDecimalHidden = someBigDecimalHidden;
    }

    //endregion

    //region > someBigDecimalDisabled (property)
    private java.math.BigDecimal someBigDecimalDisabled;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.DISABLED)
    public java.math.BigDecimal getSomeBigDecimalDisabled() {
        return someBigDecimalDisabled;
    }

    public void setSomeBigDecimalDisabled(final java.math.BigDecimal someBigDecimalDisabled) {
        this.someBigDecimalDisabled = someBigDecimalDisabled;
    }

    //endregion

    //region > someBigDecimalWithValidation (property)
    private java.math.BigDecimal someBigDecimalWithValidation;

    @javax.jdo.annotations.Column(allowsNull = "false")
    public java.math.BigDecimal getSomeBigDecimalWithValidation() {
        return someBigDecimalWithValidation;
    }

    public void setSomeBigDecimalWithValidation(final java.math.BigDecimal someBigDecimalWithValidation) {
        this.someBigDecimalWithValidation = someBigDecimalWithValidation;
    }

    public String validateSomeBigDecimalWithValidation(final java.math.BigDecimal i) {
        return i.intValue() % 2 != 0? "Can only enter even numbers": null;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimalWithValidation(final BigDecimal i) {
        setSomeBigDecimalWithValidation(i);
        return this;
    }

    public String validateUpdateSomeBigDecimalWithValidation(final java.math.BigDecimal i) {
        return validateSomeBigDecimalWithValidation(i);
    }
    public java.math.BigDecimal default0UpdateSomeBigDecimalWithValidation() {
        return getSomeBigDecimalWithValidation();
    }

    //endregion

    //region > someBigDecimalMandatoryWithChoices (property)
    private java.math.BigDecimal someBigDecimalMandatoryWithChoices;

    @Column(allowsNull = "false")
    public java.math.BigDecimal getSomeBigDecimalMandatoryWithChoices() {
        return someBigDecimalMandatoryWithChoices;
    }

    public void setSomeBigDecimalMandatoryWithChoices(final java.math.BigDecimal someBigDecimalMandatoryWithChoices) {
        this.someBigDecimalMandatoryWithChoices = someBigDecimalMandatoryWithChoices;
    }
    public Collection<java.math.BigDecimal> choicesSomeBigDecimalMandatoryWithChoices() {
        return Lists.newArrayList(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2), BigDecimal.valueOf(3.3), BigDecimal.valueOf(4.4));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimalMandatoryWithChoices(final java.math.BigDecimal i) {
        setSomeBigDecimalMandatoryWithChoices(i);
        return this;
    }
    public java.math.BigDecimal default0UpdateSomeBigDecimalMandatoryWithChoices() {
        return getSomeBigDecimalMandatoryWithChoices();
    }
    public List<java.math.BigDecimal> choices0UpdateSomeBigDecimalMandatoryWithChoices() {
        return Lists.newArrayList(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2), BigDecimal.valueOf(3.3), BigDecimal.valueOf(4.4));
    }
    //endregion

    //region > someBigDecimalOptionalWithChoices (property)
    private java.math.BigDecimal someBigDecimalOptionalWithChoices;

    @Column(allowsNull = "true")
    public java.math.BigDecimal getSomeBigDecimalOptionalWithChoices() {
        return someBigDecimalOptionalWithChoices;
    }

    public void setSomeBigDecimalOptionalWithChoices(final java.math.BigDecimal someBigDecimalOptionalWithChoices) {
        this.someBigDecimalOptionalWithChoices = someBigDecimalOptionalWithChoices;
    }
    public Collection<java.math.BigDecimal> choicesSomeBigDecimalOptionalWithChoices() {
        return Lists.newArrayList(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2), BigDecimal.valueOf(3.3), BigDecimal.valueOf(4.4));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimalOptionalWithChoices(@Parameter(optionality=Optionality.OPTIONAL) final  java.math.BigDecimal i) {
        setSomeBigDecimalOptionalWithChoices(i);
        return this;
    }
    public java.math.BigDecimal default0UpdateSomeBigDecimalOptionalWithChoices() {
        return getSomeBigDecimalOptionalWithChoices();
    }
    public List<java.math.BigDecimal> choices0UpdateSomeBigDecimalOptionalWithChoices() {
        return Lists.newArrayList(BigDecimal.valueOf(1.1), BigDecimal.valueOf(2.2), BigDecimal.valueOf(3.3), BigDecimal.valueOf(4.4));
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject resetSomeBigDecimalOptionalWithChoices() {
        setSomeBigDecimalOptionalWithChoices(null);
        return this;
    }
    //endregion




    //region > someBigDecimal92 (property)
    private BigDecimal someBigDecimal92;

    @Digits(integer = 9, fraction = 2)
    @Column(allowsNull = "true")
    public BigDecimal getSomeBigDecimal92() {
        return someBigDecimal92;
    }

    public void setSomeBigDecimal92(final BigDecimal someBigDecimal92) {
        this.someBigDecimal92 = someBigDecimal92;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimal92(@Parameter(optionality=Optionality.OPTIONAL) final  @Digits(integer = 9, fraction = 2) BigDecimal d) {
        setSomeBigDecimal92(d);
        return this;
    }

    public BigDecimal default0UpdateSomeBigDecimal92() {
        return getSomeBigDecimal92();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject resetSomeBigDecimal92() {
        setSomeBigDecimal92(null);
        return this;
    }
    //endregion

    //region > someBigDecimal124 (property)
    private BigDecimal someBigDecimal124;

    @Digits(integer = 12, fraction = 4)
    @Column(allowsNull = "true")
    public BigDecimal getSomeBigDecimal124() {
        return someBigDecimal124;
    }

    public void setSomeBigDecimal124(final BigDecimal someBigDecimal124) {
        this.someBigDecimal124 = someBigDecimal124;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimal124(@Parameter(optionality=Optionality.OPTIONAL) final  @Digits(integer = 12, fraction = 4) BigDecimal d) {
        setSomeBigDecimal124(d);
        return this;
    }

    public BigDecimal default0UpdateSomeBigDecimal124() {
        return getSomeBigDecimal124();
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public JavaMathObject resetSomeBigDecimal124() {
        setSomeBigDecimal124(null);
        return this;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(JavaMathObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion

}
