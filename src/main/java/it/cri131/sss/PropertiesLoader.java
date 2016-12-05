package it.cri131.sss;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	
	private static PropertiesLoader instance;
	
	private static Properties prop;
	
	private PropertiesLoader() throws IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream("mapping.properties")) {
			prop.load(resourceStream);
		}
	}
	
	public static String getProperty(String property) throws IOException {
		if(instance == null) {
			instance = new PropertiesLoader();
			System.out.println("--- LOAD PROPERTIES ---");
		}
		return prop.getProperty(property);
	}
	
}
