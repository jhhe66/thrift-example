FROM java:8

ADD "target/rpc-server-1.0-SNAPSHOT-jar-with-dependencies.jar" app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 9090

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]