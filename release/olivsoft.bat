@echo off
::
::  Usual usage: olivsoft -proxyHost [proxyhost] 
::                        -proxyPort [Port] 
::                        -verbose [y|n] 
::                        -debug [y|n]
::                        -direct [y|n] 
::                        -option [Option] 
::                        -channel [Option]  (Deprecated)
::                        -port [SerialPortName] 
::                        -br [BaudRate] 
::                        -file [SimulationDataFile] 
::                        -udp [UDP Port] 
::                        -extraVMprm [Extra Java VM Parameters] <- Can be repeated
::                        -allNotifications [y|n]
::
@setlocal
::
title Oliv Soft. The full stack
:: Verifying java availability
:: set PATH=C:\JDev.11.1.1.5.0\jdk160_24\bin;%PATH%
:: set JAVA_HOME=D:\Java\jdk1.7.0_45
:: set PATH=%JAVA_HOME%\bin;%PATH%
::
@echo Running script %0 to check java availability
java -version -client 1> nul 2>&1
if ERRORLEVEL 1 (
  @echo ----------------------------------------------------------------------------
  @echo ------------------------ WARNING !! ----------------------------------------
  @echo ----------------------------------------------------------------------------
  @echo java NOT found!
  @echo You can fix that.
  @echo If java is installed, you should fix the PATH, in the present
  @echo script ^(%0^), or at the system level.
  @echo If java is not installed, you need to install it from http://www.java.com/
  @echo You need a JRE ^(Java Runtime Environment^).
  @echo ----------------------------------------------------------------------------
  pause
  goto eos
) else (
  @echo java was found. Everything's OK so far.
)
::
:: Generic
::
set nbprm=0
set PROXY_HOST=
set PROXY_PORT=
set VERBOSE=N
set DIRECT=N
set DIRECTION=
set LNF=
set EXTRA_JVM_PRM=
set DEBUG=N
set ALL_NOTIFICATIONS=N
::
:: Specific
::
set CHANNEL=
set FILE=
set PORT=
set BR=
set UDP=
::
for %%i in (%*) do call :count %%i
:: echo NbPrm: %nbprm%
:looptop
set PRM=%1
:: echo PRM:%1 [%PRM%]
if "%PRM%" == "" (
  goto next
) else (
  if "%PRM%" == "-proxyHost" (
    set PROXY_HOST=%2
  ) else if "%PRM%" == "-proxyPort" (
    set PROXY_PORT=%2
  ) else if "%PRM%" == "-verbose" (
    set VERBOSE=%2
  ) else if "%PRM%" == "-direct" (
    set DIRECT=%2
  ) else if "%PRM%" == "-option" (
    set DIRECTION=%2
  ) else if "%PRM%" == "-channel" (
    set CHANNEL=%2
  ) else if "%PRM%" == "-port" (
    set PORT=%2
  ) else if "%PRM%" == "-udp" (
    set UDP=%2
  ) else if "%PRM%" == "-file" (
    set FILE=%2
  ) else if "%PRM%" == "-br" (
    set BR=%2
  ) else if "%PRM%" == "-lnf" (  
    set LNF=%2
  ) else if "%PRM%" == "-debug" (  
    set DEBUG=%2
  ) else if "%PRM%" == "-extraVMprm" ( 
    set EXTRA_JVM_PRM=%EXTRA_JVM_PRM% %2
  ) else if "%PRM%" == "-allNotifications" (
    set ALL_NOTIFICATIONS=%2
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
:: echo Proxy  : %PROXY_HOST%
:: echo Port   : %PROXY_PORT%
:: echo Verbose: %VERBOSE%
echo Direct : %DIRECT%
echo Option : %DIRECTION%
if not ["%EXTRA_JVM_PRM%"] == [""] (
  echo +-----------------------------------------------------
  echo ^| Extra JVM prms : %EXTRA_JVM_PRM%
  echo +-----------------------------------------------------
)
goto begin
:count
set /a nbprm=%nbprm% + 1
:: echo Value of prm %nbprm%=%1
::
goto eos

:begin
if /i [%DIRECT%] == [Y] (
  if [%DIRECTION%] == [] (
    @echo Ca va pas. No good.
    pause
    goto finish 
  )
)
if /i [%VERBOSE%] == [Y] echo Verbose=Y
set CURRENT_DIR=%~dp0
cd %CURRENT_DIR%\all-scripts
:: set PATH=.\jre\bin;%PATH%
:: Finding 64 or 32 Bits VM
set JAVA_LIB_PATH=..\all-3rd-party\rxtx.distrib\win64
:: For findstr
set PATH=%PATH%;%SystemRoot%\system32
::
java -version -client 2> java.version
findstr "64-Bit" java.version
if ERRORLEVEL 1 (
  set JAVA_LIB_PATH=..\all-3rd-party\rxtx.distrib\win32
)
if /i [%DIRECT%] == [N] (
  java -version -client -Djava.library.path=%JAVA_LIB_PATH%
)  
set CP=..\all-3rd-party\rxtx.distrib\RXTXcomm.jar
set CP=%CP%;..\build\libs\release-4.0.0.0-all.jar
::
::@echo %CP%
::pause
::
:: set MEM_OPTIONS=-Xms128m -Xmx1024m
:: set MEM_OPTIONS=-Xmn1536m -Xms2048m -Xmx2048m 
:::::: set MEM_OPTIONS=-XX:NewSize=512m -XX:MaxNewSize=512m -Xmn768m -Xms1024m -Xmx1024m 
:: set MEM_OPTIONS=-XX:NewSize=1024m -XX:MaxNewSize=1024m -Xmn1536m -Xms2048m -Xmx2048m 
set MEM_OPTIONS=%MEM_OPTIONS% -XX:SurvivorRatio=1 -XX:+UseParallelGC
::
:topprompt
::
set RAW=false
if /i [%DIRECT%] == [N] (
call :displayBanner  
@echo +---------------------------------------------+
@echo ^| OlivSoft full stack, 2007, 2008, and beyond ^|
@echo +---------------------------------------------+-----------------------+
@echo ^| WW   for Weather Wizard            POL for Polar Tool               ^| 
@echo ^| WM   for Weather Wizard with Metal L^&F                              ^| 
@echo ^| HLWW for Headless Weather Wizard                                    ^| 
@echo +---------------------------------------------------------------------+
@echo ^| D    for DOS Prompt here           W for Windows Explorer           ^|
@echo ^| DT   Desktop                       SNIF for NMEA Sniffer            ^| 
@echo ^| DM   Desktop with Metal L^&F        TEST NMEA Input Channel Test     ^| 
@echo ^| DR   Desktop, raw.                                                  ^| 
@echo ^| HL   Headless Console              HLH Headless Console Help        ^| 
@echo ^| HUE  Headless Console with User-Exit                                ^| 
@echo ^| HLU  Headless Update               CLI Preferences CLI              ^| 
@echo +---------------------------------------------------------------------+
@echo ^| Q    to Quit                                                        ^| 
@echo +---------------------------------------------------------------------+
::
set /p option=You choose ^> 
) else (
  set option=%direction%
)
:: Java Options
set JAVA_OPTIONS=-Djava.library.path=%JAVA_LIB_PATH% -DGRIB.wind.factor=1.0
if not [%PROXY_HOST%] == [] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dhttp.proxyHost=%PROXY_HOST% -Dhttp.proxyPort=%PROXY_PORT% -Dhttp.nonProxyHosts=localhost
)
if not [%LNF%] == [] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dswing.defaultlaf=%LNF%
)
if not ["%EXTRA_JVM_PRM%"] == [""] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% %EXTRA_JVM_PRM%
)
::
if /i [%option%] == [Q] goto finish
if /i [%option%] == [QUIT] goto finish
if /i [%option%] == [WW] (
  call :weatherfax
) else if /i [%option%] == [HLWW] (
  call :weatherfax-hl
) else if /i [%option%] == [WM] (
  call :weatherfax javax.swing.plaf.metal.MetalLookAndFeel
) else if /i [%option%] == [HL] (
  call :headlessconsole
) else if /i [%option%] == [TEST] (
  call :testnmeachannel
) else if /i [%option%] == [HUE] (
  call :headlessconsole-ue
) else if /i [%option%] == [HLH] (
  call :headlessconsole-help
) else if /i [%option%] == [HLU] (
  call :headlessupdate
) else if /i [%option%] == [CLI] (
  call :pref-cli
) else if /i [%option%] == [DT] (
  call :desktop
) else if /i [%option%] == [DR] (
  set RAW=true
  call :desktop
) else if /i [%option%] == [DM] (
  call :desktop javax.swing.plaf.metal.MetalLookAndFeel
) else if /i [%option%] == [SNIF] (
  set verb=false
  if /i [%VERBOSE%] == [y] set verb=true
::java %JAVA_OPTIONS% -classpath %CP%  -Dverbose=%verb% nmeasniffer.Sniffer
  java %JAVA_OPTIONS% -classpath %CP%  -Dverbose=%verb% nmeasniffer.gui.NMEASniffer
  if /i [%direct%] == [N] pause
) else if /i [%option%] == [D] (
  start 
) else if /i [%option%] == [W] (
  start .
) else if /i [%option%] == [POL] (
::start /min "Polar Tool" java -splash:"clipper.jpg" %JAVA_OPTIONS% -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath %CP% polarmaker.polars.main.PolarSmoother
  start /min "Polar Tool" java -splash:"clipper.jpg" %JAVA_OPTIONS% -classpath %CP% polarmaker.polars.main.PolarSmoother
) else (
  @echo [%option%] Unknown command...
  pause
)
cls
if /i [%direct%] == [N] goto topprompt
:finish
@echo Oliv Soft, 2007, 2008, etc
if /i [%direct%] == [N] pause
endlocal
goto finish

