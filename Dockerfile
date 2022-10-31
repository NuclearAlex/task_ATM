FROM tomcat:9.0-alpine
LABEL maintainer="dubaicool@mail.ru"
ADD task_ATM.war E://All_for_Java/reserv_copies/task_ATM/
EXPOSE 8080
CMD ["catalina.sh", "run"]
