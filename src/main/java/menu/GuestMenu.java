package menu;

import config.ApplicationConnection;
import service.Login;
import service.ShowPublishedArticles;
import service.SignUp;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Objects;


public class GuestMenu {

    public void showGuestMenu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        String input;

        label:
        while (true) {
            System.out.println("please chose fllowing menu. ");
            System.out.println("1: Sign up");
            System.out.println("2: Login");
            System.out.println("3: Show All articles that have been published");
            System.out.println("4: Exit");

            input = scanner.next();
            switch (input) {
                case "1":
                    SignUp signUp = new SignUp();
                    signUp.signUp();
                    break;
                case "2":
                    Login login = new Login();
                    login.login();
                    break;
                case "3":
                    ShowPublishedArticles showPublishedArticles = new ShowPublishedArticles();
                    showPublishedArticles.showPublishedArticlese();
                    break;
                case "4":
                    break label;
                default:
                    System.out.println("Eror! please try again. ");
                    break;
            }

        }


    }
}

