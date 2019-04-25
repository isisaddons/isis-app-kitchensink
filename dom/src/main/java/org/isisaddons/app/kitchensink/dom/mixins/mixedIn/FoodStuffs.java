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
package org.isisaddons.app.kitchensink.dom.mixins.mixedIn;

import java.util.List;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(repositoryFor = FoodStuff.class)
public class FoodStuffs {

    private final Class<FoodStuff> cls = FoodStuff.class;

    public String iconName() {
        return cls.getSimpleName();
    }

    public String getId() {
        return "mixins." + getClass().getSimpleName();
    }

    @MemberOrder(sequence = "30")
    public FoodStuff createFoodStuff(
            @ParameterLayout(named="Name")
            final String name) {
        final FoodStuff obj = factoryService.instantiate(
                FoodStuff.class);
        obj.setName(name);

        repositoryService.persist(obj);
        return obj;
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "10")
    public FoodStuff firstFoodStuff() {
        final List<FoodStuff> list = listAllFoodStuffs();
        return list.isEmpty()? null: list.get(0);
    }

    @Action(semantics= SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "20")
    public List<FoodStuff> listAllFoodStuffs() {
        return repositoryService.allInstances(cls);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    @javax.inject.Inject
    FactoryService factoryService;

}
