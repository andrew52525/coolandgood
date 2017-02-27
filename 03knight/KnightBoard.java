public class KnightBoard{
    private int[][] board;
    public KnightBoard(int y, int x){
	board = new int[y][x];
    }
    public String toString(){
	String retstr = "";
	for (int[] y : board){
	    for (int x: y){
		if (x < 10 && x > 0){System.out.print(" ");}
		retstr+=" ";
		retstr+=x;
	    }
	    retstr+="\n";
	}
	return retstr;
    }
    public void solve(){
	boolean breaker = false;
	for (int j = 0; j < 1+board.length/2; j++){
	    if (!breaker){
		for (int i = 0; i < 1+board[0].length/2; i++){
		    if(cool(j, i, 1)){
			breaker = true;
			break;
		    }
		}
	    }
	} 
	//cool(board.length, board[0].length, 2);
    }
    
    private boolean cool(int y, int x, int level){

	//first, place the shit
	board[y][x] = level;
	if (level == board.length*board[0].length){
	    return true;
	}

        /*int[][] spots = {{y+1,x+2},{y+2,x+1},{y-1,x+2},{y-2,x+1},{y-1,x-2},{y-2,x-1},{y+1,x-2},{y+2,x-1}};
	for (int i = 0; i < 8; i++){
	    //for each spot if spot is 0 and spot is on board, cool at that spot
	    //if cool at that spot returns true, return true (stop everything)
	    if ((spots[i][0] < board.length) && (spots[i][0] >= 0) && 
		(spots[i][1] < board[0].length) && (spots[i][1] >= 0) &&
		(board[spots[i][0]][spots[i][1]] == 0)){
		//it gets to here
		if (cool(spots[i][0], spots[i][1], level+1)){
		    return true;
		}
	    }
	    }*/
	int xcheckadd = 1;
	int ycheckadd = 2;
	for (int i = 0; i < 8; i++){
	    int xcheck = xcheckadd + x;
	    int ycheck = ycheckadd + y;
	    if ((ycheck<board.length)&&(ycheck>=0)&&
		(xcheck<board[0].length)&&(xcheck>=0)&&
		(board[ycheck][xcheck]==0)){
		if (cool(ycheck, xcheck, level+1)){
		    return true;
	        }
	    }
	    int b = ycheckadd; ycheckadd = xcheckadd; xcheckadd=b;
	    if (i%4==3){xcheckadd = 0-xcheckadd;}
	    if (i%4==1){ycheckadd = 0-ycheckadd;}
	    // System.out.println("" + xcheckadd + " " + ycheckadd + " " + i);
	}
	//remove the shit
	board[y][x] = 0;
	return false;
    }
    public static void main (String[] args){
	KnightBoard cool = new KnightBoard(6, 5);
	cool.solve();
	//System.out.println(cool);
    }
}
