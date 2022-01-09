FROM openjdk:8
EXPOSE 9090
ADD targets/springboot-jenkins-demo.jar springboot-jenkins-demo
ENTRYPOINT ["java","-jar","/springboot-jenkins-demo.jar"]



