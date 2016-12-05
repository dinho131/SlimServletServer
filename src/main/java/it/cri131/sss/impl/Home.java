package it.cri131.sss.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import it.cri131.sss.RequestSkeleton;
import it.cri131.sss.SSSResponse;

public class Home implements RequestSkeleton {

	@Override
	public java.lang.Object doRequest(IHTTPSession session) throws Exception {
		InputStream stream = new ByteArrayInputStream("<h2>SimpleServletServer Started</h2>".getBytes(StandardCharsets.UTF_8));
		return new SSSResponse(Status.OK, "text/html", stream);
	}

}
