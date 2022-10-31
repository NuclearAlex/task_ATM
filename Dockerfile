FROM tomcat:9.0-alpine
LABEL maintainer="dubaicool@mail.ru"
ADD task_ATM.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]