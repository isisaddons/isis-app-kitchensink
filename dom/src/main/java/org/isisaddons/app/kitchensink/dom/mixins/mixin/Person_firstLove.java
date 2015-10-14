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

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;
import org.isisaddons.app.kitchensink.dom.mixins.mixin.Preference.Predicates;

@DomainObject(nature = Nature.MIXIN )
public class Person_firstLove {

    private final Person person;
    public Person_firstLove(final Person person) {
        this.person = person;
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    public FoodStuff _() {
        final List<FoodStuff> loves = Lists.newArrayList(
                Iterables.transform(
                        Iterables.filter(
                                preferences.listAllPreferences(),
                                Predicates.preferenceOf(person, Preference.PreferenceType.LOVE)),
                        Preference.Functions.food()
                ));
        return loves.isEmpty()? null: loves.get(0);
    }

    public boolean hide_() {
        return person.isSecure();
    }
    public String disable_() {
        return person.isLockDown()? "Person has been locked down": null;
    }


    @javax.inject.Inject
    Preferences preferences;

}
