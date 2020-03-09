#!/bin/bash
# cd /home/oracle/oliv/all-scripts
# export JAVA_HOME=/oracle/javahome/jrockit-jdk1.6.0_29-R28.2.0-4.0.1/jre
# export PATH=$JAVA_HOME/bin:$PATH
export PATH=`which java | awk '{ print substr($1, 0, length($1) - length("/java")) }'`:$PATH
# echo PATH is $PATH
CP=""
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
#
PI4J_HOME=/opt/pi4j
#CP=$CP:../all-3rd-party/rxtx.distrib/RXTXcomm.jar
CP=$CP:/usr/share/java/RXTXcomm.jar
# echo CLASSPATH=$CP
#
function nocase()
{
  if [ "`echo $1 | tr [:lower:] [:upper:]`" = "`echo $2 | tr [:lower:] [:upper:]`" ]
  then
    return 0  # true
  else
    return 1 # false
  fi
}
#
DIRECT=false
if [ "$1" != "" ]
then
  choice=$1
  DIRECT=true
fi
#
GRAPHIC=false
EXIT=false
while [ "$EXIT" = "false" ]
do
  clear
  if [ "$DIRECT" = "false" ]
  then
    if [ "$GRAPHIC" = "true" ]
    then
      echo -e '\e(0\x6c\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x6b\e(B'
      echo -e '\e(0\x78\e(B WH Weather Wizard, headless     \e(0\x78\e(B'
      echo -e '\e(0\x78\e(B KW Stop Headless Weather Wizard \e(0\x78\e(B'
      echo -e '\e(0\x78\e(B S  NMEA Sniffer                 \e(0\x78\e(B'
      echo -e '\e(0\x78\e(B HC Headless NMEA Console        \e(0\x78\e(B'
      echo -e '\e(0\x78\e(B KC Stop Headless Console        \e(0\x78\e(B'
      echo -e '\e(0\x78\e(B HU Headless Update              \e(0\x78\e(B'
      echo -e '\e(0\x74\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x75\e(B'  
      echo -e '\e(0\x78\e(B Q Quit                          \e(0\x78\e(B'          
      echo -e '\e(0\x6d\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x71\e(B\e(0\x6a\e(B'
    else
#     echo -e 'Warning: Sensors require Admin priv.'
      echo -e '+--- S M A L L   C O N S O L E ----+'
      echo -e '| WH  Weather Wizard, headless     |'
      echo -e '| KW  Stop Headless Weather Wizard |'
      echo -e '| S   NMEA Sniffer                 |'
      echo -e '| HC[?] Headless NMEA Console      |'
      echo -e '| HCB Headless NMEA (-> TCP/HTTP)  |'
      echo -e '| HCC Char. NMEA Console (<-TCP)   |'
      echo -e '| KC  Stop Headless Console        |'
      echo -e '| HU  Headless Update              |'
      echo -e '| CLI Preferences CLI              |'
      echo -e '| Q   Quit                         |'          
      echo -e '+----------------------------------+'
    fi    
#
    echo -n 'You choose : '
    read choice
  else
    EXIT=true
  fi
# if [ "$choice" = "J" ] || [ "$choice" = "j" ] 
  if nocase "$choice" "J"
  then
    java -version
    echo -n [Hit return to continue...]
    read a
  elif nocase "$choice" "W"
  then
#   echo $CP
    java -Djava.library.path=/usr/lib/jni -client -splash:"clipper.jpg" -classpath $CP main.splash.Splasher
#   java -client -Xms512m -Xmx1024m -splash:"clipper.jpg" -classpath $CP main.splash.Splasher
    echo -n Hit [Return]
    read a
  elif nocase "$choice" "WH"
  then
