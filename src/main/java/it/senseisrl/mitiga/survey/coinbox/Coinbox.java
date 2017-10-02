package it.senseisrl.mitiga.survey.coinbox;
/**
 * Class.......: Coinbox.java
 * Description.: a Sample class to write Java Test-Case 
 * 
 * 
 * @author M. Matricardi <massimo.matricardi@senseisrl.it>
 * @version 1.0
 */

public class Coinbox {
	
	private int totalQtrs; 		// total quarters collected 
	private int curQtrs; 		// current quartes collected 
	private boolean allowVend; 	// 1=vending is allowed 


	public Coinbox() {

		reset();
		return;
	} 
	
	public void reset() {
		totalQtrs	= 0;
		allowVend 	= false;
		curQtrs		= 0;
		return;
	} 
	
	/**
	 * 
	 * @param amount: amount of coin 
	 */	
	public void addQtr(int amount){
		if (amount > 0)
			curQtrs = curQtrs + amount; // add a quarter 
		if (curQtrs > 1)    		// if more than one quarter collected, 
			allowVend = true; 	// then set allowVend
		return; 
	}

	/**
	 * Return the coin
	 */
	public void returnQtrs(){
		curQtrs 	= 0; 
		allowVend 	= false; // --- this is the Error
		return;
	} // return current quarters 

	/**
	 * Flag
	 */
	public boolean isAllowedVend() {
		return allowVend;
	} 

	/**
	 * if allowVend, update totalQtrs and curQtrs
	 */ 
	public boolean vend(){
		if (isAllowedVend()) {    //if allowVend 
			totalQtrs		= totalQtrs+curQtrs; 	// update totalQtr 
			curQtrs		= 0;                   		// curQtr 
			allowVend	= false;                 		// allowVend
			return true;
		}
		else
			return false;
	}

	
	/**
	 * return a String representation of the Class status
	 * 
	 */
	public String toString() {
		String status = "totalQtrs: '" +  totalQtrs + "', "
				      + "curQtrs: '" +  curQtrs   + "', " 
				      + "allowVend: '" +  allowVend + "', ";
		
		return status;
		
	}

} // --- end of class()

