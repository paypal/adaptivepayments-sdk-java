package test.core;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.paypal.core.ICredential;
import com.paypal.exception.MissingCredentialException;

public class ICredentialTest {
	ICredential cred = new ICredential() {

		@Override
		protected void validate() throws MissingCredentialException {

		}

	};

	@Test
	public void setAndGetPasswordTest() {
		cred.setPassword("1255077037");
		Assert.assertEquals("1255077037", cred.getPassword());
	}

	@Test
	public void setAndGetApplicationIdTest() {
		cred.setApplicationId("APP-80W284485P519543T");
		Assert.assertEquals("APP-80W284485P519543T", cred.getApplicationId());
	}

	@Test
	public void setAndGetUserNameTest() {
		cred.setUserName("platfo_1255077030_biz_api1.gmail.com");
		Assert.assertEquals("platfo_1255077030_biz_api1.gmail.com",
				cred.getUserName());
	}

}
