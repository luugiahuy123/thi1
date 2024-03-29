package repository;

import Dto.StudentDto;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepository {
    List<StudentDto> findAll() throws SQLException;

    void addStudent(Student student) throws SQLException;

    void updateStu(Student student) throws SQLException;

    Student findById(Integer id) throws SQLException;

    void RemoveStudent(Integer id) throws SQLException;

    List<StudentDto> searchName(String name) throws SQLException;

}
