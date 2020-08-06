#!/bin/bash
OPTION=$1
CP=build/libs/release-4.0.0.0-all.jar
if [[ ${OPTION} == "WW" ]]
then
  java -cp ${CP} main.splash.Splasher
else
  java -jar ${CP}
fi
