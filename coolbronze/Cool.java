/*
there are 9 cows
there are R rows of spots and C of spots
1st number is R, 2nd numberr is C, 3rd number is D, inches by stomping
hit the highest number in the 3x3, and then press by D

N instructions
E is final sea level
find V

next lines are array
next lines are instructions

calculate V with inches (one square six by six foot)

*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Cool{
    private int[][] farm;
    private int sealevel;

    public static void main (String[] args) throws FileNotFoundException {
	//testing stuff
	System.out.println("cool");
	Cool c = new Cool();
	c.bronze("good.txt");
    }
    public int bronze(String filename)throws FileNotFoundException{
	Scanner in = new Scanner(new File(filename));
	int rows = in.nextInt(), cols = in.nextInt();
	farm = new int[rows][cols];
	sealevel = in.nextInt();
	int numCommands = in.nextInt();
	int r = 0, c = 0;
	int[][] instructions = new int[numCommands][3];
	while(in.hasNextInt()) {
	    if(r < rows) {
	        farm[r][c] = in.nextInt();
	        c++;
	        if(c >= cols) {r++; c = 0;}
	    }
	    else if(r == rows) {
		r = 0;
		c = 0;
	    }
	    else {
		instructions[r] = new int[] {
		    in.nextInt(), in.nextInt(), in.nextInt()
		};
		r++;
	    }
	}
	parray(farm);
	return 0;
    }
    public void parray(int[][] a){
	String retstr = "";
	for (int i = 0; i < a.length; i++){
	    for (int j = 0; j < a[0].length; j++){
		retstr+= (a[i][j] + " ");
	    }
	    retstr+="\n";
	}
	System.out.println(retstr);
    }
    public void stomp(int row, int col, int amount) {
	//
    }
 }
