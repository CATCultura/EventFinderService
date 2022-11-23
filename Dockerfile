FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0

ADD . /finder/

USER root

WORKDIR /finder/

RUN apt-get update

RUN apt-get install fakeroot -y

RUN which fakeroot

RUN sbt clean debian:packageBin

RUN dpkg -i target/eventfinder_0.1.0-SNAPSHOT_all.deb

CMD ["eventfinder"]
