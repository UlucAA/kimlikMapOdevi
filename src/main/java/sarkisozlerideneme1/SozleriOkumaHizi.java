package sarkisozlerideneme1;

import java.io.*;
import java.time.LocalTime;

public class SozleriOkumaHizi {
    public static void main(String[] args) throws IOException {
        readFileLineByLine();
        readFileCharBychar();

    }
    public static void readFileCharBychar() throws IOException {
        int nano1 = LocalTime.now().getNano();
                String path = "src/main/java/sarkisozlerideneme1/Noumena-SlainMemories";
        FileInputStream fis = new FileInputStream(path);

        int kontrol=0;
       // String metin = "";
        while((kontrol=fis.read()) != -1){
          // System.out.print((char)kontrol);//Sarki sozleri satir satir cikar
            //metin+=(char)kontrol;

        }
        long nano2 = LocalTime.now().getNano();
        long fark1 =((Math.abs(nano2 - nano1)));
        System.out.println("fark1 = " + fark1);

        System.out.println("========================");
       // System.out.println(metin);//aynisi cikiyor
    }
    public static void readFileLineByLine() throws IOException {
        long nano3 = LocalTime.now().getNano();
        //Bu method dosyayi alip yazdiracak o yuzden return type imiz void
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/sarkisozlerideneme1/Noumena-SlainMemories"));
        String line = br.readLine();
        while(line!=null){
            //data olmayinca null oluyor
           // System.out.println(line);
            line = br.readLine();
        }
//        try {
//
//            //eger character character okumak sart degilse
//            //S:  text file'yi okuyan kodu yaziniz derlerse karakter olarak mi yoksa satir satir mi okutayim diye sorun ve %90 satir satir okutun derler.
//            //
//            //C: BufferedReader ile satir satir okutabilirsiniz.
//
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Ya path yanlis ya da dosya silinmis -"+ e.getMessage());
//        } catch (IOException e) {
//            System.out.println("Okunamayacak character veya characterler var -" + e.getMessage());
//        }
        //BufferedReader bir constructor, FileReader objesi ile calisiyor
        long nano4 = LocalTime.now().getNano();
        long fark2 =((Math.abs(nano3 - nano4)));
        System.out.println("fark2 = " + fark2);

    }
}
