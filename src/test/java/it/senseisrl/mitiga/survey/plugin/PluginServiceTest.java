package it.senseisrl.mitiga.survey.plugin;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PluginServiceTest {
	
	
	final protected String basePath= "it.senseisrl.mitiga.survey.plugin"; 
	
	protected Properties props_ = new Properties();
	
	// class to be tested
	protected PluginService service_ = null;
	
	
	
	public PluginServiceTest() {
		
		//  
		service_ = new PluginService();
	}
	

	@Before
	public void setUp() throws Exception {
		// init the plug-in list
		props_.setProperty("plugin.1", basePath + ".ApplicationAnswerType");
		props_.setProperty("plugin.2", basePath + ".OtherAnswerType");
		props_.setProperty("plugin.3", basePath + ".NotExistAnswerType");
		props_.setProperty("plugin.4", basePath + ".NotExistAnswerType");
	}

	@After
	public void tearDown() throws Exception {
		
	}


	@Test
	public void testLoadPlugin() {
		service_.initPlugins(props_);
		assertTrue("No plugin was loaded ==>> "+ props_.size(), service_.count() > 0);
	}


	@Test
	public void testResetPlugin() {
		service_.resetPlugin();
		assertTrue("Some plugins is already loaded", service_.count() == 0);
	}


}
