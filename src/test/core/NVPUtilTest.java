package test.core;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.paypal.core.NVPUtil;

public class NVPUtilTest {

	@Test
	public void decodeTest() throws UnsupportedEncodingException {
		String nvpString = "responseEnvelope.timestamp=2011-05-17T21%3A24%3A44.279-07%3A00&responseEnvelope.ack=Success&responseEnvelope.correlationId=ca0c236593634&responseEnvelope.build=1901705&invoiceID=INV2-AAWE-TAQW-7UXT-ZHBY&invoiceNumber=INV-00404";
		Map<String, String> map = NVPUtil.decode(nvpString);
		Assert.assertEquals(6, map.size());
		assert (map.containsValue("Success"));
		assert (map.containsKey("invoiceID"));
		assert (map.containsKey("invoiceNumber"));
		Assert.assertEquals("INV2-AAWE-TAQW-7UXT-ZHBY", map.get("invoiceID"));
		Assert.assertEquals("INV-00404", map.get("invoiceNumber"));
	}

	@Test
	public void encodeTest() throws UnsupportedEncodingException {
		String value = "jbui-us-personal1@paypal.com";
		Assert.assertEquals("jbui-us-personal1%40paypal.com",
				NVPUtil.encodeUrl(value));
	}
}
