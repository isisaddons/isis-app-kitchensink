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
package org.isisaddons.app.kitchensink.dom.other;

import java.util.List;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.CssClassFa;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.Named;

@Hidden
@DomainService(menuOrder = "90", repositoryFor = OtherBoundedObject.class)
public class OtherBoundedObjects extends RepositoryAbstract<OtherBoundedObject> {

    public OtherBoundedObjects() {
        super(OtherBoundedObject.class, Visibility.VISIBLE);
    }

    @Hidden
    @Override
    public OtherBoundedObject first() {
        return super.first();
    }

    @Hidden
    @Override
    public List<OtherBoundedObject> listAll() {
        return super.listAll();
    }

    @Hidden
    public OtherBoundedObject create(
            final @Named("Name") String name,
            final @Named("Description") String description) {
        final OtherBoundedObject obj = container.newTransientInstance(OtherBoundedObject.class);
        obj.setName(name);
        obj.setDescription(description);

        container.persistIfNotAlready(obj);
        return obj;
    }

}
