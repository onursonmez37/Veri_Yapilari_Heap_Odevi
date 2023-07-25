package _21010310076_Onur_S�nmez_Main;

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
	
	public void silme(long  silmek_�stenen_Eleman)
	{
		Heap[--size]=silmek_�stenen_Eleman;
		int curent= size;
		
		while(Heap[curent]>Heap[parent(curent)])
		{
			degistirme(curent, parent(curent));
			curent=parent(curent);
		}
	}
	
	public void print() {
		 
		for (int i = 0; i < size / 2; i++) {
			
			
			System.out.print("�st D���m : " + Math.abs(Heap[i]));

			if ( Math.abs(leftChild(i)) < size) // if the child is out of the bound
										// of the array
				System.out.print(" Sol Alt D���m: " + Math.abs(Heap[leftChild(i)]));
			if (Math.abs(rightChild(i)) < size) // if the right child index must not
										// be out of the index of the array
				System.out.print(" Sa� Alt D���m: " + Math.abs(Heap[rightChild(i)]));

			System.out.println(); // for new line
		}
	}

	// Method 9
	// Remove an element from max heap
	public long extractMax() { // maksimum say�y� diziden kald�rmay� yapar
		long popped = Heap[0];
		Heap[0] = Heap[--size];
		maxHeapify(0);
		return popped;
		
	}
	
	
	
	
}

public class _21010310076_Onur_S�nmez_Main {

	public static void main(String[] args) throws IOException {
		 int ElemanSay�s�=0;
		 Scanner metin = new Scanner(System.in);
	
		
		  // hesap yap�s�  
		   MaxHeap maxHeap = new MaxHeap(5000);
		
		
         PriorityQueue<Long> heap = new PriorityQueue<>(Collections.reverseOrder());

	        File file = new File("kayit_dosyasi.txt");
	
	        FileReader fileReader = new FileReader(file);
	        String line;

	        BufferedReader br = new BufferedReader(fileReader);
	      
	        for(ElemanSay�s�=0; ElemanSay�s�<2500;ElemanSay�s�++)  //ilk 2500 sat�r okuma i�lemi
	           {
	        	
	        	line = br.readLine();
	        	String numara= (line.substring(0,10));
	        	String ad= line.substring(11,21);
	        	String soyad= line.substring(22,32);
	        	
	        	
	        	long  id= Long.parseLong(numara);  // numaralar� say� tipine cevirdik 
	        	//System.out.println(id*0);
	        	
	 
	        	constructors_Id_Ad_Soyad nesne = new constructors_Id_Ad_Soyad(id, ad, soyad);
	        	// heap class�n� tan�mlay�p eleman ekleme i�lemini yapalim
	        
	        	maxHeap.insert(nesne.Id);
	        	
	        }
	        

	        br.close();
	        
	     // Calling maxHeap() as defined above
			maxHeap.print();

			// Print and display the maximum value in heap
			System.out.println("EN B�Y�K TC : " + maxHeap.extractMax());
			System.out.println("Kapasitesi 2500 olan veri yap�s� yarat�lm��t�r.\r\n"
			+ "Insert() metodu kullan�larak dosyadaki ilk 2500 kay�t veri yap�s�na eklenmi�tir. Yukar�daki ��kt� bu yap�yla ilgilidir.");
			do {
				System.out.println("Yapmak istedi�iniz i�lemi Se�iniz :");
				System.out.println("1- Arama yapma i�in :Search(XXXXXXXXXX) yaz�m�na uyunuz :");
				System.out.println("2- Kayit En_Buyuk_Kaydi_Cikar()");
				System.out.println("3- Kayit Delete(XXXXXXXXXX)  yaz�m�na uyunuz :");
				System.out.println("4- Kayit Delete_pos(XX) yaz�m�na uyunuz ->");
			    System.out.println("5- int Return_Kayit_Sayisi()      ->");
				System.out.println("6- int Return_Seviye_Sayisi()      ->");
				System.out.println("7- Ekrana_Yazdir(Kayit kayit)      ->");
				Scanner i�lem = new Scanner(System.in);
				int Se�ilen��lem = i�lem.nextInt();
				
				switch (Se�ilen��lem)
				   {
				   case 1:
				   System.out.println("ARAMA ��LEM� SE��LD�");
				   System.out.println("ARAMAK �STED���N�Z SAYIYI G�R�N�Z! 10 KARAKTERDEN OLU�MASINA D�KKAT ED�N�Z !");
				   Scanner aramaYap�lcakEleman = new Scanner(System.in);
				   long AramaYap�lacakEleman = aramaYap�lcakEleman.nextInt();
				   Arama��lemi();				 
				   
				   break;
				   case 2:
				   System.out.println("2- Kayit En_Buyuk_Kaydi_Cikar() SE��LD�");
				   System.out.println("EN B�Y�K TC : " + maxHeap.extractMax()+"De�eri silindi.");
				   break;
				   case 3:
				   System.out.println("3- Kayit Delete(XXXXXXXXXX) se�ildi");
				   break;	   
				   case 4:
				   System.out.println("4- Kayit Delete_pos(XX) yaz�m�na uyunuz ->");
				   Scanner pozisyonu_silinecek_eleman = new Scanner(System.in);
				   int PozisyonuSilinecekEleman = pozisyonu_silinecek_eleman.nextInt();
				   System.out.println("Pozisyonu Silinen Eleman :"+PozisyonuSilinecekEleman);
				   break;
				   case 5:
				   System.out.println("5- int Return_Kayit_Sayisi()      -> SE��LD�");
				   System.out.println("Mevcut Kay�t Say�s� : "+ElemanSay�s�);
				   
				   break;
				   case 6:
				   System.out.println("6- int Return_Seviye_Sayisi()      ->");
				   System.out.println("Seviye Say�s� : "+ElemanSay�s�/2);
				   break;
				   case 7:
				   System.out.println("Ekrana_Yazdir(XXXXXXXXXX) yaz�m�na uyunuz   ->");
				   Scanner BilgileriEkranaYazd�rma = new Scanner(System.in);
				   int �stenenKi�ininBilgileri = BilgileriEkranaYazd�rma.nextInt();
				   System.out.println("�stenen ki�inin bilgileri ->");
				   
				   
				   
				   break;
				   default:
				   System.out.println("Yanl�� de�er girildi !"); 
				   }
				  
				String silinmekistenensay�n�nStringhali = metin.nextLine();
	    long silinmekistenenSay�=silinmekistenensay�n�nStringhali.compareTo(silinmekistenensay�n�nStringhali);
			} while (true);
				
	   		
	}

	private static void Arama��lemi() {
		// TODO Auto-generated method stub
		
		
	}

	


	

}
