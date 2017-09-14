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
package org.isisaddons.app.kitchensink.dom.mixins.mixedIn;

import java.util.Objects;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Ordering;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;

import org.isisaddons.app.kitchensink.dom.Entity;

import lombok.Getter;
import lombok.Setter;

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
        objectType = "mixins.PERSON",
        bounded = true
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class Person implements Entity<Person> {

    @Column(allowsNull="false")
    @Title
    @Getter @Setter
    private String name;

    public enum ConfigureType {
        REGULAR,
        /**
         * For testing dynamic visibility of mixin actions.
         */
        SUPPRESS,
        /**
         * For testing dynamic disablement of mixin actions.
         */
        LOCKDOWN
    }

    @Column(allowsNull = "true")
    @MemberOrder(sequence = "1")
    @Getter @Setter
    private ConfigureType configure;


    public boolean isSecure() {
        return Objects.equals(getConfigure(), ConfigureType.SUPPRESS);
    }

    public boolean isLockDown() {
        return Objects.equals(getConfigure(), ConfigureType.LOCKDOWN);
    }


    @Override
    public int compareTo(final Person other) {
        return Ordering.natural().onResultOf(Person::getName).compare(this, other);
    }

}
