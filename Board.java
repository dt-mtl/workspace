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
		createBoard(level,size);
	}
	//user defined constructor
	public Board(int l, int x){
		level=l;
		size=x;
		createBoard(level,size);
	}
	//method to create board
	private void createBoard(int bLevel,int bSize) {
		board=new int[bLevel][bSize][bSize];
		
		for(int l=0;l < bLevel;l++){
		    for(int x=0;x<bSize;x++){
		        for(int y=0;y<bSize;y++){
		        	if(x==0&&y==0&&y==0) {
		        		board[l][x][y]=0;
		        	}else if(((l+x+y)%3)==0){
		                board[l][x][y]=-3;
		            }else if(((l+x+y)%5)==0){
		                board[l][x][y]=-2;
		            }else if(((l+x+y)%7)==0){
		                board[l][x][y]=2;
		            }else{
		                board[l][x][y]=0;
		            }       
		        }
		    }
		}
		
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
				output="\nlevel ";
			else
				output=output.concat("level ");
			output = output.concat(Integer.toString(l));
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