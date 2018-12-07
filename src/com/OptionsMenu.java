package com;

class OptionsMenu extends Menu {


    // menuID = 3
    void showOptionsMenu(){
        System.out.println("[1] - add words\n[2] - edit words\n[3] - delete the words"
                +"\n[9] - back");
        System.out.print("Option: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 1 || option == 2 || option == 3){
            backMenuID = menuID;
            menuID = 31;
        }
        else if(option == 9) menuID = backMenuID;
    }

    // menuID = 31
    void showCategory(){
        System.out.println("[1] - nouns\n[2] - verbs\n[3] - adjectives\n[9] - back");
        System.out.print("Select category: ");
        option = input.nextInt();
        input.nextLine();
        if(option == 1 ){
            backMenuID = menuID;
            menuID = 311;
        }
        else if(option == 9){
            menuID = backMenuID;
        }


    }
    //menuID = 311
    void showNouns(){

    }


}
