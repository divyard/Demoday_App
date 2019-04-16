package com.example.divya.demoday;

public class judges {
    private String name;
    private String design;
    private String place;
    private String team;
    public judges(){

    }
    public judges(String name,String design,String place,String team)
    {
       this.name=name;
       this.design=design;
       this.place=place;
       this.team=team;
    }
    public String getName(){
        return name;
    }
    public String getDesign(){
        return design;
    }
    public String getPlace(){
        return place;
    }

    public String getTeam() {
        return team;
    }
}
