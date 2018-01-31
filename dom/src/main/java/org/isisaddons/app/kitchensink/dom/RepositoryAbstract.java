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
package org.isisaddons.app.kitchensink.dom;

import java.util.List;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;

public abstract class RepositoryAbstract<T extends Entity> {

    private final Class<T> cls;

    public RepositoryAbstract(Class<T> cls, Visibility visibility) {
        this.cls = cls;
        this.visibility = visibility;
    }

    //region > visibility

    private final Visibility visibility;

    protected enum Visibility {
        VISIBLE,
        NOT_VISIBLE
    }

    public boolean hidden() {
        return this.visibility == Visibility.NOT_VISIBLE;
    }
    //endregion


    //region > identification in the UI

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    //endregion

    //region > first (action)

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "10")
    public T first() {
        final List<T> list = listAll();
        return list.isEmpty()? null: list.get(0);
    }
    //endregion

    //region > listAll (action)

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "20")
    public List<T> listAll() {
        return container.allInstances(cls);
    }

    //endregion


    //region > injected services

    @javax.inject.Inject
    protected DomainObjectContainer container;

    @javax.inject.Inject
    protected RepositoryService repositoryService;

    @javax.inject.Inject
    protected FactoryService factoryService;

    //endregion

}
