test:
	mvn install
	cd target && rm -rf applepie
	cd target && mvn archetype:generate \
		-DarchetypeGroupId=de.choffmeister \
		-DarchetypeArtifactId=console-app-archetype \
		-DarchetypeVersion=0.0-SNAPSHOT \
		-DgroupId=foo.bar \
		-DartifactId=applepie \
		-Dversion=1.0-SNAPSHOT \
		-Dpackage=foo.bar.applepie \
		-DinteractiveMode=false
	cd target/applepie && mvn package
	cd target/applepie && java -jar target/applepie-1.0-SNAPSHOT-app.jar -n=10 Hello World
	cd target/applepie && mvn site

deploy:
	mvn install -DcreateChecksum=true
	rsync -rv ~/.m2/repository/de/choffmeister/console-app-archetype/ choffmeister@choffmeister.de:/var/www/de.choffmeister.repo/maven2/de/choffmeister/console-app-archetype/
