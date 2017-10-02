package it.senseisrl.mitiga.survey.countermeasure;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class CountermeasureBuilder {

	/**
	 * Print the entire response retrieve by OKHttp GET request.
	 * 
	 */
	public static void printResponseContent() {
		OkHttpClient client = new OkHttpClient();
		client.setReadTimeout(6, TimeUnit.SECONDS);

		Request request = new Request.Builder().url(
				"http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false")
				.get()
				// .addHeader("accept-encoding", "gzip, deflate")
				.addHeader("accept-language", "it-IT,it;q=0.8,en-US;q=0.6,en;q=0.4")
				.addHeader("user-agent",
						"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36")
				.addHeader("accept", "application/json, text/plain, */*")
				.addHeader("referer", "http://192.168.88.166:9080/mitiga/webapp/")
				.addHeader("cookie", "triplesec.NG_TRANSLATE_LANG_KEY=it").addHeader("connection", "keep-alive")
				.addHeader("iv-user", "ADMIN").addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "3339f944-d0f9-3b12-1733-7ef9b132b9d9").build();

		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	final static String path = "C://Users//Giuseppe D'Agostino//eclipse-workspace//testingDataGenerator//jsonResponse.txt";

	/**
	 * DESERIALIZE Take json from gate request, scan for desired element, edit them
	 * and try to do more stuff
	 *
	 * @return HashMap<Integer, Countermeasure>
	 * @throws IOException
	 */
	public static HashMap<Integer, Countermeasure> jsonManage() throws IOException {
		OkHttpClient client = new OkHttpClient();
		client.setReadTimeout(6, TimeUnit.SECONDS);

		Request request = new Request.Builder().url(
				"http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false")
				.get()
				// .addHeader("accept-encoding", "gzip, deflate")
				.addHeader("accept-language", "it-IT,it;q=0.8,en-US;q=0.6,en;q=0.4")
				.addHeader("user-agent",
						"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36")
				.addHeader("accept", "application/json, text/plain, */*")
				.addHeader("referer", "http://192.168.88.166:9080/mitiga/webapp/")
				.addHeader("cookie", "triplesec.NG_TRANSLATE_LANG_KEY=it").addHeader("connection", "keep-alive")
				.addHeader("iv-user", "ADMIN").addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "3339f944-d0f9-3b12-1733-7ef9b132b9d9").build();

		Response response = client.newCall(request).execute();

		JSONObject temp = new JSONObject();

		HashMap<Integer, Countermeasure> hashMap = new HashMap<Integer, Countermeasure>();

		JSONParser parser = new JSONParser();
		// JSONObject jsonObject = new JSONObject();

		try {
			temp = (JSONObject) parser.parse(response.body().string());
			// jsonObject = (JSONObject) parser.parse(new FileReader(path));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// as deep as possible
		JSONObject jLevel0 = (JSONObject) temp.get("body"); // body
		JSONObject jLevel1 = (JSONObject) jLevel0.get("bodyAnswers"); // bodyAnswers
		JSONArray jLevel2_Array = (JSONArray) jLevel1.get("threatResponses"); // threatResponses

		if (jLevel2_Array.size() == 0) {
			System.err.print("EMPTY JSON OBJECT");
		} else
			for (int i = 0; i < jLevel2_Array.size(); i++) {
				JSONObject allCountermeasures = (JSONObject) jLevel2_Array.get(i);
				for (int j = 0; j < allCountermeasures.size(); j++) {
					JSONArray jCountermeasuresArray = (JSONArray) allCountermeasures.get("countermeasures");
					for (int k = 0; k < jCountermeasuresArray.size(); k++) {
						JSONObject jCountermeasures = (JSONObject) jCountermeasuresArray.get(k);

						Countermeasure countermeasure = new Countermeasure(); // my model

						countermeasure.setMitigation(jCountermeasures.get("mitigation").toString());
						countermeasure.setApplication(jCountermeasures.get("application").toString());
						countermeasure.setNote((String) jCountermeasures.get("note"));
						countermeasure.setUserName((String) jCountermeasures.get("userName"));
						countermeasure.setValidationNote((String) jCountermeasures.get("validationNote"));
						countermeasure.setProbabilityControlId((String) jCountermeasures.get("probabilityControlId"));
						countermeasure.setCounterMeasureId((String) jCountermeasures.get("counterMeasureId"));
						countermeasure.setUserId((String) jCountermeasures.get("userId"));

						hashMap.put(k, countermeasure);
					}
				}
			}
		return hashMap;
	}

	/**
	 * Version II DESERIALIZE Take json from gate request, scan for desired element,
	 * edit them and try to do more stuff
	 *
	 * @return JSONObject
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject jsonManageII() throws IOException {
		OkHttpClient client = new OkHttpClient();
		client.setReadTimeout(6, TimeUnit.SECONDS);

		Request request = new Request.Builder().url(
				"http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false")
				.get()
				// .addHeader("accept-encoding", "gzip, deflate")
				.addHeader("accept-language", "it-IT,it;q=0.8,en-US;q=0.6,en;q=0.4")
				.addHeader("user-agent",
						"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36")
				.addHeader("accept", "application/json, text/plain, */*")
				.addHeader("referer", "http://192.168.88.166:9080/mitiga/webapp/")
				.addHeader("cookie", "triplesec.NG_TRANSLATE_LANG_KEY=it").addHeader("connection", "keep-alive")
				.addHeader("iv-user", "ADMIN").addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "3339f944-d0f9-3b12-1733-7ef9b132b9d9").build();

		Response response = client.newCall(request).execute();
		JSONObject temp = new JSONObject();
		JSONObject responseObject = new JSONObject();
		JSONParser parser = new JSONParser();

		try {
			temp = (JSONObject) parser.parse(response.body().string());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// as deep as possible
		JSONObject jLevel0 = (JSONObject) temp.get("body"); // body
		JSONObject jLevel1 = (JSONObject) jLevel0.get("bodyAnswers"); // bodyAnswers
		JSONArray jLevel2_Array = (JSONArray) jLevel1.get("threatResponses"); // threatResponses

		if (jLevel2_Array.size() == 0) {
			System.err.print("EMPTY JSON OBJECT");
		} else
			for (int i = 0; i < jLevel2_Array.size(); i++) {
				JSONObject allCountermeasures = (JSONObject) jLevel2_Array.get(i);
				for (int j = 0; j < allCountermeasures.size(); j++) {
					JSONArray jCountermeasuresArray = (JSONArray) allCountermeasures.get("countermeasures");
					for (int k = 0; k < jCountermeasuresArray.size(); k++) {
						JSONObject jCountermeasures = (JSONObject) jCountermeasuresArray.get(k);

						Countermeasure countermeasure = new Countermeasure(); // my model

						countermeasure.setMitigation(jCountermeasures.get("mitigation").toString());
						countermeasure.setApplication(jCountermeasures.get("application").toString());
						countermeasure.setNote((String) jCountermeasures.get("note"));
						countermeasure.setUserName((String) jCountermeasures.get("userName"));
						countermeasure.setValidationNote((String) jCountermeasures.get("validationNote"));
						countermeasure.setProbabilityControlId((String) jCountermeasures.get("probabilityControlId"));
						countermeasure.setCounterMeasureId((String) jCountermeasures.get("counterMeasureId"));
						countermeasure.setUserId((String) jCountermeasures.get("userId"));

						responseObject.put(k, countermeasure);

					}
				}
			}
		return responseObject;
	}

	public static void streamReader() throws IOException, UnirestException {
//		HttpResponse<String> response = Unirest.get("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey")
//				  .header("iv-user", "ADMIN")
//				  .asString();
	
		
		Request request = new Request.Builder().url(
				"http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false")
				.get()
				.addHeader("iv-user", "ADMIN")
				.addHeader("postman-token", "3339f944-d0f9-3b12-1733-7ef9b132b9d9")
				.build();
				
		StringBuilder builder = new StringBuilder();
		builder.append("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false");
		builder.append("-H iv-user: ADMIN");
		
		URL url = new URL(request.toString());
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
	
		
//		System.out.println(response.getBody().toString());
		
//		URL url = new URL(
//				"http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false -H Accept: application/json, text/plain, */* -H Cookie: triplesec.NG_TRANSLATE_LANG_KEY=it -H Connection: keep-alive -H iv-user: ADMIN");
//		InputStream in = url.openStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		StringBuilder result = new StringBuilder();
//		String line;
//		while ((line = reader.readLine()) != null) {
//			result.append(line);
//		}
//		System.out.println(result.toString());
	}
	
	 public static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }

}
