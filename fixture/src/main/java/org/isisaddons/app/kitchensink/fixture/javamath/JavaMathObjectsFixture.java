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
package org.isisaddons.app.kitchensink.fixture.javamath;

import org.isisaddons.app.kitchensink.dom.javamath.JavaMathObject;
import org.isisaddons.app.kitchensink.dom.javamath.JavaMathObjects;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class JavaMathObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        long l = 0;
        create("Foo", l++, executionContext);
        create("Bar", l++, executionContext);
        create("Baz", l++, executionContext);
    }

    private JavaMathObject create(final String name, long l, ExecutionContext executionContext) {
        return executionContext.add(this, javaMathObjects.create(name, l, l));
    }

    @javax.inject.Inject
    private JavaMathObjects javaMathObjects;

}