:weatherfax
if not [%1] == [] (
 set JAVA_OPTIONS=%JAVA_OPTIONS% -Dswing.defaultlaf=%1
)
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dswing.aatext=true -Dswing.plaf.metal.controlFont=Tahoma -Dswing.plaf.metal.userFont=Verdana
set lng=
if [%DIRECTION%] == [] (
  set /p lng=[E] for English, [F] for France, [C] for Canada, [D] for Germany, [A] for Austria, [S] for Spain ?  ^>  
  set /p verbose=Verbose ?       y^|[n] ^>  
) else (
  set lng=N
)
if [%lng%] == [] set lng=N
if [%verbose%] == [] set verbose=N
::  
:: if /i [%lng%] == [Y] set JAVA_OPTIONS=-Duser.language=fr -Duser.country=FR %JAVA_OPTIONS% 
if /i [%lng%] == [F] set JAVA_OPTIONS=-Duser.language=fr -Duser.country=FR %JAVA_OPTIONS% 
if /i [%lng%] == [C] set JAVA_OPTIONS=-Duser.language=fr -Duser.country=CA %JAVA_OPTIONS% 
if /i [%lng%] == [D] set JAVA_OPTIONS=-Duser.language=de -Duser.country=DE %JAVA_OPTIONS% 
if /i [%lng%] == [A] set JAVA_OPTIONS=-Duser.language=de -Duser.country=AT %JAVA_OPTIONS% 
if /i [%lng%] == [S] set JAVA_OPTIONS=-Duser.language=es -Duser.country=ES %JAVA_OPTIONS% 
if /i [%lng%] == [E] set JAVA_OPTIONS=-Duser.language=en -Duser.country=US %JAVA_OPTIONS% 
set JAVA_OPTIONS=%EXTRA_JVM_PRM% %MEM_OPTIONS% %JAVA_OPTIONS% 
set JAVA_OPTIONS=%JAVA_OPTIONS% -splash:"clipper.jpg"
if /i [%ALL_NOTIFICATIONS%] == [Y] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnotifications=all
)
::echo %CP% | findstr /c:"\tools.jar" > dummy.txt
::@echo ErrorLevel: %ERRORLEVEL%
::if ERRORLEVEL 1 (
::  echo Tools.jar Not Found, adding it
::  set CP=%CP%;D:\Program Files\Java\jdk1.7.0\lib\tools.jar
::)
set command=java %JAVA_OPTIONS% -client -classpath "%CP%" main.splash.Splasher
if /i [%verbose%] == [Y] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -verbose
  echo LNG=%lng%, JAVA_OPTIONS=%JAVA_OPTIONS%
  echo %command%
  echo Running in %cd%
  echo %command% > weatherfax.log
  if /i [%direct%] == [N] pause
)
if /i [%verbose%] == [n] (
::echo %command%
  start /min %command%
) else (  
  @echo Running!
  %command%
  @pause
)
if /i [%verbose%] == [Y] (
  @pause
)  
goto finish

