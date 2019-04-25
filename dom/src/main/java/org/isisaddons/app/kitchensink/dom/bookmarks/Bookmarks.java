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
package org.isisaddons.app.kitchensink.dom.bookmarks;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.applib.services.bookmark.BookmarkService2;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY
)
public class Bookmarks {

    @MemberOrder(sequence = "20")
    public Object lookup(
            @ParameterLayout(named = "Bookmark")
            final String bookmarkStr) {

        Bookmark bookmark = new Bookmark(bookmarkStr);
        final Object obj = bookmarkService.lookup(bookmark, BookmarkService2.FieldResetPolicy.DONT_RESET);
        return obj;
    }

    @javax.inject.Inject
    protected BookmarkService2 bookmarkService;


}
