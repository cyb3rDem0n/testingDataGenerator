package it.senseisrl.mitiga.survey.plugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONObject;

public abstract class AnswerType {
	static String name_;
	String propsFile_; 

	/**
	 * 
	 * @param jsonObject
	 */
	public abstract void setDefault(JSONObject jsonObject);

	
	
	public String getName() {
		return name_;
	}
	/**
	 * load the preference file... 
	 */
	public void init() {
		try {
			// load common properties
			InputStream input = new FileInputStream(propsFile_);
			Properties  props = new Properties();
			props.load(input);
			
			// 
			
		}catch(IOException ioe) {
//			log.error() // TODO
		}
	}
	
} // END OF FILE
