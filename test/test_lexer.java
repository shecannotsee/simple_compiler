package test;
import test.easy_to_test.ReadStringFile;

public class test_lexer {
    public static void main(String[] args) {
        if ( test_lexer._1() ) {
            System.out.println("test_lexer._1() pass\n");}
        else {
            System.out.println("test_lexer._1() failed\n");
        }

    }

    public static boolean _1() {
        String __ = ReadStringFile.readStringFromFile("./test/test_lexer._1.txt");
        for (char ___ : __.toCharArray()) {
            if (___ == '\n') {
                System.out.print("[LF]\n");
            } else {
                System.out.print(___);
            }
        }
        return true;
    }
}
