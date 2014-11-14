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
package org.isisaddons.app.kitchensink.dom.hierarchy;

import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObjects;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObjects;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObjects;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;

@DomainService(menuOrder = "10.10")
public class HierarchyObjects {


    @MemberOrder(sequence = "10")
    public ParentObject firstParent() {
        return parentObjects.first();
    }

    @MemberOrder(sequence = "20")
    public ChildObject firstChild() {
        return childObjects.first();
    }

    @MemberOrder(sequence = "30")
    public GrandchildObject firstGrandchild() {
        return grandchildObjects.first();
    }


    @Inject
    private ParentObjects parentObjects;

    @Inject
    private ChildObjects childObjects;

    @Inject
    private GrandchildObjects grandchildObjects;

}
