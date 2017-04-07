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
package org.isisaddons.app.kitchensink.integtests.modules.blobclob;

import javax.inject.Inject;
import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObject;
import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObjects;
import org.isisaddons.app.kitchensink.fixture.KitchensinkTearDownFixture;
import org.isisaddons.app.kitchensink.fixture.blobclob.BlobClobObjectsFixture;
import org.isisaddons.app.kitchensink.integtests.modules.KitchensinkAppIntegTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.apache.isis.applib.fixturescripts.FixtureScripts;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;
import static org.assertj.core.api.Assertions.assertThat;

public class BlobClobObjectIntegTest extends KitchensinkAppIntegTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Inject
    FixtureScripts fixtureScripts;
    @Inject
    BlobClobObjects blobClobObjects;


    @Before
    public void setUp() throws Exception {
        fixtureScripts.runFixtureScript(new KitchensinkTearDownFixture(), null);
    }

    @Test
    public void persist_then_update() throws Exception {

        // given, when
        final BlobClobObjectsFixture fs = new BlobClobObjectsFixture();
        fs.setNumberToCreate(1);
        fs.setName("Foo");
        fixtureScripts.runFixtureScript(fs, null);

        final Blob someBlob = fs.getObjects().get(0).getSomeBlob();
        final Clob someClob = fs.getObjects().get(0).getSomeClob();
        final Blob someImage = fs.getObjects().get(0).getSomeImage();

        nextSession();

        // then
        BlobClobObject blobClobObject = blobClobObjects.first();

        assertThat(blobClobObject.getName()).isEqualTo("Foo-0");
        assertThat(blobClobObject.getSomeBlob().getName()).isEqualTo(someBlob.getName());
        assertThat(blobClobObject.getSomeBlob().getBytes()).isEqualTo(someBlob.getBytes());
        assertThat(blobClobObject.getSomeBlob().getMimeType().toString()).isEqualTo(someBlob.getMimeType().toString());
        assertThat(blobClobObject.getSomeClob().getName()).isEqualTo(someClob.getName());
        assertThat(blobClobObject.getSomeClob().getChars()).isEqualTo(someClob.getChars());
        assertThat(blobClobObject.getSomeClob().getMimeType().toString()).isEqualTo(someClob.getMimeType().toString());
        assertThat(blobClobObject.getSomeImage().getName()).isEqualTo(someImage.getName());
        assertThat(blobClobObject.getSomeImage().getBytes()).isEqualTo(someImage.getBytes());
        assertThat(blobClobObject.getSomeImage().getMimeType().toString()).isEqualTo(someImage.getMimeType().toString());

        // when
        blobClobObject.updateSomeBlob(null);
        blobClobObject.updateSomeClob(null);
        blobClobObject.updateSomeImage(null);

        nextSession();

        // then
        blobClobObject = blobClobObjects.first();

        assertThat(blobClobObject.getSomeBlob()).isNull();
        assertThat(blobClobObject.getSomeClob()).isNull();
        assertThat(blobClobObject.getSomeImage()).isNull();
    }

}