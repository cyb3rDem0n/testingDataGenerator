package it.senseisrl.mitiga.survey;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int choice;
		
		System.out
				.println("APP \n" + "1: Generate json file \n" + "2: Get json info \n" + "3: Average \n" + "4: Mitigation Values");
		choice = reader.nextInt();
		if (choice == 1) {
			System.out.println("Enter a integer value: ");
			int intVal = reader.nextInt();
			System.out.println("Enter a string value: ");
			String stringVal = reader.next();
		
			try {
				JsonModel.customJson(JsonModel.getJsonDetails(), intVal, stringVal);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (choice == 2) {
				// JSOn Model
				System.out.println(JsonModel.getJsonDetails().toString() + "\n");
			}
			if (choice == 3) {
				// Average Probability
				System.out.println("Average Probability is -> " + averageProbability());
			}
			if (choice == 4) {
				// Mitigation Values
				StringBuffer buffer_mitigations = new StringBuffer();
				for (Double d : checkMitigationValues()) {
					buffer_mitigations.append(d + "  ");
				}
				System.out.println("Mitigation Values -> " + buffer_mitigations);
			}
		}

		// Build JUnit
		// runTests(ApplicationTest.class); -> useless

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
			e.printStackTrace();
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
