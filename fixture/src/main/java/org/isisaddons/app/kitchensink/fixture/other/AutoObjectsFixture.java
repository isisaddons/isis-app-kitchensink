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

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.isisaddons.app.kitchensink.dom.other.AutoObject;
import org.isisaddons.app.kitchensink.dom.other.AutoObjects;

public class AutoObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        create("John", executionContext);
        create("Joe", executionContext);
        create("Jack", executionContext);
        create("Jim", executionContext);
        create("Bill", executionContext);
        create("Bert", executionContext);
        create("Bobby", executionContext);
        create("Brian", executionContext);
        create("Mary", executionContext);
        create("Marianne", executionContext);
        create("Margaret", executionContext);
        create("Maude", executionContext);
        create("Pippa", executionContext);
        create("Penelope", executionContext);
        create("Pamela", executionContext);
        create("Prudence", executionContext);
    }

    private AutoObject create(final String name, ExecutionContext executionContext) {
        return executionContext.addResult(this, autoObjects.create(name));
    }

    @javax.inject.Inject
    private AutoObjects autoObjects;

}
