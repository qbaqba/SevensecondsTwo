package com;

import database.Lexicon;
import database.Match;
import database.Nouns;
import database.Verbs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    private int option;

    private int categoryID;
    private String categoryName;

    private int menuID = 0;

    int getMenuID(){
        return menuID;
    }

    Scanner input = new Scanner(System.in);
    Lexicon lex = new Lexicon();

    Match match = new Match(1,"nouns");

//    LexiconMenu lexMenu = new LexiconMenu();
 //   OptionsMenu optMenu = new OptionsMenu();



    void switchCategoryIdName(int categoryID){
        if(categoryID == 1)categoryName = "nouns";
        else if(categoryID == 2)categoryName = "verbs";
        else if(categoryID == 3)categoryName = "adjectives";
    }

    void showMenu(){
        if(menuID == 0) showMainMenu();
        if(menuID == 1) showLexiconMenu();
        if(menuID == 2) showPlayMenu();
        if(menuID == 3) showOptionsMenu();
        if(menuID == 31) addWordMenu();
        if(menuID == 32) editWordMenu();
        if(menuID == 33) deleteWordMenu();
        if(menuID == 4) showResultsMenu();
    }

    // menuID = 0
    void showMainMenu(){

        System.out.println("[1] - LEXICON\n[2] - PLAY\n[3] - OPTIONS\n[4] - RESULTS"
        +"\n[0] - EXIT");
        option = input.nextInt();
        input.nextLine();
        if(option == 1) menuID = 1;
        if(option == 2) menuID = 2;
        if(option == 3) menuID = 3;
        if(option == 4) menuID = 4;
        if(option == 0) menuID = -1;
    }


    //////////////////////TEST//////////////////
    public void showWords(int i){
        if(i == 1){
            LinkedList<Nouns> nouns = lex.selectNouns();
            Iterator<Nouns> nounsIterator = nouns.listIterator();
            System.out.println("");

            while(nounsIterator.hasNext()){
                System.out.println(nounsIterator.next().toString());
            }
            nounsIterator = nouns.listIterator();
        }
        else if(i == 2){
            LinkedList<Verbs> verbs = lex.selectVerbs();
            Iterator<Verbs> verbsIterator = verbs.listIterator();

            while(verbsIterator.hasNext()){
                System.out.println(verbsIterator.next().toString());
            }
            verbsIterator = verbs.listIterator();
        }
    }




    ////////////////////////////////////////////

    // menuID = 1
    void showLexiconMenu(){
        System.out.println("CHOOSE CATEGORY\n[1] - NOUNS\n[2] - VERBS\n[3] - ADJECTIVES \n[9] - BACK");
        System.out.print("Option: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 1 || option == 2 || option == 3){
            showWords(option);
        }
        else if(option == 9) menuID = 0;
    }


    // menuID = 2
    void showPlayMenu(){
        int gameMode;

        System.out.println("[1] - NOUNS\n[2] - VERBS\n[3] - ADJECTIVES\n[9] - BACK");
        System.out.print("SELECT CATEGORY: ");
        categoryID = input.nextInt();
        input.nextLine();
        switchCategoryIdName(categoryID);
        if(categoryID == 9){
            menuID = 0;
            return;
        }
        else {
            System.out.println("* CHOOSE GAME MODE *");
            System.out.println("[1] - ENGLISH\n[2] - POLISH\n[9] - BACK");
            gameMode = input.nextInt();
            input.nextLine();
            if (gameMode == 9) {
                menuID = 2;
                return;
            }
            else{
                Match match = new Match(gameMode, "verbs");
                match.setListVerbs();
                match.startGame(gameMode);
            }
        }

    }

    // menuID = 3

    void showOptionsMenu(){
        System.out.println("[1] - ADD WORD\n[2] - EDIT WORD\n[3] - DELETE WORD\n[9] - BACK");
        option = input.nextInt();
        input.nextLine();
        if(option == 9) menuID = 0;
        else if(option == 1 || option == 2 || option == 3){
            System.out.println("[1] - NOUNS\n[2] - VERBS\n[3] - ADJECTIVES\n[9] - BACK");
            System.out.print("SELECT CATEGORY: ");
            categoryID = input.nextInt();
            input.nextLine();
            switchCategoryIdName(categoryID);
            if(categoryID == 9){
                return;
            }
        }
        if(option == 1){
            menuID = 31;
        }
        else if(option == 2){
            menuID = 32;
        }
        else if(option == 3){
            menuID = 33;
        }
    }

    // menu 31
    void addWordMenu(){
        String pl1, pl2, eng1, eng2;
        boolean additionalMeaning;

        System.out.print("Enter polish meaning: ");
        pl1 = input.nextLine();
        System.out.print("Enter english meaning: ");
        eng1 = input.nextLine();
        System.out.print("Enter additional polish meaning (press enter to skip)");
        pl2 = input.nextLine();
        System.out.print("Enter additional english meaning (press enter to skip)");
        eng2 = input.nextLine();
        if(pl2.length() == 0){
            pl2 = "---";
        }
        if(eng2.length() == 0){
            eng2 = "---";
        }
        if(categoryID == 1)
        lex.insertNoun(pl1, eng1);
        if(categoryID == 2)
            lex.insertVerb(pl1, pl2, eng1, eng2);

        menuID = 3;
    }

    // menuID = 32
    void editWordMenu(){
        int recordID;
        String pl1, pl2, eng1, eng2;

        showWords(categoryID);
        do {
            System.out.print("Enter the word ID, that you want edit: ");
            System.out.println("[0] - BACK");
            recordID = input.nextInt();
            input.nextLine();
            if(recordID < 0 || recordID > lex.getLastId(categoryName))
                System.out.println("WRONG ID..");
        }while (recordID < 0 || recordID > lex.getLastId(categoryName));
        if(recordID == 0){
            menuID = 3;
            return;
        }
        System.out.print("Enter polish meaning: ");
        pl1 = input.nextLine();
        System.out.print("Enter english meaning: ");
        eng1 = input.nextLine();
        System.out.print("Enter additional polish meaning (press enter to skip)");
        pl2 = input.nextLine();
        System.out.print("Enter additional english meaning (press enter to skip)");
        eng2 = input.nextLine();
        if(pl2.length() == 0){
            pl2 = "---";
        }
        if(eng2.length() == 0){
            eng2 = "---";
        }
        lex.updateRecord(recordID,categoryName,pl1,pl2, eng1,eng2);
        menuID = 3;
    }

    void deleteWordMenu(){
        int recordID;

        showWords(categoryID);
        do {
            System.out.print("Enter the word ID, that you want delete: ");
            System.out.println("[0] - BACK");
            recordID = input.nextInt();
            input.nextLine();
            if(recordID < 0 || recordID > lex.getLastId(categoryName))
                System.out.println("WRONG ID..");
        }while (recordID < 0 || recordID > lex.getLastId(categoryName));
        if(recordID == 0){
            menuID = 3;
            return;
        }
        lex.deleteRecord(recordID,categoryName);
        lex.resetID(categoryName);
    }


    // menuID = 4
    void showResultsMenu(){
        System.out.println("[1] - SHOW RESULTS\n[9] - BACK");
        option = input.nextInt();
        input.nextLine();
        if(option == 9){
            menuID = 0;
            return;
        }
        else if(option == 1){
            lex.showResults();
            System.out.println("[9] - BACK");
            option = input.nextInt();
            input.nextLine();
            if(option == 9){
                menuID = 0;
            }
        }
    }
}
