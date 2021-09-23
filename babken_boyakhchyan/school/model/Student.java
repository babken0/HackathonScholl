package babken_boyakhchyan.school.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


public class Student extends Human{
    private int studentId;
    private int classId;
    private int rollNumber;
    private double avgGrade;


    public Student(String name,int age, String address, Date birthday, double avgGrade) {
        super(name ,age,address, birthday);
        this.avgGrade = avgGrade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || super.getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getName().equals(student.getName()) &&
                Objects.equals(rollNumber, student.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), rollNumber);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", address='" + super.getAddress() + '\'' +
                ", birthday=" + super.getBirthday() +
                "rollNumber=" + rollNumber +
                ", avgGrade=" + avgGrade +
                '}';
    }


}
