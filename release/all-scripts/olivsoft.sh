#!/bin/bash
# export PATH=$JAVA_HOME/bin:$PATH
export PATH=`which java | awk '{ print substr($1, 0, length($1) - length("/java")) }'`:$PATH
# echo PATH is $PATH
CP="."
CP=$CP:../build/libs/release-4.0.0.0-all.jar
#for JARFILE in ../all-3rd-party/*.jar
#do
#  CP=$CP:$JARFILE
#done
#for JARFILE in ../all-libs/*.jar
#do 
#  CP=$CP:$JARFILE
#done
#for JARFILE in ../all-extras/*.jar
#do
#  CP=$CP:$JARFILE
#done
#for JARFILE in ../all-user-exits/*.jar
#do
#  CP=$CP:$JARFILE
#done
CP=$CP:../all-3rd-party/rxtx.distrib/RXTXcomm.jar
# CP=$CP:/usr/share/java/RXTXcomm.jar
# echo CLASSPATH=$CP; read dum
#
function nocase() {
  if [[ "`echo $1 | tr [:lower:] [:upper:]`" = "`echo $2 | tr [:lower:] [:upper:]`" ]]
  then
    return 0  # true
  else
    return 1 # false
  fi
}
EXIT=false
#
MAYBE_RPI=false
#
ARM=`uname -a | grep arm`
echo \[${ARM}\]
if [[ "$ARM" == "" ]]
then
  MAYBE_RPI=false
else
  MAYBE_RPI=true
fi
#
while [[ "$EXIT" == "false" ]]
do
  clear
  # made with http://www.network-science.de/ascii/
  echo -e '  ___  _ _        ____         __ _'
  echo -e ' / _ \| (_)_   __/ ___|  ___  / _| |_'
  echo -e '| | | | | \ \ / /\___ \ / _ \| |_| __|'
  echo -e '| |_| | | |\ V /  ___) | (_) |  _| |_'
  echo -e ' \___/|_|_| \_/  |____/ \___/|_|  \__|'
  if [[ ${MAYBE_RPI} == true ]]
  then
    echo -e '+-------------------------------------------+'
    echo Note: If you run on a Raspberry PI, you might want to modify this
    echo script \($0\) to add sudo privilege to java.
    echo If you really don\'t know, use olivier@lediouris.net :\)
  fi
  echo -e '+-------------------------------------------+'
  echo -e '|  J for Java version                       |'
  echo -e '|  W for Weather Wizard                     |'
  echo -e '|  WH for Weather Wizard, headless          |'
  echo -e '|  KW for Stop Headless Weather Wizard      |'
# echo -e '|  L for Weather Wizard, with Plastic L&F   |'
  echo -e '|  M for Weather Wizard, with Metal L&F     |'
# echo -e '|  N for Weather Wizard, with Napkin L&F    |'
  echo -e '|  P for Weather Wizard, with http proxy    |'
  echo -e '|  S for NMEA Sniffer                       |'
  echo -e '|  HC for Headless NMEA Console             |'
  echo -e '|  KC for Stop Headless Console             |'
  echo -e '|  HU for Headless Update                   |'
  echo -e '|  POL for Polar Tool                       |'
  echo -e '|  D for Desktop                            |'
  echo -e '+-------------------------------------------+'
  echo -e '| Q for Quit                                |'
  echo -e '+-------------------------------------------+'
#
  echo -n 'You choose : '
  read choice
  if nocase "$choice" "J"
  then
    java -version
    echo [Hit return to continue...]
    read a
  elif nocase "$choice" "W"
  then
    echo $CP
    sudo java -Djava.library.path=/usr/lib/jni -client -splash:"clipper.jpg" -classpath ${CP} main.splash.Splasher
#   java -client -Xms512m -Xmx1024m -splash:"clipper.jpg" -classpath $CP main.splash.Splasher
    echo Hit [Return]
    read a
  elif nocase "$choice" "WH"
  then
