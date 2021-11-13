package B1;

import java.util.ArrayList;
import java.util.Scanner;
public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("So luong dieu hoa: ");
        n = sc.nextInt();
        ArrayList<DieuHoa> DH = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Nhap dieu hoa thu " + (i+1) + ": ");
            DieuHoa D = new DieuHoa();
            D.nhap();
            DH.add(D);
        }
        System.out.println();
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n","Ma SP", "Ten SP", "Hang SX", "Ngay nhap", "Cong suat", "Gia tien");
        for(DieuHoa D: DH){
           D.xuat();
        }

        System.out.println();
        System.out.println("Danh sách các điều hòa có hãng sản xuất Electrolux: ");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n","Ma SP", "Ten SP", "Hang SX", "Ngay nhap", "Cong suat", "Gia tien");

        int indexmin;
        DieuHoa H = new DieuHoa();
        for(int i=0;i<n;i++){
            if(DH.get(i).getTenHangSX().equals("Electrolux")){
                DH.get(i).xuat();
            }
            if(i != n-1){
                if(DH.get(i).getGiaBan() < DH.get(i+1).getGiaBan()){
                    indexmin = i;
                }
                else{
                    indexmin = i+1;
                }
                H = DH.get(indexmin);
            }
        }

        System.out.println();
        System.out.println(" Các sản phẩm có giá bán thấp nhất: ");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n","Ma SP", "Ten SP", "Hang SX", "Ngay nhap", "Cong suat", "Gia tien");

        for(DieuHoa D:DH){
            if(D.getGiaBan() == H.getGiaBan()){
                D.xuat();
            }
        }
    }
}
