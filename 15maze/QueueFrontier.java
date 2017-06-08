import java.util.*;

public class QueueFrontier implements Frontier{
	private LinkedList<Location> a;
	private int size;
	
	public QueueFrontier(){
		a = new LinkedList<Location>();		
	}
	
	public void add(Location l){
		a.add(l); size++;
	}
	public Location next(){
		size--;
		return a.remove();
	}
	public boolean hasNext(){return !a.isEmpty();}
	public int getSize(){return size;}
}