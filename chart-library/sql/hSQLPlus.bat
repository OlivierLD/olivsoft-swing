@echo off
@echo Available Connections:
@echo CHART chart chart
::
@set CP=%CP%;..\..\all-3rd-party\hSQL.jar
@set CP=%CP%;..\..\all-libs\geomutil.jar
@set CP=%CP%;..\..\all-libs\chartlib.jar
::
@title Charts 
@color f0
@java -client -classpath %CP% chartlib.sql.HSQLPlus %1 %2 %3
