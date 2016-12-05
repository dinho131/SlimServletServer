package it.cri131.sss.impl;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import it.cri131.sss.RequestSkeleton;

public class JourneyCounter implements RequestSkeleton {
	
	private static int counter = 0;

	@Override
	public String doRequest(IHTTPSession session) throws Exception {
		counter++;
		//return "" + counter;
		return null;
	}

}
