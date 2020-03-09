#!/bin/bash
# cd /home/oracle/oliv/all-scripts
# export JAVA_HOME=/oracle/javahome/jrockit-jdk1.6.0_29-R28.2.0-4.0.1/jre
# export PATH=$JAVA_HOME/bin:$PATH
export PATH=`which java | awk '{ print substr($1, 0, length($1) - length("/java")) }'`:$PATH
echo PATH is ${PATH}
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
CP=$CP:../all-3rd-party/rxtx.distrib/RXTXcomm.jar
# echo CLASSPATH=$CP
#
EXIT=false
while [[ "$EXIT" == "false" ]]
do
  clear
  echo +----------------------+
  echo \| Oliv Soft full stack \|
  echo +----------------------+--------
  echo \| J for Java version
  echo \| W for Weather Wizard
# echo \| L for Weather Wizard  with Plastic L\&F
  echo \| M for Weather Wizard with Metal L\&F \(recommended\)
# echo \| N for Weather Wizard  with Napkin L\&F
  echo \| P for Weather Wizard, with http proxy
  echo \| PM for Weather Wizard, with http proxy and Metal L\&F
  echo \| S for NMEA Sniffer
  echo \| H for Headless NMEA Console
  echo \| POL for Polar Tool
  echo \| D for Desktop
  echo \| DM for Desktop with Metal L\&F \(recommended\)
  echo +-------------------------------
  echo \| Q for Quit
  echo +-------------------------------
#
  echo -n You choose :
  read choice
  if [[ ${choice} == "J" ]] || [[ ${choice} == "j" ]]
  then
    java -version
    echo [Hit return to continue...]
    read a
  elif [[ ${choice} == "W" ]] || [[ ${choice} == "w" ]]
  then
#   echo $CP
    java -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -client -Xms512m -Xmx1024m -splash:"clipper.jpg" -classpath $CP main.splash.Splasher
#   java -client -Xms512m -Xmx1024m -splash:"clipper.jpg" -classpath $CP main.splash.Splasher
  elif [[ ${choice} == "L" ]] || [[ ${choice} == "l" ]]
  then
    java -Xms512m -Xmx512m -splash:"clipper.jpg" -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -Dswing.defaultlaf=com.jgoodies.looks.plastic.Plastic3DLookAndFeel -classpath $CP main.splash.Splasher
  elif [[ ${choice} == "M" ]] || [[ ${choice} == "m" ]]
  then
    java -Xms512m -Xmx512m -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -classpath $CP main.splash.Splasher
#   java -Xms512m -Xmx512m -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -classpath $CP main.splash.Splasher
    echo -n Hit Return
    read a
  elif [[ ${choice} == "H" ]] || [[ ${choice} == "h" ]]
  then
    JAVA_OPTIONS="$JAVA_OPTIONS -Dverbose=false"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dheadless=yes"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dserial.port=/dev/tty.Bluetooth-Incoming-Port"
    JAVA_OPTIONS="$JAVA_OPTIONS -Dbaud.rate=4800"
    JAVA_OPTIONS="$JAVA_OPTIONS -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5"
    # JAVA_OPTIONS="$JAVA_OPTIONS -Dlogged.nmea.data=./logged-data/2010-11-08.Nuku-Hiva-Tuamotu.nmea"
    #
    HEADLESS_OPTIONS="-output=HTTP:9999"
    HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=TCP:7001"
    HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=UDP:230.0.0.1:8001"
    # HEADLESS_OPTIONS="$HEADLESS_OPTIONS -output=FILE:.\logged-data\headless.nmea
    #
    echo JAVA_OPTIONS=$JAVA_OPTIONS
    echo HEADLESS_OPTIONS=$HEADLESS_OPTIONS
    java -client -Xms512m -Xmx1024m -classpath $CP $JAVA_OPTIONS olivsoftdesktop.OlivSoftDesktop $HEADLESS_OPTIONS
    echo -e 'Hit return'
    read a
  elif [[ ${choice} == "S" ]] || [[ ${choice} == "s" ]]
  then
    java -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -Dverbose=true -Xms512m -Xmx512m -splash:"clipper.jpg" -classpath $CP nmeasniffer.gui.NMEASniffer
    echo -e 'Hit return'
    read a
  elif [[ ${choice} == "P" ]] || [[ ${choice} == "p" ]]
  then
    java -Xms512m -Xmx512m -splash:"clipper.jpg" -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath $CP main.splash.Splasher
  elif [[ ${choice} == "PM" ]] || [[ ${choice} == "pm" ]]
  then
    java -Xms512m -Xmx512m -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -Dhttp.proxyHost=www-proxy.us.oracle.com -Dhttp.proxyPort=80 -classpath $CP main.splash.Splasher
#   java -Xms512m -Xmx512m -splash:"clipper.jpg" -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -classpath $CP main.splash.Splasher
    echo -n Hit Return
    read a
  elif [[ ${choice} == "D" ]] || [[ ${choice} == "d" ]]
  then
    java -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -Dwith.journal=true -Dwith.logger=true -classpath $CP olivsoftdesktop.OlivSoftDesktop
  elif [[ ${choice} == "DM" ]] || [[ ${choice} == "dm" ]]
  then
    java -Djava.library.path=../all-3rd-party/rxtx.distrib/mac-10.5 -Dwith.journal=true -Dwith.logger=true -Dswing.defaultlaf=javax.swing.plaf.metal.MetalLookAndFeel -classpath $CP olivsoftdesktop.OlivSoftDesktop
  elif [[ ${choice} == "POL" ]] || [[ ${choice} == "pol" ]]
  then
    java -classpath $CP polarmaker.polars.main.PolarSmoother
  elif [[ ${choice} == "Q" ]] || [[ ${choice} == "q" ]]
  then
    EXIT=true
  else
    echo Command \[${choice}\] Not supported yet..., hit [return]
    read a
  fi
done
echo Bye now...
