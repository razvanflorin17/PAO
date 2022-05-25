package DataBase;

import Classes.Curs;
import Enums.CursTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursDbRepository {
    private Connection connection;

    public CursDbRepository() throws SQLException {
        this.connection = DbConnection.getInstance();
    }

    public void save(Curs curs) throws SQLException {
        String query = "insert into curs values (null, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, curs.getNume());
            preparedStatement.setString(2, curs.getTipCurs().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curs> getAll() throws SQLException {
        List<Curs> cursuri = new ArrayList<>();

        String query = "select * from curs";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String nume = resultSet.getString("nume");
                String tipCurs = resultSet.getString("tipcurs");

                Curs curs = new Curs(nume);

                if(tipCurs.equals("CURS_MATE"))
                    curs.setTipCurs(CursTypes.CURS_MATE);

                if(tipCurs.equals("CURS_INFO"))
                    curs.setTipCurs(CursTypes.CURS_INFO);

                if(tipCurs.equals("CURS_DEZVOLTARE"))
                    curs.setTipCurs(CursTypes.CURS_DEZVOLTARE);

                cursuri.add(curs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursuri;
    }

    public void update(int id, String nume, CursTypes tipCurs) throws SQLException {
        String query = "update curs set nume = ?, tipcurs = ? where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, tipCurs.toString());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "delete from curs where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
