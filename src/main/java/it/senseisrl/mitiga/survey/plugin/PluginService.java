package it.senseisrl.mitiga.survey.plugin;

import java.util.HashMap;
import java.util.Properties;

public class PluginService {
	
	protected HashMap<String, AnswerType> pluginStore_ = new HashMap<String, AnswerType>(0); 
	
	protected Properties properties = new Properties();
	
	
	public PluginService() {
		loadPlugins();
	}
	
	/**
	 * read the list of plugins and create them
	 */
	protected void loadPlugins() {
		
		String classPath = "";
		AnswerType plugin = null;
		
		// read the list
//		for(int i=0; i < collection.size(); i++) {
		
			// ... and for eachOne
			plugin = PluginFactory.create(classPath);
			plugin.init();
			
			// if everything is OK
			pluginStore_.put(plugin.getName(), plugin);
//		} // end of loop
	}
	 
	public AnswerType getPlugin(String name) {
		return pluginStore_.get(name);
	}
	
}  // END OF CLASS
