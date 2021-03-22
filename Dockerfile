FROM openjdk:11

WORKDIR /app

COPY target/angular-component-definer.jar angular-component-definer.jar

# ENTRYPOINT "java -jar angular-component-definer.jar /app/r/result.json /app/ftg/filesToGroup.txt" 

ENTRYPOINT ["java", "-jar", "angular-component-definer.jar", "./r/result.json", "./ftg/filesToGroup.txt"]