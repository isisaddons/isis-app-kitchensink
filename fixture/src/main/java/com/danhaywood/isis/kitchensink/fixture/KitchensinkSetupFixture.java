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

package com.danhaywood.isis.kitchensink.fixture;

import com.danhaywood.isis.kitchensink.fixture.choice.ChoiceObjectsFixture;
import com.danhaywood.isis.kitchensink.fixture.enumerated.EnumeratedObjectsFixture;
import com.danhaywood.isis.kitchensink.fixture.number.NumberObjectsFixture;
import com.danhaywood.isis.kitchensink.fixture.other.OtherBoundedObjectsFixture;
import com.danhaywood.isis.kitchensink.fixture.other.OtherObjectsFixture;
import com.danhaywood.isis.kitchensink.fixture.text.TextObjectsFixture;

import org.apache.isis.applib.fixturescripts.FixtureScript;

public class KitchensinkSetupFixture extends FixtureScript {

    public KitchensinkSetupFixture() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(ExecutionContext executionContext) {

        // prereqs
        execute(new KitchensinkTearDownFixture(), executionContext);

        // create
        execute(new NumberObjectsFixture(), executionContext);
        execute(new TextObjectsFixture(), executionContext);
        execute(new EnumeratedObjectsFixture(), executionContext);
        execute(new OtherBoundedObjectsFixture(), executionContext);
        execute(new OtherObjectsFixture(), executionContext);
        execute(new ChoiceObjectsFixture(), executionContext);
    }

}
