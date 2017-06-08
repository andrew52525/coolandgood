import java.util.*;

public class StackCalc{
    public static double eval(String s){
		String[] a = s.split(" ");
		Stack<Double> nums = new Stack<Double>();
		for (int i = 0; i < a.length; i++){
			if(isOp(a[i])){nums.push(operate(a[i], nums.pop(), nums.pop()));}
			else{nums.push(Double.parseDouble(a[i]));}
		}
		return nums.pop();
	}


    public static double operate(String op, Double a, Double b){
		if(op.equals("+")){return a + b;}
		if(op.equals("*")){return a * b;}
		if(op.equals("-")){return b - a;}
		if(op.equals("/")){return b / a;}
		if(op.equals("%")){return b % a;}	
		return 0.0;
    }
	private static boolean isOp(String op){
		return (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%"));
    }
}