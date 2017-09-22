/**
 * 
 */
package it.senseisrl.mitiga.survey;

import junit.framework.TestCase;

/**
 * @author Sensei
 *
 */

/**		Possible bad sequence 
 *   {@link #testCombination()}. 
 *   {@link #testCombination2()}. 

 *   **/
public class CoinboxTest extends TestCase {
	private Coinbox coinbox;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		coinbox = new Coinbox();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {

		coinbox = null;
		super.tearDown();
	}

	public void testOneCoin() {
		coinbox.addQtr(1);
		System.out.println("testOneCoin.STATUS ==> Insert One Coin ==> " + coinbox.toString());

		coinbox.vend();
		System.out.println("testOneCoin.STATUS ==> " + coinbox.toString());

	}

	public void testTwoCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testTwoCoins.STATUS ==> " + coinbox.toString());
	}

	public void testTwoCoins2() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testTwoCoins2.STATUS(1) ==> " + coinbox.toString());
		coinbox.vend();
		System.out.println("testTwoCoins2.STATUS(1) ==> " + coinbox.toString());
	}

	public void testTwoCoins3() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		System.out.println("testTwoCoins3.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		coinbox.addQtr(1);
		System.out.println("testTwoCoins3.STATUS ==> " + coinbox.toString());

		coinbox.vend();
		System.out.println("testTwoCoins3.STATUS ==> " + coinbox.toString());

	}

	public void testThreeCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testThreeCoins.STATUS ==> " + coinbox.toString());
	}

	public void testThreeCoins2() {
		coinbox.addQtr(3);
		System.out.println("testThreeCoins2.STATUS ==> " + coinbox.toString());

		coinbox.vend();
		System.out.println("testThreeCoins2.STATUS ==> " + coinbox.toString());

	}

	public void testFourCoins() {
		coinbox.addQtr(2);
		coinbox.addQtr(2);
		coinbox.vend();
		System.out.println("testFourCoins.STATUS ==> " + coinbox.toString());
	}

	public void testFiveCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testFiveCoins.STATUS ==> " + coinbox.toString());
	}

	public void testFiveCoins2() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();

		System.out.println("testFiveCoins2.STATUS ==> " + coinbox.toString());
	}

	public void testSixCoins() {
		coinbox.addQtr(5);
		coinbox.addQtr(1);
		coinbox.vend();
		System.out.println("testSixCoins.STATUS ==> " + coinbox.toString());
	}

	public void testSixCoins2() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);

		System.out.println("testSixCoins2.STATUS ==> " + coinbox.toString());

		coinbox.vend();

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
		System.out.println("testSevenCoins.STATUS ==> " + coinbox.toString());
	}

	public void testEightCoins() {
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.vend();

		System.out.println("testEightCoins.STATUS ==> " + coinbox.toString());
	}

	public void testMod() {
		int n = 0;
		while (coinbox.vend() != true) {
			n++;
			coinbox.addQtr(n);
			System.out.println("    Drink some coffee with " + n + " coins ||" + coinbox.toString());

		}
		System.out.println("testMod.STATUS ==> " + coinbox.toString());
	}

	public void testSequenceCoins() {
		coinbox.addQtr(2);
		System.out.println("testSequenceCoins.STATUS ==> " + coinbox.toString());
		coinbox.vend();
		System.out.println("testSequenceCoins.STATUS ==> " + coinbox.toString());
		coinbox.vend();
	}

	public void testSequence2Coins() {
		coinbox.addQtr(2);
		System.out.println("testSequence2Coins.STATUS ==> " + coinbox.toString());
		coinbox.vend();
		coinbox.vend();
		System.out.println("testSequence2Coins.STATUS ==> " + coinbox.toString());
	}

	public void testReturnQtrs() {
		coinbox.addQtr(2);
		coinbox.addQtr(1);
		System.out.println("testReturnQtrs.STATUS ==> " + coinbox.toString());

		coinbox.returnQtrs();
		System.out.println("testReturnQtrs.STATUS ==> " + coinbox.toString());

	}

	public void testReturnQtrs2() {
		coinbox.addQtr(1);
		System.out.println("testReturnQtrs.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testReturnQtrs.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testReturnQtrs.STATUS ==> " + coinbox.toString());

		coinbox.returnQtrs();
		coinbox.addQtr(1);
		System.out.println("testReturnQtrs.STATUS ==> " + coinbox.toString());
	}

	public void testReturnQtrs3() {
		coinbox.addQtr(2);
		System.out.println("testReturnQtrs3(2).STATUS ==> " + coinbox.toString());

		coinbox.vend();
		System.out.println("testReturnQtrs3(vend).STATUS ==> " + coinbox.toString());

		coinbox.addQtr(2);
		System.out.println("testReturnQtrs3(2).STATUS ==> " + coinbox.toString());

	}

	public void testCollectedCoins() {
		// inserisco un po di gettoni e mi aspetto che venga incrementato curQtrs
		coinbox.addQtr(1);
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

		coinbox.addQtr(1);
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

		// provo a consumare il servizio, mi basta curQtrs >1, mi aspetto che totalQtr
		// venga aggiornato
		// con la quantità totale di coin inseriti
		coinbox.vend();
		System.out.println("testCollectedCoins.STATUS ==> " + coinbox.toString());

	}
	public void testDifferentInputSequence() {
		System.out.println("testDifferentInputSequence ==>  ADD 5 coins");
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		coinbox.addQtr(1);
		System.out.println("testDifferentInputSequence.STATUS ==> " + coinbox.toString());
		coinbox.returnQtrs();
		System.out.println("testDifferentInputSequence ==>  returnQrs ==> "  + coinbox.toString());
		
		coinbox.addQtr(1);
		System.out.println("testDifferentInputSequence ==>  ADD 1 coin "  + coinbox.toString());
		coinbox.vend();
		System.out.println("testDifferentInputSequence ==>  try vend() "  + coinbox.toString());
		
		coinbox.addQtr(1);
		System.out.println("testDifferentInputSequence ==>  ADD 1 more coin - 2 total - "  + coinbox.toString());
		coinbox.vend();
		System.out.println("testDifferentInputSequence ==>  try vend() "  + coinbox.toString());
		
		coinbox.addQtr(1);
		System.out.println("testDifferentInputSequence ==>  ADD 1 more coin - 3 total - "  + coinbox.toString());
		coinbox.vend();
		System.out.println("testDifferentInputSequence ==>  try vend() "  + coinbox.toString());

		// quando il quantità di coins passa da cuQtrs a totalQtrs, allora ho consumato vend()
		
	}
	
	/**
	 * returnQtrs() should set totalQtrs= 4 and allowVend= true
	 * only 2 of 4 coins have been used.    ...maybe!
	 */
	public void testCombination() {
		System.out.println("\n" + "==> 0 coin " + coinbox.toString());
		
		coinbox.addQtr(1);
		System.out.println("==> 1 coin " + coinbox.toString());
		
		coinbox.vend();
		System.out.println("==> vend result " + coinbox.toString());
		
		coinbox.addQtr(1);
		System.out.println("==> one more coin " + coinbox.toString());
		
		coinbox.vend();
		System.out.println("==> vend result " + coinbox.toString());

		coinbox.returnQtrs();
		System.out.println("==> returnQtrs " + coinbox.toString());
		
		coinbox.addQtr(2);
		System.out.println("==> two more coins " + coinbox.toString());
		
		coinbox.returnQtrs();
		System.out.println("==> returnQtrs - allowVend should be true & totalQtrs = 4 ? " + coinbox.toString());
	
		coinbox.vend();
		System.out.println("==> vend? " + coinbox.toString() + "\n");
		
	}
	
	// lose money
	public void testCombination2() {
		System.out.println("testCombination2.STATUS ==> "  + coinbox.toString());
		coinbox.addQtr(4);
		System.out.println("testCombination2.STATUS ==> " + coinbox.toString());
		coinbox.reset();
		System.out.println("testCombination2.STATUS ==> RESET " + coinbox.toString());
		coinbox.returnQtrs();	//deve abilitare
		System.out.println("testCombination2.STATUS ==> RETURN " + coinbox.toString());
		coinbox.vend(); 
		System.out.println("testCombination2.STATUS ==> VEND " + coinbox.toString());		
}


} // END OF CLASS
