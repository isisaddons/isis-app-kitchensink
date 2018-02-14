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
package org.isisaddons.app.kitchensink.dom.busrules;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Lists;
import com.google.common.eventbus.Subscribe;

import org.jetbrains.annotations.Nullable;

import org.apache.isis.applib.AbstractSubscriber;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Auditing;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.Collection;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MementoSerialization;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.queryresultscache.QueryResultsCache;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;

import lombok.Getter;
import lombok.Setter;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "busrules.BusRulesObject",
        auditing = Auditing.ENABLED,
        publishing = Publishing.ENABLED
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT,
        titleUiEvent = BusRulesObject.TitleUiEvent.class,
        iconUiEvent = BusRulesObject.IconUiEvent.class,
        cssClassUiEvent = BusRulesObject.CssClassUiEvent.class
)
public class BusRulesObject implements Entity<BusRulesObject> {


    @DomainService(nature = NatureOfService.DOMAIN)
    public static class TitleSubscriber extends AbstractSubscriber {


        @Subscribe
        @org.axonframework.eventhandling.annotation.EventHandler
        public void on(TitleUiEvent ev) {
            ev.setTitle(ev.getSource().getName() + " (from subscriber)");
        }

        @Subscribe
        @org.axonframework.eventhandling.annotation.EventHandler
        public void on(IconUiEvent ev) {
            ev.setIconName("BusRulesObjectFromSubscriber");
        }

        @Subscribe
        @org.axonframework.eventhandling.annotation.EventHandler
        public void on(CssClassUiEvent ev) {
            ev.setCssClass("BusRulesObjectFromSubscriber");
        }

    }

    public static class TitleUiEvent extends org.apache.isis.applib.services.eventbus.TitleUiEvent<BusRulesObject> {}
    public static class IconUiEvent extends org.apache.isis.applib.services.eventbus.IconUiEvent<BusRulesObject> {}
    public static class CssClassUiEvent extends org.apache.isis.applib.services.eventbus.CssClassUiEvent<BusRulesObject> {}


    public String title() {return getName() + " (from title method)";}
    public String iconName() {return "BusRulesObjectFromIconNameMethod";}
    public String cssClass() {return "BusRulesObjectFromCssClassMethod";}


    @Column(allowsNull="false")
    @Title(sequence="1")
    @Getter @Setter
    private String name;

    @Getter @Setter
    private boolean enableActions;


    //region > configureActions

    public BusRulesObject configureActions(@ParameterLayout(named = "Enable?") boolean v) {

        // to break things, we're priming the cache with an current value (about to be invalidated)
        // this stale value will be read in the disable, causing actions' enablement to not be updated correctly
        final boolean enabledUNUSED = reasonDisabledIfAnyCached() == null;

        setEnableActions(v);
        final boolean enabledUNUSED2 = reasonDisabledIfAnyCached() == null;
        final boolean enabledUNUSED3 = doReasonDisabledIfAny(this) == null;

        return this;
    }

    public boolean default0ConfigureActions() {
        // this to force a cache invalidation issue.
        final boolean enabled = reasonDisabledIfAnyCached() == null;
        return !enabled;
    }

    //endregion


    //region > actionAssociatedWithProperty

    public BusRulesObject actionAssociatedWithProperty() {
        return this;
    }

    public String disableActionAssociatedWithProperty() {
        return doReasonDisabledIfAny(this);
    }

    //endregion

    //region > action2AssociatedWithProperty

    public BusRulesObject action2AssociatedWithProperty() {
        return this;
    }


    //endregion


    //region > other (derived collection)

    @Collection(
            mementoSerialization = MementoSerialization.EXCLUDED
    )
    public List<BusRulesObject> getOther() {
        final List<BusRulesObject> other = Lists.newArrayList();
        other.addAll(busRulesObjectMenu.listAllBusRulesObject());
        other.remove(this);
        return other;
    }

    //endregion

    //region > actionAssociatedWithCollection

    public BusRulesObject actionAssociatedWithCollection() {
        return this;
    }

    public String disableActionAssociatedWithCollection() {
        return reasonDisabledIfAnyCached();
    }

    //endregion

    //region > action3AssociatedWithCollection

    public BusRulesObject action3AssociatedWithCollection() {
        return this;
    }

    public boolean hideAction3AssociatedWithCollection() {
        return reasonDisabledIfAnyCached() != null;
    }

    public String disableAction3AssociatedWithCollection() {
        // this should not be called if hidden.
        return "Always disabled";
    }

    //endregion

    //region > action2AssociatedWithCollection

    public BusRulesObject action2AssociatedWithCollection() {
        return this;
    }
    //endregion


    //region > topLevelAction (action)
    public BusRulesObject topLevelAction() {
        return this;
    }

    public String disableTopLevelAction() {
        return doReasonDisabledIfAny(this);
    }
    //endregion

    //region > topLevelAction2 (action)
    public BusRulesObject topLevelAction2() {
        return this;
    }
    //endregion



    //region > compareTo

    @Override
    public int compareTo(final BusRulesObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion


    String reasonDisabledIfAnyCached() {
        final String reasonDisabledIfAnyCached = queryResultsCache.execute(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doReasonDisabledIfAny(BusRulesObject.this);
            }
        }, getClass(), "reasonDisabledIfAnyCached", this);
        boolean enabled = reasonDisabledIfAnyCached == null;
        return reasonDisabledIfAnyCached;
    }

    @Nullable
    private String doReasonDisabledIfAny(final BusRulesObject busRulesObject) {
        return busRulesObject.isEnableActions() ? null : "Disabled";
    }

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @Inject
    BusRulesObjectMenu busRulesObjectMenu;

    @Inject
    QueryResultsCache queryResultsCache;
    //endregion

}
