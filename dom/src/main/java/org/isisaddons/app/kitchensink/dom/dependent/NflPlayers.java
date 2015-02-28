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
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;

@DomainService(repositoryFor = ReferenceObject.class)
@DomainServiceLayout(menuOrder = "10.9",named="Dependent")
public class NflPlayers extends RepositoryAbstract<NflPlayer> {

    public NflPlayers() {
        super(NflPlayer.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public NflPlayer create(
            final @ParameterLayout(named="Name") String name,
            final NflLeague league,
            @Parameter(optionality=Optionality.OPTIONAL) final  NflRegion region,
            @Parameter(optionality= Optionality.OPTIONAL) final  NflTeam nflTeam) {
        final NflPlayer obj = container.newTransientInstance(NflPlayer.class);
        obj.setName(name);

        obj.setLeague(league);
        obj.setRegion(region);
        obj.setTeam(nflTeam);

        container.persistIfNotAlready(obj);
        return obj;
    }

    public List<NflRegion> choices2Create(final String name, final NflLeague league) {
        return NflRegion.thoseFor(league);
    }
    public List<NflTeam> choices3Create(final String name, final NflLeague league, final NflRegion region) {
        return NflTeam.thoseFor(region);
    }

}
