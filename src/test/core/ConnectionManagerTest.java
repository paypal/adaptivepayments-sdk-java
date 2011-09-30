package test.core;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.core.ConnectionManager;
import com.paypal.core.HttpConnection;

public class ConnectionManagerTest {
	ConnectionManager conn;
	HttpConnection http;

	@BeforeClass
	public void beforeClass() {
		conn = ConnectionManager.getInstance();
		http = conn.getConnection();
	}

	@Test
	public void getConnectionTest() {
		Assert.assertNotNull(http);
	}

	@AfterClass
	public void afterClass() {
		conn = null;
		http = null;

	}

}
