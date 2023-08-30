package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    private static Connection connection = Util.getDBConnection();

    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = """
                    CREATE TABLE IF NOT EXISTS users(
                    id bigint primary key auto_increment,
                    name varchar(30),
                    lastName varchar(50),
                    age smallint
                    );
                    """;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "DROP TABLE IF EXISTS users";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO users(name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ");";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM users WHERE id=" + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM users";
            ResultSet resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                User user = new User();

                user.setId(resultset.getLong("id"));
                user.setName(resultset.getString("name"));
                user.setLastName(resultset.getString("lastName"));
                user.setAge(resultset.getByte("age"));
                users.add(user);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM users";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}