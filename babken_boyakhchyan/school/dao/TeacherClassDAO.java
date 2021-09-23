package babken_boyakhchyan.school.dao;

import babken_boyakhchyan.school.model.SchoolClass;
import babken_boyakhchyan.school.model.Teacher;
import babken_boyakhchyan.school.util.SchoolUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherClassDAO {
    public void addTeacherToClass(Teacher teacher, SchoolClass schoolClass){
        String INSERT_TEACHER_CLASS_TABLE_URL = "INSERT INTO teacherClasses" +
                " (teacherId,classId) VALUES " +
                "(?,?)";

        try (Connection connection = SchoolUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHER_CLASS_TABLE_URL)) {

            preparedStatement.setInt(1, teacher.getTeacherId());
            preparedStatement.setInt(2, schoolClass.getClassId());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
    public void deleteStudent(int studentId){
        String STUDENT_DELETE_URL =  "DELETE FROM student where student = '" + studentId + "';";

        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(STUDENT_DELETE_URL);

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
