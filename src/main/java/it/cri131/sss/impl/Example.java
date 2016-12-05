package it.cri131.sss.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import it.cri131.sss.RequestSkeleton;
import it.cri131.sss.SSSResponse;

public class Example implements RequestSkeleton {

	@Override
	public Object doRequest(IHTTPSession session) throws Exception {
		InputStream stream = new ByteArrayInputStream("SimpleServletServer Example".getBytes(StandardCharsets.UTF_8));
		return new SSSResponse(Status.OK, "text/html", stream);
	}

}
