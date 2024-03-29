package repository;

import DB.DBConnection;
import Dto.StudentDto;
import model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private String SELECT = "select Student.*, Class.name as nameClass from Student join Class on Student.lop_hoc_id=Class.id;";
    private String INSERT = "insert into Student(name,date_of_birth,address,phone_number,email,lop_hoc_id) values(?,?,?,?,?,?);";
    private String UPDATE = "update Student set name=?,date_of_birth=?,address=?,phone_number=?,email=?,lop_hoc_id=? where (id=?);";
    private String WHERE = "select*from Student where id=?;";
    private String DELETE = "delete from Student where id=?;";
    private String SEARCH = "select Student.*, Class.name as nameClass from Student join Class on Student.lop_hoc_id=Class.id where Student.name like ?;";

    @Override
    public List<StudentDto> findAll() throws SQLException {
        List<StudentDto> studentDto = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            LocalDate date = rs.getDate("date_of_birth").toLocalDate();
            String address = rs.getString("address");
            String phone = rs.getString("phone_number");
            String email = rs.getString("email");
            String className = rs.getString("nameClass");
            studentDto.add(new StudentDto(id, name, date, address, phone, email, className));
        }
        return studentDto;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT);
        statement.setString(1, student.getName());
        statement.setDate(2, Date.valueOf(student.getDate()));
        statement.setString(3, student.getAddress());
        statement.setString(4, student.getPhone());
        statement.setString(5, student.getEmail());
        statement.setInt(6, student.getClassId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void updateStu(Student student) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, student.getName());
        statement.setDate(2, Date.valueOf(student.getDate()));
        statement.setString(3, student.getAddress());
        statement.setString(4, student.getPhone());
        statement.setString(5, student.getEmail());
        statement.setInt(6, student.getClassId());
        statement.setInt(7, student.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Student findById(Integer id) throws SQLException {
        Student student = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(WHERE);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Integer id1 = rs.getInt("id");
            String name = rs.getString("name");
            LocalDate date = rs.getDate("date_of_birth").toLocalDate();
            String address = rs.getString("address");
            String phone = rs.getString("phone_number");
            String email = rs.getString("email");
            Integer className = rs.getInt("lop_hoc_id");
            student = new Student(id1, name, date, address, phone, email, className);
        }
        return student;
    }

    @Override
    public void RemoveStudent(Integer id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public List<StudentDto> searchName(String name) throws SQLException {
        List<StudentDto> studentDtos = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SEARCH);
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            LocalDate date = resultSet.getDate("date_of_birth").toLocalDate();
            String address = resultSet.getString("address");
            String phone = resultSet.getString("phone_number");
            String email = resultSet.getString("email");
            String className = resultSet.getString("nameClass");
            studentDtos.add(new StudentDto(id, name1, date, address, phone, email, className));
        }
        return studentDtos;
    }
}
