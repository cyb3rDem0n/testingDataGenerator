package it.senseisrl.mitiga.survey.plugin;

import java.util.HashMap;
import java.util.Iterator;
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
		AnswerType plugin = null;

		// read the list

		if (prp.size() > 0) {

			for (int i = 0; i < prp.size(); i++) {

				// assegno il classPath avente la chiave corrispondente
				// Properties in ingresso avrà una sua dimensione

				classPath = prp.getProperty("plugin." + 1);

				if (!classPath.equals(null)) {
					plugin = PluginFactory.create(classPath);
				} else
					log_.error(Level.WARN);

				// ... and for eachOne

				if (plugin != null) {
					plugin.init();
					pluginStore_.put(plugin.getName(), plugin);
				} else {
					// if plugin is null, classPath doesn't exist
					log_.error(Level.WARN);
				}
			}
			log_.error("empty properties");

		} // end of loop

	} // --- loadPlugins() ---

	public void resetPlugin() {
		if (pluginStore_.isEmpty() == false) {
			for (Iterator<?> it = pluginStore_.entrySet().iterator(); it.hasNext();) {
				pluginStore_.remove(it.next());
			}
		}
	}

	public int count() {
		return pluginStore_.size();
	}

	public AnswerType getPlugin(String name) {
		return pluginStore_.get(name);
	}

} // END OF CLASS
