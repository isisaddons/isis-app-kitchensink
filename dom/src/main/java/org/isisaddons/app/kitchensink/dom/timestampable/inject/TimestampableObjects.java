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
package org.isisaddons.app.kitchensink.dom.timestampable.inject;

import java.util.List;
import java.util.Objects;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = TimestampableObject.class
)
public class TimestampableObjects {

    private final Class<TimestampableObject> cls = TimestampableObject.class;

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    @MemberOrder(sequence = "30")
    public TimestampableObject createTimestampableObject(
            @ParameterLayout(named = "Name")
            final String name) {
        final TimestampableObject obj = factoryService.instantiate(cls);
        obj.setName(name);

        repositoryService.persist(obj);
        return obj;
    }

    @Action(semantics= SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "10")
    public TimestampableObject firstTimestampableObject() {
        final List<TimestampableObject> list = listAllTimestampableObjects();
        return list.isEmpty()? null: list.get(0);
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "15")
    public TimestampableObject findTimestampableObject(
            @ParameterLayout(named = "Name")
            final String name) {
        final List<TimestampableObject> list = listAllTimestampableObjects();
        for (TimestampableObject timestampableObject : list) {
            if(Objects.equals(timestampableObject.getName(), name)) {
                return timestampableObject;
            }
        }
        return null;
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "20")
    public List<TimestampableObject> listAllTimestampableObjects() {
        return repositoryService.allInstances(cls);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;
    @javax.inject.Inject
    FactoryService factoryService;

}
