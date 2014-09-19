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

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Wrappers")
@DomainService(menuOrder = "10", repositoryFor = WrapperObject.class)
public class WrapperObjects extends RepositoryAbstract<WrapperObject> {

    public WrapperObjects() {
        super(WrapperObject.class);
    }

    @MemberOrder(sequence = "30")
    public WrapperObject create(
            final @Named("Name") String name,
            final @Named("Byte") byte b,
            final @Named("Short") short s,
            final @Named("Int") int i,
            final @Named("Long") long l,
            final @Named("Float") float f,
            final @Named("Double") double d) {
        final WrapperObject obj = container.newTransientInstance(WrapperObject.class);
        obj.setName(name);

        obj.setSomeByteWrapperMandatory(b);
        obj.setSomeByteWrapperOptional(b);

        obj.setSomeShortWrapperMandatory(s);
        obj.setSomeShortWrapperOptional(s);

        obj.setSomeIntegerWrapperMandatory(i);
        obj.setSomeIntegerWrapperOptional(i);

        obj.setSomeLongWrapperMandatory(l);
        obj.setSomeLongWrapperOptional(l);

        obj.setSomeFloatWrapperMandatory(f);
        obj.setSomeFloatWrapperOptional(f);

        obj.setSomeDoubleWrapperMandatory(d);
        obj.setSomeDoubleWrapperOptional(d);

        container.persistIfNotAlready(obj);
        return obj;
    }
}
