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
package org.isisaddons.app.kitchensink.fixture.other;

import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObjects;

import org.apache.isis.applib.fixturescripts.FixtureScript;

public class OtherBoundedObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        create("Foo", executionContext, null);
        create("Bar", executionContext, null);
        create("Baz", executionContext, null);
    }

    private org.isisaddons.app.kitchensink.dom.other.OtherBoundedObject create(final String name, ExecutionContext executionContext, String description) {
        return executionContext.addResult(this, otherBoundedObjects.create(name, description));
    }

    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

}
