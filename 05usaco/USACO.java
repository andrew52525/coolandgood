
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class USACO{
    private int[][] farm;
    private int sealevel;

    public static void main (String[] args) throws FileNotFoundException {
	//testing stuff
	USACO c = new USACO();
	//c.bronze("good.txt");
	//System.out.println(c.silver("ngood.txt"));
    }
	
	public int silver(String filename)throws FileNotFoundException{
		Scanner in = new Scanner(new File(filename));
		int n = in.nextInt(), m = in.nextInt(), t = in.nextInt();
		int[][] a = new int[n][m];
		in.nextLine();
		for (int i = 0; i < n; i++){
			String line = in.nextLine();
			for (int j = 0; j < m; j++){
				char whatitbe = line.charAt(j);
				if (whatitbe == '.'){a[i][j] = 0;}
				if (whatitbe == '*'){a[i][j] = -1;}
			}
		}
		int r1 = in.nextInt()-1, c1 = in.nextInt()-1, r2 = in.nextInt()-1, c2 = in.nextInt()-1;
		a[r1][c1] = 1;
		return shelp(r2, c2, n, m, t, a, 1);
	}
	public int shelp(int r2, int c2, int n, int m, int t, int[][] a, int tcurr){
		int[][] b = new int[n][m];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				if (a[i][j] < 0){b[i][j] = -1;}
				else{
				if ((i!=n-1)&&(a[i+1][j]>=0)){b[i+1][j] += a[i][j];}
				if ((i!=0)&&(a[i-1][j]>=0)){b[i-1][j] += a[i][j];}
				if ((j!=m-1)&&(a[i][j+1]>=0)){b[i][j+1] += a[i][j];}
				if ((j!=0)&&(a[i][j-1]>=0)){b[i][j-1] += a[i][j];}}
			}
		}
		if (t == tcurr){return b[r2][c2];}
		return shelp(r2, c2, n, m, t, b, tcurr+1);
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
	    else {
		instructions[r-rows] = new int[] {
		    in.nextInt(), in.nextInt(), in.nextInt()
		};
		stomp(instructions[r-rows][0], instructions[r-rows][1], instructions[r-rows][2]);
		r++;
	    }
	}
	parray(farm);
	return compute();
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
	int highest = farm[row][col];
	for (int i = row; i < row+3; i++){
	    for (int j = col; j < col+3; j++){
		if (farm[i][j] > highest){highest = farm[i][j];}
	    }
	}
	if (highest - amount < 0){highest = amount;}
	System.out.println("XDDDD" + highest);
       	for (int i = row; i < row+3; i++){
	    for (int j = col; j < col+3; j++){
	        if (farm[i][j]>highest-amount){farm[i][j] = highest-amount;}
	    }
	}
    }
    public int compute(){
	int howmuchwater = 0;
	for (int i = 0; i < farm.length; i++){
	    for (int j = 0; j < farm[0].length; j++){
		if(sealevel > farm[i][j]){
		    howmuchwater += (sealevel - farm[i][j])*5184;
		}
	    }
	}
	return howmuchwater;
    }
 }
