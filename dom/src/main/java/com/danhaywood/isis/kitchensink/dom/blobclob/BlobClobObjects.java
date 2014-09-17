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
package com.danhaywood.isis.kitchensink.dom.blobclob;

import java.util.List;
import com.danhaywood.isis.kitchensink.dom.choice.ChoiceObject;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

@Named("Blob/Clob")
@DomainService(menuOrder = "10", repositoryFor = ChoiceObject.class)
public class BlobClobObjects {

    //region > identification in the UI

    public String getId() {
        return "blobClob";
    }

    public String iconName() {
        return "BlobClobObject";
    }

    //endregion

    //region > listAll (action)

    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<BlobClobObject> listAll() {
        return container.allInstances(BlobClobObject.class);
    }

    //endregion

    //region > create (action)

    @MemberOrder(sequence = "2")
    public BlobClobObject create(
            final @Named("Name") String name,
            final @Named("Some blob") @Optional Blob blob,
            final @Named("Some image") @Optional Blob image,
            final @Named("Some clob") @Optional Clob clob) {
        final BlobClobObject obj = container.newTransientInstance(BlobClobObject.class);
        obj.setName(name);

        obj.setSomeBlob(blob);
        obj.setSomeImage(image);
        obj.setSomeClob(clob);

        container.persistIfNotAlready(obj);
        return obj;
    }

    //endregion

    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion

}
