package chapter12;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    String url = "jdbc:h2:tcp://localhost/db;SCHEMA=ut";

    public List<String> getList() throws SQLException {
        ResultSet resultSet = getStatement().executeQuery("SELECT name FROM users");
        LinkedList<String> result = new LinkedList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString(1));
        }
        return result;
    }

    public void insert(String userName) throws SQLException {
        getStatement().executeUpdate("INSERT INTO users(name) VALUES ('" + userName + "')");
    }

    public Statement getStatement() throws SQLException {
        return DriverManager.getConnection(url, "sa", "").createStatement();
    }

}
