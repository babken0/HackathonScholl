package babken_boyakhchyan.school.dao;

import babken_boyakhchyan.school.model.SchoolClass;
import babken_boyakhchyan.school.model.Student;
import babken_boyakhchyan.school.model.Teacher;
import babken_boyakhchyan.school.util.SchoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void regStudent(Student student, SchoolClass schoolClass) {
        String STUDENT_INSERT_SQL = "INSERT INTO student" +
                " (classId,regNumber, name, age,address,birthdate,GPA) VALUES " +
                "(?,?,?,?,?,?,?)";

        try (Connection connection = SchoolUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(STUDENT_INSERT_SQL)) {

            preparedStatement.setInt(1, schoolClass.getClassId());
            preparedStatement.setInt(2, student.getRollNumber());
            preparedStatement.setString(3, student.getName());
            preparedStatement.setLong(4, student.getAge());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setDate(6, student.getBirthday());
            preparedStatement.setDouble(7,student.getAvgGrade());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        String GET_ALL_STUDENTS_URL = "SELECT studentId,classId,regNumber" +
                ",name,age,address,birthdate,gpa FROM student";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_ALL_STUDENTS_URL);
                while (rs.next()){
                    int studentId = rs.getInt("studentId");
                    int classId = rs.getInt("classId");
                    int regNumber = rs.getInt("regNumber");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    Date birthdate = rs.getDate("birthdate");
                    long gpa = rs.getLong("gpa");
                    Student student = new Student(name,age,address,birthdate,gpa);
                    student.setStudentId(studentId);
                    student.setRollNumber(regNumber);
                    student.setClassId(classId);
                    students.add(student);

            }
        } catch (SQLException ex){
                ex.printStackTrace();
                if (rs!= null){
                    rs.close();
                }
            }
    } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return students;
    }

    Student getStudentById(int studentID){
        Student student = null;
        String GET_STUDENT_BY_ID_URL = "SELECT studentId,classId,regNumber" +
                " ,name,age,address,birthdate,gpa FROM student where studentId = '" + studentID + "'";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_STUDENT_BY_ID_URL);
                while (rs.next()){
                    int studentId = rs.getInt("studentId");
                    int classId = rs.getInt("classId");
                    int regNumber = rs.getInt("regNumber");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    Date birthdate = rs.getDate("birthdate");
                    long gpa = rs.getLong("gpa");
                    student = new Student(name,age,address,birthdate,gpa);
                    student.setClassId(classId);
                    student.setRollNumber(regNumber);
                    student.setStudentId(studentId);

                }
            } catch (SQLException ex){
                ex.printStackTrace();
                if (rs!= null){
                    rs.close();
                }
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return student;
    }

}
