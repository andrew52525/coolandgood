public class Recursion{
	public static String name(){
		return "Chen,Andrew";
	}
	public static double sqrt(double n){
		if (n < 0){throw new IllegalArgumentException();}
		return sqrtHelp(n, 1);
	}
	public static double sqrtHelp (double n, double guess){
		if (closeEnough(n, guess*guess)){
			return guess;
		}
		return sqrtHelp(n, (n/guess + guess) / 2);
	}
	public static boolean closeEnough(double n, double m){
		return ((-.00001 < (n - m)/m) && (.00001 > (n-m)/m));
	}
	public static void main (String[] args){
		System.out.println(sqrt(4));
		System.out.println(sqrt(1));
		System.out.println(sqrt(.001));
	}
	
	
}