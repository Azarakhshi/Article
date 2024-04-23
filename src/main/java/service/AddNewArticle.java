package service;

import entity.*;
import repository.ArticleRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class AddNewArticle {

    private final Article article = new Article();
    Scanner scanner = new Scanner(System.in);


    private void takeTitle() {
        String title;
        do {
            System.out.println("please enter the title: ");
            title = scanner.nextLine();
            if (title.length() <= 30) {
                break;
            } else {
                System.out.println("your title is not valid! ");
            }
        } while (true);
        article.setTitle(title);
    }


    private void takeBrief() {
        String brief;
        do {
            System.out.println("please enter the brief: ");
            brief = scanner.nextLine();
            if (brief.length() <= 100) {
                break;
            } else {
                System.out.println("your brief is not valid! ");
            }
        } while (true);
        article.setBrief(brief);
    }


    private void takeContent() {
        String content;
        do {
            System.out.println("please enter the content: ");
            content = scanner.nextLine();
            if (content.length() <= 1000) {
                break;
            } else {
                System.out.println("your content is not valid! ");
            }
        } while (true);
        article.setContent(content);
    }

    private void takeCreatDate() {
        String creatdate;
        do {
            System.out.println("please enter the creatdate: ");
            creatdate = scanner.next();
            if (creatdate.length() <= 9) {
                break;
            } else {
                System.out.println("your creatdate is not valid! ");
            }
        } while (true);
        article.setCreateDate(creatdate);
    }


    private void takeIsPublished() {
        boolean ispublished;
        String published;
        do {
            System.out.println("please enter the ispublished: ");
            published = scanner.next();
            if (published.length() <= 5) {
                if (published.equals("true")) {
                    ispublished = true;
                    break;
                } else if (published.equals("false")) {
                    ispublished = false;
                    break;
                }

            } else {
                System.out.println("your ispublished is not valid! ");
            }
        } while (true);
        article.setPublished(ispublished);
    }

    public void AddnewArticle(int id) throws SQLException {
        takeTitle();
        takeBrief();
        takeContent();
        takeCreatDate();
        takeIsPublished();
        article.setUserId(id);
        ArticleRepository articleRepository = new ArticleRepository();
        articleRepository.insertArticle(article);
    }


}
