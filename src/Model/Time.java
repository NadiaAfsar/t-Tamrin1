package Model;

import java.util.ArrayList;

public class Time {
    private String date;
    private int hour;
    private Time start;
    private Time end;
    private int minute;
    private int[] dates;

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
    public Time(int[] dates, Time start, Time end) {
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

    public int[] getDates() {
        return dates;
    }

    public void setDates(int[] dates) {
        this.dates = dates;
    }
    @Override
    public String toString () {
        String time = "";
        if (date != null) {
            time += date + " ";
            time += getStart().getHour()+":"+getStart().getMinute();
        }
        else {
            for (int i = 0; i < dates.length; i++) {
                if (dates[i] == 1) {
                    time +="Saturday ";
                }
                else if (dates[i] == 2) {
                    time +="Sunday ";
                }
                else if (dates[i] == 3) {
                    time +="Monday ";
                }
                else if (dates[i] == 4) {
                    time +="Tuesday ";
                }
                else if (dates[i] == 5) {
                    time +="Wednesday ";
                }
                else if (dates[i] == 6) {
                    time +="Thursday ";
                }
                else if (dates[i] == 7) {
                    time +="Friday ";
                }
                if (i != dates.length - 1) {
                    time +="& ";
                }
            }
            time += getStart().getHour()+":"+getStart().getMinute()+" - "+getEnd().getHour()+":"+getEnd().getMinute();
        }
        return time;
    }
}
