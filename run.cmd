@echo off
setlocal EnableExtensions DisableDelayedExpansion
pushd "%~dp0" || exit /b 1
call build.cmd
if errorlevel 1 goto failed
set "OOP_JAVA=java"
if defined JAVA_HOME set "OOP_JAVA=%JAVA_HOME%\bin\java.exe"
"%OOP_JAVA%" -cp "build\classes" report.TEST
if errorlevel 1 goto failed
popd
echo.
pause
exit /b 0

:failed
echo.
echo The demonstration could not run. See the error above. 1>&2
popd
pause
exit /b 1
