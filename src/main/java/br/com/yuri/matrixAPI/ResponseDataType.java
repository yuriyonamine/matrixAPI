package br.com.yuri.matrixAPI;

public enum ResponseDataType {
	JSON("json"), XML("xml");

	private String value;

	ResponseDataType(String value) {
		this.value = value;
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
