package kimlikprojesitekrar1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KimlikPojo {
//     1) Kullanicidan kimlik numarasini(4 haneli), tam ismini, adresini, telefonunu, alin
//
//  2) Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin
    public String tamIsim;
    public String adres;
    public String telNo;
    private String kmlkNo;
    static Scanner scan = new Scanner(System.in);
    static Map<String,KimlikPojo> myMap = new HashMap<>();

    public KimlikPojo(String kmlkNo,String tamIsim, String adres, String telNo) {
        this.kmlkNo=kmlkNo;
        this.tamIsim = tamIsim;
        this.adres = adres;
        this.telNo = telNo;
    }

    public String getKmlkNo() {
        return kmlkNo;
    }

    public void setKmlkNo(String kmlkNo) {
        this.kmlkNo = kmlkNo;
    }

    @Override
    public String toString() {
        return "\t {" +
                " tamIsim='" + tamIsim + '\'' +
                ", adres='" + adres + '\'' +
                ", telNo='" + telNo + '\'' +
                ", kmlkNo='" + kmlkNo + '\'' +
                '}';
    }
}
