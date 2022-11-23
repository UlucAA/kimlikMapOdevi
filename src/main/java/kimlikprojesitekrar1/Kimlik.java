package kimlikprojesitekrar1;

import java.util.*;

public class Kimlik  {
    public static final String siyah = "\u001B[30m";
    public static final String kirmizi = "\u001B[31m";
    public static final String yesil = "\u001B[32m";
    public static final String sari = "\u001B[33m";
    public static final String mavi = "\u001B[34m";
    public static final String mor = "\u001B[35m";
    public static final String acikMavi = "\u001B[36m";

    public static final String gri = "\u001B[37m";
    public static final String beyaz = "\u001B[38m";
    public static final String fullKoyuSiyahSatirCizgi = "\u001B[40m";
    public static final String fullKoyuKirmiziSatirCizgi = "\u001B[41m";
    public static final String fullKoyuYesilSatirCizgi1 = "\u001B[42m";
    public static final String fullKoyuSariSatirCizgi2 = "\u001B[43m";
    public static final String fullKoyuMaviSatirCizgi3 = "\u001B[44m";

static Scanner scan = new Scanner(System.in);
static Map<String,KimlikPojo> myMap = new HashMap<>();
    static Set<String> mySet = myMap.keySet();

    //    +++ saveInfo() method olusturun:
//            3)Kullanicidan bircok kimlik numarasi(4 haneli), isim, adres ve telefon alin.
//            4)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin.
//            5)Ayni kimlik numarasi ile bilgi girilmesine engel olun.
    public static void saveInfo() throws InterruptedException {
        System.out.println(mavi + "Kayit icin bir kimlik numarasi giriniz");
        String kmlkNo = scan.nextLine();
        if (kmlkNo.matches("[0-9]{4}")) {
            boolean durum = true;
            while (durum) {
                if (!mySet.contains(kmlkNo)) {
                    System.out.println(mavi + "Ismini giriniz");
                    String isim = scan.nextLine();
                    System.out.println(sari + "Adresini giriniz");
                    String adres = scan.nextLine();
                    System.out.println(kirmizi + "TelNo giriniz");
                    String telNo = scan.nextLine();
                    KimlikPojo obj = new KimlikPojo(kmlkNo, isim, adres, telNo);
                    myMap.put(kmlkNo, obj);
                    durum = false;
                    System.out.println(mavi + "Baska bir kimlik no eklemek icin 1'i\n" + "Ana menuye donmek icin 2'ye basiniz");
                    String sec = scan.nextLine();
                    if (sec.equals("1")) {
                        saveInfo();
                    } else if (sec.equals("2")) {
                        secenekler();
                    } else {
                        System.out.println(mavi + "Yanlis giris yaptiniz Lutfen Baska bir kimlik no eklemek icin 1'i\n" + "Ana menuye donmek icin 2'ye basiniz");
//                        scan.nextLine();
//                        saveInfo();
                        saveInfoElse();
                    }
                } else {
                    System.out.println(mavi + "Girilen kimlik zaten kayitlidir " +
                            " lutfen tekrardan baska bir kimlik no giriniz\n" +
                            " Tekrar girmek icin 1'i\n" + "Ana menuye donmek icin 2'ye basiniz");
                    durum = false;
                    saveInfoElse();
//                    String sec = scan.nextLine();
//                    if (sec.equals("1")) {
//                        saveInfo();
//                    } else if (sec.equals("2")) {
//                        secenekler();
//                    } else {
//                        System.out.println(mavi + "Yanlis giris yaptiniz tekrar giris yapiniz");
//                        scan.nextLine();
//                        saveInfo();
//                    }
                }

            }
        } else {
            System.out.println(mavi + " Lutfen Dort haneli  bir kimlik no giriniz");
            saveInfo();
        }
    }
        public static void saveInfoElse() throws InterruptedException {
            String sec= scan.nextLine();
            if (sec.equals("1")){
                saveInfo();
            }else if (sec.equals("2")){
                secenekler();
            }else {
                System.out.println(mavi+"Yanlis giris yaptiniz lutfen tekrardan baska bir kimlik no giriniz\n" +
                                "Tekrar girmek icin 1'i\n" + "Ana menuye donmek icin 2'ye basiniz");
                //scan.nextLine();
                saveInfoElse();
            }
        }



