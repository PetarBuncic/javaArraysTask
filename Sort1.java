import java.util.Scanner;
import java.util.HashMap;
import java.lang.*;

public class Sort1 {

	
	
	
	public static void main(String[] args) {
        int [] array={12,23,-22,0,43,545,-4,-55,43,12,0,43,-99,-87,12,12,4,-4,0,55,55};
        HashMap <Integer,Integer> map= new HashMap();
		
        int size= array.length;       
		int[] new_array= new int[size];
        int[] times = new int[size];
        
        for(int i=0;i<times.length;i++){
            times[i]=1;
        }

		// Search for repeated elements
		for (int j = 0; j < array.length; j++) {
		    for (int i = j; i < array.length; i++) {
		        if (array[j] == array[i] && j != i) {
                    new_array[i]=array[i];
                    times[i]++;
                    map.put(new_array[i],times[i]);
		        }
		    }
        }
        
		//Printing output
		for (int i = 0; i <  new_array.length; i++) {
        
            System.out.println("\t Original: " + array[i] + "\t Repeted: " +  new_array[i] + "\t This is: " + times[i] + "\t repeted.");
           
        }
        System.out.println(map);
     
      

	}

}
