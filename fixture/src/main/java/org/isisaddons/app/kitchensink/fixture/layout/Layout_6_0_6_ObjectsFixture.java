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
package org.isisaddons.app.kitchensink.fixture.layout;

import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6.Layout_6_0_6_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6.Layout_6_0_6_Objects;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class Layout_6_0_6_ObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        create("Foo", executionContext);
        create("Bar", executionContext);
        create("Baz", executionContext);
    }

    private Layout_6_0_6_Object create(final String name, ExecutionContext executionContext) {
        return executionContext.addResult(this, layout_6_0_6_objects.create(name));
    }

    @javax.inject.Inject
    private Layout_6_0_6_Objects layout_6_0_6_objects;

}
