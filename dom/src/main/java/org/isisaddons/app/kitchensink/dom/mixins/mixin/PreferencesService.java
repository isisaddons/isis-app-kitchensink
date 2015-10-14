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

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

@DomainService(
        nature = NatureOfService.DOMAIN
)
public class PreferencesService {

    Preference addPreference(
            final Person person,
            final Preference.PreferenceType preferenceType,
            final FoodStuff foodStuff) {
        removePreference(person, foodStuff);
        return preferences.createPreference(person, preferenceType, foodStuff);
    }

    Person removePreference(final Person person, final FoodStuff foodStuff) {
        final List<Preference> preferences1 = preferences.listAllPreferences();
        for (final Preference preference : preferences1) {
            if(preference.getPerson() == person && preference.getFoodStuff() == foodStuff) {
                preferences.deletePreference(preference);
            }
        }
        return person;
    }

    List<Preference> preferencesOf(final Person person) {
        return Lists.newArrayList(
                Iterables.filter(
                        preferences.listAllPreferences(),
                        Preference.Predicates.preferenceOf(person))
        );
    }


    @javax.inject.Inject
    protected Preferences preferences;

}
