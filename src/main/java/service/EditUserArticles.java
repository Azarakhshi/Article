package service;

import entity.Article;
import repository.ArticleRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class EditUserArticles {

    Scanner scanner = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    private Article oldArticle = new Article();
    private Article newArticle = new Article();

    private void checkTitleUserArticle(int id) throws SQLException {
        String title;
        while (true) {
            System.out.println("please enter the title of Article: ");
            title = scanner.nextLine();
            if (articleRepository.ArticleContains(title, id)) {
                break;
            } else {
                System.out.println("your title is not valid! ");
            }
        }
        oldArticle.setUserId(id);
        oldArticle.setTitle(title);
        System.out.println("correct! ");
    }

    public void takeTitleNewArticle() {

        String title;
        do {
            System.out.println("please enter the new title: ");
            title = scanner.nextLine();
            if (title.length() <= 30) {
                break;
            } else {
                System.out.println("your title is not valid! ");
            }
        } while (true);
        newArticle.setTitle(title);

    }

    private void takeBriefNewArticle() {
        String brief;
        do {
            System.out.println("please enter the new brief: ");
            brief = scanner.nextLine();
            if (brief.length() <= 100) {
                break;
            } else {
                System.out.println("your brief is not valid! ");
            }
        } while (true);
        newArticle.setBrief(brief);
    }

    private void takeContentNewArticle() {
        String content;
        do {
            System.out.println("please enter the new content: ");
            content = scanner.nextLine();
            if (content.length() <= 1000) {
                break;
            } else {
                System.out.println("your content is not valid! ");
            }
        } while (true);
        newArticle.setContent(content);
    }

    private void takeCreatDateNewArticle() {
        String creatdate;
        do {
            System.out.println("please enter the new creatdate: ");
            creatdate = scanner.nextLine();
            if (creatdate.length() <= 9) {
                break;
            } else {
                System.out.println("your creatdate is not valid! ");
            }
        } while (true);
        newArticle.setCreateDate(creatdate);
    }

    private void takeIsPublished() {
        boolean ispublished;
        String publish;
        do {
            System.out.println("please enter the new ispublished: ");
            publish = scanner.nextLine();
            if (publish.length() <= 5) {
                if (publish.equals("true")) {
                    ispublished = true;
                    break;
                } else if (publish.equals("false")) {
                    ispublished = false;
                    break;
                }

            } else {
                System.out.println("your is published is not valid! ");
            }
        } while (true);
        newArticle.setPublished(ispublished);

    }

    public void editArticle(int id) throws SQLException {

        checkTitleUserArticle(id);
        takeTitleNewArticle();
        takeBriefNewArticle();
        takeContentNewArticle();
        takeCreatDateNewArticle();
        takeIsPublished();
        articleRepository.editArticle(oldArticle , newArticle);
        System.out.println("edit article is successfully! ");
    }


}
