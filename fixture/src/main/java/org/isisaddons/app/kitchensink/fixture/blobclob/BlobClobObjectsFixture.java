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
import com.google.common.io.Resources;
import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObject;
import org.isisaddons.app.kitchensink.dom.blobclob.BlobClobObjects;
import org.apache.isis.applib.fixturescripts.FixtureScript;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

public class BlobClobObjectsFixture extends FixtureScript {


    @Override
    protected void execute(ExecutionContext executionContext) {

        create("Foo", executionContext);
        create("Bar", executionContext);
        create("Baz", executionContext);
    }

    private BlobClobObject create(final String name, ExecutionContext executionContext) {
        try {
            final Blob blob = newBlob(name, "application/pdf", "rick-mugridge-paper.pdf");
            final Blob image = newBlob(name, "image/jpeg", "flowers.jpg");
            Clob clob = newClob(name, "application/rtf", "sample.rtf");
            return executionContext.add(this, blobClobObjects.createBlobClobObject(name, blob, image, clob));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Blob newBlob(String name, String mimeType, String resourceName) throws IOException {
        final byte[] pdfBytes = Resources.toByteArray(Resources.getResource(getClass(), resourceName));
        return new Blob(name + "-" + resourceName, mimeType, pdfBytes);
    }

    private Clob newClob(String name, String mimeType, String resourceName) throws IOException {
        final String contents = Resources.toString(Resources.getResource(getClass(), resourceName), Charset.forName("Cp1252"));
        return new Clob(name + "-" + resourceName, mimeType, contents);
    }

    @javax.inject.Inject
    private BlobClobObjects blobClobObjects;

}
