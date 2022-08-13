package menu;

import entity.UserInfo;
import repository.UserRepository;
import service.AddNewArticle;
import service.ChangePassword;
import service.EditUserArticles;
import service.ShowUserArticles;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {

    public void userMenu(UserInfo userInfo) throws SQLException {


        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            UserRepository userRepository = new UserRepository();
            int id = userRepository.findIdByUsername(userInfo.getUserName());
            System.out.println("Welcome. ");
            System.out.println("please chose fllowing menu. ");
            System.out.println("1: Show My Articles ");
            System.out.println("2: Edit My Articles ");
            System.out.println("3: Add A New Article ");
            System.out.println("4: Change Password ");
            System.out.println("5: LogOut ");

            input = scanner.next();
            if(input.equals("1")){
                ShowUserArticles showUserArticles = new ShowUserArticles();
                showUserArticles.showUserArticles(id);
            }else if(input.equals("2")){
                EditUserArticles editUserArticles = new EditUserArticles();
                editUserArticles.editArticle(id);
            }else if(input.equals("3")){
                AddNewArticle addNewArticle = new AddNewArticle();
                addNewArticle.AddnewArticle(id);
            }else if(input.equals("4")){
                ChangePassword changePassword = new ChangePassword();
                changePassword.changePassword(userInfo);
            }else{
                break;
            }

        }



    }


}
