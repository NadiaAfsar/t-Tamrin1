package Model;

import java.util.ArrayList;

public class Time {
    private String date;
    private int hour;
    private Time start;
    private Time end;
    private int minute;
    private String[] dates;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    //exam
    public Time(String date, Time start) {
        this.date = date;
        this.start = start;
    }
    //class
    public Time(String[] dates, Time start, Time end) {
        this.dates = dates;
        this.start = start;
        this.end = end;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String[] getDates() {
        return dates;
    }

    public void setDates(String[] dates) {
        this.dates = dates;
    }
}
