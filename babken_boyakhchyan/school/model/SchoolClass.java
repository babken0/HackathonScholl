package babken_boyakhchyan.school.model;



import java.util.*;

public class SchoolClass {
    private int classId;
    private int number;
    private String name;
    private Teacher headTeacher;
    private List<Student> students;
    private List<Teacher> teachers;


    public SchoolClass( int number, String name, Teacher headTeacher){
        this.number = number;
        this.name = name;
        this.headTeacher = headTeacher;
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int schoolClassId) {
        this.classId = schoolClassId;
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

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacherId) {
        this.headTeacher = headTeacher;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public Student getStudentByRollNumber(int number){
        return students.get(number);
    }

    public List<Student> getStudents(){
        return students;
    }

    public List<Teacher> getTeachers(){
        return teachers;
    }

    public void addStudent(Student student){
        student.setRollNumber(students.size()+1);
        students.add(student);
        students.sort(Comparator.comparing(Human::getName));
        for (int i = 0; i < students.size() ; i++){
            students.get(i).setRollNumber(i+1);
        }
    }




}
