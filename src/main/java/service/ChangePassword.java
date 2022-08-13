package service;

import entity.UserInfo;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class ChangePassword {

    public void changePassword(UserInfo userInfo) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository();
        String newPassword;
        do {
            System.out.println("please enter the new password: ");
            newPassword = scanner.next();
            if (newPassword.length() <= 20 && newPassword.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("your national code is not correct! ");
            }
        } while (true);
        userInfo.setPassword(newPassword);
        userRepository.changePassword(userInfo);
        System.out.println("your password is changed! ");

    }
}
