This application contains API based samples for AdaptivePayments. 

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 3 or higher
*  Please refer http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html for any help in Maven.

To build and run this application:
----------------------------------

*   Setup your API credentials and other configuration as shown in SDK README in the root directory.
*	Simply run `mvn install` to build war file.
*	Run `mvn jetty:run` to run the war file.
*	Access `http://localhost:<jetty-port>/adaptivepaymentssample-2.6.110/` in your browser to play with the test pages.`<jetty-port>` is configurable in `pom.xml`.
