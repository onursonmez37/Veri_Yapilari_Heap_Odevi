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
	
	public void silme(long  silmek_İstenen_Eleman)
	{
		Heap[--size]=silmek_İstenen_Eleman;
		int curent= size;
		
		while(Heap[curent]>Heap[parent(curent)])
		{
			degistirme(curent, parent(curent));
			curent=parent(curent);
		}
	}
	
	public void print() {
		 
		for (int i = 0; i < size / 2; i++) {
			
			
			System.out.print("Üst Düğüm : " + Math.abs(Heap[i]));

			if ( Math.abs(leftChild(i)) < size) // if the child is out of the bound
										// of the array
				System.out.print(" Sol Alt Düğüm: " + Math.abs(Heap[leftChild(i)]));
			if (Math.abs(rightChild(i)) < size) // if the right child index must not
										// be out of the index of the array
				System.out.print(" Sağ Alt Düğüm: " + Math.abs(Heap[rightChild(i)]));

			System.out.println(); // for new line
		}
	}

	// Method 9
	// Remove an element from max heap
	public long extractMax() { // maksimum sayıyı diziden kaldırmayı yapar
		long popped = Heap[0];
		Heap[0] = Heap[--size];
		maxHeapify(0);
		return popped;
		
	}
	
	
	
	
}

public class _21010310076_Onur_Sönmez_Main {

	public static void main(String[] args) throws IOException {
		 int ElemanSayısı=0;
		 Scanner metin = new Scanner(System.in);
	
		
		  // hesap yapısı  
		   MaxHeap maxHeap = new MaxHeap(5000);
		
		
         PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());

	        File file = new File("kayit_dosyasi.txt");
	
	        FileReader fileReader = new FileReader(file);
	        String line;

	        BufferedReader br = new BufferedReader(fileReader);
	      
	        for(ElemanSayısı=0; ElemanSayısı<2500;ElemanSayısı++)  //ilk 2500 satır okuma işlemi
	           {
	        	
	        	line = br.readLine();
	        	String numara= (line.substring(0,10));
	        	String ad= line.substring(11,21);
	        	String soyad= line.substring(22,32);
	        	
	        	
	        	long  id= Long.parseLong(numara);  // numaraları sayı tipine cevirdik 
	        	//System.out.println(id*0);
	        	
	 
	        	constructors_Id_Ad_Soyad nesne = new constructors_Id_Ad_Soyad(id, ad, soyad);
	        	// heap classını tanımlayıp eleman ekleme işlemini yapalim
	        
	        	maxHeap.insert(nesne.Id);
	        	
	        }
	        

	        br.close();
	        
	     // Calling maxHeap() as defined above
			maxHeap.print();

			// Print and display the maximum value in heap
			System.out.println("EN BÜYÜK TC : " + maxHeap.extractMax());
			System.out.println("Kapasitesi 2500 olan veri yapısı yaratılmıştır.\r\n"
			+ "Insert() metodu kullanılarak dosyadaki ilk 2500 kayıt veri yapısına eklenmiştir. Yukarıdaki çıktı bu yapıyla ilgilidir.");
			do {
				System.out.println("Yapmak istediğiniz işlemi Seçiniz :");
				System.out.println("1- Arama yapma için :Search(XXXXXXXXXX) yazımına uyunuz :");
				System.out.println("2- Kayit En_Buyuk_Kaydi_Cikar()");
				System.out.println("3- Kayit Delete(XXXXXXXXXX)  yazımına uyunuz :");
				System.out.println("4- Kayit Delete_pos(XX) yazımına uyunuz ->");
			    System.out.println("5- int Return_Kayit_Sayisi()      ->");
				System.out.println("6- int Return_Seviye_Sayisi()      ->");
				System.out.println("7- Ekrana_Yazdir(Kayit kayit)      ->");
				Scanner işlem = new Scanner(System.in);
				int Seçilenİşlem = işlem.nextInt();
				
				switch (Seçilenİşlem)
				   {
				   case 1:
				   System.out.println("ARAMA İŞLEMİ SEÇİLDİ");
				   System.out.println("ARAMAK İSTEDİĞİNİZ SAYIYI GİRİNİZ! 10 KARAKTERDEN OLUŞMASINA DİKKAT EDİNİZ !");
				   Scanner aramaYapılcakEleman = new Scanner(System.in);
				   long AramaYapılacakEleman = aramaYapılcakEleman.nextInt();
				   Aramaİşlemi();				 
				   
				   break;
				   case 2:
				   System.out.println("2- Kayit En_Buyuk_Kaydi_Cikar() SEÇİLDİ");
				   System.out.println("EN BÜYÜK TC : " + maxHeap.extractMax()+"Değeri silindi.");
				   break;
				   case 3:
				   System.out.println("3- Kayit Delete(XXXXXXXXXX) seçildi");
				   break;	   
				   case 4:
				   System.out.println("4- Kayit Delete_pos(XX) yazımına uyunuz ->");
				   Scanner pozisyonu_silinecek_eleman = new Scanner(System.in);
				   int PozisyonuSilinecekEleman = pozisyonu_silinecek_eleman.nextInt();
				   System.out.println("Pozisyonu Silinen Eleman :"+PozisyonuSilinecekEleman);
				   break;
				   case 5:
				   System.out.println("5- int Return_Kayit_Sayisi()      -> SEÇİLDİ");
				   System.out.println("Mevcut Kayıt Sayısı : "+ElemanSayısı);
				   
				   break;
				   case 6:
				   System.out.println("6- int Return_Seviye_Sayisi()      ->");
				   System.out.println("Seviye Sayısı : "+ElemanSayısı/2);
				   break;
				   case 7:
				   System.out.println("Ekrana_Yazdir(XXXXXXXXXX) yazımına uyunuz   ->");
				   Scanner BilgileriEkranaYazdırma = new Scanner(System.in);
				   int İstenenKişininBilgileri = BilgileriEkranaYazdırma.nextInt();
				   System.out.println("İstenen kişinin bilgileri ->");
				   
				   
				   
				   break;
				   default:
				   System.out.println("Yanlış değer girildi !"); 
				   }
				  
				String silinmekistenensayınınStringhali = metin.nextLine();
	    long silinmekistenenSayı=silinmekistenensayınınStringhali.compareTo(silinmekistenensayınınStringhali);
			} while (true);
				
	   		
	}

	private static void Aramaİşlemi() {
		// TODO Auto-generated method stub
		
		
	}

	


	

}
