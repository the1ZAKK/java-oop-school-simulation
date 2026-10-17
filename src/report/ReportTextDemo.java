package report;

/**
 * The report's inline TEST example under a new entry-point name.
 * This class was added during reconstruction to preserve both report variants.
 */
public class ReportTextDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("doae el karzaoui");
        student.setAge(18);
        student.setAddress("Dalian");
        student.setStudentID(12345);

        Teacher teacher = new Teacher();
        teacher.setName("Mr. Charles");
        teacher.setAge(35);
        teacher.setAddress("Dalian");
        teacher.setTeacherID(54321);

        Class myClass = new Class();
        myClass.setClassName("PE teacher");
        myClass.setTeacher(teacher);
        myClass.setStudents(new Student[] {student});

        Child child = new Child();
        child.setName("Sarah Johnson");
        child.setAge(10);
        child.setAddress("Dalian");
        child.setParentName("EL Karzaoui");

        habbit habbit = new habbit();
        habbit.setName("eating breakfast");

        System.out.println("name is  " + student.getName()
                + " i came from Morocco to china i'm  " + student.getAge()
                + " i live in " + student.getAddress()
                + " my student ID is " + student.getStudentID());
        System.out.println("teacher name is: " + teacher.getName()
                + " he's teaching us java and the introduction to java he is  " + teacher.getAge()
                + " years old " + teacher.getAddress()
                + " his ID card is " + teacher.getTeacherID());
        System.out.println("Class: " + myClass.getClassName() + ", "
                + myClass.getTeacher().getName() + ", " + myClass.getStudents()[0].getName());
        System.out.println("Child: " + child.getName() + ", " + child.getAge() + ", "
                + child.getAddress() + ", " + child.getParentName());
        System.out.println("habbit: " + habbit.getName()
                + " then she's Playing games " + " and do her hoemwork");
    }
}
