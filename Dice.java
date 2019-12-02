/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * This class creates dice objects. Every instance of the dice is a randomly generated number from 
 * 1 to 6 . This class includes required accessor method but no setter methods as dice should never
 * be set, but rather randomly generated. additionally a toPrint method was made displaying the dice
 * roll, a roll dice method that simulates rolling new numbers and both function that checks if you rolled
 * a double, and a method that sums the resulting dice rolled should you need the value again with out 
 * having to roll the dice.
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
	//function which returns the new roll from both dice
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
	//Method that returns the addition of both dice should the dice have been rolled but do not need to be rolled again.
	public int dieSum() {
		return (die1+die2);
	}
}