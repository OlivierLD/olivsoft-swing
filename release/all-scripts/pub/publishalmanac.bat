@echo off
@setlocal
@echo %*
set OLIVSOFT_HOME=..\..
::
cd %~dp0
set CP=%OLIVSOFT_HOME%\build\libs\release-4.0.0.0-all.jar
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\orai18n-collation.jar
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\orai18n-mapping.jar
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\fnd2.zip
set CP=%CP%;%OLIVSOFT_HOME%\all-3rd-party\xdo-0301.jar
::
set XSL_STYLESHEET=.\data2fop_2pages.xsl
:: set XSL_STYLESHEET=.\data2fop_2pages.no.sha.xsl
set LANG=%1
set WITH_STARS=%2
if [%LANG%] == [FR] (
  echo On parle francais
  set PRM_OPTION=-docconf .\lang_fr.cfg 
  if [%WITH_STARS%] == [false] set PRM_OPTION=-docconf .\lang_fr_ns.cfg 
  copy literals_fr.xsl literals.xsl  
) else (
  echo Will speak English
  copy literals_en.xsl literals.xsl
  set PRM_OPTION=-docconf .\lang_en.cfg 
  if [%WITH_STARS%] == [false] set PRM_OPTION=-docconf .\lang_en_ns.cfg 
)
@echo Publishing
@echo %PRM_OPTION%
set begintime=%time%
@java -Xms256m -Xmx1024m -classpath %CP% oracle.apps.xdo.template.FOProcessor %PRM_OPTION% -xml %3 -xsl %XSL_STYLESHEET% -pdf %4
:: @java -Xms256m -Xmx1024m -classpath %CP% oracle.apps.xdo.template.FOProcessor %PRM_OPTION% -xml %3 -xsl %XSL_STYLESHEET% -rtf %4
set finishtime=%time%
call :timediff %begintime% %finishtime%
::@echo.
@echo Done calculating at %finishtime%, it took %timetaken% sec. Now displaying.
call %4
exit
:: goto eos
::
:timediff
:: echo from [%1] to [%2]
set starttime=%1
set endtime=%2
if [%starttime:~1,1%] == [:] set starttime=0%starttime%
if [%endtime:~1,1%] == [:] set endtime=0%endtime%
set startcsec=%starttime:~9,2%
set startsecs=%starttime:~6,2%
set startmins=%starttime:~3,2%
set starthour=%starttime:~0,2%
:: Remove leading 0 (considered as octal numbers)
call :removeLeadingZero %startcsec%
set startcsec=%truncated%
call :removeLeadingZero %startsecs%
set startsecs=%truncated%
call :removeLeadingZero %startmins%
set startmins=%truncated%
call :removeLeadingZero %starthour%
set starthour=%truncated%
::
set /a starttime=(%starthour%*60*60*100)+(%startmins%*60*100)+(%startsecs%*100)+(%startcsec%)
::
set endcsec=%endtime:~9,2%
set endsecs=%endtime:~6,2%
set endmins=%endtime:~3,2%
set endhour=%endtime:~0,2%
:: Remove leading 0 (considered as octal numbers)
call :removeLeadingZero %endcsec% 
set endcsec=%truncated%
call :removeLeadingZero %endsecs%
set endsecs=%truncated%
call :removeLeadingZero %endmins%
set endmins=%truncated%
call :removeLeadingZero %endhour%
set endhour=%truncated%
::
if %endhour% LSS %starthour% set /a endhour+=24
set /a endtime=(%endhour%*60*60*100)+(%endmins%*60*100)+(%endsecs%*100)+(%endcsec%)
set /a timetaken= ( %endtime% - %starttime% )
set /a timetakens= %timetaken% / 100
set timetaken=%timetakens%.%timetaken:~-2%
goto eos
::
:removeLeadingZero
set truncated=%1
:top
if not [%truncated:~1%] == [] (
  if [%truncated:~0,1%] == [0] (
    set truncated=%truncated:~1%
    goto top
  )
)
:: if not [%1] == [%truncated%] @echo [%1] becomes [%truncated%]
goto eos
:: End Of Script
:eos
@endlocal
