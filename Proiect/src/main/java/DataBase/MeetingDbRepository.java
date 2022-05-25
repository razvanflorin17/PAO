package DataBase;

import Classes.Curs;
import Classes.Meeting;
import Classes.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeetingDbRepository {
    private Connection connection;

    public MeetingDbRepository() throws SQLException {
        this.connection = DbConnection.getInstance();
    }

    public void save(Meeting meeting) throws SQLException {
        String query = "insert into meeting values (null, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, meeting.getProfesor().getNume());
            preparedStatement.setString(2, meeting.getCurs().getNume());
            preparedStatement.setInt(3, meeting.getDurata());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Meeting> getAll() throws SQLException {
        List<Meeting> meetings = new ArrayList<>();

        String query = "select * from meeting";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String profesor = resultSet.getString("profesor");
                String curs = resultSet.getString("curs");
                int durata = resultSet.getInt("durata");

                meetings.add(new Meeting(id, new Profesor(profesor), new Curs(curs), durata));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meetings;
    }

    public void update(int id, String profesor, String curs) throws SQLException {
        String query = "update meeting set profesor = ?, curs = ? where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, profesor);
            preparedStatement.setString(2, curs);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "delete from meeting where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
