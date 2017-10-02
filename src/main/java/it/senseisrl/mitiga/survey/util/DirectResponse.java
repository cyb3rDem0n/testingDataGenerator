package it.senseisrl.mitiga.survey.util;

import java.io.IOException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class DirectResponse {

	public static void okHttpPutRequest() throws IOException {
	OkHttpClient client = new OkHttpClient();

	MediaType mediaType = MediaType.parse("application/json");
	RequestBody body = RequestBody.create(mediaType, "{\"surveyAnswers\":\"{\\\"threatResponses\\\":[{\\\"threatId\\\":\\\"8a5ade8c-327a-40b7-ae90-b808afb6f873\\\",\\\"countermeasures\\\":[{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.05,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"af2a2b6c-c9cb-4812-a28c-d13cf6ea720c\\\",\\\"application\\\":99.99,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.05,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"d3e8ce45-97de-447e-897f-166b4cff236d\\\",\\\"application\\\":85.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"BATMAN THE BEST\\\",\\\"mitigation\\\":0.03,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"c8e4729f-b858-49ab-aab4-e6e77f4e9e59\\\",\\\"application\\\":37.5,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.02,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"7e3fc101-af58-44e0-8e32-3366fa6bee82\\\",\\\"application\\\":95.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.04,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"74971921-1138-4bc7-bf62-23fc0b21299c\\\",\\\"application\\\":37.5,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.03,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"9305de16-559f-4790-b874-c3267761b0f0\\\",\\\"application\\\":75.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla ...\\\",\\\"mitigation\\\":0.07,\\\"probabilityControlId\\\":\\\"c35f1419-9070-4748-b926-a640d1459a99\\\",\\\"counterMeasureId\\\":\\\"4076b86e-70e3-436a-bbe8-6db0dab048f4\\\",\\\"application\\\":37.5,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"test di chimata per la compilazione automatica dei questionari su asset\\\",\\\"mitigation\\\":0.02,\\\"probabilityControlId\\\":\\\"c35f1419-9070-4748-b926-a640d1459a99\\\",\\\"counterMeasureId\\\":\\\"deb3661a-907e-41a8-81c2-c6bf9bd26be5\\\",\\\"application\\\":75.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"}],\\\"probabilityId\\\":\\\"eb6d5309-8bdb-4f0d-814b-9221179c2121\\\"}]}\",\r\n\"processState\": \"VALIDATED\",\r\n  \"systemOwner\": false,\r\n  \"header\": null}\r\n");
	Request request = new Request.Builder()
	  .url("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate")
	  .put(body)
	  .addHeader("content-type", "application/json")
	  .addHeader("iv-user", "ADMIN")
	  .addHeader("cache-control", "no-cache")
	  .addHeader("postman-token", "79fe4d55-e3a7-d1e8-ae74-192ac2815b08")
	  .build();

	Response response = client.newCall(request).execute();
	
	if(response.code() != 200)
		System.err.println("RESPONSE CODE: " + response.code() + "\n" + "RESPONSE MESSAGE: "
			+ response.message() + "\n" + "SUCCESSFUL?: " + response.isSuccessful());
	else
		System.out.println("RESPONSE CODE: " + response.code() );
	}
	
	public static void unirestPutRequest() throws UnirestException {
	HttpResponse<String> response = Unirest.put("http://192.168.88.166:9080/mitiga/processes/260e9a6c-f5cb-477d-9d17-1789fdd8324f/validate")
			  .header("content-type", "application/json")
			  .header("iv-user", "ADMIN")
			  .header("cache-control", "no-cache")
			  .header("postman-token", "d4e659f7-22e7-58ce-d6f3-3a9319dc69ec")
			  .body("{\"surveyAnswers\":\"{\\\"threatResponses\\\":[{\\\"threatId\\\":\\\"8a5ade8c-327a-40b7-ae90-b808afb6f873\\\",\\\"countermeasures\\\":[{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.05,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"af2a2b6c-c9cb-4812-a28c-d13cf6ea720c\\\",\\\"application\\\":99.99,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.05,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"d3e8ce45-97de-447e-897f-166b4cff236d\\\",\\\"application\\\":85.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"BATMAN THE BEST\\\",\\\"mitigation\\\":0.03,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"c8e4729f-b858-49ab-aab4-e6e77f4e9e59\\\",\\\"application\\\":37.5,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.02,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"7e3fc101-af58-44e0-8e32-3366fa6bee82\\\",\\\"application\\\":95.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.04,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"74971921-1138-4bc7-bf62-23fc0b21299c\\\",\\\"application\\\":37.5,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla\\\",\\\"mitigation\\\":0.03,\\\"probabilityControlId\\\":\\\"399500f3-b592-476e-b85a-96e62cbd000b\\\",\\\"counterMeasureId\\\":\\\"9305de16-559f-4790-b874-c3267761b0f0\\\",\\\"application\\\":75.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"bla bla bla ...\\\",\\\"mitigation\\\":0.07,\\\"probabilityControlId\\\":\\\"c35f1419-9070-4748-b926-a640d1459a99\\\",\\\"counterMeasureId\\\":\\\"4076b86e-70e3-436a-bbe8-6db0dab048f4\\\",\\\"application\\\":37.5,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"},{\\\"note\\\":\\\"test di chimata per la compilazione automatica dei questionari su asset\\\",\\\"mitigation\\\":0.02,\\\"probabilityControlId\\\":\\\"c35f1419-9070-4748-b926-a640d1459a99\\\",\\\"counterMeasureId\\\":\\\"deb3661a-907e-41a8-81c2-c6bf9bd26be5\\\",\\\"application\\\":75.0,\\\"validationNote\\\":\\\"\\\",\\\"userName\\\":\\\"ADMIN - ADMIN ADMIN\\\",\\\"userId\\\":\\\"e8f996a7-4c46-4229-b7bd-dcc24635f6d2\\\"}],\\\"probabilityId\\\":\\\"eb6d5309-8bdb-4f0d-814b-9221179c2121\\\"}]}\",\r\n\"processState\": \"VALIDATED\",\r\n  \"systemOwner\": false,\r\n  \"header\": null}\r\n")
			  .asString();
	
				System.out.println(response.getStatusText());
	
				
	
	}
}
