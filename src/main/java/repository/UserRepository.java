package repository;

import config.ApplicationConnection;
import entity.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {

    public void signUp(UserInfo userInfo) throws SQLException {

        String sql = "INSERT INTO user_info (user_name, national_Code, birthday , password) VALUES (  ? , ? , ? , ? )";
        PreparedStatement insertStatement = ApplicationConnection.
                getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        insertStatement.setString(1, userInfo.getUserName());
        insertStatement.setString(2, userInfo.getNationalCode());
        insertStatement.setString(3, userInfo.getBirthday());
        insertStatement.setString(4, userInfo.getPassword());


        insertStatement.execute();
        insertStatement.close();


    }

    public boolean logIn(UserInfo userInfo) throws SQLException {

        String sql = "SELECT user_name from user_info WHERE user_name=? and password=? ;";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, userInfo.getUserName());
        ps.setString(2, userInfo.getPassword());

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public int findIdByUsername(String userName) throws SQLException {
        int id;
        String sql = "SELECT id from user_info WHERE user_name=?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql);
        ps.setString(1, userName);
        ps.execute();
        ResultSet rs = ps.executeQuery();
        rs.next();

        id = rs.getInt("id");
        ps.close();
        rs.close();

        return id;
    }

    public boolean usernameContains(String username) throws SQLException {
        String sql = "SELECT user_name from user_info WHERE user_name=? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void changePassword(UserInfo userInfo) throws SQLException {
        String sql = " UPDATE user_info SET password = ?   WHERE username = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, userInfo.getPassword());
        ps.setString(2, userInfo.getUserName());
        ps.executeUpdate();
        ps.close();
    }

}
