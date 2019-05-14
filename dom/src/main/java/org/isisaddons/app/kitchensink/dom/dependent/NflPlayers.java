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

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.registry.ServiceRegistry2;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(
        repositoryFor = NflPlayer.class
)
public class NflPlayers extends RepositoryAbstract<NflPlayer> {

    public NflPlayers() {
        super(NflPlayer.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public NflPlayer create(
            @ParameterLayout(named="Name")
            final String name,
            final NflLeague league,
            @Parameter(optionality=Optionality.OPTIONAL) final  NflRegion region,
            @Parameter(optionality= Optionality.OPTIONAL) final NflTeamEnum nflTeamEnum) {

        final NflPlayer nflPlayer = serviceRegistry2.injectServicesInto(new NflPlayer(name));
        nflPlayer.updateUsingEnum(league, region, nflTeamEnum);

        repositoryService.persist(nflPlayer);
        return nflPlayer;
    }

    public List<NflRegion> choices2Create(final String name, final NflLeague league) {
        return NflRegion.thoseFor(league);
    }
    public List<NflTeamEnum> choices3Create(final String name, final NflLeague league, final NflRegion region) {
        return NflTeamEnum.thoseFor(region);
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @MemberOrder(sequence = "1")
    public NflPlayer newPlayer(
            @ParameterLayout(named="Name")
            final String name,
            final NflLeague league,
            final List<INflLeague> unused) {

        final NflPlayer nflPlayer = serviceRegistry2.injectServicesInto(new NflPlayer(name));

        repositoryService.persist(nflPlayer);
        return nflPlayer;

    }

    public List<INflLeague> choices2NewPlayer() {
        return Arrays.asList(NflLeague.values());
    }


    @Inject
    ServiceRegistry2 serviceRegistry2;

}
