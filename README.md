This repository contains java sdk and samples for Adaptive Payments API.

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 2 or higher

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
		mvn install:install-file -Dfile=adaptivepaymentssdk-2.0.96.jar -DgroupId=com.paypal.sdk -DartifactId=adaptivepaymentssdk -Dversion=2.0.96 -Dpackaging=jar	

*	Create a new maven application.

*	Add dependency to sdk in your application's pom.xml as below.
		
		<dependency>
			<groupId>com.paypal.sdk</groupId>
			<artifactId>adaptivepaymentssdk</artifactId>
			<version>2.0.96</version>
		</dependency>
		
To make an API call:
--------------------			
*	Import AdaptivePaymentsService.java into your code.
		
*	Copy the configuration file 'sdk_config.properties' in 'adaptivepaymentssample/src/main/resources' folder to your application 'src/main/resources'. And load it using,  
*	Copy the configuration file 'sdk_config.properties' in 'adaptivepaymentssample/src/main/resources' folder to your application 'src/main/resources'. And load it using,  
		  
		  new AdaptivePaymentsService(this.getClass().getResourceAsStream("/sdk_config.properties"));
	
*	Or load the configuration file from any location using absolute path with the below method calls as required.

          new AdaptivePaymentsService(new File(" .../sdk_config.properties"));
                                 Or
		  new AdaptivePaymentsService(new InputStream(new File(" .../sdk_config.properties")));
                                 Or
          new AdaptivePaymentsService(" .../sdk_config.properties");
  
*	Create a service wrapper object.

*	Create a request object as per your project needs. 

*	Invoke the appropriate method on the service wrapper object.

For example,

          
	  import com.paypal.svcs.services.AdaptivePaymentsService;
	  import com.paypal.svcs.types.common.RequestEnvelope;
	  import com.paypal.svcs.types.ap.PayRequest;
      import com.paypal.svcs.types.ap.PayResponse;
	  import com.paypal.svcs.types.ap.Receiver;
      import com.paypal.svcs.types.ap.ReceiverList;
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

          AdaptivePaymentsService adaptivePaymentsService = new AdaptivePaymentsService(this.getClass().getResourceAsStream("/sdk_config.properties"));
		  //userName is optional
	      PayResponse payResponse = adaptivePaymentsService.pay(payRequest,userName);
		  

SDK Logging:
------------
*	For logging - java.util.logging has been used. To change the default configuration, edit the
 
logging.properties file in 'jre/lib' folder under your JDK root.		  

		  
SDK Configuration:
------------------
The SDK uses .properties format configuration file. Sample of this file is at 
 
'adaptivepaymentssample/src/main/resources/'. You can use the 'sdk_config.properties' configuration file to configure

*	(Multiple) API account credentials.

*	HTTP connection parameters.

*	Service configuration.


For additional information on Adaptive Payments API, please refer to https://www.x.com/developers/paypal/documentation-tools/api




