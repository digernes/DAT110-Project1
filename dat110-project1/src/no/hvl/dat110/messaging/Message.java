package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length <= MessageConfig.SEGMENTSIZE-1) {
			this.payload = payload; // TODO: check for length within boundary
		} else {
			System.out.println("Feilmelding: Melding er for lang til å bli konstruert.");
			payload = new byte[0];
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte) payload.length;
		for (int i = 0; i < payload.length; i++) {
			encoded[i+1] = payload[i];
		}
		// TODO
		// encapulate/encode the payload of the message

//		if (true) {
//			throw new RuntimeException("not yet implemented");
//		}

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		int len = (int) received[0];
		byte[] midl = new byte[len];
		for (int i = 0; i < midl.length; i++) {
			midl[i] = received[i + 1];
		}
		payload = midl;
	}
}
