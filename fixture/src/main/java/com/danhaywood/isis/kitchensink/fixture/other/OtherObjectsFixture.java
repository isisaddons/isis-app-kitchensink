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

package com.danhaywood.isis.kitchensink.fixture.other;

import com.danhaywood.isis.kitchensink.dom.other.OtherObject;
import com.danhaywood.isis.kitchensink.dom.other.OtherObjects;

import org.apache.isis.applib.fixturescripts.FixtureScript;

public class OtherObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        // create
        create("Foo", executionContext, null);
        create("Bar", executionContext, null);
        create("Baz", executionContext, null);
    }

    private OtherObject create(final String name, ExecutionContext executionContext, String description) {
        return executionContext.add(this, otherObjects.create(name, description));
    }

    @javax.inject.Inject
    private OtherObjects otherObjects;

}
