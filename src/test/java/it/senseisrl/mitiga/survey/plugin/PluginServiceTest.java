package it.senseisrl.mitiga.survey.plugin;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PluginServiceTest {

	final protected String basePath = "it.senseisrl.mitiga.survey.plugin";

	protected Properties props_ = new Properties();
	protected JSONObject jsonObject = new JSONObject();
	AnswerType answerType;

	// class to be tested
	protected PluginService service_ = null;

	public PluginServiceTest() {
		// viene invocato initPlugin nel costruttore
		service_ = new PluginService();
	}

	@Before
	public void setUp() throws Exception {
		// init the plug-in list
		// Property<Key,Value>
		props_.setProperty("plugin.1", basePath + ".ApplicationAnswerType");
		props_.setProperty("plugin.2", basePath + ".OtherAnswerType");
		props_.setProperty("plugin.3", basePath + ".NotExistAnswerType");
		//props_.setProperty("plugin.4", basePath + ".NotExistAnswerType2");
		service_ = new PluginService(props_);

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testLoadPlugin() {
		service_.initPlugins(props_);
		assertTrue("No plugin was loaded ==>> ", service_.count() > 0);
	}

	@Test
	public void testResetPlugin() {
		service_.resetPlugin();
		assertTrue("Some plugins is already loaded", service_.count() == 0);
	}

	@Test
	public void testGetPluginExists() {
		AnswerType plugin = service_.getPlugin("plugin.1");
		assertTrue("unable to find 'plugin.1' is " + plugin, plugin != null);
	}
	
	@Test
	public void testGetPluginExists2() {
		AnswerType plugin = service_.getPlugin("plugin.2");
		assertTrue("unable to find 'plugin.2' is " + plugin, plugin != null);
	}

	@Test
	public void testGetPluginNotExists() {
		AnswerType plugin = service_.getPlugin("plugin.3");
		assertTrue("OK! 'plugin.3' doesn't exists", plugin == null);
	}

}
