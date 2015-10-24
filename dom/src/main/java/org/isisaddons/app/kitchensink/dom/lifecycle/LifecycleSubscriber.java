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
package org.isisaddons.app.kitchensink.dom.lifecycle;

import com.google.common.eventbus.Subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.isis.applib.AbstractSubscriber;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.eventbus.ObjectCreatedEvent;
import org.apache.isis.applib.services.eventbus.ObjectLoadedEvent;
import org.apache.isis.applib.services.eventbus.ObjectPersistedEvent;
import org.apache.isis.applib.services.eventbus.ObjectPersistingEvent;
import org.apache.isis.applib.services.eventbus.ObjectRemovingEvent;
import org.apache.isis.applib.services.eventbus.ObjectUpdatedEvent;
import org.apache.isis.applib.services.eventbus.ObjectUpdatingEvent;

@DomainService()
public class LifecycleSubscriber extends AbstractSubscriber {

    public static final Logger LOG = LoggerFactory.getLogger(LifecycleSubscriber.class);

    @Programmatic
    @Subscribe
    public void on(final ObjectCreatedEvent ev) {
        LOG.info(ev.toString());
    }

    @Programmatic
    @Subscribe
    public void on(final ObjectLoadedEvent ev) {
        LOG.info(ev.toString());
    }

    @Programmatic
    @Subscribe
    public void on(final ObjectPersistingEvent ev) {
        LOG.info(ev.toString());
    }

    @Programmatic
    @Subscribe
    public void on(final ObjectPersistedEvent ev) {
        LOG.info(ev.toString());
    }

    @Programmatic
    @Subscribe
    public void on(final ObjectUpdatingEvent ev) {
        LOG.info(ev.toString());
    }

    @Programmatic
    @Subscribe
    public void on(final ObjectUpdatedEvent ev) {
        LOG.info(ev.toString());
    }

    @Programmatic
    @Subscribe
    public void on(final ObjectRemovingEvent ev) {
        LOG.info(ev.toString());
    }


}
