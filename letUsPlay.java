/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * This class puts into play the other predefined classes Board, Dice and Player. This class will setup
 * both the players, the board game map to be used, and the dice that will be used through out the game.
 * this class follows the rules of Nancy's 3D warrior game as per assignment hand out and attempts to give do a 
 * full game play. While some functions work perfectly minor bugs hinder this class from working as desired. 
 * I hope that the work given will maximize as many partial marks as possible, in addition to giving you the
 * pleasure of enjoying Nancy's 3D warrior game.
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
		Player holders[] = new Player[2]; //player holder for moving them to their new designated location
		Board map= new Board(); //BOard that shall be used in the game, already defined by deafult
		Scanner input=new Scanner(System.in); //scanner holder
		int lDec; // variable that will hold the amount of levels desired by player
		int sDec; // variable that will hold the board size desired by player
		int bDec; // variable that will hold the decision for board setup of the player
		int cDec; // Variable that will hold the decision whether a player whishes to challenge or not.
		int numPlayers=0; // variable that holds the number of players
		String nDec;  //Variable that will input players name
		int turn=0;	//turn variable that will decide who goes next
		int mapEnergy; //a holder variable for the specific energy at a location
		int holderEnergy; // a variable that will hold a players energy level before being modified.
		
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
		holders[0]=new Player(players[0]);
		holders[1]=new Player(players[1]);
		turn=(int) (Math.random()*2);
		System.out.println("\nThe game has started "+players[turn].getName()+" goes first"+
						   "\n==============================================");
		//This will change the order of the two players so that the player that got to go
		//first will always go first
		if (turn==1) {
			holders[0]=new Player(players[0]);
			players[0]=new Player(players[1]);
			players[1]=new Player(holders[0]);
		}
		//round repetition- works on the principle that if the hasWon method does not return true it will execute every round
		turn=0;
		while(!hasWon(players[0],players[1],map)){
			//roll the dice of each player
			for(int r=0, o=0;r<2;r++) {
				if(r==0) {
					o=1; //variable indicating the opposite player
				}else {
					o=0; //variable indicating the opposite player
				}	
				//integrate algorithm that rolls three times for some one low on energy
				if(players[r].getEnergy()<=0) {
					for(int e=0;e<3;e++) {
						die.rollDice();
						System.out.println("\t"+players[r].getName()+" you rolled "+die);
						//check to see if the rolled dice are a double, if so energy increase
						if(die.isDouble()) {
							players[r].setEnergy(players[r].getEnergy()+2);
							System.out.println("\tCongratulations you rolled double "+die.getDie1()+". Your energy went up by 2 units");
						}
					}	
			  	}	
				if(players[r].getEnergy()>0) {
					System.out.println("It is "+ players[r].getName()+"'s turn");
					die.rollDice();
					System.out.println("\t"+players[r].getName()+" you rolled "+die);
					//check to see if the rolled dice are a double, if so energy increase
					if(die.isDouble()) {
						players[r].setEnergy(players[r].getEnergy()+2);
						System.out.println("\tCongratulations you rolled double "+die.getDie1()+". Your energy went up by 2 units");
					}
				}	
				//estimate the new location of the player
				holders[r]=calcLocation(players[r],die,map);
				//Check if players are in the exact same spot and challenge
				if(holders[r].equals(players[o])&&turn!=0) {
					System.out.println("Player "+players[o].getName()+" is at your new location!");
					System.out.println("what would you like to do?");
					System.out.println("\t0 - Challenge and risk loosing 50% of your energy units if you lose"
							+"\n\t\tor move to new location and get 50% of the other players energy units."+
							"\n\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy units");
					cDec= input.nextInt();
					while(cDec!=0||cDec!=-1) {
						if(cDec==1) {
							holders[r].setEnergy(players[r].getEnergy()-2);
							if(players[r].getLevel()>0) {
								players[r].setLevel(players[r].getLevel()-1);
								holders[r].setLevel(players[r].getLevel());
							}else {
								holders[r].setX(0);
								holders[r].setY(0);
								holders[r].setLevel(0);
							}
							System.out.println("You forfeit");
							break;
						}else if(cDec==0) {
							System.out.println("Challenge");
							break;
						}else {
							System.out.print("Sorry but "+cDec+" is not a legal choice\n");
							cDec=input.nextInt();
						}
					}
				} 					
			//this is where energy is adjusted as per the map however there is a bug here i cannot figure out.
				mapEnergy=map.getEnergyAdj(holders[r].getLevel(), holders[r].getX(), holders[r].getY());
				holderEnergy=holders[r].getEnergy();
				holderEnergy=mapEnergy+holderEnergy;
				holders[r].setEnergy(holderEnergy);
				System.out.println("\tYour energy is adjusted by "+mapEnergy+" for landing at ("+holders[r].getX()+","+
				holders[r].getY()+") at level "+holders[r].getLevel());
				System.out.println("energy is : "+players[r].getEnergy());
				
			}
			System.out.println("energy problem? :"+holders[0].getEnergy()+" "+ holders[0].getEnergy()+"p: "+players[0].getEnergy() );
				for(int e=0;e<2;e++) {
					players[e].setX(holders[e].getX());
					players[e].setY(holders[e].getY());
					players[e].setLevel(holders[e].getLevel());
					//problem is here
					players[e].setEnergy(map.getEnergyAdj(players[e].getLevel(), players[e].getX(), players[e].getY()));
				}
			
			
			//End of round
			System.out.println("At the end of this round:");
			for(int w=0;w<2;w++) {
				System.out.println("\t"+players[w].getName()+" is on level "+players[w].getLevel()+" at location ("+players[w].getX()+","+
						players[w].getY()+") and has "+players[w].getEnergy()+" units of energy");
			}
			turn++;
			//wait for a key to be pressed in order for the round to be over
			System.out.print("Press any Key to continue to the next Round");
			input.next().charAt(0);
			System.out.println("\n=============================================================================================="+
					"======================");
			
		}
		if(players[0].won(map)) 
			System.out.println("The winner is "+players[0].getName()+" you're a GOAT! congratulations");
		else
			System.out.println("The winner is "+players[1].getName()+" you're a GOAT! congratulations");
		System.out.println("Thank you for playing until next time!");
		input.close();
		
	}

	
	public static boolean hasWon(Player p1,Player p2,Board mp) {
		if(p1.won(mp)||p2.won(mp)) {
			return true;
		}else {
			return false;
		}
	}
	//this masterpiece of ducking code makes sure that my player moves accordingly and well :'(
	public static Player calcLocation(Player l1,Dice q1,Board og) {
		int sz=og.getSize();
		int sumD=q1.dieSum();
		int xMove=l1.getX()+(sumD/sz);
		int yMove=l1.getY()+(sumD%sz);
		Player holding= new Player(l1.getLevel(),l1.getX(),l1.getY());
		
		//this will always give the correct space for Y location
		if (yMove>=sz) { 
			yMove=yMove%sz;
			xMove++;
		} 
		//now adjust x according if it is ever off the board
		if(xMove>=sz){
			xMove=xMove%sz;
			holding.setLevel(holding.getLevel()+1);
		}
		holding.setX(xMove);
		holding.setY(yMove);
		
		//this will only execute if the player is going to a next level and 
		//and the player is on the last level
		if(holding.getLevel()>=og.getLevel()) {
			l1.setX(l1.getX());
			l1.setY(l1.getY());
			l1.setEnergy(l1.getEnergy()-2);
			l1.setLevel(l1.getLevel());
		}else {
		//otherwise always move the player unless he is about to win
			l1.setX(holding.getX());
			l1.setY(holding.getY());
			l1.setLevel(holding.getLevel());
		}
		return l1;
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