package generics;

import java.util.Arrays;

public class G02GenericMetodlar {
    public static void main(String[] args) {
        Integer[] integerDizi = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleDizi = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] charDizi = { 'H', 'E', 'L', 'L', 'O' };
        System.out.println("Integer Dizi:");
        diziYazdır(integerDizi);
        System.out.println("Double Dizi:");
        diziYazdır(doubleDizi);
        System.out.println("Karakter Dizisi:");
        diziYazdır(charDizi);

        System.out.println("**********************");
        System.out.println("MAKS: " + maksBulKlasik(3,7,5));
        System.out.println("MAKS: " + maksBulKlasik(10,3,4));
        System.out.println("MAKS: " + maksBulKlasik(5,4,14));

        System.out.println("**********************");
        System.out.println("MAKS: " + maksBulGeneric(3,7,5));
        System.out.println("MAKS: " + maksBulGeneric(10.4,3.5,4.6));
        System.out.println("MAKS: " + maksBulGeneric("5","4","14"));
        System.out.println("MAKS: " + maksBulGeneric(1f,3.4f,4.6f));
    }

    // - Bir jenerik metot tanımlanırken metodun dönüş tipinin önüne < T > (angle brackets) konulur.
    // - T (Type) kullanılan parametrik veri tipini göstermektedir
    // - Ayrıca, parametre listesinde parametre tipleri kullanılır.
    // - Bu parametre listeleri bir veya daha fazla olabilir ve virgülle ayrılarak yazılırlar.
    // - Parametre tipleri non-primitif olmalıdır.
    // - Aslında derleyici, derleme aşamasında generic metotudu java byte kodlara çevirirken parametre tiplerini
    //   kaldırır ve yerine gerçek parametreleri koyar. Bu prosese erasure denilir.


    //Generic metot tanimlamasi
    public static <T> void diziYazdır( T[] dizi){
        Arrays.stream(dizi).forEach(System.out::println);
    }



    // Aşağıda, 3 adet int parametreniyi alan ve en büyüğünü bularak döndüren bir metot bulunmaktdır.
    // Bu metotu farklı veri tipleri ile çalışacak şekilde Generic olarak yazalım.
    public static int maksBulKlasik(int x, int y,int z) {
        int maks = x;
        if (y > maks){
            maks = y;
        }
        if(z > maks) {
            maks = z;
        }
        return maks;
    }

    // - Generic veri tipleri sadece non-primitif olabilir.
    // - Binary operatörler (+, -,*, / ,<, >) ise non-primitif veri tiplerinde kullanılamazlar.
    // - Dolayısıyla bir generic metotta karşılaştırma için ne kullanılabilir?
    // - CEVAP: Comparable interface'i kullanımı

    public static <T extends Comparable<T>> T maksBulGeneric(T x, T y, T z){
        T maks = x;
        if(y.compareTo(maks) > 0 ){
            maks = y;
        }
        if(z.compareTo(maks) > 0 ){
            maks = z;
        }
        return maks;
    }




}
