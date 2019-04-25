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
package org.isisaddons.app.kitchensink.dom.pages;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.NonRecoverableException;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.busrules.BusRulesObject;
import org.isisaddons.app.kitchensink.dom.busrules.BusRulesObjects;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY
)
public class Pages {


    @Action(semantics= SemanticsOf.SAFE)
    @MemberOrder(sequence = "10")
    public BusRulesObject entityPage() {
        return busRulesObjects.firstBusRulesObject();
    }

    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @Action(semantics=SemanticsOf.SAFE)
    @MemberOrder(sequence = "10")
    public List<BusRulesObject> standaloneCollection() {
        return busRulesObjects.listAllBusRulesObject();
    }

    @Action(semantics=SemanticsOf.SAFE)
    @MemberOrder(sequence = "30")
    public int scalarPageReturningInt() {
        return 5;
    }

    @Action(semantics=SemanticsOf.SAFE)
    @MemberOrder(sequence = "40")
    public String scalarPageReturningString() {
        return "Hi there!";
    }

    @Action(semantics=SemanticsOf.SAFE)
    @MemberOrder(sequence = "50")
    public void voidPage() {
    }

    @Action(semantics=SemanticsOf.SAFE)
    @MemberOrder(sequence = "60")
    public void errorPage() {
        throw new NonRecoverableException("Oh no, all gone wrong!");
    }


    @javax.inject.Inject
    protected DomainObjectContainer container;
    @javax.inject.Inject
    protected BusRulesObjects busRulesObjects;

}
