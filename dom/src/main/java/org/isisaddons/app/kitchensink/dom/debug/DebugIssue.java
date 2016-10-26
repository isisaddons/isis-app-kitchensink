package org.isisaddons.app.kitchensink.dom.debug;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.LocalDate;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;

@DomainService(nature = NatureOfService.VIEW_MENU_ONLY)
public class DebugIssue {

    public List<ActivityAttendanceSummary> listAttendanceData() {
        ArrayList<ActivityAttendanceSummary> list = new ArrayList<>();
        Calendar calendar1 = new GregorianCalendar(2015,0,29);
        ActivityAttendanceSummary temp1 = new ActivityAttendanceSummary();
        temp1.setActivityId(1000L);
        temp1.setActivityName("Activity 1");
        temp1.setRegionName("SOUTH");
        temp1.setDate(calendar1.getTime());
        temp1.setLocalDate(LocalDate.fromDateFields(calendar1.getTime()));
        list.add(temp1);

        Calendar calendar2 = new GregorianCalendar(2015,0,30);
        ActivityAttendanceSummary temp2 = new ActivityAttendanceSummary();
        temp2.setActivityId(1001L);
        temp2.setActivityName("Activity 2");
        temp2.setRegionName("WEST");
        temp2.setDate(calendar2.getTime());
        temp2.setLocalDate(LocalDate.fromDateFields(calendar2.getTime()));

        list.add(temp2);
        return list;
    }
}
