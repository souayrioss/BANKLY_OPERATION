FROM openjdk:17-jdk-alpine
WORKDIR operation/
COPY target/banklyOperation-0.0.1.war operation/
ENTRYPOINT ["java", "-jar","operation/banklyOperation-0.0.1.war"]