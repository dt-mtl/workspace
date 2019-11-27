/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * 
 * 
// Written by: Daniel Torres 40101143
// For COMP 248 Section (FF) � Fall 2019
// --------------------------------------------------------*/
import java.util.Scanner;
public class letUsPlay {

	public static void main(String[] args) {
		
		//Game board setup
		Dice die=new Dice(); // creation of the dice of the game
		Player players[] =new Player[2]; //Player array that will hold the two players
		Board map= new Board(); //BOard that shall be used in the game, already defined by deafult
		Scanner input=new Scanner(System.in); //scanner holder
		int lDec; // variable that will hold the amount of levels desired by player
		int sDec; // variable that will hold the board size desired by player
		int bDec; // variable that will hold the decision for board setup of the player
		int numPlayers=0; // variable that holds the number of players
		String nDec;  //Variable that will input players name
		
		banner();
		System.out.println("The default game board has 3 levels and each level has a 4x4 board.\n"+
				"You can use this default board size or change the size");
		System.out.print("\t0 to use the default board size\n\t-1 to enter your own size\n"+
				"==>What do you want to do? ");
		bDec= input.nextInt();
		
		//board setup and board map parameter limiter 
		while(bDec!=0||bDec!=-1) {
			if(bDec==-1) {		
				System.out.print("How many levels would you like? (minimum size 3, max 10) ");
				lDec=input.nextInt();
				
				while(lDec>10||lDec<3) {
					System.out.print("Sorry but "+lDec+" is not a legal choice\n");
					lDec=input.nextInt();
				}
				if(lDec<=10&&lDec>=3) {
					System.out.print("What size do you want the nxn boards on each level to be? \nMinimum size is 3X3, max is 10X10 "+
									  "\n==> Enter the value of n: ");
					sDec=input.nextInt();
					while(sDec>10||sDec<3) {
						System.out.print("Sorry but "+sDec+" is not a legal choice\n");
						sDec=input.nextInt();
					}
					map = new Board(lDec,sDec);
					break;
				} 
				break;

			} else if(bDec==0) {
				System.out.print("Sweet, your board will have "+map.getLevel()+" levels and a "+map.getSize()
				+"X"+map.getSize()+" Board");
				break;
			}else {
				System.out.print("Sorry but "+bDec+" is not a legal choice\n");
				bDec=input.nextInt();
			}
				
		}
		System.out.println("\nYour 3D board has been setup to look like this: \n"+map);
		
		//Player name prompt and definition
		while(numPlayers<2) {
			System.out.print("What is Player "+(numPlayers+1)+"'s name (one word only): ");
		    while (!input.hasNext("[A-Za-z]+")) {
		        System.out.println("Nope, that's not it!");
		        input.next();
		    }
		    nDec = input.next();
		    System.out.println("Thank you! Got " + nDec);
			players[numPlayers]=new Player(nDec);
			numPlayers++;
		}
	
		
	}

	static void banner() {
		System.out.println("      *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*"+
				         "\n      *                                           *"+
				         "\n      *   Welcome To Nancy's 3D Warrior Game!     *"+
				         "\n      *                                           *"+
						 "\n      *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");
	}	
}
