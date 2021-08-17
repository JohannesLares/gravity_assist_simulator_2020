FROM maven:3.8.2-jdk-8

WORKDIR /app

COPY ./luolastogeneraattori .
COPY README.md .
RUN mvn install -Dmaven.test.skip=true
RUN mvn package -Dmaven.test.skip=true

CMD java -jar target/luolastogeneraattori-0.0.1-SNAPSHOT.jar