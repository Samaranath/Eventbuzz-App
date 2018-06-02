package com.example.sravyanaguboyina.eventbuzz;
/**
 * Created by sravya naguboyina on 11-04-2018.
 */

class MyData2 {
    //private final String name;
 //   private int empid;
    private String descr,date,time,semester,branch,empid;
    public MyData2(String empid, String descr, String date, String time, String semester,
                   String branch) {
        //this.id = id;
        this.empid=empid;
        this.descr = descr;
        this.date = date;
        this.time = time;
        this.semester = semester;
        this.branch = branch;
    }

    public String getdescr() {
        return descr;
    }
    public String getempid() {
        return empid;
    }
    public String getdate() {
        return date;
    }
    public String gettime() {
        return time;
    }
    public String getsem() {
        return semester;
    }
    public String getbranch() {
        return branch;
    }
    public void setempid(String empid) {
        this.empid = empid;
    }
    public void setdescr(String descr) {
        this.descr = descr;
    }
    public void setdate(String date) {
        this.date = date;
    }

    public void settime(String time) {
        this.time = time;
    }

    public void setsem(String semester) {
        this.semester = semester;
    }
    public void setbranch(String branch) {
        this.branch = branch;
    }



}
