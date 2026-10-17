package report;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/** Dependency-free behavioral checks against the report and its two examples. */
public final class ReconstructionTest {
    private static int cases;
    private static int checks;

    private ReconstructionTest() {
    }

    public static void main(String[] args) throws Exception {
        run("Eclipse screenshot console output", () -> compareOutput(
                "examples/screenshot-output.txt", () -> TEST.main(new String[0])));
        run("Written report console output", () -> compareOutput(
                "examples/report-text-output.txt", () -> ReportTextDemo.main(new String[0])));
        run("Inheritance and private fields", ReconstructionTest::inheritanceAndEncapsulation);
        run("Teacher and student relationships", ReconstructionTest::relationships);
        run("Original default and array behavior", ReconstructionTest::defaultsAndArrays);
        run("Habit fields remain independent", ReconstructionTest::habitFields);
        System.out.println("PASS: " + cases + " test cases, " + checks + " checks.");
    }

    private static void inheritanceAndEncapsulation() throws Exception {
        Person[] people = {new Student(), new Teacher(), new Child(), new habbit()};
        for (int i = 0; i < people.length; i++) {
            people[i].setName("Person " + i);
            people[i].setAge(20 + i);
            people[i].setAddress("Dalian");
            equal("Person " + i, people[i].getName(), "inherited name");
            equal(20 + i, people[i].getAge(), "inherited age");
            equal("Dalian", people[i].getAddress(), "inherited address");
        }
        equal(true, Modifier.isPrivate(Person.class.getDeclaredField("name").getModifiers()),
                "name stays private");
        equal(true, Modifier.isPrivate(Person.class.getDeclaredField("age").getModifiers()),
                "age stays private");
        equal(true, Modifier.isPrivate(Person.class.getDeclaredField("address").getModifiers()),
                "address stays private");
        Student student = (Student) people[0];
        Teacher teacher = (Teacher) people[1];
        Child child = (Child) people[2];
        student.setStudentID(100);
        teacher.setTeacherID(200);
        child.setParentName("Parent");
        equal(100, student.getStudentID(), "student identifier");
        equal(200, teacher.getTeacherID(), "teacher identifier");
        equal("Parent", child.getParentName(), "parent relationship");
    }

    private static void relationships() {
        Teacher teacher = new Teacher();
        Student first = new Student();
        Student second = new Student();
        Class classroom = new Class();
        classroom.setClassName("Programming");
        classroom.setTeacher(teacher);
        classroom.setStudents(new Student[] {first, second});
        teacher.setName("Updated teacher");
        second.setName("Second student");
        equal("Programming", classroom.getClassName(), "class name");
        equal(true, classroom.getTeacher() == teacher, "teacher is a shared object");
        equal("Updated teacher", classroom.getTeacher().getName(), "teacher changes propagate");
        equal(2, classroom.getStudents().length, "multiple students");
        equal(true, classroom.getStudents()[0] == first, "student ordering");
        equal("Second student", classroom.getStudents()[1].getName(), "student changes propagate");
    }

    private static void defaultsAndArrays() {
        Person person = new Person();
        Class classroom = new Class();
        equal(null, person.getName(), "default name");
        equal(0, person.getAge(), "default age");
        equal(null, person.getAddress(), "default address");
        equal(null, classroom.getTeacher(), "default teacher");
        equal(null, classroom.getStudents(), "default roster");
        Student[] students = {new Student()};
        classroom.setStudents(students);
        equal(true, classroom.getStudents() == students, "original array reference is retained");
        Student replacement = new Student();
        students[0] = replacement;
        equal(true, classroom.getStudents()[0] == replacement, "array changes remain visible");
        classroom.setStudents(new Student[0]);
        equal(0, classroom.getStudents().length, "empty roster is stored");
        classroom.setStudents(null);
        equal(null, classroom.getStudents(), "null roster is stored without added validation");
    }

    private static void habitFields() {
        habbit habit = new habbit();
        habit.setName("play football");
        equal(null, habit.getHabitName(), "report demo does not set habitName");
        habit.setHabitName("reading");
        equal("play football", habit.getName(), "inherited name remains separate");
        equal("reading", habit.getHabitName(), "separate habitName accessor");
    }

    private static void compareOutput(String fixture, CheckedCase demonstration) throws Exception {
        String expected = normalize(Files.readString(Path.of(fixture), StandardCharsets.UTF_8));
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream previous = System.out;
        try (PrintStream captured = new PrintStream(bytes, true, StandardCharsets.UTF_8)) {
            System.setOut(captured);
            demonstration.run();
        } finally {
            System.setOut(previous);
        }
        equal(expected, normalize(bytes.toString(StandardCharsets.UTF_8)), fixture);
    }

    private static String normalize(String value) {
        return value.replace("\r\n", "\n");
    }

    private static void equal(Object expected, Object actual, String message) {
        checks++;
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(message + "\nExpected: " + expected + "\nActual:   " + actual);
        }
    }

    private static void run(String name, CheckedCase test) throws Exception {
        test.run();
        cases++;
        System.out.println("PASS: " + name);
    }

    @FunctionalInterface
    private interface CheckedCase {
        void run() throws Exception;
    }
}
