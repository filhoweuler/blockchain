package blockchain;

import java.util.Date.*;
import java.security.MessageDigest;

class Block {
	int index;
	long timestamp;
	Data data;
	Block last;
	String lastHash;

	Block (int index, long timestamp, Data data, Block last) {
		this.index = index;
		this.timestamp = timestamp;
		this.data = data;
		this.last = last;

		lastHash = null;
		if(last != null)
			this.lastHash = hashBlock(last);
	}

	int getIndex() {
		return index;
	}

	Block (Block b, Data data) { //usamos b para ser o bloco anterior do bloco sendo criado
		this.index = 0;
		if(b != null) 
			this.index = b.getIndex() + 1;
		
		this.timestamp = System.currentTimeMillis();
		this.data = data;
		this.last = b;
		
		this.lastHash = null;
		if(b != null)
			this.lastHash = hashBlock(b);
	}

	public String hashBlock(Block b) {
		byte[] hash = null;

		try {
			MessageDigest d = MessageDigest.getInstance("SHA-256");
			String s = b.index + b.timestamp + b.data.getInfo() + lastHash;
			hash = d.digest(s.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[hash.length * 2];
	    for ( int j = 0; j < hash.length; j++ ) {
	        int v = hash[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
		
		return new String(hexChars);
	}
}