package rest.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class DataUtils {

	public static final int POST_STATUS_CODE = 201;
	public static final int SUCCESS_STATUS_CODE = 200;
	public static final int DELETE_STATUS_CODE = 204;
	public static final int ERROR_STATUS_CODE = 404;

	public static void main(String[] args) throws IOException {
		String value = getConstantFileFromInput("MAP", "JSON");

		System.out.println(value);
	}

	public static String baseDataGet(String key) throws IOException {
		FileInputStream fin = new FileInputStream("files//configurations.txt");

		Properties prop = new Properties();
		prop.load(fin);
		String value = prop.getProperty(key);
		return value;
	}

	public static String getConstantFileFromInput(String filename, String extension) throws IOException {

		BufferedReader bFin = new BufferedReader(
				new FileReader("finput//" + filename.toLowerCase() + "." + extension.toLowerCase()));
		String output = "";
		String input;
		while ((input = bFin.readLine()) != null) {
			output += input;

		}
		bFin.close();

		return output;
	}
	
	public static String getJsonResponseValue(String response,String value) {
		
		JsonPath json = new JsonPath(response);
		
		return json.getString(value);
		
	}

}
