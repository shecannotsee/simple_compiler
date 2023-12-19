package test.java.com.shecannotsee.common;

import test.Color;
import src.main.java.com.shecannotsee.common.ReadFromFile;

public class ReadFromFileTest {
    public static void main(String[] arg) {
        if (Test.t1()) {
            System.out.println(Color.GREEN + "\ntest_lexer._1() pass\n" + Color.RESET);
        } else {
            System.out.println(Color.RED + "\ntest_lexer._1() failed\n" + Color.RESET);
        }
    }
}

class Test {
    public static boolean t1() {
        String filePath = "resource/main.she";
        String recvFromFile = ReadFromFile.pathName(filePath);
        if (recvFromFile != null) {
            for (char singleChar : recvFromFile.toCharArray()) {
                if (singleChar == '\n') {
                    System.out.print("[LF]\n");
                } else {
                    System.out.print(singleChar);
                }
            }
        }
        return true;
    }
}

