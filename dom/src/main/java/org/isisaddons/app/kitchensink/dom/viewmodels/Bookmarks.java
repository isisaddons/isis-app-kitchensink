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
package org.isisaddons.app.kitchensink.dom.viewmodels;

import org.joda.time.LocalDate;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.applib.services.bookmark.BookmarkService2;
import org.apache.isis.applib.services.factory.FactoryService;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY
)
@DomainServiceLayout(
        menuOrder = "16.1",
        named="View Models"
)
public class Bookmarks {

    private final Class<SomeViewModel> cls = SomeViewModel.class;

    public String getId() {
        return cls.getSimpleName();
    }

    public String iconName() {
        return cls.getSimpleName();
    }

    @MemberOrder(sequence = "30")
    public SomeViewModel createViewModel(
            @ParameterLayout(named = "Name")
            final String name,
            @ParameterLayout(named = "Date")
            final LocalDate date
            ) {
        SomeViewModel someViewModel = factoryService.instantiate(cls);
        someViewModel.setName(name);
        someViewModel.setDate(date);
        return someViewModel;
    }

    @MemberOrder(sequence = "20")
    public Object lookup(
            @ParameterLayout(named = "Bookmark")
            final String bookmarkStr) {

        Bookmark bookmark = new Bookmark(bookmarkStr);
        final Object obj = bookmarkService.lookup(bookmark, BookmarkService2.FieldResetPolicy.DONT_RESET);
        return obj;
    }

    @javax.inject.Inject
    protected FactoryService factoryService;

    @javax.inject.Inject
    protected BookmarkService2 bookmarkService;

    @javax.inject.Inject
    protected DomainObjectContainer container;

}
