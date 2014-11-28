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
package org.isisaddons.app.kitchensink.fixture.contrib;

import org.isisaddons.app.kitchensink.dom.contrib.contributed.Preference;
import org.isisaddons.app.kitchensink.dom.contrib.contributed.Preferences;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.FoodStuff;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.Person;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.Persons;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.FoodStuffs;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class ContribObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        final Person mary = createPerson("Mary", executionContext);
        final Person mungo = createPerson("Mungo", executionContext);
        final Person midge = createPerson("Midge", executionContext);

        final FoodStuff apple = createFood("Apple", executionContext);
        final FoodStuff orange = createFood("Orange", executionContext);
        final FoodStuff banana = createFood("Banana", executionContext);
        final FoodStuff pear = createFood("Pear", executionContext);

        createPreference(mary, Preference.PreferenceType.LOVE, apple, executionContext);
        createPreference(mary, Preference.PreferenceType.LOVE, orange, executionContext);
        createPreference(mary, Preference.PreferenceType.LIKE, pear, executionContext);
        createPreference(mary, Preference.PreferenceType.HATE, banana, executionContext);

        createPreference(mungo, Preference.PreferenceType.LOVE, orange, executionContext);
        createPreference(mungo, Preference.PreferenceType.LOVE, orange, executionContext);

        createPreference(mungo, Preference.PreferenceType.LIKE, apple, executionContext);
        createPreference(mungo, Preference.PreferenceType.LIKE, orange, executionContext);
        createPreference(mungo, Preference.PreferenceType.HATE, banana, executionContext);
    }

    private Person createPerson(
            final String name, ExecutionContext executionContext) {
        return executionContext.add(this, persons.createPerson(name));
    }

    private FoodStuff createFood(
            final String name, ExecutionContext executionContext) {
        return executionContext.add(this, foodStuffs.createFoodStuff(name));
    }

    private Preference createPreference(
            final Person person,
            final Preference.PreferenceType preferenceType,
            final FoodStuff foodStuff,
            final ExecutionContext executionContext) {
        return executionContext.add(this, preferences.createPreference(person, preferenceType, foodStuff));
    }

    @javax.inject.Inject
    private Persons persons;

    @javax.inject.Inject
    private FoodStuffs foodStuffs;

    @javax.inject.Inject
    private Preferences preferences;

}
