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

import com.google.common.collect.Lists;
import org.apache.isis.applib.annotation.*;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

import java.util.List;
import java.util.stream.Collectors;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = AutoObject.class)
public class AutoObjects extends RepositoryAbstract<AutoObject> {

    public AutoObjects() {
        super(AutoObject.class, Visibility.VISIBLE);
    }



    @Action(hidden = Where.EVERYWHERE, semantics = SemanticsOf.SAFE)
    @Override
    public AutoObject first() {
        return super.first();
    }

    @Action(hidden = Where.EVERYWHERE, semantics = SemanticsOf.SAFE)
    @Override
    public List<AutoObject> listAll() {
        return super.listAll();
    }


    @Action(
            semantics = SemanticsOf.SAFE,
            publishing = Publishing.ENABLED // even though this is enabled, is deliberately not honoured for autocomplete
    )
    public List<AutoObject> autoComplete(@MinLength(1) String searchTerm) {
        return Lists.newArrayList(
                listAll()
                        .stream()
                        .filter(x -> x.getName().contains(searchTerm))
                        .collect(Collectors.toList())
        );
    }


    @Action(hidden = Where.EVERYWHERE)
    public AutoObject create(
            final @ParameterLayout(named="Name") String name) {
        final AutoObject obj = factoryService.instantiate(AutoObject.class);
        obj.setName(name);

        repositoryService.persist(obj);
        return obj;
    }

}
