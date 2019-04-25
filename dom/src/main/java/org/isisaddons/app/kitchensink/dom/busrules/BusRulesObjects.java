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
package org.isisaddons.app.kitchensink.dom.busrules;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = BusRulesObject.class,
        objectType = "busrules.BusRulesObjects"
)
public class BusRulesObjects {

    private final static Class<BusRulesObject> cls = BusRulesObject.class;

    @MemberOrder(sequence = "30")
    public BusRulesObject createBusRulesObject(
            @ParameterLayout(named="Name")
            final String name) {
        return repositoryService.persist(new BusRulesObject(name));
    }

    @Action(semantics= SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "10")
    public BusRulesObject firstBusRulesObject() {
        return listAllBusRulesObject().stream().findFirst().orElse(null);
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "15")
    public BusRulesObject findBusRulesObject(
            @ParameterLayout(named="Name")
            final String name) {
        final List<BusRulesObject> list = listAllBusRulesObject();
        for (BusRulesObject busRulesObject : list) {
            if(Objects.equals(busRulesObject.getName(), name)) {
                return busRulesObject;
            }
        }
        return null;
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "18")
    public List<BusRulesObject> findMatchingBusRulesObject(
            @ParameterLayout(named="Name")
            final String name) {
        return listAllBusRulesObject().stream()
                .filter(x -> x.getName().contains(name))
                .collect(Collectors.toList());
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "20")
    public List<BusRulesObject> listAllBusRulesObject() {
        return repositoryService.allInstances(cls);
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "30")
    public List<BusRulesObject> listAllBusRulesObjectDisabled() {
        return listAllBusRulesObject();
    }

    public String disableListAllBusRulesObjectDisabled() {
        return "Always disabled";
    }
    @Action(
            semantics=SemanticsOf.SAFE,
            hidden = Where.EVERYWHERE
    )
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "40")
    public List<BusRulesObject> listAllBusRulesObjectHidden() {
        return listAllBusRulesObject();
    }

    @javax.inject.Inject
    RepositoryService repositoryService;

}
