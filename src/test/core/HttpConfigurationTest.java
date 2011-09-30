package test.core;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.paypal.core.HttpConfiguration;

public class HttpConfigurationTest {
	HttpConfiguration httpConf;

	@BeforeClass
	public void beforeClass() {
		httpConf = new HttpConfiguration();
	}

	@AfterClass
	public void afterClass() {
		httpConf = null;
	}

	@Test(priority = 0)
	public void getConnectionTimeoutTest() {
		Assert.assertEquals(0, httpConf.getConnectionTimeout());
	}

	@Test(priority = 1)
	public void getEndPointUrlTest() {
		Assert.assertEquals(null, httpConf.getEndPointUrl());
	}

	@Test(priority = 2)
	public void getMaxHttpConnectionTest() {
		Assert.assertEquals(10, httpConf.getMaxHttpConnection());
	}

	@Test(priority = 3)
	public void getMaxRetryTest() {
		Assert.assertEquals(2, httpConf.getMaxRetry());
	}

	@Test(priority = 4)
	public void getProxyHostTest() {
		Assert.assertEquals(null, httpConf.getProxyHost());
	}

	@Test(priority = 5)
	public void getProxyPortTest() {
		Assert.assertEquals(-1, httpConf.getProxyPort());
	}

	@Test(priority = 6)
	public void getReadTimeoutTest() {
		Assert.assertEquals(0, httpConf.getReadTimeout());
	}

	@Test(priority = 7)
	public void getRetryDelayTest() {
		Assert.assertEquals(1000, httpConf.getRetryDelay());
	}

	@Test(priority = 9)
	public void isProxySetTest() {
		Assert.assertEquals(false, httpConf.isProxySet());
	}

	@Test(priority = 10)
	public void isTrustAllTest() {
		Assert.assertEquals(true, httpConf.isTrustAll());
	}

	@Test(priority = 11)
	public void setAndGetConnectionTimeoutTest() {
		httpConf.setConnectionTimeout(5000);
		Assert.assertEquals(5000, httpConf.getConnectionTimeout());
	}

	@Test(priority = 12)
	public void setAndGetEndPointUrlTest() {
		httpConf.setEndPointUrl("https://svcs.sandbox.paypal.com/Invoice/CreateInvoice");
		Assert.assertEquals(
				"https://svcs.sandbox.paypal.com/Invoice/CreateInvoice",
				httpConf.getEndPointUrl());
	}

	@Test(priority = 14)
	public void setAndGetMaxHttpConnectionTest() {
		httpConf.setMaxHttpConnection(3);
		Assert.assertEquals(3, httpConf.getMaxHttpConnection());
	}

	@Test(priority = 15)
	public void setAndGetMaxRetryTest() {
		httpConf.setMaxRetry(2);
		Assert.assertEquals(2, httpConf.getMaxRetry());
	}

	@Test(priority = 16)
	public void setAndGetProxyHostTest() {
		httpConf.setProxyHost(null);
		Assert.assertEquals(null, httpConf.getProxyHost());
	}

	@Test(priority = 17)
	public void setAndGetProxyPortTest() {
		httpConf.setProxyPort(8080);
		Assert.assertEquals(8080, httpConf.getProxyPort());
	}

	@Test(priority = 18)
	public void setAndIsProxySetTest() {
		httpConf.setProxySet(true);
		Assert.assertEquals(true, httpConf.isProxySet());
	}

	@Test(priority = 19)
	public void setAndGetReadTimeoutTest() {
		httpConf.setReadTimeout(10);
		Assert.assertEquals(10, httpConf.getReadTimeout());
	}

	@Test(priority = 20)
	public void setAndGetRetryDelayTest() {
		httpConf.setRetryDelay(30);
		Assert.assertEquals(30, httpConf.getRetryDelay());
	}

	@Test(priority = 21)
	public void setAndIsTrustAllTest() {
		httpConf.setTrustAll(true);
		Assert.assertEquals(true, httpConf.isTrustAll());
	}
}
