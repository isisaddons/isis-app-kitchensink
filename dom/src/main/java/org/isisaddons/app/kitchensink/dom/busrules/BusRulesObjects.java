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
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.Disabled;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Hidden;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Bus Rules")
@DomainService(menuOrder = "10.1", repositoryFor = BusRulesObject.class)
public class BusRulesObjects  {

    private final Class<BusRulesObject> cls = BusRulesObject.class;


    @MemberOrder(sequence = "30")
    public BusRulesObject create(
            final @Named("Name") String name) {
        final BusRulesObject obj = container.newTransientInstance(BusRulesObject.class);
        obj.setName(name);

        container.persistIfNotAlready(obj);
        return obj;
    }

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    @Bookmarkable
    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "10")
    public BusRulesObject firstBusRulesObject() {
        final List<BusRulesObject> list = listAllBusRulesObject();
        return list.isEmpty()? null: list.get(0);
    }

    @Bookmarkable
    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "20")
    public List<BusRulesObject> listAllBusRulesObject() {
        return container.allInstances(cls);
    }

    @Bookmarkable
    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "30")
    @Disabled
    public List<BusRulesObject> listAllBusRulesObjectDisabled() {
        return listAllBusRulesObject();
    }

    @Bookmarkable
    @ActionSemantics(ActionSemantics.Of.SAFE)
    @MemberOrder(sequence = "40")
    @Hidden
    public List<BusRulesObject> listAllBusRulesObjectHidden() {
        return listAllBusRulesObject();
    }

    @javax.inject.Inject
    protected DomainObjectContainer container;

}
