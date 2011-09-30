package test.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;

import test.UnitTestConstants;

import com.paypal.core.AuthenticationService;
import com.paypal.core.ConfigManager;
import com.paypal.core.ConnectionManager;
import com.paypal.core.HttpConfiguration;
import com.paypal.core.HttpConnection;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class DataProviderClass {
	static ConfigManager conf;
	static File file = new File(UnitTestConstants.FILE_PATH);

	@DataProvider(name = "configParams")
	public static Object[][] configParams() throws FileNotFoundException,
			IOException {
		conf = ConfigManager.getInstance();

		FileInputStream in = new FileInputStream(file);
		conf.load(in);
		return new Object[][] { new Object[] { conf } };

	}

	@DataProvider(name = "headers")
	public static Object[][] getPayPalHeaders()
			throws InvalidCredentialException, IOException,
			MissingCredentialException, SSLConfigurationException,
			OAuthException {
		AuthenticationService auth = new AuthenticationService();
		ConnectionManager connectionMgr = ConnectionManager.getInstance();
		HttpConnection connection = connectionMgr.getConnection();
		HttpConfiguration httpConfiguration = new HttpConfiguration();
		httpConfiguration.setEndPointUrl(UnitTestConstants.API_ENDPOINT);
		Map<String, String> map = auth.getPayPalHeaders(
				UnitTestConstants.API_USER_NAME, connection, null, null,
				httpConfiguration);
		return new Object[][] { new Object[] { map } };

	}
}