#   echo $CP
#   echo Attention: Changing the DISPLAY value: was $DISPLAY, setting it to :0.0
#   DISPLAY=:0.0
    PRM1=-composite:./patterns/01.Favorites/01.3.00.Pacific.Sfc.500.Tropic.GRIB.ptrn
    PRM2=-interval:360
    PRM3="-pattern:/yyyy/MM-MMM | Auto_ | yyyy_MM_dd_HH_mm_ss_z | waz"
    java -Djava.library.path=/usr/lib/jni -client -classpath $CP -Dheadless=true main.splash.Splasher $PRM1 $PRM2 "$PRM3" > wh.log &2>1 &
    echo Output is in wh.log
    echo -n Hit [Return]
    read a
  elif nocase "$choice" "L"
  then
    java -splash:"clipper.jpg" Djava.library.path=/usr/lib/jni -Dswing.defaultlaf=com.jgoodies.looks.plastic.Plastic3DLookAndFeel -classpath $CP main.splash.Splasher
  elif nocase "$choice" "M"
  then
#   java -Xms512m -Xmx512m -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -Djava.library.path=/usr/lib/jni -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath $CP main.splash.Splasher
    java -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -classpath $CP main.splash.Splasher
  echo -n Hit Return
  read a
  elif nocase "$choice" "N"
  then
    java -Djava.library.path=/usr/lib/jni -splash:"clipper.jpg" -Dswing.defaultlaf=net.sourceforge.napkinlaf.NapkinLookAndFeel -classpath $CP main.splash.Splasher
  elif nocase "$choice" "P"
  then
    java -splash:"clipper.jpg" -Djava.library.path=/usr/lib/jni -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath $CP main.splash.Splasher
  elif nocase "$choice" "D"
  then
    java -Djava.library.path=/usr/lib/jni -Dwith.journal=true -Dwith.logger=true -classpath $CP olivsoftdesktop.OlivSoftDesktop
    echo [Return]
    read a
  elif nocase "$choice" "HC"
  then
    JAVA_OPTIONS=""
    echo -n "Test NMEA input only [n]|y ? > "
    read a
    if nocase "$a" "Y"
    then
      JAVA_OPTIONS="-Dnmea.channel.test=true"
    fi
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
#   JAVA_OPTIONS="$JAVA_OPTIONS -Due.verbose=true"
    JAVA_OPTIONS="$JAVA_OPTIONS -Doriginal.cache=true"
    JAVA_OPTIONS="$JAVA_OPTIONS -Djava.library.path=/usr/lib/jni"
    CHAR=false
    echo -n 'With Char Console [n]|y ? > '
    read a
    if nocase "$a" "Y"
    then
      CHAR=true
    fi
    if [ "$CHAR" = "true" ]
    then
      JAVA_OPTIONS="$JAVA_OPTIONS -Dchar.console=true"
    fi
    GUI=false
    echo -n 'With GUI [n]|y ?          > '
    read a
    if nocase "$a" "Y"
    then
      GUI=true
    fi
    if [ "$GUI" = "true" ]
    then
      JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless.gui=yes -Dsmall.ui=true"
    else
      echo -n 'Verbose ? [n]|y           > '
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
      if [ "$a" = "y" ] || [ "$a" = "Y" ]
      then
        echo Reading $SERIAL_PORT
        JAVA_OPTIONS="$JAVA_OPTIONS -Dserial.port=$SERIAL_PORT"
      else
        echo -n 'Replay logged data (Nuku-Hiva - Rangi) ? y|[n] > '
        read a
        if nocase "$a" "Y"
        then
          JAVA_OPTIONS="$JAVA_OPTIONS -Dlogged.nmea.data=./logged-data/2010-11-08.Nuku-Hiva-Tuamotu.nmea"
        fi
      fi
      #
      JAVA_OPTIONS="$JAVA_OPTIONS -Dadmin.http.port=8888"
      HEADLESS_OPTION=
      ENABLE_OUTPUT=,true
      echo -n 'All output enabled (Admin Server) ? [y]|n > '
      read a
      if nocase "$a" "N"
      then
        ENABLE_OUTPUT=,false
      fi
      echo -n 'Rebroadcast on http:9999 y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=HTTP:9999$ENABLE_OUTPUT"
      fi
      echo -n 'Rebroadcast on tcp:7001 y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=TCP:7001$ENABLE_OUTPUT"
      fi
      echo -n 'Rebroadcast on udp:8001 y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=UDP:230.0.0.1:8001$ENABLE_OUTPUT"
      fi
      echo -n 'Log the data in ./logged-data/headless.nmea y|[n] > '
      read a
      if nocase "$a" "Y"
      then
        HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=FILE:./logged-data/headless.nmea$ENABLE_OUTPUT"
        JAVA_OPTIONS="$JAVA_OPTIONS -Dlog.fmt=json"
        JAVA_OPTIONS="$JAVA_OPTIONS -Dlog.with.time=true"
      fi
    fi
    # echo Classpath is [$CP]
    # echo Java options are $JAVA_OPTIONS
    UE=''
    echo -n 'True Wind insertion [n]|y ? > '
    read a
    if nocase  "$a" "Y"
    then
      UE='-ue:olivsoftdesktopuserexits.sample.TrueWindSentenceInsertion'
    fi
    echo 'Choose your user-exits:'
    DONE=false
    while [ "$DONE" = "false" ]
    do
      echo 'With UserExit:'
      if [[ $UE != *WindWatcher* ]]
      then
        echo '   [W]  WindWatcher '
      fi
      if [[ $UE != *Sensor2NMEA* ]]
      then
        echo '   [N]  NMEASensors '
      fi
      if [[ $UE != *FONA* ]]
      then
        echo '   [F]  FONA '
      fi
      if [[ $UE != *Voltage2NMEA* ]]
      then
        echo '   [B]  Battery Monitor '
      fi
      if [[ $UE != *CurrentCalculator* ]]
      then
        echo '   [C]  Current Calc '
      fi
