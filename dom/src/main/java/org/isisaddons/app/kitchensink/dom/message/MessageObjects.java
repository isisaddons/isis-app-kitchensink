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

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.NonRecoverableException;
import org.apache.isis.applib.RecoverableException;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;

@DomainService(repositoryFor = MessageObject.class)
@DomainServiceLayout(named="Messages",menuOrder = "10.12")
public class MessageObjects extends RepositoryAbstract<MessageObject> {

    public MessageObjects() {
        super(MessageObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30.1")
    public MessageObject createAndInfoMessage(
            final @ParameterLayout(named="Name") String name) {
        final MessageObject messageObject = create(name);
        container.informUser("Created object: " + name + " (informUser)");
        return messageObject;
    }

    @MemberOrder(sequence = "30.2")
    public MessageObject createAndWarnUser(
            final @ParameterLayout(named="Name") String name) {
        final MessageObject messageObject = create(name);
        container.warnUser("Created object: " + name + " (warnUser)");
        return messageObject;
    }

    @MemberOrder(sequence = "30.3")
    public MessageObject createAndRaiseError(
            final @ParameterLayout(named="Name") String name) {
        final MessageObject messageObject = create(name);
        container.raiseError("Created object: " + name + " (raiseError)");
        return messageObject;
    }

    @MemberOrder(sequence = "30.4")
    public MessageObject createAndThrowRecoverableException(
            final @ParameterLayout(named="Name") String name) {
        create(name);
        throw new RecoverableException("A recoverable (application) exception has been thrown; the object (name='" + name + "') should NOT have been created");
    }

    @MemberOrder(sequence = "30.5")
    public MessageObject createAndThrowNonRecoverableException(
            final @ParameterLayout(named="Name") String name) {
        create(name);
        throw new NonRecoverableException("A non-recoverable exception has been thrown; the object (name='" + name + "') should NOT have been created");
    }

    @MemberOrder(sequence = "30.6")
    public MessageObject createAndThrowRuntimeException(
            final @ParameterLayout(named="Name") String name) {
        create(name);
        throw new RuntimeException("A runtime exception has been thrown; the object (name='" + name + "') should NOT have been created");
    }

    @Programmatic
    public MessageObject create(String name) {
        final MessageObject obj = container.newTransientInstance(MessageObject.class);
        obj.setName(name);

        container.persistIfNotAlready(obj);
        return obj;
    }

}
