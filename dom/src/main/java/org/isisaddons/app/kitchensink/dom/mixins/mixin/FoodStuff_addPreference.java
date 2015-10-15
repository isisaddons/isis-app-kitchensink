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

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

@DomainObject(nature = Nature.MIXIN )
public class FoodStuff_addPreference {

    private final FoodStuff foodStuff;
    public FoodStuff_addPreference(final FoodStuff foodStuff) {
        this.foodStuff = foodStuff;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @ActionLayout(contributed = Contributed.AS_ACTION)
    public Preference __(
            final Person person,
            final Preference.PreferenceType preferenceType) {
        return preferencesService.addPreference(person, preferenceType, foodStuff);
    }

    @javax.inject.Inject
    PreferencesService preferencesService;

}
