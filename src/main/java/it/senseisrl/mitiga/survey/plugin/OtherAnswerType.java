package it.senseisrl.mitiga.survey.plugin;

import org.json.simple.JSONObject;

public class OtherAnswerType extends AnswerType {
	static String name_="OtherAnswerType";
	
	@Override
	public void setDefault(JSONObject jsonObject) {
		jsonObject.put("attrFieldId", "");
		jsonObject.put("name", "");
		jsonObject.put("type", "");
		jsonObject.put("tailoring", false);
		jsonObject.put("readOnly", false);
		jsonObject.put("singleValue", false);
		// Array<String>
		jsonObject.put("multiValues", null);
		jsonObject.put("answers", null);
	}
	@Override
	public void init() {
		super.init();
	}
	
}
