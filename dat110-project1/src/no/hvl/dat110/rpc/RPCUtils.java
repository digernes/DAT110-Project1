package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {
		if (str.length() < 128) {
			byte[] marshalled = new byte[str.length() + 1];
			byte[] encoded;
			encoded = str.getBytes();
			marshalled[0] = rpcid;
			for(int i = 0; i < marshalled.length; i++) {
				marshalled[i+1] = encoded[i];
			}
			return encoded;
		}
		else {
			throw new RuntimeException("Teksten er for lang.");
		}
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		
		byte[] intbytes = BigInteger.valueOf(x).toByteArray();
		encoded[0] = rpcid;
		for(int i = 0; i < intbytes.length; i++) {
			encoded[i+1] = intbytes[i];
		}
		
		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		byte[] intbytes = new byte[data.length-1];
		
		// TODO: unmarshall integer contained in data

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return decoded;

	}
}
