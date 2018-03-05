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
package org.isisaddons.app.kitchensink.dom.text;

import java.util.List;

import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.value.Password;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = TextObject.class
)
@DomainServiceLayout(
        named="Data Types",
        menuOrder = "10.1"
)
public class TextObjects  {

    private final static Class<TextObject> cls = TextObject.class;

    @MemberOrder(sequence = "30")
    public TextObject createTextObject(
            @ParameterLayout(named="Name")
            final String name) {
        final TextObject obj = repositoryService.instantiate(TextObject.class);
        obj.setName(name);

        final char nameChar0 = name.charAt(0);
        final Password password = new Password(name);

        obj.setSomeChar(nameChar0);
        obj.setSomeCharHidden(nameChar0);
        obj.setSomeCharDisabled(nameChar0);
        obj.setSomeCharWithValidation(nameChar0);
        obj.setSomeCharWithChoices(nameChar0);

        obj.setSomeCharacterWrapperMandatory(nameChar0);
        obj.setSomeCharacterWrapperOptional(nameChar0);
        obj.setSomeCharacterWrapperHidden(nameChar0);
        obj.setSomeCharacterWrapperDisabled(nameChar0);
        obj.setSomeCharacterWrapperWithValidation(nameChar0);
        obj.setSomeCharacterWrapperMandatoryWithChoices(nameChar0);
        obj.setSomeCharacterWrapperOptional(nameChar0);

        obj.setSomeStringMandatory(name);
        obj.setSomeStringOptional(name);
        obj.setSomeStringHidden(name);
        obj.setSomeStringDisabled(name);
        obj.setSomeStringWithValidation(name);
        obj.setSomeStringMandatoryWithChoices(name);
        obj.setSomeStringOptionalWithChoices(name);

        obj.setSomePasswordMandatory(password);
        obj.setSomePasswordOptional(password);
        obj.setSomePasswordHidden(password);
        obj.setSomePasswordDisabled(password);
        obj.setSomePasswordWithValidation(password);
        obj.setSomePasswordMandatoryWithChoices(password);
        obj.setSomePasswordOptionalWithChoices(password);
        
        obj.setSomeString20(name);
        obj.setSomeString50(name);

        obj.setSomeStringMultiline(name);
        obj.setSomeStringMultilineNoWrap(name);

        repositoryService.persist(obj);
        return obj;
    }


    @ActionLayout(named="First TextObject")
    public TextObject first() {
        return listAll().stream().findFirst().orElse(null);
    }

    @ActionLayout(named="List All TextObjects")
    public List<TextObject> listAll() {
        return repositoryService.allInstances(cls);
    }


    @javax.inject.Inject
    RepositoryService repositoryService;


}
