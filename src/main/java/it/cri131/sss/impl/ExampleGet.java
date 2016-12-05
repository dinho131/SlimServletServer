package it.cri131.sss.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fi.iki.elonen.NanoHTTPD.IHTTPSession;
import fi.iki.elonen.NanoHTTPD.Method;
import it.cri131.sss.RequestSkeleton;

public class ExampleGet implements RequestSkeleton {

	@Override
	public Object doRequest(IHTTPSession session) throws Exception {
		
		if(!session.getMethod().equals(Method.GET)) {
			return "Method not allowed: " + session.getMethod().name();
		}
		
		String outMessage = "";
		
		Map<String, List<String>> parameters = session.getParameters();
		
		Set<String> keys = parameters.keySet();
		for(String key : keys) {
			System.out.println("Key: " + key + " - Param: " + parameters.get(key).get(0));
			outMessage += "Parameter: " + key + " - value: " + parameters.get(key).get(0) + "<br/>";
		}
		
		return null;
	}

}
