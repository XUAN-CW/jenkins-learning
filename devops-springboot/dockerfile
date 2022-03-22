# FROM java:8
# FROM openjdk:8-jdk-alpine
# 测试时用这个，工具比较多
FROM openjdk:8u312-oraclelinux8
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]