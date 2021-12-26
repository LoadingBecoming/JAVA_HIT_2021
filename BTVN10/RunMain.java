package BT;

import java.util.*;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;


public class RunMain {
    static Scanner sc = new Scanner(System.in);
    static Map<Long, Integer> mapId = new HashMap<>();
    static Map<String, Integer> mapUsername = new HashMap<>();
    static List<Account> list = new ArrayList<>();
    static Account acc = new Account();
    static Data data = new Data();

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date;
    static Pattern pattern;

    static final String REGEX_USERNAME = "^[a-zA-Z0-9]{6,}$";
    static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";
    static final String REGEX_EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    static final String REGEX_PHONE = "^[0-9\\-\\+]{9,15}$";
    static final String ACCOUNT_FILE = "ACC.DAT";

    public static void main(String[] args) {
        while (true){
            System.out.println("1.Create new account.");
            System.out.println("2.Login to an existing account.");
            System.out.println("3.Sort accounts by username.");
            System.out.println("4.Exit.");
            System.out.print("Chon chuc nang: ");
            int x = sc.nextInt();
            switch (x){
                case 1:
                    CreatNewAccount();
                    System.out.println();
                    break;
                case 2:
                    Login();
                    System.out.println();
                    break;
                case 3:
                    SortAccoutByUsername();
                    System.out.println();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void CreatNewAccount(){

        while(true){
            System.out.print("Nhap id: ");
            acc.setId(sc.nextLong());
            if(mapId.containsKey(acc.getId())){
                System.out.println("Id da co xin vui long nhap lai!");
            }
            else{
                System.out.println("Id oke!");
                mapId.put(acc.getId(), 1);
                break;
            }
        }

        sc.nextLine();
        System.out.print("Nhap fullName: ");
        acc.setFullName(sc.nextLine());

        while (true){
            System.out.println("*Username: chứa các ký tự thường, hoa, số, ít nhất 6 ký tự.");
            System.out.print("Nhap userName: ");
            acc.setUserName(sc.nextLine());
            pattern = Pattern.compile(REGEX_USERNAME);
            boolean isUsername = pattern.matcher(acc.getUserName()).find();
            if(!isUsername || mapUsername.containsKey(acc.getUserName())){
                System.out.println("Username khong hop le hoac la da co! Nhap lai!");
            }
            else{
                System.out.println("Username hop le!");
                mapUsername.put(acc.getUserName(), 1);
                break;
            }
        }

        while(true){
            System.out.println("Password: tối thiểu 8 ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một số và một ký tự đặc biệt.");
            System.out.print("nhap Password: ");
            acc.setPassword(sc.nextLine());
            pattern = Pattern.compile(REGEX_PASSWORD);
            boolean isPass = pattern.matcher(acc.getPassword()).find();
            if(!isPass){
                System.out.println("Pass khong hop le, nhap lai!");
            }
            else{
                while (true){
                    System.out.print("Xac nhan lai pass: ");
                    String rePassword = sc.nextLine();
                    if (acc.getPassword().equals(rePassword)) {
                        System.out.println("Mat khau khop!");
                        break;
                    } else {
                        System.out.println("Nhap lai pass!");
                    }
                }
                break;
            }
        }

        while(true){
            System.out.print("Enter Email: ");
            acc.setEmail(sc.nextLine());
            pattern = Pattern.compile(REGEX_EMAIL);
            boolean isEmail = pattern.matcher(acc.getEmail()).find();
            if (!isEmail){
                System.out.println("Email khong hop le!");
            } else {
                System.out.println("Email hop le!");
                break;
            }
        }

        while (true){
            System.out.print("Enter phone: ");
            acc.setPhone(sc.nextLine());
            pattern = Pattern.compile(REGEX_PHONE);
            boolean isPhone = pattern.matcher(acc.getPhone()).find();
            if (!isPhone){
                System.out.println("Phone khong hop le!");
            } else {
                System.out.println("Phone hop le!");
                break;
            }
        }

        date = new Date();
        acc.setCreateAt(simpleDateFormat.format(date));
        data.WirteAccountToFile(ACCOUNT_FILE, acc);
    }

    public static void Login(){
        list = data.ReadAccountFromFile(ACCOUNT_FILE);
        sc.nextLine();
        String tk, mk;
        while(true){
            System.out.print("Nhap tai khoan: ");
            tk = sc.nextLine();
            System.out.print("Nhap mat khau: ");
            mk = sc.nextLine();
            if(CheckLogin(tk, mk))
                break;
            else{
                System.out.println("Tai khoan hoac mat khau cua ban khong dung!");
            }
        }

        while (true){
            System.out.println("5.Show info");
            System.out.println("6.Change password");
            System.out.println("7.Exit");
            System.out.print("Nhap lua chon: ");
            int y = sc.nextInt();
            switch (y){
                case 5:
                    Showinfo(tk);
                    System.out.println();
                    break;
                case 6:
                    ChangePass(tk);
                    System.out.println();
                    break;
                case 7:
                    return;
            }
        }
    }

    public static boolean CheckLogin(String tk, String mk){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUserName().equals(tk) && list.get(i).getPassword().equals(mk)) {
                return true;
            }
        }
        return false;
    }

    public static void Showinfo(String tk){
        System.out.println("Thong tin tai khoan: ");
        for(int i=0;i< list.size();i++){
            if(list.get(i).getUserName().equals(tk)){
                System.out.println(list.get(i));
            }
        }
    }

    public static void ChangePass(String tk){
        sc.nextLine();
        String newPass;
        while (true){
            System.out.println("Password: tối thiểu 8 ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một số và một ký tự đặc biệt.");
            System.out.print("Nhap new Password: ");
            newPass = sc.nextLine();
            pattern = Pattern.compile(REGEX_PASSWORD);
            boolean isPass = pattern.matcher(newPass).find();
            if(!isPass){
                System.out.println("Pass khong hop le, nhap lai!");
            }
            else{
                while (true){
                    System.out.print("Xac nhan lai pass: ");
                    String reNewPassword = sc.nextLine();
                    if (newPass.equals(reNewPassword)) {
                        System.out.println("Mat khau khop!");
                        break;
                    } else {
                        System.out.println("Nhap lai pass!");
                    }
                }
                break;
            }
        }

        for(int i=0;i< list.size();i++){
            if(list.get(i).getUserName().equals(tk)){                             //Tim account co tai khoan giong tk
                list.get(i).setPassword(newPass);                                       // Cap nhat lai mk cho account
                list.set(i, list.get(i));                                           // Cap nhat lai cho list
            }
        }
        data.UpdateAccountFile(list,ACCOUNT_FILE);                                  //Cap nhat lai file
    }

    public static void SortAccoutByUsername(){
        list = data.ReadAccountFromFile(ACCOUNT_FILE);
        Collections.sort(list, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getUserName().compareTo(o2.getUserName());
            }
        });

        data.UpdateAccountFile(list, ACCOUNT_FILE);
        for(Account acc:list)
            System.out.println(acc);
    }
}
