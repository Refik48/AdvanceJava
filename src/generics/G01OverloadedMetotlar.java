package generics;

import java.util.Arrays;

public class G01OverloadedMetotlar {

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
        System.out.println("===========================================================");
        System.out.println("Integer Dizi:");
        diziYazdırObject(integerDizi);
        System.out.println("Double Dizi:");
        diziYazdırObject(doubleDizi);
        System.out.println("Karakter Dizisi:");
        diziYazdırObject(charDizi);

    }
    public static void diziYazdır(Integer [] dizi){
       Arrays.stream(dizi).forEach(System.out::println);
    }

    public static void diziYazdır(Double [] dizi){
        Arrays.stream(dizi).forEach(System.out::println);
    }

    public static void diziYazdır(Character [] dizi){
        Arrays.stream(dizi).forEach(System.out::println);
    }


    //SuperClass(Object) ile DiziYazdir

    public static void diziYazdırObject(Object [] dizi){
        Arrays.stream(dizi).forEach(System.out::println);
    }

}
