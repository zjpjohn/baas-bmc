#!/usr/bin/env bash

#set java home
if [ "$JAVA_HOME" != "" ]; then
  JAVA="$JAVA_HOME/bin/java"
else
  JAVA=java
fi

# get the previous process id
PID_FILES="checking.pid"

CHECKING_PID=`cat ${PID_FILES}`
if [ "$CHECKING_PID" != "" ]; then
    PS_OUT=`ps -ef | grep $CHECKING_PID | grep -v 'grep' | grep -v $0`
    result=$(echo $PS_OUT | grep $CHECKING_PID)
    if [ "$result" != "" ]; then
        echo "The checking  process is running. Will delay the analysis."
        exit -1;
    fi
fi

# echo the current process Id to pid file
PID=$!
echo "Current analysis process Id : ${PID}"
echo $PID > SW_ANALYSIS_PID


## check duplicate process is running
$JAVA -jar bmc-checking.jar -classpath $CLASSPATH com.ai.baas.bmc.checking.CheckDriver >> logfile & 2 >&1 &