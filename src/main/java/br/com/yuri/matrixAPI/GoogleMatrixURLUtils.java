package br.com.yuri.matrixAPI;

import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.URIUtil;

public class GoogleMatrixURLUtils {
	public static String concatLocations(String... locations) {
		StringBuilder concatenatedLocations = new StringBuilder();

		for (int index = 0; index < locations.length; index++) {
			if (index != 0) {
				concatenatedLocations.append("|");
			}

			concatenatedLocations.append(locations[index]);
		}

		return concatenatedLocations.toString();
	}

	public static String encodeURL(String url) {
		try {
			return URIUtil.encodeQuery(url, "UTF-8");
		} catch (URIException e) {
			throw new RuntimeException(e);
		}
	}
}
