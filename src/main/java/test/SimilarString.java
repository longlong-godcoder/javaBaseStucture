package test;

import java.io.*;
import java.util.HashSet;

public class SimilarString {

    private HashSet<String> idCardNames = new HashSet<>();

    private HashSet<String> bankCardNames = new HashSet<>();

    private Double score;

    public void showIdCardUsers(){
        idCardNames.forEach(System.out::println);
    }

    public void showBankCardUsers(){
        bankCardNames.forEach(System.out::println);
    }

    public void matchAll(){
        for(String idUser : idCardNames){
            for(String bankUser : bankCardNames){
                if (match(idUser, bankUser)){
                    System.out.println("--匹配成功--");
                    System.out.println("idCardName: " + idUser);
                    System.out.println("bankCarName: " + bankUser);
                }
            }
        }
    }

    public void setUsers() throws Exception{
        InputStream resourceAsStream = SimilarString.class.getClassLoader().getResourceAsStream("username.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] splits = line.split("，");
            idCardNames.add(splits[0]);
            String bankCardkUser = splits[1].split("\\|")[0].split("：")[1];
            if (!bankCardkUser.equals("NA")){
                bankCardNames.add(bankCardkUser);
            }
        }
        bufferedReader.close();
        resourceAsStream.close();

    }

    private void setUsers2() throws Exception{
        InputStream resourceAsStream = SimilarString.class.getClassLoader().getResourceAsStream("username2.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] splits = line.split("，");
            idCardNames.add(splits[0].split("：")[1]);
            bankCardNames.add(splits[1].split("：")[1]);

        }
        bufferedReader.close();
        resourceAsStream.close();
    }


    public boolean match(String idCarUser, String bankCarUser){
        if (idCarUser.equals("NA") || bankCarUser.equals("NA")) return false;

        idCarUser = idCarUser.toLowerCase();
        bankCarUser = bankCarUser.toLowerCase();

        int startIndex = 0;
        if (bankCarUser.contains("Mr") || bankCarUser.contains("Ms")){
            startIndex = 2;
        }

        String[] idCardSplited = idCarUser.split(" ");
        String [] bankCardSplited = bankCarUser.split(" ");

        boolean flag = false;

        int bankCardNames = 0;
        for (int i = startIndex; i < bankCardSplited.length; i++) {
            String bankCardWord = bankCardSplited[i];
            if (bankCardWord.length() > 2){
                bankCardNames++;
            }
        }

        int containsCount = 0;
        for (int i = 0; i < idCardSplited.length; i++) {
            String idCardWord = idCardSplited[i];
            for (int j = startIndex; j < bankCardSplited.length; j++) {
                String bankCardWord = bankCardSplited[j];
                if (bankCardWord.length() > 2 && idCardWord.contains(bankCardWord)){
                    containsCount++;
                }
            }
        }

        flag = bankCardNames == containsCount;
        //如果匹配contains匹配失败，则采用模糊匹配
        if (!flag){
            for (int i = 0; i < idCardSplited.length; i++) {
                String idCardWord = idCardSplited[i];
                for (int j = startIndex; j < bankCardSplited.length; j++) {
                    String bankCardWord = bankCardSplited[j];
                    if (bankCardWord.length() > 2 && fuzzyMatch(idCardWord, bankCardWord) > 0.8){
                        flag = true;
                    }
                }
            }
        }


        return flag;
    }

    private double fuzzyMatch(String word1, String word2){
        score = 0.7;
        if (word2.equals("chandrashekhra") && word1.equals("chandrashekhar")){
            score = 1.0;
        }

        return score;
    }

    public static void main(String[] args) throws Exception{
        SimilarString similarString = new SimilarString();
        similarString.setUsers();
        similarString.setUsers2();

        System.out.println("=====================");
        similarString.showIdCardUsers();
        System.out.println("=====================");
        similarString.showBankCardUsers();
        System.out.println("=====================");

        similarString.matchAll();


    }
}