#     if [[ $UE != *Stellarium* ]]
#     then
#       echo '   [S]  Stellarium '
#     fi
      if [[ $UE != *WSUserExit* ]]
      then
        echo '   [WS] WebSocket server '
      fi
      echo '   [] Done'
      echo -n ' You say > '
  #   echo -n 'With UserExit [W] WindWatcher [N] NMEASensors [S] Stellarium [] None > '
      read a
      if nocase  "$a" "W"
      then
        echo Loading User-Exit "WindWatcher"
        UE="$UE -ue:olivsoftdesktopuserexits.WindWatcher"
      elif nocase  "$a" "F"
      then
        echo Loading User-Exit "FONA"
        CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
        UE="$UE -ue:olivsoftdesktopuserexits.FONAUserExit"
      elif nocase "$a" "N"
      then
        echo Loading User-Exit "NMEASensors"
        UE="$UE -ue:olivsoftdesktopuserexits.Sensor2NMEA"
        CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
        JAVA_OPTIONS="$JAVA_OPTIONS -DBMP180=y"
        JAVA_OPTIONS="$JAVA_OPTIONS -DHTU21DF=y"
      elif nocase "$a" "B"
      then
        echo Loading User-Exit "Battery Monitor"
        UE="$UE -ue:olivsoftdesktopuserexits.Voltage2NMEA"
        CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
        JAVA_OPTIONS="$JAVA_OPTIONS -Dtune=973:14"
      elif nocase "$a" "C"
      then
        echo Loading User-Exit "Current Calc"
        UE="$UE -ue:olivsoftdesktopuserexits.LongTimeCurrentCalculator"
        JAVA_OPTIONS="$JAVA_OPTIONS -Dbuffer.length=300000"
