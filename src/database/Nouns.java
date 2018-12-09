package database;

import java.util.LinkedList;
import java.util.Scanner;

public class Nouns {

    Scanner input = new Scanner(System.in);

    LinkedList<Nouns> nouns = new LinkedList<>();

    private int idNouns;
    private String plNouns;
    private String engNouns;

    public int getIdNouns(){
        return idNouns;
    }

    public void setIdNouns(int idNouns){
        this.idNouns = idNouns;
    }

    public String getPlNouns(){
        return plNouns;
    }

    public void setPlNouns(String plNouns){
        this.plNouns = plNouns;
    }

    public String getEngNouns(){
        return engNouns;
    }

    public void setEngNouns(String engNouns){
        this.engNouns = engNouns;
    }

    public Nouns(int idNouns, String plNouns, String engNouns){
        this.idNouns = idNouns;
        this.plNouns = plNouns;
        this.engNouns = engNouns;
    }

    public Nouns(){
        System.out.print("Polish word: ");
        this.plNouns = input.nextLine();
        System.out.println("English word: ");
        this.engNouns = input.nextLine();
    }

    public String toString(){
        return "["+idNouns+"] "+plNouns+" "+engNouns;
    }

}
