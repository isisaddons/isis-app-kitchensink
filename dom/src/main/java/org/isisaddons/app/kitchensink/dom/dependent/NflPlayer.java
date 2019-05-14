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

import javax.annotation.Nullable;
import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.VersionStrategy;

import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.util.ObjectContracts;

import org.isisaddons.app.kitchensink.dom.Entity;

import lombok.Getter;
import lombok.Setter;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@javax.jdo.annotations.DatastoreIdentity(
        strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY,
         column="id")
@javax.jdo.annotations.Version(
        strategy=VersionStrategy.VERSION_NUMBER, 
        column="version")
@DomainObject(
        objectType = "NFLPLAYER"
)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)
public class NflPlayer implements Entity<NflPlayer> {

    public NflPlayer(final String name) {
        this.name = name;
    }

    @Column(allowsNull="false")
    @Title(sequence="1")
    @Getter @Setter
    private String name;

    @Property(editing = Editing.DISABLED)
    @Column(allowsNull = "false")
    @MemberOrder(sequence = "1")
    @Getter @Setter
    private NflLeague league;

    @Property(editing = Editing.DISABLED)
    @Column(allowsNull = "true")
    @MemberOrder(sequence = "1")
    @Getter @Setter
    private NflRegion region;

    @Property(editing = Editing.DISABLED)
    @Column(allowsNull = "true")
    @MemberOrder(sequence = "1")
    @Getter @Setter
    private NflTeamEnum teamEnum;


    @Property(editing = Editing.DISABLED)
    @Column(allowsNull = "true")
    @MemberOrder(sequence = "1")
    @Getter @Setter
    private NflTeamEntity teamEntity;
    //endregion

    //region > updateUsingEntity (action)

    public NflPlayer updateUsingEntity(
            final NflLeague league,
            @Nullable final NflRegion region,
            @Nullable final NflTeamEntity nflTeamEntity) {

        setLeague(league);
        setRegion(region);
        setTeamEnum(NflTeamEnum.lookup(nflTeamEntity));
        setTeamEntity(nflTeamEntity);

        return this;
    }

    public List<NflRegion> choices1UpdateUsingEntity(final NflLeague league) {
        return NflRegion.thoseFor(league);
    }
    public List<NflTeamEntity> choices2UpdateUsingEntity(final NflLeague league, final NflRegion region) {
        return nflTeams.thoseFor(region);
    }

    public NflLeague default0UpdateUsingEntity() {
        return getLeague();
    }
    //    public NflRegion default1UpdateUsingEntity(final NflLeague nflLeague) {
    //        return choices1UpdateUsingEntity(nflLeague).stream().findFirst().orElse(null);
    //    }
    //    public NflTeamEntity default2UpdateUsingEntity(final NflLeague league, final NflRegion region) {
    //        return choices2UpdateUsingEntity(league, region).stream().findFirst().orElse(null);
    //    }
    //endregion

    //region > updateUsingEnum (action)

    public NflPlayer updateUsingEnum(
            final NflLeague league,
            /*@Nullable */final NflRegion region,
            @Nullable final NflTeamEnum nflTeamEnum) {

        final NflTeamEntity nflTeamEntity = nflTeams.lookup(nflTeamEnum);
        return updateUsingEntity(league, region, nflTeamEntity);
    }

    public List<NflRegion> choices1UpdateUsingEnum(final NflLeague league) {
        return NflRegion.thoseFor(league);
    }
    public List<NflTeamEnum> choices2UpdateUsingEnum(final NflLeague league, final NflRegion region) {
        return NflTeamEnum.thoseFor(region);
    }

    public NflLeague default0UpdateUsingEnum() {
        return getLeague();
    }
    public NflRegion default1UpdateUsingEnum(final NflLeague nflLeague) {
        return choices1UpdateUsingEntity(nflLeague).stream().findFirst().orElse(null);
    }
//    public NflTeamEnum default2UpdateUsingEnum() {
//        return getTeamEnum();
//    }
    //endregion




    @Override
    public int compareTo(final NflPlayer other) {
        return ObjectContracts.compare(this, other, "name");
    }


    @javax.inject.Inject
    NflTeams nflTeams;


}
