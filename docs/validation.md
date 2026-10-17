# Validation of the reconstructed project

Validation completed on **18 October 2026, China time**, using **OpenJDK 17.0.20 on Linux**. No external Java dependencies were installed or downloaded.

## Results

| Check | Result |
| --- | --- |
| Compile application and test source with Java 17, UTF-8, all compiler lint checks and warnings treated as errors | Passed |
| Dependency-free behavioral suite | 6 test cases, 38 checks passed |
| Default `report.TEST` output against the Eclipse console transcription | Passed, all five lines |
| `report.ReportTextDemo` output against the selectable report-code example | Passed, all five lines |
| Model inheritance, private person fields, inherited state and entity-specific properties | Passed |
| Shared teacher/student references and multiple-student ordering | Passed |
| Original null defaults, empty roster and direct array-reference behavior | Passed |
| Independence of `habbit.name` and `habbit.habitName` | Passed |
| Executable JAR entry point and alternate demo loaded from the JAR | Passed |
| Run and test scripts invoked from outside the project directory | Passed |
| Project directory with spaces, Unicode and an ampersand | Passed |
| `JAVA_HOME` containing spaces | Passed |
| Bash syntax, Eclipse XML, launch files and workflow structure | Passed |
| Windows command-file line endings | CRLF verified |

The six original model classes were compared against the report's selectable Java code by token sequence, excluding comments and whitespace. All six matched. The alternate `ReportTextDemo` also matched the selectable `TEST` code after the documented entry-point rename. See [source fidelity results](source-fidelity.json) and [verification results](verification-results.json).

The screenshot variant of `TEST` was reconstructed using the visible editor screenshot together with the complete console output; it is not asserted to be byte-for-byte recovered source. The report's complete written-code variant is preserved separately.

## Re-run the checks

From the project directory:

```bat
test.cmd
```

or:

```bash
bash test.sh
```

Expected summary:

```text
PASS: 6 test cases, 38 checks.
```

## Verification limits

Native Windows command execution and the Eclipse desktop interface were unavailable in this environment. Their configuration and scripts were reviewed, but no Windows or Eclipse UI pass is claimed. The prepared GitHub Actions workflow exercises the native Windows script and the Linux script after upload; it has not been run on GitHub as part of this reconstruction.

The original `.project`, `.classpath`, module descriptor and Git history were not recoverable from the report. Included IDE and automation files were created for this package. Output fixtures are manually transcribed evidence, not recovered original test files.

## CI action references

The workflow pins these official action revisions, verified when the package was prepared:

- [actions/checkout v7.0.1](https://github.com/actions/checkout/commit/3d3c42e5aac5ba805825da76410c181273ba90b1)
- [actions/setup-java v6.1.0](https://github.com/actions/setup-java/commit/b843ebf9b913146b38da2eaa7aeddf76074ae1ad)
