package br.com.yuri.matrixAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
	private static final String GOOGLE_API_KEY = "TYPE YOUR GOOGLE API KEY";
	private static final String MATRIX_API_URL = "https://maps.googleapis.com/maps/api/distancematrix/";

	public static void main(String[] args) throws IOException {
		URL url = new GoogleMatrixURLBuilder(MATRIX_API_URL)
				.googleAPIKey(GOOGLE_API_KEY)
				.origins("Seattle")
				.destinations("San Francisco")
				.responseDataType(ResponseDataType.JSON)
				.language("pt-BR")
				.build();

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		Scanner scanner = new Scanner(connection.getInputStream());
		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}

	}
}
