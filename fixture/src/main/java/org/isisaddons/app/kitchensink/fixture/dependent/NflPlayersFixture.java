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

import org.isisaddons.app.kitchensink.dom.dependent.*;
import org.apache.isis.applib.fixturescripts.FixtureScript;

public class NflPlayersFixture extends FixtureScript {


    @Override
    protected void execute(ExecutionContext executionContext) {

        create("John",   NflLeague.NFC, executionContext);
        create("Johnny", NflRegion.NFC_EAST, executionContext);

        create("Herc", NflTeam.DAL, executionContext);
        create("Johnson", NflTeam.DAL, executionContext);
        create("Murray", NflTeam.NYG, executionContext);
        create("Sammy", NflTeam.NYG, executionContext);

        create("Rich", NflRegion.NFC_WEST, executionContext);
        create("Dan", NflTeam.ARI, executionContext);
        create("Dick", NflTeam.SF, executionContext);
        create("Bert", NflTeam.SF, executionContext);
        create("Burt", NflTeam.SF, executionContext);
        create("Alf", NflTeam.SEA, executionContext);

        create("Mike", NflLeague.AFC, executionContext);
        create("Victor", NflRegion.AFC_EAST, executionContext);
        create("Sean", NflRegion.AFC_NORTH, executionContext);
        create("Stef", NflTeam.BAL, executionContext);
        create("Bob", NflTeam.CIN, executionContext);
    }

    private NflPlayer create(final String name, final NflLeague league, ExecutionContext executionContext) {
        return executionContext.add(this, nflPlayers.create(name, league, null, null));
    }

    private NflPlayer create(final String name, final NflRegion region, ExecutionContext executionContext) {
        return executionContext.add(this, nflPlayers.create(name, region.getLeague(), region, null));
    }

    private NflPlayer create(final String name, final NflTeam team, ExecutionContext executionContext) {
        return executionContext.add(this, nflPlayers.create(name, team.getRegion().getLeague(), team.getRegion(), team));
    }



    @javax.inject.Inject
    private NflPlayers nflPlayers;

}
