package br.com.yuri.matrixAPI;

import java.net.MalformedURLException;
import java.net.URL;

import javax.management.RuntimeErrorException;

import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.URIUtil;

public class GoogleMatrixURLBuilder {

	private String googleMatrixURLBase;
	private String[] origins;
	private String[] destinations;
	private ResponseDataType responseDataType;
	private String googleAPIKey;
	private String language;

	public GoogleMatrixURLBuilder(String googleMatrixURLBase) {
		super();
		this.googleMatrixURLBase = googleMatrixURLBase;
	}

	public GoogleMatrixURLBuilder googleAPIKey(String googleAPIKey) {
		this.googleAPIKey = googleAPIKey;
		return this;
	}

	public GoogleMatrixURLBuilder responseDataType(ResponseDataType responseDataType) {
		this.responseDataType = responseDataType;
		return this;
	}

	public GoogleMatrixURLBuilder origins(String... origins) {
		this.origins = origins;
		return this;
	}

	public GoogleMatrixURLBuilder destinations(String... destionations) {
		this.destinations = destionations;
		return this;
	}

	public GoogleMatrixURLBuilder language(String language) {
		this.language = language;
		return this;
	}

	private void validateParameters() {
		if (origins.length < 0) {
			throw new RuntimeException("Origin is required");
		}

		if (destinations.length < 0) {
			throw new RuntimeException("Destination is required");
		}

		if (googleAPIKey.isEmpty() || googleAPIKey == null) {
			throw new RuntimeException("Google API Key is required");
		}

	}

	public URL build() {
		validateParameters();

		String responseDataTypeParam = "";
		if (responseDataType != null) {
			responseDataTypeParam += responseDataType.getValue() + "?";
		} else {
			responseDataTypeParam += ResponseDataType.JSON.getValue() + "?";
		}

		String originsParam = "origins=" + GoogleMatrixURLUtils.concatLocations(origins);
		String destinationsParam = "&destinations=" + GoogleMatrixURLUtils.concatLocations(destinations);
		String googleAPIKeyParam = "&key=" + googleAPIKey;
		
		String googleMatrixURLRequest = googleMatrixURLBase + responseDataTypeParam + originsParam + destinationsParam + googleAPIKeyParam;

		String encodedUrl = GoogleMatrixURLUtils.encodeURL(googleMatrixURLRequest);

		try {
			return new URL(encodedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

}
