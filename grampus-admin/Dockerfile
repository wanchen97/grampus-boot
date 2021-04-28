# 构建镜像，执行命令：【docker build -t grampus-admin:1.0.0】
FROM openjdk:11.0.11-jre

MAINTAINER Beck

ENV TIME_ZONE=UTC
ENV JAVA_OPTS="-server -Xms512m -Xmx1024m -Djava.security.egd=file:/dev/./urandom -Dfile.encoding=UTF-8 -XX:+HeapDumpOnOutOfMemoryError"

# 时区问题
RUN ln -sf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime && echo $TIME_ZONE > /etc/timezone

RUN mkdir -p /grampus-admin

WORKDIR /grampus-admin

EXPOSE 4000

ADD ./target/grampus-admin.jar ./

CMD sleep 60;java $JAVA_OPTS -jar grampus-admin.jar