This application contains API based samples for AdaptivePayments. 

Prerequisities:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 2 or higher

To build and run this application:
----------------------------------

*   Update the 'sdk_config.properties' in the 'adaptivepaymentssample/src/main/resources' directory with your API credentials.
*	Simply run mvn install to build war file.
*	Copy the 'target/adaptivepaymentssample-1.0-SNAPSHOT.war' into your 'tomcat/webapps' directory.
*	Start your tomcat if it's not already running.
*	Access 'http://<your-server-host:port>/adaptivepaymentssample-1.0-SNAPSHOT/' in your browser to play with the test pages.