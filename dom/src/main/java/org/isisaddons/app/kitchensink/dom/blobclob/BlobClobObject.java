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
package org.isisaddons.app.kitchensink.dom.blobclob;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObjects;
import org.isisaddons.app.kitchensink.dom.other.OtherObjects;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "BLOBCLOB"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class BlobClobObject implements Entity<BlobClobObject> {

    //region > name (property)

    private String name;

    @Column(allowsNull="false")
    @Title(sequence="1")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //endregion

    //region > someBlob (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "someBlob_name"),
            @javax.jdo.annotations.Column(name = "someBlob_mimetype"),
            @javax.jdo.annotations.Column(name = "someBlob_bytes", jdbcType = "BLOB", sqlType = "BLOB")
    })
    private Blob someBlob;

    @Property(optionality = Optionality.OPTIONAL)
    public Blob getSomeBlob() {
        return someBlob;
    }

    public void setSomeBlob(final Blob someBlob) {
        this.someBlob = someBlob;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public BlobClobObject updateSomeBlob(
            @Parameter(optionality = Optionality.OPTIONAL)
            final Blob blob) {
        setSomeBlob(blob);
        return this;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT)
    public BlobClobObject resetSomeBlob() {
        setSomeBlob(null);
        return this;
    }
    //endregion

    //region > someImage (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "someImage_name"),
            @javax.jdo.annotations.Column(name = "someImage_mimetype"),
            @javax.jdo.annotations.Column(name = "someImage_bytes", jdbcType = "BLOB", sqlType = "BLOB")
    })
    private Blob someImage;

    @Property(optionality = Optionality.OPTIONAL)
    public Blob getSomeImage() {
        return someImage;
    }

    public void setSomeImage(final Blob someImage) {
        this.someImage = someImage;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject updateSomeImage(@Parameter(optionality=Optionality.OPTIONAL) final  Blob i) {
        setSomeImage(i);
        return this;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject resetSomeImage() {
        setSomeImage(null);
        return this;
    }
    //endregion

    //region > someClob (property)
    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "someClob_name"),
            @javax.jdo.annotations.Column(name = "someClob_mimetype"),
            @javax.jdo.annotations.Column(name = "someClob_chars", jdbcType = "CLOB", sqlType = "CLOB")
    })
    private Clob someClob;

    @Property(optionality=Optionality.OPTIONAL)
    public Clob getSomeClob() {
        return someClob;
    }

    public void setSomeClob(final Clob someClob) {
        this.someClob = someClob;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject updateSomeClob(
            @Parameter(optionality=Optionality.OPTIONAL)
            final Clob clob) {
        setSomeClob(clob);
        return this;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject resetSomeClob() {
        setSomeClob(null);
        return this;
    }
    //endregion

    //region > compareTo

    @Override
    public int compareTo(final BlobClobObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @javax.inject.Inject
    private OtherObjects otherObjects;

    @javax.inject.Inject
    private OtherBoundedObjects otherBoundedObjects;

    //endregion

}
