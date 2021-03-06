import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Maze{
    private char[][]tmaze = new char[5000][5000]; 
    private char[][]maze;
    private boolean animate;
    int numRow = 0;
    int numCol = 0;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename) throws FileNotFoundException{

	File text = new File(filename); 
        Scanner inf = new Scanner(text);
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    for (int i = 0; i < line.length(); i++){
		tmaze[numRow][i] = line.charAt(i);
	    }
	    numRow++;
        }    
	for(int i = 0; i > -1; i++){
	    if (tmaze[0][i]!=('#')){numCol = i; break;}}
	for(int i = 0; i > -1; i++){
	    if (tmaze[i][0]!=('#')){numRow = i; break;}} 
	System.out.println("" + numCol + "  " +  numRow);
	maze = new char[numRow][numCol];
	for (int i = 0; i < numRow; i++){
	    for (int j = 0; j < numCol; j++){
		maze[i][j] = tmaze[i][j];//mistake?? check orientation
	    }
	}
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length; j++){
		System.out.print(maze[i][j]);
	    }
	    System.out.println("");
	}
    }

    public String toString(){
	String retstr = "";
	for (int i = 0; i < numRow; i++){
	    for (int j = 0; j < numCol; j++){
		retstr+=maze[i][j];
	    }
	    retstr+="\n";
	}
	return retstr;
    }
    public void setAnimate(boolean b){
        animate = b;
    }
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
            //Initialize starting row and startint col with the location of the S. 
	    boolean stop = true;
	    for (int i = 0; i < numRow; i++){
		if(stop){
		    for (int j = 0; j < numCol; j++){
			if (maze[i][j] == 'S'){startr = i; startc = j; stop = false;break;}
		    }
		}
		if(!stop){break;}
	    }
            maze[startr][startc] = '@';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
	if(animate){System.out.println("\033[2J\033[1;1H"+this);wait(20);}
	if (maze[row][col] == 'E'){maze[row][col] = '@'; return true;}
	boolean alive = false;
	maze[row][col] = '@';
	
	row++; if(solveHelp(row, col)){return true;}
        row = row - 2; if(solveHelp(row, col)){return true;}
        row++; col++; if(solveHelp(row, col)){return true;}
        col = col - 2; if(solveHelp(row, col)){return true;}
        col++;
	if (alive == false){maze[row][col] = '.'; return false;}
        else {return true;}

        //COMPLETE SOLVE
    }
    private boolean solveHelp(int row, int col){
        if ((maze[row][col] == ' ') || (maze[row][col] == 'E')){
	    if(solve(row, col)){
		return true;
	    }
	}
	return false;
    }
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

}
