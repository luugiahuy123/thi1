package repository;

import DB.DBConnection;
import model.Clazz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository {
    private String SELECT = "select*from Class;";

    @Override
    public List<Clazz> findAll() throws SQLException {
        List<Clazz> classes = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            classes.add(new Clazz(id, name));
        }
        statement.close();
        return classes;
    }
}
