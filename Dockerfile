FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0

ADD . /finder/

WORKDIR /finder/

RUN sbt clean assembly

#ENTRYPOINT ["java"]

CMD ["java", "-jar", "./target/scala-3.1.3/eventfinder.jar"]
