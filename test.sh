#!/bin/bash

mvn install

cd target
rm -rf applepie
mvn archetype:generate \
  -DarchetypeGroupId=de.choffmeister \
  -DarchetypeArtifactId=console-app-archetype \
  -DarchetypeVersion=0.0-SNAPSHOT \
  -DgroupId=foo.bar \
  -DartifactId=applepie \
  -Dversion=1.0-SNAPSHOT \
  -Dpackage=foo.bar.applepie \
  -DinteractiveMode=false
cd applepie
mvn package
java -jar target/applepie-1.0-SNAPSHOT-app.jar -n=10 Hello World
mvn site
