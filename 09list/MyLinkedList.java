public class MyLinkedList{

    //node class
    public class LNode{
	public LNode next;
	public int value;
	public LNode(){next = null; value = 0;}
    }

    //inst vars
    public LNode start;
    public int size;

    //adds
    public boolean add(int n){
	size++;
	if (start == null){start = new LNode(); start.value = n;return true;}
	LNode current = start;
	while (current.next!= null){current = current.next;}
	current.next = new LNode();
	current.next.value = n; return true;
    }
    public void add(int n, int v){
	LNode woo = new LNode(); woo.value = v;
	if (n==0){
	    LNode buffer = start;
	    start = woo;
	    start.next = buffer;
	}
	else{
	    LNode current = start; int i = 1;
	    while (i < n){current = current.next;i++;}
	    LNode buffer = current.next;
	    current.next = woo;
	    woo.next = buffer;
	}
    }
    
    //stuff
    public int indexOf(int v){
	int i = 0;
	LNode current = start;
	while (current.next != null){
	    if (current.value == v){return i;}
	    i++; current = current.next;
	}
	return -1;
    }
    public int remove(int n){
	if (n == 0){
	    int r = start.value;
	    start = start.next;
	    return r;
	}
	LNode current = start; int i = 1;
	while (i < n){current = current.next; i++;}
	int r = current.next.value;
	LNode c = current.next.next;
	current.next = c; return r;
    }

    //getterssetters
    public int size(){return size;}
    public String toString(){
	if (start == null){return "[]";}
	String ret = "";
	ret += "[";
	LNode current = start;
	while (current.next != null){
	    ret += current.value;
	    ret += ",";
	    current = current.next;
	}
	ret+= current.value;
	ret+= "]";
	return ret;
    }
    public int get(int n){
	LNode current = start;
	int i = 0;
	while (i < n){
	    current = current.next;
	    i++;
	}
	return current.value;
    }
    public int set(int n, int v){
	LNode current = start;int i = 0; 
	while (i < n){current = current.next; i++;}
	int b = current.value; current.value = v; return b;
    }

    public static void main (String[] args){
	MyLinkedList d = new MyLinkedList();
	d.add(4);
	d.add(6);
	for (int i = 0; i < 10; i++){d.add(i);}
	System.out.println(d.get(1));
	d.add(12, 100);
	d.remove(6);
	System.out.println(d);
    }
}

