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

import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Optional;
import com.google.common.collect.Iterables;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObjects;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObjects;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObjects;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        menuOrder = "10.10"
)
public class HierarchyObjects {


    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "10")
    public ParentObject firstParent() {
        return parentObjects.first();
    }

    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "11")
    public ParentObject findParent(
            @ParameterLayout(named="Title")
            final String title) {
        final Optional<ParentObject> parentObjectIfAny =
                Iterables.tryFind(parentObjects.listAll(), input -> container.titleOf(input).contains(title));
        return parentObjectIfAny.orNull();
    }

    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "11.1")
    public ParentObject findParentUnique(String name) {
        return parentObjects.findUnique(name);
    }


    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "12")
    public List<ParentObject> allParents() {
        return parentObjects.listAll();
    }


    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "20")
    public ChildObject firstChild() {
        return childObjects.first();
    }


    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "21")
    public List<ChildObject> allChildren() {
        return childObjects.listAll();
    }



    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "30")
    public GrandchildObject firstGrandchild() {
        return grandchildObjects.first();
    }


    @Action(semantics = SemanticsOf.SAFE)
    @MemberOrder(sequence = "31")
    public List<GrandchildObject> allGrandChildren() {
        return grandchildObjects.listAll();
    }


    @Inject
    private ParentObjects parentObjects;

    @Inject
    private ChildObjects childObjects;

    @Inject
    private GrandchildObjects grandchildObjects;

    @Inject
    DomainObjectContainer container;


}
