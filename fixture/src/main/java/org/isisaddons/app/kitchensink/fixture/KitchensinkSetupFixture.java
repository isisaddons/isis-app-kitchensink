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

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.isisaddons.app.kitchensink.fixture.blobclob.BlobClobObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.bulk.WorkflowObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.busrules.BusRulesObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.contrib.ContribObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.date.DateObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.dependent.NflPlayersFixture;
import org.isisaddons.app.kitchensink.fixture.dependent.NflTeamsFixture;
import org.isisaddons.app.kitchensink.fixture.enumerated.EnumeratedObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.hierarchy.HierarchyObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.inject.InjectObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.javamath.JavaMathObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.Layout_3_4_5_ObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.Layout_4_0_0_8C_ObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.Layout_4_0_8_ObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.Layout_4_4_4_ObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.Layout_6_0_6_12C_ObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.layout.Layout_6_0_6_ObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.message.MessageObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.misc.MiscObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.mixins.MixinObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.other.OtherBoundedObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.other.OtherObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.primitive.PrimitiveObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.reference.ReferenceObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.semantics.SemanticsObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.spec.SpecObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.text.TextObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.timestampable.TimestampableObjectsFixture;
import org.isisaddons.app.kitchensink.fixture.wrapper.WrapperObjectsFixture;

public class KitchensinkSetupFixture extends FixtureScript {

    public KitchensinkSetupFixture() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(final ExecutionContext executionContext) {

        executionContext.executeChild(this, new KitchensinkTearDownFixture());

        executionContext.executeChild(this, new OtherBoundedObjectsFixture());
        executionContext.executeChild(this, new OtherObjectsFixture());
        executionContext.executeChild(this, new NflTeamsFixture());
        executionContext.executeChild(this, new NflPlayersFixture());

        executionContext.executeChild(this, new PrimitiveObjectsFixture());
        executionContext.executeChild(this, new WrapperObjectsFixture());
        executionContext.executeChild(this, new JavaMathObjectsFixture());

        executionContext.executeChild(this, new TextObjectsFixture());
        executionContext.executeChild(this, new EnumeratedObjectsFixture());
        executionContext.executeChild(this, new ReferenceObjectsFixture());
        executionContext.executeChild(this, new DateObjectsFixture());
        executionContext.executeChild(this, new BlobClobObjectsFixture());
        executionContext.executeChild(this, new MiscObjectsFixture());

        executionContext.executeChild(this, new WorkflowObjectsFixture());

        executionContext.executeChild(this, new Layout_3_4_5_ObjectsFixture());
        executionContext.executeChild(this, new Layout_4_4_4_ObjectsFixture());
        executionContext.executeChild(this, new Layout_4_0_8_ObjectsFixture());
        executionContext.executeChild(this, new Layout_6_0_6_ObjectsFixture());

        executionContext.executeChild(this, new Layout_4_0_0_8C_ObjectsFixture());
        executionContext.executeChild(this, new Layout_6_0_6_12C_ObjectsFixture());

        executionContext.executeChild(this, new HierarchyObjectsFixture());

        executionContext.executeChild(this, new MessageObjectsFixture());

        executionContext.executeChild(this, new BusRulesObjectsFixture());
        executionContext.executeChild(this, new SemanticsObjectsFixture());
        executionContext.executeChild(this, new SpecObjectsFixture());
        executionContext.executeChild(this, new InjectObjectsFixture());
        executionContext.executeChild(this, new TimestampableObjectsFixture());

        executionContext.executeChild(this, new ContribObjectsFixture());
        executionContext.executeChild(this, new MixinObjectsFixture());

    }

}
