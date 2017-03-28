import java.util.Random;
public class Merge{
    public static void main (String[] args){
	/*int[] a = new int[10];
	int[] b = new int[10];
	int[] d = new int[20];
	Random rn = new Random();
	for (int i = 0; i < a.length; i++){
	    a[i] = rn.nextInt(8);
	    b[i] = rn.nextInt(9);
	}
	for (int i = 0; i < a.length; i++){
	    System.out.print(a[i] + " ");
	}
	System.out.println("b");
	for (int i = 0; i < b.length; i++){
	    System.out.print(b[i] + " ");
	}
	System.out.println("d");
	merge(a, b, d);
	for (int i = 0; i < d.length; i++){
	    System.out.print(d[i]);
	}
	mergesort(a);
	for (int i = 0; i < a.length; i++){
	    System.out.print(a[i]);
	}*/
    }
    public static int[] mergesort(int[] a){
	if (a.length == 1){
	    return a;
	}
	else{
	    int[] left = new int[a.length/2];
	    int[] right = new int[a.length-left.length];
	    for (int i = 0; i < left.length; i++){left[i] = a[i];}
	    for (int i = 0; i < right.length; i++){right[i] = a[i+left.length];}
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, a);
	    return a;
	}
    }
    public static void merge(int[] a, int[] b, int[] d){
	int bi = 0, ai = 0;
	for (int i = 0; i < d.length; i++){
	    if (ai==a.length){d[i] = b[bi];bi++;}
            else{
		if(bi==b.length){d[i] = a[ai];ai++;}
		else{
		    if (a[ai] < b[bi]){d[i] = a[ai];ai++;}
		    else{d[i] = b[bi];bi++;}
		}
	    }
	}
    }
}
