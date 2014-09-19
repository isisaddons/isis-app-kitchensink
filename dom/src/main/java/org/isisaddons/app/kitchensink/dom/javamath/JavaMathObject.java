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
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import javax.validation.constraints.Digits;
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
@ObjectType("NUMBER")
@Bookmarkable
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public JavaMathObject updateSomeBigIntegerOptional(final @Optional BigInteger d) {
        setSomeBigIntegerOptional(d);
        return this;
    }
    public BigInteger default0UpdateSomeBigIntegerOptional() {
        return getSomeBigIntegerOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public JavaMathObject resetSomeBigIntegerOptional() {
        setSomeBigIntegerOptional(null);
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimalOptional(final @Optional BigDecimal d) {
        setSomeBigDecimalOptional(d);
        return this;
    }
    public BigDecimal default0UpdateSomeBigDecimalOptional() {
        return getSomeBigDecimalOptional();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public JavaMathObject resetSomeBigDecimalOptional() {
        setSomeBigDecimalOptional(null);
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimal92(final @Optional @Digits(integer = 9, fraction = 2) BigDecimal d) {
        setSomeBigDecimal92(d);
        return this;
    }

    public BigDecimal default0UpdateSomeBigDecimal92() {
        return getSomeBigDecimal92();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
    public JavaMathObject updateSomeBigDecimal124(final @Optional @Digits(integer = 12, fraction = 4) BigDecimal d) {
        setSomeBigDecimal124(d);
        return this;
    }

    public BigDecimal default0UpdateSomeBigDecimal124() {
        return getSomeBigDecimal124();
    }

    @ActionSemantics(ActionSemantics.Of.IDEMPOTENT)
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
