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
package org.isisaddons.app.kitchensink.dom.layout.layout_3_4_5;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_4_4.Layout_4_4_4_Object;
import org.apache.isis.applib.annotation.CssClassFa;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;

@DomainService(menuOrder = "10", repositoryFor = Layout_4_4_4_Object.class)
public class Layout_3_4_5_Objects extends RepositoryAbstract<Layout_3_4_5_Object> {

    public Layout_3_4_5_Objects() {
        super(Layout_3_4_5_Object.class, Visibility.NOT_VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public Layout_3_4_5_Object create(
            final String name) {
        final Layout_3_4_5_Object obj = container.newTransientInstance(Layout_3_4_5_Object.class);
        obj.setName(name);

        obj.setSomeString1(name);
        obj.setSomeString2(name);
        obj.setSomeString3(name);
        obj.setSomeString4(name);
        obj.setSomeString5(name);
        obj.setSomeString6(name);

        container.persistIfNotAlready(obj);
        return obj;
    }

}
