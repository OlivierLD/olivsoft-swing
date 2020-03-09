@setlocal
@echo off
@echo +----------------------------------------+
@echo ^| Routing Command Line Interface (R-CLI) ^|
@echo +----------------------------------------+
::
:: Parameters ?
::
set FROM_L=
set FROM_G=
set TO_L=
set TO_G=
set START_TIME=
set POLARS=
set GRIB=
set OUTPUT=
set VERBOSE=N
set SPEED_COEFF=1.0
set TIME_INTERVAL=24
set FORK_WIDTH=140
set ROUTING_STEP=10
set LIMIT_TWS=-1
set LIMIT_TWA=-1
::
set PRM_STRING=
::
:looptop
set PRM=%1
:: echo PRM:%1 [%PRM%]
:: echo the full stuff [%1 %2]
if "%PRM%" == "" (
  goto next
) else (
  if "%PRM%" == "-help" (
    set PRM_STRING="-help"
	goto run
  ) else if "%PRM%" == "-fromL" (
    set FROM_L=%2
  ) else if "%PRM%" == "-fromG" (
    set FROM_G=%2
  ) else if "%PRM%" == "-toL" (
    set TO_L=%2
  ) else if "%PRM%" == "-toG" (
    set TO_G=%2
  ) else if "%PRM%" == "-startTime" (
    set START_TIME=%2
  ) else if "%PRM%" == "-grib" (
    set GRIB=%2
  ) else if "%PRM%" == "-output" (
    set OUTPUT=%2
  ) else if "%PRM%" == "-polars" (
    set POLARS=%2
  ) else if "%PRM%" == "-verbose" (
    set VERBOSE=%2
  ) else if "%PRM%" == "-speedCoeff" (
    set SPEED_COEFF=%2
  ) else if "%PRM%" == "-timeInterval" (
    set TIME_INTERVAL=%2
  ) else if "%PRM%" == "-routingForkWidth" (  
    set FORK_WIDTH=%2
  ) else if "%PRM%" == "-routingStep" (  
    set ROUTING_STEP=%2
  ) else if "%PRM%" == "-limitTWS" (  
    set LIMIT_TWS=%2
  ) else if "%PRM%" == "-limitTWA" (  
    set LIMIT_TWA=%2
  )
  shift
  goto looptop
)
:next
if /i "%DEBUG%" == "Y" (
  set VERBOSE=Y
  @echo on
)
::
if ["%FROM_L%"] == [""] (
  set /p FROM_L=Start Latitude  ^> 
)
if ["%FROM_G%"] == [""] (
  set /p FROM_G=Start Longitude ^> 
)
if ["%TO_L%"] == [""] (
  set /p TO_L=Arrival Latitude  ^> 
)
if ["%TO_G%"] == [""] (
  set /p TO_G=Arrival Longitude ^> 
)
if ["%START_TIME%"] == [""] (
  set /p START_TIME=Starting ^(time^) ^> 
)
if ["%GRIB%"] == [""] (
  set /p GRIB=Grib File ^> 
)
if ["%POLARS%"] == [""] (
  set /p POLARS=Polars File ^> 
)
if ["%OUTPUT%"] == [""] (
  set /p OUTPUT=Output File ^> 
)
::
set PRM_STRING=-fromL %FROM_L% -fromG %FROM_G% -toL %TO_L% -toG %TO_G% -startTime "%START_TIME%" 
set PRM_STRING=%PRM_STRING% -grib "%GRIB%" -polars "%POLARS%" -output "%OUTPUT%" -speedCoeff %SPEED_COEFF% -verbose %VERBOSE%
set PRM_STRING=%PRM_STRING% -timeInterval %TIME_INTERVAL% -routingForkWidth %FORK_WIDTH% -routingStep %ROUTING_STEP% -limitTWS %LIMIT_TWS% -limitTWA %LIMIT_TWA%
:run
::
set CP=
set CP=..\all-3rd-party\rxtx.distrib\RXTXcomm.jar
set CP=%CP%;..\build\libs\release-4.0.0.0-all.jar
::
set JAVA_OPTIONS=-Xmn1536m -Xms2048m -Xmx2048m -XX:SurvivorRatio=1 -XX:PermSize=30m -XX:+UseParallelGC 
:: @echo Parameters: %PRM_STRING%
::
set begintime=%TIME%
@echo Computing routing at %begintime% ...
::
java -client -classpath %CP% %JAVA_OPTIONS% main.BlindRouting %PRM_STRING%
set finishtime=%time%
call :timediff %begintime% %finishtime%
::@echo.
@echo Done at %finishtime%, it took %timetaken%
@echo -----------------------------------------
goto eos
::
:timediff
:: echo %1, %2
set start=%1
set end=%2
set options="tokens=1-4 delims=:."
for /f %options% %%a in ("%start%") do set start_h=%%a & set /a start_m=100%%b %% 100 & set /a start_s=100%%c %% 100 & set /a start_ms=100%%d %% 100
for /f %options% %%a in ("%end%") do set end_h=%%a & set /a end_m=100%%b %% 100 & set /a end_s=100%%c %% 100 & set /a end_ms=100%%d %% 100
set /a hours=%end_h%-%start_h%
set /a mins=%end_m%-%start_m%
set /a secs=%end_s%-%start_s%
set /a ms=%end_ms%-%start_ms%
if %hours% lss 0 set /a hours = 24%hours%
if %mins% lss 0 set /a hours = %hours% - 1 & set /a mins = 60%mins%
if %secs% lss 0 set /a mins = %mins% - 1 & set /a secs = 60%secs%
if %ms% lss 0 set /a secs = %secs% - 1 & set /a ms = 100%ms%
if 1%ms% lss 100 set ms=0%ms%
set timetaken=%hours%:%mins%:%secs%.%ms%
goto eos
:: End Of Script
:eos
