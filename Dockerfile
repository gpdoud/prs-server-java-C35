FROM javase-11
EXPOSE 3306
WORKDIR /app
COPY target/prs-server-java-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "prs-server-java-0.0.1-SNAPSHOT.jar" ]