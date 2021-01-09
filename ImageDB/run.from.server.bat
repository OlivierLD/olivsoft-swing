@echo off
@setlocal
set CP=.\dnd.jar
set CP=%CP%;.\hsqldb.jar
set CP=%CP%;.\coreutilities.jar
::
set JAVA_OPTIONS=-Dverbose=false
:: set JAVA_OPTIONS=-Dverbose=true
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Ddb.location=.\db -Ddb.flavor=file.db
set JAVA_OPTIONS=%JAVA_OPTIONS% -Ddb.flavor=server.db -Ddb.url=//localhost:2345/images -Xmx1024m
::
java %JAVA_OPTIONS% -cp %CP% dnd.gui.splash.Splasher
@endlocal