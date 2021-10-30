package B2;
import java.util.Scanner;
public class Runmain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        System.out.println("Nhap arr1: ");
        arr1.inputData();
        System.out.println("Nhap arr2: ");
        arr2.inputData();
        float TBC1 = (float)arr1.Sum()/arr1.getN();
        float TBC2 = (float)arr2.Sum()/arr2.getN();
        if(TBC1 > TBC2){
            System.out.println("TBC cua arr1 lon hon TBC cua arr2");
        }
        else if(TBC1 < TBC2){
            System.out.println("TBC cua arr2 lon hon TBC cua arr1");
        }
        else{
            System.out.println("Bye");
        }
    }
}
