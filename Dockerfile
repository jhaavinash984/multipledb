#FROM containers.cisco.com/aws_managed/tomcat-7-jws3.1_custom
## Maintainer ##
FROM registry.access.redhat.com/jboss-webserver-3/webserver31-tomcat7-openshift
#FROM containers.cisco.com/aws_managed/webserver57-openjdk8-tomcat9-openshift-rhel8
MAINTAINER Lae2Cae-Operations
#FROM registry.access.redhat.com/jboss-webserver-5/webserver50-tomcat9-openshift
USER root
ADD *.rpm /tmp/
#COPY redhat_base.repo  /etc/yum.repos.d/
RUN  yum install -y /tmp/*.rpm && \
     rm -f /tmp/*.rpm && \
     echo /usr/lib/oracle/11.2/client64/lib > /etc/ld.so.conf.d/oracle-instantclient11.2.conf && \
     ldconfig
COPY network /usr/lib/oracle/11.2/network
#ADD AppDServerAgent /opt/AppDServerAgent

COPY remoteuservalve.jar TomEncrypt.jar log4j.properties ${JWS_HOME}/lib/
ENV JAVA_OPTS_EXT="-Djboss.server.log.dir=$JWS_HOME/log/\$HOSTNAME -Djava.library.path=/usr/lib/oracle/11.2/client64/lib" \
    OPENSHIFT_LOG_DIR=${JWS_HOME}/logs/\$HOSTNAME \
    OPENSHIFT_HOMEDIR=${JWS_HOME} \
    OPENSHIFT_REPO_DIR=${HOME}/lae-home/app-root/repo \
    OPENSHIFT_JBOSSEWS_DIR=${JWS_HOME} \
    TMP_DIR=/tmp \
    OPENSHIFT_JBOSSEWS_LOG_DIR=${JWS_HOME}/logs/\$HOSTNAME \
    OPENSHIFT_DATA_DIR=${JWS_HOME}/logs/\$HOSTNAME \
    PATH=$PATH:/usr/lib/oracle/11.2/client64/bin \
    LD_LIBRARY_PATH=/usr/lib/oracle/11.2/client64/lib:$LD_LIBRARY_PATH \
    TNS_ADMIN=/usr/lib/oracle/11.2/network/admin \
    PATH=$PATH:${JWS_HOME}

COPY setenv.sh  ${JWS_HOME}/bin

RUN mkdir ${HOME}/{data,lae-home} && \
    mkdir ${HOME}/lae-home/jbossews && \
    mkdir -p ${HOME}/lae-home/app-root/runtime/repo && \
    mkdir -p /opt/AppDServerAgent/logs && \
    mkdir ${JWS_HOME}/infrascripts && \
    mkdir -p ${JWS_HOME}/app-deployments/current/dependencies/jbossews/webapps && \
    mkdir -p ${JWS_HOME}/app-root/runtime/dependencies/jbossews/webapps && \
    ln -fs /usr/share/zoneinfo/America/Los_Angeles /etc/localtime && \
    chmod +x ${JWS_HOME}/bin/setenv.sh

WORKDIR ${HOME}/lae-home/app-root
RUN ln -s runtime/repo repo
WORKDIR ${HOME}

COPY config-replace  ${JWS_HOME}/infrascripts/config-replace
COPY serverStart  ${JWS_HOME}/bin/serverStart.sh
RUN chmod -R 777 ${JWS_HOME}/{bin,logs,infrascripts} && \
    chmod -R 777 ${HOME}/lae-home/app-root && \
    chmod -R 775 /opt/AppDServerAgent/logs && \
    rm -rf ${JWS_HOME}/webapps/manager
EXPOSE 8080
COPY package/repo  ${HOME}/lae-home/app-root/runtime/repo
RUN chmod -R 777  ${HOME}/lae-home/app-root/runtime/repo
# Add Deployment WAR
COPY package/dependencies/jbossews/webapps/*.war  ${JWS_HOME}/webapps/
RUN echo "Building Application Image!"
USER default
# Main Command
CMD ${JWS_HOME}/bin/serverStart.sh
