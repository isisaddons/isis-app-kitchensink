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
package org.isisaddons.app.kitchensink.dom.message;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;
import org.isisaddons.app.kitchensink.dom.Entity;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.NonRecoverableException;
import org.apache.isis.applib.RecoverableException;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "MESSAGE"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class MessageObject implements Entity<MessageObject> {


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



    @MemberOrder(name="name", sequence = "30.1")
    public MessageObject updateAndInformUser(
            final @ParameterLayout(named="Name") String name) {
        setName(name);
        container.informUser("Created object: " + name + " (informUser)");
        return this;
    }

    @MemberOrder(name="name", sequence = "30.2")
    public MessageObject updateAndWarnUser(
            final @ParameterLayout(named="Name") String name) {
        setName(name);
        container.warnUser("Created object: " + name + " (warnUser)");
        return this;
    }

    @MemberOrder(name="name", sequence = "30.3")
    public MessageObject updateAndRaiseError(
            final @ParameterLayout(named="Name") String name) {
        setName(name);
        container.raiseError("Created object: " + name + " (raiseError)");
        return this;
    }

    @MemberOrder(sequence = "30.4")
    public MessageObject updateAndThrowRecoverableException(
            final @ParameterLayout(named="Name") String name) {
        setName(name);
        throw new RecoverableException("A recoverable (application) exception has been thrown; the object should NOT have been updated (to '" + name + "') ");
    }

    @MemberOrder(sequence = "30.5")
    public MessageObject updateAndThrowNonRecoverableException(
            final @ParameterLayout(named="Name") String name) {
        setName(name);
        throw new NonRecoverableException("A non-recoverable exception has been thrown; the object should NOT have been updated (to '" + name + "') ");
    }

    @MemberOrder(sequence = "30.6")
    public MessageObject updateAndThrowRuntimeException(
            final @ParameterLayout(named="Name") String name) {
        setName(name);
        throw new RuntimeException("A runtime exception has been thrown; the object should NOT have been updated (to '" + name + "') ");
    }


    //endregion

    //region > cloneAnd...

    @MemberOrder(sequence = "40.1")
    public MessageObject cloneAndInformUser() {
        final MessageObject clonedObject = messageObjects.create(getName() + " (cloned)");
        container.informUser("Cloned object: " + name + " (informUser)");
        return clonedObject;
    }

    @MemberOrder(sequence = "40.2")
    public MessageObject cloneAndWarnUser() {
        final MessageObject clonedObject = messageObjects.create(getName() + " (cloned)");
        container.warnUser("Cloned object: " + name + " (warnUser)");
        return clonedObject;
    }

    @MemberOrder(sequence = "40.3")
    public MessageObject cloneAndRaiseError() {
        final MessageObject clonedObject = messageObjects.create(getName() + " (cloned)");
        container.raiseError("Cloned object: " + name + " (raiseError)");
        return clonedObject;
    }

    @MemberOrder(sequence = "40.4")
    public MessageObject cloneAndThrowRecoverableException(
            final @ParameterLayout(named="Name") String name) {
        final String cloneName = getName() + " (cloned)";
        messageObjects.create(cloneName);
        throw new RecoverableException("A recoverable (application) exception has been thrown; the object (name='" + cloneName + "') should NOT have been created");
    }

    @MemberOrder(sequence = "40.5")
    public MessageObject cloneAndThrowNonRecoverableException(
            final @ParameterLayout(named="Name") String name) {
        final String cloneName = getName() + " (cloned)";
        messageObjects.create(cloneName);
        throw new NonRecoverableException("A non-recoverable exception has been thrown; the object (name='" + cloneName + "') should NOT have been created");
    }

    @MemberOrder(sequence = "40.6")
    public MessageObject createAndThrowRuntimeException(
            final @ParameterLayout(named="Name") String name) {
        final String cloneName = getName() + " (cloned)";
        messageObjects.create(cloneName);
        throw new RuntimeException("A runtime exception has been thrown; the object (name='" + cloneName + "') should NOT have been created");
    }

    //endregion

    //region > compareTo

    @Override
    public int compareTo(MessageObject other) {
        return ObjectContracts.compare(this, other, "name");
    }

    //endregion

    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    @javax.inject.Inject
    private MessageObjects messageObjects;

    //endregion

}
