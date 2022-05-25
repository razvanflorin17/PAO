package DataBase;

import Classes.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDbRepository {
    private Connection connection;

    public UserDbRepository() throws SQLException {
        this.connection = DbConnection.getInstance();
    }

    public void save(User user) throws SQLException {
        String query = "insert into user values (null, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getNume());
            preparedStatement.setString(2, user.getPrenume());
            preparedStatement.setInt(3, user.getVarsta());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();

        String query = "select * from users";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                int varsta = resultSet.getInt("varsta");
                users.add(new User(nume, prenume, varsta));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void update(int id, String nume, String prenume, int varsta) throws SQLException {
        String query = "update users set nume = ?, prenume = ?, varsta = ? where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3, varsta);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "delete from users where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
