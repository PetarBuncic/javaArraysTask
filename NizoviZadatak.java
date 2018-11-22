import java.lang;
import java.Array;
import java.util.HashMap;


public class NizoviZadatak{
    public static void main(String[] args) {
        int [] array={12,23,-22,0,43,545,-4,-55,43,12,0,-99,-87};
        
        rasporediClanoveNiza(array);// pozivamo metodu(funkciju koja raspodeljuje clanove na poz i negativne i stampa sva tri niza)
        findDuplicates(array); //metoda za pronalazenje duplikata i stampanje koliko se puta pojavljuju
       
       
    }
	/*implementiramo metodu koja rasporedjuje
	clanove niza i poziva metode za ispisivanje koje su implementitane
	u daljem kodu*/
    public static  void rasporediClanoveNiza(int [] array){
        /* ovde definisemo nasa nova dva niza koja moramo i da inicijalizujemo 
         * brojem elemenata kako bi odredili prostor u memoriji.Posto ne znamo koliko je jednih
         * a koliko drugih elemenata pozivamo metodu koju smo implementirali u  daljem kodu*/
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

    /*implementacija metode za ispisisvanje niza na conzolu, prosledimo joj neki niz kao
     * argument i ona ga stampa*/
    public static   void printArray(int [] array){
        System.out.println("Clanovi niza kojih ukupno ima: "+ array.length);
        for (int i=0;i<array.length;i++){
            System.out.printf(array[i]+ " ");
        }
        System.out.println("");

    }

    /*metoda koja nam daje broj koliko elemanata u jednom nizu ima pozitivnu vrednost*/
    public static  int countLengthPoz(int [] array){
            int count=0;
            for(int i =0;i<array.length;i++){
            if (array[i]>0){
                count++;
            }
        }
        return count;
    }   
    /*metoda koja nam daje broj koliko elemanata u jednom nizu ima negativnu vrednost*/
    public static int countLengthNeg(int [] array){
        int count=0;
        for(int i = 0;i<array.length;i++){
            if (array[i]<0){
                count++;
            }
        }
        return count;
    }
    /*/metoda koja pronalazi duplikate i stampa ih preko hashMap 
    videti HashMap class ima po par elemenata u nasem slucaju upisuje clan niza koji se ponavlja i koliko puta */
    public static void findDuplicates(int [] array) {
        HashMap <Integer,Integer> map= new HashMap();
        int size= array.length;       
		int[] new_array= new int[size];
        int[] times = new int[size];
        for(int i=0;i<times.length;i++){
            times[i]=1;
        }
		for (int j = 0; j < array.length; j++) {
		    for (int i = j; i < array.length; i++) {
		        if (array[j] == array[i] && j != i) {
                        new_array[i]=array[i];
                        times[i]++;
                        map.put(new_array[i],times[i]);
		        }
		    }
        }
        System.out.println(map);
    }
}
