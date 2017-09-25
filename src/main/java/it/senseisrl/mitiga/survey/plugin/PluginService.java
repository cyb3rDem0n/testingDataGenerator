package it.senseisrl.mitiga.survey.plugin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

public class PluginService {
	
	private final Logger log_ = Logger.getLogger( this.getClass().getName() );
	
	// key + instance
	protected HashMap<String, AnswerType> pluginStore_ = new HashMap<String, AnswerType>(0); 
	
	protected Properties properties = new Properties();
	
	
	public PluginService() {
		// empty method
	}

	public PluginService(Properties p) {
		initPlugins( p );
	}
	
	/**
	 * read the list of plugins and create them
	 */
	public void initPlugins(Properties prp) {
		
		String classPath = "";
		AnswerType plugin = null;
		
		// read the list
		
		for(int i = 1; i < 100; i++) {
			
			classPath = prp.getProperty("plugin."+1);
		
			// ... and for eachOne
			plugin = PluginFactory.create(classPath);
			plugin.init();
			
			pluginStore_.put(plugin.getName(), plugin);
			
		} // end of loop
		
	} // --- loadPlugins() ---
	
	
	public void resetPlugin() {
		if(pluginStore_.isEmpty() == false ) {
			for(Iterator it = pluginStore_.entrySet().iterator() ; it.hasNext(); ) {
					pluginStore_.remove( it.next() );
			}
		}
	}
	
	public int count(){
		return pluginStore_.size();
	}
	 
	public AnswerType getPlugin(String name) {
		return pluginStore_.get(name);
	}
	
	
	
}  // END OF CLASS
