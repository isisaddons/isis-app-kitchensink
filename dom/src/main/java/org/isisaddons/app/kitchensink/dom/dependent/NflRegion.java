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

public enum NflRegion {
    AFC_NORTH(NflLeague.AFC, "North"),
    AFC_EAST(NflLeague.AFC, "East"),
    AFC_SOUTH(NflLeague.AFC, "South"),
    AFC_WEST(NflLeague.AFC, "West"),
    NFC_NORTH(NflLeague.NFC, "North"),
    NFC_EAST(NflLeague.NFC, "East"),
    NFC_SOUTH(NflLeague.NFC, "South"),
    NFC_WEST(NflLeague.NFC, "West");

    private final NflLeague league;
    private final String region;

    NflRegion(NflLeague league, String region) {
        this.league = league;
        this.region = region;
    }

    public NflLeague getLeague() {
        return league;
    }

    public String getRegion() {
        return region;
    }

    public static List<NflRegion> thoseFor(final NflLeague league) {
        return Lists.newArrayList(Iterables.filter(Arrays.asList(values()), new Predicate<NflRegion>() {
            @Override
            public boolean apply(NflRegion input) {
                return input.getLeague() == league;
            }
        }));
    }
}
