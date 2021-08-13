package generics;

//Generic class tanımlamasi

import jdk.swing.interop.SwingInterOpUtils;

public class G04GenericSinif <T> {  //T: Type
    private T veri;


    //Default constructor
    public G04GenericSinif() {

    }

    //Parametreli constructor
    public G04GenericSinif(T veri) {
        this.veri = veri;
    }

    public T getVeri() {
        return veri;
    }

    public void setVeri(T veri) {
        this.veri = veri;
    }

    public static void main(String[] args) {
        G04GenericSinif<Integer> intVeri = new G04GenericSinif<>(10);
        System.out.println("Integer ile test" + intVeri.getVeri());

         G04GenericSinif<Double>  doubleVeri = new G04GenericSinif<Double>();
         doubleVeri.setVeri(5.5);
        System.out.println("Double ile test" + doubleVeri.getVeri());

        G04GenericSinif<String> stringeVeri = new G04GenericSinif<>("Merhaba Generics");

        System.out.println("String ile test:" + stringeVeri.getVeri());

          //Derleme hatasi ile kullanıci uyarlıyor
        // G04GenericSinif<String> stringVeri1 = new G04GenericSinif<>(34);

    }
}
