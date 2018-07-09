package com.interlink.hotel.Reception;

import java.time.LocalDate;

public class Period {
    private LocalDate startDate;
    private LocalDate endDate;


    public Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Period(LocalDate startDate) {
        this.startDate = startDate;
        this.endDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Period{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public boolean isIntersectWith(Period period) {
        LocalDate mostLaterStart;
        LocalDate mostEarlyEnd;
        if (this.startDate.isAfter(period.getStartDate())) {
            mostLaterStart = this.startDate;
        } else {
            mostLaterStart = period.getStartDate();
        }
        if (this.endDate.isBefore(period.getEndDate())){
            mostEarlyEnd = this.endDate;
        }else{
            mostEarlyEnd = period.getEndDate();
        }
        if (mostLaterStart.isEqual(mostEarlyEnd)){
            return true;
        }
        if (mostLaterStart.isBefore(mostEarlyEnd)){
            return true;
        }
        return false;
    }
}
