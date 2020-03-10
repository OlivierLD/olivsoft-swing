#!/bin/bash
echo Image Database. Server version
CP=./build/libs/ImageDB-4.0.0.0-all.jar
#
# JAVA_OPTIONS=-Dverbose=false -Xmx1024m
JAVA_OPTIONS=-Dverbose=true
# JAVA_OPTIONS="$JAVA_OPTIONS -Ddb.location=./db -Ddb.flavor=file.db"
JAVA_OPTIONS="$JAVA_OPTIONS -Ddb.flavor=server.db -Ddb.url=//localhost:2345/images"
#
java ${JAVA_OPTIONS} -cp ${CP} imagedb.gui.splash.Splasher
#
