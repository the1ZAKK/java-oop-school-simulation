package report;

/**
 * Reconstructed Eclipse screenshot demonstration.
 * See ReportTextDemo for the different example in the report's written code.
 */
public class TEST {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("BRIM ZAKARIA");
        student.setAge(19);
        student.setAddress("Dalian");
        student.setStudentID(219101);

        Teacher teacher = new Teacher();
        teacher.setName("Mr. Charles");
        teacher.setAge(29);
        teacher.setAddress("Dalian");
        teacher.setTeacherID(1512);

        Class myClass = new Class();
        myClass.setClassName("PE teacher");
        myClass.setTeacher(teacher);
        myClass.setStudents(new Student[] {student});

        Child child = new Child();
        child.setName("William");
        child.setAge(10);
        child.setAddress("USA");
        child.setParentName("BRIM");

        habbit habbit = new habbit();
        habbit.setName("play football");

        System.out.println("my name is  " + student.getName()
                + " i came from Morocco to china i'm  " + student.getAge()
                + " i live in " + student.getAddress()
                + " my student ID is " + student.getStudentID());
        System.out.println("teacher name is: " + teacher.getName()
                + " he's teaching us object oriented programming he is  " + teacher.getAge()
                + " years old " + teacher.getAddress()
                + " his ID card is " + teacher.getTeacherID());
        System.out.println("Class: " + myClass.getClassName() + ", "
                + myClass.getTeacher().getName() + ", " + myClass.getStudents()[0].getName());
        System.out.println("Child: " + child.getName() + ", " + child.getAge() + ", "
                + child.getAddress() + ", " + child.getParentName());
        System.out.println("habbit: " + habbit.getName()
                + " also he like to listen to music " + " and read books");
    }
}
