FROM maven:3.9.6 AS build

WORKDIR /code
COPY pom.xml .
COPY . /code

# Build the application cache dependancies
RUN --mount=type=cache,target=/root/.m2 mvn clean package

# # Build the application
# RUN mvn clean package -DskipTests

# Use Adoptium JDK 16 as the base image for the final image
FROM openjdk:21-jdk-slim

RUN mkdir /app

# Copy the JAR file from the Maven image

COPY --from=build /target/eureka-server-1.0-SNAPSHOT.jar /app/eureka-server.jar

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the Maven image

COPY --from=build /target/eureka-server-1.0-SNAPSHOT.jar /app/eureka-server.jar


#EXPOSE 8081

#COPY ./init_db.sh /docker-entrypoint-initdb.d/
#RUN chmod +x /docker-entrypoint-initdb.d/init_db.sh

CMD [ "java", "--enable-preview", "-jar", "eureka-server.jar" ]