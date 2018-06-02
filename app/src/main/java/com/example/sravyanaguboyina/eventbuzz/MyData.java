package com.example.sravyanaguboyina.eventbuzz;

/**
 * Created by sravya naguboyina on 26-03-2018.
 */

class MyData {
    private int id;
    private String description,name,venue,startdate,starttime,enddate,endtime;

    public MyData(String name, String description,String venue,String startdate,
                  String starttime,String enddate,String endtime) {
        //this.id = id;
        this.description = description;
        this.name=name;
        this.venue=venue;
        this.startdate=startdate;
        this.starttime=starttime;
        this.enddate=enddate;
        this.endtime=endtime;
        //this.image_link = image_link;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

  //  public void setId(int id) {
     //   this.id = id;
    //}
    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
