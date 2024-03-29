package service;

import model.Clazz;

import java.sql.SQLException;
import java.util.List;

public interface IClassService {

    List<Clazz> findAll() throws SQLException;

}
