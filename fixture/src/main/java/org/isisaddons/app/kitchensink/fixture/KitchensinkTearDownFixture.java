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
import org.apache.isis.applib.fixturescripts.teardown.TeardownFixtureAbstract2;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObject;
import org.isisaddons.app.kitchensink.dom.busrules.BusRulesObject;
import org.isisaddons.app.kitchensink.dom.contrib.contributed.Preference;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.FoodStuff;
import org.isisaddons.app.kitchensink.dom.contrib.contributee.Person;
import org.isisaddons.app.kitchensink.dom.date.DateObject;
import org.isisaddons.app.kitchensink.dom.dependent.NflPlayer;
import org.isisaddons.app.kitchensink.dom.enumerated.EnumeratedObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.child.ChildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.grandchild.GrandchildObject;
import org.isisaddons.app.kitchensink.dom.hierarchy.parent.ParentObject;
import org.isisaddons.app.kitchensink.dom.inject.InjectObject;
import org.isisaddons.app.kitchensink.dom.javamath.JavaMathObject;
import org.isisaddons.app.kitchensink.dom.layout.layout_3_4_5.Layout_3_4_5_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_0_0_8C.Layout_4_0_0_8C_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_0_8.Layout_4_0_8_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_4_4.Layout_4_4_4_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6.Layout_6_0_6_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6_12C.Layout_6_0_6_12C_Object;
import org.isisaddons.app.kitchensink.dom.message.MessageObject;
import org.isisaddons.app.kitchensink.dom.misc.MiscObject;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObject;
import org.isisaddons.app.kitchensink.dom.other.OtherObject;
import org.isisaddons.app.kitchensink.dom.primitive.PrimitiveObject;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceObject;
import org.isisaddons.app.kitchensink.dom.reference.child.ReferenceChildObject;
import org.isisaddons.app.kitchensink.dom.reference.child2.ReferenceChild2Object;
import org.isisaddons.app.kitchensink.dom.semantics.SemanticsObject;
import org.isisaddons.app.kitchensink.dom.spec.SpecObject;
import org.isisaddons.app.kitchensink.dom.text.TextObject;
import org.isisaddons.app.kitchensink.dom.timestampable.inject.TimestampableObject;
import org.isisaddons.app.kitchensink.dom.wrapper.WrapperObject;

public class KitchensinkTearDownFixture extends TeardownFixtureAbstract2 {

    public KitchensinkTearDownFixture() {
        withDiscoverability(Discoverability.DISCOVERABLE);
    }

    @Override
    protected void execute(FixtureScript.ExecutionContext executionContext) {

        deleteFrom(PrimitiveObject.class);
        deleteFrom(NflPlayer.class);
        deleteFrom(WrapperObject.class);
        deleteFrom(JavaMathObject.class);
        deleteFrom(TextObject.class);
        deleteFrom(DateObject.class);
        deleteFrom(BlobClobObject.class);
        deleteFrom(EnumeratedObject.class);
        deleteFrom(MiscObject.class);

        deleteFrom(ReferenceChild2Object.class);
        deleteFrom(ReferenceChildObject.class);
        deleteFrom(ReferenceObject.class);

        deleteFrom(OtherObject.class);
        deleteFrom(OtherBoundedObject.class);

        deleteFrom(Layout_3_4_5_Object.class);
        deleteFrom(Layout_4_0_8_Object.class);
        deleteFrom(Layout_4_4_4_Object.class);
        deleteFrom(Layout_6_0_6_Object.class);

        deleteFrom(Layout_4_0_0_8C_Object.class);
        deleteFrom(Layout_6_0_6_12C_Object.class);

        deleteFrom(GrandchildObject.class);
        deleteFrom(ChildObject.class);
        deleteFrom(ParentObject.class);

        deleteFrom(MessageObject.class);

        deleteFrom(BusRulesObject.class);
        deleteFrom(SemanticsObject.class);
        deleteFrom(SpecObject.class);

        deleteFrom(Preference.class);
        deleteFrom(Person.class);
        deleteFrom(FoodStuff.class);

        deleteFrom(org.isisaddons.app.kitchensink.dom.mixins.mixin.Preference.class);
        deleteFrom(org.isisaddons.app.kitchensink.dom.mixins.mixedIn.Person .class);
        deleteFrom(org.isisaddons.app.kitchensink.dom.mixins.mixedIn.FoodStuff .class);

        deleteFrom(InjectObject.class);
        deleteFrom(TimestampableObject.class);
    }


    @javax.inject.Inject
    private IsisJdoSupport isisJdoSupport;

}
