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

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Optionality;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Programmatic;

import org.isisaddons.app.kitchensink.dom.RepositoryAbstract;

@DomainService(repositoryFor = NflTeamEntity.class)
@DomainServiceLayout(menuOrder = "10.10",named="Dependent")
public class NflTeams extends RepositoryAbstract<NflTeamEntity> {

    public NflTeams() {
        super(NflTeamEntity.class, Visibility.VISIBLE);
    }

    @MemberOrder(sequence = "30")
    public NflTeamEntity create(
            final @ParameterLayout(named="Name") String name,
            final NflLeague league,
            @Parameter(optionality=Optionality.OPTIONAL) final  NflRegion region) {
        final NflTeamEntity obj = container.newTransientInstance(NflTeamEntity.class);

        obj.setName(name);
        obj.setRegion(region);

        container.persistIfNotAlready(obj);
        return obj;
    }

    public List<NflRegion> choices2Create(final String name, final NflLeague league) {
        return NflRegion.thoseFor(league);
    }


    @Programmatic
    public List<NflTeamEntity> thoseFor(final NflRegion leagueRegion) {
        final List<NflTeamEntity> nflTeamEntities = listAll();
        return Lists.newArrayList(Iterables.filter(nflTeamEntities, new Predicate<NflTeamEntity>() {
            @Override
            public boolean apply(NflTeamEntity input) {
                return input.getRegion() == leagueRegion;
            }
        }));
    }

    @Programmatic
    public NflTeamEntity lookup(final NflTeamEnum nflTeamEnum) {
        if(nflTeamEnum == null) {
            return null;
        }
        final List<NflTeamEntity> nflTeamEntities = listAll();
        final Iterator<NflTeamEntity> iterator = Iterables.filter(nflTeamEntities, new Predicate<NflTeamEntity>() {
            @Override
            public boolean apply(NflTeamEntity input) {
                return Objects.equal(nflTeamEnum.getName(), input.getName()) && Objects.equal(nflTeamEnum.getRegion(), input.getRegion());
            }
        }).iterator();
        return iterator.hasNext()? iterator.next(): null;
    }

}
