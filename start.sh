#!/usr/bin/env bash
mvn clean package -Dmaven.test.skip -U
java  -jar elastics-core/target/elastics.jar --spring.profiles.active=local --spring.dubbo.protocol.port=20881  --server.port=8080 &