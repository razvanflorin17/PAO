package DataBase;

import Classes.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDbRepository {
    private Connection connection;

    public ProfesorDbRepository() throws SQLException {
        this.connection = DbConnection.getInstance();
    }

    public void save(Profesor profesor) throws SQLException {
        String query = "insert into profesor values (null, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, profesor.getNume());
            preparedStatement.setString(2, profesor.getPrenume());
            preparedStatement.setInt(3, profesor.getVarsta());
            preparedStatement.setInt(4, profesor.getRating());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Profesor> getAll() throws SQLException {
        List<Profesor> profesors = new ArrayList<>();

        String query = "select * from profesor";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                int varsta = resultSet.getInt("varsta");
                int rating = resultSet.getInt("rating");
                profesors.add(new Profesor(nume, prenume, varsta, rating));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profesors;
    }

    public void update(int id, String nume, String prenume, int varsta, int rating) throws SQLException {
        String query = "update profesor set nume = ?, prenume = ?, varsta = ?, rating = ? where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3, varsta);
            preparedStatement.setInt(4, rating);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "delete from profesor where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
