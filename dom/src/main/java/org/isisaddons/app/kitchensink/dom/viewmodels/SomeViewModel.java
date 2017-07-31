package org.isisaddons.app.kitchensink.dom.viewmodels;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Strings;

import org.joda.time.LocalDate;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.applib.services.bookmark.BookmarkService;
import org.apache.isis.applib.services.hint.HintStore;
import org.apache.isis.applib.util.ReasonBuffer;
import org.apache.isis.schema.utils.jaxbadapters.JodaLocalDateStringAdapter;

import org.isisaddons.app.kitchensink.dom.text.TextObject;
import org.isisaddons.app.kitchensink.dom.text.TextObjects;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Dan on 31/07/2017.
 */
@javax.xml.bind.annotation.XmlRootElement(name = "someViewModel")
@javax.xml.bind.annotation.XmlType(
        propOrder = {
                "id",
                "name",
                "date",
                "textObject",
        }
)
@javax.xml.bind.annotation.XmlAccessorType(XmlAccessType.FIELD)
public class SomeViewModel implements org.apache.isis.applib.services.dto.Dto, HintStore.HintIdProvider {

    @MemberOrder(sequence = "1")
    @Getter @Setter
    @Property(editing = Editing.DISABLED)
    private int id;

    @Title
    @MemberOrder(sequence = "1.1")
    @Getter @Setter
    @Property(editing = Editing.ENABLED)
    private String name;

    //region > updateTextObject2 (action)
    @Mixin(method="act")
    public static class updateName{
        private final SomeViewModel someViewModel;
        public updateName(final SomeViewModel someViewModel) {
            this.someViewModel = someViewModel;
        }
        @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
        @ActionLayout(contributed= Contributed.AS_ACTION)
        public SomeViewModel act(final String newName) {
            someViewModel.setName(newName);
            return someViewModel;
        }
        public String default0Act() { return someViewModel.getName(); }

        @Inject
        TextObjects textObjects;
    }
    //endregion

    @Override
    public String hintId() {
        return "" + getId();
    }

    @XmlJavaTypeAdapter(JodaLocalDateStringAdapter.ForJaxb.class)
    @MemberOrder(sequence = "2")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private LocalDate date;

    //region > updateTextObject (action)
    @Mixin(method="act")
    public static class updateDate {
        private final SomeViewModel someViewModel;
        public updateDate(final SomeViewModel someViewModel) {
            this.someViewModel = someViewModel;
        }
        @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
        @ActionLayout(contributed= Contributed.AS_ACTION)
        public SomeViewModel act(
                @ParameterLayout(named = "Day") Integer day,
                @ParameterLayout(named = "Month") Integer month,
                @ParameterLayout(named = "Year") Integer year
        ) {
            someViewModel.setDate(new LocalDate(year, month, day));
            return someViewModel;
        }
        public Integer default0Act() {
            LocalDate date = someViewModel.getDate();
            return date != null ? date.getDayOfMonth() : null;
        }
        public Integer default1Act() {
            LocalDate date = someViewModel.getDate();
            return date != null ? date.getMonthOfYear() : null;
        }
        public Integer default2Act() {
            LocalDate date = someViewModel.getDate();
            return date != null ? date.getYear() : null;
        }

        @Inject
        TextObjects textObjects;
    }
    //endregion


    @Nullable
    @MemberOrder(sequence = "3")
    @Property(editing = Editing.DISABLED)
    @Getter @Setter
    private TextObject textObject;

    //region > updateTextObject (action)
    @Mixin(method="act")
    public static class updateTextObject {
        private final SomeViewModel someViewModel;
        public updateTextObject(final SomeViewModel someViewModel) {
            this.someViewModel = someViewModel;
        }
        @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
        @ActionLayout(contributed= Contributed.AS_ACTION)
        public SomeViewModel act(@Nullable final TextObject textObject) {
            someViewModel.setTextObject(textObject);
            return someViewModel;
        }
        public List<TextObject> choices0Act() {
            return textObjects.listAll();
        }
        public boolean hideAct() {
            return someViewModel.getName().contains("b");
        }

        @Inject
        TextObjects textObjects;
    }
    //endregion

    //region > updateTextObject2 (action)
    @Mixin(method="act")
    public static class updateTextObject2 {
        private final SomeViewModel someViewModel;
        public updateTextObject2(final SomeViewModel someViewModel) {
            this.someViewModel = someViewModel;
        }
        @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
        @ActionLayout(contributed= Contributed.AS_ACTION)
        public SomeViewModel act(@Nullable final TextObject textObject) {
            someViewModel.setTextObject(textObject);
            return someViewModel;
        }
        public List<TextObject> choices0Act() {
            return textObjects.listAll();
        }
        public boolean hideAct() {
            return someViewModel.getName().contains("a");
        }

        @Inject
        TextObjects textObjects;
    }
    //endregion

    public String getReason() {
        final ReasonBuffer buf = new ReasonBuffer();
        if (getName().contains("a")) {
            buf.append("updateTextObject2 hidden because name contains 'a'");
        }
        if (getName().contains("b")) {
            buf.append("updateTextObject hidden because name contains 'b'");
        }
        return buf.getReason();
    }

    public boolean hideReason() {
        return Strings.isNullOrEmpty(getReason());
    }

    @MemberOrder(sequence = "4")
    @Property(editing = Editing.DISABLED)
    public String getBookmark() {
        Bookmark bookmark = bookmarkService.bookmarkFor(this);
        return bookmark.toString();
    }

    @Inject
    @XmlTransient
    BookmarkService bookmarkService;

    @Inject
    @XmlTransient
    TextObjects textObjects;

}
