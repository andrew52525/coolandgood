import java.util.PriorityQueue;
public class FrontierPriorityQueue implements Frontier{
	private PriorityQueue<Location> a;
	private int size;
	
	public FrontierPriorityQueue(){
		a = new PriorityQueue<Location>();
	}
	public void add(Location l){
		a.add(l);
		size++;		
	}
	public Location next(){
		size--;
		return a.remove();
	}
	
	public int getSize(){return size;}
	
}