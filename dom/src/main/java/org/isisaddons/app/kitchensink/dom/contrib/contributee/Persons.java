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
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

@DomainService(repositoryFor = Person.class)
@DomainServiceLayout(
        named="Contributions",
        menuOrder = "10.1"
)
public class Persons {

    private final Class<Person> cls = Person.class;

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    @MemberOrder(sequence = "30")
    public Person createPerson(
            final @ParameterLayout(named="Name") String name) {
        final Person obj = container.newTransientInstance(Person.class);
        obj.setName(name);

        container.persistIfNotAlready(obj);
        return obj;
    }


    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @Action(semantics=SemanticsOf.SAFE)
    @MemberOrder(sequence = "10")
    public Person firstPerson() {
        final List<Person> list = listAllPersons();
        return list.isEmpty()? null: list.get(0);
    }

    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @Action(semantics= SemanticsOf.SAFE)
    @MemberOrder(sequence = "20")
    public List<Person> listAllPersons() {
        return container.allInstances(cls);
    }

    @javax.inject.Inject
    protected DomainObjectContainer container;

}
