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
package org.isisaddons.app.kitchensink.dom.contrib.contributee;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Contributions")
@DomainService(menuOrder = "10.1", repositoryFor = FoodStuff.class)
public class FoodStuffs {

    private final Class<FoodStuff> cls = FoodStuff.class;

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }


    @MemberOrder(sequence = "30")
    public FoodStuff createFoodStuff(
            final @Named("Name") String name) {
        final FoodStuff obj = container.newTransientInstance(FoodStuff.class);
        obj.setName(name);

        container.persistIfNotAlready(obj);
        return obj;
    }

    @Bookmarkable
    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "10")
    public FoodStuff firstFoodStuff() {
        final List<FoodStuff> list = listAllFoodStuffs();
        return list.isEmpty()? null: list.get(0);
    }

    @Bookmarkable
    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "20")
    public List<FoodStuff> listAllFoodStuffs() {
        return container.allInstances(cls);
    }

    @javax.inject.Inject
    protected DomainObjectContainer container;

}
