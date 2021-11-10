FROM openjdk:8-jdk-alpine
COPY target/pica-employee-0.0.1-SNAPSHOT.jar pica-employee.jar
ENTRYPOINT ["java", "-jar", "pica-employee.jar"]