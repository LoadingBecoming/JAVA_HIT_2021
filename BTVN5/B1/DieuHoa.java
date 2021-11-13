package B1;

import java.util.Scanner;
public class DieuHoa extends SanPham{
    private Scanner sc = new Scanner(System.in);
    private float congSuat, giaBan;


    public void nhap(){
        super.nhap();
        System.out.print("Cong suat: ");
        congSuat = sc.nextFloat();
        System.out.print("Gia tien: ");
        giaBan = sc.nextFloat();
    }

    public void xuat(){
        super.xuat();
        System.out.printf("%-17.2f %-17.2f\n", congSuat, giaBan);
    }

    public float getGiaBan() {
        return giaBan;
    }
}
