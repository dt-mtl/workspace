/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * 
 * 
// Written by: Daniel Torres 40101143
// For COMP 248 Section (FF) � Fall 2019
// --------------------------------------------------------*/

public class Dice {
	
	private int die1=0;
	private int die2=0;
	
	
	//default constructor
	public Dice() {
		this.die1= (int) (Math.random()*6)+1;
		this.die2= (int) (Math.random()*6)+1;
		
	}
	//function which returns the result of both die
	public int rollDice() {
		this.die1= (int) (Math.random()*6)+1;
		this.die2= (int) (Math.random()*6)+1;
		int sum= die1+die2;
		return (sum);
		
	}
	//accessor methods
	public  int getDie1() {
		return die1;
	}
	public int getDie2() {
		return this.die2;
	}
	
	//toString Method
	public String toString() {
		String output1 = String.format("Die1: %d Die2: %d",getDie1(),getDie2());
			return output1;
	}
	//double function when dice are the same value
	public boolean isDouble() {
		return(this.die1==this.die2);
	}
}
