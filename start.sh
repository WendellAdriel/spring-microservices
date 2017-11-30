#!/bin/bash

echo Discovery Service: BUILDING
cd discovery-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILDING
cd api-gateway
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Monitor Service: BUILDING
cd monitor-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Monitor Service: BUILD DONE
echo Articles Service: BUILDING
cd article-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Monitor Service: BUILD DONE
echo Articles Service: BUILD DONE
echo Author Service: BUILDING
cd author-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Monitor Service: BUILD DONE
echo Articles Service: BUILD DONE
echo Author Service: BUILD DONE
echo ---
echo Starting Application...
docker-compose up --build
