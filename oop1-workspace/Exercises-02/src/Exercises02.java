import java.util.Arrays;

/**
 * 
 */

/**
 * @author hasan
 *
 */
public class Exercises02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// IsEqual ..
		double arr1[] = { 5.4, 6.3, 8.1, 9.0, 7.2 };
		double arr2[] = { 5.1, 6.2, 0.11, 9.0, 7.2 };
		IsEqual equal = new IsEqual();
		System.out.println(equal.isEqual(arr1, arr2));

		// Add Element on the end of Array..
		double list[] = { 2.1, 3.11, 9.3, 7.25 };
		AddList add = new AddList();
		System.out.println(add.addLast(list, 91.0));

		// Add Element at the begining of Array..
		AddFirst add1 = new AddFirst();
		System.out.println(add1.addFirst(list, 4.8));

		// Add Element at Position
		InsertAtPosition InsertAt = new InsertAtPosition();
		InsertAt.insert(list, 1.21, 1);
		

		// GetLast and GetFirst Methods..
		getFirstLast get = new getFirstLast();
		get.getlast(list);
		get.getFirst(list);

		//Remove from the Last and First..
		RemoveLastFirst remove = new RemoveLastFirst();
		remove.removeLast(list);
		remove.removeFirst(list);
		
		//Swapping 2 Elements..
		SwapElements swap = new SwapElements();
		swap.swap(list, 1, 3);
		
		//Sorting Array .. 
		double [] list1 = {8.1, 9.2, 1.3, 5.9, 0.5} ;
		BubleSortArray sort = new BubleSortArray();
		sort.bubleSort(list1);
		
		//length of Vector 
		double[] vector = {1.2,3.5,4.0};
		VerkorLength lengthV = new VerkorLength();
		lengthV.vectorLength(vector);
		
		//Shortest Vector ..
		double [][] vectors = { {12,9,4} , 
								{10,5,2} ,
								{15,8,3} };
		MinVektor min = new MinVektor();
		min.minVektor(vectors);
		
		//Add Vectors..
		double [] a = {2.2, 3.1, 5.1};
		double [] b = {7.8, 6.9, 4.9};
		AddVectors addVectors = new AddVectors();
		double [] sum = addVectors.addVectors(a, b); 
		for (int i = 0; i < b.length; i++) {
			System.out.print(sum[i] +  "  " );
		}
		
		//Append String .. 
		AppendString append = new AppendString();
		System.out.println("\n"+append.append("Hasan ", 'H'));
		
		//Chiffre String
		ChiffreClass chiffre = new ChiffreClass();
		System.out.println(chiffre.caesarChiffre("hasan"));
		
		//Remove Vocals
		RemoveClass removeVocals = new RemoveClass();
		System.out.println(removeVocals.removeVocls("Englisch lernen ist wichtig")); 
	}
// IsEqual ..
public static boolean isEqual(double[] arr1, double[] arr2) {

	if (arr1.length != arr2.length) {
		return false;

	} else {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
	}

	return true;
}
//Add Last ..
public static double [] addLast(double []list, double a) {
	int i;
	for(i = 0; i < list.length; i++) {
		
		System.out.print(list[i] + " ");
	}
	list = Arrays.copyOf(list, list.length+1);
	list[list.length - 1] = a;
	System.out.print(list[i]+ "  ");
	System.out.println(" ");
	return null;
}

//Add First ,, 

public static double [] addFirst(double [] list, double a){
	
	int i ;
	for (i = list.length-1; i > 0; i--) {
		list[i] = list[i-1];
		
		
	}
	list[0] = a;
	for( i=0; i  < list.length; i++) {
	System.out.print(list[i] + " ");
	}
	System.out.println(" ");
	return null;
}

// Insert ..

public static double[] insert(double[] list, double a, int position) {
	int i;
	for (i = list.length-1; i > position; i--) {
		list[i] = list[i-1];
		//System.out.print(list[i] + " ");
	}
	list[position] = a;
	
	for(i = 0 ; i < list.length; i++) {
		System.out.print(list[i] + " ");
	}
	System.out.println(" ");
	return null;
	
}

//getFist getLast .. 

public static double getlast(double[] list) {
	int i = 0;
	if (list[i] == list [list.length-1] ) {
		System.out.print("\n"+"The last Element is : "+ list[i]);
		System.out.println(" ");
	}else
	System.out.print( "\n"+"The last Element is : "+ list[list.length-1] + " ");

	return 0;

}

public static double getFirst(double[] list) {
	int i = 0;
	if (list[0] == list[i]) {
		System.out.println("\n"+"The First Element is : "+list[i]);
	}else 
		System.out.println("\n"+"The First Element is : "+"\n"+list[0]);

	return 0;

}

// Remove last..

public static double[] removeLast(double[] list) {
	int i = 0;
	System.out.println("The List without Remove ..");
	for (i = 0; i < list.length; i++) {
		System.out.print(list[i] + " ");
	}
	for (i = list.length - 1; i < list.length - 1; i++) {
		list[i] = list[i + 1];
	}
	System.out.println("\nRemove the Last Item ..");
	for (i = 0; i < list.length - 1; i++) {
		System.out.print(list[i] + " ");
	}
	return null;
}

