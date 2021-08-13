package multiThreading;

// =========================================   SYNHRONIZED  ==========================================================
// multi-threading çalışma koşullarında birden fazla thread'in aynı kaynağa (değişken metot, class, bellek vb)
// erişimi (okuma veya yazma) sırasında verinin güncellenmesi ve tutarlılığı ile ilgili sorunlar çıkabilir.
// Bu tutarsızlığı engellemek için synchronized keywordu (metot) kullanılabilir.
// synchronized keywordunun farklı kullanımları bulunmaktadır.
//  1- Eğer bir metot "synronized" yapılırsa bu metota aynı andan birden fazla thread'in erişimine izin verilmez.
//  2- Eğer bir metot yerine o metodun ait olduğu class'ı aynı anda birden fazla thread'in kullanımına kapatmak
//     istersek o zaman "synchronized static" kullanmalıyız.
//  3- Eğer bir metot içerisinde belirli bir kismin eş zamanlı thread kullanımına kapatılmasını ister isek o zaman
//     "synchronized block" kullanmalıyız.

public class MultiThreading02 {
    public static void main(String[] args) {

    }
}
