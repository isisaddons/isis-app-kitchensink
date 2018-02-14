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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.value.Money;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        repositoryFor = MiscObject.class
)
@DomainServiceLayout(
        named="Misc",
        menuOrder = "10.15"
)
public class MiscObjects extends RepositoryAbstract<MiscObject> {

    public MiscObjects() {
        super(MiscObject.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public MiscObject createMiscObject(
            final @ParameterLayout(named="Name") String name,
            final URL url,
            final UUID uuid,
            final Money money) {
        final MiscObject obj = repositoryService.instantiate(MiscObject.class);
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

        obj.setSomeMoneyDisabled(money);
        obj.setSomeMoneyHidden(money);
        obj.setSomeMoneyMandatory(money);
        obj.setSomeMoneyMandatoryWithChoices(money);
        obj.setSomeMoneyWithValidation(money);
        obj.setSomeMoneyOptional(money);
        obj.setSomeMoneyOptionalWithChoices(money);

        repositoryService.persist(obj);
        return obj;
    }



    @ActionLayout(named="First MiscObject")
    @Override
    public MiscObject first() {
        return super.first();
    }

    @ActionLayout(named="List All MiscObjects")
    @Override
    public List<MiscObject> listAll() {
        return super.listAll();
    }


    @Action(semantics = SemanticsOf.SAFE)
    public URL openGoogle() throws MalformedURLException {
        return new java.net.URL("https://www.google.com");
    }

    @Action(semantics = SemanticsOf.SAFE)
    public URL openUrl(@ParameterLayout(named="Url") String url) throws MalformedURLException {
        return new java.net.URL(url);
    }
    public String validateOpenUrl(String url) {
        if (url == null)
            return "No URL to open";
        try {
            openUrl(url);
        } catch (MalformedURLException ex) {
            return "Bad URL";
        }
        return null;
    }



}
