FROM maven:3.6.3-openjdk-8 AS builder
RUN mkdir /demo-nidhal
COPY . /demo-nidhal
WORKDIR /demo-nidhal
RUN mvn package


FROM openjdk:8-jre-alpine
RUN mkdir /demo-nidhal
WORKDIR /demo-nidhal
COPY --from=builder /demo-nidhal/target/*.jar demo.jar
EXPOSE 9874
ENTRYPOINT ["java", "-Dlog.path=/demo-nidhal/log", "-jar", "demo.jar"]