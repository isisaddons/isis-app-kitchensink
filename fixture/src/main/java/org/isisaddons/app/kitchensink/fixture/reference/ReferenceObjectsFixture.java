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
package org.isisaddons.app.kitchensink.fixture.reference;

import java.util.List;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.isisaddons.app.kitchensink.dom.other.*;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceObject;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceObjects;
import org.isisaddons.app.kitchensink.fixture.other.OtherBoundedObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.other.OtherObjectsFixture;

public class ReferenceObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // prereqs
        executionContext.executeChild(this, new OtherObjectsFixture());
        executionContext.executeChild(this, new OtherBoundedObjectsFixture());

        final List<AutoObject> autoObjectList = autoObjects.listAll();
        final List<OtherObject> otherObjectList = otherObjects.listAll();
        final List<OtherBoundedObject> otherBoundedObjectList = otherBoundedObjects.listAll();

        // create
        int i=0;
        final ReferenceObject foo = create("Foo", executionContext, i++, get(autoObjectList, i),
                get(otherObjectList, i), get(otherBoundedObjectList, i));

        foo.addChild("Child 1");
        foo.addChild("Child 2");
        foo.addChild("Child 3");

        foo.addChild2("Child2 A");
        foo.addChild2("Child2 B");
        foo.addChild2("Child2 C");

        final ReferenceObject bar = create("Bar", executionContext, i++, get(autoObjectList, i),
                get(otherObjectList, i), get(otherBoundedObjectList, i));
        bar.addChild("Child 4");
        bar.addChild("Child 5");
        bar.addChild("Child 6");
        bar.addChild("Child 7");

        bar.addChild2("Child2 D");
        bar.addChild2("Child2 E");
        bar.addChild2("Child2 F");
        bar.addChild2("Child2 G");

        create("Baz", executionContext, i++, get(autoObjectList, i), get(otherObjectList, i), get(otherBoundedObjectList, i));
    }

    private static <T> T get(List<T> list, int i) {
        return list.isEmpty() ? null : list.get(i % list.size());
    }

    private ReferenceObject create(final String name, ExecutionContext executionContext, int i, AutoObject autoObject, OtherObject otherObject, OtherBoundedObject otherBoundedObject) {
        return executionContext.addResult(this, referenceObjects.createReferenceObject(name, i, autoObject, otherObject, otherBoundedObject));
    }

    @javax.inject.Inject
    private ReferenceObjects referenceObjects;
    @javax.inject.Inject
    private OtherObjects otherObjects;
    @javax.inject.Inject
    private AutoObjects autoObjects;
    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

}
