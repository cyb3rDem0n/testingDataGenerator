package it.senseisrl.mitiga.survey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import it.senseisrl.mitiga.survey.plugin.AnswerType;
import it.senseisrl.mitiga.survey.plugin.ApplicationAnswerType;

public class ResponseReader {
	static String sURL = "curl 'http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/assessment-process-survey?editHeader=false' -H 'Accept-Encoding: gzip, deflate' -H 'Accept-Language: it-IT,it;q=0.8,en-US;q=0.6,en;q=0.4' -H 'User-Agent: Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.91 Safari/537.36' -H 'Accept: application/json, text/plain, */*' -H 'Referer: http://192.168.88.166:9080/mitiga/webapp/' -H 'Cookie: triplesec.NG_TRANSLATE_LANG_KEY=it' -H 'Connection: keep-alive' -H 'iv-user: ADMIN' --compressed";

	/**
	 * If <code>setDefault</code> is true, all the json response values will be
	 * changed to default status. Else, will be shown the original response.
	 * 
	 * @return ArrayList <<code>JSONObject</code>>
	 * @param setDefault 
	 */
	public static ArrayList<JSONObject> getJson(boolean setDefault) throws IOException {
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
		String jsonData = response.body().string();
		JSONObject jsonToPlugin = null;
		ArrayList<JSONObject> responseList = new ArrayList<>();

		// GZip DECOMPRESSION
		// String decompResponse = null;
		// byte[] byteResponse = response.body().string().getBytes();
		// try {
		// decompResponse = GzipDecode.decompress(byteResponse);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// System.out.println("Response: " + decompResponse );
		// END DECOMPRESSION

		if (!response.isSuccessful())
			System.out.println("Response Code: " + response.code());
		else
			System.out.println("Response Code: " + response.code() + "OK" + "\n" + response.headers());
		AnswerType answerType;
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(jsonData);

			JSONObject level_2 = (JSONObject) jsonObject.get("body");
			JSONObject level_3 = (JSONObject) level_2.get("bodyAnswers");
			JSONArray level_4 = (JSONArray) level_3.get("threatResponses");
			for (int i = 0; i < level_4.size(); i++) {
				JSONObject jsonObjectNext = (JSONObject) level_4.get(i);
				JSONArray level_5 = (JSONArray) jsonObjectNext.get("countermeasures");
				// System.out.println(level_5.toString());
				for (int j = 0; j < level_5.size(); j++) {
					responseList.add((JSONObject) level_5.get(j));
					jsonToPlugin = (JSONObject) level_5.get(j);
					if (setDefault != false) {
						answerType = new ApplicationAnswerType();
						answerType.setDefault(jsonToPlugin);
					}

					// System.out.println(jsonToPlugin);

				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return responseList;
	}
}
