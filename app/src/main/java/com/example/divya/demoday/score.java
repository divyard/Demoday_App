package com.example.divya.demoday;

public class score {
    private String jury;
    private String tename;
    private String pvcd;
    private String innovation;
    private String soln;
    private String tech;
    private String team;
    private String comment;
    public score(){

    }
    public score(String tename,String jury,String pvcd,String innovation,String soln,String tech,String team,String comment)
    {
        this.tename=tename;
        this.jury=jury;
        this.pvcd=pvcd;
        this.innovation=innovation;
        this.soln=soln;
        this.tech=tech;
        this.team=team;
        this.comment=comment;
    }
    public String getTename() {
        return tename;
    }
    public String getJury(){
        return jury;
    }



    public String getPvcd(){return pvcd;}
    public String getInnovation(){
        return innovation;
    }

    public String getSoln(){
        return soln;
    }
    public String getTech(){
        return tech;
    }
    public String getTeam(){
        return team;
    }

    public String getComment(){
        return comment;
    }
}
