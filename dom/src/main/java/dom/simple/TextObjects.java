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

@DomainService(menuOrder = "10", repositoryFor = TextObject.class)
public class TextObjects {

    //region > identification in the UI

    public String getId() {
        return "text";
    }

    public String iconName() {
        return "TextObject";
    }

    //endregion

    //region > listAll (action)

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<TextObject> listAll() {
        return container.allInstances(TextObject.class);
    }

    //endregion

    //region > create (action)

    @MemberOrder(sequence = "2")
    public TextObject create(
            final @Named("Name") String name) {
        final TextObject obj = container.newTransientInstance(TextObject.class);
        obj.setName(name);

        obj.setSomeChar(name.charAt(0));
        obj.setSomeCharacterWrapperMandatory(name.charAt(0));
        obj.setSomeCharacterWrapperOptional(name.charAt(0));

        obj.setSomeStringMandatory(name);
        obj.setSomeStringOptional(name);
        obj.setSomeString20(name);
        obj.setSomeString50(name);
        obj.setSomeStringMulti(name);
        obj.setSomeStringMultiNoWrap(name);

        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
