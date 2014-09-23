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
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Java Math")
@DomainService(menuOrder = "10", repositoryFor = JavaMathObject.class)
public class JavaMathObjects extends RepositoryAbstract<JavaMathObject> {

    public JavaMathObjects() {
        super(JavaMathObject.class);
    }


    @MemberOrder(sequence = "30")
    public JavaMathObject create(
            final @Named("Name") String name,
            final @Named("Long") long l,
            final @Named("Double") double d) {
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


}
