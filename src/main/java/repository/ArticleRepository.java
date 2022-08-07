package repository;

import config.ApplicationConnection;
import entity.Article;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticleRepository {

    public Article[] loadAllArticle() throws SQLException {
        final String query = " select * from article where ispublished = true order by id;";
        Statement statement = ApplicationConnection.getConnection().createStatement();


        ResultSet resultSet = statement.executeQuery(query);
        Article[] articles = new Article[1000];

        int index = 0;
        while (resultSet.next()) {
            Article article = new Article();
            article.setId(resultSet.getInt("id"));
            article.setTitle(resultSet.getString("title"));
            article.setBrief(resultSet.getString("brief"));
            article.setContent(resultSet.getString("content"));
            article.setCreateDate(resultSet.getString("creatdate"));
            article.setPublished(resultSet.getBoolean("ispublished"));
            article.setUserId(resultSet.getInt("userid"));
            articles[index] = article;
            index++;

        }
        resultSet.close();
        return articles;
    }









}