    // +++ getInfo() method olusturun:
    //            1)Kimlik numarasini girerek kullanicinin bilgilerine ulasin.
    //            2)Olmayan kimlik numarasi girilirse kullaniciya hata mesaji verin.
    private static void getInfo() throws InterruptedException {
        System.out.println(yesil+"Kullanici Listesi");
        Set<Map.Entry<String, KimlikPojo>> myEntryset=myMap.entrySet();
        //myEntryset.forEach(System.out::println);
        myMap.keySet().forEach(System.out::println);
        if(mySet.isEmpty()){
            System.out.println(sari+"Silmek istediginiz List bostur,\n" +
                    " Kullanici Listesini gorebilmek icin once bir kimlik eklemeniz gerekir ");
            saveInfo(); }
        System.out.println(yesil+"kullaniciya ait kimlik Bilgilerini almak icin kimlikNo giriniz");
        String kmlkNo=scan.nextLine();

            boolean durum=true;
            while(durum){
                if (mySet.contains(kmlkNo)) {
                    System.out.println(yesil+"Girdiginiz kimlik no ya ait bilgiler" + myMap.get(kmlkNo));
                    durum=false;
                    System.out.println(yesil+"Baska bir kimlik no bakmak icin 1'i\n"+"Ana menuye donmek icin 2'ye basiniz");
                    getInfoElse();
//                    String sec= scan.nextLine();
//                    if (sec.equals("1")){
//                        getInfo();
//                    }else if (sec.equals("2")){
//                        secenekler();
//                    }else {
//                        System.out.println(yesil+"Yanlis giris yaptiniz tekrar giris yapiniz");
//                        scan.nextLine();
//                    }
                }else{
                    System.out.println(yesil+" lutfen listede olan bir kimlik no giriniz");
                    durum=false;
                    getInfo();

                }
            }


    }
    public static void getInfoElse() throws InterruptedException {

        String sec= scan.nextLine();
        if (sec.equals("1")){
            getInfo();
        }else if (sec.equals("2")){
            secenekler();
        }else {
            System.out.println(yesil+"Yanlis giris yaptiniz tekrar giris yapiniz\n"+
                             "Baska bir kimlik no bakmak icin 1'i\n"
                            +"Ana menuye donmek icin 2'ye basiniz");
            //scan.nextLine();
            getInfoElse();
        }
    }
//removeInfo() method olusturun:
//            1)Kimlik numarasini girerek data silin.
//                     2)Girilen kimlik numarasi yoksa kullaniciya hata mesaji verin.
//            3)Collection bos ise kullaniciya hata mesaji verin.

    private static void removeInfo() throws InterruptedException {
        System.out.println(sari+"Kullanici Listesi");
        Set<Map.Entry<String, KimlikPojo>> myEntryset=myMap.entrySet();
        //myEntryset.forEach(System.out::println);
        myMap.keySet().forEach(System.out::println);
        if(mySet.isEmpty()){
            System.out.println(sari+"Silmek istediginiz List bostur,\n" +
                    "Silme islemi yapabilmek icin Kimlik Listenize once bir kimlik eklemeniz gerekir ");
            saveInfo(); }
        System.out.println(sari+"Silmek istediginiz kullaniciya ait kimlikNo giriniz");
            String kmlkNo=scan.nextLine();
        if (myMap.containsKey(kmlkNo)){
            myMap.remove(kmlkNo);
            System.out.println(kirmizi+"Girdiginiz kullaniciya ait veriler basariyla silinmistir\n"+
                    "Silme islemi yapildiktan sonra olusan Liste ");
            myEntryset.forEach(System.out::println);
            System.out.println(sari+"Baska bir kimlik no silmek icin 1'i\n"+"Ana menuye donmek icin 2'ye basiniz");
            removeInfoElse();
 //           String sec= scan.nextLine();
//            if (sec.equals("1")){
//                removeInfo();
//            }else if (sec.equals("2")){
//                secenekler();
//            }else {
//                System.out.println(sari+"Yanlis giris yaptiniz tekrar giris yapiniz");
//                scan.nextLine();
//            }
        }else{
            System.out.println(sari+"Girilen "+kmlkNo+" Listede bulunmamaktadir");
            removeInfo();
        }



    }
    public static void removeInfoElse() throws InterruptedException {
        String sec= scan.nextLine();
        if (sec.equals("1")){
            removeInfo();
        }else if (sec.equals("2")){
            secenekler();
        }else {
            System.out.println(sari+"Yanlis giris yaptiniz tekrar giris yapiniz\n"+
                    "Baska bir kimlik no silmek icin 1'i\n"+
                     "Ana menuye donmek icin 2'ye basiniz");
            removeInfoElse();
        }
    }
    private static void cikis() throws InterruptedException {
        System.out.print(kirmizi+"Cikis isleminiz gerceklestirilmektedir  "+(char)9951);
        for (int i=0;i<6;i++){
                Thread.sleep(500);
        System.out.print(" "+(char)9951);
    }System.exit(0);}
    public static void secenekler() throws InterruptedException {
        boolean secim = true;
        do {
            System.out.println(fullKoyuSiyahSatirCizgi+mor+"Yapmak istediginiz islem icin bir secenek seciniz\n"+
                   mavi+ "kimlik eklemek icin 1\n"+
                    yesil+"kimlik listelemek icin 2\n"+
                    sari+ "kimlik silmek icin 3\n"+
                    kirmizi+"Cikis yapmak icin 4");
            String secenek= scan.nextLine();

            switch (secenek){
                case "1" :
                    saveInfo();
                    secim=false;
                    break;
                case "2" :
                    getInfo();
                    secim=false;
                    break;

                case "3" :
                    removeInfo();
                    secim=false;
                    break;

                case "4":
                    cikis();
                    secim=false;
                    break;
                default:
                    System.out.println(kirmizi+"Yanlis bir secenek girdiniz , Lutfen tekrar giris yapiniz");
                    //secim=false;
                    //scan.nextLine();
                    secenekler();
            }
        }while (secim);
}
}
