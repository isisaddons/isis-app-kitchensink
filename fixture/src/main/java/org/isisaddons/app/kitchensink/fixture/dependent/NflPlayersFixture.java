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
package org.isisaddons.app.kitchensink.fixture.dependent;

import org.apache.isis.applib.fixturescripts.FixtureScript;

import org.isisaddons.app.kitchensink.dom.dependent.NflLeague;
import org.isisaddons.app.kitchensink.dom.dependent.NflPlayer;
import org.isisaddons.app.kitchensink.dom.dependent.NflPlayers;
import org.isisaddons.app.kitchensink.dom.dependent.NflRegion;
import org.isisaddons.app.kitchensink.dom.dependent.NflTeamEnum;

public class NflPlayersFixture extends FixtureScript {


    @Override
    protected void execute(ExecutionContext executionContext) {

        create("John",   NflLeague.NFC, executionContext);
        create("Johnny", NflRegion.NFC_EAST, executionContext);

        create("Herc", NflTeamEnum.DAL, executionContext);
        create("Johnson", NflTeamEnum.DAL, executionContext);
        create("Murray", NflTeamEnum.NYG, executionContext);
        create("Sammy", NflTeamEnum.NYG, executionContext);

        create("Rich", NflRegion.NFC_WEST, executionContext);
        create("Dan", NflTeamEnum.ARI, executionContext);
        create("Dick", NflTeamEnum.SF, executionContext);
        create("Bert", NflTeamEnum.SF, executionContext);
        create("Burt", NflTeamEnum.SF, executionContext);
        create("Alf", NflTeamEnum.SEA, executionContext);

        create("Mike", NflLeague.AFC, executionContext);
        create("Victor", NflRegion.AFC_EAST, executionContext);
        create("Sean", NflRegion.AFC_NORTH, executionContext);
        create("Stef", NflTeamEnum.BAL, executionContext);
        create("Bob", NflTeamEnum.CIN, executionContext);
    }

    private NflPlayer create(final String name, final NflLeague league, ExecutionContext executionContext) {
        return executionContext.add(this, nflPlayers.create(name, league, null, null));
    }

    private NflPlayer create(final String name, final NflRegion region, ExecutionContext executionContext) {
        return executionContext.add(this, nflPlayers.create(name, region.getLeague(), region, null));
    }

    private NflPlayer create(final String name, final NflTeamEnum team, ExecutionContext executionContext) {
        return executionContext.add(this, nflPlayers.create(name, team.getRegion().getLeague(), team.getRegion(), team));
    }



    @javax.inject.Inject
    private NflPlayers nflPlayers;

}
