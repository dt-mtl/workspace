/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * 
 * 
// Written by: Daniel Torres 40101143
// For COMP 248 Section (FF) � Fall 2019
// --------------------------------------------------------*/
import java.util.Random;
public class Dice {
	
	private int die1;
	private int die2;
	
	
	//default constructor
	public Dice() {
		this.die1= (int) (Math.random()*6)+1;
		this.die2= (int) (Math.random()*6)+1;
		
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
}
