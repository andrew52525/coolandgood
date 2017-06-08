import java.util.*;

public class StackFrontier implements Frontier{
	private Stack<Location> a;
	private int size;
	
	public StackFrontier(){
		a = new Stack<Location>();		
	}
	
	public void add(Location l){
		a.push(l); size++;
	}
	public Location next(){
		size--;
		return a.pop();
	}
	public boolean hasNext(){return !a.isEmpty();}
	public int getSize(){return size;}
}