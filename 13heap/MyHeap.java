import java.util.ArrayList;

public class MyHeap{
    
    int min = 1;  //min being -1 means it will flip things to min... -1 is ON
    int s = 0;//s is size
    ArrayList<Comparable> a;
    
    public MyHeap(){
	a = new ArrayList<Comparable>(100);
	a.add(0);
    }
    public MyHeap(boolean b){  //if false is inputted, it will set min on
	super();
	if(!b){min = -1;} else{min = 1;}
    }
    public static void main (String[] args){
	/*MyHeap b = new MyHeap();
	b.add("cool");
	b.add("hi");
	b.add("a");
	b.add("b");
	b.add("cdas");
	b.add("z");
	b.add("y");
	b.add("f");
        for (int i = 0; i < 8; i++){System.out.println(b.remove());}*/
    }
    public void add (Comparable x){
	s++;
        a.add(x);
	up(s);
    }
    public Comparable remove(){
	Comparable r = a.get(1);
	a.set(1, a.get(s));  //put the last one into first
	down(1); //push it down
	a.remove(s);
	s--;
	return r;
    }
    public Comparable peek (){
	return a.get(1);
    }

    private void swap (int c, int b){
	a.set(c, a.set(b, a.get(c)));
    }
    private void up(int i){
	if (i != 1){ //to check that it has parents
	    if (a.get(i/2).compareTo(a.get(i)) * min < 0){ //if parent is smaller(max)
		swap(i, i/2);
		up(i/2);
	    }
        }
	//recursively pushes up
    }
    private void down(int i){
	if ((i*2)+1 < s) { //to check that children exists
	    int c1 = i*2; int c2 = (i*2) + 1;
	    if (a.get(c1).compareTo(a.get(i))*min >0){
		if (a.get(c2).compareTo(a.get(c1))*min>0){ 
		    swap(i, c2);
		    down(c2);
		}
		else{ 
		    swap(i, c1);
		    down(c1);
		}
	    }
	    if (a.get(c2).compareTo(a.get(i))*min>0){
		swap(i, c2);
		down(c2);
	    }
	}
        else if (i*2 < s){ // in case just one child exists
	    if (a.get(i*2).compareTo(a.get(i))*min>0){
		swap(i, i*2);
		down(i*2);
	    }
	}
    }

    //if maxheap, big numbers on top, remove ethe largest
    //if minheap, remove the smallest (top)

    //to refer to left child, n*2
    //to refer to right child, n*2 + 1
    //to refer to parent, divide by 2
}
