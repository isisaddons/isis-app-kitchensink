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
package org.isisaddons.app.kitchensink.fixture.blobclob;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObject;
import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObjects;
import org.isisaddons.module.fakedata.dom.FakeDataService;

public class BlobClobObjectsFixture extends FixtureScript {

    //region > numberToCreate
    private Integer numberToCreate;

    /**
     * Defaults to 3
     */
    public Integer getNumberToCreate() {
        return numberToCreate;
    }

    public void setNumberToCreate(final Integer numberToCreate) {
        this.numberToCreate = numberToCreate;
    }
    //endregion


    //region > name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    //endregion

    //region > objects (output)
    private final List<BlobClobObject> objects = Lists.newArrayList();

    public List<BlobClobObject> getObjects() {
        return objects;
    }
    //endregion


    @Override
    protected void execute(final ExecutionContext ec) {

        defaultParam("numberToCreate", ec, 3);
        defaultParam("name", ec, fake.name().firstName());


        for (int k = 0; k < getNumberToCreate(); k++) {
            final String str = getName() + "-" + k;

            final BlobClobObject object;
            try {
                final Blob blob = newBlob(str, "application/pdf", "rick-mugridge-paper.pdf");
                final Blob image = newBlob(str, "image/jpeg", "flowers.jpg");
                final Clob clob = newClob(str, "application/rtf", "sample.rtf");

                object = blobClobObjects.createBlobClobObject(str, blob, image, clob);
                objects.add(object);
                ec.addResult(this, object);

            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Blob newBlob(final String name, final String mimeType, final String resourceName) throws IOException {
        final byte[] pdfBytes = Resources.toByteArray(Resources.getResource(getClass(), resourceName));
        return new Blob(name + "-" + resourceName, mimeType, pdfBytes);
    }

    private Clob newClob(final String name, final String mimeType, final String resourceName) throws IOException {
        final String contents = Resources.toString(Resources.getResource(getClass(), resourceName), Charset.forName("Cp1252"));
        return new Clob(name + "-" + resourceName, mimeType, contents);
    }

    @javax.inject.Inject
    private BlobClobObjects blobClobObjects;

    @Inject
    FakeDataService fake;

}
