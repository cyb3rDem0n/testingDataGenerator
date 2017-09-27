package it.senseisrl.mitiga.survey.plugin;

import org.apache.log4j.Logger;

public class PluginFactory {

	private static final Logger log_ = Logger.getLogger(PluginFactory.class);

	/**
	 * Create a Factory to generate object of concrete class based on given
	 * information.
	 */
	public static AnswerType create(String classPath) {
		try {
			// forName() Returns the Class object associated with the class or interface
			// with the given string name.
			return (AnswerType) Class.forName(classPath).newInstance();
		} catch (Exception e) {
			String sterr = "Unable to construct instance of " + classPath;

			log_.error("Unable to construct instance" + classPath, e);
			throw new RuntimeException(sterr);
		}
	}

}
