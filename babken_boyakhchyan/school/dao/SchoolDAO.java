package babken_boyakhchyan.school.dao;

import babken_boyakhchyan.school.model.School;
import babken_boyakhchyan.school.model.SchoolClass;
import babken_boyakhchyan.school.util.SchoolUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {

    public void regSchool(School school){
        String SCHOOL_INSERT_URL =  "INSERT INTO school" +
                " (name, number,director,budget,aditionalCost) VALUES " +
                "(?,?,?,?,?)";

        try (Connection connection = SchoolUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SCHOOL_INSERT_URL)) {

            preparedStatement.setString(1, school.getName());
            preparedStatement.setInt(2, school.getNumber());
            preparedStatement.setString(3, school.getDirector());
            preparedStatement.setDouble(4, school.getBudget());
            preparedStatement.setDouble(5, school.getSideExpenses());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public List<School> getAllSchool(){
        List<School> schools = new ArrayList<>();
        String GET_ALL_SCHOOLS_URL = "SELECT schoolId, name, number,director,budget,aditionalCost FROM school";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_ALL_SCHOOLS_URL);
                while (rs.next()){
                    int schoolId = rs.getInt("schoolId");
                    String name = rs.getString("name");
                    int number = rs.getInt("number");
                    String director = rs.getString("director");
                    double budget = rs.getDouble("budget");
                    double aditionalCost = rs.getDouble("aditionalCost");
                    School school = new School(number,name,director,budget,aditionalCost);
                    school.setSchoolId(schoolId);
                    schools.add(school);

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
        return schools;
    }

    public School getSchoolById(int schoolId){
        School school = null;
        String GET_SCHOOL_BY_ID_URL = "SELECT schoolId, name, number,director,budget,aditionalCost FROM" +
                " school where schoolId = '" + schoolId + "'";
        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(GET_SCHOOL_BY_ID_URL);
                while (rs.next()){
                    String name = rs.getString("name");
                    int number = rs.getInt("number");
                    String director = rs.getString("director");
                    double budget = rs.getDouble("budget");
                    double aditionalCost = rs.getDouble("aditionalCost");
                    school = new School(number,name,director,budget,aditionalCost);
                    school.setSchoolId(schoolId);
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
        return school;
    }

    public void deleteSchool(int schoolId){
        String SCHOOL_DELETE_URL =  "DELETE FROM school where schoolId = '" + schoolId + "';";

        try (Connection connection = SchoolUtil.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(SCHOOL_DELETE_URL);

        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

}
