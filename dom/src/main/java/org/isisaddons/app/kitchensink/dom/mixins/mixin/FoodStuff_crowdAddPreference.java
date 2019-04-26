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

import javax.annotation.Nullable;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

@Mixin(method = "act")
public class FoodStuff_crowdAddPreference {

    private final FoodStuff foodStuff;
    public FoodStuff_crowdAddPreference(final FoodStuff foodStuff) {
        this.foodStuff = foodStuff;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @ActionLayout(contributed = Contributed.AS_ACTION)
    public Preference act(
            final Person person,
            @Nullable final Person person2,
            @Nullable final Person person3,
            @Nullable final Person person4,
            @Nullable final Person person5,
            @Nullable final Person person6,
            @Nullable final Person person7,
            @Nullable final Person person8,
            @Nullable final Person person9,
            @Nullable final Person personA,
            @Nullable final Person personB,
            @Nullable final Person personC,
            @Nullable final Person personD,
            @Nullable final Person personE,
            @Nullable final Person personF,
            @Nullable final Person personG,
            @Nullable final Person personH,
            @Nullable final Person personI,
            @Nullable final Person personJ,
            final Preference.PreferenceType preferenceType) {
        final Preference preference = addPreference(person, preferenceType);
        addPreference(person2, preferenceType);
        addPreference(person3, preferenceType);
        addPreference(person4, preferenceType);
        addPreference(person5, preferenceType);
        addPreference(person6, preferenceType);
        addPreference(person7, preferenceType);
        addPreference(person8, preferenceType);
        addPreference(person9, preferenceType);
        addPreference(personA, preferenceType);
        addPreference(personB, preferenceType);
        addPreference(personC, preferenceType);
        addPreference(personD, preferenceType);
        addPreference(personE, preferenceType);
        addPreference(personE, preferenceType);
        addPreference(personF, preferenceType);
        addPreference(personG, preferenceType);
        addPreference(personH, preferenceType);
        addPreference(personI, preferenceType);
        addPreference(personJ, preferenceType);
        return preference;
    }

    private Preference addPreference(final Person person, final Preference.PreferenceType preferenceType) {
        if(person == null) {
            return null;
        }
        return preferencesService.addPreference(person, preferenceType, foodStuff);
    }


    @javax.inject.Inject
    PreferencesService preferencesService;

}
