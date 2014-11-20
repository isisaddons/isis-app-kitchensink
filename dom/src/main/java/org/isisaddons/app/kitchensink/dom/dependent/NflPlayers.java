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
package org.isisaddons.app.kitchensink.dom.dependent;

import java.util.List;
import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;
import org.isisaddons.app.kitchensink.dom.reference.ReferenceObject;
import org.apache.isis.applib.annotation.CssClassFa;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.Optional;

@Named("Dependent")
@DomainService(menuOrder = "10.9", repositoryFor = ReferenceObject.class)
public class NflPlayers extends RepositoryAbstract<NflPlayer> {

    public NflPlayers() {
        super(NflPlayer.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public NflPlayer create(
            final @Named("Name") String name,
            final NflLeague league,
            final @Optional NflRegion region,
            final @Optional NflTeam nflTeam) {
        final NflPlayer obj = container.newTransientInstance(NflPlayer.class);
        obj.setName(name);

        obj.setLeague(league);
        obj.setRegion(region);
        obj.setTeam(nflTeam);

        container.persistIfNotAlready(obj);
        return obj;
    }

    public List<NflRegion> choices2Create(String name, NflLeague league) {
        return NflRegion.thoseFor(league);
    }
    public List<NflTeam> choices3Create(String name, NflLeague league, NflRegion region) {
        return NflTeam.thoseFor(region);
    }

}