#     elif nocase "$a" "S"
#     then
#       echo Loading User-Exit "Stellarium"
#       UE="$UE -ue:olivsoftdesktopuserexits.StellariumPosition"
      elif nocase "$a" "WS"
      then
        echo Loading User-Exit "WebSocket"
        UE="$UE -ue:olivsoftdesktopuserexits.ws.WSUserExit"
        echo -ne 'verbose for WebSocket server ? [n]|y > '
        read resp 
        if nocase "$resp" "Y"
        then
          JAVA_OPTIONS="$JAVA_OPTIONS -Dws.verbose=true"
        fi
        echo -ne 'Start the WebSocket server? [n]|y > '
        read a
        if nocase "$a" "Y"
        then
          echo Starting Node.js
          cd html5
          /home/pi/node-v0.10.2-linux-arm-pi/bin/node server.js >node.log 2>&1 &
          cd -
        fi
      else
        echo Done with User-Exit 
        DONE=true
      fi
    done
    if [[ $JAVA_OPTIONS == *char.console* ]] # Contains chr.console
    then
      java -client -classpath $CP $JAVA_OPTIONS olivsoftdesktop.OlivSoftDesktop $UE $HEADLESS_OPTIONS 2> hc.log
    else
      COMMAND="java -client -classpath $CP $JAVA_OPTIONS olivsoftdesktop.OlivSoftDesktop $UE $HEADLESS_OPTIONS "
      # echo Running [$COMMAND]
      # read a
      $COMMAND &
    fi
    echo -n Hit [Return]
    read a
  elif nocase "$choice" "HCB"
  then
    JAVA_OPTIONS=""
#   JAVA_OPTIONS="$JAVA_OPTIONS -Dverbose=true"
#   JAVA_OPTIONS="$JAVA_OPTIONS -Ddesktop.verbose=true"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
    JAVA_OPTIONS="$JAVA_OPTIONS -Djava.library.path=/usr/lib/jni"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dchar.console=false"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless.gui=no"
    JAVA_OPTIONS="$JAVA_OPTIONS -Doriginal.cache=true"
    SERIAL_PORT=/dev/ttyUSB0
    BAUD_RATE=9600
    JAVA_OPTIONS="$JAVA_OPTIONS -Dserial.port=$SERIAL_PORT -Dbaud.rate=$BAUD_RATE"
    # JAVA_OPTIONS="$JAVA_OPTIONS -Dlogged.nmea.data=./logged-data/2010-11-08.Nuku-Hiva-Tuamotu.nmea"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dadmin.http.port=8888"
    if [ "$DIRECT" = "false" ]
    then
      echo -n INFO: Admin port is 8888 [Hit return]
      read x
    fi
    HEADLESS_OPTION=
    ENABLE_OUTPUT=,true
    HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=HTTP:9999$ENABLE_OUTPUT"
    HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=TCP:7001$ENABLE_OUTPUT"
    HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=FILE:./logged-data/headless.nmea$ENABLE_OUTPUT"
    if [ "$DIRECT" = "false" ]
    then
      echo -n 'Reset log file ? y|[n] > '
      read a
    else
      a=N
    fi
    if nocase "$a" "Y"
    then
      sudo rm ./logged-data/headless.nmea
      echo Log file reset.
    fi
    if [ "$DIRECT" = "false" ]
    then
      echo -n 'Pre-selected UserExits [y]|n ? > '
      read a
    else
      a=Y
    fi
    if nocase "$a" "N"
    then
      echo 'Choose your user-exits:'
      DONE=false
      UE=''
#     echo -n 'True Wind insertion [n]|y ? > '
#     read a
#     if nocase  "$a" "Y"
#     then
        UE='-ue:olivsoftdesktopuserexits.sample.TrueWindSentenceInsertion'
