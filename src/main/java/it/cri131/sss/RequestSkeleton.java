package it.cri131.sss;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;

public interface RequestSkeleton {

	public Object doRequest(IHTTPSession session) throws Exception;
	
}
