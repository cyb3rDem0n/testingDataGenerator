package it.senseisrl.mitiga.survey.plugin;

import org.json.simple.JSONObject;

public class ApplicationAnswerType extends AnswerType {
		
	static String name_= "application";
		
	@SuppressWarnings("unchecked")
	@Override
	public void setDefault(JSONObject jsonObject) {
		jsonObject.put("mitigation", 0);
		jsonObject.put("application", 0);
		jsonObject.put("note", "");
		jsonObject.put("userName", "");
		jsonObject.put("validationNote", "");
		jsonObject.put("probabilityControlId", "");
		jsonObject.put("counterMeasureId", "");
		jsonObject.put("userId", "");
	}
	
	@Override
	public void init() {
		super.init();
	}
}
