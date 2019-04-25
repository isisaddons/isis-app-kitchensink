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
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum NflRegion {
    AFC_NORTH(NflLeague.AFC, "North"),
    AFC_EAST(NflLeague.AFC, "East"),
    AFC_SOUTH(NflLeague.AFC, "South"),
    AFC_WEST(NflLeague.AFC, "West"),
    NFC_NORTH(NflLeague.NFC, "North"),
    NFC_EAST(NflLeague.NFC, "East"),
    NFC_SOUTH(NflLeague.NFC, "South"),
    NFC_WEST(NflLeague.NFC, "West");

    @Getter
    private final NflLeague league;
    @Getter
    private final String region;

    public static List<NflRegion> thoseFor(final NflLeague league) {
        return Arrays.stream(values())
                .filter(input -> input.getLeague() == league)
                .collect(Collectors.toList());
    }
}
