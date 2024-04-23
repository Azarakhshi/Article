package service;

import entity.Article;
import repository.ArticleRepository;


import java.sql.SQLException;
import java.util.Arrays;

public class ShowPublishedArticles {

    public void showPublishedArticlese() throws SQLException {
        ArticleRepository articleRepository = new ArticleRepository();
        Article[] articles;
        articles = articleRepository.loadAllArticle();
        while (true) {
            if (articles.length == 0) {
                System.out.println("published article is not exist");
                break;
            } else {
                for (int i = 0; i < articles.length; i++) {

                    if (articles[i] != null) {
                        System.out.println(articles[i]);
                    }
                }
            }
        }
    }

}
