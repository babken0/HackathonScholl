package babken_boyakhchyan.school.model;

import java.util.ArrayList;
import java.util.List;

public class School {
    private int schoolId;
    private int number;
    private String name;
    private String directorName;
    private double budget;
    private double sideExpenses;
    private final List<SchoolClass> classes;

    public School(int number, String name, String director, double budget, double sideExpenses) {
        this.number = number;
        this.name = name;
        this.directorName = director;
        this.budget = budget;
        this.sideExpenses = sideExpenses;
        classes = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return directorName;
    }

    public void setDirector(String director) {
        this.directorName = director;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getSideExpenses() {
        return sideExpenses;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", budget=" + budget +
                ", sideExpenses=" + sideExpenses +
                '}';
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setSideExpenses(double sideExpenses) {
        this.sideExpenses = sideExpenses;
    }

    public List<SchoolClass> getClasses() {
        return classes;
    }

    public void addSchoolClass(SchoolClass schoolClass) {
        classes.add(schoolClass);
    }
}
