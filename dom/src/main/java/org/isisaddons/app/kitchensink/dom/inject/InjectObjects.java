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
package org.isisaddons.app.kitchensink.dom.inject;

import java.util.List;
import java.util.Objects;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

@DomainService(
        repositoryFor = InjectObject.class
)
@DomainServiceLayout(
        menuOrder = "10.1",
        named="Inject"
)
public class InjectObjects {

    private final Class<InjectObject> cls = InjectObject.class;

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    @MemberOrder(sequence = "30")
    public InjectObject createInjectObject(
            final @ParameterLayout(named = "Name") String name) {
        final InjectObject obj = container.newTransientInstance(InjectObject.class);
        obj.setName(name);

        container.persistIfNotAlready(obj);
        return obj;
    }

    @Action(semantics= SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "10")
    public InjectObject firstInjectObject() {
        final List<InjectObject> list = listAllInjectObject();
        return list.isEmpty()? null: list.get(0);
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "15")
    public InjectObject findInjectObject(final @ParameterLayout(named = "Name") String name) {
        final List<InjectObject> list = listAllInjectObject();
        for (InjectObject injectObject : list) {
            if(Objects.equals(injectObject.getName(), name)) {
                return injectObject;
            }
        }
        return null;
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "20")
    public List<InjectObject> listAllInjectObject() {
        return container.allInstances(cls);
    }

    @javax.inject.Inject
    protected DomainObjectContainer container;

}
