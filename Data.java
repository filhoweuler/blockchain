package blockchain;

public class Data {
	String info;

	Data() {
		info = "";
	}

	Data(String s) {
		info = s;
	}

	void setInfo(String s) {
		info = s;
	}

	String getInfo() {
		return info;
	}
}