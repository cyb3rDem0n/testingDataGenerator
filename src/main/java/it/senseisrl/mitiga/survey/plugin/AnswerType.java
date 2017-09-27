package it.senseisrl.mitiga.survey.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

public abstract class AnswerType {
	static String name_;
	String propsFile_;
	private final Logger log_ = Logger.getLogger(this.getClass().getName());	

	/**
	 * @param jsonObject
	 */
	public abstract void setDefault(JSONObject jsonObject);

	Properties prop = new Properties();
	InputStream input = null;

	public String getName() {
		return name_;
	}

	/**
	 * load the preference file...
	 */
	public void init() {
		try {

			// load common properties
			URL url = ClassLoader.getSystemResource("propsFile_.txt");
			prop.load(url.openStream());
			System.out.println(prop.getProperty("info"));
		} catch (IOException ioe) { 
			log_.error(Level.INFO);
			
		}
	}

} // END OF FILE
