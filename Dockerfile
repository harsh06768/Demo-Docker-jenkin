FROM openjdk:8
EXPOSE 9090
ADD target/springboot-jenkins-demo.jar springboot-jenkins-demo
ENTRYPOINT ["java","-jar","/springboot-jenkins-demo.jar"]



