FROM maven:3.8.5-openjdk-17 as base
COPY pom.xml /home/
WORKDIR /home
RUN mvn dependency:resolve
COPY src/ src/
RUN mvn package -Dmaven.test.skip


FROM maven:3.8.5-openjdk-17-slim
WORKDIR /home
COPY --from=base /home/target/*.jar .
RUN mv `ls -r *.*-SNAPSHOT.jar | head -1` app.jar
ENTRYPOINT ["java","-jar","app.jar"]