:weatherfax-hl
set JAVA_OPTIONS=%EXTRA_JVM_PRM% %MEM_OPTIONS% %JAVA_OPTIONS% 
::
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhhtp.proxyPort=80
::
set PRMS=-composite:./patterns/01.Favorites/01.3.00.Pacific.Sfc.500.Tropic.GRIB.ptrn
set PRMS=%PRMS%,./patterns/01.Favorites/06.01.AllPac.Faxes.Satellite.ptrn
set PRMS=%PRMS% -interval:360 
set PRMS=%PRMS% "-pattern:/yyyy/MM-MMM | | yyyy-MM-dd_HHmmss_z | _Pacific | waz"
set PRMS=%PRMS%,"/yyyy/MM-MMM | NPac_ | yyyy-MM-dd_HHmmss_z | _FaxSatPic | waz"
::
set command=java %JAVA_OPTIONS% -client -classpath "%CP%" -Dheadless=true main.splash.Splasher %PRMS%
::
start "Headless Weather Wizard" %command%
:: %command%
@pause
goto finish

:testnmeachannel
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnmea.channel.test=true
goto :headlessconsole
:: goto finish

:headlessconsole
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -client -XX:NewSize=1024m -XX:MaxNewSize=1024m -Xmn1536m -Xms2048m -Xmx2048m -XX:SurvivorRatio=1 -XX:PermSize=30m -XX:+UseParallelGC
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -splash:"clipper.jpg"
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dwith.logger=true -Dwith.journal=true 
:: set JAVA_OPTIONS=
::
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dverbose=false
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless=yes
set /p adp=Admin HTTP Port (default 8080) ^> 
if [%adp%] == [] set adp=8080
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dadmin.http.port=%adp%
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless.gui=no
set option=N
set /p option=Char Console [n]^|y ^> 
if /i [%option%] == [Y] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dchar.console=true
) else (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dchar.console=false
)
set HL_GUI=N
set option=N
set /p option=GUI [n]^|y ^> 
if /i [%option%] == [Y] (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless.gui=yes
  set HL_GUI=Y
) else (
  set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless.gui=no
)
if /i [%HL_GUI%] == [N] (
  :: There are way more options to implement... the following options are a bit arbitrary.
  set option=N
  set /p option=Replay Logged Data [n]^|y ^> 
  ::
  echo Option [%option%]
  if /i [%option%] == [Y] (
    set JAVA_OPTIONS=%JAVA_OPTIONS% -Dlogged.nmea.data=D:\OlivSoft\all-scripts\logged-data\2010-11-08.Nuku-Hiva-Tuamotu.nmea
  ) else (
    :: Read other channel?
    set option=N
    set /p option=Read from TCP [n]^|y ^> 
    if /i [%option%] == [Y] (
      set JAVA_OPTIONS=%JAVA_OPTIONS% -Dhostname=localhost
      set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnet.transport=TCP
      set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnet.port=7001
    )
  )
  ::
  set HEADLESS_OPTIONS=
  set option=N
  set /p option=Rebroadcast on HTTP [n]^|y ^> 
  if /i [%option%] == [Y] (
    set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=HTTP:9999
  )
  set option=N
  set /p option=Rebroadcast on TCP  [n]^|y ^> 
  if /i [%option%] == [Y] (
    set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=TCP:7001
  )
  set option=N
  set /p option=Rebroadcast on UDP  [n]^|y ^> 
  if /i [%option%] == [Y] (
    set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=UDP:230.0.0.1:8001
  )
)
if /i [%ALL_NOTIFICATIONS%] == [Y] set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnotifications=all
:: set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=FILE:.\logged-data\headless.nmea
set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %HEADLESS_OPTIONS% 
:: echo Executing %COMMAND%
start "Headless Console" %COMMAND% 
:: %COMMAND% > hc.log 2>hc.err.log
:: %COMMAND%
:: pause
if /i [%direct%] == [N] pause
goto finish

