/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
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
package org.isisaddons.app.kitchensink.app.spi;

import java.util.SortedMap;

import com.google.common.collect.Maps;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.services.exceprecog.ExceptionRecognizerComposite;

@DomainService(menuOrder = "99")
public class ExceptionRecognizersForKitchensinkApp extends ExceptionRecognizerComposite {
    
    private final SortedMap<String,String> constraintNames = Maps.newTreeMap();
    
    public ExceptionRecognizersForKitchensinkApp() {
        add("unique constraint or index violation; \"NflPlayer_U1", "NFL Player with that name already exists");
    }

    private void add(final String constraintName, final String replacement) {
        add(new ExceptionRecognizerSubstituting(constraintName, replacement));
        constraintNames.put(constraintName, replacement);
    }

}