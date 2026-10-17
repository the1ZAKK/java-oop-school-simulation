package report;

/**
 * A class roster holding a teacher and an array of student references.
 * The original name is retained; this is not java.lang.Class.
 */
public class Class {
    private String className;
    private Teacher teacher;
    private Student[] students;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
