import java.lang;
import java.Array;

public class NizoviZadatak{
    public static void main(String [] arg){
        System.out.println("welcome to this tutorial");
        
        int [] array={12,23,-22,0,43,545,-4,-55,43,12,0,-99,-87};
        beforeZero(array);
    }

    static public void beforeZero(int [] array){
        int [] arrayaz = new int [countLengthPoz(array)];
        int [] arraybz = new int [countLengthNeg(array)];
        int j=0,k=0;
        for(int i=0;i<array.length;i++){
            if (array[i]<0){
                arraybz [j++] = array[i];
            }
            else if (array[i]>0){
                arrayaz[k++]=array[i];
            }
        }

        printArray(array);
        printArray(arraybz);
        printArray(arrayaz);
    
    }
    static public void printArray(int [] array){
        System.out.println("Clanovi niza: "+ array.length);
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+ " ");
        }

    }
    static public int countLengthPoz(int [] array){
            int count=0;
            for(int i =0;i<array.length;i++){
            if (array[i]>0){
                count++;
            }
        
        }
        return count;
    }   
    
    static public int countLengthNeg(int [] array){
            int count=0;
        for(int i = 0;i<array.length;i++){
            
            if (array[i]<0){
                count++;
            }
        
        }
        return count;
    }

}