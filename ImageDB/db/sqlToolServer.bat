@echo off
@echo Connecting to User IMAGES
setlocal
set HSQLDB_HOME=..
set CP=%HSQLDB_HOME%\hsqldb.jar
@echo To exit, type \q
java -jar %CP% --inlineRc URL=jdbc:hsqldb:hsql://localhost:2345/images,USER=IMAGES,DRIVER=org.hsqldb.jdbcDriver
:: java -jar %CP% --help
pause
endlocal
