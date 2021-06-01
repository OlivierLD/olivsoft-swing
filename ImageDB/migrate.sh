#!/bin/bash
echo -e "Migrate HSQL to SQLite"
#echo -e "Available Connections:"
#echo -e "CHART chart chart"
#echo -e "LOG log log"
#echo -e "TIDES tides tides"
#echo -e "IMAGES images images"
#echo -e "Usage is:"
#echo -e "----------------------------"
#echo -e "$0 IMAGES images images"
#echo -e "hSQL> connect"
#echo -e "hSQL> select count(*) from images;"
#echo -e "----------------------------"
#echo -e "Type help at the prompt for help"
#echo -e "..."
#echo -e "!! Warning !! Even \"create table\" needs to be committed..."
#
CP=./build/libs/ImageDB-4.0.0.0-all.jar
#
java -classpath ${CP} dnd.hsql.DumpDB
# @java -classpath %CP% coreutilities.sql.HSQLPlus "SAMPLEDB" SA ""
