Prerequisites:
--------------
*	Java jdk-1.5 or higher

Using SDK:
----------
SDK Integration:
----------------
*	Download the project from github, build project using build.xml with default ant target, which will create 			    'adaptivepayments-java-sdk_1.8.92.jar' inside 'dist' folder.

*	Copy 'adaptivepayments-java-sdk_1.8.92.jar' inside 'dist' folder under SDK root, to your class path.

*	Copy the configuration file 'sdk_config.properties' in SDK 'resource' folder to your project.

*	Import AdaptivePaymentsService.java into your code.

*	Load the configuration file into your application with the below method calls as required.

          new AdaptivePaymentsService(new File(" .../sdk_config.properties"));
                                 Or
          new AdaptivePaymentsService(new InputStream(new File(" .../sdk_config.properties")));
                                 Or
          new AdaptivePaymentsService(" .../sdk_config.properties");

Eg. if your sdk_config.properties file is in your WEB-INF/ folder, you can initialize the AdaptivePaymentsService as below:	
	
		  new AdaptivePaymentsService(this.getServletContext().getRealPath("/") + "/WEB-INF/sdk_config.properties");
		

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
	  
	      PayRequest request = new PayRequest();
	      request.setReceiverList(receiverlst);
	      request.setRequestEnvelope(env);
          ...

          //userName is optional
          AdaptivePaymentsService service = new AdaptivePaymentsService(".../sdk_config.properties");
	      PayResponse ret = service.pay(req,userName);


SDK Testing:
-----------

*	To run test cases, 'testng.jar' in SDK lib folder is required in class path.

*	Run default ant target "dist" to compile and test the sdk classes.

*	Junit reports are generated in testReport folder.

*   'UnitTestConstants.java' in test folder contains constants for testing. It will mimic the API User Details and resource details in properties file. Replace the constants with your own appropriate values.


SDK Logging:
------------
*	For logging - java.util.logging has been used. To change the default configuration, edit the
 
logging.properties file in 'jre/lib' folder under your JDK root.


SDK Configuration:
------------------
The SDK uses .properties format configuration file. Sample of this file is at 
 
'resource/'. You can use the 'sdk_config.properties' configuration file to configure

*	(Multiple) API account credentials.

*	HTTP connection parameters.

*	Service configuration.

Please refer to the sample config file provided with this bundle.

