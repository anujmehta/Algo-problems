package crap;

/**
 * Created by an039me on 10/4/2016.
 */
public class Unico {
    public static void main(String[] args){
        String string = "Km số 10, Quốc lộ 5, Dương Xá, Gia Lâm, Hà Nội";
        String replaceAll = string.replaceAll("(Quốc lộ)\\s+(\\d+)", "QL$2");
        System.out.println(replaceAll);
    }
}
