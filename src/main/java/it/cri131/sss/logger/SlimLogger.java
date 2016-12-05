package it.cri131.sss.logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import it.cri131.sss.PropertiesLoader;

public class SlimLogger {
	
	/* Log Levels */
	public static final int OFF = 0;
	public static final int INFO = 5;
	public static final int DEBUG = 10;
	
	private static SimpleDateFormat sdf; 
	private static SlimLogger instance;
	private static int logLevel = 1;
	
	private SlimLogger() { }
	
	public static SlimLogger getLogger() {
		if(instance == null) {
			instance = new SlimLogger();
			SlimLogLevel slimLogLevel = null;
			try {
				slimLogLevel = SlimLogLevel.valueOf(PropertiesLoader.getProperty("slim.logger.level"));
			} catch (IOException e) {
				System.err.println("Cannot find property slim.logger.level");
				e.printStackTrace();
				System.exit(-1);
			}
			try {
				sdf = new SimpleDateFormat(PropertiesLoader.getProperty("slim.logger.dateformat"));
			} catch (IOException e) {
				System.err.println("Cannot find property slim.logger.dateformat");
				e.printStackTrace();
				System.exit(-1);
			}
			System.out.println("Setting log level to " + slimLogLevel.getLoglevelName() + "[" + slimLogLevel.getLogLevel() + "]");
			logLevel = slimLogLevel.getLogLevel();
		}
		return instance;
	}
	
	public void write(SlimLogLevel messageLoglevel, Class<?> clazz, String message) {
		int messageLogLevelINT = messageLoglevel.getLogLevel();
		if(messageLogLevelINT <= logLevel) {
			System.out.println(sdf.format(new Date()) + " (" + messageLoglevel.getLoglevelName() + ") [" + clazz.getName() + "] - " + message);
		}
	}

}
