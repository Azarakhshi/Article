package repository;

import config.ApplicationConnection;
import entity.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {

    public void signUp(UserInfo userInfo) throws SQLException {

        String sql = "INSERT INTO userinfo (userName, nationalCode, birthday , password) VALUES (  ? , ? , ? , ? )";
        PreparedStatement insertStatement = ApplicationConnection.
                getConnection().prepareStatement(sql);

        insertStatement.setString(1, userInfo.getUserName());
        insertStatement.setString(2, userInfo.getNationalCode());
        insertStatement.setString(3, userInfo.getBirthday());
        insertStatement.setString(4, userInfo.getPassword());

        insertStatement.execute();
        insertStatement.close();

        insertStatement.execute();
        ResultSet generatedIds = insertStatement.getGeneratedKeys();
        generatedIds.next();
        int id = generatedIds.getInt("id");
        userInfo.setId(id);
        insertStatement.close();
        generatedIds.close();


    }

    public boolean logIn(UserInfo userInfo) throws SQLException {

        String sql = "SELECT username from userInfo WHERE username=? and password=? ;";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, userInfo.getUserName());
        ps.setString(2, userInfo.getPassword());

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }



}
