/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
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

package com.danhaywood.isis.kitchensink.fixture.choice;

import java.util.List;
import com.danhaywood.isis.kitchensink.dom.choice.ChoiceObject;
import com.danhaywood.isis.kitchensink.dom.choice.ChoiceObjects;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherBoundedObjects;
import com.danhaywood.isis.kitchensink.dom.other.OtherObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherObjects;
import com.danhaywood.isis.kitchensink.fixture.other.OtherBoundedObjectsFixture;
import com.danhaywood.isis.kitchensink.fixture.other.OtherObjectsFixture;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class ChoiceObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // prereqs
        execute(new OtherObjectsFixture(), executionContext);
        execute(new OtherBoundedObjectsFixture(), executionContext);

        final List<OtherObject> otherObjectList = otherObjects.listAll();
        final List<OtherBoundedObject> otherBoundedObjectList = otherBoundedObjects.listAll();

        // create
        int i=0;
        create("Foo", executionContext, i++, get(otherObjectList, i), get(otherBoundedObjectList, i));
        create("Bar", executionContext, i++, get(otherObjectList, i), get(otherBoundedObjectList, i));
        create("Baz", executionContext, i++, get(otherObjectList, i), get(otherBoundedObjectList, i));
    }

    private static <T> T get(List<T> list, int i) {
        return list.get(i % list.size());
    }

    private ChoiceObject create(final String name, ExecutionContext executionContext, int i, OtherObject otherObject, OtherBoundedObject otherBoundedObject) {
        return executionContext.add(this, choiceObjects.create(name, i, otherObject, otherBoundedObject));
    }

    @javax.inject.Inject
    private ChoiceObjects choiceObjects;
    @javax.inject.Inject
    private OtherObjects otherObjects;
    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

}
