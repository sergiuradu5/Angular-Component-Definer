FROM openjdk:11

WORKDIR /app

COPY ./target/angular-component-definer.jar /app

ENV outputFile = /app/docker/result.json

ENV filesToGroup = /app/docker/filesToGroup.txt

ENTRYPOINT eval "java -jar angular-component-definer.jar ${outputFile} ${filesToGroup}" 

# ENTRYPOINT ["java", "-jar", "angular-component-definer.jar", ${outputFile}, ${filesToGroup}]