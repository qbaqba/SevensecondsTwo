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
    protected int backMenuID;


    int getMenuID(){
        return menuID;
    }

    Scanner input = new Scanner(System.in);
    Lexicon lex = new Lexicon();

//    LexiconMenu lexMenu = new LexiconMenu();
 //   OptionsMenu optMenu = new OptionsMenu();

    LinkedList<Nouns> nouns = lex.selectNouns();
    Iterator<Nouns> nounsIterator = nouns.listIterator();

    LinkedList<Verbs> verbs = lex.selectVerbs();
    Iterator<Verbs> verbsIterator = verbs.listIterator();


    void showMenu(){
        if(menuID == 0) showMainMenu();
        if(menuID == 1) showLexiconMenu();
          if(menuID == 2) showPlayMenu();
     //   if(menuID == 3) optMenu.showOptionsMenu();
       // if(menuID == 31) optMenu.showCategory();
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

    // menuID = 1
    void showLexiconMenu(){
        System.out.println("CHOOSE CATEGORY\n[1] - NOUNS\n[2] - VERBS\n[3] - ADJECTIVES \n[9] - BACK");
        System.out.print("Option: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 1){
            while(nounsIterator.hasNext()){
                System.out.println(nounsIterator.next().toString());
            }
            nounsIterator = nouns.listIterator();
        }
        if(option == 2) {
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
        if(option == 1 || option == 2 || option == 3){
            showCategoryMenu();
        }
    }

    // menuID = 4
    void showResultsMenu(){
        System.out.println("TestResults");
    }

    void showCategoryMenu(){
        System.out.println("[1] - nouns\n[2] - verbs\n[3] - adjectives\n[9] - back");
        System.out.print("Select category: ");
        option = input.nextInt();
        input.nextLine();
        if( option == 9){
            menuID = 3;
            return;
        }
        else{
            categoryID = option;
        }
    }




}
