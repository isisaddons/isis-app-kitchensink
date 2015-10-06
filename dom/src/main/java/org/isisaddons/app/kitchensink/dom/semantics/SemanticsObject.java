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
package org.isisaddons.app.kitchensink.dom.semantics;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.wrapper.WrapperFactory;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "SEMANTICS"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class SemanticsObject implements Entity<SemanticsObject> {

    //region > name (property)

    private String name;

    @Column(allowsNull="false")
    @Title(sequence="1")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //endregion

    //region > counter (property)
    private int counter;

    @Column(allowsNull="false")
    public int getCounter() {
        return counter;
    }

    public void setCounter(final int counter) {
        this.counter = counter;
    }
    //endregion

    //region > resetCounter (action)
    @Action(
            semantics = SemanticsOf.IDEMPOTENT
    )
    public SemanticsObject resetCounter() {
        setCounter(0);
        return this;
    }
    //endregion

    //region > resetCounterAreYouSure (action)
    @Action(
            semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE
    )
    public SemanticsObject resetCounterAreYouSure() {
        setCounter(0);
        return this;
    }
    //endregion

    //region > resetCounterAreYouSureTakingArgument (action)
    @Action(
            semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE
    )
    public SemanticsObject resetCounterAreYouSureTakingArgument(@ParameterLayout(named="Dummy") String dummy) {
        setCounter(0);
        return this;
    }
    //endregion

    //region > incrementCounter (action)
    @Action(
            semantics = SemanticsOf.NON_IDEMPOTENT
    )
    public SemanticsObject incrementCounter() {
        setCounter(getCounter()+1);
        return this;
    }
    //endregion

    //region > incrementCounterAreYouSure (action)
    @Action(
            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE
    )
    public SemanticsObject incrementCounterAreYouSure() {
        setCounter(getCounter()+1);
        return this;
    }
    //endregion

    //region > incrementCounterAreYouSureTakingArgument (action)
    @Action(
            semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE
    )
    public SemanticsObject incrementCounterAreYouSureTakingArgument(@ParameterLayout(named="Dummy") String dummy) {
    setCounter(0);
        return this;
    }
    //endregion

    //region > safeAction
    @Action(
        semantics = SemanticsOf.SAFE
    )
    public SemanticsObject safeAction() {
        setCounter(getCounter() + 1);
        return this;
    }
    //endregion

    //region > safeAndRequestCacheableAction
    @Action(
        semantics = SemanticsOf.SAFE_AND_REQUEST_CACHEABLE
    )
    public SemanticsObject safeAndRequestCacheableAction() {
        setCounter(getCounter() + 1);
        return this;
    }
    //endregion

    //region > invoke

    public enum Which {
        SAFE {
            @Override
            public void invoke(final SemanticsObject semanticsObject) {
                semanticsObject.safeAction();
            }
        },
        SAFE_AND_REQUEST_CACHEABLE {
            @Override
            public void invoke(final SemanticsObject semanticsObject) {

                final WrapperFactory wrapperFactory = semanticsObject.wrapperFactory;

                wrapperFactory.wrapSkipRules(semanticsObject).safeAndRequestCacheableAction();
            }
        };

        public abstract void invoke(final SemanticsObject semanticsObject);
    }

    public SemanticsObject invoke(
            @ParameterLayout(named = "Count")
            final Integer count,
            @ParameterLayout(named = "Which to invoke")
            final Which which) {
        resetCounter();
        for (int i = 0; i < count; i++) {
            which.invoke(this);
        }
        return this;
    }
    public Integer default0Invoke() {
        return 5;
    }
    //endregion


    //region > compareTo

    @Override
    public int compareTo(final SemanticsObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @Inject
    SemanticsObjects semanticsObjects;

    @Inject
    WrapperFactory wrapperFactory;
    //endregion

}
