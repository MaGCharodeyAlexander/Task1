package com.google.gwt.sample.convv.ConvV.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>Convert</code>.
 */
public interface ConvertAsync {
	void ConvServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
}