:headlessconsole-ue
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -client -XX:NewSize=1024m -XX:MaxNewSize=1024m -Xmn1536m -Xms2048m -Xmx2048m -XX:SurvivorRatio=1 -XX:PermSize=30m -XX:+UseParallelGC
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -splash:"clipper.jpg"
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dwith.logger=true -Dwith.journal=true 
:: set JAVA_OPTIONS=
::
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dverbose=false
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless=yes
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless.gui=yes
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dlogged.nmea.data=D:\OlivSoft\all-scripts\logged-data\2010-11-08.Nuku-Hiva-Tuamotu.nmea
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dlogged.nmea.data=D:\OlivSoft\all-scripts\logged-data\headless.nmea
::
if /i [%ALL_NOTIFICATIONS%] == [Y] set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnotifications=all
set HEADLESS_OPTIONS=-output=HTTP:9999
set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=TCP:7001
set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=UDP:230.0.0.1:8001
:: set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=FILE:.\logged-data\headless.nmea
:: set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %HEADLESS_OPTIONS% -ue:olivsoftdesktopuserexits.DesktopEmailSender
::
set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -ue:olivsoftdesktopuserexits.ws.WSUserExit
:: set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %HEADLESS_OPTIONS% -ue:olivsoftdesktopuserexits.WindWatcher
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dcustom.nmea.parser=olivsoftdesktopuserexits.coreutilities.sample.CustomRNDParser
:: set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %HEADLESS_OPTIONS% -ue:olivsoftdesktopuserexits.coreutilities.sample.CustomSentenceInsertion
set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %HEADLESS_OPTIONS% 
:: echo CP=%CP%
:: echo Starting %COMMAND%
start "Headless Console (User-Exit)" %COMMAND%
if /i [%direct%] == [N] pause
goto finish

