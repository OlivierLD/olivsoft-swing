@echo off
@setlocal
title Image Database
:: Verifying java availability
@echo Running script %0 to check java availability
java -version 1> nul 2>&1
if ERRORLEVEL 1 (
  @echo ----------------------------------------------------------------------------
  @echo ------------------------ WARNING !! ----------------------------------------
  @echo ----------------------------------------------------------------------------
  @echo java NOT found!
  @echo You can fix that.
  @echo If java is installed, you should fix the PATH, in the present
  @echo script ^(%0^), at the system level.
  @echo If java is not installed, you need to install it from http://www.java.com/
  @echo You need at least a JRE ^(Java Runtime Engine^).
  @echo ----------------------------------------------------------------------------
  pause
  goto eos
) else (
  @echo java was found. Everything's OK so far.
)
set CP=.\dnd.jar
set CP=%CP%;.\hsqldb.jar
set CP=%CP%;.\coreutilities.jar
::
set JAVA_OPTIONS=-Dverbose=false -Xmx1024m
:: set JAVA_OPTIONS=-Dverbose=true
set JAVA_OPTIONS=%JAVA_OPTIONS% -Ddb.location=.\db -Ddb.flavor=file.db
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Ddb.flavor=server.db -Ddb.url=//localhost:2345/images
::
java %JAVA_OPTIONS% -cp %CP% dnd.gui.splash.Splasher
:eos
@endlocal
