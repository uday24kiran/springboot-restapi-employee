FROM openjdk:8
EXPOSE 9090
ADD target/*.jar springboot-crud-k8s.jar
ENTRYPOINT ["java","-jar","/springboot-crud-k8s.jar"]
