package service;

import Dto.StudentDto;
import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository iStudentRepository = new StudentRepository();

    @Override
    public List<StudentDto> findAll() throws SQLException {
        return iStudentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        iStudentRepository.addStudent(student);
    }

    @Override
    public void updateStu(Student student) throws SQLException {
        iStudentRepository.updateStu(student);
    }

    @Override
    public Student findById(Integer id) throws SQLException {
        return iStudentRepository.findById(id);
    }

    @Override
    public void RemoveStudent(Integer id) throws SQLException {
        iStudentRepository.RemoveStudent(id);
    }

    @Override
    public List<StudentDto> searchName(String name) throws SQLException {
        return iStudentRepository.searchName(name);
    }
}

