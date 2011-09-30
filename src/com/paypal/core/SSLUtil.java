
package com.paypal.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.paypal.exception.SSLConfigurationException;



/**
 * Default TrustManager to relax verification on server certificate.
 */
class RelaxedX509TrustManager implements X509TrustManager {
	public boolean checkClientTrusted(java.security.cert.X509Certificate[] chain) {
		return true;
	}

	public boolean isServerTrusted(java.security.cert.X509Certificate[] chain) {
		return true;
	}

	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	}

	public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
			String authType) {
	}

	public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
			String authType) {
	}
} 

public abstract class SSLUtil {
	public static KeyManagerFactory kmf = null;

	/**
	 * @param keymanagers
	 *            KeyManager[] The key managers
	 * @return SSLContext with proper client certificate
	 * @throws SSLConfigurationException 
	 * @throws IOException
	 *             if an IOException occurs
	 */
	public static SSLContext getSSLContext(KeyManager[] keymanagers,
			boolean trustAll) throws SSLConfigurationException  {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL"); // TLS, SSLv3, SSL
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(System.currentTimeMillis());
			if (trustAll) {
				TrustManager[] tm = { new RelaxedX509TrustManager() }; 
				ctx.init(keymanagers, tm, random);
			} else {
				ctx.init(keymanagers, null, random);
			}
			return ctx;
		}catch (Exception e) {
			throw new SSLConfigurationException(e.getMessage(),e);
		}
	} 
	
	/**
	 * @param trustAll
	 * @return default SSLContext if client certificate is not provided.
	 * @throws SSLConfigurationException
	 */
	public static SSLContext getDefaultSSLContext(boolean trustAll)
			throws SSLConfigurationException {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL"); // TLS, SSLv3, SSL
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(System.currentTimeMillis());

			if (trustAll) {
				TrustManager[] tm = { new RelaxedX509TrustManager() }; 
				ctx.init(null, tm, random);
			} else {
				ctx.init(null, null, random);
			}
			return ctx;
		} catch (Exception e) {
			throw new SSLConfigurationException(e.getMessage(),e);
		}

	}
	
	/**
	 * loads certificate into java keystore
	 * @param p12Path
	 * @param password
	 * @return keystore 
	 * @throws NoSuchProviderException
	 * @throws KeyStoreException
	 * @throws CertificateException
	 * @throws NoSuchAlgorithmException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static KeyStore p12ToKeyStore(String p12Path, String password)
			throws NoSuchProviderException, KeyStoreException,
			CertificateException, NoSuchAlgorithmException,
			FileNotFoundException, IOException {
		/*
		 * if (log.isDebugEnabled()) {
		 * log.debug("PPCrypto.p12ToKeyStore, keystore = " + p12Path); }
		 */
		KeyStore ks = null;
		ks = KeyStore.getInstance("PKCS12", "SunJSSE");
		FileInputStream in;
		in = new FileInputStream(p12Path);
		ks.load(in, password.toCharArray());
		return ks;
	}
	
	/**
	 * Create a SSLContext with certificate provided
	 * @param cert_path
	 * @param cert_password
	 * @param trustAll
	 * @return SSLContext
	 * @throws SSLConfigurationException
	 */
	public static SSLContext setupClientSSL(String cert_path, String cert_password, boolean trustAll)
			throws SSLConfigurationException {
		SSLContext sslContext=null;
		try {
			
			kmf = KeyManagerFactory.getInstance("SunX509");
			KeyStore ks = p12ToKeyStore(cert_path, cert_password);
			kmf.init(ks, cert_password.toCharArray());
			sslContext=getSSLContext(kmf.getKeyManagers(), trustAll);
			
		} catch (NoSuchAlgorithmException e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		} catch (KeyStoreException e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		} catch (UnrecoverableKeyException e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		} catch (CertificateException e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		} catch (NoSuchProviderException e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		} catch (IOException e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		}
		return sslContext;
	}
}
