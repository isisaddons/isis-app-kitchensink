package org.isisaddons.app.kitchensink.dom.viewmodels;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.LocalDate;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.applib.services.bookmark.BookmarkService;
import org.apache.isis.schema.utils.jaxbadapters.JodaLocalDateStringAdapter;

@javax.xml.bind.annotation.XmlRootElement(name = "someViewModel")
@javax.xml.bind.annotation.XmlType(
        propOrder = {
                "name",
                "date",
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

    private LocalDate date;

    @XmlJavaTypeAdapter(JodaLocalDateStringAdapter.ForJaxb.class)
    @MemberOrder(sequence = "2")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }


    @MemberOrder(sequence = "3")
    @XmlTransient
    public String getBookmark() {
        Bookmark bookmark = bookmarkService.bookmarkFor(this);
        return bookmark.toString();
    }

    @Inject
    @XmlTransient
    BookmarkService bookmarkService;
}
