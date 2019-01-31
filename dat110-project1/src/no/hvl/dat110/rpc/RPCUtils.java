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
			for (int i = 0; i < marshalled.length; i++) {
				marshalled[i + 1] = encoded[i];
			}
			return encoded;
		} else {
			throw new RuntimeException("Teksten er for lang.");
		}
	}

	public static String unmarshallString(byte[] data) {
		String decoded = "";
		for (int i = 0; i < data.length + 1; i++) {
			data[i] = data[i + 1];
		}
		decoded = data.toString();
		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;

		// TODO: marshall RPC identifier in case of void type

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

		byte[] encoded = {
				rpcid, 
				(byte) ((x >> 24) & 0xFF),
				(byte) ((x >> 16) & 0xFF),
				(byte) ((x >> 8) & 0xFF),
				(byte) (x & 0xFF)   
		};

		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded = data[4] & 0xFF |
	            (data[3] & 0xFF) << 8 |
	            (data[2] & 0xFF) << 16 |
	            (data[1] & 0xFF) << 24;
		
		// TODO: unmarshall integer contained in data

		return decoded;

	}
}
