package de.fis.addon.time;

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
}
