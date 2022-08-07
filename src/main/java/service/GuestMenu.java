package service;

import config.ApplicationConnection;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Objects;


public class GuestMenu {

    public void showGuestMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("please chose fllowing menu. ");
            System.out.println("1: Sign up");
            System.out.println("2: Login");
            System.out.println("3: Show All articles that have been published");
            System.out.println("4: Exit");

            input = scanner.next();
            if (input.equals("1")) {
                SignUp signUp = new SignUp();
                signUp.signUp();
            } else if (input.equals("2")) {
                Login login = new Login();
                login.login();
            } else if (input.equals("3")) {
                //show articles
            } else if (input.equals("4")) {
                break;
            } else {
                System.out.println("Eror! please try again. ");
            }

        }

    }
}

