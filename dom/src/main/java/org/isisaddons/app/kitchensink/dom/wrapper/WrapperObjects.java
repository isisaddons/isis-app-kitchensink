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
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;

@DomainService(repositoryFor = WrapperObject.class)
@DomainServiceLayout(named="Data Types", menuOrder = "10.3")
public class WrapperObjects extends RepositoryAbstract<WrapperObject> {

    public WrapperObjects() {
        super(WrapperObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public WrapperObject createWrapperObject(
            final @ParameterLayout(named="Name") String name,
            final @ParameterLayout(named="Byte") byte b,
            final @ParameterLayout(named="Short") short s,
            final @ParameterLayout(named="Int") int i,
            final @ParameterLayout(named="Long") long l,
            final @ParameterLayout(named="Float") float f,
            final @ParameterLayout(named="Double") double d) {
        final WrapperObject obj = container.newTransientInstance(WrapperObject.class);
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

        container.persistIfNotAlready(obj);
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
