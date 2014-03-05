This repository contains java sdk and samples for Adaptive Payments API.

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 3 or higher
*	Please refer http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html for any help in Maven.

To build sdk and samples:
--------------------------
*	Build core files from https://github.com/paypal/sdk-core-java, as it is a dependency for sdk.
*	Then, run 'mvn install' to build sdk jar and sample war files.

SDK Integration:
----------------
For Non-Maven Users:
--------------------
*   Create a new application.

*   Copy  all the jar files present inside 'lib' folder to your application.

For Maven Users:
----------------
*   Install all the jar files present inside 'lib' folder manually to local repository. 

        mvn install:install-file -Dfile=commons-codec-1.3.jar -DgroupId=commons-codec -DartifactId=commons-codec -Dversion=1.3 -Dpackaging=jar
        mvn install:install-file -Dfile=paypal-core-1.0.jar -DgroupId=com.paypal.sdk -DartifactId=paypal-core -Dversion=1.0 -Dpackaging=jar
		mvn install:install-file -Dfile=adaptivepaymentssdk-2.6.110.jar -DgroupId=com.paypal.sdk -DartifactId=adaptivepaymentssdk -Dversion=2.6.110 -Dpackaging=jar	

*	Create a new maven application.

*	Add dependency to sdk in your application's pom.xml as below.
		
    ```xml
    <dependency>
        <groupId>com.paypal.sdk</groupId>
        <artifactId>adaptivepaymentssdk</artifactId>
        <version>2.6.110</version>
    </dependency>
    ```

To make an API call:
--------------------			
*	Import AdaptivePaymentsService.java into your code.
		
*	Create a configuration file 'sdk_config.properties' with parameters specified in configuration section (make sure the file is in class path). Use the default constructor to run with configuration used from 'sdk_config.properties' found in classpath.
	```java
	new AdaptivePaymentsService();
	```
*	For Dynamic configuration(configuration is tied to the lifetime of the service object)
	```java
	new AdaptivePaymentsService(new File("/pathto/custom.properties"));
                         Or
	new AdaptivePaymentsService(new FileInputStream(new File("/pathto/custom.properties")));
                         Or
	new AdaptivePaymentsService("/pathto/custom.properties");
                         Or
	new AdaptivePaymentsService(Map<String, String> customConfigurationMap);
                         Or
	new AdaptivePaymentsService(Properties customProperties);
	```
*	The SDK takes defaults for certain parameters (eg: Account Credentials and either of 'mode' or 'service.Endpoint' are mandatory parameters).

*	Create a service wrapper object.

*	Create a request object as per your project needs. 

*	Invoke the appropriate method on the service wrapper object.

    For example,

          
    ```java
    import com.paypal.svcs.services.AdaptivePaymentsService;
    import com.paypal.svcs.types.common.RequestEnvelope;
    import com.paypal.svcs.types.ap.*;
    ...
      
    RequestEnvelope env = new RequestEnvelope();
    env.setErrorLanguage("en_US");
    ...

    List<Receiver> receiver = new ArrayList<Receiver>();
    Receiver rec = new Receiver();
    rec.setAmount("2.0");
    rec.setEmail(request.getParameter("sdk@gmail.com"));
    receiver.add(rec);
    ReceiverList receiverlst = new ReceiverList(receiver);
    ...

    PayRequest payRequest = new PayRequest();
    payRequest.setReceiverList(receiverlst);
    payRequest.setRequestEnvelope(env);
    ...

    AdaptivePaymentsService adaptivePaymentsService = new AdaptivePaymentsService();
			Or
    Map<String, String> customConfigurationMap = new HashMap<String, String>();
    customConfigurationMap.put("mode", "sandbox"); // Load the map with all mandatory parameters
    ...
    AdaptivePaymentsService adaptivePaymentsService = new AdaptivePaymentsService(Map<String, String> customConfigurationMap);
    PayResponse payResponse = adaptivePaymentsService.pay(payRequest,userName);
    ```

SDK Logging:
------------
*	For logging - java.util.logging has been used. To change the default configuration, edit the
 
logging.properties file in 'jre/lib' folder under your JDK root.		  

		  
SDK Configuration:
------------------
The SDK uses dynamic configuration map or '*.properties' format configuration file as shown in code snippet above, to configure

*	Mode is specified using the parameter name 'mode' with values 'sandbox' or 'live', if specified 'service.EndPoint' parameter is not required and the SDK chooses the sandbox or live endpoints automatically.

*	(Multiple) API account credentials, by appending a '.' (dot) character and the service name to 'service.EndPoint' parameter.

*	HTTP connection parameters, if certain connection parameters are not specified, the SDK will assume defaults for them.

*	Service configuration.

*   You can refer full list of configuration parameters in [wiki](https://github.com/paypal/sdk-core-java/wiki/SDK-Configuration-Parameters) page.

Multiple SDK usage (Multiple End-points Support)
---------------------------
Multiple end-points configuration can be done by specifying mulitple end-points identified by specific property keys. 
When using multiple SDKs in combination, like Merchant and Permissions etc..configure the endpoints as shown below 
one for each service used, The existing service.EndPoint property is still supported for backward compatibility (using 
a single SDK). The list below specifies endpoints for different services, in SANDBOX and PRODUCTION, with their 
property keys and end-point as property values.

For additional information on Adaptive Payments API, please refer to https://www.x.com/developers/paypal/documentation-tools/api

Instant Payment Notification(IPN) 
---------------------------------
* Please refer readme  at 'adaptivepaymentssample/IPN-README.md'

