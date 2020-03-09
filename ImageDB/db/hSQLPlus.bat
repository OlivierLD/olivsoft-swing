@echo off
@echo Available Connections:
@echo CHART chart chart
@echo LOG log log
@echo TIDES tides tides
@echo IMAGES images images
@echo Usage is:
@echo %0 CHART chart chart
@echo hSQL^> connect
@echo hSQL^> select * from charts;
@echo Type help for help
@echo ...
@echo !! Warning !! Even "create table" needs to be commited...
::
@set CP=%CP%;..\hsqldb.jar
@set CP=%CP%;..\geomutil.jar
@set CP=%CP%;..\chartlib.jar
@set CP=%CP%;..\chartcomponents.jar
@set CP=%CP%;..\coreutilities.jar
::
@title hSQL DB Browser
@color f0
@java -classpath %CP% coreutilities.sql.HSQLPlus %1 %2 %3
:: @java -classpath %CP% coreutilities.sql.HSQLPlus "SAMPLEDB" SA ""