#       echo -ne 'verbose for True Wind Insertion ? [n]|y > '
#       read resp 
#       if nocase "$resp" "Y"
#       then
#         JAVA_OPTIONS="$JAVA_OPTIONS -Dtw.verbose=true"
#       fi
#     fi
      while [ "$DONE" = "false" ]
      do
        echo 'With UserExit:'
        if [[ $UE != *Sensor2NMEA* ]]
        then
          echo '   [N]  NMEASensors '
        fi
        if [[ $UE != *FONA* ]]
        then
          echo '   [F]  FONA '
        fi
        if [[ $UE != *Voltage2NMEA* ]]
        then
          echo '   [B]  Battery Monitor '
        fi
        if [[ $UE != *CurrentCalculator* ]]
        then
          echo '   [C]  Current Calc '
        fi
        if [[ $UE != *WSUserExit* ]]
        then
          echo '   [WS] WebSocket server '
        fi
        echo '   [] Done'
        echo -n ' You say > '
  #     echo -n 'With UserExit [W] WindWatcher [N] NMEASensors [S] Stellarium [] None > '
        read a
        if nocase "$a" "N"
        then
          echo Loading User-Exit "NMEASensors"
          UE="$UE -ue:olivsoftdesktopuserexits.Sensor2NMEA"
          CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
          JAVA_OPTIONS="$JAVA_OPTIONS -DBMP180=y"
          JAVA_OPTIONS="$JAVA_OPTIONS -DHTU21DF=y"
          echo -ne 'verbose for NMEA Sensors ? [n]|y > '
          read resp 
          if nocase "$resp" "Y"
          then
            JAVA_OPTIONS="$JAVA_OPTIONS -Dsensor.verbose=true"
            JAVA_OPTIONS="$JAVA_OPTIONS -Ddesktop.verbose=true"
  #         JAVA_OPTIONS="$JAVA_OPTIONS -Dsensor.register.verbose=true"
          fi
        elif nocase "$a" "B"
        then
          echo Loading User-Exit "Battery Monitor"
          UE="$UE -ue:olivsoftdesktopuserexits.Voltage2NMEA"
          CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
          JAVA_OPTIONS="$JAVA_OPTIONS -Dtune=973:14"
          echo -ne 'verbose for Battery Sensors ? [n]|y > '
          read resp 
          if nocase "$resp" "Y"
          then
            JAVA_OPTIONS="$JAVA_OPTIONS -Dbat.verbose=true"
          fi
        elif nocase "$a" "C"
        then
          echo Loading User-Exit "Current Calc"
          UE="$UE -ue:olivsoftdesktopuserexits.LongTimeCurrentCalculator"
          JAVA_OPTIONS="$JAVA_OPTIONS -Dbuffer.length=300000" # 5 minutes
          echo -ne 'verbose for Current Calculator ? [n]|y > '
          read resp 
          if nocase "$resp" "Y"
          then
            JAVA_OPTIONS="$JAVA_OPTIONS -Dcurrent.verbose=true" # Current
          fi
        elif nocase "$a" "F"
        then
          echo Loading User-Exit "FONA"
          CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
          UE="$UE -ue:olivsoftdesktopuserexits.FONAUserExit"
          echo -ne 'verbose for FONA ? [n]|y > '
          read resp 
          if nocase "$resp" "Y"
          then
            JAVA_OPTIONS="$JAVA_OPTIONS -Dfona.verbose=true"
          fi
        elif nocase "$a" "WS"
        then
          echo Loading User-Exit "WebSocket"
          UE="$UE -ue:olivsoftdesktopuserexits.ws.WSUserExit"
          echo -ne 'verbose for WebSocket server ? [n]|y > '
          read resp 
          if nocase "$resp" "Y"
          then
            JAVA_OPTIONS="$JAVA_OPTIONS -Dws.verbose=true"
          fi
          echo -ne 'Start the WebSocket server? [n]|y > '
          read a
          if nocase "$a" "Y"
          then
            echo Starting Node.js
            cd html5
#           /home/pi/node-v0.10.2-linux-arm-pi/bin/node server.js >node.log 2>&1 &
            node server.js >node.log 2>&1 &
            cd -
          fi
        else
          echo Done with User-Exit 
          DONE=true
        fi
      done
    else
      UE="-ue:olivsoftdesktopuserexits.sample.TrueWindSentenceInsertion"
      UE="$UE -ue:olivsoftdesktopuserexits.Sensor2NMEA"
      UE="$UE -ue:olivsoftdesktopuserexits.Voltage2NMEA"
      UE="$UE -ue:olivsoftdesktopuserexits.LongTimeCurrentCalculator"
      echo Loading: True Wind Insertion, NMEA Sensors, Battery and Current
      CP=$CP:$PI4J_HOME/lib/pi4j-core.jar
      JAVA_OPTIONS="$JAVA_OPTIONS -DBMP180=y"
      JAVA_OPTIONS="$JAVA_OPTIONS -DHTU21DF=y"
      JAVA_OPTIONS="$JAVA_OPTIONS -Dbuffer.length=300000" # 5 minutes
    fi
    COMMAND="java -client -classpath $CP $JAVA_OPTIONS olivsoftdesktop.OlivSoftDesktop $UE $HEADLESS_OPTIONS"
    # sudo $COMMAND
    if [ "$DIRECT" = "false" ]
    then
      echo -n INFO:Program log file is hcb.log. Hit [Return]
      read a
    fi
    echo Command is $COMMAND >hcb.log
    echo =================== >>hcb.log
    sudo $COMMAND >>hcb.log 2>&1 &
    if [ "$DIRECT" = "true" ]
    then
      echo "HCB is on its way."
    fi
  elif nocase "$choice" "HCC"
  then
    JAVA_OPTIONS=""
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
    JAVA_OPTIONS="$JAVA_OPTIONS -Djava.library.path=/usr/lib/jni"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dchar.console=true"
