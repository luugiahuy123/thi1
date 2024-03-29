package controller;

import Dto.StudentDto;
import model.Clazz;
import model.Student;
import service.ClassService;
import service.IClassService;
import service.IStudentService;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "StudentController", urlPatterns = "/student")
public class StudentController extends HttpServlet {
    private IClassService iClassService = new ClassService();
    private IStudentService iStudentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ahihi");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showCreate(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    showUpdate(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "remove":
                try {
                    showRemove(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showList(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }
    }

    private void showRemove(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        iStudentService.RemoveStudent(id);
        resp.sendRedirect("/student");
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
        Integer id = Integer.valueOf(req.getParameter("id"));
        List<Clazz> clazz = iClassService.findAll();
        Student student = iStudentService.findById(id);
        req.setAttribute("student", student);
        req.setAttribute("clazz", clazz);
        dispatcher.forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        List<Clazz> clazz = iClassService.findAll();
        req.setAttribute("clazz", clazz);
        dispatcher.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        List<StudentDto> students = iStudentService.findAll();
        req.setAttribute("students", students);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createStudent(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    updateStudent(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                try {
                    searchStudent(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }
        List<StudentDto> student = iStudentService.searchName(name);
        req.setAttribute("students", student);
        req.setAttribute("name", name);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("date_of_birth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone_number");
        String email = req.getParameter("email");
        Integer className = Integer.valueOf(req.getParameter("lop_hoc_id"));
        Student student = new Student(name, date, address, phone, email, className);
        student.setId(id);
        iStudentService.updateStu(student);
        resp.sendRedirect("/student");
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("date_of_birth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone_number");
        String email = req.getParameter("email");
        Integer className = Integer.valueOf(req.getParameter("lop_hoc_id"));
        Student student = new Student(name, date, address, phone, email, className);
        iStudentService.addStudent(student);
        resp.sendRedirect("/student");
    }
}
