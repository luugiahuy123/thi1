package repository;

import model.Clazz;

import java.sql.SQLException;
import java.util.List;

public interface IClassRepository {

    List<Clazz> findAll() throws SQLException;

}
