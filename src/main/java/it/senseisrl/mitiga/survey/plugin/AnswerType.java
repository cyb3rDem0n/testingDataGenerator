package it.senseisrl.mitiga.survey.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;

import it.senseisrl.mitiga.survey.countermeasure.Countermeasure;

public abstract class AnswerType {
	static String name_;
	String propsFile_;
	private final Logger log_ = Logger.getLogger(this.getClass().getName());

	/**
	 * 
	 * Every element of the hash map is a countermeasures object, so each value of
	 * every object will set at his default value.
	 * 
	 * @param HashMap<String, Countermeasure>
	 * @return void
	 */
	public abstract void setDefault(HashMap<Integer, Countermeasure> hashMap);

	public abstract void preciseSetValue(HashMap<String, Countermeasure> hashMap, String key, String setValue);

	public abstract void searchNote(String valueToSearch);
	
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
