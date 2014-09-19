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
package org.isisaddons.app.kitchensink.dom;

import java.util.Arrays;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public enum SomeSubcategory {
    A1(SomeCategory.A),
    A2(SomeCategory.A),
    B1(SomeCategory.B),
    B2(SomeCategory.B),
    B3(SomeCategory.B),
    C1(SomeCategory.C),
    C2(SomeCategory.C),
    C3(SomeCategory.C),
    C4(SomeCategory.C),
    D1(SomeCategory.D),
    D2(SomeCategory.D),
    D3(SomeCategory.D),
    D4(SomeCategory.D),
    D5(SomeCategory.D);

    private SomeSubcategory(SomeCategory category) {
        this.category = category;
    }

    private final SomeCategory category;
    public SomeCategory getCategory() {
        return category;
    }

    public static Iterable<SomeSubcategory> under(final SomeCategory category) {
        return Iterables.filter(Arrays.asList(values()), new Predicate<SomeSubcategory>() {
            @Override
            public boolean apply(SomeSubcategory input) {
                return input.category == category;
            }
        });
    }
}
