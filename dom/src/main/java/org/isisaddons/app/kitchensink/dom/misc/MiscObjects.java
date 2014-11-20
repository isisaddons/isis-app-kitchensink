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
package org.isisaddons.app.kitchensink.dom.misc;

import java.net.URL;
import java.util.List;
import java.util.UUID;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.apache.isis.applib.annotation.CssClassFa;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

@Named("Data Types")
@DomainService(menuOrder = "10.15", repositoryFor = MiscObject.class)
public class MiscObjects extends RepositoryAbstract<MiscObject> {

    public MiscObjects() {
        super(MiscObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public MiscObject createMiscObject(
            final @Named("Name") String name,
            final URL url,
            final UUID uuid) {
        final MiscObject obj = container.newTransientInstance(MiscObject.class);
        obj.setName(name);

        obj.setSomeUrlDisabled(url);
        obj.setSomeUrlHidden(url);
        obj.setSomeUrlMandatory(url);
        obj.setSomeUrlMandatoryWithChoices(url);
        obj.setSomeUrlWithValidation(url);
        obj.setSomeUrlOptional(url);
        obj.setSomeUrlOptionalWithChoices(url);


        obj.setSomeUuidDisabled(uuid);
        obj.setSomeUuidHidden(uuid);
        obj.setSomeUuidMandatory(uuid);
        obj.setSomeUuidMandatoryWithChoices(uuid);
        obj.setSomeUuidWithValidation(uuid);
        obj.setSomeUuidOptional(uuid);
        obj.setSomeUuidOptionalWithChoices(uuid);


        container.persistIfNotAlready(obj);
        return obj;
    }



    @Named("First MiscObject")
    @Override
    public MiscObject first() {
        return super.first();
    }

    @Named("List All MiscObjects")
    @Override
    public List<MiscObject> listAll() {
        return super.listAll();
    }


}
