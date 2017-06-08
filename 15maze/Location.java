public class Location implements Comparable<Location>{
	private int r, c;
	private Location prev;
	private int dStart;
	private int dEnd;
	private boolean aStar;
	
	public Location(int ri, int ci, Location previ, int dSi, int dEi){
		r=ri; c=ci; prev=previ; dStart=dSi; dEnd=dEi;}
	public Location(int ri, int ci, Location previ, int dSi, int dEi, boolean aStari){
		this(ri, ci, previ, dSi, dEi); aStar=aStari;}
		
	public int getR(){return r;} 	public int getC(){return c;}
	public int getdS(){return dStart;}  public int getdE(){return dEnd;}
	public boolean getaS(){return aStar;}
	public Location getPrev(){return prev;}
	
	public int compareTo(Location other){
		if(other.getaS()){
			return ((getdS() + getdE()) - 
					(other.getdS() + other.getdE()));
		}
		else{return getdE() - other.getdE();}
	}
}