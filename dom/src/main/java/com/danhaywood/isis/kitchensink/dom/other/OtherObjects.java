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
package com.danhaywood.isis.kitchensink.dom.other;

import java.util.List;
import com.danhaywood.isis.kitchensink.dom.text.TextObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

@Named("Others")
@DomainService(menuOrder = "90", repositoryFor = TextObject.class)
public class OtherObjects {

    //region > identification in the UI

    public String getId() {
        return "other";
    }

    public String iconName() {
        return "OtherObject";
    }

    //endregion

    //region > listAll (action)

    @Bookmarkable
    @Named("List Others")
    @ActionSemantics(Of.SAFE)
    @MemberOrder(name="Others", sequence = "10.1")
    public List<OtherObject> listAll() {
        return container.allInstances(OtherObject.class);
    }

    //endregion

    //region > create (action)

    @MemberOrder(name="Others", sequence = "10.2")
    public OtherObject create(
            final @Named("Name") String name,
            final @Named("Description") String description) {
        final OtherObject obj = container.newTransientInstance(OtherObject.class);
        obj.setName(name);
        obj.setDescription(description);

        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
