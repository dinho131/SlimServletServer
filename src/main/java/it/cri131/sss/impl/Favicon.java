package it.cri131.sss.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import it.cri131.sss.RequestSkeleton;
import it.cri131.sss.SSSResponse;
import it.cri131.sss.logger.SlimLogLevel;
import it.cri131.sss.logger.SlimLogger;

public class Favicon implements RequestSkeleton {
	
	SlimLogger logger = SlimLogger.getLogger();

	@Override
	public Object doRequest(IHTTPSession session) throws IOException {
		logger.write(SlimLogLevel.DEBUG, this.getClass(), "Loading favicon");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("favicon.ico");
		File icon = new File(url.getFile());		
		InputStream is = new FileInputStream(icon);
		return new SSSResponse(Status.OK, "image/x-icon", is);
	}

}
