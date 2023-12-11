#FROM containers.cisco.com/aws_staged/tomcat-7-jws3.1
#FROM registry.access.redhat.com/jboss-webserver-5/webserver50-tomcat9-openshift 
FROM containers.cisco.com/aws_managed/webserver56-openjdk8-tomcat9-openshift-rhel8
USER root

ADD *.rpm /tmp/
#COPY redhat_base.repo  /etc/yum.repos.d/
RUN  yum install -y /tmp/*.rpm && \
     rm -f /tmp/*.rpm && \
     echo /usr/lib/oracle/11.2/client64/lib > /etc/ld.so.conf.d/oracle-instantclient11.2.conf && \
     ldconfig
COPY network /usr/lib/oracle/11.2/network
ADD AppDServerAgent /opt/AppDServerAgent

COPY remoteuservalve.jar TomEncrypt.jar log4j.properties ${JWS_HOME}/lib/
#ENV JAVA_OPTS_EXT=" -Djboss.server.log.dir=$JWS_HOME/logs/ -Djava.library.path=/usr/lib/oracle/11.2/client64/lib" \
ENV OPENSHIFT_LOG_DIR=${HOME}/lae-home/app-root/logs/ \
    OPENSHIFT_HOMEDIR=${JWS_HOME} \
    OPENSHIFT_REPO_DIR=${HOME}/lae-home/app-root/repo \
    OPENSHIFT_JBOSSEWS_DIR=${JWS_HOME} \
    TMP_DIR=/tmp \
    OPENSHIFT_JBOSSEWS_LOG_DIR=${JWS_HOME}/logs/ \
    OPENSHIFT_DATA_DIR=${HOME}/data \
    PATH=$PATH:/usr/lib/oracle/11.2/client64/bin \
    LD_LIBRARY_PATH=/usr/lib/oracle/11.2/client64/lib:$LD_LIBRARY_PATH \
    TNS_ADMIN=/usr/lib/oracle/11.2/network/admin \
    PATH=$PATH:${JWS_HOME}

COPY setenv.sh  ${JWS_HOME}/bin

RUN mkdir ${HOME}/{data,lae-home} && \
    mkdir ${HOME}/lae-home/jbossews && \
    mkdir -p ${HOME}/lae-home/app-root/runtime/repo && \
    mkdir -p ${HOME}/lae-home/app-root/logs && \
    mkdir -p /opt/AppDServerAgent/logs && \
    mkdir -p ${JWS_HOME}/app-root/repo && \
    mkdir -p ${JWS_HOME}/app-deployments/current/dependencies/jbossews/webapps && \
    mkdir -p ${JWS_HOME}/app-root/runtime/dependencies/jbossews/webapps && \
    ln -fs /usr/share/zoneinfo/America/Los_Angeles /etc/localtime && \
    ln -s $HOME/lae-home/app-root  $HOME/app-root && \
    ln -s $HOME/lae-home/app-root /home/app-root && \
    chmod +x ${JWS_HOME}/bin/setenv.sh

WORKDIR ${HOME}/lae-home/app-root
RUN ln -s runtime/repo repo
WORKDIR ${HOME}

#COPY config-replace  ${JWS_HOME}/infrascripts/config-replace
COPY serverStart  ${JWS_HOME}/bin/serverStart.sh
RUN chmod -R 777 ${JWS_HOME} && \
    chmod -R 777 ${HOME} && \
    chmod -R 775 /opt/AppDServerAgent/logs && \
    rm -rf ${JWS_HOME}/webapps/manager
   
EXPOSE 8080

RUN echo "Building Application Image!"
CMD ${JWS_HOME}/bin/serverStart.sh