public static double[] removeFirst(double[] list) {
	int i;
	System.out.println("\nRemove the First Item .. ");
	for (i = 0; i < list.length - 1; i++) {
		list[i] = list[i + 1];
	}
	for (i = 0; i < list.length - 1; i++) {
		System.out.print(list[i] + " ");
	}

	return null;

}

//Swap ..

public static double[] swap(double[] list, int position1, int position2) {
	System.out.println("   \nBefore Swapping ..  ");

	for (int i = 0; i < list.length ; i++) {
		System.out.print(list[i] + " ");
	}

	System.out.println("\nSwitch Positions..");
	double a = 0;
	a = list[position1];
	list[position1] = list[position2];
	list[position2] = a;
	
	for (int i = 0; i < list.length; i++) {
		System.out.print(list[i] + " ");
		}
	
	/*int temp = list.length ;
	list[position2] = list[position1];
	list[position1] = temp;

	for (int i = 0; i < list.length ; i++) {
		System.out.print(list[i] + " ");
	}*/
	return null;

}

// Bubble Sort ..

public static double[] bubleSort(double[] list1) {
	System.out.println("\nList After sorting...");
	double a = 0;
	int n = list1.length;
	for (int i = 1; i <= (n-1); i++) {
		for(int j = 0; j < (n-1); j++) {
			if (list1[j+1] < list1[j]) {
				a = list1[j];
				list1[j] = list1[j+1];
				list1[j+1] = a;
			}
		}
	}
	for(int i = 0; i < list1.length; i++) {
		System.out.print(list1[i] + " ");
	}
	return null;
}

//Vector Length ..
public static double vectorLength(double[] vector) {
	System.out.println("\nVector Element are :");
	
	for (int i = 0; i < vector.length; i++) {
		//vector[i] = Math.pow(vector[i], 2);
		System.out.print(vector[i] + " " );
		
	}
	System.out.println("\nThe Square Vektor Elemente : ");
	for (int i = 0; i < vector.length; i++) {
		vector[i] = Math.pow(vector[i], 2);
		System.out.print(vector[i] + " " );
		
	}
	
	double x = Arrays.stream(vector).sum();
	x = Math.sqrt(x);
	
	System.out.println("\nLength of Vector : " + x);
	return 0;	
}

// Min Vector

public static double[] minVektor(double[][] vectors) {
	double mul = 0;
	double x = 0;
	double y = 0;
	double z = 0;
	for (int i = 0; i < vectors.length; i++) {
		for (int j = 0; j < vectors.length; ++j) {
			System.out.print(vectors[i][j] + " ");
		}
		System.out.println();
	}
	System.out.println("\nThe Square of all Vectors..");

	for (int i = 0; i < vectors.length; i++) {
		for (int j = 0; j < vectors.length; j++) {
			mul = vectors[i][j] * vectors[i][j];
			System.out.print(mul + " ");
		}
		System.out.println();
	}
	for (int i = 0; i < vectors.length; i++) {
			x += vectors[i][0];
	}System.out.println(x + " ");
	
	for (int i = 0; i < vectors.length; i++) {
		y += vectors[i][1];
	}
	System.out.println(y + " ");
	for (int i = 0; i < vectors.length; i++) {
		z += vectors[i][2];
	}
	System.out.println(z + " ");
	
	
	double d = 0;
	d = Math.min(x, y);
	double minVektor = Math.min(d, z);
	
	System.out.println("The Minimum Vektor is : " + minVektor);

	return null;
}

//AddVector ..

public static double[] addVectors(double[] a, double [] b) {
	double sum [] = new double [a.length] ;	
for (int i = 0; i < a.length; i++) {
	 sum [i] = a[i] + b[i];
}
System.out.println("The Sum of the Vektors : ");
return sum;

}
//Append ..

public static String append(String s, char c) {
	
	 s += c;
	System.out.print("\n"+System.nanoTime());
	return s;	
}

//Caesar Chiffre ..

public static String caesarChiffre(String s, int n) {
	String res = "";
	if (n >= 0 && n <= 26) {
		char c = (char) n;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) > 'A' && s.charAt(i) < 'Z') {
				if ((s.charAt(i) + c) > 'Z') {
					res += (char) (s.charAt(i) + c - 26);
				} else {
					res += (char) (s.charAt(i) + c);
				}
			} else {
				if ((s.charAt(i) + c) > 'z') {
					res += (char) (s.charAt(i) + c - 26);
				} else {
					res += (char) (s.charAt(i) + c);
				}
			}
		}
	} else {
		res = "Zahl muss zwischen 0 und 26 liegen.";
	}
	return res;
}

//RemoveVocals .. 

public static String removeVocls(String s){
	
	String st1 = s.replaceAll("[AEIOaeio]", "");
	
	
	return st1;
}



}