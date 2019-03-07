#!/bin/bash

java -Dspring.profiles.active=$1 -Dlogging.config=/logback.xml -jar /app.jar