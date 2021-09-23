package babken_boyakhchyan.school.dao;

import babken_boyakhchyan.school.model.SchoolClass;
import babken_boyakhchyan.school.model.Student;
import babken_boyakhchyan.school.model.Teacher;
import babken_boyakhchyan.school.util.SchoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    public void regClass(SchoolClass schoolClass){
        String CLASS_INSERT_URL =  "INSERT INTO class" +
                " (name, number,headerTeacherId) VALUES " +
                "(?,?,?)";

        try (Connection connection = SchoolUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CLASS_INSERT_URL)) {

            preparedStatement.setString(1, schoolClass.getName());
            preparedStatement.setInt(2, schoolClass.getNumber());
            preparedStatement.setInt(3, schoolClass.getHeadTeacher().getTeacherId());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    List<SchoolClass> getAllClasses(){
        List<SchoolClass> classes = new ArrayList<>();
        String GET_ALL_CLASSES_URL = "SELECT classId, name, number,headerTeacherId FROM class";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_ALL_CLASSES_URL);
                while (rs.next()){
                    int classId = rs.getInt("classId");
                    String name = rs.getString("name");
                    int number = rs.getInt("number");
                    int headTeacherId = rs.getInt("headTeacherId");

                    Teacher headTeacher = new Teacher(new TeacherDAO().getTeacherById(headTeacherId));
                    SchoolClass schoolClass = new SchoolClass(number,name,headTeacher);
                    schoolClass.setClassId(classId);
                    classes.add(schoolClass);

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
        return classes;
    }

    SchoolClass getClassById(int classId){
        SchoolClass schoolClass = null;
        String GET_CLASS_BY_ID_URL = "SELECT classId, name, number,headerTeacherId FROM" +
                " class where classID = '" + classId + "'";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_CLASS_BY_ID_URL);
                while (rs.next()){
                    String name = rs.getString("name");
                    int number = rs.getInt("number");
                    int headTeacherId = rs.getInt("headTeacherId");
                    Teacher headTeacher = new Teacher(new TeacherDAO().getTeacherById(headTeacherId));
                    schoolClass = new SchoolClass(number,name,headTeacher);
                    schoolClass.setClassId(classId);

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
        return schoolClass;
    }

    public void deleteClass(int classId){
        String SCHOOL_DELETE_URL =  "DELETE FROM class where classId = '" + classId + "'";

        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(SCHOOL_DELETE_URL);

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

}
