package com.example.jokerlol.acharyaone;

/**
 * Created by Joker LOL on 10/17/2015.
 */
public class ttobject {
    private String subject;
    private String starttime;
    private String endtime;

    public ttobject(String starttime, String subject, String endtime) {
        this.starttime = starttime;
        this.subject = subject;
        this.endtime = endtime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {

        this.subject = subject;
    }

    public String getStarttime() {

        return starttime;
    }

    public void setStarttime(String starttime) {

        this.starttime = starttime;
    }

    public String getEndtime() {

        return endtime;
    }

    public void setEndtime(String endtime) {

        this.endtime = endtime;
    }
}
