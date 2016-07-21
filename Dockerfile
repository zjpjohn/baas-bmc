
FROM centos:7

MAINTAINER ai-opt

RUN yum install -y java-1.8.0-openjdk

# copy service files
COPY ./build/config baas-bmc-service/config
COPY ./build/libs baas-bmc-service/libs

# copy shell
COPY ./script/baas-bmc-service.sh baas-bmc-service
RUN chmod 755 baas-bmc-service/baas-bmc-service.sh

RUN mkdir baas-bmc-service/logs

EXPOSE 10774

CMD ["./baas-bmc-service/baas-bmc-service.sh"]


