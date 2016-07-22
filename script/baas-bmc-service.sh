#!/bin/sh

CONFIG_PATH=${APP_HOME}/config
LOG_PATH=${APP_HOME}/logs/baas-bmc-rest.log

BIN_PATH=${APP_HOME}/libs

for file in ${BIN_PATH}/**/*.jar;
do CP=${CP}:$file;
done

CLASSPATH="${CP}"

CLASSPATH="${CONFIG_PATH}:${CLASSPATH}"
echo $CLASSPATH
JAVA_OPTIONS=" -Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10"
MEM_ARGS="-Xms128m -Xmx512m"

START_CMD=" ${MEM_ARGS} -Ddubbo.registry.address=${REST_REGISTRY_ADDR} -Ddubbo.protocol.port=${REST_PORT} -Ddubbo.protocol.contextpath=${CONTEXT_PATH} -Ddubbo.protocol=${PROTOCOL} -D${PROCESS_PARM}  ${JAVA_OPTIONS} com.ai.opt.sdk.appserver.DubboServiceStart >> $LOG_PATH & 2>&1&"

sed -i "s/paas.sdk.mode=.*/paas.sdk.mode=${SDK_MODE}/g" /baas-bmc-service/config/paas/paas-conf.properties
sed -i "s/ccs.appname=.*/ccs.appname=${CCS_NAME}/g" /baas-bmc-service/config/paas/paas-conf.properties
sed -i "s/ccs.zk_address=.*/ccs.zk_address=${ZK_ADDRESS}/g" /baas-bmc-service/config/paas/paas-conf.properties

echo "------------------- baas bmc service start --------------------"

java ${START_CMD}

echo "------------------- baas bmc service started --------------------"