package _21010310076_Onur_Sönmez_Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.text.Element;

class constructors_Id_Ad_Soyad {
	 long Id;
	  String Ad;
	  String Soyad;

	  public constructors_Id_Ad_Soyad(long Id, String Ad, String Soyad) {
		  this.Id=Id;
		  this.Ad=Ad;
		  this.Soyad=Soyad;
		
	  }
}


class MaxHeap {
	private static final int element = 0;
	private long[] Heap;
	private int size;
	private long maxsize;

	// Constructor to initialize an
	// empty max heap with given maximum
	// capacity
	public MaxHeap(long maxsize) {
		// This keyword refers to current instance itself
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new long[(int) this.maxsize];
	}

	// Method 1
	// Returning position of parent
	private int parent(int curent) {
		return (curent - 1) / 2;
	}

	// Method 2
	// Returning left children
	private int leftChild(int pos) {
		return (2 * pos) + 1;
	}

	// Method 3
	// Returning right children
	private int rightChild(int pos) {
		return (2 * pos) + 2;
	}

	// Method 4
	// Returning true of given node is leaf
	private boolean isLeaf(int pos) {
		if (pos > (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	// Method 5
	// Swapping nodes
	private void degistirme(int  fpos, int spos) {
		long tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	// Method 6
	// Recursive function to max heapify given subtree
	private void maxHeapify(int pos) {
		if (isLeaf(pos))
			return;

		if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
				degistirme(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			} else {
				degistirme(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}


	
	// max heap insert metodu  
	
	public void insert(long  element)
	{
		Heap[++size]=element;
		int curent= size;
		
		while(Heap[curent]>Heap[parent(curent)])
		{
			degistirme(curent, parent(curent));
			curent=parent(curent);
		}
	}
	
	public void silme(long  silmek_Ýstenen_Eleman)
	{
		Heap[--size]=silmek_Ýstenen_Eleman;
		int curent= size;
		
		while(Heap[curent]>Heap[parent(curent)])
		{
			degistirme(curent, parent(curent));
			curent=parent(curent);
		}
	}
	
	public void print() {
		 
		for (int i = 0; i < size / 2; i++) {
			
			
			System.out.print("Üst Düðüm : " + Math.abs(Heap[i]));

			if ( Math.abs(leftChild(i)) < size) // if the child is out of the bound
										// of the array
				System.out.print(" Sol Alt Düðüm: " + Math.abs(Heap[leftChild(i)]));
			if (Math.abs(rightChild(i)) < size) // if the right child index must not
										// be out of the index of the array
				System.out.print(" Sað Alt Düðüm: " + Math.abs(Heap[rightChild(i)]));

			System.out.println(); // for new line
		}
	}

	// Method 9
	// Remove an element from max heap
	public long extractMax() { // maksimum sayýyý diziden kaldýrmayý yapar
		long popped = Heap[0];
		Heap[0] = Heap[--size];
		maxHeapify(0);
		return popped;
		
	}
	
	
	
	
}

public class _21010310076_Onur_Sönmez_Main {

	public static void main(String[] args) throws IOException {
		 int ElemanSayýsý=0;
		 Scanner metin = new Scanner(System.in);
	
		
		  // hesap yapýsý  
		   MaxHeap maxHeap = new MaxHeap(5000);
		
		
         PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());

	        File file = new File("kayit_dosyasi.txt");
	
	        FileReader fileReader = new FileReader(file);
	        String line;

	        BufferedReader br = new BufferedReader(fileReader);
	      
	        for(ElemanSayýsý=0; ElemanSayýsý<2500;ElemanSayýsý++)  //ilk 2500 satýr okuma iþlemi
	           {
	        	
	        	line = br.readLine();
	        	String numara= (line.substring(0,10));
	        	String ad= line.substring(11,21);
	        	String soyad= line.substring(22,32);
	        	
	        	
	        	long  id= Long.parseLong(numara);  // numaralarý sayý tipine cevirdik 
	        	//System.out.println(id*0);
	        	
	 
	        	constructors_Id_Ad_Soyad nesne = new constructors_Id_Ad_Soyad(id, ad, soyad);
	        	// heap classýný tanýmlayýp eleman ekleme iþlemini yapalim
	        
	        	maxHeap.insert(nesne.Id);
	        	
	        }
	        

	        br.close();
	        
	     // Calling maxHeap() as defined above
			maxHeap.print();

			// Print and display the maximum value in heap
			System.out.println("EN BÜYÜK TC : " + maxHeap.extractMax());
			System.out.println("Kapasitesi 2500 olan veri yapýsý yaratýlmýþtýr.\r\n"
			+ "Insert() metodu kullanýlarak dosyadaki ilk 2500 kayýt veri yapýsýna eklenmiþtir. Yukarýdaki çýktý bu yapýyla ilgilidir.");
			do {
				System.out.println("Yapmak istediðiniz iþlemi Seçiniz :");
				System.out.println("1- Arama yapma için :Search(XXXXXXXXXX) yazýmýna uyunuz :");
				System.out.println("2- Kayit En_Buyuk_Kaydi_Cikar()");
				System.out.println("3- Kayit Delete(XXXXXXXXXX)  yazýmýna uyunuz :");
				System.out.println("4- Kayit Delete_pos(XX) yazýmýna uyunuz ->");
			    System.out.println("5- int Return_Kayit_Sayisi()      ->");
				System.out.println("6- int Return_Seviye_Sayisi()      ->");
				System.out.println("7- Ekrana_Yazdir(Kayit kayit)      ->");
				Scanner iþlem = new Scanner(System.in);
				int SeçilenÝþlem = iþlem.nextInt();
				
				switch (SeçilenÝþlem)
				   {
				   case 1:
				   System.out.println("ARAMA ÝÞLEMÝ SEÇÝLDÝ");
				   System.out.println("ARAMAK ÝSTEDÝÐÝNÝZ SAYIYI GÝRÝNÝZ! 10 KARAKTERDEN OLUÞMASINA DÝKKAT EDÝNÝZ !");
				   Scanner aramaYapýlcakEleman = new Scanner(System.in);
				   long AramaYapýlacakEleman = aramaYapýlcakEleman.nextInt();
				   AramaÝþlemi();				 
				   
				   break;
				   case 2:
				   System.out.println("2- Kayit En_Buyuk_Kaydi_Cikar() SEÇÝLDÝ");
				   System.out.println("EN BÜYÜK TC : " + maxHeap.extractMax()+"Deðeri silindi.");
				   break;
				   case 3:
				   System.out.println("3- Kayit Delete(XXXXXXXXXX) seçildi");
				   break;	   
				   case 4:
				   System.out.println("4- Kayit Delete_pos(XX) yazýmýna uyunuz ->");
				   Scanner pozisyonu_silinecek_eleman = new Scanner(System.in);
				   int PozisyonuSilinecekEleman = pozisyonu_silinecek_eleman.nextInt();
				   System.out.println("Pozisyonu Silinen Eleman :"+PozisyonuSilinecekEleman);
				   break;
				   case 5:
				   System.out.println("5- int Return_Kayit_Sayisi()      -> SEÇÝLDÝ");
				   System.out.println("Mevcut Kayýt Sayýsý : "+ElemanSayýsý);
				   
				   break;
				   case 6:
				   System.out.println("6- int Return_Seviye_Sayisi()      ->");
				   System.out.println("Seviye Sayýsý : "+ElemanSayýsý/2);
				   break;
				   case 7:
				   System.out.println("Ekrana_Yazdir(XXXXXXXXXX) yazýmýna uyunuz   ->");
				   Scanner BilgileriEkranaYazdýrma = new Scanner(System.in);
				   int ÝstenenKiþininBilgileri = BilgileriEkranaYazdýrma.nextInt();
				   System.out.println("Ýstenen kiþinin bilgileri ->");
				   
				   
				   
				   break;
				   default:
				   System.out.println("Yanlýþ deðer girildi !"); 
				   }
				  
				String silinmekistenensayýnýnStringhali = metin.nextLine();
	    long silinmekistenenSayý=silinmekistenensayýnýnStringhali.compareTo(silinmekistenensayýnýnStringhali);
			} while (true);
				
	   		
	}

	private static void AramaÝþlemi() {
		// TODO Auto-generated method stub
		
		
	}

	


	

}
