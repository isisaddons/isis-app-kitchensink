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
package org.isisaddons.app.kitchensink.dom.layout;

import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.layout.layout_3_4_5.Layout_3_4_5_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_3_4_5.Layout_3_4_5_Objects;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_0_0_8C.Layout_4_0_0_8C_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_0_0_8C.Layout_4_0_0_8C_Objects;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_0_8.Layout_4_0_8_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_0_8.Layout_4_0_8_Objects;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_4_4.Layout_4_4_4_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_4_4_4.Layout_4_4_4_Objects;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6.Layout_6_0_6_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6.Layout_6_0_6_Objects;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6_12C.Layout_6_0_6_12C_Object;
import org.isisaddons.app.kitchensink.dom.layout.layout_6_0_6_12C.Layout_6_0_6_12C_Objects;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;

@DomainService(menuOrder = "10.11")
public class LayoutObjects  {


    @MemberOrder(sequence = "10")
    public Layout_4_4_4_Object first_4_4_4() {
        return layout_4_4_4_objects.first();
    }

    @MemberOrder(sequence = "20")
    public Layout_3_4_5_Object first_3_4_5() {
        return layout_3_4_5_objects.first();
    }

    @MemberOrder(sequence = "30")
    public Layout_4_0_8_Object first_4_0_8() {
        return layout_4_0_8_objects.first();
    }

    @MemberOrder(sequence = "40")
    public Layout_6_0_6_Object first_6_0_6() {
        return layout_6_0_6_objects.first();
    }

    @MemberOrder(sequence = "50")
    public Layout_4_0_0_8C_Object first_4_0_0_8C() {
        return layout_4_0_0_8C_objects.first();
    }

    @MemberOrder(sequence = "60")
    public Layout_6_0_6_12C_Object first_6_0_6_12C() {
        return layout_6_0_6_12C_objects.first();
    }



    @Inject
    private Layout_4_4_4_Objects layout_4_4_4_objects;

    @Inject
    private Layout_4_0_8_Objects layout_4_0_8_objects;

    @Inject
    private Layout_6_0_6_Objects layout_6_0_6_objects;

    @Inject
    private Layout_3_4_5_Objects layout_3_4_5_objects;

    @Inject
    private Layout_4_0_0_8C_Objects layout_4_0_0_8C_objects;

    @Inject
    private Layout_6_0_6_12C_Objects layout_6_0_6_12C_objects;
}
