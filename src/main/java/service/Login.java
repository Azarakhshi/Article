package service;

import entity.UserInfo;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);
    UserInfo userInfo = new UserInfo();

    private void setUserName() {
        String username;
        do {
            System.out.println("please enter the username: ");
            username = scanner.next();
            if (username.length() <= 18) {
                break;
            } else {
                System.out.println("your username is not valid! ");
            }
        } while (true);
        userInfo.setUserName(username);
    }

    private void setPassword() {
        String password;
        do {
            System.out.println("please enter the password code: ");
            password = scanner.next();
            if (password.length() <= 10 && password.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("your password code is not valid! ");
            }
        } while (true);
        userInfo.setPassword(password);
    }


    public void login() throws SQLException {
        setUserName();
        setPassword();
        UserRepository userRepository = new UserRepository();
        boolean check = userRepository.logIn(userInfo);
        if (check) {
            System.out.println("your account is exist. ");
            UserMenu userMenu = new UserMenu();
            userMenu.userMenu();
        } else {
            System.out.println("your account is not exist. ");
        }


    }
}
