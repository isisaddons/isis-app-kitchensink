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
import java.util.List;

import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = JavaMathObject.class
)
@DomainServiceLayout(
        named="Data Types",
        menuOrder = "10.4"
)
public class JavaMathObjects extends RepositoryAbstract<JavaMathObject> {

    public JavaMathObjects() {
        super(JavaMathObject.class, Visibility.VISIBLE);
    }


    @MemberOrder(sequence = "30")
    public JavaMathObject createJavaMathObject(
            @ParameterLayout(named="Name")
            final String name,
            @ParameterLayout(named="Long")
            final long l,
            @ParameterLayout(named="Double")
            final double d) {
        final JavaMathObject obj = container.newTransientInstance(JavaMathObject.class);
        obj.setName(name);

        final BigInteger bi = BigInteger.valueOf(l);
        final BigDecimal bd = BigDecimal.valueOf(d);

        obj.setSomeBigIntegerMandatory(bi);
        obj.setSomeBigIntegerOptional(bi);
        obj.setSomeBigIntegerHidden(bi);
        obj.setSomeBigIntegerDisabled(bi);
        obj.setSomeBigIntegerWithValidation(bi);
        obj.setSomeBigIntegerMandatoryWithChoices(bi);
        obj.setSomeBigIntegerOptionalWithChoices(bi);

        obj.setSomeBigDecimalMandatory(bd);
        obj.setSomeBigDecimalOptional(bd);
        obj.setSomeBigDecimalHidden(bd);
        obj.setSomeBigDecimalDisabled(bd);
        obj.setSomeBigDecimalWithValidation(bd);
        obj.setSomeBigDecimalMandatoryWithChoices(bd);
        obj.setSomeBigDecimalOptionalWithChoices(bd);


        obj.setSomeBigDecimal92(bd);

        container.persistIfNotAlready(obj);
        return obj;
    }


    @ActionLayout(named="First JavaMathObject")
    @Override
    public JavaMathObject first() {
        return super.first();
    }

    @ActionLayout(named="List All JavaMathObjects")
    @Override
    public List<JavaMathObject> listAll() {
        return super.listAll();
    }


}
