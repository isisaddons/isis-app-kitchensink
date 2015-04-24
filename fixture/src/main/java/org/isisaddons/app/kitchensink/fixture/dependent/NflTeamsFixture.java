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

import org.isisaddons.app.kitchensink.dom.dependent.NflTeamEntity;
import org.isisaddons.app.kitchensink.dom.dependent.NflTeamEnum;
import org.isisaddons.app.kitchensink.dom.dependent.NflTeams;

public class NflTeamsFixture extends FixtureScript {


    @Override
    protected void execute(ExecutionContext executionContext) {

        for (final NflTeamEnum nflTeamEnum: NflTeamEnum.values()) {
            create(nflTeamEnum, executionContext);
        }
    }

    private NflTeamEntity create(final NflTeamEnum nflTeamEnum, ExecutionContext executionContext) {
        final NflTeamEntity nflTeamEntity = nflTeams.create(
                nflTeamEnum.getName(), nflTeamEnum.getRegion().getLeague(), nflTeamEnum.getRegion());
        return executionContext.addResult(this, nflTeamEntity);
    }

    @javax.inject.Inject
    private NflTeams nflTeams;

}
