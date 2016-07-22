1.编译打包
gradle build -x test
# 生成image
docker build -t baas-bmc:1.0 .
docker build -t 10.1.245.4:5000/baas-bmc:1.0 .
docker push 10.1.245.4:5000/baas-bmc:1.0

3. 运行镜像
docker run -d --net=host -e "REST_REGISTRY_ADDR=10.1.234.162:2181" -e "REST_PORT=10774" -e "CONTEXT_PATH=baas-bmc" -e "PROTOCOL=rest" -e "SDK_MODE=1" -e "CCS_NAME=aiopt-baas-bmc" -e "ZK_ADDRESS=10.1.234.162:2181" baas-bmc:1.0
