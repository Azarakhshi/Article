package service;

import entity.*;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class SignUp {

    Scanner scanner = new Scanner(System.in);

    public void signUp() throws SQLException {
        UserInfo userInfo = new UserInfo();
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

        UserRepository userRepository = new UserRepository();
        userRepository.insert(userInfo);

        System.out.println("your account is created! ");




    }

}
