import java.util.*;

public class MyHeap{
    private int size;
    private ArrayList<Integer> arr;
    private int konstans;

    public MyHeap(boolean b){
	size = 0;
	arr = new ArrayList<Integer>();
	arr.add(420);
	if(b == true)
	    konstans = 1;
	if(b == false)
	    konstans = -1;
    }

    public int size(){
	return size;
    }

    public MyHeap(){
	size = 0;
	konstans = 1;
	arr = new ArrayList<Integer>();
	arr.add(420);
    }
    
    public int peek(){
	return arr.get(1);	
    }

    private int LChild(int n){
	return arr.get(2 * n);
    }

    private int RChild(int n){
	return arr.get(2 * n + 1);
    }

    private int getParent(int n){
	return arr.get(n / 2);
    }

    private boolean hasParent(int n){
	return n != 1;
    }

    private boolean hasLChild(int n){
	return size >= 2 * n;
    }

    private boolean hasRChild(int n){
	return size >= 2 * n + 1;
    }

    private void pushUp(int n){
	if (hasParent(n) && (getParent(n) - arr.get(n)) * konstans < 0){
	    int s = getParent(n);
	    arr.set(n / 2, arr.get(n));
	    arr.set(n, s);
	    pushUp(n / 2);
	}
    }

    private void pushDown(int n){

	if(n == 0)
	    return;


	int pos = 0; //0 = 0, -1 = L, 1 = R
	int s = arr.get(n);
	if(hasLChild(n) && (s - LChild(n)) * konstans < 0){
	    pos = -1;
	    s = LChild(n);
	}
	if(hasRChild(n) && (s - RChild(n)) * konstans < 0){
	    pos = 1;
	    s = RChild(n);
	}

	if(pos == 0)
	    return;
	if(pos == -1){
	    int l = LChild(n);
	    arr.set(n * 2, arr.get(n));
	    arr.set(n, l);
	    pushDown(n * 2);
	    return;
	}

	if(pos == 1){
	    int l = RChild(n);
	    arr.set(n * 2 + 1, arr.get(n));
	    arr.set(n, l);
	    pushDown(n * 2 + 1);
	    return;
	}
    }

    public void add(int s){
	arr.add(s);
	size++;
	pushUp(size);
    }

    public int remove(){
	if(size == 1){
	    int s = arr.get(1);
	    size--;
	    arr.remove(1);
	    return s;
	}


	int s = arr.get(1);
	arr.set(1, arr.remove(size));
	size--;
	pushDown(1);
	
	return s;
    }

    public void display(){
	for(int s : arr){
	    System.out.print(s + " ");
	}
    }
    
}