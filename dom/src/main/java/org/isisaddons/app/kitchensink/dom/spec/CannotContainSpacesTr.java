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
package org.isisaddons.app.kitchensink.dom.spec;

import org.apache.isis.applib.services.i18n.TranslatableString;
import org.apache.isis.applib.spec.AbstractSpecification2;

public class CannotContainSpacesTr extends AbstractSpecification2<String> {

    public CannotContainSpacesTr() {
        super(Nullability.IGNORE_IF_NULL, TypeChecking.ENSURE_CORRECT_TYPE);
    }

    @Override
    public TranslatableString satisfiesTranslatableSafely(final String obj) {
        return TranslatableString.tr(
                obj != null && obj.contains(" ")
                        ? "Proposed value '{proposed}' cannot contain spaces!"
                        : null,
                "proposed", obj);
    }
}
