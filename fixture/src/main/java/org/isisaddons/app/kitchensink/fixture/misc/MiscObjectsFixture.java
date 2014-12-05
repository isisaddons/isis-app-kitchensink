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
package org.isisaddons.app.kitchensink.fixture.misc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import org.isisaddons.app.kitchensink.dom.misc.MiscObject;
import org.isisaddons.app.kitchensink.dom.misc.MiscObjects;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.value.Money;

public class MiscObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        try {
            create("Foo", new URL("http://isis.apache.org"), UUID.randomUUID(), new Money(10, "GBP"), executionContext);
            create("Bar", new URL("http://www.apache.org"), UUID.randomUUID(), new Money(10, "GBP"), executionContext);
            create("Baz", new URL("http://issues.apache.org"), UUID.randomUUID(), new Money(10, "GBP"), executionContext);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private MiscObject create(final String name, final URL url, final UUID uuid, final Money money, final ExecutionContext executionContext) {
        return executionContext.add(this, miscObjects.createMiscObject(name, url, uuid, money));
    }

    @javax.inject.Inject
    private MiscObjects miscObjects;

}
