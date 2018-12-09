package database;

import java.util.LinkedList;

public class Verbs {

    int idVerb;

    String verbPl1, verbPl2, verbPl3, verbEng1, verbEng2, verbEng3;


    public Verbs(int idVerb, String verbPl1, String verbPl2, String verbPl3, String verbEng1, String verbEng2, String verbEng3){
        this.idVerb = idVerb;
        this.verbPl1 = verbPl1;
        this.verbPl2 = verbPl2;
        this.verbPl3 = verbPl3;
        this.verbEng1 = verbEng1;
        this.verbEng2 = verbEng2;
        this.verbEng3 = verbEng3;
    }

    int getIdVerb(){
        return idVerb;
    }

    String getVerbPl1(){
        return verbPl1;
    }
    String getVerbPl2(){
        return verbPl2;
    }
    String getVerbPl3(){
        return verbPl3;
    }

    String getVerbEng1(){
        return verbEng1;
    }
    String getVerbEng2(){
        return verbEng2;
    }
    String getVerbEng3(){
        return verbEng3;
    }

    public void setIdVerb(int idVerb){
        this.idVerb = idVerb;
    }
    public void setVerbPl1(String verbPl1){
        this.verbPl1 = verbPl1;
    }
    public void setVerbPl2(String verbPl2){
        this.verbPl2 = verbPl2;
    }
    public void setVerbPl3(String verbPl3){
        this.verbPl3 = verbPl3;
    }
    public void setVerbEng1(String verbEng1){
        this.verbEng1 = verbEng1;
    }
    public void setVerbEng2(String verbEng2){
        this.verbEng2 = verbEng2;
    }
    public void setVerbEng3(String verbEng3){
        this.verbEng3 = verbEng3;
    }

    public String toString(){
        return "["+idVerb+"] "+verbPl1+" "+verbEng1;
    }

}
