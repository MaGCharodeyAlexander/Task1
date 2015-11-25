package com.google.gwt.sample.convv.ConvV.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface Convert extends RemoteService {
	String ConvServer(String value) throws IllegalArgumentException;
}
