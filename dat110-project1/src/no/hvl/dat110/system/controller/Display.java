package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
		byte[] mldByte = RPCUtils.marshallString(RPCID, message);
		RPCClient klient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		klient.connect();
		byte[] svarByte = klient.call(mldByte);
		klient.disconnect();
		String svar = RPCUtils.unmarshallString(svarByte);
		
	}
}
