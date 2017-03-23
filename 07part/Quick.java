import java.util.Random;
public class Quick{
	
    public static int part (int[] data, int start, int end){
	Random rn = new Random();
	int v;
	int i = start+1, k = start+1, j = end;
	if (end!=start){v = start + rn.nextInt(end-start+1);}
	else{return start;}
	System.out.println("startpart"+ " s" + start + " e" + end + " v" + v);
	swap(data, v, start);
	while (i <= j){
	    if (data[i] < data[start]){
		swap(data, i, k);
		i++;
		k++;
	    }
	    else if (data[i] == data[start]){
	        i++;
	    }
	    else{
		swap(data, i, j);
		j--;
	    }
	    for (int p = start; p <= end; p++){
		System.out.print(data[p]);
	    }
		System.out.print(" i" + i + " j"+j + " k"+k);
	    System.out.println("");
	}
	System.out.println("endpart");
	swap (data, j, start);
	for (int p = start; p <= end; p++){
	    System.out.print(data[p]);
	}
	return j;
    }
    public static void swap(int[] a, int b, int c){
        int buff = a[c];
	a[c] = a[b];
	a[b] = buff;
    }
	
	
    public static int quickselect (int[] data, int k){
	int pivot = 0, start = 0, end = data.length-1;
	while (pivot != k){
	    if (pivot > k){end = pivot-1;}
	    if (pivot < k){start = pivot+1;}
	    pivot = part(data, start, end);
	}
	return data[k];
    }
    public static void quickSort (int[] data){
	qsh(data, 0, data.length-1);
    }
    public static void qsh (int[] data, int start, int end){
	if (start < end){
	    int pivot = part(data, start, end);
	    int length = 0;
	    for (int i = pivot; i <= end; i++){
		if (data[i] == data[pivot]){length++;}
		else{break;}
	    }
	    System.out.println("pivot"+pivot);
	    qsh(data, start, pivot-1);
	    qsh(data, pivot+length, end);
	}
    }
    public static void main (String[] args){
	//test();
    }
    public static void test (){
	int lengtha = 1000;
	int range = 100;
	Random rn = new Random();
	int[] a = new int[lengtha];
	for (int i = 0; i < lengtha; i++){
	    a[i] = rn.nextInt(range);
	}
	for (int i = 0; i < lengtha; i++){
	    System.out.print(a[i]+" ");
	}
	quickSort(a);
	for (int i = 0; i < lengtha; i++){
	    System.out.print(a[i]+" ");
	}
    }
}
