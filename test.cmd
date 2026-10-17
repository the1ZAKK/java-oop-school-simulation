@echo off
setlocal EnableExtensions DisableDelayedExpansion
pushd "%~dp0" || exit /b 1
call build.cmd
if errorlevel 1 goto failed
set "OOP_JAVA=java"
if defined JAVA_HOME set "OOP_JAVA=%JAVA_HOME%\bin\java.exe"
mkdir "build\test-classes"
if errorlevel 1 goto failed
"%OOP_JAVA%" -m jdk.compiler/com.sun.tools.javac.Main --release 17 -encoding UTF-8 -Xlint:all -Werror -cp "build\classes" -d "build\test-classes" tests/report/ReconstructionTest.java
if errorlevel 1 goto failed
"%OOP_JAVA%" -cp "build\classes;build\test-classes" report.ReconstructionTest
if errorlevel 1 goto failed
popd
exit /b 0

:failed
echo Tests failed. See the error above. 1>&2
popd
exit /b 1
