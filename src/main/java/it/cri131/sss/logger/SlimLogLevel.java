package it.cri131.sss.logger;

public enum SlimLogLevel {
	
	OFF("  OFF", 0),
	INFO(" INFO", 5),
	DEBUG("DEBUG", 10);
	
	private String logLevelName;
	private int logLevel;
	
	public String getLoglevelName() {
		return logLevelName;
	}
	
	public int getLogLevel() {
		return logLevel;
	}
	
	private SlimLogLevel(String loglevelName, int loglevel) {
		this.logLevelName = loglevelName;
		this.logLevel = loglevel;
	}

}
