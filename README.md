# Veri_Yapilari_Heap_Odevi
Bu ödevde metin belgesinde bulunan 500.000 kayıt içeren TcKimlikNo,Ad,Soyad şeklindeki verilerin istenilen şartlar altında Heap veri yapısı ile belirli işlemlere tabi tutulması amaçlanmaktadır. Burada istenilen şartlardan ilki öncelikle 250.000 kayıtın işleme tabi tutulması ardından diğer kalan 250.000 in heap yapısına eklenmesidir.
Bu ödevde kullanıcıya seçenekler sunularak belirli işlemleri yapmalarına olanak sağlanmaktadır. 
Main çalıştıktan sonra tüm kullanıcıların üst düğümü, sol ve sağ alt düğümlerini yazdırması istenilmektedir.
![örnek çıktı](https://github.com/onursonmez37/Veri_Yapilari_Heap_Odevi/blob/main/heap%20%C3%B6devi.png)
Ödevde istenilen işlemler ve fonksiyon yazımları aşağıdaki kurallara göre ayarlanmalıdır. Bunların hangi işlemleri yapmaları gerektiklerini açıklayalım.
## 1- Arama yapma için :Search(XXXXXXXXXX) yazımına uyunuz :
	Arama yapma: İstenilen elemanın heap yapısında olup olmadığını bize geri döndüren yapıdır. Eğer yapıda yoksa bize bildirmesi gerekmektedir.
## 2- Kayit En_Buyuk_Kaydi_Cikar() :
	En büyük kaydı çıkar : En büyük kaydın çıkarılmasından sonra heap yapısının tekrardan maxHeapify ile düzene oturtulması gerekmektedir.
## 3- Kayit Delete(XXXXXXXXXX)  yazımına uyunuz :
	Kayıt silme : Silinen kayıt sonrasında tekrardan maxHeapify fonksiyonu ile heap özelliği sağlanmalıdır.
## 4- Kayit Delete_pos(XX) yazımına uyunuz ->
	Kayit Delete_pos(XX) : İstenilen pozisyondaki kayıt silinmeli ve yeniden maxHeapify özelliği korunulmalıdır.
## 5- int Return_Kayit_Sayisi() :     
Heap yapısındaki kayıt sayısını geri döndürmesi gerekmektedir.
## 6- int Return_Seviye_Sayisi() :    
Heap yapısının yüksekliğini geri döndürmesi gerekmektedir.
## 7- Ekrana_Yazdir(Kayit kayit) :
İstenilen kayıt bilgilerini ekrana yazdırma işlemini gerekmektedir.
