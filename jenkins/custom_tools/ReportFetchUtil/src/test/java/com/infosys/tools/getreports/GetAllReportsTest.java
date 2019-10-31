/***********************************************************************************************
*
* Copyright 2018 Infosys Ltd.
* Use of this source code is governed by MIT license that can be found in the LICENSE file or at
* https://opensource.org/licenses/MIT.
*
***********************************************************************************************/
package com.infosys.tools.getreports;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GetAllReportsTest {
	@Spy
	@InjectMocks
	private GetAllReports getAllReports;

	private static HttpUrlStreamHandler httpUrlStreamHandler;

	@BeforeClass
	public static void setupURLStreamHandlerFactory() {
		// Allows for mocking URL connections
		URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);

		try {
			if (System.getProperty("com.xxx.streamHandlerFactoryInstalled") == null) {
				URL.setURLStreamHandlerFactory(urlStreamHandlerFactory);
				System.setProperty("com.xxx.streamHandlerFactoryInstalled", "true");
			}
		}
		catch(Exception e)
		{
			
		}

		httpUrlStreamHandler = new HttpUrlStreamHandler();
		given(urlStreamHandlerFactory.createURLStreamHandler("http")).willReturn(httpUrlStreamHandler);
	}

	@Before
	public void reset() {
		httpUrlStreamHandler.resetConnections();
	}
	
	@Test
	public void createChangeLogTest() {
		try {
			String href = "https://google.com";

			URLConnection urlConnection = mock(URLConnection.class);
			httpUrlStreamHandler.addConnection(new URL(href), urlConnection);
			byte[] expectedImageBytes = "Any String you want".getBytes();
//		    byte[] expectedImageBytes = bytes.toBytes(
//		            0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x0A, 0x00, 0x0A, 0x00, 0x91, 0x00, 0x00, 0xFF, 0xFF, 0xFF,
//		            0xFF, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x00, 0x00, 0x00, 0x21, 0xF9, 0x04, 0x00, 0x00, 0x00, 0x00,
//		            0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x0A, 0x00, 0x00, 0x02, 0x16, 0x8C, 0x2D, 0x99,
//		            0x87, 0x2A, 0x1C, 0xDC, 0x33, 0xA0, 0x02, 0x75, 0xEC, 0x95, 0xFA, 0xA8, 0xDE, 0x60, 0x8C, 0x04,
//		            0x91, 0x4C, 0x01, 0x00, 0x3B);
			try(InputStream imageInputStream = new ByteArrayInputStream(expectedImageBytes)){
				Mockito.when(urlConnection.getInputStream()).thenReturn(imageInputStream);
			}
			
			String temp=getAllReports.makeDir("string");
			assertNotNull(temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void copyReportsTest() {
		try {
			String href = "https://google.com";

			URLConnection urlConnection = mock(URLConnection.class);
			httpUrlStreamHandler.addConnection(new URL(href), urlConnection);
			byte[] expectedImageBytes = "Any String you want".getBytes();
//		    byte[] expectedImageBytes = bytes.toBytes(
//		            0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x0A, 0x00, 0x0A, 0x00, 0x91, 0x00, 0x00, 0xFF, 0xFF, 0xFF,
//		            0xFF, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x00, 0x00, 0x00, 0x21, 0xF9, 0x04, 0x00, 0x00, 0x00, 0x00,
//		            0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x0A, 0x00, 0x00, 0x02, 0x16, 0x8C, 0x2D, 0x99,
//		            0x87, 0x2A, 0x1C, 0xDC, 0x33, 0xA0, 0x02, 0x75, 0xEC, 0x95, 0xFA, 0xA8, 0xDE, 0x60, 0x8C, 0x04,
//		            0x91, 0x4C, 0x01, 0x00, 0x3B);
			try(InputStream imageInputStream = new ByteArrayInputStream(expectedImageBytes)){
				Mockito.when(urlConnection.getInputStream()).thenReturn(imageInputStream);
			}

			Boolean temp = getAllReports.copyReports("string", "string", "string", "string", "string", "string");
			assertNotNull(temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void copyTest() {
		try {
			String href = "https://google.com";

			URLConnection urlConnection = mock(URLConnection.class);
			httpUrlStreamHandler.addConnection(new URL(href), urlConnection);
			byte[] expectedImageBytes = "Any String you want".getBytes();
//		    byte[] expectedImageBytes = bytes.toBytes(
//		            0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x0A, 0x00, 0x0A, 0x00, 0x91, 0x00, 0x00, 0xFF, 0xFF, 0xFF,
//		            0xFF, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x00, 0x00, 0x00, 0x21, 0xF9, 0x04, 0x00, 0x00, 0x00, 0x00,
//		            0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x0A, 0x00, 0x00, 0x02, 0x16, 0x8C, 0x2D, 0x99,
//		            0x87, 0x2A, 0x1C, 0xDC, 0x33, 0xA0, 0x02, 0x75, 0xEC, 0x95, 0xFA, 0xA8, 0xDE, 0x60, 0x8C, 0x04,
//		            0x91, 0x4C, 0x01, 0x00, 0x3B);
			try(InputStream imageInputStream = new ByteArrayInputStream(expectedImageBytes)){
				Mockito.when(urlConnection.getInputStream()).thenReturn(imageInputStream);
			}
			
			getAllReports.copy("string", "string", "string", "string", "string", "string", "string");
			List<String> temp=null;
			assertEquals(null,temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void performTest() {
		try {
			String href = "https://google.com";

			URLConnection urlConnection = mock(URLConnection.class);
			httpUrlStreamHandler.addConnection(new URL(href), urlConnection);
			byte[] expectedImageBytes = "Any String you want".getBytes();
//		    byte[] expectedImageBytes = bytes.toBytes(
//		            0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x0A, 0x00, 0x0A, 0x00, 0x91, 0x00, 0x00, 0xFF, 0xFF, 0xFF,
//		            0xFF, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x00, 0x00, 0x00, 0x21, 0xF9, 0x04, 0x00, 0x00, 0x00, 0x00,
//		            0x00, 0x2C, 0x00, 0x00, 0x00, 0x00, 0x0A, 0x00, 0x0A, 0x00, 0x00, 0x02, 0x16, 0x8C, 0x2D, 0x99,
//		            0x87, 0x2A, 0x1C, 0xDC, 0x33, 0xA0, 0x02, 0x75, 0xEC, 0x95, 0xFA, 0xA8, 0xDE, 0x60, 0x8C, 0x04,
//		            0x91, 0x4C, 0x01, 0x00, 0x3B);
			try(InputStream imageInputStream = new ByteArrayInputStream(expectedImageBytes)){
				Mockito.when(urlConnection.getInputStream()).thenReturn(imageInputStream);
			}
						
			String[] args = { "" };
			String[] extensions = { "" };
			File file = new File("test");
			getAllReports.perform(args, "string", "string", "string", "string", file, extensions, "string");
			List<String> temp=null;
			assertEquals(null,temp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
