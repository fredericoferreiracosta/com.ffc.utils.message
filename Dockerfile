FROM java:8-jdk
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

ENV KARAF_VERSION=4.2.7

RUN wget http://www-us.apache.org/dist/karaf/${KARAF_VERSION}/apache-karaf-${KARAF_VERSION}.tar.gz; \
    mkdir /opt/karaf; \
    tar --strip-components=1 -C /opt/karaf -xzf apache-karaf-${KARAF_VERSION}.tar.gz; \
    rm apache-karaf-${KARAF_VERSION}.tar.gz; \
    mkdir /deploy; \
    sed -i 's/^\(felix\.fileinstall\.dir\s*=\s*\).*$/\1\/deploy/' /opt/karaf/etc/org.apache.felix.fileinstall-deploy.cfg

VOLUME ["/deploy"]
COPY ./waitingservice/target/*.jar /deploy
COPY ./defaultmessageimpl/target/*.jar /deploy
COPY ./funnymessageimpl/target/*.jar /deploy
COPY ./holidaymessageimpl/target/*.jar /deploy
COPY ./integrationtest/target/*.jar /deploy

EXPOSE 1099 8101 8181 44444
ENTRYPOINT ["/opt/karaf/bin/karaf"]