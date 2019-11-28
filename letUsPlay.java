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
		int turn=0;
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
			 nDec = input.nextLine();
		    while (!input.hasNext("[A-Za-z]+")) {
		        System.out.print("Nope, that's not a valid name! Try again with no number :");
		       nDec=input.nextLine();
		    }
		    nDec = input.next();
		    System.out.println("Thank you! Your name will be: " + nDec);
			players[numPlayers]=new Player(nDec);
			numPlayers++;
		}
		turn=(int) (Math.random()*2);
		System.out.println("\nThe game has started "+players[turn].getName()+" goes first"+
						   "\n==============================================");
		//This will change the order of the two players so that the player that got to go
		//first will always go first
		if (turn==1) {
			Player hold=new Player(players[0]);
			players[0]=new Player(players[1]);
			players[1]=new Player(hold);
		}
		//round repetition
		while(!hasWon(players[0],players[1],map)){
			//roll the dice of each player
			for(int r=0;r<2;r++) {
				System.out.println("It is "+ players[r].getName()+"'s turn");
				die.rollDice();
				System.out.println("\t"+players[r].getName()+" you rolled "+die);
				//check to see if the rolled dice are a double, if so energy increase
				if(die.isDouble()) {
					players[r].setEnergy(players[r].getEnergy()+2);
					System.out.println("\tCongratulations you rolled double "+die.getDie1()+". Your energy went up by 2 units");
				}		
				//estimate the new location of the player
				players[r]=calcLocation(players[r],die,map);
				
			}
			//Check if players are in the exact same spot and challenge
			if(players[0].equals(players[1])) {
				System.out.println("ok both are i nthe same spot challenge time!");
			}
			
			
			//wait for a key to be pressed in order for the round to be over
			System.out.print("Press any Key to continue to the next Round");
			input.next().charAt(0);
			System.out.println("\n=============================================================================================="+
					"======================");
			
		}
		if(players[0].won(map)) 
			System.out.println("The weiner is "+players[0].getName()+" you're a GOAT! congratulations");
		else
			System.out.println("The weiner is "+players[1].getName()+" you're a GOAT! congratulations");
		System.out.println("Thank you for playing until next time peasant!");
	}
	
	public static boolean hasWon(Player p1,Player p2,Board mp) {
		if(p1.won(mp)||p2.won(mp)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Player calcLocation(Player l1,Dice q1,Board og) {
		int sz=og.getSize();
		int lvl=og.getLevel();
		Player nextPlace=new Player(l1.getLevel(),l1.getX(),l1.getY());
		return nextPlace;
	}
	
	public void moveLocation(int d1,int d2) {
		
	}
	
	static void banner() {
		System.out.println("      *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*"+
				         "\n      *                                           *"+
				         "\n      *   Welcome To Nancy's 3D Warrior Game!     *"+
				         "\n      *                                           *"+
						 "\n      *_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*\n");
	}	
}
