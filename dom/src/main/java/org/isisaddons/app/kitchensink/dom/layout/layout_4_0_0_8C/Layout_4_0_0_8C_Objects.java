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
package org.isisaddons.app.kitchensink.dom.layout.layout_4_0_0_8C;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = Layout_4_0_0_8C_Object.class
)
public class Layout_4_0_0_8C_Objects extends RepositoryAbstract<Layout_4_0_0_8C_Object> {

    public Layout_4_0_0_8C_Objects() {
        super(Layout_4_0_0_8C_Object.class, Visibility.NOT_VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public Layout_4_0_0_8C_Object create(
            final String name) {
        final Layout_4_0_0_8C_Object obj = factoryService.instantiate(Layout_4_0_0_8C_Object.class);
        obj.setName(name);

        obj.setSomeString1(name);
        obj.setSomeString2(name);
        obj.setSomeString3(name);

        repositoryService.persist(obj);
        return obj;
    }

}
