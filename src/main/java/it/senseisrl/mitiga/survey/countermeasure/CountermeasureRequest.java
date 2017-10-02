package it.senseisrl.mitiga.survey.countermeasure;

import java.io.IOException;

import org.json.simple.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class CountermeasureRequest {

	public static void okHttpPutRequest(JSONObject jsonObject) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, jsonObject.toJSONString());
		Request request = new Request.Builder()
				.url("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate")
				.put(body).addHeader("content-type", "application/json").addHeader("iv-user", "ADMIN")
				.addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "79fe4d55-e3a7-d1e8-ae74-192ac2815b08").build();

		Response response = client.newCall(request).execute();

		if (response.code() != 200)
			System.err.println("RESPONSE CODE: " + response.code() + "\n" + "RESPONSE MESSAGE: " + response.message()
					+ "\n" + "SUCCESSFUL?: " + response.isSuccessful());
		else
			System.out.println("RESPONSE CODE: " + response.code());

	}

	public static void unirestPutRequest(JSONObject jsonObject) throws UnirestException {
		HttpResponse<String> response = Unirest
				.put("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false")
				.header("content-type", "application/json").header("iv-user", "ADMIN")
				.header("cache-control", "no-cache").header("postman-token", "d4e659f7-22e7-58ce-d6f3-3a9319dc69ec")
				.body(jsonObject.toString()).asString();

		System.out.println(response.getStatusText());

	}
}
