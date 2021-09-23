package babken_boyakhchyan.school.model;

import babken_boyakhchyan.school.model.Human;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Teacher extends Human {
    private int teacherId;
    private double salary;
    private String  subject;


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", salary=" + salary +
                ", subject='" + subject + '\'' +
                '}';
    }

    public Teacher(Teacher teacher){
        super(teacher.getName(),teacher.getAge(),teacher.getAddress(),teacher.getBirthday());
        this.salary = teacher.getSalary();
        this.subject = teacher.getSubject();

    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubjectId(String subject) {
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(String name,int age, String address, Date birthday, double salary, String subject) {
        super(name,age, address, birthday);
        this.salary = salary;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return this.getName().equals(teacher.getName()) &&
                Objects.equals(subject, teacher.subject);
    }


    @Override
    public int hashCode() {
        return Objects.hash(getName(), subject);
    }
}
