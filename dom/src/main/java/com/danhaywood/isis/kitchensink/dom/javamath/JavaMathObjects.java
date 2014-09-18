/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
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
package com.danhaywood.isis.kitchensink.dom.javamath;

import java.math.BigDecimal;
import java.math.BigInteger;
import com.danhaywood.isis.kitchensink.dom.RepositoryAbstract;
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

        obj.setSomeBigIntegerMandatory(BigInteger.valueOf(l));
        obj.setSomeBigIntegerOptional(BigInteger.valueOf(l));

        obj.setSomeBigDecimalMandatory(BigDecimal.valueOf(d));
        obj.setSomeBigDecimalOptional(BigDecimal.valueOf(d));

        obj.setSomeBigDecimal92(BigDecimal.valueOf(d));

        container.persistIfNotAlready(obj);
        return obj;
    }


}
