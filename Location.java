
public class Location {

	public static void main(String[] args) {
		Dice die=new Dice(); // creation of the dice of the game
		Player played =new Player(); //Player array that will hold the two players
		Player holding =new Player();
		Board map= new Board(5,5); //BOard that shall be used in the game, already defined by deafult
		played.setName("DAN");
		
		int stop=0;
		while(stop==0) {
			die.rollDice();
			holding=calcLocation(played,die,map);
			played.setX(holding.getX());
			played.setY(holding.getY());
			played.setLevel(holding.getLevel());
			System.out.println(played);
		}

		System.out.print("Fuck MOVING");
	}
	public static Player calcLocation(Player l1,Dice q1,Board og) {
		int sz=og.getSize();
		int lvl=og.getLevel();
		int sumD=q1.dieSum();
		int xMove=l1.getX()+(sumD/sz);
		int yMove=l1.getY()+(sumD%sz);
		int option=0;
		l1.setX(xMove);
		l1.setY(yMove);
/*		Player nextPlace=new Player(l1.getLevel(),l1.getX(),l1.getY());
		if(yMove>=sz) {
			nextPlace.setX(xMove);
			nextPlace.setY(yMove%sz);
			nextPlace.setLevel(l1.getLevel());
			option=1;
		}else if(xMove>=sz) {
			option=2;
			nextPlace.setX(xMove%sz);
			nextPlace.setLevel(l1.getY()+1);
			if(nextPlace.getLevel()>=lvl) {
				nextPlace.setX(l1.getX());
				nextPlace.setEnergy(l1.getEnergy()-2);
			}
		}else if (xMove>=sz&&yMove>=sz) {
			option=3;
			nextPlace.setY(yMove%sz);
			xMove=(yMove/sz)+xMove;
			nextPlace.setX(xMove%sz);
			nextPlace.setLevel(l1.getY()+1);
			if(nextPlace.getLevel()>=lvl) {
				nextPlace.setX(l1.getX());
				nextPlace.setY(l1.getY());
				nextPlace.setEnergy(l1.getEnergy()-2);
			}
		}else {
		//6 C 1
			option=4;
			nextPlace.setX(xMove);
			nextPlace.setY(yMove);
			nextPlace.setLevel(l1.getLevel());
		}
		return nextPlace;
		
		*/
		return l1;
	}
}
