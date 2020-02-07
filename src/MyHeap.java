
public class MyHeap {

	MyNodoHeap[] heap;
	private int size;

	public MyHeap() {
		this.heap = new MyNodoHeap[11];
		this.size = 0;
	}

	public MyHeap(MyNodoHeap[] datos) {  
		//hacer heapify
		this.heap=datos;
		this.size = datos.length;   //suponemos que siempre nos pasan el arreglo lleno
		heapify(heap);

	}

	private void heapify(MyNodoHeap[] datos) {                                 // padre: (pos-1)/2       hijo:  2 * pos + (left ? 1: 2)
		//poner el arreglo con las condiciones de heap
		int current = this.size / 2 - 1;
		int left;
		int right;
		while(current >= 0) {
			left = 2 * current + 1;
			right = 2 * current + 2;
			if(left < this.size && right < this.size) {
				if(heap[current].score < (heap[left].score) || heap[current].score< (heap[right].score)) {
					if(heap[left].score > (heap[right].score) ) {
						swap(left, current);
						fixBelow(left);
					}
					else{
						swap(right, current);
						fixBelow(right);	
					}
				}
			}
			else if(left < this.size && right >= this.size) {
				if(heap[current].score < (heap[left].score)) {
					swap(left, current);
					fixBelow(left);
				}
			}
			current--;
		}

	}

	private void fixBelow(int current) {
		int left;
		int right;
		boolean bandera = true;
		while(heap[current] != null && bandera != false) {
			bandera = false;
			left = 2 * current + 1;
			right = 2 * current + 2;

			if(left < this.size && right < this.size) {
				if(heap[current].score < (heap[left].score) || heap[current].score < (heap[right].score)) {
					if(heap[left].score > (heap[right].score)) {
						swap(left, current);
						current = left;
						bandera = true;
					}
					else{
						swap(right, current);
						current = right ;
						bandera = true;
					}
				}
			}
			else if(left < this.size && right >= this.size) {
				if(heap[current].score < (heap[left].score)) {
					swap(left, current);
					current = left;
					bandera = true;
				}
			}
		}
		return;
	}       

	private void fixAbow(int current) {
		int parent;
		boolean bandera = true;
		while(current > 0 && bandera != false) {
			bandera = false;
			parent = (current-1)/2 ;

			if(heap[parent].score <(heap[current].score)) {
				swap(parent, current);
				bandera = true;
			}
			current = parent;
		}
		return;
	} 

	public void push(MyNodoHeap nodo) {
		if(this.size == 10) {
			this.heap[10] = nodo;
			fixAbow(10);
		}else {
			this.heap[this.size] = nodo;
			fixAbow(size);
			this.size++;
		}
		
	}

	private void swap(int pos1, int pos2) {
		MyNodoHeap aux = this.heap[pos1];
		this.heap[pos1] = this.heap[pos2];
		this.heap[pos2] = aux;
	}

	public MyNodoHeap pop() {
		if(this.size > 0) {
			MyNodoHeap res = this.heap[0];
			this.heap[0] = heap[this.size-1];   
			heap[this.size-1] = res;
			this.size--;
			fixBelow(0);
			return res;
		}
		return null;
		
		
	}

	public static void main(String[] args) {
		
		MyNodoHeap[] datos = new MyNodoHeap[7];
		for (int i = 0; i < 7; i++) {
			datos[i] = new MyNodoHeap(i+1, "LINDA" + i);
		}
		MyHeap heap_1 = new MyHeap(datos);
		for (int i = 0; i < heap_1.size; i++) {
			System.out.println(heap_1.heap[i].getScore());
		}
	

	}
}


class MyNodoHeap <E extends Comparable<E>>{//<E extends Comparable<E>>

	public String name;
	public int score;

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public MyNodoHeap(Integer score, String name) {    // Nodo hoja
		this.name = name;
		this.score = score;
	}

	public String toString() {
		return "score: " + Integer.toString(score) + " name: " + name;
	}
	
}


