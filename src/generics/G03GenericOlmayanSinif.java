package generics;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;

public class G03GenericOlmayanSinif {
    public static void main(String[] args) {
        // Java5 den öncesi (raw listeler ile) farklı veri tipleri ile çalışılabilir.
        // Ancak List içerisindeki veri tiplerini alırken Cast işlemine çok dikkat etmek gerekir.
        // Yoksa Runtime hatası alınır.

        List liste = new ArrayList();
        liste.add("TECHPROED");
        liste.add(2021);

        String techpro = (String) liste.get(0);  // Object class'ından String'e casting yaptık.
        Integer yil = (Integer) liste.get(1);   // Object class'ından Integer'e casting yaptık.
        System.out.println(techpro + " " + yil);
        liste.add(5.5);
        // Derleme hatasi almazsiniz ancak bu kod ClassCastException firlatir.
        //   System.out.println( (Integer) liste.get(2));


        // Object Super Class kullanımı
        List <Object> nesneListesi = new ArrayList<>();
        nesneListesi.add("GENERIC");
        nesneListesi.add(2021);
        String generic = (String) nesneListesi.get(0);  // Object class'ından String'e casting yaptık.
        Integer tarih = (Integer) nesneListesi.get(1);   // Object class'ından Integer'e casting yaptık.

        for(Object each: nesneListesi ){
            String yazi = (String) each;        // Derleme hatasi almazsiniz ancak bu kod ClassCastException firlatir.
            System.out.println(yazi);
        }




    }
}
