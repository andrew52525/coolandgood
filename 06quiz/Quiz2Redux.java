import java.util.*;
public class Quiz2Redux{
	/*public static void main (String[] args){
		System.out.println("cool");
		for (String s : combinations("abcd")){
			System.out.println(s);
		}
	}*/
	public static ArrayList<String> combinations(String s){
		ArrayList<String> words = new ArrayList<String>();
		help(words, s, "", 0);
		Collections.sort(words);
		return words;
	}
	public static void help (ArrayList<String> words, String s, String n, int x){
		if (x == s.length()){words.add(n);}
		else{
			help(words, s, n + s.charAt(x), x+1);
			help(words, s, n, x+1);
		}
	}
	
}