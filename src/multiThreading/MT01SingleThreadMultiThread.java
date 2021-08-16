package multiThreading;

/* ============================================ THREAD, PROCESS=========================================================
    Thread : Kelime manası iplik olmasına karşın IT alanında iş parçacığı olarak adlandırılır.
    Thread, Process olarak adlandırılan ve her bir çalışan programın alt iş parçaçığı olarak düşünülebilir.
    Single Thread: Tek iş parcacığı vardır. Ve tüm işler sıra ile yapılır.
    Multi-Thread: Bir den fazla iş parçacığı vardır ve bu işler aynı anda yapılabilir (farklı işlemciler yardımıyla)

    Javada 2 yöntem ile Thread oluşturmak mümkündür.
    ----------------------------------------------
    1- Thread classından bir class extends (türeterek)
    2- Runnable Interface'inden implements ederek.


    Thread class'ının yaygın kullanılan metotlari:
    -----------------------------------------------
    public void run(): Bir threat'in calistiracagi islemleri tanımlamak amacıyla kullanlır.
    public void start(): Bir thread'in baslatilmasini saglar.JVM, thread'in run() methodunu calisitirir.
    public void sleep(long miliseconds): Bir thread'in belirtilen sure (ms) boyunca bekletilmesini saglar.
    public void join(): Bir thread olmesini (bitmesi) beklemek icin kullanilir.
    public int getPriority(): Bir thread'in önceligini dondurur.
    public int setPriority(int priority): Bir thread icin oncelik ayarlamaya yarar.
    public String getName(): Bir thread'in adini dondurur.
    public void setName(String name): Bir thread'e isim vermeye yarar.
    public Thread currentThread(): Su an calisan thread'in referansını dondurur.
    public int getId(): Bir thread'in id numarasını dondurur.
    public Thread.State getState(): Bir thread'in state (durum)'ini dondurur.
    public boolean isAlive(): Bir thread'in canlı (alive) olup olmadığını soyler.
    public void yield(): Aktif olan bir thread'in gecici olarak durdurulmasini ve baska thread'lerin calistirilmasini saglar.
    public boolean isDaemon(): Bir thread'in Deamon threat lup olmadıgını test eder.
    public void setDaemon(boolean b): Bir thread'i deoman thread olarak işaretler.
    public void interrupt(): Thread kesiintiye ugratır.
    public boolean isInterrupted(): Bir thread'in kesilip kesilmediğni test eder.
 */
public class MT01SingleThreadMultiThread{

    public static void main(String[] args) throws InterruptedException {
        long baslaSingleTh = System.currentTimeMillis();
        System.out.println("==================== SINGLE-THREAD ===============");
        SayacSingleThread s1 = new SayacSingleThread(1);
        s1.sayac();
        SayacSingleThread s2 = new SayacSingleThread(2);
        s2.sayac();
        long bitirSingleTh = System.currentTimeMillis();
        System.out.println("Single Thread Gecen Sure = " + (bitirSingleTh - baslaSingleTh));

        System.out.println("==================== MULTI-THREAD ===============");

        long baslaMultiTh = System.currentTimeMillis();
        SayacMultiThread s3 = new SayacMultiThread(3);
        s3.start();
        SayacMultiThread s4 = new SayacMultiThread(4);
        s4.start();

        // Bir threading bitmesini beklemek için Join metodu kullanılabilir.

        s4.join();  // s4 thread'i bittikten sonra geri kalan komutlari çalıştır.

        long bitirMultiTh = System.currentTimeMillis();
        System.out.println("Multi Thread Gecen Sure = " + (bitirMultiTh - baslaMultiTh));
    }
}

class SayacSingleThread{
    private int threadNo;

    public SayacSingleThread(int threadNo) {
        this.threadNo = threadNo;
    }

    public void sayac(){
        for(int i=1;i<=10;i++){
            System.out.println("i:" + i + "Thread No:" + threadNo);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class SayacMultiThread extends  Thread{
    private int threadNo;
    public SayacMultiThread(int threadNo) {
        this.threadNo = threadNo;
    }
    public void sayac(){
        for(int i=1;i<=10;i++){
            System.out.println("i:" + i + "Thread No:" + threadNo);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        sayac();
    }


}