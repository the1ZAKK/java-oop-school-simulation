@echo off
setlocal EnableExtensions DisableDelayedExpansion
pushd "%~dp0" || exit /b 1
set "OOP_JAVA=java"
if defined JAVA_HOME set "OOP_JAVA=%JAVA_HOME%\bin\java.exe"

"%OOP_JAVA%" -m jdk.compiler/com.sun.tools.javac.Main -version >nul 2>&1
if errorlevel 1 goto no_jdk

if exist "build\classes" rmdir /s /q "build\classes"
if exist "build\test-classes" rmdir /s /q "build\test-classes"
if exist "build\classes" goto failed
if exist "build\test-classes" goto failed
if not exist "build" mkdir "build"
if errorlevel 1 goto failed
mkdir "build\classes"
if errorlevel 1 goto failed

"%OOP_JAVA%" -m jdk.compiler/com.sun.tools.javac.Main --release 17 -encoding UTF-8 -Xlint:all -Werror -d "build\classes" @config/sources.txt
if errorlevel 1 goto failed
"%OOP_JAVA%" -m jdk.jartool/sun.tools.jar.Main --create --file "build\java-oop-school-simulation.jar" --main-class report.TEST -C "build\classes" .
if errorlevel 1 goto failed
echo Build complete: build\java-oop-school-simulation.jar
popd
exit /b 0

:no_jdk
echo A full JDK 17 or later is required. Set JAVA_HOME or put its bin directory on PATH. 1>&2
popd
exit /b 1

:failed
echo Build failed. See the error above. 1>&2
popd
exit /b 1
