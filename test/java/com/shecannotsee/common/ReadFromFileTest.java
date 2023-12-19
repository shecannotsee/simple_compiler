package test.java.com.shecannotsee.common;

import src.main.java.com.shecannotsee.common.ReadFromFile;

public class ReadFromFileTest {
    public static void main(String[] arg) {
        if (Test.t1()) {
            System.out.println("\ntest_lexer._1() pass\n");
        } else {
            System.out.println("\ntest_lexer._1() failed\n");
        }
    }
}

class Test {
    public static boolean t1() {
        String __ = ReadFromFile.pathName("resource/test_lexer._1.txt");
        if (__ != null) {
            for (char ___ : __.toCharArray()) {
                if (___ == '\n') {
                    System.out.print("[LF]\n");
                } else {
                    System.out.print(___);
                }
            }
        }
        return true;
    }
}

