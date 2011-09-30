package test.core;

import junit.framework.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.paypal.core.CertificateCredential;
import com.paypal.core.ICredential;
import com.paypal.exception.MissingCredentialException;

public class CertificateCredentialTest {

	ICredential cred;

	@BeforeClass
	public void beforeClass() throws MissingCredentialException {
		cred = new CertificateCredential(
				"platfo_1255077030_biz_api1.gmail.com", "1255077037",
				"resource/sdk-cert.p12", "KJAERUGBLVF6Y",
				"APP-80W284485P519543T");
	}

	@Test(priority=0)
	public void getCertificatePathTest() {
		Assert.assertEquals("resource/sdk-cert.p12",
				((CertificateCredential) cred).getCertificatePath());
	}

	@Test(priority=1)
	public void getCertificateKeyTest() {
		Assert.assertEquals("KJAERUGBLVF6Y",
				((CertificateCredential) cred).getCertificateKey());
	}

	@Test(priority=2)
	public void getApplicationIdTest() {
		Assert.assertEquals("APP-80W284485P519543T", cred.getApplicationId());
	}

	@Test(priority=3)
	public void getPasswordTest() {
		Assert.assertEquals("1255077037", cred.getPassword());
	}

	@Test(priority=4)
	public void getUserNameTest() {
		Assert.assertEquals("platfo_1255077030_biz_api1.gmail.com",
				cred.getUserName());
	}

	@Test(priority=5)
	public void setAndGetUserName() {
		cred.setUserName("certuser_biz_api1.paypal.com");
		Assert.assertEquals("certuser_biz_api1.paypal.com", cred.getUserName());
	}

	@Test(priority=6)
	public void setAndGetPassword() {
		cred.setPassword("D6JNKKULHN3G5B8A");
		Assert.assertEquals("D6JNKKULHN3G5B8A", cred.getPassword());
	}

	@Test(priority=7)
	public void setAndGetAppId() {
		cred.setApplicationId("APP-80W284485P519543T");
		Assert.assertEquals("APP-80W284485P519543T", cred.getApplicationId());
	}

	@Test(priority=8)
	public void setAndGetCertPath() {
		((CertificateCredential) cred)
				.setCertificatePath("src/resource/sdk-cert.p12");
		Assert.assertEquals("src/resource/sdk-cert.p12",
				((CertificateCredential) cred).getCertificatePath());
	}

	@Test(priority=9)
	public void setAndGetCertKey() {
		((CertificateCredential) cred).setCertificateKey("password");
		Assert.assertEquals("password",
				((CertificateCredential) cred).getCertificateKey());
	}

	@Test(expectedExceptions = MissingCredentialException.class,priority=10)
	public void validateTestForUserName() throws Exception {
		cred = new CertificateCredential(null, "1255077037",
				"resource/sdk-cert.p12", "KJAERUGBLVF6Y",
				"APP-80W284485P519543T");
		((CertificateCredential) cred).validate();
	}
	
	@Test(expectedExceptions = MissingCredentialException.class,priority=10)
	public void validateTestForPassword() throws Exception {
		cred = new CertificateCredential("platfo_1255077030_biz_api1.gmail.com", null,
				"resource/sdk-cert.p12", "KJAERUGBLVF6Y",
				"APP-80W284485P519543T");
		((CertificateCredential) cred).validate();
	}
	
	@Test(expectedExceptions = MissingCredentialException.class,priority=10)
	public void validateTestForCertPath() throws Exception {
		cred = new CertificateCredential("platfo_1255077030_biz_api1.gmail.com", "1255077037",
				null, "KJAERUGBLVF6Y",
				"APP-80W284485P519543T");
		((CertificateCredential) cred).validate();
	}
	
	@Test(expectedExceptions = MissingCredentialException.class,priority=10)
	public void validateTestForCertKey() throws Exception {
		cred = new CertificateCredential("platfo_1255077030_biz_api1.gmail.com", "1255077037",
				"resource/sdk-cert.p12", null,
				"APP-80W284485P519543T");
		((CertificateCredential) cred).validate();
	}
	
	@Test(expectedExceptions = MissingCredentialException.class,priority=10)
	public void validateTestForAppId() throws Exception {
		cred = new CertificateCredential("platfo_1255077030_biz_api1.gmail.com", "1255077037",
				"resource/sdk-cert.p12", "KJAERUGBLVF6Y",
				null);
		((CertificateCredential) cred).validate();
	}

	@AfterClass
	public void afterClass() {
		cred = null;

	}
}
