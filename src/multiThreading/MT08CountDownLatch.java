package multiThreading;

/* ============================================= COUNTDOWNLATCH ========================================================
    Var olan Thread'lerin yönetilmesini saglayan bir yontemdir. Belirli sayıda Thread'in islem gordukten sonra
    diger Thread'lere gecilmesini saglayan bir yontemdir.

    Geri Sayım sayac mantığı ile çalışır.Sayaca yüklenen sayıdan başlar ve her bir Thread'in calimasi tamamlaninca
    sayac'ın degeri otomatik olarak bir azalır. Böylelikle sayac sifir degerine ulasana kadar  latch.await() komutu ile
    diğer Thread'lerin bekletilmesini sağlar. Eger sayac Sifira ulaşırsa yani istenilen sayida Thread islem görmüş
    ise o zaman yeni gelecek olan Thread'lerin calismasina izin verilir.

*/
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MT08CountDownLatch {
    public static void main(String[] args) {

        // Thread geri sayicisina 6 degerini yukledik. (Sayaca geri sayimi 6'dan başlayacak)
        CountDownLatch latch = new CountDownLatch(6);

        // 9 thread'lik bir havuz olusturduk.
        ExecutorService service = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 6; i++) {
            service.execute(new Thread(new ThreadOlustur1(latch)));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("6 adet threat calisti ve durdu");
        service.shutdown();

        Thread bekleyenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Bekleyen thread calisti....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Bekleyen thread durdu....");
            }
        });
        bekleyenThread.start();
    }
}

class ThreadOlustur1 extends Thread {
    private CountDownLatch latch;

    public ThreadOlustur1(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " calismaya basladi..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " durdu..");
        System.out.println("============================================");
        latch.countDown();
    }
}
