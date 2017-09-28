package it.senseisrl.mitiga.survey.plugin;

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class PluginService {

	private final Logger log_ = Logger.getLogger(this.getClass().getName());
	// key + instance
	protected HashMap<String, AnswerType> pluginStore_ = new HashMap<String, AnswerType>(0);

	protected Properties properties = new Properties();

	public PluginService() {
		// empty method
	}

	public PluginService(Properties p) {
		initPlugins(p);
	}

	/**
	 * read the list of plugins and create them
	 */
	public void initPlugins(Properties prp) {

		String classPath = "";
		AnswerType answerType = null;

		// read the list

		if (prp.size() > 0) {

			for (int i = 1; i < prp.size(); i++) {

				// prendo il classPath legato alla key "plugin + i"
				classPath = prp.getProperty("plugin." + i);
				
				if (!classPath.equals(null)) {
					answerType = PluginFactory.create(classPath);
				} else
					log_.error(Level.WARN);

				// ... and for eachOne

				if (answerType != null) {
					answerType.init();
					//String key = pluginStore_.get("plugin."+i);
					pluginStore_.put("plugin."+i, answerType);
				} else {
					// if plugin is null, classPath doesn't exist
					log_.error(Level.WARN);
				}
			}
			log_.error("empty properties");

		} // end of loop

	} // --- loadPlugins() ---

	public void resetPlugin() {
		if (pluginStore_.size() != 0) {
			pluginStore_.clear();
		}else
			System.out.println("Empty HashMap");
	}

	public int count() {
		return pluginStore_.size();
	}

	public AnswerType getPlugin(String name) {
		return pluginStore_.get(name);
	}

} // END OF CLASS
