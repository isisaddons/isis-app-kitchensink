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
package org.isisaddons.app.kitchensink.dom.hierarchy.parent;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.query.QueryDefault;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = ParentObject.class
)
@DomainServiceLayout(menuOrder = "10")
public class ParentObjects extends RepositoryAbstract<ParentObject> {

    public ParentObjects() {
        super(ParentObject.class, Visibility.NOT_VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public ParentObject create(
            @ParameterLayout(named="Name")
            final String name) {
        return repositoryService.persist(ParentObject.create(name));
    }

    @MemberOrder(sequence = "30.2")
    public ParentObject findUnique(
            @ParameterLayout(named="Name")
            final String name) {
        return repositoryService.firstMatch(
                new QueryDefault<>(ParentObject.class,
                        "findUnique",
                        "name", name));
    }

}
