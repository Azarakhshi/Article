package service;

import entity.UserInfo;
import menu.UserMenu;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {

    Scanner scanner = new Scanner(System.in);
    UserInfo userInfo = new UserInfo();

    private void setUserName() throws SQLException {
        String username;
        do {
            System.out.println("please enter the username: ");
            username = scanner.next();
            UserRepository userRepository = new UserRepository();
            if (username.length() <= 18 && !userRepository.usernameContains(username)) {
                break;
            } else {
                System.out.println("your username is not valid! ");
            }
        } while (true);
        userInfo.setUserName(username);
    }


    private void setNationalCode() throws SQLException {
        String nationalCode;
        do {
            System.out.println("please enter the national code: ");
            nationalCode = scanner.next();
            if (nationalCode.length() <= 10 && nationalCode.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("your national code is not correct! ");
            }
        } while (true);

        System.out.println("********");
        System.out.println("your password equal to national code you can update later. ");
        System.out.println("********");
        userInfo.setNationalCode(nationalCode);
        userInfo.setPassword(nationalCode);
    }

    public void setBirthday() throws SQLException {
        String birthday;
        System.out.println("please enter your birthday: ");
        birthday = scanner.next();
        userInfo.setBirthday(birthday);
    }


    public void signUp() throws SQLException {
        setUserName();
        setNationalCode();
        setBirthday();
        UserRepository userRepository = new UserRepository();
        userRepository.signUp(userInfo);

        System.out.println("your account is created! ");

        UserMenu userMenu = new UserMenu();
        userMenu.userMenu(userInfo);

        System.out.println("********");
    }


}
