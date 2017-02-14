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
package org.isisaddons.app.kitchensink.dom.blobclob;

import java.util.List;

import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = BlobClobObject.class
)
@DomainServiceLayout(
        named="Data Types",
        menuOrder = "10.7"
)
public class BlobClobObjects extends RepositoryAbstract<BlobClobObject> {

    public BlobClobObjects() {
        super(BlobClobObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public BlobClobObject createBlobClobObject(
            @ParameterLayout(named="Name")
            final String name,
            @ParameterLayout(named="Some blob") @Parameter(optionality=Optionality.OPTIONAL)
            final Blob blob,
            @ParameterLayout(named="Some image") @Parameter(optionality= Optionality.OPTIONAL)
            final Blob image,
            @ParameterLayout(named="Some clob") @Parameter(optionality=Optionality.OPTIONAL)
            final Clob clob) {
        final BlobClobObject obj = container.newTransientInstance(BlobClobObject.class);
        obj.setName(name);

        obj.setSomeBlob(blob);
        obj.setSomeImage(image);
        obj.setSomeClob(clob);

        container.persistIfNotAlready(obj);
        return obj;
    }

    @ActionLayout(named="First BlobClobObject")
    @Override
    public BlobClobObject first() {
        return super.first();
    }

    @ActionLayout(named="List All BlobClobObjects")
    @Override
    public List<BlobClobObject> listAll() {
        return super.listAll();
    }
}
