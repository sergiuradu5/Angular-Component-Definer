FROM openjdk:11

WORKDIR /acd

COPY target ./target

# ENV outputFile = "../result.json"

# ENV filesToGroup = "../filesToGroup.txt"

#ENTRYPOINT java -jar angular-component-definer.jar

# ENTRYPOINT ["java", "-jar", "angular-component-definer.jar"]