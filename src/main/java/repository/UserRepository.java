package repository;

import config.ApplicationConnection;
import entity.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {

    public void insert(UserInfo userInfo) throws SQLException {

        String sql = "INSERT INTO userinfo (userName, nationalCode, birthday , password) VALUES (  ? , ? , ? , ? )";
        PreparedStatement insertStatement = ApplicationConnection.
                getConnection().prepareStatement(sql);

        insertStatement.setString(1, userInfo.getUserName());
        insertStatement.setString(2, userInfo.getNationalCode());
        insertStatement.setString(3, userInfo.getBirthday());
        insertStatement.setString(4, userInfo.getPassword());

        insertStatement.execute();
        insertStatement.close();

    }

}