#   JAVA_OPTIONS="$JAVA_OPTIONS -Dcc.verbose=true"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless.gui=no"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dhostname=localhost"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dnet.transport=TCP"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dnet.port=7001"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dadmin.http.port=7777"
    JAVA_OPTIONS="$JAVA_OPTIONS -Doriginal.cache=false"
    echo Warning: No Calculated Current will be available, just VDR
    echo -n Admin Port is 7777 [Hit return]
    read x
    # echo Classpath is [$CP]
    # echo Java options are $JAVA_OPTIONS
    java -client -classpath $CP $JAVA_OPTIONS olivsoftdesktop.OlivSoftDesktop $HEADLESS_OPTIONS 2>hcc.log
    # echo -n Hit [Return]
    # read a
  elif nocase "$choice" "KC"
  then
    # Kills the headless console
    echo Terminating the Headless Console:
    PID=`ps -ef | grep -v grep | grep Dheadless=yes | awk '{ print $2 }'`
    PID_NODE=`ps -ef | grep -v grep | grep node-nmea | awk '{ print $2 }'`
    if [ "$PID" != "" ]
    then
      echo -n 'Killing process ' $PID $PID_NODE ', proceed [n]|y > '
      read a
      if nocase "$a" "Y"
      then
      # sudo kill -SIGTERM $PID
        sudo kill -9 $PID $PID_NODE
      fi
    else
      echo Found no console...
    fi
    echo -n Hit [return]
    read a
  elif nocase "$choice" "HC?"
  then
    # Looking for the headless console
    echo Looking for the Headless Console:
    PID=`ps -ef | grep -v grep | grep Dheadless=yes | awk '{ print $2 }'`
    if [ "$PID" != "" ]
    then
      echo Found process $PID
    else
      echo Found no console...
    fi
    echo -n Hit [return]
    read a
  elif nocase "$choice" "KW"
  then
    # Kills the headless console
    echo Terminating the Headless Console:
    PID=`ps -ef | grep -v grep | grep 'Dheadless=true.*Splasher' | awk '{ print $2 }'`
    if [ "$PID" != "" ]
    then
      echo Killing process $PID
      kill -SIGTERM $PID
    else
      echo Found no headless weather wizard...
    fi
    echo -n Hit [return]
    read a
  elif nocase "$choice" "CLI"
  then
    java -client -classpath $CP $JAVA_OPTIONS olivsoftdesktop.PreferencesCLI
    echo -n Hit [return]
    read a
  elif nocase "$choice" "HU"
  then
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
    java -client -classpath $CP $JAVA_OPTIONS olivsoftdesktop.OlivSoftDesktop --check-update
    echo -n Hit [return]
    read a
  elif nocase "$choice" "S"
  then
    java -Djava.library.path=/usr/lib/jni -classpath $CP nmeasniffer.gui.NMEASniffer
    read a
  elif nocase "$choice" "POL"
  then
    java -classpath $CP polarmaker.polars.main.PolarSmoother
  elif nocase "$choice" "Q"
  then
    EXIT=true
  else
    echo Command [$choice] Not supported yet..., hit [return]
    read a
  fi
done
if [ "$DIRECT" = "false" ]
then
  echo Bye now...
fi
