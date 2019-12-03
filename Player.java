/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game- PLayer Class
 * 
 * This is the class for object players. The class will create the players and has three different constructors,
 * in addition to mutator and accessor methods required. Additional methods include a toPrint method that will
 * output a short description of the player, in addition to a method that verifies if players are in the same 
 * location and if a player has won.
 * 
// Written by: Daniel Torres 40101143
// For COMP 248 Section (FF) � Fall 2019
// --------------------------------------------------------*/
public class Player {
	//Five instance variable required for this object class
	private String name; // name of player
	public int x;  //position variable
	public int y;	//position variable
	public int level;	//position variable
	public int energy;	//energy counter variable
	
	//default constructor
	public Player() {
		name="";
		x=0;
		y=0;
		level=0;
		energy=10;
		
	}
	//parameter user defined constructor that only assigns name
	public Player(String n) {
		name=n;
		x=0;
		y=0;
		level=0;
		energy=10;
		
	}
	//parameter user defined constructor that only assigns location of an object and no name
	public Player(int l,int x1, int y1) {
		name="";
		x=x1;
		y=y1;
		level=l;
		energy=10;
			
	}
	//5. A copy constructor which duplicates the passed Player object?
	public Player(Player p3) {
		this.name=p3.getName();
		this.x=p3.getX();
		this.y=p3.getX();
		this.level=p3.getLevel();
		this.energy=p3.getEnergy();
	}
	//mutator methods
	public void setX(int x2) {
		this.x=x2;
	}
	public void setY(int y2) {
		this.y=y2;
	}
	public void setLevel(int l1) {
		this.level=l1;
	}
	public void setEnergy(int e) {
		this.energy=e;
	}
	public void setName(String n1) {
		this.name=n1;
	}
	// Accessor methods
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getLevel() {
		return this.level;
	}
	public String getName() {
		return this.name;
	}
	public int getEnergy() {
		return this.energy;
	}
	
	//move to method 
	public void moveTo(Player p1) {
		x=p1.getX();
		y=p1.getY();
		level=p1.getLevel();
		
	}
	// won board method- method that verifies if one of the players has won.
	public boolean won(Board b1) {
		
		if(this.x==b1.getSize()-1&&this.y==b1.getSize()-1&&this.level==b1.getLevel()-1)
			return true;
		return false;
	}
	
	//equals method-checks that players are in the same location
	public boolean equals(Player p2) {
		
		if(this.x==p2.getX() && this.y==p2.getY() && this.level==p2.getLevel()) {
			return true;
		}else {	
			return false;
		}
	}
	
	// To string method
	public String toString() {
		String info;
		info=String.format("Player name: %s Location is level: %d X: %d Y: %d Energy: %d", 
				getName(),getLevel(),getX(),getY(),getEnergy());
		return info;
	}
	
}