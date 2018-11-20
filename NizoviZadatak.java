import java.lang;
import java.Array;

package nizovi;

public class Sort {

	public static void main(String[] args) {
		int [] array={12,23,-22,0,43,545,-4,-55,43,12,0,-99,-87};
		rasporediClanoveNiza(array);// pozivamo metodu(funkciju koja raspodeljuje clanove na poz i negativne i stampa sva tri niza)
    }
	/*implementiramo metodu koja rasporedjuje
	clanove niza i poziva metode za ispisivanje koje su implementitane
	u daljem kodu*/
    static public void rasporediClanoveNiza(int [] array){
        /* ovde definisemo nasa nova dva niza koja moramo i da inicijalizujemo 
         * brojem elemenata kako bi odredili prostor u memoriji.Posto ne znamo koliko je jednih
         * a koliko drugih elemenata pozivamo metodu koju smo implementirali u  daljem kodu*/
    	int [] arrayaz = new int [countLengthPoz(array)];// niz u koji cemo smestiti pozitivne elemente
        int [] arraybz = new int [countLengthNeg(array)];// niz u koji cemo smestiti negativne elemente
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
    static public void printArray(int [] array){
        System.out.println("Clanovi niza kojih ukupno ima: "+ array.length);
        for (int i=0;i<array.length;i++){
            System.out.printf(array[i]+ " ");
        }
        System.out.println("");

    }
    /*metoda koja nam daje broj koliko elemanata u jednom nizu ima pozitivnu vrednost*/
    static public int countLengthPoz(int [] array){
            int count=0;
            for(int i =0;i<array.length;i++){
            if (array[i]>0){
                count++;
            }
        }
        return count;
    }   
    /*metoda koja nam daje broj koliko elemanata u jednom nizu ima negativnu vrednost*/
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
