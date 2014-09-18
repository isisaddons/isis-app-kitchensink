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
package com.danhaywood.isis.kitchensink.dom.primitive;

import com.danhaywood.isis.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Primitive")
@DomainService(menuOrder = "10", repositoryFor = PrimitiveObject.class)
public class PrimitiveObjects extends RepositoryAbstract<PrimitiveObject> {

    public PrimitiveObjects() {
        super(PrimitiveObject.class);
    }

    @MemberOrder(sequence = "30")
    public PrimitiveObject create(
            final @Named("Name") String name,
            final @Named("Byte") byte b,
            final @Named("Short") short s,
            final @Named("Int") int i,
            final @Named("Long") long l,
            final @Named("Float") float f,
            final @Named("Double") double d) {
        final PrimitiveObject obj = container.newTransientInstance(PrimitiveObject.class);
        obj.setName(name);

        obj.setSomeByte(b);
        obj.setSomeShort(s);

        obj.setSomeInt(i);
        obj.setSomeIntHidden(i);
        obj.setSomeIntDisabled(i);
        obj.setSomeIntWithValidation(i);
        obj.setSomeIntWithChoices(i);
        obj.setSomeIntWithChoices(i);

        obj.setSomeLong(l);
        obj.setSomeFloat(f);
        obj.setSomeDouble(d);


        container.persistIfNotAlready(obj);
        return obj;
    }
}
