package service;

import entity.UserInfo;
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
            if (username.length() <= 18) {
                break;
            } else {
                System.out.println("your username is not correct! ");
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
        do {
            System.out.println("please enter your birthday: ");
            birthday = scanner.next();
            if (birthday.length() <= 9 && birthday.matches("[0-9[-]]+")) {
                break;
            } else {
                System.out.println("your birthday is not correct! ");
            }
        } while (true);
        userInfo.setBirthday(birthday);
    }


    public void signUp() throws SQLException {
        setUserName();
        setUserName();
        setBirthday();
        UserRepository userRepository = new UserRepository();
        userRepository.signUp(userInfo);

        System.out.println("your account is created! ");

        UserMenu userMenu = new UserMenu();
        userMenu.userMenu();

        System.out.println("********");
    }


}
