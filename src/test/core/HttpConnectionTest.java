package test.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.core.ConfigManager;
import com.paypal.core.ConnectionManager;
import com.paypal.core.HttpConfiguration;
import com.paypal.core.HttpConnection;
import com.paypal.exception.SSLConfigurationException;

public class HttpConnectionTest {
	HttpConnection connection;
	HttpConfiguration httpConfiguration;

	@BeforeClass
	public void beforeClass() throws MalformedURLException, IOException {
		ConnectionManager connectionMgr = ConnectionManager.getInstance();
		connection = connectionMgr.getConnection();
		httpConfiguration = new HttpConfiguration();

	}

	@Test(dataProvider = "configParams", dataProviderClass = DataProviderClass.class)
	public void setupClientSSLTest(ConfigManager conf)
			throws SSLConfigurationException {
		connection.setupClientSSL(null, null, true);
		if (Boolean.parseBoolean(conf.getValue("http.UseProxy"))) {
			httpConfiguration.setProxyHost(conf.getValue("http.ProxyHost"));
			httpConfiguration.setProxyPassword(conf
					.getValue("http.ProxyPassword"));
			httpConfiguration.setProxyPort(Integer.parseInt(conf
					.getValue("http.ProxyPort")));
			httpConfiguration.setProxyUserName(conf
					.getValue("http.ProxyUserName"));
		}
	}

	@Test(expectedExceptions = MalformedURLException.class)
	public void checkMalformedURLExceptionTest() throws Exception {
		httpConfiguration.setEndPointUrl("ww.paypal.in");
		connection.CreateAndconfigureHttpConnection(httpConfiguration);
	}

	@Test(expectedExceptions = InvocationTargetException.class)
	public void readMethodTest() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, IOException {
		Method readMethod = HttpConnection.class.getDeclaredMethod("read",
				BufferedReader.class);
		readMethod.setAccessible(true);
		BufferedReader br = null;
		readMethod.invoke(connection, br);
	}

	@AfterClass
	public void afterClass() {
		connection = null;
		httpConfiguration = null;
	}

}
