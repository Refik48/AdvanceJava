package generics;

// Generic olmayan Ana class
public class G05GenericSiniflar {
    public static void main(String[] args) {
        VeriSakla<String> veri1 = new VeriSakla<>("Merhaba Generic");
        VeriSakla<Integer> veri2 = new VeriSakla<>(123);
        VeriSakla<Double> veri3 = new VeriSakla<>(3.14);

        //Doğrudan getter ile verilerin okunarak print ile yazdirilmasi
        System.out.println(veri1.getVeri());
        System.out.println(veri2.getVeri());
        System.out.println(veri3.getVeri());

        //VeriYazdir class ile verilerin yazdirilmasi
        VeriYazdir.yazdir(veri1.getVeri());
        VeriYazdir.yazdir(veri2.getVeri());
        VeriYazdir.yazdir(veri3.getVeri());
    }
}
// Generic Class
class VeriSakla<T> {
    private T veri;
    public VeriSakla(T veri) {
        this.veri = veri;
    }
    public T getVeri() {
        return veri;
    }
    public void setVeri(T veri) {
        this.veri = veri;
    }
}

//Generic olmayan bir class
class VeriYazdir {
    // Generic metot tanımlanmasi
    public static <T> void yazdir (T veri){
        System.out.println("Veri:" + veri);
    }
}