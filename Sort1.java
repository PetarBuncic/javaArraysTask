import java.util.Scanner;
import java.util.HashMap;
import java.lang.*;

public class Sort1 {

	public static void main(String[] args) {
        int [] array={12,23,-22,0,43,545,-4,-55,43,12,0,43,-99,-87,12,12,4,-4,0,55};
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
                   /* if(i>0 && new_array[i]==new_array[i-1]){
                        new_array[i-1]=0;
                        new_array[i]=array[i];
                    }*/
                    times[i]++;
                    map.put(new_array[i],times[i]);
		        }
		    }
        }
      /*  //leve only members that show more than onse
        for (int j = 0; j < new_array.length; j++) {
		    for (int i = j; i < new_array.length; i++) {
		        if (new_array[j] == new_array[i] && j != i) {
                   new_array[j]=0;
		        }
		    }
		}*/
		//Printing output
		for (int i = 0; i <  new_array.length; i++) {
        
            System.out.println("\t" + array[i] + "\t" +  new_array[i] + "\t" + times[i]);
           
        }

	}

}