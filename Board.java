/* -------------------------------------------------------
// Assignment 4 Nancy's 3D Warrior Game
 * 
 * 
 * 
// Written by: Daniel Torres 40101143
// For COMP 248 Section (FF) � Fall 2019
// --------------------------------------------------------*/
public class Board {
	public int[][][] board;
	private static int MIN_LEVEL=3;
	private static int MIN_SIZE=3;
	public int level;
	public int size;
	
	
	//Default Constructor
	public Board(){
		level=MIN_LEVEL;
		size=4;
		createBoard(size,level);
	}
	//user defined constructor
	public Board(int l, int x){
		level=l;
		size=x;
		createBoard(size,level);
	}
	//method to create board
	private void createBoard(int bSize,int bLevel) {
		board=new int[bLevel][bSize][bSize];
	}
	//accesor methods
	public int getSize() {
		return this.size;
	}
	public int getLevel() {
		return this.level;
	}
	public int getEnergyAdj(int l, int x, int y) {
		return board[l][x][y];
	}
	//output method
	public String toString(){
		String output="";
		
		for(int l=0;l < board.length ;l++) {
			if (l==0)
				output="level ";
			else
				output=output.concat("level ");
			output = output.concat(Integer.toString(level));
			output = output.concat("\n--------\n");
			
			for(int x=0; x < board[l].length ;x++) {
				for(int y=0;y < board[l][x].length ;y++) {
					output=output.concat("\t"+board[l][x][y]);
				}
				output=output.concat("\n");
			}
		}
		
		return output;
	}
}