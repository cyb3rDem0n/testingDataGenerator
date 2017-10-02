package it.senseisrl.mitiga.survey;

import org.junit.Test;

import it.senseisrl.mitiga.survey.json.JsonModel;
import junit.framework.TestCase;

public class TestMe extends TestCase{

	protected JsonModel instance;
	
	public void setUp() {
		instance = new JsonModel();
	}
	public void tearDown() {
		instance = null;
	}
	@Test
	public void testCheck() {
		instance.setAssetTypeName("software");
		instance.checkState(instance);
	}
	@Test
	public void testDetails(){
		
	}
}
