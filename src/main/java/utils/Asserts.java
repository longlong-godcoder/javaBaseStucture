package utils;

public class Asserts {

    public static void test(boolean value){
        if (!value) try {
            throw new Exception("test failed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
