package database;

import java.util.LinkedList;

public class Verbs {

    int idVerb;

    String verbPl1, verbPl2, verbEng1, verbEng2;


    public Verbs(int idVerb, String verbPl1, String verbPl2, String verbEng1, String verbEng2){
        this.idVerb = idVerb;
        this.verbPl1 = verbPl1;
        this.verbPl2 = verbPl2;
        this.verbEng1 = verbEng1;
        this.verbEng2 = verbEng2;
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


    String getVerbEng1(){
        return verbEng1;
    }
    String getVerbEng2(){
        return verbEng2;
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

    public void setVerbEng1(String verbEng1){
        this.verbEng1 = verbEng1;
    }
    public void setVerbEng2(String verbEng2){
        this.verbEng2 = verbEng2;
    }


    public String toString(){
        return "["+idVerb+"]\t "+verbPl1+"\t "+verbEng1+"\t "+verbPl2+"\t "+verbEng2;
    }

}
