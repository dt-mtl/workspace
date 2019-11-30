
public class writtenLine {

	public static void main(String[] args) {
		// This program will attempt to output the whole matrix as one string
		int[][][]board= {{{1,2,3},{4,5,3,4,5,6,},{7,8,9}},{{1,2,3},{4,5,2,3,6,},{7,8,9}},{{1,3,2,2,3},{4,5,6,},{7,8,9}}};	
		System.out.println("this board should look like: ");
		
		String output="";
		
		for(int level=0;level < board.length ;level++) {
			if (level==0)
				output="level ";
			else
				output=output.concat("level ");
			output = output.concat(Integer.toString(level));
			output = output.concat("\n--------\n");
			
			for(int x=0; x < board[level].length ;x++) {
				for(int y=0;y < board[level][x].length ;y++) {
					output=output.concat("\t"+board[level][x][y]);
				}
				output=output.concat("\n");
				
			}
			
			
		}
		
		System.out.print(output);
	}

}
