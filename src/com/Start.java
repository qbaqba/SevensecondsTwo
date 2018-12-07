package com;

import database.Lexicon;

public class Start {
    public static void main(String[] args){


        Menu menu = new Menu();


        do {
            menu.showMenu();
        }while (menu.getMenuID() != -1);

        if(menu.getMenuID() == -1)
            System.exit(0);
    }


}
