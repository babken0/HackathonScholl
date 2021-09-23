package babken_boyakhchyan.school.dao;

import babken_boyakhchyan.school.model.Teacher;
import babken_boyakhchyan.school.util.SchoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    public void regTeacher(Teacher teacher){


        String TEACHER_INSERT_URL =  "INSERT INTO teacher" +
                " ( name, age,address,birthdate,salary,subject) VALUES " +
                "(?,?,?,?,?,?)";

        try (Connection connection = SchoolUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(TEACHER_INSERT_URL)) {

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setLong(2, teacher.getAge());
            preparedStatement.setString(3, teacher.getAddress());
            preparedStatement.setDate(4, teacher.getBirthday());
            preparedStatement.setDouble(5,teacher.getSalary());
            preparedStatement.setString(6,teacher.getSubject());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public List<Teacher> getAllTeacher(){
        List<Teacher> teachers = new ArrayList<>();
        String GET_ALL_TEACHERS_URL = "SELECT teacherId,name,age,address,birthdate," +
                "salary,subject FROM teacher";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_ALL_TEACHERS_URL);
                while (rs.next()){
                    int teacherId = rs.getInt("teacherId");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    Date birthdate = rs.getDate("birthdate");
                    double salary = rs.getDouble("salary");
                    String subject = rs.getString("subject");
                    Teacher teacher = new Teacher(name,age,address,birthdate,salary,subject);
                    teacher.setTeacherId(teacherId);
                    teachers.add(teacher);

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
        return teachers;
    }

    public Teacher getTeacherById(int teacherId){
        Teacher teacher = null;
        String GET_TEACHER_BY_ID_URL = "SELECT teacherId,name,age,address,birthdate," +
                "salary,subject FROM teacher where teacherId = '" + teacherId + "'";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_TEACHER_BY_ID_URL);
                while (rs.next()){
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    Date birthdate = rs.getDate("birthdate");
                    double salary = rs.getDouble("salary");
                    String subject = rs.getString("subject");
                    teacher = new Teacher(name,age,address,birthdate,salary,subject);
                    teacher.setTeacherId(teacherId);

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
        return teacher;
    }
}
