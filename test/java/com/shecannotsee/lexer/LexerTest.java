package test.java.com.shecannotsee.lexer;

import test.Color;
import src.main.java.com.shecannotsee.common.ReadFromFile;
import src.main.java.com.shecannotsee.lexer.Token;

import java.util.ArrayList;

public class LexerTest {
    public static void main(String[] argv) {
        if (Test.t1()) {
            System.out.println(Color.GREEN + "\nLexer Test.t1() pass\n"    + Color.RESET);
        } else {
            System.out.println(Color.RED   + "\nLexer Test.t1() failed\n"  + Color.RESET);
        }
    }
}

class Test {
    public static boolean t1() {
        String filePath = "resource/main.she";
        String charStream = ReadFromFile.pathName(filePath);
        if (charStream == null) {
            System.out.println(Color.RED + filePath + "error" +Color.RESET);
            return false;
        }
        ArrayList<Token> ret = Token.generate(charStream);
        for (Token token : ret) {
            System.out.print("type:" + token.getType());
            System.out.print(", value:" + token.getValue() + "\n");
        }

        return true;
    }
}
