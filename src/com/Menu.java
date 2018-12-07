package com;

import database.Lexicon;
import database.Nouns;

import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    protected int option;

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
    int ik = nouns.size();


    void showMenu(){
        if(menuID == 0) showMainMenu();
        if(menuID == 1) {

                System.out.println(nouns.get(0).toString());

        }
          if(menuID == 2) showPlayMenu();
     //   if(menuID == 3) optMenu.showOptionsMenu();
       // if(menuID == 31) optMenu.showCategory();
          if(menuID == 4) showResultsMenu();
    }

    // menuID = 0
    void showMainMenu(){
        System.out.println("[1] - lexicon\n[2] - play\n[3] - options\n[4] - results"
        +"\n[0] - exit");
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
        System.out.println("[1] - choose category \n[9] - back");
        System.out.print("Option: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 9) menuID = 0;
        /*if(option == 1) showPlayMenu();
        if(option == 9) return;*/
    }

    // menuID = 2
    void showPlayMenu(){
        System.out.println("TestPlay");
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
    }




}
