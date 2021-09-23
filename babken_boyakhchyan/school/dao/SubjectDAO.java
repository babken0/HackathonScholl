package babken_boyakhchyan.school.dao;

import babken_boyakhchyan.school.model.Subject;
import babken_boyakhchyan.school.util.SchoolUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {
    public void regSubject(Subject subject){
        String SUBJECT_INSERT_URL =  "INSERT INTO subject" +
                " (name) VALUES " +
                "(?)";

        try (Connection connection = SchoolUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SUBJECT_INSERT_URL)) {

            preparedStatement.setString(1, subject.getName());
            
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
