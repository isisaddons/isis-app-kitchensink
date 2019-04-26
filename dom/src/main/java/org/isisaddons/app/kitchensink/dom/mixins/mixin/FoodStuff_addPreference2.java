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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.LabelPosition;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.PropertyLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.value.Markup;

import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

import lombok.NoArgsConstructor;

@Mixin(method = "act")
@javax.xml.bind.annotation.XmlRootElement(name = "FoodStuff_addPreference2")
@javax.xml.bind.annotation.XmlType(
        propOrder = {
        }
)
@javax.xml.bind.annotation.XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class FoodStuff_addPreference2 {

    private FoodStuff foodStuff;

    public FoodStuff_addPreference2(final FoodStuff foodStuff) {
        this.foodStuff = foodStuff;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    @ActionLayout(contributed = Contributed.AS_ACTION)
    public Preference act(
            final Person person,
            final Preference.PreferenceType preferenceType) {
        final Preference preference = addPreference(person, preferenceType);
        return preference;
    }

    private Preference addPreference(final Person person, final Preference.PreferenceType preferenceType) {
        if(person == null) {
            return null;
        }
        return preferencesService.addPreference(person, preferenceType, foodStuff);
    }

    @Collection
    public List<Preference> getPreferences() {
        return preferences.listAllPreferences();
    }

    @Property
    @PropertyLayout(labelPosition = LabelPosition.NONE)
    public Markup getHelp() {
        return new Markup("<p>here's how to use this action:<ul><li>enter the <b>person</b></li><li>then enter the <u>preference type</u></li></ul><p>... and hit OK!</p></p>");
    }



    @XmlTransient
    @javax.inject.Inject
    PreferencesService preferencesService;

    @XmlTransient
    @javax.inject.Inject
    Preferences preferences;

}
