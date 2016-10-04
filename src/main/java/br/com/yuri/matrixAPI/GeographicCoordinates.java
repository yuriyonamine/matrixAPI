package br.com.yuri.matrixAPI;

public class GeographicCoordinates {
	private String latitude;
	private String longitude;

	public GeographicCoordinates(String latitude, String longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}
	
	
}
