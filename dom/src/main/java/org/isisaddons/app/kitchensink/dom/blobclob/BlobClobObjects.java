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

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceObject;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

@Named("Blob/Clob")
@DomainService(menuOrder = "10.7", repositoryFor = ReferenceObject.class)
public class BlobClobObjects extends RepositoryAbstract<BlobClobObject> {

    public BlobClobObjects() {
        super(BlobClobObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
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


}
