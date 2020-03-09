#!/bin/bash
# Kills the headless console
echo Terminating the Headless Console:
PID=`ps -ef | grep -v grep | grep Dheadless=yes | awk '{ print $2 }'`
if [ "$PID" != "" ]
then
  echo Killing process $PID
  kill -SIGTERM $PID
else
  echo Found no console...
fi

