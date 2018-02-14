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
package org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = Layout_6_0_6_Object.class
)
@DomainServiceLayout(
        menuOrder = "10"
)
public class Layout_6_0_6_Objects extends RepositoryAbstract<Layout_6_0_6_Object> {

    public Layout_6_0_6_Objects() {
        super(Layout_6_0_6_Object.class, Visibility.NOT_VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public Layout_6_0_6_Object create(
            final String name) {
        final Layout_6_0_6_Object obj = repositoryService.instantiate(Layout_6_0_6_Object.class);
        obj.setName(name);

        obj.setSomeString1(name);
        obj.setSomeString2(name);
        obj.setSomeString3(name);
        obj.setSomeString4(name);
        obj.setSomeString5(name);
        obj.setSomeString6(name);

        repositoryService.persist(obj);
        return obj;
    }

}
