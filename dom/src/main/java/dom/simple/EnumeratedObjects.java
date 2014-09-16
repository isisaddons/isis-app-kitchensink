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

@DomainService(menuOrder = "10", repositoryFor = EnumeratedObject.class)
public class EnumeratedObjects {

    //region > identification in the UI

    public String getId() {
        return "enumerated";
    }

    public String iconName() {
        return "EnumeratedObject";
    }

    //endregion

    //region > listAll (action)

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<EnumeratedObject> listAll() {
        return container.allInstances(EnumeratedObject.class);
    }

    //endregion

    //region > create (action)

    @MemberOrder(sequence = "2")
    public EnumeratedObject create(
            final @Named("Name") String name,
            final boolean b,
            final EnumOf3 enumOf3,
            final EnumOf4 enumOf4,
            final EnumOf8 enumOf8) {
        final EnumeratedObject obj = container.newTransientInstance(EnumeratedObject.class);
        obj.setName(name);

        obj.setSomeBoolean(b);
        obj.setSomeBooleanWrapperMandatory(b);
        obj.setSomeBooleanWrapperOptional(b);

        obj.setSomeEnumOf3Mandatory(enumOf3);
        obj.setSomeEnumOf3Optional(enumOf3);

        obj.setSomeEnumOf4Mandatory(enumOf4);
        obj.setSomeEnumOf4Optional(enumOf4);

        obj.setSomeEnumOf8Mandatory(enumOf8);
        obj.setSomeEnumOf8Optional(enumOf8);

        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
