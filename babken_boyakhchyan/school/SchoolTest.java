package babken_boyakhchyan.school;



import babken_boyakhchyan.school.dao.SchoolDAO;
import babken_boyakhchyan.school.dao.StudentDAO;
import babken_boyakhchyan.school.dao.TeacherDAO;
import babken_boyakhchyan.school.model.School;
import babken_boyakhchyan.school.model.SchoolClass;
import babken_boyakhchyan.school.model.Student;
import babken_boyakhchyan.school.model.Teacher;
import babken_boyakhchyan.school.service.SchoolService;

import java.sql.Date;
import java.time.LocalDate;

public class SchoolTest {
    public static void main(String[] args) {
        Student student = new Student("NL",2,"address", Date.valueOf("2019-06-25"),15.4);
        School school = new School(10,"N10","Karen Avdalyan",1550000,50000);
        SchoolDAO schoolDAO = new SchoolDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        //schoolDAO.regSchool(school);
//        System.out.println(schoolDAO.getAllSchool());

//        School school = SchoolService.createSchool(10, "School_10",
//                "FullName", 800_000, 600_000);
//
        Teacher headTeacher1 = SchoolService.createTeacher("testN",15, "addressTest",
                Date.valueOf("1985-10-15"), 100_000, "English");
//

        teacherDAO.regTeacher(headTeacher1);
        System.out.println(teacherDAO.getAllTeacher());
        SchoolClass schoolClass = SchoolService.createSchoolClass(5, "a", headTeacher1);
//        SchoolClass schoolClass1 = SchoolService.createSchoolClass(3, "b", headTeacher1);
//
//
//        Teacher mathTeacher = SchoolService.createTeacher("testN", "testL", "addressTest",
//                LocalDate.of(1985, 10, 15), 100_000, "Math");
//        Teacher historyTeacher = SchoolService.createTeacher("testN", "testL", "addressTest",
//                LocalDate.of(1985, 10, 15), 100_000, "History");
//        Teacher geographyTeacher = SchoolService.createTeacher("testN", "testL", "addressTest",
//                LocalDate.of(1985, 10, 15), 100_000, "Geography");
//        Teacher newGeographyTeacher = SchoolService.createTeacher("NewTeacher", "testL", "addressTest",
//                LocalDate.of(1985, 10, 15), 150_000, "Geography");

//
//        Student student1 = new Student("Arman", "Avetisyan", "addressTest",
//                LocalDate.of(1985, 10, 15), 5);
//        Student student2 = new Student("Grigor", "Baghdasaryan", "addressTest",
//                LocalDate.of(1985, 10, 15), 9);
//        Student student3 = new Student("Ani", "Abgaryan", "addressTest",
//                LocalDate.of(1985, 10, 15), 1);

//        schoolClass.addStudent(student2);
//        schoolClass.addStudent(student1);
//
//        schoolClass1.addStudent(student1);
//        schoolClass1.addStudent(student2);
//
//        schoolClass.addTeacher(mathTeacher);
//        schoolClass.addTeacher(geographyTeacher);
//        schoolClass.addTeacher(historyTeacher);
//        schoolClass1.addTeacher(mathTeacher);
//        school.addSchoolClass(schoolClass);
//        school.addSchoolClass(schoolClass1);
//        //1
//        System.out.println(SchoolService.getAllSchoolStudentsCount(school));
//        //2
//        SchoolService.printAllTeacherTotalSalaryAndCount(school);
//        //3
//        SchoolService.addNewTeacherAndDeleteOld(schoolClass, newGeographyTeacher);
//        SchoolService.printAllTeacherTotalSalaryAndCount(school);
//        //4
//        System.out.println("Smart student count:" + SchoolService.getAllSmartStudent(schoolClass));
//        //5
//        System.out.print("Before add: ");
//        for (Student student : schoolClass.getStudents())
//            System.out.println(student);
//        SchoolService.addStudent(schoolClass, student3);
//        System.out.print("After add: ");
//        for (Student student : schoolClass.getStudents())
//            System.out.println(student);
//        //6
//        System.out.println("Before remove " + SchoolService.getAllSchoolStudentsCount(school));
//        SchoolService.removeStudentsWithGradeLess3(school);
//        System.out.println("After remove " + SchoolService.getAllSchoolStudentsCount(school));
//        //7
//        System.out.println("Before reduce: " + school.getSideExpenses());
//        SchoolService.reduceSideExpenses(school);
//        System.out.println("After reduce: " + school.getSideExpenses());
    }
}
