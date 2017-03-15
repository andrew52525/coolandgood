import java.util.Random;
public class Quick{
    public static int part (int[] data, int start, int end){
	Random rn = new Random();
	int pivot = rn.nextInt(data.length);
	int[] outp = new int[data.length];
	int numsbelow = 0, numsabove = 0;
	for (int i = start; i < end; i++){outp[i] = data[pivot];}
	for (int i = start; i <= end; i++){
	    if (data[i] < data[pivot]){
		outp[start+numsbelow] = data[i]; numsbelow++;}
	    if (data[i] > data[pivot]){
		outp[end-numsabove] = data[i]; numsabove++;}
	}
	for (int i = 0; i < data.length; i++){System.out.println("c"+data[i]);}
	return start+numsbelow+1;
    }
    public static int quickselect (int[] data, int k){
	int pivot = 0, start = 0, end = data.length-1;
	System.out.println(pivot+"vdvdv");
	while (pivot != k){
	    pivot = part(data, start, end);
	    if (pivot > k){end = pivot;}
	    if (pivot < k){start = pivot;}
	}
	return data[k];
    }
    public static void main (String[] args){
	int[] a = {1, 3, 2, 6, 7, 3, 666, 34, 12};
	System.out.println(part(a, 2, 5));
        System.out.println(quickselect(a, 5));
    }
}
