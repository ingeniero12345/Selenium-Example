package com.hernan.test;
import org.junit.*;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class OpenWeatherMap {
	 private StringBuffer verificationErrors = new StringBuffer();
	
	 @Test
	  public void testOpenWeatherMapPSL() throws Exception {
			Client cliente= ClientBuilder.newClient();
			WebTarget target=cliente.target("http://api.openweathermap.org/data/2.5/weather?q=London&APPID=60df05c61e2bbbc3925f9fc27692a6d7");
			try {
				target.request(MediaType.TEXT_XML).get(String.class);
			} catch (Exception e) {
		         verificationErrors.append(e.toString());
			}  
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
			      fail(verificationErrorString);
			}
	  }
}
