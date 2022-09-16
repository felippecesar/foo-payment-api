# foo-payment-api

to run:

$ ./gradlew clean build && docker compose -f docker/docker-compose.yml up

to update:

$ docker image rm docker-foo-payment-api


extra:

you can run locally, but then you will need to create your own database and apply flyway manually:

$ ./gradlew build && java -jar build/libs/foo-payment-api-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=local