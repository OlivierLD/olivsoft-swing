@echo off
@echo +------------------------+
@echo ! Sight Reduction Sample !
@echo +------------------------+
@setlocal
set CP=.\classes
set CP=%OLIVSOFT_HOME%\build\libs\release-4.0.0.0-all.jar
java -classpath %CP% -DdeltaT=65.984 app.raw.SightReductionSample
@endlocal
pause