import java.util.Scanner;

public class SortingArrays {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size: ");
		
		int size = input.nextInt();
		int[] crr_array = new int[size];
		int[] new_array= new int[size];
		int[] times = new int[size];

		// Read integers from the console
		System.out.println("Enter array elements: ");
		for (int i = 0; i < crr_array.length; i++) {
		    crr_array[i] = input.nextInt();
		    times[i] = 1;
		}

		// Search for repeated elements
		for (int j = 0; j < crr_array.length; j++) {
		    for (int i = j; i < crr_array.length; i++) {
		        if (crr_array[j] == crr_array[i] && j != i) {
		            new_array[i] = crr_array[i];
		            times[i]++;
		        }
		    }
		}
		//Printing output but still printing every memeber of an array, i'll try to find out to print only element that reapet 
		// and how time are repeated
		for (int i = 0; i <  new_array.length; i++) {
		    System.out.println("\t" + crr_array[i] + "\t" +  new_array[i] + "\t" + times[i]);

		}

	}

}
