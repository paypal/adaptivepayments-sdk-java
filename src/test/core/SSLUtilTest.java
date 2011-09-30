package test.core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import test.UnitTestConstants;

import com.paypal.core.SSLUtil;
import com.paypal.exception.SSLConfigurationException;

public class SSLUtilTest {

	@Test
	public void getDefaultSSLContextTest() throws SSLConfigurationException {
		Assert.assertNotNull(SSLUtil.getDefaultSSLContext(true));
		Assert.assertNotNull(SSLUtil.getDefaultSSLContext(false));
	}

	@Test
	public void getSSLContextTest() throws SSLConfigurationException,
			NoSuchAlgorithmException, NoSuchProviderException,
			KeyStoreException, CertificateException, FileNotFoundException,
			IOException, UnrecoverableKeyException {

		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		KeyStore ks = SSLUtil.p12ToKeyStore(UnitTestConstants.CERT_PATH,
				UnitTestConstants.CERT_PASSWORD);
		kmf.init(ks, UnitTestConstants.CERT_PASSWORD.toCharArray());
		Assert.assertNotNull(SSLUtil.getSSLContext(kmf.getKeyManagers(), true));
		Assert.assertNotNull(SSLUtil.getSSLContext(kmf.getKeyManagers(), false));
	}

	@Test
	public void p12ToKeyStoreTest() throws NoSuchProviderException,
			KeyStoreException, CertificateException, NoSuchAlgorithmException,
			FileNotFoundException, IOException {
		Assert.assertNotNull(SSLUtil.p12ToKeyStore(UnitTestConstants.CERT_PATH,
				UnitTestConstants.CERT_PASSWORD));
	}

	@Test
	public void setupClientSSLTest() throws SSLConfigurationException {
		Assert.assertNotNull(SSLUtil.setupClientSSL(
				UnitTestConstants.CERT_PATH, UnitTestConstants.CERT_PASSWORD,
				true));
	}

	@Test(expectedExceptions = SSLConfigurationException.class)
	public void setupClientSSLExceptionTest() throws Exception {
		Assert.assertNotNull(SSLUtil.setupClientSSL("src/sdk_cert.p12",
				UnitTestConstants.CERT_PASSWORD, true));
	}
}
