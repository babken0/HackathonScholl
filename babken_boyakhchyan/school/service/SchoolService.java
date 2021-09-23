package babken_boyakhchyan.school.service;

import babken_boyakhchyan.school.model.School;
import babken_boyakhchyan.school.model.SchoolClass;
import babken_boyakhchyan.school.model.Student;
import babken_boyakhchyan.school.model.Teacher;

import java.sql.Date;

import java.util.HashSet;
import java.util.Set;


public class SchoolService {

    public static Teacher createTeacher(String name,int age, String address,
                                        Date birthday, double salary, String subject) {
        return new Teacher(name,age, address, birthday, salary, subject);
    }

    public static Student createStudent(String name,int age, String address,
                                        Date birthday, double avgGrade) {
        return new Student(name,age, address, birthday, avgGrade);
    }

    public static SchoolClass createSchoolClass(int number, String name, Teacher headTeacher) {
        return new SchoolClass(number, name, headTeacher);
    }

    public static School createSchool(int number, String name, String director, int budget, int sideExpenses) {
        return new School(number, name, director, budget, sideExpenses);
    }

    public static int getAllSchoolStudentsCount(School school) {
        int count = 0;
        for (SchoolClass schoolClass : school.getClasses()) {
            count = count + schoolClass.getStudents().size();
        }
        return count;
    }

    public static void printAllTeacherTotalSalaryAndCount(School school) {
        System.out.println("Teacher count: " + getAllTeacherCount(school));
        System.out.println("Teacher total salary: " + getAllTeacherSalary(school));
    }

    private static int getAllTeacherSalary(School school) {
        int totalSalary = 0;
        Set<Teacher> teachers = getAllTeacher(school);
        for (Teacher teacher : teachers) {
            totalSalary += teacher.getSalary();
        }
        return totalSalary;
    }


    public static void addNewTeacherAndDeleteOld(SchoolClass schoolClass, Teacher newTeacher) {
        schoolClass.getTeachers().removeIf(teacher -> teacher.getSubject().equals(newTeacher.getSubject()));
        schoolClass.addTeacher(newTeacher);
    }

    public static long getAllSmartStudent(SchoolClass schoolClass) {
        return schoolClass.getStudents().stream()
                .filter(student -> student.getAvgGrade() > 8)
                .count();
    }

    public static void addStudent(SchoolClass schoolClass, Student student) {
        schoolClass.addStudent(student);
    }

    public static void removeStudentsWithGradeLess3(School school) {
        for (SchoolClass schoolClass : school.getClasses())
            schoolClass.getStudents().removeIf(student -> student.getAvgGrade() < 3);
    }

    public static void reduceSideExpenses(School school) {
        double allExpenses = getAllTeacherSalary(school) + school.getSideExpenses();
        if (school.getBudget() < allExpenses) {
            if (school.getSideExpenses() > allExpenses - school.getBudget()) {
                school.setSideExpenses(school.getSideExpenses() - (allExpenses - school.getBudget()));
            } else {
                try {
                    throw new Exception("Can't reduce side expenses");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private static int getAllTeacherCount(School school) {
        int count = 0;
        Set<Teacher> teachers = getAllTeacher(school);
        for (Teacher teacher : teachers) {
            count++;
        }
        return count;
    }


    private static Set<Teacher> getAllTeacher(School school) {
        Set<Teacher> teachers = new HashSet<>();
        int count = 0;

        for (SchoolClass schoolClass : school.getClasses())
            teachers.addAll(schoolClass.getTeachers());
        return teachers;
    }


}
