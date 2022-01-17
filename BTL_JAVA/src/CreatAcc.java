import java.util.Scanner;
import java.util.regex.Pattern;

public class CreatAcc  {

    static final String REGEX_USERNAME = "^[a-zA-Z0-9]{6,}$";
    static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
    static final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    static final String REGEX_PHONE = "^[0-9\\-\\+]{9,15}$";

    static Scanner sc = new Scanner(System.in);
    static Pattern pattern;

   public String creUser(){
       System.out.println("*Username: chứa các ký tự thường, hoa, số, ít nhất 6 ký tự.");
       while(true){
           System.out.print("Nhap userName: ");
           String userName =  sc.nextLine();
           pattern = Pattern.compile((REGEX_USERNAME));
           boolean isUsername = pattern.matcher(userName).find();
           if( !isUsername){
               System.out.println("Username khong hop le. Nhap lai!");
           }
           else{
               System.out.println("Username hop le!");
               return userName;
           }
       }
   }

   public String crePass(){
       System.out.println("Password: tối thiểu 8 ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một số và một ký tự đặc biệt.");
       while(true){
           System.out.print("nhap Password: ");
           String pass = sc.nextLine();
           pattern = Pattern.compile(REGEX_PASSWORD);
           boolean isPass = pattern.matcher(pass).find();
           if(!isPass){
               System.out.println("Pass khong hop le, nhap lai!");
           }
           else{
               while (true) {
                   System.out.print("Xac nhan lai pass: ");
                   String rePassword = sc.nextLine();
                   if (pass.equals(rePassword)) {
                       System.out.println("Mat khau khop!");
                       return pass;
                   } else {
                       System.out.println("Nhap lai pass!");
                   }
               }
           }
       }
   }

   public String creTen(){
       System.out.println("Nhập tên đầy đủ: ");
       String ten = sc.nextLine();
       return ten;
   }

   public String creDiaChi(){
       System.out.println("Nhập địa chỉ: ");
       String diaChi = sc.nextLine();
       return diaChi;
   }

   public String creGioiTinh(){
       System.out.println("Nhap giới tính: ");
       String gioiTinh = sc.nextLine();
       return gioiTinh;
   }

   public String crePhone(){
       while (true){
           System.out.print("Enter phone: ");
           String phone = sc.nextLine();
           pattern = Pattern.compile(REGEX_PHONE);
           boolean isPhone = pattern.matcher(phone).find();
           if (!isPhone){
               System.out.println("Phone khong hop le!");
           } else {
               System.out.println("Phone hop le!");
               return phone;
           }
       }
   }

   public String creEmail(){
       while(true){
           System.out.print("Enter Email: ");
           String email = sc.nextLine();
           pattern = Pattern.compile(REGEX_EMAIL);
           boolean isEmail = pattern.matcher(email).find();
           if (!isEmail){
               System.out.println("Email khong hop le!");
           } else {
               System.out.println("Email hop le!");
               return email;
           }
       }
   }
}
