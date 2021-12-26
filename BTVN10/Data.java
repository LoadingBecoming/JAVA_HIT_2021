package BT;

import java.io.*;
import java.util.*;
import java.nio.file.Paths;


public class Data {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private Scanner sc;

    public void OpenFileToWrite(String fileName){
        try{
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite(){
        try{
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName){
        try{
            sc = new Scanner(Paths.get(fileName));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead(){
        sc.close();
    }

    public void WirteAccountToFile(String fileName, Account acc){
        OpenFileToWrite(fileName);
        printWriter.println(acc.getId() + "|" + acc.getFullName() + "|" + acc.getUserName() + "|" + acc.getPassword() + "|" + acc.getEmail() + "|" + acc.getPhone() + "|" + acc.getCreateAt());
        CloseFileAfterWrite();
    }

    public Account CreateAccountFromData(String data){
        String[] a = data.split("\\|");
        Account acc = new Account(Long.parseLong(a[0]), a[1], a[2], a[3], a[4], a[5], a[6]);
        return acc;
    }

    public List<Account> ReadAccountFromFile(String filename){
        OpenFileToRead(filename);
        List<Account> list = new ArrayList<>();
        while(sc.hasNext()){
            String data = sc.nextLine();
            Account acc = CreateAccountFromData(data);
            list.add(acc);
        }
        CloseFileAfterRead();
        return list;
    }

    public void UpdateAccountFile(List<Account> list, String fileName){
        File file = new File(fileName);
        if(file.exists()){
            file.delete();
        }
        OpenFileToWrite(fileName);
        for(Account acc:list){
            printWriter.println(acc.getId() + "|" + acc.getFullName() + "|" + acc.getUserName() + "|" +
                    acc.getPassword() + "|" + acc.getEmail() + "|" + acc.getEmail() + "|" +
                    acc.getPhone() + "|" + acc.getCreateAt());
        }
        CloseFileAfterWrite();
    }
}
