package database;

import java.util.*;

public class Match {

    Scanner input = new Scanner(System.in);
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

        while(i < 7){
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
    public void startGame(int gameMode){
        String question1;
        String question2;
        String answer;

        Verbs activeVerb;

        Iterator<Verbs> iterator25words = list25Words.listIterator();
        while(iterator25words.hasNext()){
            activeVerb = iterator25words.next();
            question1 = activeVerb.verbEng1;
            System.out.println(question1);
            if(activeVerb.verbEng2.equals("---"))
                question2 = null;
            else{
                question2 = activeVerb.verbEng2;
                    System.out.println(question2);
                }
            System.out.println("ANSWER: ");
            answer = input.nextLine();
            if(answer.equals(activeVerb.verbPl1) || answer.equals(activeVerb.verbPl2)){
                System.out.println("GOOD!\n");
                score++;
            }
            else System.out.println("WRONG!\n");
        }

        System.out.println("RESULT : "+score+"/7");
        lex.insertResult(score);

    }






}
