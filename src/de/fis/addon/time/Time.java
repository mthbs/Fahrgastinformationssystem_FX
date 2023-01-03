package de.fis.addon.time;

import java.util.ArrayList;
import java.util.List;


// source: https://www.youtube.com/watch?v=zJZ-ogqin2o
public class Time {

    private int hour;

    private int minute;

    private int second;

    public Time(final int hour, final int minute, final int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(String currentTime) {
        String[] time = currentTime.split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        second = Integer.parseInt(time[2]);
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    public String getCurrentTime(boolean seconds) {
        String min;
        String sec;
        if (minute < 10) {
            min = 0 + String.valueOf(minute);
        } else {
            min = String.valueOf(minute);
        }
        if (second < 10) {
            sec = 0 + String.valueOf(second);
        } else {
            sec = String.valueOf(second);
        }

        if (seconds) {
            return hour + ":" + min + ":" + sec;
        }
        return hour + ":" + min;
    }

    //    public static void main(String[] args) {
    //        Time currTime = new Time(new CurrentTime().currentTime());
    //        System.out.println(currTime);
    //        Time newTime = increment(new Time("14:01:00"),45);
    //        System.out.println(newTime);
    //        List<Time> timeList = incrementList(new Time("09:01:00"),new Time("14:59:52"),45);
    //        int i = 0;
    //        for(Time t : timeList){
    //            System.out.println(i+": " + t);
    //            i++;
    //        }
    //    }

    public void oneSecondPassed() {
        second++;
        if (second >= 60) {
            minute++;
            second = 0;
            if (minute >= 60) {
                hour++;
                minute = 0;
                if (hour >= 24) {
                    hour = 0;
                    System.out.println("next day");
                }
            }
        }
    }

    public List<Time> incrementList(Time startTime, Time endTime, int takt) {

        List<Time> timeList = new ArrayList<>();

        if (compareTime(startTime, endTime)) {
            Time thisTime = startTime;
            while (compareTime(thisTime, endTime)) {
                timeList.add(thisTime);
                thisTime = increment(thisTime, takt);
            }
        } else {
            new RuntimeException("Zielzeit ist kleiner als die Startzeit. Dieses Format wird nicht unterstützt");
        }
        return timeList;
    }

    public Time increment(int takt) {
        return increment(new Time(new CurrentTime().currentTime()), takt);
    }

    // set increment
    public Time increment(Time startTime, int takt) {
        int startHour = startTime.getHour();
        int endHour = startHour;
        int startMinute = startTime.getMinute();
        int endMinute = startMinute + takt;
        int startSecond = startTime.getSecond();
        int endSecond = startSecond;
        Time returnTime = null;
        if (takt <= 60) {
            if (endMinute > 59) {
                endHour++;
                endMinute -= 60;
                if (endHour > 23) {
                    endHour = 0;
                }
            }
            returnTime = new Time(endHour + ":" + endMinute + ":" + endSecond);
        } else {
            new RuntimeException("Feature is now not supported. Please select a frequence less than 60 minutes");
        }
        return returnTime;
    }

    private boolean compareTime(Time smallerTime, Time largerTime) {
        if (largerTime.getHour() > smallerTime.getHour()) {
            return true;
        } else if (largerTime.getHour() < smallerTime.getHour()) {
            return false;
        } else {
            if (largerTime.getMinute() > smallerTime.getMinute()) {
                return true;
            } else if (largerTime.getMinute() < smallerTime.getMinute()) {
                return false;
            } else {
                if (largerTime.getSecond() > smallerTime.getSecond()) {
                    return true;
                } else if (largerTime.getSecond() < smallerTime.getSecond()) {
                    return false;
                } else {
                    // equal
                    return false;
                }
            }
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
