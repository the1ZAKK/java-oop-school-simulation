# Reconstruction from the coursework report

The application source was reconstructed from `Java_OOP_Final_Report.docx`, supplied by the author. The report contains selectable Java code, screenshots of all seven original classes, and a final Eclipse console screenshot. The recovered files are a reconstruction of that evidence; original Git history, workspace settings and file bytes were unavailable.

The six model class implementations retain the report's fields, method signatures and behavior. Changes to these classes are indentation, blank lines and explanatory comments. There is no newly invented school-management feature set.

## Evidence map

Page numbers refer to the eight-page render of the supplied report.

| Source file | Report evidence | Reconstruction decision |
| --- | --- | --- |
| `Person.java` | Pages 2–3, written code and first screenshot | Restore `name`, `age`, `address` and all accessors |
| `Student.java` | Pages 3–4, code and screenshot | Restore `extends Person` and integer `studentID` |
| `Child.java` | Page 4, code and screenshot | Restore `extends Person` and `parentName` |
| `Teacher.java` | Page 5, code and screenshot | Restore `extends Person` and integer `teacherID` |
| `Class.java` | Pages 5–6, code and screenshot | Restore the teacher reference and direct `Student[]` reference |
| `habbit.java` | Pages 6–7, code and screenshot | Retain spelling, inheritance and separate `habitName` |
| `TEST.java` | Page 8, Eclipse editor and console screenshots | Recreate the screenshot variant; use the console screenshot for complete output strings where the editor is cropped |
| `ReportTextDemo.java` | Pages 7–8, selectable `TEST` code | Additional entry point preserving this alternate variant; only the class name and formatting/comments are changed |

## The report contains two different demonstrations

The inline code and the Eclipse screenshot are not the same example. They are kept separate rather than silently combined.

| Value | Eclipse screenshot and default `TEST` | Written code and `ReportTextDemo` |
| --- | --- | --- |
| Student | BRIM ZAKARIA, age 19, ID 219101 | doae el karzaoui, age 18, ID 12345 |
| Teacher | Mr. Charles, age 29, ID 1512 | Mr. Charles, age 35, ID 54321 |
| Class | PE teacher | PE teacher |
| Child | William, age 10, USA, parent BRIM | Sarah Johnson, age 10, Dalian, parent EL Karzaoui |
| Habit example | play football | eating breakfast |
| Teacher sentence | Object-oriented programming wording | Java introduction wording |
| Habit sentence | Listening to music and reading books | Playing games and doing homework, including the original `hoemwork` typo |

The final screenshot shows five application output lines. IDE chrome, process launch text and the local Eclipse installation path are not application output. The golden fixture transcribes those five lines, including the visible extra spaces. Tests normalize Windows line endings only.

## Preserved limitations

- `Class` models a named class roster; it has no physical room-number or scheduling model.
- It exposes and stores the same student-array reference, just as the report does. It does not make defensive copies.
- Fresh objects have Java defaults such as `null` names/references and zero numeric fields. Setters do not validate ages, IDs or nulls.
- The demo fills one student slot and prints index zero. The model can hold several students, but the original demo does not provide a roster-management interface.
- `habbit extends Person` is retained even though a redesigned domain model would usually represent a habit separately. Its inherited `name` and its own `habitName` are independent.

## Added support files

Build and run scripts, dependency-free tests, golden output fixtures, Eclipse project settings and launch configurations, Git attributes, documentation and a GitHub Actions workflow were created during reconstruction. They are not recovered historical files.

The screenshots show a `module-info.java` editor tab but do not show its contents. No module declaration has been invented; the reconstructed project builds and runs on the classpath. No archived Eclipse workspace, compiled classes or original version history is claimed.

The original Word report is not bundled in the source package. The package preserves the documented examples without redistributing the report's cover page, metadata or local IDE paths.

## Source identity

| Item | Value |
| --- | --- |
| Supplied report | `Java_OOP_Final_Report.docx` |
| Size | 256103 bytes |
| SHA-256 | `e9ce0b06394e8d0e7ca50f4e8e6f8bd381341dd455d1f89ba5a022d5d8c581a7` |
| Reconstruction date | 18 October 2026, China time |
