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

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.objectstore.jdo.applib.service.support.IsisJdoSupport;

public class KitchensinkTearDownFixture extends FixtureScript {

    @Override
    protected void execute(ExecutionContext executionContext) {
        isisJdoSupport.executeUpdate("delete from \"PrimitiveObject\"");
        isisJdoSupport.executeUpdate("delete from \"WrapperObject\"");
        isisJdoSupport.executeUpdate("delete from \"JavaMathObject\"");
        isisJdoSupport.executeUpdate("delete from \"TextObject\"");
        isisJdoSupport.executeUpdate("delete from \"DateObject\"");
        isisJdoSupport.executeUpdate("delete from \"ReferenceObject\"");
        isisJdoSupport.executeUpdate("delete from \"BlobClobObject\"");
        isisJdoSupport.executeUpdate("delete from \"EnumeratedObject\"");

        isisJdoSupport.executeUpdate("delete from \"OtherObject\"");
        isisJdoSupport.executeUpdate("delete from \"OtherBoundedObject\"");
    }


    @javax.inject.Inject
    private IsisJdoSupport isisJdoSupport;

}