#   echo $CP
#   echo Attention: Changing the DISPLAY value: was $DISPLAY, setting it to :0.0
#   DISPLAY=:0.0
#
# The code below does the following:
#  It loads the composites mentioned in PRM1 every 6 hours (360 min, as in PRM2). The storage format is given in PRM3
#  In addition, it sends en ephemeris email every day at 5am
#   For that one, see ephemeris.email.properties, and set the preferences in the Headless category of the WeatherWizard preferences.
#    -> Modify ephemeris.email.properties_template (in this directory), and rename it ephemeris.email.properties
# See the doc for details.
#
    PRM1=-composite:./patterns/01.Favorites/01.3.00.Pacific.Sfc.500.Tropic.GRIB.ptrn,./patterns/00.Micro.patterns/AlaskaGulfNorth.ptrn,./patterns/01.Favorites/06.01.AllPac.Faxes.Satellite.ptrn
    PRM2=-interval:360
    PRM3="-pattern:/yyyy/MM-MMM | | yyyy_MM_dd-HHmmss_z | _Pacific | waz,/yyyy/MM-MMM | | yyyy_MM_dd-HHmmss_z | _Alaska | waz,/yyyy/MM-MMM | | yyyy_MM_dd-HHmmss_z | _PacSatPic | waz"
#
    JAVA_OPTS="-Djava.library.path=/usr/lib/jni"
    JAVA_OPTS="$JAVA_OPTS -client"
    JAVA_OPTS="$JAVA_OPTS -classpath $CP"
    JAVA_OPTS="$JAVA_OPTS -Dheadless=true"
    JAVA_OPTS="$JAVA_OPTS -Dephemeris.email=true"
    JAVA_OPTS="$JAVA_OPTS -Dstart.loop.at=21:00"
    JAVA_OPTS="$JAVA_OPTS -Dstart.ephemeris.loop.at=05:00"
    JAVA_OPTS="$JAVA_OPTS -DdeltaT=68.3964"
#
    java $JAVA_OPTS main.splash.Splasher ${PRM1} ${PRM2} "${PRM3}"
#   echo Output is in wh.log
    echo Hit [Return]
    read a
  elif nocase "$choice" "L"
  then
    java -splash:"clipper.jpg" Djava.library.path=/usr/lib/jni -Dswing.defaultlaf=com.jgoodies.looks.plastic.Plastic3DLookAndFeel -classpath ${CP} main.splash.Splasher
  elif nocase "$choice" "M"
  then
