/**
 * 
 */
package it.senseisrl.mitiga.survey;

import junit.framework.TestCase;

/**
 * @author Sensei
 *
 */
public class CoinboxTest extends TestCase {
	private Coinbox coinbox;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		coinbox = new Coinbox();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		
		coinbox = null;
		super.tearDown();
	}

	
	public void testTwoCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testTwoCoins.STATUS ==> " + coinbox.toString() );
	}
	
	public void testthreeCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testthreeCoins.STATUS ==> " + coinbox.toString() );
	}
	
	public void testFourCoins() {
		coinbox.addQtr(2);
		coinbox.addQtr(2);
		coinbox.vend();
		System.out.println("testFourCoins.STATUS ==> " + coinbox.toString() );
	}
	public void testFiveCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testFiveCoins.STATUS ==> " + coinbox.toString() );
	}
	public void testSixCoins() {
		coinbox.addQtr(5);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testSixCoins.STATUS ==> " + coinbox.toString() );
	}
	public void testSevenCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testSevenCoins.STATUS ==> " + coinbox.toString() );
	}


	public void testMod() {
		int n = 0;
		while(coinbox.vend() != true) {
			n++;
			coinbox.addQtr(n);
			System.out.println("    Drink some coffee with "+ n + " coins ||"+ coinbox.toString() );
			
		}
		System.out.println("testMod.STATUS ==> " + coinbox.toString() );
	}
	
	// 2 total 1 current
	public void testeightCoins() {
		coinbox.vend();
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);		
		coinbox.addQtr(1);
		coinbox.vend();
		coinbox.vend();
		
		System.out.println("testeightCoins.STATUS ==> " + coinbox.toString() );
	}
	
	// 4 totalQtrs  1 current
	public void testfiveCoinsTwo() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		coinbox.addQtr(1);
		coinbox.vend();

		coinbox.addQtr(0);
		coinbox.vend();
		coinbox.addQtr(1);
		coinbox.vend();
		coinbox.addQtr(1);
		coinbox.vend();
		
		System.out.println("testfiveCoinsTwo.STATUS ==> " + coinbox.toString() );
	}
	public void test3Coins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		
		System.out.println("test3Coins.STATUS ==> " + coinbox.toString() );
		
		coinbox.vend();
	}
	
	public void test6Coins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		
		System.out.println("test6Coins.STATUS ==> " + coinbox.toString() );

		
		coinbox.vend();

	}
	
	public void testTwoCoin() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("	--	testTwoCoin.STATUS(1) ==> " + coinbox.toString() );
		coinbox.vend();
		System.out.println("	--	testTwoCoin.STATUS(1) ==> " + coinbox.toString() );
	}
	
	public void test2Coins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		
		System.out.println("	--	test2Coins.STATUS ==> " + coinbox.toString() );

		coinbox.addQtr(1);
		coinbox.addQtr(1);
		
		
		coinbox.vend();
		System.out.println("	--	test2Coins.STATUS ==> " + coinbox.toString() );

	}
	
	public void  testSequenceCoins() {
		coinbox.addQtr(2);
		System.out.println("testSequenceCoins.STATUS ==> " + coinbox.toString());
		coinbox.vend();
		System.out.println("testSequenceCoins.STATUS ==> " + coinbox.toString());
		coinbox.vend();
	}
	
	public void  testSequence2Coins() {
		coinbox.addQtr(2);
		System.out.println("testSequence2Coins.STATUS ==> " + coinbox.toString());
		coinbox.vend();
		coinbox.vend();
		System.out.println("testSequence2Coins.STATUS ==> " + coinbox.toString());
		
	}
	
	

	
} // END OF CLASS
