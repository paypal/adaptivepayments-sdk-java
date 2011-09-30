package test.core;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.UnitTestConstants;

import com.paypal.core.ConfigManager;
import com.paypal.core.CredentialManager;
import com.paypal.core.ICredential;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.MissingCredentialException;

public class CredentialManagerTest {
	CredentialManager cred;
	ICredential credential;

	@BeforeClass
	public void beforeClass() throws FileNotFoundException, IOException,
			MissingCredentialException {
		cred = CredentialManager.getInstance();
	}

	@Test(dataProvider = "configParams", dataProviderClass = DataProviderClass.class)
	public void getCredentialObjectTest(ConfigManager conf)
			throws InvalidCredentialException {

		credential = cred.getCredentialObject(UnitTestConstants.API_USER_NAME);
		Assert.assertNotNull(credential);
		assert (credential.getApplicationId().contains("APP"));
	}

	@Test(expectedExceptions = InvalidCredentialException.class, dataProvider = "configParams", dataProviderClass = DataProviderClass.class)
	public void getInvalidCredentialObjectTest(ConfigManager conf)
			throws Exception {
		cred.getCredentialObject("arumugam-biz_api1.paypal.com");
	}

	@Test(dataProvider = "configParams", dataProviderClass = DataProviderClass.class)
	public void checkDefaultCredentialObjectTest(ConfigManager conf)
			throws InvalidCredentialException {
		credential = cred.getCredentialObject(null);
		Assert.assertNotNull(credential);
	}

	@AfterClass
	public void afterClass() {
		cred = null;
	}

}
