#!/usr/bin/env bash
# tag::adocSnippet[]
mvn io.quarkus:quarkus-maven-plugin:2.5.0.Final:create \
    -DplatformVersion=2.5.0.Final \
    -DprojectGroupId=org.agoncal.fascicle.quarkus.putting-together \
    -DprojectArtifactId=rest-number \
    -DprojectVersion=2.0.0-SNAPSHOT \
    -DclassName="org.agoncal.fascicle.quarkus.number.NumberResource" \
    -Dpath="/api/numbers" \
    -Dextensions="resteasy-jsonb, smallrye-openapi, smallrye-health"
# end::adocSnippet[]
