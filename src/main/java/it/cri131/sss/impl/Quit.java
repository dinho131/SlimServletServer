package it.cri131.sss.impl;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import it.cri131.sss.RequestSkeleton;

public class Quit implements RequestSkeleton {

	@Override
	public Object doRequest(IHTTPSession session) throws Exception {
		System.out.println("Exiting...");
		System.exit(0);
		return null;
	}

}
