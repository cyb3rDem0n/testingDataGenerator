package it.senseisrl.mitiga.survey.plugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

public abstract class AnswerType {
	static String name_;
	String propsFile_; 
	private final Logger log_ = Logger.getLogger( this.getClass().getName() );
	/**
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
			InputStream input = new FileInputStream("C://Developer//eclipse-workspace//propsFile_.txt");
			Properties  props = new Properties();
			props.load(input);
			
			// 
			
		}catch(IOException ioe) {
			log_.log(Level.INFO, ioe.toString(), ioe);;
		}
	}
	
} // END OF FILE
