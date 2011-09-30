package test.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import junit.framework.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.core.BaseService;

public class BaseServiceTest {
	BaseService service;
	String filePath = "src/config.properties";

	@BeforeClass
	public void beforeClass() {
		service = new BaseService("Service", "1.6.0");
	}

	@AfterClass
	public void afterClass() {
		service = null;
	}

	@Test
	public void getServiceNameTest() {
		Assert.assertEquals("Service", service.getServiceName());
	}

	@Test
	public void getVersionTest() {
		Assert.assertEquals("1.6.0", service.getVersion());
	}

	@Test(expectedExceptions = FileNotFoundException.class)
	public void initConfigTestUsingFilePath() throws Exception {
		BaseService.initConfig(filePath);
	}

	@Test(expectedExceptions = FileNotFoundException.class)
	public void initConfigTestUsingFile() throws Exception {
		File file = new File(filePath);
		BaseService.initConfig(file);
	}

	@Test(expectedExceptions = FileNotFoundException.class)
	public void initConfigTestUsingInputStream() throws Exception {
		InputStream is = new FileInputStream(new File(filePath));
		BaseService.initConfig(is);
	}

}
