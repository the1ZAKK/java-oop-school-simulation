# Share the reconstructed project on GitHub

Suggested repository name: `java-oop-school-simulation`.

Create an empty repository in your GitHub account. Starting from the extracted project directory, the standard Git sequence is:

```bash
git init -b main
git add .
git commit -m "Reconstruct Java OOP coursework from the original report"
git remote add origin YOUR_REPOSITORY_URL
git push -u origin main
```

Replace `YOUR_REPOSITORY_URL` with the clone URL shown by GitHub for your new repository. Git may request your usual authentication. Keep the README's reconstruction note so visitors understand the project's history.

Include the project configuration files and the `.github` directory when transferring the source. The Git ignore file excludes generated classes, JAR files and build output. The original report does not need to be uploaded.

After pushing, the **Java verification** workflow will be able to run the Java 17 build and tests on Ubuntu and Windows. Review its actual results in the repository's Actions tab before describing hosted CI as passing.

## Suggested repository description

Java and Eclipse OOP coursework modeling students, teachers and class rosters with inheritance, encapsulation and object arrays. Reconstructed from the original report.

## Suggested topics

`java`, `object-oriented-programming`, `eclipse`, `inheritance`, `encapsulation`, `coursework`, `console-application`

## Portfolio description

**Object-oriented programming coursework | Java, Eclipse**

- Modeled students, teachers and class rosters using object-oriented design.
- Applied inheritance, encapsulation and object arrays to represent relationships between school entities.
- Demonstrated system behavior and relationships through console output.
- Reconstructed the lost source from the original coursework report and added repeatable build and verification scripts.
