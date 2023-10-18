package nizovi;


public class NizoviZadatak{
    public static void main(String[] args) {
        int [] array={12,23,-22,43,0,545,-4,-55,43,12,-99,-87,0,12,-55,43};
        
        rasporediClanoveNiza(array);// pozivamo metodu(funkciju koja raspodeljuje clanove na poz i negativne i stampa sva tri niza)
        findDuplicates(array); //metoda za pronalazenje duplikata, stampanja koji su to clanovi i stampanje koliko se puta pojavljuju
       
       
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
        System.out.print("Clanovi niza kojih ukupno ima: ");
        printArray(array);
        System.out.print("Negativnih clanova ima : ");
        printArray(arraybz);
        System.out.print("Pozitivnih clanova ima : ");
        printArray(arrayaz);
       
    }
    /*implementacija metode za ispisisvanje niza na conzolu, prosledimo joj neki niz kao
     * argument i ona ga stampa*/
    public static   void printArray(int [] array){
        System.out.print(array.length);
        System.out.print(" { ");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]);
            if(i<array.length-1) System.out.print(", ");
        }
        System.out.println(" }");

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
    /*/metoda koja pronalazi duplikate i broj nula (0) koje se pojavljuju
    postoje dva pomocna niza new_array i times, u prvi ipisujemo brojeve koji se ponavljaju na onim pozicijama kao i u osnovnom zadatom nizu
    i povecavamo vrednost clana times niza za 1 na tom mestu, pravimo dakle par gde na istim mestima imamo clana koji se ponavlja i broj ponavljanja  */
    public static void findDuplicates(int [] array) {
	 	int size= array.length;
	 	int brojnulaunizu=0;
		int[] new_array= new int[size];
        int[] times = new int[size];
        //u pomocnom nizu koji cuva broj ponavljanja elemenata sve elemente inicijalizujemo na 1 (svaki el. naseg niza se pojavljuje jednom)
        for(int i=0;i<times.length;i++){
            times[i]=1;
        }
        /* // Pretrazujemo koji clan se ponavlja i kreiramo pomocni niz(new_array)u koji ubacijemo brojeve 
         * koji se ponavljaju i uvecavamao boj ponavljanja clan niza na isoj poziciji  times[i]++ ostali clanovi niza po defoultu 
         * ostaju da imaju vrednost nula*/
		for (int j = 0; j < array.length; j++) {
		    for (int i = j; i < array.length; i++) {
		        if (array[j] == array[i] && j != i) {
                        new_array[i]=array[i];
                        times[i]++;
                      
		        }
		    }
        }
		/*u novom pomonom nizu uporedjujemo ubacene clanove i ako neki prethodni clan vec postoji setujemo ga na tom prethodnom 
		 * mestu na 0 jer i broj ponavljanja u nizu times je manji za jedan nego na trenutnoj poziciji, ovo radimo radi preglednije stampe
		 * bez ove for petlje stmpalo bi svako  pojavljivajne nekog broja vise od 2 puta sve do konacnog broja pojavljivanja, 
		 * iskomentarisati ovu petlju pa videti i videti sta se desava */
		for (int j = 0; j < new_array.length; j++) {
		    for (int i = j; i < new_array.length; i++) {
		        if (new_array[j] == new_array[i] && j != i) {
                   new_array[j]=0;
		        }
		       
		    }
		}
		/*zbog specifinosti koriscenja 0 u prethodnih petljama kao reper za pronalazenje duplih clanova
		  * broj nula u nizu prebrojavamo brojacem prolaskom kroz originalni niz, moze se implementirati i posebna funkcija koja bi 
		  * brojala samo nule */
		for (int i = 0; i < array.length; i++) {
			if(array[i]==0) brojnulaunizu++;
		}
		// stampamo samo brojeve koji se ponavljaju sa 0 ili bez ukoliko je brojnulaunizu veci od 1
		System.out.print("Clanovi niza koji se ponavljaju su : { ");
		for (int i = 0; i <  new_array.length; i++) {
            		if((new_array[i] != 0) ){
            			System.out.print( new_array[i] + ", ");
            		}
		}
		if(brojnulaunizu>1) System.out.println("0 }");
		else System.out.println(" }");
		 
		/* u ovom delu koda funkcije za pronalazenje duplikata ispisujemo sve one clanove naseg pomocnog niza new_array koji su 
		 * razliciti od nule i broj ponavljanja veci od jedan pa bilo da su to negativni ili pozitivni brojevi */
		
		for (int i = 0; i <  new_array.length; i++) {
			/*razdvojen uslov u prvom trazimo manje od nule koji se pjavljuju vise od 1 put*/
            		if(new_array[i] < 0 && times[i]>1 ){
           		 	System.out.println("Broj:"  + "\t" +  new_array[i] + " se pojavljuje " + times[i]+ " puta");
            		}
			/*ili veci od nule koji se pojavljuju vise od 1 put*/
           		 else if (new_array[i] > 0 && times[i]>1 ){
                		System.out.println("Broj:"  + "\t" +  new_array[i] + " se pojavljuje " + times[i]+ " puta");
            		}
          
		}
		 
		/*stampamo broj nula u nizu*/
		if(brojnulaunizu>1)// ovaj red stampamo samo ako ima vise od jedne 0(nule)
		System.out.println("Broj:"  + "\t " +  0  + " se pojavljuje " + brojnulaunizu+ " puta");	
    }
}
