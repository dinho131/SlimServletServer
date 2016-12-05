package it.cri131.sss;

import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;
import it.cri131.sss.logger.SlimLogLevel;
import it.cri131.sss.logger.SlimLogger;

public class SlimServletServer extends NanoHTTPD {

	public SlimServletServer(int port) throws IOException {
		super(port);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
	}

	public static void main(String[] args) {
		try {
			System.out.println("Starting log ");
			SlimLogger logger = SlimLogger.getLogger(); // Starts it.cri131.sss.logger
			logger.write(SlimLogLevel.INFO, SlimServletServer.class, "Logger started");
			int serverPort = Integer.parseInt(PropertiesLoader.getProperty("server.port"));
			logger.write(SlimLogLevel.INFO, SlimServletServer.class, "Starting server with port " + serverPort);
			new SlimServletServer(serverPort);
			logger.write(SlimLogLevel.INFO, SlimServletServer.class, "Server started without errors");
		} catch (IOException ioe) {
			System.err.println("Couldn't start server:\n" + ioe);
		}
	}

	@Override
	public Response serve(IHTTPSession session) {
		String outMsg = "";
		String mapping = session.getUri().substring(1);
		
		SlimLogger logger = SlimLogger.getLogger();
		logger.write(SlimLogLevel.DEBUG, SlimServletServer.class, "Called /" + mapping);
		
		if (mapping.equals("")) {
			mapping = "home";
		}
		
		try {
			String classToCall = PropertiesLoader.getProperty(mapping);
			logger.write(SlimLogLevel.DEBUG, SlimServletServer.class, "Calling class: " + classToCall);
			Class<?> genericClass = Class.forName(classToCall);
			RequestSkeleton request = (RequestSkeleton) genericClass.newInstance();

			SSSResponse respo = (SSSResponse) request.doRequest(session);
			return newChunkedResponse(respo.getHttpStatus(), respo.getMimeType(), respo.getResponse());
		} catch(Exception ex) {
			ex.printStackTrace();
			// TODO: To do better...
			return newFixedLengthResponse("ERROR");
		}
		
	}

}