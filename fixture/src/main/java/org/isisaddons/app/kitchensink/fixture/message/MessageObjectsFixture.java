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
package org.isisaddons.app.kitchensink.fixture.message;

import org.isisaddons.app.kitchensink.dom.message.MessageObjects;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class MessageObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        int i=0;
        create("Foo", executionContext);
        create("Bar", executionContext);
        create("Baz", executionContext);
    }

    private org.isisaddons.app.kitchensink.dom.message.MessageObject create(final String name, ExecutionContext executionContext) {
        return executionContext.add(this, messageObjects.create(name));
    }

    @javax.inject.Inject
    private MessageObjects messageObjects;

}
