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
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public enum NflTeam {
    BAL("Baltimore Ravens", NflRegion.AFC_NORTH),
    CIN("Cincinnati Bengals", NflRegion.AFC_NORTH),
    CLE("Cleveland Browns", NflRegion.AFC_NORTH),
    PIT("Pittsburgh Steelers", NflRegion.AFC_NORTH),
    CHI("Chicago Bears", NflRegion.NFC_NORTH),
    DET("Detroit Lions", NflRegion.NFC_NORTH),
    GB("Green Bay Packers", NflRegion.NFC_NORTH),
    MIN("Minnesota Vikings", NflRegion.NFC_NORTH),
    HOU("Houston Texans", NflRegion.AFC_SOUTH),
    IND("Indianopolis Colts", NflRegion.AFC_SOUTH),
    JAC("Jacksonville Jaguars", NflRegion.AFC_SOUTH),
    TEN("Tennessee Titans", NflRegion.AFC_SOUTH),
    ATL("Atlanta Falcons", NflRegion.NFC_SOUTH),
    CAR("Carolina Panthers", NflRegion.NFC_SOUTH),
    NO("New Orleans Saints", NflRegion.NFC_SOUTH),
    TB("Tampa Bay Buccaneers", NflRegion.NFC_SOUTH),
    BUF("Buffalo Bills", NflRegion.AFC_EAST),
    MIA("Miami Dolphins", NflRegion.AFC_EAST),
    NE("New England Patriots", NflRegion.AFC_EAST),
    NYJ("New York Jets", NflRegion.AFC_EAST),
    DAL("Dallas Cowboys", NflRegion.NFC_EAST),
    NYG("New York Giants", NflRegion.NFC_EAST),
    PHI("Philadelphia Eagles", NflRegion.NFC_EAST),
    WAS("Washington Redskins", NflRegion.NFC_EAST),
    DEN("Denver Broncos", NflRegion.AFC_WEST),
    KC("Kansas City Chiefs", NflRegion.AFC_WEST),
    OAK("Oakland Raiders", NflRegion.AFC_WEST),
    SD("San Diego Chargers", NflRegion.AFC_WEST),
    ARI("Arizona Cardinals", NflRegion.NFC_WEST),
    SF("San Francisco 49ers", NflRegion.NFC_WEST),
    SEA("Seattle Seahawks", NflRegion.NFC_WEST),
    STL("St Louis Rams", NflRegion.NFC_WEST);

    private final String name;
    private final NflRegion leagueRegion;

    NflTeam(String name, NflRegion leagueRegion) {
        this.name = name;
        this.leagueRegion = leagueRegion;
    }

    public String getName() {
        return name;
    }

    public NflRegion getRegion() {
        return leagueRegion;
    }

    public static List<NflTeam> thoseFor(final NflRegion leagueRegion) {
        return Lists.newArrayList(Iterables.filter(Arrays.asList(values()), new Predicate<NflTeam>() {
            @Override
            public boolean apply(NflTeam input) {
                return input.getRegion() == leagueRegion;
            }
        }));
    }

    @Override
    public String toString() {
        return getName();
    }
}
