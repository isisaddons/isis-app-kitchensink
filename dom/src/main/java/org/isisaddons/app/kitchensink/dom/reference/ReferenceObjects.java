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
package org.isisaddons.app.kitchensink.dom.reference;

import java.util.List;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.isisaddons.app.kitchensink.dom.other.OtherBoundedObject;
import org.isisaddons.app.kitchensink.dom.other.OtherObject;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;

@DomainService(menuOrder = "10.8", repositoryFor = ReferenceObject.class)
@DomainServiceLayout(named="Data Types")
public class ReferenceObjects extends RepositoryAbstract<ReferenceObject> {

    public ReferenceObjects() {
        super(ReferenceObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public ReferenceObject createReferenceObject(
            final @ParameterLayout(named="Name") String name,
            final @ParameterLayout(named="Some Int") int i,
            final OtherObject otherObject,
            final OtherBoundedObject otherBoundedObject) {
        final ReferenceObject obj = container.newTransientInstance(ReferenceObject.class);
        obj.setName(name);

        obj.setSomeOtherObjectMandatoryWithChoices(otherObject);
        obj.setSomeOtherObjectActionOnlyWithChoices(otherObject);
        obj.setSomeOtherBoundedObjectMandatory(otherBoundedObject);

        container.persistIfNotAlready(obj);
        return obj;
    }



    @ActionLayout(named="First ReferenceObject")
    @Override
    public ReferenceObject first() {
        return super.first();
    }

    @ActionLayout(named="List All ReferenceObjects")
    @Override
    public List<ReferenceObject> listAll() {
        return super.listAll();
    }



}
