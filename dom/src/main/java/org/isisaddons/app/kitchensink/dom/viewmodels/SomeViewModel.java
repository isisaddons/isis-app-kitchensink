package org.isisaddons.app.kitchensink.dom.viewmodels;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.applib.services.bookmark.BookmarkService;

@javax.xml.bind.annotation.XmlRootElement(name = "someViewModel")
@javax.xml.bind.annotation.XmlType(
        propOrder = {
                "name",
        }
)
@javax.xml.bind.annotation.XmlAccessorType(XmlAccessType.PROPERTY)
@org.apache.isis.applib.annotation.DomainObjectLayout()
public class SomeViewModel implements org.apache.isis.applib.services.dto.Dto {

    private String name;

    @MemberOrder(sequence = "1")
    @Title
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    @MemberOrder(sequence = "2")
    @XmlTransient
    public String getBookmark() {
        Bookmark bookmark = bookmarkService.bookmarkFor(this);
        return bookmark.toString();
    }

    @Inject
    BookmarkService bookmarkService;
}
