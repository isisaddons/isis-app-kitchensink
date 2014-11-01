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
package org.isisaddons.app.kitchensink.fixture;

import org.isisaddons.app.kitchensink.fixture.blobclob.BlobClobObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.bulk.WorkflowObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.date.DateObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.dependent.NflPlayersFixture;
import org.isisaddons.app.kitchensink.fixture.enumerated.EnumeratedObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.hierarchy.HierarchyObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.javamath.JavaMathObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.*;
import org.isisaddons.app.kitchensink.fixture.message.MessageObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.misc.MiscObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.other.OtherBoundedObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.other.OtherObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.primitive.PrimitiveObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.reference.ReferenceObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.text.TextObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.wrapper.WrapperObjectsFixture;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class KitchensinkSetupFixture extends FixtureScript {

    public KitchensinkSetupFixture() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(ExecutionContext executionContext) {

        executeChild(new KitchensinkTearDownFixture(), executionContext);

        executeChild(new OtherBoundedObjectsFixture(), executionContext);
        executeChild(new OtherObjectsFixture(), executionContext);
        executeChild(new NflPlayersFixture(), executionContext);

        executeChild(new PrimitiveObjectsFixture(), executionContext);
        executeChild(new WrapperObjectsFixture(), executionContext);
        executeChild(new JavaMathObjectsFixture(), executionContext);

        executeChild(new TextObjectsFixture(), executionContext);
        executeChild(new EnumeratedObjectsFixture(), executionContext);
        executeChild(new ReferenceObjectsFixture(), executionContext);
        executeChild(new DateObjectsFixture(), executionContext);
        executeChild(new BlobClobObjectsFixture(), executionContext);
        executeChild(new MiscObjectsFixture(), executionContext);

        executeChild(new WorkflowObjectsFixture(), executionContext);

        executeChild(new Layout_3_4_5_ObjectsFixture(), executionContext);
        executeChild(new Layout_4_4_4_ObjectsFixture(), executionContext);
        executeChild(new Layout_4_0_8_ObjectsFixture(), executionContext);
        executeChild(new Layout_6_0_6_ObjectsFixture(), executionContext);

        executeChild(new Layout_4_0_0_8C_ObjectsFixture(), executionContext);
        executeChild(new Layout_6_0_6_12C_ObjectsFixture(), executionContext);

        executeChild(new HierarchyObjectsFixture(), executionContext);

        executeChild(new MessageObjectsFixture(), executionContext);

    }

}
