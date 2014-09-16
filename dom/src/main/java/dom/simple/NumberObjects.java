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
package dom.simple;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

@DomainService(menuOrder = "10", repositoryFor = NumberObject.class)
public class NumberObjects {

    //region > identification in the UI

    public String getId() {
        return "number";
    }

    public String iconName() {
        return "NumberObject";
    }

    //endregion

    //region > listAll (action)

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<NumberObject> listAll() {
        return container.allInstances(NumberObject.class);
    }

    //endregion

    //region > create (action)

    @MemberOrder(sequence = "2")
    public NumberObject create(
            final @Named("Name") String name,
            final @Named("Byte") byte b,
            final @Named("Short") short s,
            final @Named("Int") int i,
            final @Named("Long") long l,
            final @Named("Float") float f,
            final @Named("Double") double d) {
        final NumberObject obj = container.newTransientInstance(NumberObject.class);
        obj.setName(name);

        obj.setSomeByte(b);
        obj.setSomeShort(s);
        obj.setSomeInt(i);
        obj.setSomeLong(l);
        obj.setSomeFloat(f);
        obj.setSomeDouble(d);

        obj.setSomeByteWrapperMandatory(b);
        obj.setSomeShortWrapperMandatory(s);
        obj.setSomeIntegerWrapperMandatory(i);
        obj.setSomeLongWrapperMandatory(l);
        obj.setSomeFloatWrapperMandatory(f);
        obj.setSomeDoubleWrapperMandatory(d);

        obj.setSomeByteWrapperOptional(b);
        obj.setSomeShortWrapperOptional(s);
        obj.setSomeIntegerWrapperOptional(i);
        obj.setSomeLongWrapperOptional(l);
        obj.setSomeFloatWrapperOptional(f);
        obj.setSomeDoubleWrapperOptional(d);

        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
