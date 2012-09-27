package com.paypal.core;

import java.io.FileInputStream;
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

import com.paypal.exception.SSLConfigurationException;

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
	public static SSLContext getSSLContext(KeyManager[] keymanagers) throws SSLConfigurationException  {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL"); // TLS, SSLv3, SSL
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(System.currentTimeMillis());
			ctx.init(keymanagers, null, random);		
			return ctx;
		} catch (Exception e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		}
	}

	/**
	 * @return default SSLContext if client certificate is not provided.
	 * @throws SSLConfigurationException
	 */
	public static SSLContext getDefaultSSLContext()
			throws SSLConfigurationException {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL"); // TLS, SSLv3, SSL
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(System.currentTimeMillis());
			ctx.init(null, null, random);
			return ctx;
		} catch (Exception e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		}

	}

	/**
	 * loads certificate into java keystore
	 * 
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
			CertificateException, NoSuchAlgorithmException, IOException {
		KeyStore ks = null;
		ks = KeyStore.getInstance("PKCS12", "SunJSSE");
		FileInputStream in = null;
		try {
			in = new FileInputStream(p12Path);
			ks.load(in, password.toCharArray());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return ks;
	}

	/**
	 * Create a SSLContext with certificate provided
	 * 
	 * @param certPath
	 * @param certPassword
	 * @return SSLContext
	 * @throws SSLConfigurationException
	 */
	public static SSLContext setupClientSSL(String cert_path, String cert_password)
			throws SSLConfigurationException {
		SSLContext sslContext = null;
		try {

			kmf = KeyManagerFactory.getInstance("SunX509");
			KeyStore ks = p12ToKeyStore(cert_path, cert_password);
			kmf.init(ks, cert_password.toCharArray());
			sslContext=getSSLContext(kmf.getKeyManagers());
			
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
