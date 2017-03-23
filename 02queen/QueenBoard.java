public class QueenBoard{
    private int[][] board;
    private static int solutionCount = -1;
    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    public void solve(){
	System.out.println(method(0));
    }

    public void countSolutions(){
	solutionCount=0;
	countSolutionsMethod(0);
    }
    public boolean countSolutionsMethod(int x){
	boolean retbool = false;
	for (int y = 0; y < board.length; y++){
	    if (board[y][x]==0){
		addQueen(y, x);
		if (x == board.length-1){solutionCount++;retbool=true;}
		else {if(countSolutionsMethod(x+1)){retbool = true;}}
		addQueen(y, x);//remove queen
	    }
	}
	return retbool;
    }
    public boolean method(int x){
	for (int y = 0; y < board.length; y++){
	    if (board[y][x]==0){
		addQueen(y, x);
		if (x == board[y].length-1){solutionCount++;return true;}
		else{if(method(x+1)){return true;}}
		addQueen(y, x);
	    }
	}
	return false;
    }

    public int getSolutionCount(){return solutionCount;}

    public String toString(){
	String retstr = "";
	for (int[] x : board){
	    for (int y: x){
		retstr+=y;
		if(y!=-1){retstr+=" ";}
	    }
	    retstr+="\n";
	}
	return retstr;
    }

    private void addQueen(int y, int x){
        if (board[y][x] == -1){
	    board[y][x] = 0;
	    for (int i = x+1; i < board.length; i++){
		board[y][i]--;
	    } 
	    for (int i = 1; i+x < board.length; i++){
		if (i+y<board.length){board[i+y][i+x]--;}
		if (y-i>=0){board[y-i][i+x]--;}
	    }
	}
	else{
	    if (board[y][x]!=0){System.out.println("oh no it broke");}
	    board[y][x] = -1;
	    for (int i = x+1; i < board.length; i++){
		board[y][i]++;
	    }
	    for (int i = 1; i+x < board.length; i++){
		if (i+y<board.length){board[i+y][i+x]++;}
		if (y-i>=0){board[y-i][i+x]++;}
	    }
	}
    }
    public static void main (String[] args){
      QueenBoard a = new QueenBoard(6);
      a.solve();
      System.out.println(solutionCount);
      System.out.println(a);
      QueenBoard[] c = new QueenBoard[12];
      for (int i = 1; i < 13; i++){
      c[i-1] = new QueenBoard(i);
      c[i-1].countSolutions();
      System.out.println(solutionCount);
      System.out.println(c[i-1]);
      }
      }	
}
