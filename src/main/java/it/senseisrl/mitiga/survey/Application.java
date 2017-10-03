package it.senseisrl.mitiga.survey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import it.senseisrl.mitiga.survey.countermeasure.CountermeasureBuilder;
import it.senseisrl.mitiga.survey.countermeasure.CountermeasureRequest;

public class Application {
	private final static Logger log_ = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) throws IOException, UnirestException {
				//
		// for(Countermeasure countermeasure :
		// CountermeasureBuilder.jacksonMapper().values()) {
		// System.out.println(countermeasure);
		//
		//
		// }

		// AnswerType type = new ApplicationAnswerType();
		// type.searchNote("BATMAN");
		// type.setDefault(CountermeasureBuilder.jsonManage());

	}

	@SuppressWarnings("unchecked")
	public static JSONObject responseBuilder() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject();

		try {

			map.put("threatResponses", CountermeasureBuilder.jacksonMapper());

			jsonObject.put("surveyAnswers", map);
			jsonObject.put("processState", "VALIDATED");
			jsonObject.put("systemOwner", "false");
			jsonObject.put("header", "null");
		} catch (IOException e) {
			log_.log(Level.WARNING, e.toString(), e);
		}

		return jsonObject;
	}

	public static void getHeader() throws JsonParseException, JsonMappingException, IOException {

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
		JSONParser parser = new JSONParser();

		try {
			temp = (JSONObject) parser.parse(response.body().string());
			// jsonObject = (JSONObject) parser.parse(new FileReader(path));
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject header = (JSONObject) temp.get("header"); // header string
		
		JSONObject surveyAnswers = new JSONObject();
		surveyAnswers.put("header", header);
		surveyAnswers.put("threatResponses", CountermeasureBuilder.jsonManageII());
		
		CountermeasureRequest.okHttpPutRequest(surveyAnswers);
	}

	public static String readResponseInfo(JSONObject jsonObject) {
		String cms = null;

		try {

			JSONArray valueList = (JSONArray) jsonObject.get("bodyAnswers");
			for (Object object : valueList) {
				JSONObject jsonObj = (JSONObject) object;
				JSONArray sub_array = (JSONArray) jsonObj.get("threatResponses");
				for (Object sub_object : sub_array) {
					JSONObject sub_jsonObj = (JSONObject) sub_object;
					JSONArray sub_sub_array = (JSONArray) sub_jsonObj.get("countermeasures");
					for (Object sub_sub_object : sub_sub_array) {
						JSONObject sub_sub_jsonObject = (JSONObject) sub_sub_object;
						cms = ((String) sub_sub_jsonObject.toJSONString());
					}
				}
			}

		} catch (Exception e) {
			log_.log(Level.FINE, e.toString(), e);
		}
		return cms;

	}

	public static ArrayList<Double> checkMitigationValues() {

		JSONParser parser = new JSONParser();
		ArrayList<Double> mitigations = new ArrayList<Double>();

		try {

			JSONObject jsonObject = (JSONObject) parser
					.parse(new FileReader("C://Developer//eclipse-workspace//questionarioCONTROMISURE_schema.txt"));

			JSONArray valueList = (JSONArray) jsonObject.get("probabilities");
			for (Object object : valueList) {
				JSONObject jsonObj = (JSONObject) object;
				JSONArray sub_array = (JSONArray) jsonObj.get("controls");
				for (Object sub_object : sub_array) {
					JSONObject sub_jsonObj = (JSONObject) sub_object;
					JSONArray sub_sub_array = (JSONArray) sub_jsonObj.get("mitigations");
					for (Object sub_sub_object : sub_sub_array) {
						JSONObject sub_sub_jsonObject = (JSONObject) sub_sub_object;
						mitigations.add((Double) sub_sub_jsonObject.get("mitigation"));
					}
				}
			}

		} catch (Exception e) {
			log_.log(Level.ALL, e.toString(), e);
		}
		return mitigations;

	}

	public static Long averageProbability() {
		JSONParser parser = new JSONParser();
		Long s = 0l;
		double av = 0;
		Object obj;
		try {
			obj = parser.parse(new FileReader("C://Developer//eclipse-workspace//questionarioCONTROMISURE_schema.txt"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray valueList = (JSONArray) jsonObject.get("probabilities");

			for (Object obj_ : valueList) {
				JSONObject jsonObj = (JSONObject) obj_;
				long d = (Long) jsonObj.get("probability");
				s += d;
			}
			av = s / valueList.size();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (long) av;

	}

	public static boolean checkString(JSONObject jsonObject) {
		if (jsonObject.get("string").equals(null))
			return true;
		else
			return false;
	}

}
