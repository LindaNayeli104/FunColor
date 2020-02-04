import java.util.Hashtable;

public class Pruebas {

	static Hashtable<Integer, Integer> ht = new Hashtable<>();



	public static void res() {
		int score = ht.get(1);
		int aux = 0;
		int pos = 10;
		boolean bandera = false;
		for (int i = 1; i < 11; i++) {
			if(45 < score) {
				score = ht.get(i+1);
			}else {
				ht.put(i, 45);
				pos = i;
				bandera = true;
				break;
			}
		}
		if(bandera) {
			for (int j = pos+1 ; j < 11; j++) {
				aux = ht.get(j);
				ht.put(j, score);
				score = aux;
				
			}
		}

		for (int i = 1; i < 11; i++) {
			System.out.println(i + "=" + ht.get(i));
		}

	}

	
	public static void main(String[] args) {
		ht.put(1, 500);
		ht.put(2, 400);
		ht.put(3, 300);
		ht.put(4, 200);
		ht.put(5, 100);
		ht.put(6, 50);
		ht.put(7, 40);
		ht.put(8, 30);
		ht.put(9, 20);
		ht.put(10,10);
		res();
		
	}
}