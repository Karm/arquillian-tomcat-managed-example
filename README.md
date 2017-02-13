# Dead simple demo

 * wget http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.39/bin/apache-tomcat-8.0.39.zip
 * unzip apache-tomcat-8.0.39.zip
 * add ```<user username="arquillian" password="arquillian" roles="manager-script"/>``` to apache-tomcat-8.0.39/conf/tomcat-users.xml
 * export CATALINA_HOME="/your/path/apache-tomcat-8.0.39"; mvn clean package -Dtomcat.user=arquillian -Dtomcat.pass=arquillian


