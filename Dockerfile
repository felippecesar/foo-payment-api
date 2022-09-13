FROM amazoncorretto:11-alpine3.14-jdk
LABEL source="https://github.com/felippecesar/foo-payment-api" maintainer="flippc"
WORKDIR /foo-app
COPY build/libs/foo-payment-api*.jar ./foo-payment-api.jar

RUN addgroup -S appuser && adduser -S appuser -G appuser
USER appuser:appuser

EXPOSE 8999
CMD [ "java", "-jar", "foo-payment-api.jar" ]