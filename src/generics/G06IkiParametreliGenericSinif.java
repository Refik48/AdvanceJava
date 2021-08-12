package generics;

public class G06IkiParametreliGenericSinif {
    public static void main(String[] args) {
        Kisi<Integer, String> k1 = new Kisi<>(101,"Ahmet Yilmaz");
        Kisi<Long, String> k2 = new Kisi<>(102L,"Mustafa Can");

        // Compile-time hatasi
//        Kisi<Boolean, String> k3 = new Kisi<>(true, "Hakki Can");

        // Erişim
        System.out.println(k1.getKey());
        System.out.println(k2.getValue());
    }
}

// K: Key
// V: Value
// 2 parametreli Generic class oluşuturulmasi
// Parametreler istenilirse kisitlanabilir. Bunun için ilgili veri tipinden extends edileblir.
// Bu işleme parameter bounding denilmektedir.
// Bu durumda yanlış veri tipi girildiginde compile-time hatasi alinir.
class Kisi<K extends Number,V extends String> {
    //class Kisi<K ,V > {
    private K key;
    private V value;

    public Kisi(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}