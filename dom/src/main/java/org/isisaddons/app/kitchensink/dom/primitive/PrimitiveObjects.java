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
package org.isisaddons.app.kitchensink.dom.primitive;

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
        repositoryFor = PrimitiveObject.class
)
@DomainServiceLayout(
        named="Data Types",
        menuOrder = "10.2"
)
public class PrimitiveObjects extends RepositoryAbstract<PrimitiveObject> {

    public PrimitiveObjects() {
        super(PrimitiveObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public PrimitiveObject createPrimitiveObject(
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
        final PrimitiveObject obj = repositoryService.instantiate(PrimitiveObject.class);
        obj.setName(name);

        obj.setSomeByte(b);
        obj.setSomeByteHidden(b);
        obj.setSomeIntDisabled(b);
        obj.setSomeIntWithValidation(b);
        obj.setSomeIntWithChoices(b);
        obj.setSomeIntWithChoices(b);

        obj.setSomeShort(s);
        obj.setSomeShortHidden(s);
        obj.setSomeShortDisabled(s);
        obj.setSomeShortWithValidation(s);
        obj.setSomeShortWithChoices(s);
        obj.setSomeShortWithChoices(s);

        obj.setSomeInt(i);
        obj.setSomeIntHidden(i);
        obj.setSomeIntDisabled(i);
        obj.setSomeIntWithValidation(i);
        obj.setSomeIntWithChoices(i);
        obj.setSomeIntWithChoices(i);

        obj.setSomeLong(l);
        obj.setSomeLongHidden(l);
        obj.setSomeLongDisabled(l);
        obj.setSomeLongWithValidation(l);
        obj.setSomeLongWithChoices(l);
        obj.setSomeLongWithChoices(l);

        obj.setSomeFloat(f);
        obj.setSomeFloatHidden(f);
        obj.setSomeFloatDisabled(f);
        obj.setSomeFloatWithValidation(f);
        obj.setSomeFloatWithChoices(f);
        obj.setSomeFloatWithChoices(f);

        obj.setSomeDouble(d);
        obj.setSomeDoubleHidden(d);
        obj.setSomeDoubleDisabled(d);
        obj.setSomeDoubleWithValidation(d);
        obj.setSomeDoubleWithChoices(d);
        obj.setSomeDoubleWithChoices(d);


        repositoryService.persist(obj);
        return obj;
    }


    @ActionLayout(named="First PrimitiveObject")
    @Override
    public PrimitiveObject first() {
        return super.first();
    }

    @ActionLayout(named="List All PrimitiveObjects")
    @Override
    public List<PrimitiveObject> listAll() {
        return super.listAll();
    }


}
