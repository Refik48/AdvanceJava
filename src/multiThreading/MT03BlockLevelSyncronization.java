package multiThreading;

public class MT03BlockLevelSyncronization {
    public static void main(String[] args) throws InterruptedException {
        Parantez p1 = new Parantez();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    p1.parantezKoy();
                }
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    p1.parantezKoy();
                }
            }
        });
        long basla = System.currentTimeMillis();

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        long bitir = System.currentTimeMillis();
        System.out.println("Toplam Sure:" + (bitir-basla));
    }
}

/*
	  Uygulamalarda bazen tüm metotudun synchronized yapılması gerekmeyebilir.
	  Bu durumda, sadece ilgili kısımları synchronized yapıp diğer kısımların klasik multi-threading mantığı ile
	  calışmasına izin vermek performans acisindan onemli katkı saglayacaktır.

	  İstenilen kısımların synchronized yapılması için "synchronized block" kullanılır.
	  Bu durumda blok içerisindeki kısıma aynı anda birden fazla thread'in erişimine izin verilmez iken dışında kalan
	  kısımlara, aktif olan threadlar tarafından eş zamanlı erişim sağlabilir.
*/

class Parantez {
    public void parantezKoy() {
        // Block-Level Syncronization
        // Sadece parantez yazdırma kısmını eş zamanlı kullanıma kilitliyoruz.
        synchronized (this) {
            for (int i = 1; i <= 10; i++) {
                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }

        // Dolayısıyla bir thread yazdırma islemini yaparken diger threat bu kısmı yani gecikme kismini calistirabilir.
        // Bu da performans acisindan olumlu etki yapacaktır.
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}