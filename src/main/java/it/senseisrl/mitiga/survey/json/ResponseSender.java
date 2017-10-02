package it.senseisrl.mitiga.survey.json;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class ResponseSender {

	public static void OKHttp(JSONObject editedJSON) throws IOException {
		// String JSON = jsonObject.toJSONString();
		OkHttpClient client = new OkHttpClient();

		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
				editedJSON.toJSONString());

		Request request = new Request.Builder()
				.url("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate")
				.put(body).addHeader("accept-encoding", "gzip, deflate")
				.addHeader("content-type", "application/json;charset=UTF-8")
				.addHeader("accept", "application/json, text/plain, */*").addHeader("iv-user", "ADMIN").build();

		Call call = client.newCall(request);
		Response response = call.execute();
		System.out.println("Response Code: " + response.code() + "\n" + response.message() + "\n" + response.headers());
	}

	public static void HttpPut(String string) throws IOException {
		URL url = new URL("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setDoOutput(true);

		// HTTP param
		connection.setRequestProperty("iv-user", "ADMIN");
		connection.addRequestProperty("content-type", "application/json");
		connection.addRequestProperty("postman-token", "d4e659f7-22e7-58ce-d6f3-3a9319dc69ec");
		connection.addRequestProperty("cache-control", "no-cache");
		
		OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
		osw.write(string);
		osw.flush();
		osw.close();

		if(connection.getResponseCode() != 200)
			System.err.println("RESPONSE CODE: " + connection.getResponseCode() + "\n" + "RESPONSE MESSAGE: "
				+ connection.getResponseMessage() + "\n" + "INFO: " + connection.getInputStream());
		else
			System.out.println("RESPONSE CODE: " + connection.getResponseCode() );
	}

	public static void HttpPutRequest(String string) throws IOException {
		URL url = null;
		HttpURLConnection httpURLConnection = null;
		try {
			url = new URL("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate");
		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		}

		DataOutputStream dataOutputStream = null;
		try {
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
			httpURLConnection.setRequestProperty("iv-user", "ADMIN");
			httpURLConnection.setRequestMethod("PUT");
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
			dataOutputStream.writeUTF(string);

		} catch (IOException exception) {
			exception.printStackTrace();
		} finally {
			if (dataOutputStream != null) {
				System.out.println("TRY FLUSH");
				try {
					dataOutputStream.flush();
					dataOutputStream.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
				System.out.println("DISCONNECTED" + "\n" + httpURLConnection.getResponseCode());
			}
		}
	}

	public static void unirestPutRequest(String body) throws UnirestException {
		HttpResponse<String> response = Unirest
				.put("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate")
				.header("content-type", "application/json").header("iv-user", "ADMIN")
				.header("cache-control", "no-cache").header("postman-token", "d4e659f7-22e7-58ce-d6f3-3a9319dc69ec")
				.body(body).asString();

		System.out.println(response.getStatus());
	}

	public static void okHttpPutRequest(String string) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, string);
		Request request = new Request.Builder()
				.url("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate")
				.put(body).addHeader("content-type", "application/json").addHeader("iv-user", "ADMIN")
				.addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "79fe4d55-e3a7-d1e8-ae74-192ac2815b08").build();

		Response response = client.newCall(request).execute();

		System.err.println(response.code());

	}

}
