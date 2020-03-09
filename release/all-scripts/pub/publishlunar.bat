@echo off
@setlocal
@echo %*
::
cd %~dp0
@echo Running from %CD%, %0
set OLIVSOFT_HOME=..\..
set CP=%OLIVSOFT_HOME%\build\libs\release-4.0.0.0-all.jar
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\orai18n-collation.jar
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\orai18n-mapping.jar
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\fnd2.zip
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\xdo-0301.jar
::
@echo Processing PDF file
set XSL_STYLESHEET=.\lunar2fop.xsl
set LANG=%1
if [%LANG%] == [FR] (
  echo Will speak French
  set PRM_OPTION=-docconf .\lang_fr.cfg 
  copy literals_fr.xsl literals.xsl
) else (
  echo Will speak English
  copy literals_en.xsl literals.xsl
  set PRM_OPTION=-docconf .\lang_en.cfg 
)
@echo Publishing
@java -Xms256m -Xmx1024m -classpath %CP% oracle.apps.xdo.template.FOProcessor %PRM_OPTION% -xml %2 -xsl %XSL_STYLESHEET% -pdf %3
@echo Done calculating, displaying.
call %3
:end
::pause
@endlocal
exit