:headlessconsole-help
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dverbose=false
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless=yes
:: add -h as a parameter for some help...
java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop -h
if /i [%direct%] == [N] pause
goto finish

:pref-cli
set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.PreferencesCLI
%COMMAND%
:: %COMMAND%
if /i [%direct%] == [N] pause
goto finish

:headlessupdate
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -client -XX:NewSize=1024m -XX:MaxNewSize=1024m -Xmn1536m -Xms2048m -Xmx2048m -XX:SurvivorRatio=1 -XX:PermSize=30m -XX:+UseParallelGC
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -splash:"clipper.jpg"
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dwith.logger=true -Dwith.journal=true 
:: set JAVA_OPTIONS=
::
echo Warning: Using Proxy
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dhttp.proxyHost=www-proxy.us.oracle.com  -Dhttp.proxyPort=80 -Dhttp.nonProxyHosts=localhost
::
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dverbose=false
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dheadless=yes
if /i [%ALL_NOTIFICATIONS%] == [Y] set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnotifications=all
set HEADLESS_OPTIONS=--check-update
:: set HEADLESS_OPTIONS=%HEADLESS_OPTIONS% -output=FILE:.\logged-data\headless.nmea
set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %HEADLESS_OPTIONS%
%COMMAND%
:: %COMMAND%
if /i [%direct%] == [N] pause
goto finish