#   java -Xms512m -Xmx512m -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -Djava.library.path=/usr/lib/jni -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath $CP main.splash.Splasher
    java -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -classpath ${CP} main.splash.Splasher
  echo -n Hit Return
  read a
  elif nocase "$choice" "N"
  then
    java --Djava.library.path=/usr/lib/jni -splash:"clipper.jpg" -Dswing.defaultlaf=net.sourceforge.napkinlaf.NapkinLookAndFeel -classpath ${CP} main.splash.Splasher
  elif nocase "$choice" "P"
  then
    java -splash:"clipper.jpg" -Djava.library.path=/usr/lib/jni -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath ${CP} main.splash.Splasher
  elif nocase "$choice" "D"
  then
    sudo java -Djava.library.path=/usr/lib/jni -Dwith.journal=true -Dwith.logger=true -classpath ${CP} olivsoftdesktop.OlivSoftDesktop -ue:olivsoftdesktopuserexits.sample.TrueWindSentenceInsertion
    echo [Return]
    read a
  elif nocase "$choice" "HC"
  then
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
    JAVA_OPTIONS="$JAVA_OPTIONS -Djava.library.path=/usr/lib/jni"
    GUI=false
    echo -n 'With GUI [n]|y ? > '
    read a
    if nocase "$a" "Y"
    then
      GUI=true
    fi
    if [[ "$GUI" == "true" ]]
    then
      JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless.gui=yes"
    else
      echo -n 'Verbose ? [n]|y > '
      read a
      if nocase "$a" "Y"
      then
        JAVA_OPTIONS="$JAVA_OPTIONS -Dverbose=true"
      else
        JAVA_OPTIONS="$JAVA_OPTIONS -Dverbose=false"
      fi
      SERIAL_PORT=/dev/ttyUSB0
      # SERIAL_PORT=/dev/ttyAMA0
      echo -n "Read serial Port ($SERIAL_PORT) ? y|[n] > "
      read a
      if [[ "$a" == "y" ]] || [[ "$a" == "Y" ]]
      then
        echo -n 'Set Baud rate to 4800 ? [y]|n > '
        read br
        if nocase "$br" "N"
        then
          echo -n 'Enter new baud rate > '
          read BAUDRATE
          JAVA_OPTIONS="$JAVA_OPTIONS -Dbaud.rate=$BAUDRATE"
        fi
        echo Reading $SERIAL_PORT
        JAVA_OPTIONS="$JAVA_OPTIONS -Dserial.port=$SERIAL_PORT"
      else
        echo -n 'Replay logged data ? y|[n] > '
        read a
        if nocase "$a" "Y"
        then
          JAVA_OPTIONS="$JAVA_OPTIONS -Dlogged.nmea.data=./logged-data/2010-11-08.Nuku-Hiva-Tuamotu.nmea"
        fi
      fi
      #
      HEADLESS_OPTIONS=
      HEADLESS_OPTIONS=-ue:olivsoftdesktopuserexits.sample.TrueWindSentenceInsertion
      echo -n 'Rebroadcast on http:9999 y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=HTTP:9999"
      fi
      echo -n 'Rebroadcast on tcp:7001 y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=TCP:7001"
      fi
      echo -n 'Rebroadcast on udp:8001 y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=UDP:230.0.0.1:8001"
      fi
      echo -n 'Log the data in ./logged-data/headless.nmea y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=FILE:./logged-data/headless.nmea"
      fi
    fi
    # echo Classpath is [$CP]
    # echo Java options are $JAVA_OPTIONS
    WITH_HELP=""
    echo -n 'Display help (and quit) y|[n] ? > '
    read a
    if nocase "$a" "Y"
    then
      WITH_HELP="-h"
    fi
    echo -n 'With UserExit [W] WindWatcher [N] NMEASensor [S] Stellarium [] None > '
    read a
    if nocase "$a" "W"
    then
      echo Loading User-Exit "WindWatcher"
      java -client -classpath ${CP} ${JAVA_OPTIONS} olivsoftdesktop.OlivSoftDesktop ${WITH_HELP} -ue:olivsoftdesktopuserexits.WindWatcher ${HEADLESS_OPTION}S &
    elif nocase "$a" "N"
    then
      echo Loading User-Exit "NMEASensor"-
      CP=${CP}:/opt/pi4j/lib/pi4j-core.jar
      sudo java -client -classpath ${CP} ${JAVA_OPTIONS} olivsoftdesktop.OlivSoftDesktop ${WITH_HELP} -ue:olivsoftdesktopuserexits.Sensor2NMEA ${HEADLESS_OPTIONS} &
    elif nocase "$a" "S"
    then
      echo Loading User-Exit "Stellarium"
      sudo java -client -classpath ${CP} ${JAVA_OPTIONS} olivsoftdesktop.OlivSoftDesktop ${WITH_HELP} -ue:olivsoftdesktopuserexits.StellariumPosition ${HEADLESS_OPTIONS} &
    else
      echo Loading NO User-Exit
      echo ${HEADLESS_OPTIONS}
      sudo java -client -classpath ${CP} ${JAVA_OPTIONS} olivsoftdesktop.OlivSoftDesktop ${WITH_HELP} ${HEADLESS_OPTIONS} &
    fi
    echo Hit [Return]
    read a
  elif nocase "$choice" "KC"
  then
    # Kills the headless console
    echo Terminating the Headless Console:
    PID=`ps -ef | grep -v grep | grep Dheadless=yes | awk '{ print $2 }'`
    if [ "$PID" != "" ]
    then
      echo Killing process ${PID}
      sudo kill -SIGTERM ${PID}
    else
      echo Found no console...
    fi
    echo Hit [return]
    read a
  elif nocase "$choice" "KW"
  then
    # Kills the headless console
    echo Terminating the Headless Console:
    PID=`ps -ef | grep -v grep | grep 'Dheadless=true.*Splasher' | awk '{ print $2 }'`
    if [[ "$PID" != "" ]]
    then
      echo Killing process ${PID}
      kill -SIGTERM ${PID}
    else
      echo Found no headless weather wizard...
    fi
    echo Hit [return]
    read a
  elif nocase "$choice" "HU"
  then
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
    java -client -classpath ${CP} ${JAVA_OPTIONS} olivsoftdesktop.OlivSoftDesktop --check-update
    echo Hit [return]
    read a
  elif nocase "$choice" "S"
  then
    JAVA_OPT="-Dverbose=false"
    sudo java -Djava.library.path=/usr/lib/jni ${JAVA_OPT} -classpath $CP nmeasniffer.gui.NMEASniffer
    echo Hit [Return]
    read a
  elif nocase "$choice" "POL"
  then
    java -classpath ${CP} polarmaker.polars.main.PolarSmoother
  elif nocase "$choice" "Q"
  then
    EXIT=true
  else
    echo Command \[${choice}\] Not supported yet..., hit [return]
    read a
  fi
done
echo Bye now...
