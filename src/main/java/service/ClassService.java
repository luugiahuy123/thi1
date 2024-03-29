package service;

import model.Clazz;
import repository.ClassRepository;
import repository.IClassRepository;

import java.sql.SQLException;
import java.util.List;

public class ClassService implements IClassService {
    private IClassRepository iClassRepository = new ClassRepository();

    @Override
    public List<Clazz> findAll() throws SQLException {
        return iClassRepository.findAll();
    }
}
