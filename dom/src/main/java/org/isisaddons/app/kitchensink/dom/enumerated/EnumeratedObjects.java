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
package org.isisaddons.app.kitchensink.dom.enumerated;

import java.util.List;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;

@DomainService(repositoryFor = EnumeratedObject.class)
@DomainServiceLayout(named="Data Types", menuOrder = "10.6")
public class EnumeratedObjects extends RepositoryAbstract<EnumeratedObject> {

    public EnumeratedObjects() {
        super(EnumeratedObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public EnumeratedObject createEnumeratedObject(
            final @ParameterLayout(named="Name") String name,
            final boolean b,
            final EnumOf3 enumOf3,
            final EnumOf4 enumOf4,
            final EnumOf8 enumOf8) {
        final EnumeratedObject obj = container.newTransientInstance(EnumeratedObject.class);
        obj.setName(name);

        obj.setSomeBoolean(b);
        obj.setSomeBooleanHidden(b);
        obj.setSomeBooleanDisabled(b);
        obj.setSomeBooleanWithValidation(b);

        obj.setSomeBooleanWrapperMandatory(b);
        obj.setSomeBooleanWrapperOptional(b);
        obj.setSomeBooleanWrapperHidden(b);
        obj.setSomeBooleanWrapperDisabled(b);
        obj.setSomeBooleanWrapperWithValidation(b);

        obj.setSomeEnumOf3Mandatory(enumOf3);
        obj.setSomeEnumOf3Optional(enumOf3);
        obj.setSomeEnumOf3Hidden(enumOf3);
        obj.setSomeEnumOf3Disabled(enumOf3);
        obj.setSomeEnumOf3WithValidation(enumOf3);

        obj.setSomeEnumOf4Mandatory(enumOf4);
        obj.setSomeEnumOf4Optional(enumOf4);
        obj.setSomeEnumOf4Hidden(enumOf4);
        obj.setSomeEnumOf4Disabled(enumOf4);
        obj.setSomeEnumOf4WithValidation(enumOf4);

        obj.setSomeEnumOf8Mandatory(enumOf8);
        obj.setSomeEnumOf8Optional(enumOf8);
        obj.setSomeEnumOf8Hidden(enumOf8);
        obj.setSomeEnumOf8Disabled(enumOf8);
        obj.setSomeEnumOf8WithValidation(enumOf8);

        container.persistIfNotAlready(obj);
        return obj;
    }

    @ActionLayout(named="First EnumeratedObject")
    @Override
    public EnumeratedObject first() {
        return super.first();
    }

    @ActionLayout(named="List All EnumeratedObjects")
    @Override
    public List<EnumeratedObject> listAll() {
        return super.listAll();
    }



}
