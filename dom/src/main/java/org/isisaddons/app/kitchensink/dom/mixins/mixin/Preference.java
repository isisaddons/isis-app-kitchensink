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

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Where;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff;
import org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person;

@javax.jdo.annotations.PersistenceCapable(
        identityType=IdentityType.DATASTORE,
        schema = "mixins"
)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "mixins.PREFERENCE"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class Preference implements Entity<Preference> {

    public String title() {
        return container.titleOf(getPerson()) + " " + getType().toString().toLowerCase() + " " + container.titleOf(getFoodStuff());
    }

    public enum PreferenceType {
        LOVE,
        LIKE,
        DISLIKE,
        HATE
    }

    //region > description (property)

    private PreferenceType type;

    @Column(allowsNull="false")
    public PreferenceType getType() {
        return type;
    }

    public void setType(final PreferenceType type) {
        this.type = type;
    }

    //endregion

    //region > person (property)
    private Person person;

    @Column(name = "personId", allowsNull = "false")
    @Property(hidden = Where.REFERENCES_PARENT)
    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }
    //endregion

    //region > food (property)
    private FoodStuff foodStuff;

    @Column(name = "foodId", allowsNull = "false")
    @Property(hidden = Where.REFERENCES_PARENT)
    public FoodStuff getFoodStuff() {
        return foodStuff;
    }

    public void setFoodStuff(final FoodStuff foodStuff) {
        this.foodStuff = foodStuff;
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(final Preference other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    static class Predicates {
        static Predicate<Preference> preferenceOf(final Person person) {
            return input -> input.getPerson() == person;
        }
        static Predicate<Preference> preferenceOf(final Person person, final PreferenceType preferenceType) {
            return input -> input.getPerson() == person && input.getType() == preferenceType;
        }
    }

    static class Functions {
        static Function<Preference, FoodStuff> food() {
            return input -> input.getFoodStuff();
        }
    }

    @Inject
    DomainObjectContainer container;


}
