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
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Where;

@DomainService(
        nature = NatureOfService.DOMAIN, repositoryFor = OtherBoundedObject.class
)
public class OtherBoundedObjects extends RepositoryAbstract<OtherBoundedObject> {

    public OtherBoundedObjects() {
        super(OtherBoundedObject.class, Visibility.VISIBLE);
    }

    @Action(hidden = Where.EVERYWHERE, semantics = SemanticsOf.SAFE)
    @Override
    public OtherBoundedObject first() {
        return super.first();
    }

    @Action(hidden = Where.EVERYWHERE, semantics = SemanticsOf.SAFE)
    @Override
    public List<OtherBoundedObject> listAll() {
        return super.listAll();
    }

    @Action(hidden = Where.EVERYWHERE)
    public OtherBoundedObject create(
            final @ParameterLayout(named="Name") String name,
            final @ParameterLayout(named="Description") String description) {
        final OtherBoundedObject obj = container.newTransientInstance(OtherBoundedObject.class);
        obj.setName(name);
        obj.setDescription(description);

        container.persistIfNotAlready(obj);
        return obj;
    }

}
