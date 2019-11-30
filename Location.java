
public class Location {

	public static void main(String[] args) {
		Dice die=new Dice(); // creation of the dice of the game
		Player played =new Player(); //Player array that will hold the two players
		Player holding =new Player();
		Board map= new Board(4,4); //BOard that shall be used in the game, already defined by deafult
		played.setName("DAN");
		
		boolean weiner=false;
		while(!weiner) {
			die.rollDice();
			holding=calcLocation(played,die,map);
			played.setX(holding.getX());
			played.setY(holding.getY());
			played.setLevel(holding.getLevel());
			System.out.println("the dice rolled: "+die+" sum is: "+die.dieSum()+ "\n the new location is x: "+ played.getX()+
					" y: "+played.getY()+"  level: "+played.getLevel());
			if(played.won(map))
				weiner=true;
		}

		System.out.print("Fuck MOVING");
	}
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
			l1.setX(holding.getX());
			l1.setY(holding.getY());
			l1.setLevel(holding.getLevel());
		}
		return l1;
	}
	
}
