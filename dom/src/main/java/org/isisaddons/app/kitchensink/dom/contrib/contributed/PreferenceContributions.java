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
package org.isisaddons.app.kitchensink.dom.contrib.contributed;

import java.util.List;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.FoodStuff;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.Person;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

@DomainService(
        nature = NatureOfService.VIEW_CONTRIBUTIONS_ONLY
)
@DomainServiceLayout(
        menuOrder = "10.1"
)
public class PreferenceContributions {

    //region > likes (contributed collection to Person)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            contributed = Contributed.AS_ASSOCIATION
    )
    public List<FoodStuff> likes(final Person person) {
        return Lists.newArrayList(
                Iterables.transform(
                        Iterables.filter(
                                preferences.listAllPreferences(),
                                Preference.Predicates.preferenceOf(person)),
                        Preference.Functions.food()
                    ));
    }
    //endregion

    //region > firstLove (contributed property to Person)
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(
            contributed = Contributed.AS_ASSOCIATION
    )
    public FoodStuff firstLove(final Person person) {
        final List<FoodStuff> loves = Lists.newArrayList(
                Iterables.transform(
                        Iterables.filter(
                                preferences.listAllPreferences(),
                                Preference.Predicates.preferenceOf(person, Preference.PreferenceType.LIKE)),
                        Preference.Functions.food()
                ));
        return loves.isEmpty()? null: loves.get(0);
    }
    //endregion

    //region > addPreference (contributed action to Person and FoodStuff) 
    public Preference addPreference(
            final Person person,
            final @ParameterLayout(named="Type") Preference.PreferenceType preferenceType,
            final FoodStuff foodStuff) {
        removePreference(person, foodStuff);
        return preferences.createPreference(person, preferenceType, foodStuff);
    }
    //endregion

    //region > removePreference (contributed action to Person and FoodStuff)
    /**
     * Will be contributed as an action to both parameters.  However, the FoodStuff.layout.json hides the action so it
     * in the UI it appears to be only contributed to the Person entity.
     */
    public Person removePreference(final Person person, final FoodStuff foodStuff) {
        final List<Preference> preferences1 = preferences.listAllPreferences();
        for (final Preference preference : preferences1) {
            if(preference.getPerson() == person && preference.getFoodStuff() == foodStuff) {
                preferences.deletePreference(preference);
            }
        }
        return person;
    }
    //endregion

    //region > injected services
    @javax.inject.Inject
    protected Preferences preferences;
    //endregion

}
