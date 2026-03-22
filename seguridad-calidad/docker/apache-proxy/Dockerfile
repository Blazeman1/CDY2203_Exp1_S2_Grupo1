FROM httpd:2.4

RUN apt-get update && apt-get install -y libssl-dev openssl

COPY server.key /usr/local/apache2/conf/
COPY server.crt /usr/local/apache2/conf/
COPY httpd.conf /usr/local/apache2/conf/httpd.conf
COPY extra/httpd-ssl.conf /usr/local/apache2/conf/extra/httpd-ssl.conf

EXPOSE 80 443