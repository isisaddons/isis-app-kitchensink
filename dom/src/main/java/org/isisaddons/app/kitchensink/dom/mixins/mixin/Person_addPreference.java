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
import java.util.Objects;

import com.google.common.collect.Lists;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Nature;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuffs;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

@DomainObject(nature = Nature.MIXIN )
public class Person_addPreference {

    private final Person person;
    public Person_addPreference(final Person person) {
        this.person = person;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @ActionLayout(contributed = Contributed.AS_ACTION)
    public Preference __(
            final @ParameterLayout(named = "Type") Preference.PreferenceType preferenceType,
            final FoodStuff foodStuff) {
        return preferencesService.addPreference(this.person, preferenceType, foodStuff);
    }

    public boolean hide__() {
        return person.isSecure();
    }
    public String disable__() {
        return person.isLockDown()? "Person has been locked down": null;
    }

    public List<FoodStuff> choices1__() {
        final List<FoodStuff> allFoodstuffs = Lists.newArrayList(this.foodStuffs.listAllFoodStuffs());
        final List<FoodStuff> currentFoodStuffs = Lists
                .transform(preferencesService.preferencesOf(person), Preference.Functions.food());
        allFoodstuffs.removeAll(currentFoodStuffs);
        return allFoodstuffs;
    }

    public FoodStuff default1__() {
        final List<FoodStuff> foodStuffs = choices1__();
        return foodStuffs.isEmpty()? null: foodStuffs.get(0);
    }

    public String validate__(Preference.PreferenceType preferenceType, FoodStuff foodStuff) {
        if (Objects.equals(foodStuff.getName(), "Banana") && preferenceType == Preference.PreferenceType.LOVE){
            return "No-one really loves bananas!";
        }
        return null;
    }

    @javax.inject.Inject
    PreferencesService preferencesService;

    @javax.inject.Inject
    FoodStuffs foodStuffs;

}
