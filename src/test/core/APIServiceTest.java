package test.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.UnitTestConstants;

import com.paypal.core.APIService;
import com.paypal.core.AuthenticationService;
import com.paypal.core.ConfigManager;
import com.paypal.core.ConnectionManager;
import com.paypal.core.HttpConfiguration;
import com.paypal.core.HttpConnection;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.SSLConfigurationException;

public class APIServiceTest {
	APIService service;
	HttpConnection connection;

	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void beforeClass() throws NumberFormatException,
			SSLConfigurationException, FileNotFoundException, IOException {
		ConfigManager.getInstance().load(
				new FileInputStream(new File(UnitTestConstants.FILE_PATH)));
		service = new APIService("Invoice");
		ConnectionManager connectionMgr = ConnectionManager.getInstance();
		connection = connectionMgr.getConnection();
	}

	@Test(dataProvider = "configParams", dataProviderClass = DataProviderClass.class, expectedExceptions = InvalidCredentialException.class)
	public void getInvalidCredentialExceptionTest(ConfigManager conf)
			throws Exception {
		AuthenticationService auth = new AuthenticationService();
		HttpConfiguration httpConfiguration = new HttpConfiguration();
		map = auth.getPayPalHeaders("invalid@gmail.com", connection, null,
				null, httpConfiguration);

	}

	@Test
	public void getServiceNameTest() {
		Assert.assertEquals("Invoice", service.getServiceName());
	}

	@Test(dataProvider = "configParams", dataProviderClass = DataProviderClass.class)
	public void getEndPointTest(ConfigManager conf) {

		Assert.assertEquals(UnitTestConstants.API_ENDPOINT,
				service.getEndPoint());
	}

	@AfterClass
	public void afterClass() {
		service = null;
		connection = null;
	}

}
