package multiThreading;

public class MT04ClassLevelSyncronization {

    // Thread'ler farklı nesneler kullanılırsa durum nasıl değişir?
    // Dolayısıyla metot seviyesi syncronization işe yaramayacaktır.
    // Çünkü her iki thread, farklı nesnelerin parantezKoy() metodunu calistirmaktadir.
    // Burada çözüm için class seviyesinde blocklama yapmaktır.
    // Çünkü her iki obje aynı class'dan türetilmektedir.

    public static void main(String[] args) {

        Parantez1 p1 = new Parantez1();
        Parantez1 p2 = new Parantez1();

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
                    p2.parantezKoy();
                }
            }
        });
        th1.start();
        th2.start();
    }
}

class Parantez1 {
    synchronized static public void parantezKoy() {
        for (int i = 1; i <= 10; i++) {
            if (i <= 5) {
                System.out.print("[");
            } else {
                System.out.print("]");
            }
        }
        System.out.println();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}