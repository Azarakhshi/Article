package service;

import java.util.Scanner;

public class UserMenu {

    public void userMenu() {

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Welcome. ");
            System.out.println("please chose fllowing menu. ");
            System.out.println("1: Show My Articles ");
            System.out.println("2: Edit My Articles ");
            System.out.println("3: Add A New Article ");
            System.out.println("4: Change Password ");
            System.out.println("5: LogOut ");

            input = scanner.next();
            if(input.equals("1")){
                //show my articles
            }else if(input.equals("2")){
                //edit my articles
            }else if(input.equals("3")){
                //add a new articles
            }else if(input.equals("4")){
                // change password
            }else{
                break;
            }

        }



    }


}
