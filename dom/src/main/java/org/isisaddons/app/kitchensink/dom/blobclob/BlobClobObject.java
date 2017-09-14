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
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.Ordering;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.value.Blob;
import org.apache.isis.applib.value.Clob;
import org.apache.isis.applib.value.Markup;

import org.isisaddons.app.kitchensink.dom.Entity;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObjects;
import org.isisaddons.app.kitchensink.dom.other.OtherObjects;

import lombok.Getter;
import lombok.Setter;

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

    @Column(allowsNull="false")
    @Title(sequence="1")
    @Getter @Setter
    private String name;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "someBlob_name"),
            @javax.jdo.annotations.Column(name = "someBlob_mimetype"),
            @javax.jdo.annotations.Column(name = "someBlob_bytes", jdbcType = "BLOB", sqlType = "VARBINARY")
    })
    @Property(optionality = Optionality.OPTIONAL)
    @Getter @Setter
    private Blob someBlob;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "someImage_name"),
            @javax.jdo.annotations.Column(name = "someImage_mimetype"),
            @javax.jdo.annotations.Column(name = "someImage_bytes", jdbcType = "BLOB", sqlType = "LONGVARBINARY")
    })
    @Getter @Setter
    @Property(optionality = Optionality.OPTIONAL, fileAccept ="image/*")
    private Blob someImage;

    @javax.jdo.annotations.Persistent(defaultFetchGroup="false", columns = {
            @javax.jdo.annotations.Column(name = "someClob_name"),
            @javax.jdo.annotations.Column(name = "someClob_mimetype"),
            @javax.jdo.annotations.Column(name = "someClob_chars", jdbcType = "CLOB", sqlType = "LONGVARCHAR")
    })
    @Property(optionality=Optionality.OPTIONAL, fileAccept =".txt")
    @Getter @Setter
    private Clob someClob;


    @Persistent
    @Property(optionality=Optionality.OPTIONAL, editing = Editing.DISABLED)
    @Column(allowsNull = "true", length = 4000)
    @Getter @Setter
    private Markup someMarkup;

    public BlobClobObject updateSomeMarkup(Markup markup) {
        setSomeMarkup(markup);
        return this;
    }
    public Markup defaultUpdate0SomeMarkup(String markup) {
        return getSomeMarkup();
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





    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject updateSomeImage(@Parameter(optionality=Optionality.OPTIONAL, fileAccept ="image/*") final  Blob i) {
        setSomeImage(i);
        return this;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject resetSomeImage() {
        setSomeImage(null);
        return this;
    }




    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject updateSomeClob(
            @Parameter(optionality=Optionality.OPTIONAL, fileAccept =".txt")
            final Clob clob) {
        setSomeClob(clob);
        return this;
    }

    @Action(semantics=SemanticsOf.IDEMPOTENT)
    public BlobClobObject resetSomeClob() {
        setSomeClob(null);
        return this;
    }




    @Override
    public int compareTo(final BlobClobObject other) {
        return Ordering.natural().onResultOf(BlobClobObject::getName).compare(this, other);
    }


    @javax.inject.Inject
    OtherObjects otherObjects;

    @javax.inject.Inject
    OtherBoundedObjects otherBoundedObjects;


}
