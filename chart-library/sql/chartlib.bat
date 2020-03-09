setlocal
@set CP=%CP%;..\..\all-3rd-party\hSQL.jar
@set CP=%CP%;..\..\all-3rd-party\xmlparserv2.jar
@set CP=%CP%;..\..\all-libs\geomutil.jar
@set CP=%CP%;..\..\all-libs\chartcomponents.jar
@set CP=%CP%;..\..\all-libs\chartlib.jar
::
@java -classpath %CP% chartlib.ui.components.main.ChartLib 
endlocal
