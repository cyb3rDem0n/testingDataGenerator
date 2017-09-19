package it.senseisrl.mitiga.survey;

import junit.framework.TestCase;

public class Test extends TestCase {

	private Model instance;

	@Override
	// preparation - before
	public void setUp() throws Exception {
		System.out.println("setUp is running...");

		instance = new Model();
	}

	@Override
	// clean up - after
	public void tearDown() {
		System.out.println("tearDown is running...");

		instance = null;
		assertNull(instance);

	}

	public void testBanck(){
		try {
		instance.addMoreMoney(1);
		instance.addMoreMoney(10);
		instance.getBankResidue();
	}catch (Exception e) {
		e.printStackTrace();
	}
		}

}
