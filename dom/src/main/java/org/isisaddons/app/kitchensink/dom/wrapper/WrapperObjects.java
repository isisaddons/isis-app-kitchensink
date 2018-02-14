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
package org.isisaddons.app.kitchensink.dom.wrapper;

import java.util.List;

import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = WrapperObject.class
)
@DomainServiceLayout(
        named="Data Types",
        menuOrder = "10.3"
)
public class WrapperObjects extends RepositoryAbstract<WrapperObject> {

    public WrapperObjects() {
        super(WrapperObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public WrapperObject createWrapperObject(
            @ParameterLayout(named="Name")
            final String name,
            @ParameterLayout(named="Byte")
            final byte b,
            @ParameterLayout(named="Short")
            final short s,
            @ParameterLayout(named="Int")
            final int i,
            @ParameterLayout(named="Long")
            final long l,
            @ParameterLayout(named="Float")
            final float f,
            @ParameterLayout(named="Double")
            final double d) {
        final WrapperObject obj = repositoryService.instantiate(WrapperObject.class);
        obj.setName(name);

        obj.setSomeByteWrapperMandatory(b);
        obj.setSomeByteWrapperOptional(b);

        obj.setSomeShortWrapperMandatory(s);
        obj.setSomeShortWrapperOptional(s);

        obj.setSomeIntegerWrapperMandatory(i);
        obj.setSomeIntegerWrapperOptional(i);
        obj.setSomeIntegerWrapperHidden(i);
        obj.setSomeIntegerWrapperDisabled(i);
        obj.setSomeIntegerWrapperMandatoryWithChoices(i);
        obj.setSomeIntegerWrapperOptionalWithChoices(i);
        obj.setSomeIntegerWrapperWithValidation(i);

        obj.setSomeLongWrapperMandatory(l);
        obj.setSomeLongWrapperOptional(l);

        obj.setSomeFloatWrapperMandatory(f);
        obj.setSomeFloatWrapperOptional(f);

        obj.setSomeDoubleWrapperMandatory(d);
        obj.setSomeDoubleWrapperOptional(d);

        repositoryService.persist(obj);
        return obj;
    }



    @ActionLayout(named="First WrapperObject")
    @Override
    public WrapperObject first() {
        return super.first();
    }

    @ActionLayout(named="List All WrapperObjects")
    @Override
    public List<WrapperObject> listAll() {
        return super.listAll();
    }


}
