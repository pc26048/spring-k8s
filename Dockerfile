FROM openjdk:17
#copy the jar file which is target folder into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springboot-k8s-demo.jar
ENTRYPOINT ["java","-jar","/springboot-k8s-demo.jar"]