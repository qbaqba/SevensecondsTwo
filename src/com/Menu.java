package com;

import database.Lexicon;
import database.Nouns;
import database.Verbs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    protected int option;
    protected int categoryID;

    protected int menuID = 0;

    int getMenuID(){
        return menuID;
    }

    Scanner input = new Scanner(System.in);
    Lexicon lex = new Lexicon();

//    LexiconMenu lexMenu = new LexiconMenu();
 //   OptionsMenu optMenu = new OptionsMenu();





    void showMenu(){
        if(menuID == 0) showMainMenu();
        if(menuID == 1) showLexiconMenu();
        if(menuID == 2) showPlayMenu();
        if(menuID == 3) showOptionsMenu();
        if(menuID == 31) addWordMenu();
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
        menuID = 3;
    }




    ////////////////////////////////////////////

    // menuID = 1
    void showLexiconMenu(){
        System.out.println("CHOOSE CATEGORY\n[1] - NOUNS\n[2] - VERBS\n[3] - ADJECTIVES \n[9] - BACK");
        System.out.print("Option: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 1){
            LinkedList<Nouns> nouns = lex.selectNouns();
            Iterator<Nouns> nounsIterator = nouns.listIterator();


            while(nounsIterator.hasNext()){
                System.out.println(nounsIterator.next().toString());
            }
            nounsIterator = nouns.listIterator();
        }
        if(option == 2) {
            LinkedList<Verbs> verbs = lex.selectVerbs();
            Iterator<Verbs> verbsIterator = verbs.listIterator();

            while(verbsIterator.hasNext()){
                System.out.println(verbsIterator.next().toString());
            }
            verbsIterator = verbs.listIterator();
        }
        if(option == 3) System.out.println("3");
        if(option == 9) menuID = 0;
    }


    // menuID = 2
    void showPlayMenu(){
        System.out.println("TestPlay");
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
    }

    // menu 31
    void addWordMenu(){
        String pl1, pl2, eng1, eng2;
        boolean additionalMeaning;

        System.out.print("Enter polish meaning: ");
        pl1 = input.nextLine();
        System.out.print("Enter english meaning: ");
        eng1 = input.nextLine();
        System.out.println("Enter additional polish meaning (press enter to skip)");
        pl2 = input.nextLine();
        System.out.println("Enter additional english meaning (press enter to skip)");
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
        showWords(categoryID);
        menuID = 3;
    }


    // menuID = 4
    void showResultsMenu(){
        System.out.println("TestResults");
    }

    void showCategoryMenu(){
        System.out.println("[1] - nouns\n[2] - verbs\n[3] - adjectives\n[9] - back");
        System.out.print("Select category: ");
        categoryID = input.nextInt();
        input.nextLine();
        if( categoryID == 9){
            menuID = 3;
            return;
        }
        else{
            categoryID = option;
        }
    }




}
