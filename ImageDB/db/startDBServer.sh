#!/bin/bash
echo Using server.properties for configuration
echo Server is ready when you see the "HSQLDB server 1.8.0 is online" line...
echo Please wait...
echo ------------------------------------------------------------------------
# java -cp ../hsqldb.jar org.hsqldb.Server
java -cp ../build/libs/ImageDB-4.0.0.0-all.jar org.hsqldb.Server