:desktop 
::@echo Prm: %1
if not [%1] == [] (
 set JAVA_OPTIONS=%JAVA_OPTIONS% -Dswing.defaultlaf=%1
)
set lng=
if [%DIRECTION%] == [] (
  set /p lng=[E] for English, [F] for France, [C] for Canada, [D] for Germany, [A] for Austria, [S] for Spain ?  ^>  
  set /p verbose=Verbose ?       y^|[n] ^>  
  set /p wproxy=With Proxy ?    y^|[n] ^>  
) else (
  set lng=N
)
if [%lng%] == [] set lng=N
if [%verbose%] == [] set verbose=N
::  
:: if /i [%lng%] == [Y] set JAVA_OPTIONS=-Duser.language=fr -Duser.country=FR %JAVA_OPTIONS% 
if /i [%lng%] == [E] set JAVA_OPTIONS=-Duser.language=en -Duser.country=US %JAVA_OPTIONS% 
if /i [%lng%] == [F] set JAVA_OPTIONS=-Duser.language=fr -Duser.country=FR %JAVA_OPTIONS% 
if /i [%lng%] == [C] set JAVA_OPTIONS=-Duser.language=fr -Duser.country=CA %JAVA_OPTIONS% 
if /i [%lng%] == [D] set JAVA_OPTIONS=-Duser.language=de -Duser.country=DE %JAVA_OPTIONS% 
if /i [%lng%] == [A] set JAVA_OPTIONS=-Duser.language=de -Duser.country=AT %JAVA_OPTIONS% 
if /i [%lng%] == [S] set JAVA_OPTIONS=-Duser.language=es -Duser.country=ES %JAVA_OPTIONS% 
::
if /i [%wproxy%] == [Y] set JAVA_OPTIONS=%JAVA_OPTIONS% -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80
:: set LNF=com.birosoft.liquid.LiquidLookAndFeel
:: set LNF=javax.swing.plaf.metal.MetalLookAndFeel
:: set LNF=net.sourceforge.napkinlaf.NapkinLookAndFeel
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dswing.defaultlaf=%LNF%
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -client -XX:NewSize=1024m -XX:MaxNewSize=1024m -Xmn1536m -Xms2048m -Xmx2048m -XX:SurvivorRatio=1 -XX:PermSize=30m -XX:+UseParallelGC
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -client
set JAVA_OPTIONS=%JAVA_OPTIONS% -splash:"clipper.jpg"
set JAVA_OPTIONS=%JAVA_OPTIONS% -Dwith.logger=true -Dwith.journal=true 
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnmea.ui.viewer.BulkPanel.verbose=true -Docss.nmea.api.NMEAReader.verbose=true -Dnmea.server.datareader.CustomNMEAClient$1.verbose=true -Dnmea.ui.NMEAMasterPanel$1.verbose=true
:: set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnmea.ui.viewer.BulkPanel.verbose=true -Docss.nmea.api.NMEAReader.verbose=true -Dnmea.ui.NMEAMasterPanel$1.verbose=true
if /i [%ALL_NOTIFICATIONS%] == [Y] set JAVA_OPTIONS=%JAVA_OPTIONS% -Dnotifications=all
:: start /min /wait java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop
:: start /min java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop
:: echo %CP%
::
:: java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop -ue:olivsoftdesktopuserexits.StellariumPosition -ue:olivsoftdesktopuserexits.ws.WSUserExit
if [%RAW%] == [false] (
  set UE=-ue:olivsoftdesktopuserexits.StellariumPosition
  set UE=%UE% -ue:olivsoftdesktopuserexits.coreutilities.sample.TrueWindSentenceInsertion
  set UE=%UE% -ue:olivsoftdesktopuserexits.LongTimeCurrentCalculator
)
set COMMAND=java %JAVA_OPTIONS% -classpath %CP% olivsoftdesktop.OlivSoftDesktop %UE%
echo %COMMAND%
%COMMAND%
if /i [%direct%] == [N] pause
goto eos
::
:displayBanner
:: made with http://www.network-science.de/ascii/
echo   ___  _ _        ____         __ _   
echo  / _ \^| (_)_   __/ ___^|  ___  / _^| ^|_ 
echo ^| ^| ^| ^| ^| \ \ / /\___ \ / _ \^| ^|_^| __^|
echo ^| ^|_^| ^| ^| ^|\ V /  ___) ^| (_) ^|  _^| ^|_ 
echo  \___/^|_^|_^| \_/  ^|____/ \___/^|_^|  \__^|
goto eos
::
:: The End
:finish
:: if /i [%direct%] == [Y] exit
:eos
