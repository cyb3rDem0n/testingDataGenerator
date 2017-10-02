package it.senseisrl.mitiga.survey.plugin;

import java.io.IOException;
import java.util.HashMap;

import it.senseisrl.mitiga.survey.countermeasure.Countermeasure;
import it.senseisrl.mitiga.survey.countermeasure.CountermeasureBuilder;

public class ApplicationAnswerType extends AnswerType {

	static String name_ = "ApplicationAnswerType";

	@Override
	public void setDefault(HashMap<Integer, Countermeasure> hashMap) {
		for (Countermeasure countermeasure : hashMap.values()) {
			countermeasure.setMitigation("");
			countermeasure.setApplication("");
			countermeasure.setNote("");
			countermeasure.setUserName("");
			countermeasure.setValidationNote("");
			countermeasure.setProbabilityControlId("");
			countermeasure.setCounterMeasureId("");
			countermeasure.setUserId("");
		}
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void preciseSetValue(HashMap<String, Countermeasure> hashMap, String inputKey, String setValue) {
		if (inputKey == null) {
			System.err.println("Null Value - could not continue");
		} else {
			for (Countermeasure countermeasure : hashMap.values()) {

				if (inputKey.equals(countermeasure.getMitigation()))
					countermeasure.setMitigation(setValue);

				if (inputKey.equals(countermeasure.getNote()))
					countermeasure.setNote(setValue);

				if (inputKey.equals(countermeasure.getUserName()))
					countermeasure.setUserName(setValue);

				if (inputKey.equals(countermeasure.getValidationNote()))
					countermeasure.setValidationNote(setValue);

				if (inputKey.equals(countermeasure.getProbabilityControlId()))
					countermeasure.setProbabilityControlId(setValue);

				if (inputKey.equals(countermeasure.getCounterMeasureId()))
					countermeasure.setCounterMeasureId(setValue);

				if (inputKey.equals(countermeasure.getMitigation()))
					countermeasure.setMitigation(setValue);

				if (inputKey.equals(countermeasure.getUserId()))
					countermeasure.setUserId(setValue);

			}
		}

	}

	@Override
	public void searchNote(String valueToSearch) {

		try {
			for(Countermeasure countermeasure : CountermeasureBuilder.jsonManage().values())
				if(countermeasure.getNote().contains(valueToSearch)) {
				System.out.println("FOUND ==>> " + countermeasure.getNote());
			}else
				System.err.println("NOT FOUND");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
