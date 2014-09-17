package com.danhaywood.isis.kitchensink.dom;

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
