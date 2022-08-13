package service;

import entity.*;
import repository.ArticleRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;


public class ShowUserArticles {
    Scanner scanner = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    public void showUserArticles(int id) throws SQLException {
        Article article = new Article();
        Article[] articles;
        articles = articleRepository.loadUserArticle(id);
        while (true) {
            if (articles.length == 0) {
                System.out.println("published article is not exist");
                break;
            } else {
                for (int i = 0; i < articles.length; i++) {
                    if (articles[i] != null) {
                        System.out.print(" ");
                        System.out.println(articles[i]);
                    }
                }
            }
            System.out.println("********");
            break;
        }
    }


}
