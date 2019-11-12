/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * 
 * 
// Written by: Daniel Torres 40101143
// For COMP 248 Section (FF) � Fall 2019
// --------------------------------------------------------*/
public class Assign4 {
	public static void main(String[] args) {
		banner();
		System.out.println("The default game board has 3 levels and each level has a 4x4 board.\n"+
				"You can use this default board size or change the size");
		Dice die1 = new Dice();
		Dice die3 = new Dice();
		
		System.out.println(" the die roll is: "+die1);
		System.out.println(" the die roll is: "+die3);
	}
	
	
	//method that outputs the banner
	static void banner() {
		System.out.println("      *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*"+
				         "\n      *                                           *"+
				         "\n      *   Welcome To Nancy's 3D Warrior Game!     *"+
				         "\n      *                                           *"+
						 "\n      *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");
	}	
}
