import java.util.ArrayList;

public class MazeSolver{
	private Maze a;
	private boolean animate;
	
	public MazeSolver(String filename){
		this(filename, false); }
	public MazeSolver(String filename, boolean animatei){
		a = new Maze(filename);  animate = animatei; }
		
	public void solve(){solve(1);}
	
	public void solve(int n){
		
		Frontier f; boolean aS = false;
		
		if(n==3){aS = true;}
		if(n==0){f = new StackFrontier();}
		else if(n==1){f = new QueueFrontier();}
		else if(n==2||n==3){f = new FrontierPriorityQueue();}
		else{throw new IllegalArgumentException();}
		
		Location s = a.getStart(); Location e = a.getEnd();
		f.add(s);
		while(f.getSize() > 0){
			Location c = f.next();
			int ro = c.getR(); int co = c.getC();
			if(d(c, e)==0){ //if ur at the end
				a.set(ro, co, 'E');
				while(c.getPrev() != null){
					c = c.getPrev();
					a.set(c.getR(), c.getC(), '@');
				}
				a.set(c.getR(), c.getC(), 'S');
				break;
			}
			ro++;
			if(a.get(ro, co)==' '){
				f.add(new Location(ro, co, c, d(ro, co, a.getStart()), d(ro, co, a.getEnd()), aS));
				a.set(ro, co, '?');}
			ro--; co++;
			if(a.get(ro, co)==' '){
				f.add(new Location(ro, co, c, d(ro, co, a.getStart()), d(ro, co, a.getEnd()), aS));
				a.set(ro, co, '?');}
			co--; co--;
			if(a.get(ro, co)==' '){
				f.add(new Location(ro, co, c, d(ro, co, a.getStart()), d(ro, co, a.getEnd()), aS));
				a.set(ro, co, '?');}
			co++; ro--;
			if(a.get(ro, co)==' '){
				f.add(new Location(ro, co, c, d(ro, co, a.getStart()), d(ro, co, a.getEnd()), aS));
				a.set(ro, co, '?');}
			ro++;
			a.set(ro, co, '.');
			if(animate){System.out.println(this.toString());}
			//System.out.println(e.getR() + " " + e.getC());
		}
	}
	
	public String toString(){return a.toString();}
	public String toString(int ms){return a.toString(ms);}
	
	public int d(Location a, Location b){
		return d(a.getR(), a.getC(), b);		
	}
	public int d(int ro, int co, Location b){
		return(Math.abs(ro - b.getR()) + Math.abs(co - b.getC()));
	}
}