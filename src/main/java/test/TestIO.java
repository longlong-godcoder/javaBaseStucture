package test;

import java.io.*;

public class TestIO {

    public static InputStream createInputStream(){
        return  TestIO.class.getClassLoader().getResourceAsStream("/username.txt");

    }

    public static BufferedReader createBufferedReader(InputStream inputStream){
        return new BufferedReader(new InputStreamReader(inputStream));
    }



    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = TestIO.class.getClassLoader().getResourceAsStream("test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

    }
}
