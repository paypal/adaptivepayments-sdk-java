package test.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.UnitTestConstants;

import com.paypal.core.AuthenticationService;
import com.paypal.core.ConnectionManager;
import com.paypal.core.CredentialManager;
import com.paypal.core.HttpConfiguration;
import com.paypal.core.HttpConnection;
import com.paypal.core.ICredential;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class AuthenticationServiceTest {
	AuthenticationService auth;
	Map<String, String> map = new HashMap<String, String>();
	HttpConfiguration httpConfiguration;

	@BeforeClass
	public void beforeClass() throws MissingCredentialException {
		auth = new AuthenticationService();
		httpConfiguration = new HttpConfiguration();
		httpConfiguration.setEndPointUrl(UnitTestConstants.API_ENDPOINT);
	}

	@AfterClass
	public void afterClass() {
		auth = null;
	}

	@Test
	public void generateAuthStringTest() throws SecurityException,
			NoSuchMethodException, MissingCredentialException,
			InvalidCredentialException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Method method = AuthenticationService.class.getDeclaredMethod(
				"generateAuthString", ICredential.class, String.class,
				String.class, String.class);
		method.setAccessible(true);
		CredentialManager credMgr = CredentialManager.getInstance();
		ICredential apiCredential = credMgr
				.getCredentialObject(UnitTestConstants.API_USER_NAME);
		String authString = (String) method.invoke(auth, apiCredential,
				UnitTestConstants.ACCESS_TOKEN, UnitTestConstants.TOKEN_SECRET,
				UnitTestConstants.API_ENDPOINT);
		assert (authString.contains("token="));
		assert (authString.contains("signature="));
		assert (authString.contains("timestamp="));
	}

	@Test
	public void getPayPalHeadersTest() throws SSLConfigurationException,
			OAuthException, InvalidCredentialException,
			MissingCredentialException {
		ConnectionManager connectionMgr = ConnectionManager.getInstance();
		HttpConnection connection = connectionMgr.getConnection();
		map = auth.getPayPalHeaders(UnitTestConstants.API_USER_NAME,
				connection, null, null, httpConfiguration);
		Assert.assertEquals(map.get("X-PAYPAL-REQUEST-DATA-FORMAT"), "NV");
		Assert.assertEquals(map.get("X-PAYPAL-RESPONSE-DATA-FORMAT"), "NV");
		Assert.assertEquals(map.get("X-PAYPAL-APPLICATION-ID"),
				UnitTestConstants.APP_ID);

	}

	@Test
	public void appendSoapHeader() throws InvalidCredentialException,
			MissingCredentialException {
		String payload = "<Version>78.0</Version>";
		String headers = auth.appendSoapHeader(payload, null, null);
		Assert.assertEquals(
				"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:ebay:api:PayPalAPI\" xmlns:ebl=\"urn:ebay:apis:eBLBaseComponents\" xmlns:cc=\"urn:ebay:apis:CoreComponentTypes\" xmlns:ed=\"urn:ebay:apis:EnhancedDataTypes\"><soapenv:Body><Version>78.0</Version></soapenv:Body></soapenv:Envelope>",
				headers);
	}
}
