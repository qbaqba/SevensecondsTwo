package database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Match {

    Random random = new Random();

    Lexicon lex = new Lexicon();

    private int matchID;

    private int gameMode;
    private String categoryName;

    LinkedList list25Words;

    LinkedList randomList = new LinkedList<Integer>();

    private int score = 0;

    public Match(int gameMode, String categoryName){
        this.gameMode = gameMode;
        this.categoryName = categoryName;
        if(categoryName.equals("nouns")){
            list25Words = new LinkedList<Nouns>();
        }
        else if(categoryName.equals("verbs"));
            list25Words = new LinkedList<Verbs>();
    }

    public void setListVerbs(){
        int i = 0;
        int l;

        while(i < 25){
            l = random.nextInt(lex.getLastId(categoryName))+1;
            if(randomList.contains(l)){
                continue;
            }
            else{
                randomList.add(l);
                i++;
            }
        }
        Iterator<Integer> randomListIterator = randomList.listIterator();

        while(randomListIterator.hasNext()){
            list25Words.add(lex.putVerb(randomListIterator.next()));

        }


    }


    public void showList(){
        for(int i = 0; i < 25; i++){
            System.out.println(randomList.get(i));
        }
    }



    public void startGame(){
        System.out.println("test");
    }






}
