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
package org.isisaddons.app.kitchensink.dom.mixins.mixin;

import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

@DomainService(
        repositoryFor = Preference.class,
        nature = NatureOfService.VIEW_MENU_ONLY
)
@DomainServiceLayout(
        named="Contributions",
        menuOrder = "10.9"
)
public class Preferences {

    private final Class<Preference> cls = Preference.class;

    public String getId() {
        return "mixins." + getClass().getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    @MemberOrder(sequence = "30")
    public Preference createPreference(
            final Person person,
            final @ParameterLayout(named="Type") Preference.PreferenceType preferenceType,
            final FoodStuff foodStuff) {
        final Preference obj = container.newTransientInstance(Preference.class);
        obj.setPerson(person);
        obj.setType(preferenceType);
        obj.setFoodStuff(foodStuff);

        container.persistIfNotAlready(obj);
        return obj;
    }

    @Programmatic
    public void deletePreference(
            final Preference preference) {

        container.removeIfNotAlready(preference);
    }

    @Action(semantics=SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "10")
    public Preference firstPreference() {
        final List<Preference> list = listAllPreferences();
        return list.isEmpty()? null: list.get(0);
    }

    @Action(semantics= SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "20")
    public List<Preference> listAllPreferences() {
        return container.allInstances(cls);
    }

    @javax.inject.Inject
    protected DomainObjectContainer container;

}
