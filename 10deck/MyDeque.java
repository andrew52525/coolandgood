import java.util.*;
public class MyDeque{
	private String[] a;
	private int size, start , end;

	public MyDeque(){
		a = new String[10];		
		start = 0;
		end = 9;
	}
	
	private void resize(){
		String[] newa = new String[a.length * 2];
		int i = start; int j = start;
		while(i != end){
			newa[j] = a[i]; 
			i++; j++;
			if(i==a.length){i=0;}
		}
		newa[j] = a[i];
		a = newa;
		end = j;
	}
	
	public void addFirst(String s){
		if(s==null){throw new NullPointerException("oh no");}
		if(size == a.length){resize();}
		if(start==0){start = a.length;}
		start = (start-1);
		a[start] = s;
		size++;
	}
	public void addLast(String s){
		if(s==null){throw new NullPointerException("oh no");}
		if(size == a.length){resize();}
		end = (end+1)%(a.length);
		a[end] = s;
		size++;
	}
	public String removeFirst(){
		if(size == 0){throw new NoSuchElementException("oh no");}
		String r = getFirst();
		start = (start+1)%(a.length);
		size--;
		return r;
	}
	public String removeLast(){
		if(size == 0){throw new NoSuchElementException("oh no");}
		String r = getLast(); 
		if(end==0){end=a.length;}
		end = (end-1);
		size--;
		return r;
	}
	public String getFirst(){
		if(size == 0){throw new NoSuchElementException("oh no");}
		return a[start];
	}
	public String getLast(){
		if(size == 0){throw new NoSuchElementException("oh no");}
		return a[end];
	}
	
	public static void main(String[] args){
		
		
	}
	
}