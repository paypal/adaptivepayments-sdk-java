package test.core;

import junit.framework.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.core.ICredential;
import com.paypal.core.SignatureCredential;
import com.paypal.exception.MissingCredentialException;

public class SignatureCredentialTest {

	ICredential cred;

	@BeforeClass
	public void beforeClass() throws MissingCredentialException {
		cred = new SignatureCredential("platfo_1255077030_biz_api1.gmail.com",
				"1255077037",
				"Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf",
				"APP-80W284485P519543T");
	}

	@Test(priority = 0)
	public void getSignatureTest() {
		Assert.assertEquals(
				"Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf",
				((SignatureCredential) cred).getSignature());
	}

	@Test(priority = 1)
	public void getApplicationIdTest() {
		Assert.assertEquals("APP-80W284485P519543T", cred.getApplicationId());
	}

	@Test(priority = 2)
	public void getPasswordTest() {
		Assert.assertEquals("1255077037", cred.getPassword());
	}

	@Test(priority = 3)
	public void getUserNameTest() {
		Assert.assertEquals("platfo_1255077030_biz_api1.gmail.com",
				cred.getUserName());
	}

	@Test(priority = 4)
	public void setAndGetUserName() {
		cred.setUserName("certuser_biz_api1.paypal.com");
		Assert.assertEquals("certuser_biz_api1.paypal.com", cred.getUserName());
	}

	@Test(priority = 5)
	public void setAndGetPassword() {
		cred.setPassword("D6JNKKULHN3G5B8A");
		Assert.assertEquals("D6JNKKULHN3G5B8A", cred.getPassword());
	}

	@Test(priority = 6)
	public void setAndGetAppId() {
		cred.setApplicationId("APP-80W284485P519543T");
		Assert.assertEquals("APP-80W284485P519543T", cred.getApplicationId());
	}

	@Test(priority = 7)
	public void setAndGetSignature() {
		((SignatureCredential) cred)
				.setSignature("Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf");
		Assert.assertEquals(
				"Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf",
				((SignatureCredential) cred).getSignature());
	}

	@Test(expectedExceptions = MissingCredentialException.class, priority = 8)
	public void validateTest() throws Exception {
		cred = new SignatureCredential(null, "1255077037",
				"Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf",
				"APP-80W284485P519543T");
		((SignatureCredential) cred).validate();
	}

	@Test(expectedExceptions = MissingCredentialException.class, priority = 10)
	public void validateTestForAppId() throws Exception {
		cred = new SignatureCredential("platfo_1255077030_biz_api1.gmail.com",
				"1255077037",
				"Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf",
				null);
		((SignatureCredential) cred).validate();
	}

	@Test(expectedExceptions = MissingCredentialException.class, priority = 10)
	public void validateTestForSignature() throws Exception {
		cred = new SignatureCredential("platfo_1255077030_biz_api1.gmail.com",
				"1255077037", null, "APP-80W284485P519543T");
		((SignatureCredential) cred).validate();
	}

	@Test(expectedExceptions = MissingCredentialException.class, priority = 10)
	public void validateTestForPassword() throws Exception {
		cred = new SignatureCredential("platfo_1255077030_biz_api1.gmail.com",
				null,
				"Abg0gYcQyxQvnf2HDJkKtA-p6pqhA1k-KTYE0Gcy1diujFio4io5Vqjf",
				"APP-80W284485P519543T");
		((SignatureCredential) cred).validate();
	}

	@AfterClass
	public void afterClass() {
		cred = null;
	}
}
