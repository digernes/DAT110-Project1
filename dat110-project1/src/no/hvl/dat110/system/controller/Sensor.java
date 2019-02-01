package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		byte[] kall = RPCUtils.marshallVoid(RPCID);
		RPCClient klient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);
		klient.connect();
		byte[] byteTemp = klient.call(kall);
		temp = RPCUtils.unmarshallInteger(byteTemp);
		klient.disconnect();
		return temp;
	}
}
