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

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Primitive")
@DomainService(menuOrder = "10", repositoryFor = PrimitiveObject.class)
public class PrimitiveObjects extends RepositoryAbstract<PrimitiveObject> {

    public PrimitiveObjects() {
        super(PrimitiveObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public PrimitiveObject create(
            final @Named("Name") String name,
            final @Named("Byte") byte b,
            final @Named("Short") short s,
            final @Named("Int") int i,
            final @Named("Long") long l,
            final @Named("Float") float f,
            final @Named("Double") double d) {
        final PrimitiveObject obj = container.newTransientInstance(PrimitiveObject.class);
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


        container.persistIfNotAlready(obj);
        return obj;
    }
}
