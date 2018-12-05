package com;

import java.util.Scanner;

public class Menu {

    private int option;

    private int menuID = 0;
    private int backMenuID;

    int getMenuID(){
        return menuID;
    }

    Scanner input = new Scanner(System.in);

    void showMenu(){
        if(menuID == 0) showMainMenu();
        if(menuID == 1) showLexiconMenu();
        if(menuID == 2) showPlayMenu();
        if(menuID == 3) showOptionsMenu();
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

    // menuID = 3
    void showOptionsMenu(){
        System.out.println("[1] - add words\n[2] - edit words\n[3] - delete the words"
        +"\n[4] - create the category\n[9] - back");
        System.out.print("Option: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 4){
            System.out.println("");
        }
    }

    // menuID = 4
    void showResultsMenu(){
        System.out.println("TestResults");
    }




}
