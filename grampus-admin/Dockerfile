# 构建镜像，执行命令：【docker build -t grampus-admin:1.0.0】
# 启动镜像，执行指令：【docker run --name grampus-admin -d -p 28080:28080 grampus-admin:1.0.0】
FROM openjdk:11.0.11-jre

MAINTAINER Beck

ENV TIME_ZONE=UTC

# 时区问题
RUN ln -sf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime && echo $TIME_ZONE > /etc/timezone

RUN mkdir -p /grampus-admin

WORKDIR /grampus-admin

EXPOSE 28080

ADD ./target/grampus-admin.jar ./

ENTRYPOINT ["java", "-server", "-Xss256k", "-Xms512m", "-Xmx2880m", "-XX:MaxDirectMemorySize=1024m", "-XX:ReservedCodeCacheSize=256m", "-XX:MetaspaceSize=128m", "-XX:MaxMetaspaceSize=512m", "-XX:+AlwaysPreTouch", "-XX:+UseConcMarkSweepGC", "-XX:CMSInitiatingOccupancyFraction=75", "-XX:+UseCMSInitiatingOccupancyOnly", "-XX:MaxTenuringThreshold=3", "-XX:+ExplicitGCInvokesConcurrent", "-XX:+ParallelRefProcEnabled", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:-UseBiasedLocking", "-XX:AutoBoxCacheMax=20000", "-Djava.security.egd=file:/dev/./urandom", "-Djava.net.preferIPv4Stack=true", "-Dfile.encoding=UTF-8", "-jar", "grampus-admin.jar"]