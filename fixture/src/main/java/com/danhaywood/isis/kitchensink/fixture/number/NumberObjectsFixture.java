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

package com.danhaywood.isis.kitchensink.fixture.number;

import com.danhaywood.isis.kitchensink.dom.number.NumberObject;
import com.danhaywood.isis.kitchensink.dom.number.NumberObjects;

import org.apache.isis.applib.fixturescripts.FixtureScript;

public class NumberObjectsFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        long l = 0;
        create("Foo", l++, executionContext);
        create("Bar", l++, executionContext);
        create("Baz", l++, executionContext);
    }

    private NumberObject create(final String name, long l, ExecutionContext executionContext) {
        return executionContext.add(this, numberObjects.create(name, (byte)l, (short)l, (int)l, l, l, l));
    }

    @javax.inject.Inject
    private NumberObjects numberObjects;

}
