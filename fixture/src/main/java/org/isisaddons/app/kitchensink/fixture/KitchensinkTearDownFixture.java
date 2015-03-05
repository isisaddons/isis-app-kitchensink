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
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;

public class KitchensinkTearDownFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {

        isisJdoSupport.executeUpdate("delete from \"PrimitiveObject\"");
        isisJdoSupport.executeUpdate("delete from \"NflPlayer\"");
        isisJdoSupport.executeUpdate("delete from \"WrapperObject\"");
        isisJdoSupport.executeUpdate("delete from \"JavaMathObject\"");
        isisJdoSupport.executeUpdate("delete from \"TextObject\"");
        isisJdoSupport.executeUpdate("delete from \"DateObject\"");
        isisJdoSupport.executeUpdate("delete from \"ReferenceObject\"");
        isisJdoSupport.executeUpdate("delete from \"BlobClobObject\"");
        isisJdoSupport.executeUpdate("delete from \"EnumeratedObject\"");
        isisJdoSupport.executeUpdate("delete from \"MiscObject\"");

        isisJdoSupport.executeUpdate("delete from \"OtherObject\"");
        isisJdoSupport.executeUpdate("delete from \"OtherBoundedObject\"");

        isisJdoSupport.executeUpdate("delete from \"Layout_3_4_5_Object\"");
        isisJdoSupport.executeUpdate("delete from \"Layout_4_0_8_Object\"");
        isisJdoSupport.executeUpdate("delete from \"Layout_4_4_4_Object\"");
        isisJdoSupport.executeUpdate("delete from \"Layout_6_0_6_Object\"");

        isisJdoSupport.executeUpdate("delete from \"Layout_4_0_0_8C_Object\"");
        isisJdoSupport.executeUpdate("delete from \"Layout_6_0_6_12C_Object\"");

        isisJdoSupport.executeUpdate("delete from \"GrandchildObject\"");
        isisJdoSupport.executeUpdate("delete from \"ChildObject\"");
        isisJdoSupport.executeUpdate("delete from \"ParentObject\"");

        isisJdoSupport.executeUpdate("delete from \"MessageObject\"");

        isisJdoSupport.executeUpdate("delete from \"BusRulesObject\"");

        isisJdoSupport.executeUpdate("delete from \"Preference\"");
        isisJdoSupport.executeUpdate("delete from \"Person\"");
        isisJdoSupport.executeUpdate("delete from \"FoodStuff\"");
    }


    @javax.inject.Inject
    private IsisJdoSupport isisJdoSupport;

}
