package org.isisaddons.app.kitchensink.dom.debug;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.LocalDate;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.Editing;

@XmlRootElement
@DomainObject(editing = Editing.DISABLED)
public class ActivityAttendanceSummary implements
        Comparable<ActivityAttendanceSummary> {

    private Long activityId;
    private String activityName;
    private String regionName;

    private Date date;
    private LocalDate localDate;


    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Date getLocalDateAsDate() {
        return getLocalDate() == null ? null : getLocalDate().toDate();
    }

    public LocalDate getDateAsLocalDate() {
        return getDate() == null ? null : LocalDate.fromDateFields(getDate());
    }

    @Override
    public int compareTo(ActivityAttendanceSummary o) {
        // compare on name
        if (getActivityName() != null && o.getActivityName() != null) {
            if (!getActivityName().equals(o.getActivityName()))
                return getActivityName().compareTo(o.getActivityName());
        }
        // compare on start date
        if (getDate() != null && o.getDate() != null) {
            if (getDate().equals(o.getDate()))
                return 0;
            else if (getDate().before(o.getDate()))
                return -1;
            else
                return 1;
        }
        // compare on activity Id
        if (getActivityId() != null && o.getActivityId() != null) {
            if (getActivityId().equals(o.getActivityId()))
                return 0;
            else if (getActivityId() < o.getActivityId())
                return -1;
            else
                return 1;
        } else
            return 0;

    }

}